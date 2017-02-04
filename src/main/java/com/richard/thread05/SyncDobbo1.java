package com.richard.thread05;

public class SyncDobbo1 {

	private synchronized void method01(){
		System.out.println("method01..");
		method02();
	}
	private synchronized void method02(){
		System.out.println("method02..");
		method03();
	}
	private synchronized void method03(){
		System.out.println("method03");
	}
	
	public static void main(String[] args) {
		
		final SyncDobbo1 sn = new SyncDobbo1();
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				sn.method01();
			}
		});
		
		t.start();
	}
	
}
