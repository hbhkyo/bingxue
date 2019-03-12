	package com.bingbing.bingxue.design.concurrent;
 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
 
public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();//开启一个动态缓存线程池
        final Semaphore sp = new Semaphore(3);//设置3个信号灯
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable(){
                public void run() {
                    
                    try {
                        sp.acquire();//获得一盏灯的使用权
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    System.out.println("线程"+Thread.currentThread().getName()+"进入");
                    
                    try {
                        Thread.sleep((long)Math.random()*10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    System.out.println("线程"+Thread.currentThread().getName()
                            +"即将离开");
                    sp.release();//释放信号灯的使用权
                    System.out.println("线程"+Thread.currentThread().getName()+"已离开。");
                }
            };
            service.execute(runnable);
        }
        service.shutdown();
    }
}
