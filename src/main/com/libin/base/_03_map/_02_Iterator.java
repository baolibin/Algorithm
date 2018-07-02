package libin.base._03_map;

import java.util.Iterator;
import java.util.TreeSet;
/**
Itreator	该接口是集合的迭代器接口类，定义了常见的迭代方法
	1：boolean hasNext():判断集合中是否有元素，如果有元素可以迭代，就返回true。
	2： E next() :返回迭代的下一个元素，注意： 如果没有下一个元素时，调用next元素会抛出NoSuchElementException
	3： void remove():从迭代器指向的集合中移除迭代器返回的最后一个元素（可选操作）。
 */
public class _02_Iterator {
	public static void main(String[] args) {
//		String[] str={"hadoop","spark","apache","hive","hbase"};
		TreeSet<String> treeSet=new TreeSet<String>();
		treeSet.add("hadoop");
		treeSet.add("spark");
		treeSet.add("apache");
		treeSet.add("hive");
		treeSet.add("hbase");
		Iterator<String> it=treeSet.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"、");
		}
	}
}
