package libin.base._03_map;
/**
 ---|Hashtable:
	底层是哈希表数据结构，线程是同步的，不可以存入null键，null值。
	效率较低，被HashMap 替代。
---|HashMap:
	底层是哈希表数据结构，线程是不同步的，可以存入null键，null值。
	要保证键的唯一性，需要覆盖hashCode方法，和equals方法。
---| LinkedHashMap：
	该子类基于哈希表又融入了链表。可以Map集合进行增删提高效率。
---|TreeMap:
	底层是二叉树数据结构。可以对map集合中的键进行排序。需要使用Comparable或者Comparator 进行比较排序。return 0，来判断键的唯一性。
 */
public class _04_hashMap {

}
