package com.bill99.test;

public class Sleep {
	public static void main(String[] args) {
		System.out.println("start");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("end");
	}
}
