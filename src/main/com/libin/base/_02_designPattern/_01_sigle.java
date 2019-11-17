package libin.base._02_designPattern;
/**
 * 单例设计模式 :保证一个类在内存中只有一个对象
 * 
 * 模式：就是解决一类问题的步骤
 * 
 * 软件行业有23中设计模式
 * 
 * 饿汉单例设计模式
	1. 私有化构造函数。
	2. 声明本类的引用类型变量，并且使用该变量指向本类对象。
	3. 提供一个公共静态的方法获取本类的对象。

       懒汉单例设计模式：
	1. 私有化构造函数。
	2. 声明本类的引用类型变量，但是不要创建对象，
	3. 提供公共静态 的方法获取本类 的对象，获取之前先判断是否已经创建了本类 对象
	，如果已经创建了，那么直接返回对象即可，如果还没有创建，那么先创建本类的对象，
	然后再返回。
	
	推荐使用： 饿汉单例设计模式。  因为懒汉单例设计模式会存在线程安全问题，目前还不能保证一类在内存中只有一个对象。

 饿汉式：在类加载时就完成了初始化，所以类加载比较慢，但是获取对象的速度快。
 懒汉式：在类加载时候不初始化，等到第一次被使用时候才初始化。
 *
 */

public class _01_sigle {
	public static void main(String[] args) {
		Single s1=Single.getSingle();
		Single s2=Single.getSingle();
		System.out.println("是否是同一个对象:"+(s1==s2));
		
		Single2 s3=Single2.getSingle2();
		Single2 s4=Single2.getSingle2();
		System.out.println("是否是同一个对象:"+(s3==s4));
	}
}
/**
 * 1、饿汉单例
 */
class Single{
	private static Single s= new Single();
	private Single(){}
	
	public static Single getSingle(){
		return s;
	}
}
/**
 * 2、懒汉单例
 */
class Single2{
	private static Single2 single2;
	private Single2(){
	}
	
	public static Single2 getSingle2(){
		if(single2==null){
			single2=new Single2();
		}
		return single2;
	}
}
