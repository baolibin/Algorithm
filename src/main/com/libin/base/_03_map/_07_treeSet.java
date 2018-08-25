package libin.base._03_map;

import com.sun.istack.internal.NotNull;

import java.util.TreeSet;

/**
 * 底层使用红黑树数据结构
 *
 * @author baolibin
 */
public class _07_treeSet {
    public static void main(String[] args) {
        Stu stu1 = new Stu("spark", 2009);
        Stu stu2 = new Stu("hive", 2013);
        Stu stu3 = new Stu("hadoop", 2006);
        TreeSet<Object> treeSet = new TreeSet<Object>();
        treeSet.add(stu1);
        treeSet.add(stu2);
        treeSet.add(stu3);
        for (Object stu : treeSet)
            System.out.println(stu);
    }
}
class Stu implements Comparable {
    String name;
    int age;

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Object o) {
        Stu stu = (Stu) o;
        return stu.age - this.age;
    }

    @Override
    public String toString() {
        return this.name + "|" + this.age;
    }
}
