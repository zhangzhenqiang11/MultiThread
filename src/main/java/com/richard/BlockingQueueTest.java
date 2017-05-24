package com.richard;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author zhenqiang.zhang.rm
	 *多线程环境中，通过队列可以很容易实现数据共享，比如经典的“生产者”和“消费者”模型中，通过队列可以很便利地实现两者之间的数据共享。
	 *假设我们有若干生产者线程，另外又有若干个消费者线程。如果生产者线程需要把准备好的数据共享给消费者线程，利用队列的方式来传递数据，
	 *就可以很方便地解决他们之间的数据共享问题。但如果生产者和消费者在某个时间段内，万一发生数据处理速度不匹配的情况呢？理想情况下，
	 *如果生产者产出数据的速度大于消费者消费的速度，并且当生产出来的数据累积到一定程度的时候，那么生产者必须暂停等待一下（阻塞生产者线程），
	 *以便等待消费者线程把累积的数据处理完毕，反之亦然。然而，在concurrent包发布以前，在多线程环境下，我们每个程序员都必须去自己控制这些细节，
	 *尤其还要兼顾效率和线程安全，而这会给我们的程序带来不小的复杂度。好在此时，强大的concurrent包横空出世了，而他也给我们带来了强大的BlockingQueue。
	 *（在多线程领域：所谓阻塞，在某些情况下会挂起线程（即阻塞），一旦条件满足，被挂起的线程又会自动被唤醒）
 */
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
						Thread.sleep(3);
					
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
						Thread.sleep(10000);
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
