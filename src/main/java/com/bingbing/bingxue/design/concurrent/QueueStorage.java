package com.bingbing.bingxue.design.concurrent;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueStorage {
    // 仓库最大存储量
    private final int MAX_SIZE = 100;

    // 仓库存储的载体
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>(100);  

    // 生产产品
    public void produce(String producer) {
        // 如果仓库已满
        if (list.size() == MAX_SIZE) {
            System.out.println("仓库已满，【" + producer + "】： 暂时不能执行生产任务!");            
        }
        // 生产产品
        try {
            list.put(new Object());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【" + producer + "】：生产了一个产品\t【现仓储量为】:" + list.size());
    }

    // 消费产品
    public void consume(String consumer) {
        // 如果仓库存储量不足
        if (list.size() == 0) {
            System.out.println("仓库已空，【" + consumer + "】： 暂时不能执行消费任务!");            
        }
        try {
            list.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【" + consumer + "】：消费了一个产品\t【现仓储量为】:" + list.size());        
    }

    public LinkedBlockingQueue<Object> getList() {
        return list;
    }

    public void setList(LinkedBlockingQueue<Object> list) {
        this.list = list;
    }
    public int getMAX_SIZE() {
        return MAX_SIZE;
    }
    
    public static void main(String[] args) {
		QueueStorage storage = new QueueStorage();
		while (true){
			for (int i = 1; i < 2; i++) {
				int finalI = i;
				new Thread(new Runnable() {
					@Override
					public void run() {
						storage.produce("第"+finalI+"个生产者，线程name=="+Thread.currentThread().getName());
					}
				}).start();
			}
			for (int i = 1; i < 2; i++) {
				int finalI = i;
				new Thread(new Runnable() {
					@Override
					public void run() {
						storage.consume("第"+finalI+"个消费者，线程name=="+Thread.currentThread().getName());
					}
				}).start();
			}
		}
	}
}