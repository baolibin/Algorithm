package libin.general._10_machine;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class OperateUtil {
	public static void main(String[] args) {
//		OperateUtil operateUtil = new OperateUtil();
//		operateUtil.transform(); //第一个测试
//		operateUtil.retain();	//第二个测试
//		
//		int[] tmp=new int[10];
//		System.out.println(tmp[6]);
//		
//		String str="OEM Adobe & Microsoft Plus 2007/2010 $129 Windows 7 Ultimate $119 & thousand more titles";
//		String[] sp=str.split("\\s");
//		for (String str1 : sp) {
//			System.out.println(str1);
//		}
		
		System.out.println("abasdfasdf1 2wasdfasdf9_8asdfasdfz asdfasdfyx7".replaceAll("[^a-z^A-Z^0-9]", ""));
		
		List<String> list=new ArrayList<String>();
		list.add("hadoop");
		list.add("hive");
		list.add("hbase");
		int tmpindex=list.indexOf("hadoop");
		System.out.println(tmpindex);
		
	}
	/**
	 * 1、根据ASCLL码进行互相转换
	 *  A-->0 && 0-->A 
	 */
	public void transform(){
		/**
		 * A --》 0
		 */
		String str="A";
		int tmp=str.hashCode()-65;
		str=String.valueOf(tmp);
		System.out.println(str);
		
		/**
		 * 0 --> A
		 */
		int i=0;
		String temp2 = String.valueOf((char)(i+65));
		System.out.println(temp2);
	}
	/**
	 * 2、double 小数点保留若干位
	 */
	public void retain(){
		double dis=123.123546789;
		DecimalFormat df = new DecimalFormat("######0.000000");    //double保留小数点后6位
		double parseDouble = Double.parseDouble(df.format(dis));
		System.out.println(parseDouble);
	}
}





