package libin.base._03_map;

import java.util.TreeMap;

public class _06_treeMap {
	public static void main(String[] args) {
		Stu stu1 = new Stu("hadoop",2006);
		Stu stu2 = new Stu("spark",2009);
		Stu stu3 = new Stu("hive",2013);

		TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
		treeMap.put(stu1, "first");
		treeMap.put(stu2, "second");
		treeMap.put(stu3, "third");

		System.out.println(treeMap.get("HADOOP"));
	}
}

