package com.richard;

public class MySingletonThreadInnerClass {

	private static class SingletonClass{
		private static  volatile  SingletonClass singleton = new SingletonClass();
	}
	
	public static SingletonClass getSingleton(){
		return SingletonClass.singleton;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable(){

			public void run() {
				SingletonClass s1 = MySingletonThreadInnerClass.getSingleton();
				System.out.println("s1 = "+s1.hashCode());
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				SingletonClass s2 = MySingletonThreadInnerClass.getSingleton();
				System.out.println("s2 = "+s2.hashCode());
			}
		});
		
		t1.start();
		t2.start();
	}

}
