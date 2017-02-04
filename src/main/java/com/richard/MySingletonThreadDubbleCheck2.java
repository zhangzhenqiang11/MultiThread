package com.richard;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySingletonThreadDubbleCheck2 {

	static Set<Integer> set = new HashSet<Integer>();
	private static MySingletonThreadDubbleCheck2 singleton = new MySingletonThreadDubbleCheck2();
	public MySingletonThreadDubbleCheck2(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static MySingletonThreadDubbleCheck2 getSingleton(){
		if(singleton==null){
			singleton  =  new MySingletonThreadDubbleCheck2();
		}
		return singleton;
	}
	public static void main(String[] args){
		for(  int i=1;i<=10000000;i++){
//			testThread();
			 new Thread("线程"+i){
				 public void run(){
					 MySingletonThreadDubbleCheck2 s1 = MySingletonThreadDubbleCheck2.getSingleton();
//					 System.out.println(this.currentThread().getName()+" --- "+s1.hashCode());
					 set.add(s1.hashCode());
				 }
			 }.start();
			 
		}
		
		Iterator<Integer> it = set.iterator();
		System.out.println(set.size());
		while(it.hasNext()){
			System.out.println("set : "+it.next());
		}
	}
	
	
	
	public static void testThread() {
		
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				MySingletonThreadDubbleCheck2 s1 = MySingletonThreadDubbleCheck2.getSingleton();
//				System.out.println("s1 = "+s1.hashCode());
				set.add(s1.hashCode());
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				MySingletonThreadDubbleCheck2 s2 = MySingletonThreadDubbleCheck2.getSingleton();
				System.out.println("s2 = "+s2.hashCode());
			}
		});
		
		Thread t3 = new Thread(new Runnable(){
			public void run(){
				MySingletonThreadDubbleCheck2 s3 = MySingletonThreadDubbleCheck2.getSingleton();
				System.out.println("s3 = "+s3.hashCode());
			}
		});
		
		Thread t4 = new Thread(new Runnable(){
			public void run(){
				MySingletonThreadDubbleCheck2 s4 = MySingletonThreadDubbleCheck2.getSingleton();
				System.out.println("s4 = "+s4.hashCode());
			}
		});
		
		Thread t5 = new Thread(new Runnable(){
			public void run(){
				MySingletonThreadDubbleCheck2 s5 = MySingletonThreadDubbleCheck2.getSingleton();
				System.out.println("s5 = "+s5.hashCode());
			}
		});
		
		Thread t6 = new Thread(new Runnable(){
			public void run(){
				MySingletonThreadDubbleCheck2 s6 = MySingletonThreadDubbleCheck2.getSingleton();
				System.out.println("s6 = "+s6.hashCode());
			}
		});
		Thread t7 = new Thread(new Runnable(){
			public void run(){
				MySingletonThreadDubbleCheck2 s7 = MySingletonThreadDubbleCheck2.getSingleton();
				System.out.println("s7 = "+s7.hashCode());
			}
		});
		
		Thread t8 = new Thread(new Runnable(){
			public void run(){
				MySingletonThreadDubbleCheck2 s8 = MySingletonThreadDubbleCheck2.getSingleton();
				System.out.println("s8 = "+s8.hashCode());
			}
		});
		
		Thread t9 = new Thread(new Runnable(){
			public void run(){
				MySingletonThreadDubbleCheck2 s9 = MySingletonThreadDubbleCheck2.getSingleton();
				System.out.println("s9 = "+s9.hashCode());
			}
		});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
	}
	
}
