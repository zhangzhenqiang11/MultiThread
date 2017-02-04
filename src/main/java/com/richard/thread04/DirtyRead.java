package com.richard.thread04;

/*
 * 对于对象的同步和异步的方法，我们在设计自己的程序的时候，一定要考虑问题的整体，不然就会出现数据不一致的错误，
 * 很经典的错误就是脏读（dirtyread）
 *
 *总结：
 *  在我们对一个对象的方法加锁的时候，要考虑业务的整体性，即为setValue/getValue方法同时加锁synchronized同步关键字，
 *  保证业务(service)的原子性，不然会出现业务错误（也从侧面保证业务的一致性） 
 */
public class DirtyRead {

	private String name = "Richard";
	private String pwd = "123";
	
	public synchronized void setValue(String name,String pwd){
		this.name = name;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.pwd = pwd;
		System.out.println("setValue  name="+this.name+",pwd="+this.pwd);
	}
	
	//synchronized
	public void getValue(){
		System.out.println("getValue name="+this.name+",pwd="+this.pwd);
	}
	
	public static void main(String[] args) {
		final DirtyRead dr = new DirtyRead();
		
		Thread t = new Thread(new Runnable() {
			public void run() {
				dr.setValue("Jack", "456");
			}
		});
		
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		dr.getValue();
	}
	
}
