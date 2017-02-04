package com.richard;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@SuppressWarnings("unchecked")
public class MyCallableTest {

	
	/** 
	 * Callable 和 Future接口 
	 * Callable是类似于Runnable的接口，实现Callable接口的类和实现Runnable的类都是可被其它线程执行的任务。 
	 * Callable和Runnable有几点不同：  
	 * （1）Callable规定的方法是call()，而Runnable规定的方法是run(). 
	 * （2）Callable的任务执行后可返回值，而Runnable的任务是不能返回值的。  
	 * （3）call()方法可抛出异常，而run()方法是不能抛出异常的。 
	 * （4）运行Callable任务可拿到一个Future对象， Future表示异步计算的结果。 
	 * 它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果。 
	 * 通过Future对象可了解任务执行情况，可取消任务的执行，还可获取任务执行的结果。 
	 */  
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("程序开始执行》》》》》》》》》");
		
		Date start = new Date();
		
		int taskSize = 5;
		 // 创建一个线程池  
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		
		// 创建多个有返回值的任务  
		List<Future> list = new ArrayList<Future>();
		for (int i = 0; i < taskSize; i++) {
			Callable<Object> call = new MyCallable(i+"  ");
			// 执行任务并获取Future对象 
			Future f = pool.submit(call);
			System.out.println("从Future对象上获取任务的返回值>>>>"+f.get().toString());
			list.add(f);
		}
		
		//关闭线程池
		pool.shutdown();
		
		//获取所有并发任务的结果
		for (Future future : list) {
			 // 从Future对象上获取任务的返回值，并输出到控制台  
			System.out.println(future.get().toString());
		}
		
		Date end = new Date();
		long time = end.getTime() - start.getTime();
		System.out.println("【程序运行结束，运行时间="+time+"毫秒】");
	}
	
}
