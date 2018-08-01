package libin.general._10_machine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * 1、KNN：机器学习分类算法
 * 
 * @author baolibin
 * 
 * K近邻模型由三个基本要素组成： 1、距离度量 2、K值选择 3、分类决策规则
 */
public class _01_KNN {
	static List<KNN> list = new ArrayList<KNN>(); //存储所有的训练数据
	static HashMap<String, Integer> hashMap=new HashMap<String, Integer>(); //存储选中的K个训练数据
	int k=5; //假设K值等于5

	public static void main(String[] args) throws IOException {
		_01_KNN _01_KNN = new _01_KNN();
		_01_KNN.initialize("E:\\machinedata\\KNN\\datingTestSet.txt"); //读取训练数据
		
//		System.out.println("请输入K值大小：");
		System.out.println("K值大小：5");
//		System.out.println("请输入待分类的样本数据属性：");
		System.out.println("待分类的样本数据属性：(1.889456, 1.178983, \"0\")");
		KNN knn = new KNN(1.889456, 1.178983, "0"); //初始化待求点
		_01_KNN.countDistince(knn); //调用函数进行计算
		
		//输出排序后的距离
//		for (KNN knn2 : list) {
//			System.out.println(knn2.distince+"、"+knn2.classify);
//		}
		//统计每个分类的个数
		for (int i=0;i<5;i++) {
			String classifys =list.get(i).classify;
			if (hashMap.containsKey(classifys)) {
				int count=hashMap.get(classifys);
				count+=1;
				hashMap.put(classifys, count);
			}
		}
		System.out.println("\nK值内的指定分类     所属分类的个数");
		//计算最大分类
		int tmp=0;
		String fenlei="0";
		for (Entry<String, Integer> str : hashMap.entrySet()) {
			if(tmp<=str.getValue()){
				tmp=str.getValue();
				fenlei=str.getKey();
			}
			System.out.println(str.getKey()+"、"+str.getValue());
		}
		//输出所属分类
		System.out.println("该测试样例属于的分类是："+fenlei);
	}
	/**
	 * 构造方法
	 */
	public _01_KNN(){
		hashMap.put("1", 0);
		hashMap.put("2", 0);
		hashMap.put("3", 0);
	}
	/**
	 * 读取训练数据
	 * @param fileName 训练数据存放的路径
	 * 0表示分类位置
	 * 1、2、3表示对应的分类
	 * @throws IOException
	 */
	public void initialize(String fileName) throws IOException {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			if (file.isFile() && file.exists()) {
				reader = new BufferedReader(new FileReader(file));
				String tmpStr = null;
				//一行读取一个样本点
				while ((tmpStr = reader.readLine()) != null) {
					//对每行数据进行切分
					String[] split=tmpStr.split("\t");
					if (split.length==4) {
						//对于每行训练数据生成一个对象
						KNN knn = new KNN(Double.parseDouble(split[1]), Double.parseDouble(split[2]), split[3]);
//						System.out.println(split[1]+"、"+split[2]+"、"+split[3]);
						list.add(knn);
					}
				}
				reader.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if (reader!=null) {
				reader.close();
			}
		}
	}
	/**
	 * 求待求点离训练数据的距离
	 * 采用欧氏距离
	 * @param knn 待求点
	 */
	public void countDistince(KNN knn){
		DecimalFormat df = new DecimalFormat("######0.000000");    //double保留小数点后6位
		for (KNN tmpknn : list) {
			double dis=Math.sqrt(Math.pow((tmpknn.x-knn.x),2)+Math.pow((tmpknn.y-knn.y),2)); //计算欧氏距离
			if (dis>=0.0) {
//				tmpknn.distince=dis;
				tmpknn.distince=Double.parseDouble(df.format(dis)); //进行格式化，保留小数点后6位
			}
		}
		//对集合里面的元素按照距离远近进行升序排序
		Collections.sort(list, new Comparator<KNN>() {
			public int compare(KNN o1, KNN o2) {
				return new Double(o1.distince).compareTo(new Double(o2.distince));
			}
		});
	}
}
/**
 * 每个训练数据的实体类
 * @author baolibin
 */
class KNN {
	double x; // X坐标
	double y; // Y坐标
	double distince; // 距离中心点距离
	String classify; // 所属分类

	public KNN(double d, double e, String classify) {
		this.x = d;
		this.y = e;
		distince = 0;
		this.classify = classify;
	}
}
