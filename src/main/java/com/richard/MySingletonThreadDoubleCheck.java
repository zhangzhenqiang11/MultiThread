package com.richard;

public class MySingletonThreadDoubleCheck {

	private static MySingletonThreadDoubleCheck singleton ;
	
	public static MySingletonThreadDoubleCheck getSingleton(){
		if(singleton == null){
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized (MySingletonThreadDoubleCheck.class) {
				if(singleton == null){
					singleton = new MySingletonThreadDoubleCheck();
				}
			}
		}
		return singleton;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable(){
			public void run(){
				MySingletonThreadDoubleCheck s1 = MySingletonThreadDoubleCheck.getSingleton();
				System.out.println("s1 = "+s1.hashCode());
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				MySingletonThreadDoubleCheck s2 = MySingletonThreadDoubleCheck.getSingleton();
				System.out.println("s2 = "+s2.hashCode());
			}
		});
		
		Thread t3 = new Thread(new Runnable(){
			public void run(){
				MySingletonThreadDoubleCheck s3 = MySingletonThreadDoubleCheck.getSingleton();
				System.out.println("s3 = "+s3.hashCode());
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}

}
