package com.bingbing.bingxue.design.concurrent;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockStorage {
    // 仓库最大存储量
    private final int MAX_SIZE = 100;

    // 仓库存储的载体
    private LinkedList<Object> list = new LinkedList<Object>();
    // 锁
    private final Lock lock = new ReentrantLock();

    // 仓库满的条件变量
    private final Condition full = lock.newCondition();

    // 仓库空的条件变量
    private final Condition empty = lock.newCondition();

    // 生产产品
    public void produce(String producer) {
        lock.lock();
        // 如果仓库已满
        while (list.size() == MAX_SIZE) {
            System.out.println("仓库已满，【" + producer + "】： 暂时不能执行生产任务!");
            try {
                // 由于条件不满足，生产阻塞
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 生产产品
        list.add(new Object());

        System.out.println("【" + producer + "】：生产了一个产品\t【现仓储量为】:" + list.size());

        empty.signalAll();

        // 释放锁
        lock.unlock();

    }

    // 消费产品
    public void consume(String consumer) {
        // 获得锁
        lock.lock();

        // 如果仓库存储量不足
        while (list.size() == 0) {
            System.out.println("仓库已空，【" + consumer + "】： 暂时不能执行消费任务!");
            try {
                // 由于条件不满足，消费阻塞
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.remove();
        System.out.println("【" + consumer + "】：消费了一个产品\t【现仓储量为】:" + list.size());
        full.signalAll();
        
        // 释放锁
        lock.unlock();

    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }
    
    public static void main(String[] args) {
		LockStorage storage = new LockStorage();
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