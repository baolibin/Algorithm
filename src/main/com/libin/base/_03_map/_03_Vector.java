package libin.base._03_map;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Vector 是线程安全的
 * @author baolibin
 
 笔试题：说出ArrayList与Vector区别？
 相同点：ArrayList和Vector的底层都使用Object数组实现的
 不同点：1、ArrayList是线程不同步的，操作效率高。Vector是线程同步的，操作效率低；
 	 2、ArrayList是JDK1.2出现，Vector是JDK1.0出现;
 */
public class _03_Vector {
	public static void main(String[] args) {
		Vector<Object> vector = new Vector<Object>();
		
		vector.addElement("hadoop");
		vector.addElement("algorithm");
		vector.addElement("machine learning");
		
		Enumeration<Object> elements = vector.elements();
		while (elements.hasMoreElements()) {
			System.out.println(elements.nextElement());
		}
	}
}
