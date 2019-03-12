package com.bingbing.bingxue.design.concurrent;

import java.util.Timer;
import java.util.TimerTask;

/**  
* <p>Title: TraditionThreadTest</p>  
* <p>Description: </p>  
* @author Administrator    
* @date 2019年3月8日  
* @version 1.0  
*/
public class TraditionThreadTest {
	public static void main(String[] args) {
		/*thread();
		run();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("anonymous internal class");
			}
		}).start();*/
		
		Timer timer = new Timer();
		//延迟1000ms执行程序
        /*timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("IMP 当前时间" + this.scheduledExecutionTime());
            }
        }, 1000);*/
        
        //前一次执行程序结束后 2000ms 后开始执行下一次程序
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("IMP 当前时间" + this.scheduledExecutionTime());
            }
        }, 0,2000);

	}
	
	public  static void thread() {
		Thread t = new SubThread();
		t.start();
	}
	
	public  static void run() {
		Thread t = new Thread(new RunThread());
		t.start();
	}
}

class SubThread extends Thread{
	@Override
	public void run() {
		System.out.println("SubThread");
	}
}

class RunThread implements Runnable{
	@Override
	public void run() {
		System.out.println("RunThread");
	}
}