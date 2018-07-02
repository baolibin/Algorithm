package libin.base._04_basic;

import java.util.Properties;

public class _02_properties {
	public static void main(String[] args) {
		Properties pro = new Properties();
		pro.setProperty("hadoop", "Hadoop是一个适合海量数据存储和处理的框架!");
		pro.setProperty("spark", "spark是一种内存计算的大数据框架!");
		String obj = (String) pro.get("hadoop");
		System.out.println(obj);
	}
}
