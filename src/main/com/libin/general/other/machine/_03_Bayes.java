package libin.general.other.machine;
/**
 * 问题：求先验概率   词汇表不存在的单词概率为0，怎么处理
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 3、Bayes：机器学习算法
 * 
 * @author baolibin 朴素贝叶斯是分类算法、属于监督学习：
 *         路径下有25封正常邮件以及25封垃圾邮件，随机选取20封正常邮件以及20封垃圾邮件作为训练数据，剩下作为测试数据；
 *         E:\machinedata\bayes\email
 */
public class _03_Bayes {
	List<String> wordli = new ArrayList<String>(); // 存词汇表
	
	int[] wordVector1; //正常邮件的词向量
	int[] wordVector2; //垃圾邮件的词向量

	public static void main(String[] args) throws IOException {
		_03_Bayes _03_Bayes = new _03_Bayes();
		String pathHam = "E:\\machinedata\\bayes\\email\\ham"; // 正常邮件根路径
		String pathSpam = "E:\\machinedata\\bayes\\email\\spam"; // 垃圾邮件根路径
		_03_Bayes _03_Bayes2 = _03_Bayes;
		_03_Bayes2.wordList(pathHam, pathSpam); // 生成词汇表
		_03_Bayes2.wordVector(pathHam, pathSpam); //构建词向量
		
		/**
		 * 贝叶斯模型已生成，进行测试
		 * 测试数据：随机选取的测试数据
		 */
 		DecimalFormat df = new DecimalFormat("##0.00");    //double保留小数点后6位
 		String tmpPath1=null;
 		int accuracy=0;
 		for (int i = 1; i <=25; i++) {
 			tmpPath1="E:\\machinedata\\bayes\\email\\ham\\"+i+".txt";
 			String result=_03_Bayes2.classify(tmpPath1);
 			if ("正常邮件".equals(result)) {
 				accuracy++;
			}
		}
 		System.out.println("\n\n正常邮件判断正确率为："+(Double.parseDouble(df.format((double)accuracy/(double)25))));
 		
 		accuracy=0;
 		for (int i = 1; i <=25; i++) {
 			tmpPath1="E:\\machinedata\\bayes\\email\\spam\\"+i+".txt";
 			String result=_03_Bayes2.classify(tmpPath1);
 			if ("垃圾邮件".equals(result)) {
 				accuracy++;
			}
		}
 		System.out.println("垃圾邮件判断正确率为："+(Double.parseDouble(df.format((double)accuracy/(double)25))));
	}

	/**
	 * 判断一个字符串里是否包含字母
	 * 
	 * @param cardNum
	 * @return
	 */
	public boolean judgeContainsStr(String cardNum) {
		String regex = ".*[a-zA-Z]+.*";
		Matcher m = Pattern.compile(regex).matcher(cardNum);
		return m.matches();
	}

	/**
	 * 1、 将所有训练数据转换为词汇表
	 * 
	 * @param pathHam
	 *            正常邮件根路径
	 * @param pathSpam
	 *            垃圾邮件根路径
	 * @throws IOException
	 */
	public void wordList(String pathHam, String pathSpam) throws IOException {
		File file1 = new File(pathHam);
		File file2 = new File(pathSpam);
		String[] fileName1 = file1.list(); // 获取正常邮件目录下的所有文件
		String[] fileName2 = file2.list();
		String[] split = null;
		BufferedReader reader1 = null;
		BufferedReader reader2 = null;
		String tmpStrLine = null; // 存临时读取每一封邮件的每一行
		String tmpStr = null; // 存切分出来的单词字符串
		/**
		 * 读取训练数据邮件信息
		 */
		for (int i = 0; i < 20; i++) { // 读取20个正常邮件和垃圾邮件
			/**
			 * 读取正常邮件
			 */
			File tmpfile = new File((pathHam + "\\" + fileName1[i])); // 对每一封邮件内容进行切分
			reader1 = new BufferedReader(new FileReader(tmpfile));
			while ((tmpStrLine = reader1.readLine()) != null) { // 读取一封邮件的每一行
				split = tmpStrLine.split("\\s+"); // 进行切分
				if (split.length > 0) {
					for (String sp : split) { // 把切分的每一个单词去重加入词汇表
						tmpStr = sp.trim().toUpperCase(); // 全部转换为大写
						if (judgeContainsStr(tmpStr)) { // 如果这个单词里包含字母
							tmpStr=tmpStr.replaceAll("[^a-z^A-Z^0-9]", "");
							if (!wordli.contains(tmpStr)) { // 添加进词汇表里
								wordli.add(tmpStr); // 把字符串里非字母和数字都去掉
							}
						}
					}
				}
			}
			/**
			 * 读取垃圾邮件
			 */
			File tmpfile2 = new File((pathSpam + "\\" + fileName2[i])); // 对每一封邮件内容进行切分
			reader2 = new BufferedReader(new FileReader(tmpfile2));
			while ((tmpStrLine = reader2.readLine()) != null) { // 读取一封邮件的每一行
				split = tmpStrLine.split("\\s+"); // 进行切分
				if (split.length > 0) {
					for (String sp : split) { // 把切分的每一个单词去重加入词汇表
						tmpStr = sp.trim().toUpperCase(); // 全部转换为大写
						if (judgeContainsStr(tmpStr)) { // 如果这个单词里包含字母
							tmpStr=tmpStr.replaceAll("[^a-z^A-Z^0-9]", "");
							if (!wordli.contains(tmpStr)) { // 添加进词汇表里
								wordli.add(tmpStr); // 把字符串里非字母和数字都去掉
							}
						}
					}
				}
			}
		}
		reader1.close();
		reader2.close();
		/**
		 * 测试输出词汇表内容
		 */
		System.out.println("词汇表长度为：" + wordli.size());
		System.out.println("词汇表内容为：");
		int i=1;
		for (String spl : wordli) {
			if (i==10) {
				System.out.println();
				i=1;
			}
			System.out.print(spl + " ");
			i++;
		}
	}
	/**
	 * 2、构建词向量
	 * 词集模型：每个词的出现与否作为一个特征
	 * 词袋模型：每个词在文档中出现不止一次，要计算次数，不能计算是否出现
	 * @param pathHam
	 * @param pathSpam
	 * @throws IOException 
	 */
	public void wordVector(String pathHam, String pathSpam) throws IOException{
		wordVector1=new int[wordli.size()]; //正常邮件的词向量
		wordVector2=new int[wordli.size()]; //垃圾邮件的词向量
		
		File file1 = new File(pathHam);
		File file2 = new File(pathSpam);
		String[] fileName1 = file1.list(); // 获取正常邮件目录下的所有文件
		String[] fileName2 = file2.list();
		String[] split = null;
		BufferedReader reader1 = null;
		BufferedReader reader2 = null;
		String tmpStrLine = null; // 存临时读取每一封邮件的每一行
		String tmpStr = null; // 存切分出来的单词字符串
		/**
		 * 构建词向量
		 * 采用词袋模型
		 */
		for (int i = 0; i < 20; i++) { // 读取20个正常邮件和垃圾邮件
			/**
			 * 构建正常邮件的词向量
			 */
			File tmpfile = new File((pathHam + "\\" + fileName1[i])); // 对每一封邮件内容进行切分
			reader1 = new BufferedReader(new FileReader(tmpfile));
			while ((tmpStrLine = reader1.readLine()) != null) { // 读取一封邮件的每一行
				split = tmpStrLine.split("\\s+"); // 进行切分
				if (split.length > 0) {
					for (String sp : split) { // 切分的每一个单词
						tmpStr = sp.trim().toUpperCase(); // 全部转换为大写
						if (judgeContainsStr(tmpStr)) { // 如果这个单词里包含字母
							tmpStr=tmpStr.replaceAll("[^a-z^A-Z^0-9]", "");
							int tmpindex=wordli.indexOf(tmpStr);
							wordVector1[tmpindex]++; //对应的出现该元素次数加加
						}
					}
				}
			}
			/**
			 * 构建垃圾邮件的词向量
			 */
			File tmpfile2 = new File((pathSpam + "\\" + fileName2[i])); // 对每一封邮件内容进行切分
			reader2 = new BufferedReader(new FileReader(tmpfile2));
			while ((tmpStrLine = reader2.readLine()) != null) { // 读取一封邮件的每一行
				split = tmpStrLine.split("\\s+"); // 进行切分
				if (split.length > 0) {
					for (String sp : split) { // 把切分的每一个单词去重加入词汇表
						tmpStr = sp.trim().toUpperCase(); // 全部转换为大写
						if (judgeContainsStr(tmpStr)) { // 如果这个单词里包含字母
							tmpStr=tmpStr.replaceAll("[^a-z^A-Z^0-9]", "");
							int tmpindex=wordli.indexOf(tmpStr);
							wordVector2[tmpindex]++; //对应的出现该元素次数加加
						}
					}
				}
			}
		}
		reader1.close();
		reader2.close();
		/**
		 * 输出词向量
		 */
		System.out.println("\n正常邮件词向量为：");
		for (Integer in : wordVector1) {
			System.out.print(in+" ");
		}
		System.out.println("\n垃圾邮件词向量为：");
		for (Integer in : wordVector2) {
			System.out.print(in+" ");
		}
	}
	/**
	 * 对指定邮件进行分类：正常邮件还是垃圾邮件
	 * p(A|B)=P(B|A)*P(A)/P(B)
	 * 
	 * 本例子公式：
	 * P1：P(正常邮件|待求邮件)=P(待求邮件|正常邮件)*P(正常邮件)/P(待求邮件)
	 * P2：P(垃圾邮件|待求邮件)=P(待求邮件|垃圾邮件)*P(垃圾邮件)/P(待求邮件)
	 * 若P1>P2，则该邮件为正常邮件，否则为垃圾邮件
	 * 
	 * 分母一样，一次只需要比较分子大小
	 * P(待求邮件|正常邮件)*P(正常邮件)  与    P(待求邮件|垃圾邮件)*P(垃圾邮件)
	 * 训练数据一共40封邮件，20封正常邮件，20封垃圾邮件，因此 P(正常邮件)=P(垃圾邮件)=0.5
	 * 
	 * 最后只需要求 P(待求邮件|正常邮件)   与   P(待求邮件|垃圾邮件)
	 * @throws IOException 
	 */
	public String classify(String filePath) throws IOException{
		/**
		 * 依次为：后验概率、先验概率、类条件概率、总体概率密度
		 * p(c|w)=p(w|c)p(c)/p(w)
		 * 
		 * 假设所有词都相互独立
		 * p(w|c)=p(w0,w1,w2...wn|c)=p(w0|c)p(w1|c)p(w2|c)...p(wn|c)
		 */
		File file=new File(filePath);
		BufferedReader reader=null;
		String tmpStrLine=null;
		String tmpStr=null;
		String[] spl=null;
		reader=new BufferedReader(new FileReader(file));
		
		double p1=1; //正常邮件先验概率
		double p2=1; //垃圾邮件先验概率
		int word1=0; //训练数据正常邮件单词个数
		int word2=0; //训练数据垃圾邮件单词个数
		
		for (Integer in1 : wordVector1) { //计算训练数据正常邮件单词个数
			word1+=in1;
		}
		for (Integer in2 : wordVector2) { //计算训练数据垃圾邮件单词个数
			word2+=in2;
		}
		/**
		 * 计算先验概率
		 */
//		System.out.println("\n训练数据正常邮件单词个数为："+word1);
//		System.out.println("训练数据垃圾邮件单词个数为："+word2);
//		System.out.println("\n");
		DecimalFormat df = new DecimalFormat("##0.00");    //double保留小数点后6位
		while ((tmpStrLine=reader.readLine())!=null) {
			spl=tmpStrLine.split("\\s+");
			for (String str : spl) {
				tmpStr = str.trim().toUpperCase();
				if (judgeContainsStr(tmpStr)) { // 如果这个单词里包含字母
					tmpStr=tmpStr.replaceAll("[^a-z^A-Z^0-9]", "");
					/**
					 * 分子是0情况
					 * 无限相乘趋近于0
					 */
					if (wordli.contains(tmpStr)) { //词汇表中存在该单词
//						System.out.println("单词存在");
						/**
						 * 正常邮件先验概率
						 */
						int index=wordVector1[wordli.indexOf(tmpStr)]; //该单词在训练数据正常邮件出现的个数
						if(index>0){
							p1=Double.parseDouble(df.format((p1*Math.log((double)index/(double)word1))));
//							System.out.println("p1="+p1);
						}else {
							p1=Double.parseDouble(df.format(p1*(1.0/(double)(word1+2))));
						}
						/**
						 * 垃圾邮件先验概率
						 */
						int index2=wordVector2[wordli.indexOf(tmpStr)]; //该单词在训练数据正常邮件出现的个数
						if(index2>0){
							p2=Double.parseDouble(df.format((p2*Math.log((double)index2/(double)word2))));
//							System.out.println("p2="+p2);
						}else {
							p2=Double.parseDouble(df.format(p2*(1.0/(double)(word2+2))));
						}
					}else {
//						System.out.println("单词不存在！");
					}
				}
			}
		}
		/**
		 * 打印两个所求的先验概率
		 * 类条件概率、总体概率密度 两者相等，所以只需比较先验概率就可以了。
		 */
//		System.out.println("正常邮件的先验概率为："+p1);
//		System.out.println("垃圾邮件的先验概率为："+p2);
		reader.close();
//		System.out.print("\n该邮件为:");
//		System.out.println((p1>p2)?"正常邮件":"垃圾邮件");
		if (p1>p2) {
			return "正常邮件";
		}else{
			return "垃圾邮件";
		}
	}
}
