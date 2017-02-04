package com.richard;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueTest {

	public static class Basket{
		
		BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);
		
		public void produce() throws InterruptedException{
			basket.put("an apple");
		}
		
		public String  consum() throws InterruptedException{
			return basket.take();
		}
	}
	
	public static void baskettest(){
		
		final Basket basket = new Basket();
		
		class Producer implements Runnable{

			public void run() {
				
				try {
					while(true){
						System.out.println("生产者准备生产苹果 >> "+System.currentTimeMillis());
						basket.produce();
						System.out.println("生产者生产苹果完毕："   
                                + System.currentTimeMillis());  
						Thread.sleep(300);
					
				}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		class Consumer implements Runnable{

			public void run() {
				
				try {
					while(true){
						System.out.println("消费者准备消费苹果》》》"+System.currentTimeMillis());
						basket.consum();
						System.out.println("消费者消费苹果完毕>>>"+System.currentTimeMillis());
						Thread.sleep(1000);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		ExecutorService pool = Executors.newCachedThreadPool();
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		pool.submit(producer);
		pool.submit(consumer);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pool.shutdown();
	}
	
	public static void main(String[] args) {
		 BlockingQueueTest.baskettest();  
	}
	
}
