package com.bill99.test;

public class Mythread2 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyTicket(),"t1");
		Thread t2 = new Thread(new MyTicket(),"t2");
		Thread t3 = new Thread(new MyTicket(),"t3");
		Thread t4 = new Thread(new MyTicket(),"t4");
		Thread t5 = new Thread(new MyTicket(),"t5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
}
class MyTicket implements Runnable{
	
	private int ticket = 5;
	
	public void run(){
		while(true){
			if(ticket > 0){
				System.out.println(" ticket = "+ticket-- + "  "
						+Thread.currentThread().getName());
			}else{
				break;
			}
		}
	}
	
}