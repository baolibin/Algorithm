package libin.base._03_map;

import java.util.TreeMap;

public class _06_treeMap {
	public static void main(String[] args) {
		TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
		treeMap.put("HADOOP", "dashujyu");
		treeMap.put("HADOOP", "hH");
		System.out.println(treeMap.get("HADOOP"));
	}
}
