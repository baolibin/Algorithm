package libin.base._01_thread;
/**
 * Java 多线程
 */
public class _01_Thread{

	public static void main(String[] args) {
		MyThread01 myThread01 = new MyThread01();
		Thread thread01 = new Thread(myThread01);
		thread01.start();
		
		MyThread02 myThread02 = new MyThread02();
		myThread02.start();
	}
}

class MyThread01 implements Runnable{
	public void run() {
		System.out.println("Runnable");
	}
}

class MyThread02 extends Thread{
	public void run() {
		System.out.println("Thread");
	}
}