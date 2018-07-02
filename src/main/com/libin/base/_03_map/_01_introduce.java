package libin.base._03_map;
/*
集合 的体系：
------------| Collection 单例集合的根接口
----------------| List  如果是实现了List接口的集合类，具备的特点： 有序，可重复。 
-------------------| ArrayList  ArrayList 底层是维护了一个Object数组实现的。 特点： 查询速度快，增删慢。
-------------------| LinkedList LinkedList 底层是使用了链表数据结构实现的， 特点： 查询速度慢，增删快。
-------------------| Vector(了解即可)  底层也是维护了一个Object的数组实现的，实现与ArrayList是一样的，但是Vector是线程安全的，操作效率低。

----------------| Set  如果是实现了Set接口的集合类，具备的特点： 无序，不可重复。
treeSet要注意的事项：
 	1. 往TreeSet添加元素的时候，如果元素本身具备了自然顺序的特性，那么就按照元素自然顺序的特性进行排序存储。
 	2. 往TreeSet添加元素的时候，如果元素本身不具备自然顺序的特性，那么该元素所属的类必须要实现Comparable接口，把元素
 	的比较规则定义在compareTo(T o)方法上。 
 	3. 如果比较元素的时候，compareTo方法返回 的是0，那么该元素就被视为重复元素，不允许添加.(注意：TreeSet与HashCode、equals方法是没有任何关系。)
 	4. 往TreeSet添加元素的时候, 如果元素本身没有具备自然顺序 的特性，而元素所属的类也没有实现Comparable接口，那么必须要在创建TreeSet的时候传入一个
 	比较器。
 	5.  往TreeSet添加元素的时候，如果元素本身不具备自然顺序的特性，而元素所属的类已经实现了Comparable接口， 在创建TreeSet对象的时候也传入了比较器
 	那么是以比较器的比较规则优先使用。

无序： 添加元素 的顺序与元素出来的顺序是不一致 的。

hashSet的实现原理：
	往Haset添加元素的时候，HashSet会先调用元素的hashCode方法得到元素的哈希值 ，
	然后通过元素 的哈希值经过移位等运算，就可以算出该元素在哈希表中 的存储位置。
	
	情况1： 如果算出元素存储的位置目前没有任何元素存储，那么该元素可以直接存储到该位置上。

	情况2： 如果算出该元素的存储位置目前已经存在有其他的元素了，那么会调用该元素的equals方法与该位置的元素再比较一次
	，如果equals返回的是true，那么该元素与这个位置上的元素就视为重复元素，不允许添加，如果equals方法返回的是false，那么该元素运行 添加。

    HashCode默认情况下表示的是内存地址，String 类已经重写了Object的hashCode方法了。
	注意： 如果两个字符串的内容一致，那么返回的hashCode 码肯定也会一致的。 
*/
public class _01_introduce {
	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = new String("hello");
		System.out.println("两个是同一个对象吗？"+(str1==str2));
		System.out.println("str1的hashCode："+ str1.hashCode());
		System.out.println("str2的hashCode:"+ str2.hashCode());
	}
}
/**
 ---|Collection: 单列集合
			---|List: 有存储顺序, 可重复
				---|ArrayList:	数组实现, 查找快, 增删慢
					                由于是数组实现, 在增和删的时候会牵扯到数组
							增容, 以及拷贝元素. 所以慢。数组是可以直接
							按索引查找, 所以查找时较快
				---|LinkedList:	链表实现, 增删快, 查找慢
					                由于链表实现, 增加时只要让前一个元素记住自
							己就可以, 删除时让前一个元素记住后一个元
							素, 后一个元素记住前一个元素. 这样的增删效
							率较高但查询时需要一个一个的遍历, 所以效率
							较低
				---|Vector:	和ArrayList原理相同, 但线程安全, 效率略低
					                和ArrayList实现方式相同, 但考虑了线程安全问
							题, 所以效率略低
			---|Set: 无存储顺序, 不可重复
				---|HashSet
				---|TreeSet
				---|LinkedHashSet
---| Map: 键值对
		---|HashMap
		---|TreeMap
		---|HashTable
		---|LinkedHashMap
 */
