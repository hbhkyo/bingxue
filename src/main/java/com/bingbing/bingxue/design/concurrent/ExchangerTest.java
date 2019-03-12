package com.bingbing.bingxue.design.concurrent;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerTest {

    static class ExchangerProducer implements Runnable {
    	
    	private static int data = 10;
    	
        private Exchanger<Integer> exchanger;
        ExchangerProducer(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                System.out.println("producer before: " + data);
                TimeUnit.SECONDS.sleep(1);
                data = exchanger.exchange(data);
                System.out.println("producer after: " + data);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
    }

    static class ExchangerConsumer implements Runnable {
        private Exchanger<Integer> exchanger;
        private static int data = 0;
        ExchangerConsumer(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }
        @Override
        public void run() {
            try {
            	System.out.println("consumer before : " + data);
                data = exchanger.exchange(data);
                System.out.println("consumer after : " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<Integer> exchanger = new Exchanger<Integer>();
        ExchangerProducer producer = new ExchangerProducer(exchanger);
        ExchangerConsumer consumer = new ExchangerConsumer(exchanger);
        exec.execute(producer);
        exec.execute(consumer);
        exec.shutdown();
    }
}