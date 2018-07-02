package libin.base._02_designPattern;
/**
 * 代理设计模式
 * 指由一个代理主题来操作真实的主题，真实主题执行具体的业务操作；
 * 而代理主题负责其他相关业务的处理；
 */
public class _03_Proxy {
	public static void main(String[] args) {
		NetWork netWork=new Proxy(new Real()); //传入代理的真实操作，实例化代理
		netWork.browse(); //客户的上网操作
	}
}
interface NetWork{ //定义接口
	public void browse();
}
class Real implements NetWork{ //真实上网操作类
	public void browse() {
		System.out.println("上网浏览信息!");
	}
}
class Proxy implements NetWork{ //代理上网
	private NetWork netWork;
	public Proxy(NetWork netWork){
		this.netWork=netWork;
	}
	public void check(){
		System.out.println("检查用户是否合法!");
	}
	public void browse() {
		this.check();
		this.netWork.browse();
	}
}