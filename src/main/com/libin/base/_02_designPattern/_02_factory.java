package libin.base._02_designPattern;
/**
 * 工厂设计模式
 * 程序的运行结果和之前一样，但是取得实例的过程不大一样。
 * 因为接口对象的实例是通过工厂取得的，这样以后如果再有子类扩充，直接修改工厂类客户端就可以标记得到相应的实例。
 * 灵活性较高。
 */
public class _02_factory {
	public static void main(String[] args) {
		Fruit fsFruit=Factory.getInstance("apple"); //通过工厂取得实例
		if (fsFruit!=null) {
			fsFruit.eat();
		}
	}
}
interface Fruit{ //定义一个接口
	public void eat();
}
class Apple implements Fruit{ //定义一个子类apple类
	public void eat() {
		System.out.println("this is apple");
	}
}
class Orange implements Fruit{ //定义一个子类orange类
	public void eat() {
		System.out.println("this is orange");
	}
}
class Factory{ //定义工厂类
	public static Fruit getInstance(String className){
		if ("apple".equals(className)) {
			return new Apple();
		}
		if ("orange".equals(className)){
			return new Orange();
		}
		return null;
	}
}