package com.richard;

import java.util.Date;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Object> {

	private String taskNum;
	
	public MyCallable(String taskNum){
		this.taskNum = taskNum;
	}
	
	public Object  call() throws Exception {
		
		System.out.println("任务 >>>>>"+taskNum +" >>>  启动");
		Date start = new Date();
		Thread.sleep(1000);
		Date end = new Date();
		long time = end.getTime()-start.getTime();
		 
		System.out.println("任务 >>>>>"+taskNum +" >>>  停止");
		
		return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
	}

}
