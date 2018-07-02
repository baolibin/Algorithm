package libin.general.other.machine;
/**
 * 问题：初始聚类中心选择不好，初始聚类中心可能最后减少。
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * 2、KMeans：机器学习聚类算法
 * @author baolibin
 */
public class _02_kmeans {
	public static List<kmean> list=new ArrayList<kmean>(); //存所有的点对象
	public static int k; //聚类中心数
	public static List<kmean> center=new ArrayList<kmean>(); //存储聚类中心
	//main函数
	public static void main(String[] args) throws IOException {
		_02_kmeans _02_kmeans = new _02_kmeans();
		_02_kmeans.initialize("E:\\machinedata\\kMeans_demo\\testSet.txt"); //读取样本数据
		
		/**
		 * 输入聚类中心个数
		 */
		System.out.print("请输入聚类中心 K = ");
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		k=sc.nextInt();
		//进行测试，查看数据是否读取出来
//		for (kmean km : list) {
//			System.out.println(km.x+"、"+km.y);
//		}
		/**
		 * 初始化K个聚类中心，采用kmean++,避免陷入局部局部最优值，是初始化的聚类中心尽量分散开
		 */
		System.out.println("样本数据总个数为："+list.size());
		System.out.println("聚类中心个数为："+k);
		_02_kmeans.countCenter();
		System.out.println("初始化的k个聚类中心为：");
		for (kmean str : center) {
			System.out.println(str.x+"、"+str.y);
		}
		/**
		 * 计算聚类中心
		 */
		_02_kmeans.iteraCount(10); //最多迭代十次
	}
	/**
	 * 初始化读取样本点数据
	 * @param pathname 样本数据路径
	 * @throws IOException
	 */
	public void initialize(String pathname) throws IOException{
		File file = new File(pathname);
		BufferedReader reader=null;
		try {
			if (file.isFile()&&file.exists()) {
				reader = new BufferedReader(new FileReader(file));
				String tmpStr=null;
				//按行读取样本数据
				while ((tmpStr=reader.readLine())!=null) {
					String[] split=tmpStr.split("\t");
					if (split.length==2) {
						//进行切分，并对每行数据生成一个点对象
						kmean km = new kmean(Double.parseDouble(split[0].trim()), Double.parseDouble(split[1].trim()));
						list.add(km); //添加到对象集合中
					}
				}
				reader.close();
			}else{
				System.out.println("指定路径不是文件或路径不存在！");
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
	 * 初始化K个聚类中心
	 */
	public void countCenter(){
		Random random = new Random();
		kmean km=null;
		
		//随机选取第一个聚类中心
		int target=random.nextInt(list.size()); //随机数范围 0~size-1
		km=list.get(target);
		km.classify="A";
		center.add(km);
		
		for (int i = 0; i < k-1; i++) {//逐个求K个聚类中心
			double manhattan=0; //每次迭代最大曼哈顿距离
			double tmp=0; //每次迭代临时曼哈顿距离值
			km=null; //每次循环临时值对象
			kmean newkm=null; //存每次新迭代的距离中心
			//新聚类中心与已求的每个聚类中心曼哈顿距离最大，每次随机选取样本数的百分之50%个点进行比较选取曼哈顿距离最大的点作为新聚类中心。
			for (int j = 0; j < (list.size()/2); j++) { //循环50%样本点
				for (kmean kmeans : center) { //求与已有的聚类中心的曼哈度距离
					km=list.get(random.nextInt(list.size())); //随机值点对象
					tmp=(Math.abs(kmeans.x-km.x))+(Math.abs(kmeans.y-km.y)); //随机值点对象距离
					if(tmp>manhattan){
						newkm=km; //最大曼哈顿距离值对象
					}
				}
			}
			String temp2 = String.valueOf((char)(i+1+65)); //0-->A 根据数组转换成字母分类
			newkm.classify=temp2; //附上对应的分类
			center.add(newkm);
		}
	}
	/**
	 * 迭代至每个点所属分类不再改变,或达到最大迭代的次数
	 * @param maxNum 最大迭代次数
	 */
	public void iteraCount(int maxNum){
		System.out.println("计算之前的hashmap:");
		for (kmean kmean : center) {
			System.out.println(kmean.classify+"、"+kmean.x+"、"+kmean.y);
		}
		boolean flag=true;
		int count=0;
		while (flag&&maxNum>0) { //循环条件
			System.out.println("第"+(++count)+"次计算:");
			/**
			 * 1、求每个点所属的分类
			 */
			for(int i=0;i<list.size();i++){ //迭代每个点
				kmean km=null; //临时存每个点聚类中心
				double tmp=0; //临时存每个点欧氏距离
				double maxtmp=0; //临时存每个点最大欧氏距离
				for (kmean kn : center) { //求每个点的聚类中心，采用欧氏距离
					tmp=Math.sqrt(Math.pow((kn.x-list.get(i).x),2)+Math.pow((kn.y-list.get(i).y),2));
					if (maxtmp<tmp) {
						maxtmp=tmp;
						km=kn;
					}
				}
				list.get(i).center=km; //把当前点的聚类中心进行赋值
				list.get(i).classify=km.classify; //每个点元素赋值对应的分类
				list.get(i).distince=maxtmp;  //每个点离聚类中心的距离
			}
			
			/**
			 * 测试输出每个点所属的分类
			 */
			System.out.println("测试输出每个点所属的分类：");
//			for (kmean ks : list) {
//				System.out.println(ks.x+"、"+ks.y+"、"+ks.classify);
//			}
			
			/**
			 * 2.1、计算新聚类中心
			 * 汇总求总值 --》 旧分类所有点元素求和
			 */
			List<kmean> newcenter=new ArrayList<kmean>(); //存储新计算的聚类中心
			HashMap<String, Double[]> hMap=new HashMap<String, Double[]>();
			HashMap<String,Integer> hMap2=new HashMap<String,Integer>();
			for (kmean km : list) {
				Double[] doubles=new Double[2];
				//根据所属分类的节点的x和y计算新的中心
				if (!hMap.containsKey(km.classify)) {
					doubles[0]=km.x;
					doubles[1]=km.y;
					hMap.put(km.classify,doubles);
					hMap2.put(km.classify, 1);
				}else{
					doubles[0]=hMap.get(km.classify)[0];
					doubles[1]=hMap.get(km.classify)[1];
					doubles[0]+=km.x;
					doubles[1]+=km.y;
					hMap.put(km.classify,doubles);
					
					int countClassify=hMap2.get(km.classify);
					countClassify++;
					hMap2.put(km.classify, countClassify);
				}
			}
			
			/*
			 * 测试两个hashmap
			 */
//			System.out.println("测试两个hashmap:");
//			for (Map.Entry<String, Double[]> str : hMap.entrySet()) {
//				System.out.println(str.getKey()+"、"+str.getValue()[0]+"、"+str.getValue()[1]+"、"+hMap2.get(str.getKey()));
//			}
			
			DecimalFormat df = new DecimalFormat("######0.000000");    //double保留小数点后6位
			/**
			 * 2.2、计算新的聚类中心
			 * 求平均值  --》 即新聚类中心坐标
			 */
			for (Map.Entry<String, Double[]> cEntry : hMap.entrySet()) {
				//计算新的点的x和y的值     如：A类的x的总值  除以 A类点的个数  即为A类新中心的x值   || A类的y的总值  除以 A类点的个数  即为A类新中心的y值
				double x1=Double.parseDouble(df.format(cEntry.getValue()[0]/hMap2.get(cEntry.getKey())));
				double y1=Double.parseDouble(df.format(cEntry.getValue()[1]/hMap2.get(cEntry.getKey())));
				kmean kms = new kmean(x1,y1 );
				kms.classify=cEntry.getKey();
				//将新的点加入到中心集合中
				newcenter.add(kms);
			}
			
			System.out.println("新聚类中心：");
			for (kmean kmss : newcenter) {
				System.out.println(kmss.x+"、"+kmss.y);
			}
			
			/**
			 * 3、判断前后两次迭代聚类中心是否一样
			 */
			int countSame=0;
			for (kmean kmss1 : center) {
				for(kmean kmss2 : newcenter){
					if (kmss1.x==kmss2.x&&kmss1.y==kmss2.y) {
						countSame++;
						break;
					}
				}
			}
			//如果前后聚类中心都一样，那么停止循环
			if(countSame==center.size()){
				flag=false;
			}
			//否则，继续进行循环
			center=newcenter;  //新旧聚类中心不一样，新聚类中心替换掉旧聚类中心
			newcenter=null;
			
			maxNum--;
		}
		System.out.println("计算结束，共迭代"+count+"次!");
	}
}
/**
 * 一个元素对象
 * @author baolibin
 */
class kmean{
	public double x;
	public double y;
	public kmean center;
	public String classify;
	public double distince;
	public kmean(double x, double y) {
		this.x = x;
		this.y = y;
		this.center=null;
		this.classify = null;
		this.distince = 0;
	}
}
