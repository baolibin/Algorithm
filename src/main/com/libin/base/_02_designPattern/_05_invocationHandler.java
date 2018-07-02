package libin.base._02_designPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;;

/**
 * 动态代理
 * 通过一个代理类完成全部的代理功能。
	在Java中实现动态代理：需要 java.lang.reflect.InvocationHandler 接口  和 java.lang.reflect.Proxy 类支持。
	public interface InvocationHandler {
 		public Object invoke(Object proxy, Method method, Object[] args)throws Throwable;
    }
 */
public class _05_invocationHandler {
	public static void main(String[] args) {
		MyInvocationHandler headler = new MyInvocationHandler(); //实例化代理操作类
		subject bind = (subject) headler.bind(new RealSubject()); //绑定对象
		String info = bind.say("hadoop", 10); //通过动态代理调用方法
		System.out.println(info); //信息输出
	}
}
interface subject{ //定义接口
	public String say(String name, int age);
}
class  RealSubject implements subject{ //定义真实主题实现类
	public String say(String name, int age) {
		return "姓名："+name+",年龄："+age;
	}
}
class MyInvocationHandler implements InvocationHandler{ //定义InvocationHandler接口的子类，以完成代理的具体操作。
	private Object obj; //真实主题
	public Object bind(Object obj){ //绑定真实操作主题
		this.obj=obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this); //取得代理对象
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { //动态调用方法
		Object invoke = method.invoke(this.obj, args); //调用方法，传入真实主题和参数
		return invoke;
	}
	
}