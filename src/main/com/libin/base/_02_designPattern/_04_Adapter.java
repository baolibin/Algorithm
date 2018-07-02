package libin.base._02_designPattern;
/**
 * 适配器模式
 * 实现接口需要实现其全部的方法，很麻烦，有很多方法用不到;
 * 需要一个中间过渡，但是此过渡又不希望被直接使用，此过渡类定义成抽象类最合适；
 * 此抽象类又称作适配类
 */
public class _04_Adapter {
	public static void main(String[] args) {
		windows win=new windowImpl(); //实现接口调用
		win.open();
		win.close();
	}
}
interface windows{ //定义接口
	public void open();
	public void close();
	public void activated();
}
abstract class windowAdaper implements windows{ //定义抽象类实现接口,覆写所有方法，但都为空。
	public void open(){}
	public void close(){}
	public void activated(){}
}
class windowImpl extends windowAdaper{ //子类继承抽象类windowAdaper，有选择的实现需要的方法
	public void open(){
		System.out.println("打开窗子!"); //真正实现open方法
	}
	public void close(){
		System.out.println("关闭窗子!"); //真正实现close方法
	}
}
