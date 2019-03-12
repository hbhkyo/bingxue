package com.bingbing.bingxue.design.concurrent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
		static Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
		
		static Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
	
	    public static void main(String[] args) throws InterruptedException {
	        for (int i = 0; i < 5; i++) {
	        	map.put(i, i);
	        }
	        
	        for (int i = 0; i < 5; i++) {
	        	hash.put(i, i);
	        }
	        
	        /*for (Entry<Integer, Integer> entry : map.entrySet()) {
	            if (entry.getKey() < 5) {
	            	map.remove(entry.getKey());
	            }
	        }*/
	        
	        /*for (Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
	            Entry<Integer, Integer> entry = iterator.next();
	            Integer key = entry.getKey();
	            if (key < 10) {
	            	//迭代器没有add方法
	                iterator.remove();
	                map.put(6, 6);  
	            }
	        }*/
	        
	        /*for (Entry<Integer, Integer> entry : hash.entrySet()) {
	            if (entry.getKey() < 3) {
	            	//hash.remove(entry.getKey());  //报错
	            	//hash.put(6, 6);  //报错
	            }
	        }*/
	        //需要使用迭代器的方法删除iterator.remove()  而不是集合的方法删除hash.remove(entry.getKey());
	        /*for (Iterator<Entry<Integer, Integer>> iterator = hash.entrySet().iterator(); iterator.hasNext();) {
	            Entry<Integer, Integer> entry = iterator.next();
	            Integer key = entry.getKey();
	            if (key < 10) {
	            	//迭代器没有add方法
	                iterator.remove();
	                //hash.put(6, 6);  //报错
	            }
	        }*/
	
	        Thread thread = new Thread(new Runnable() {
	            public void run() {
	                map.put(6, 6);
	            }
	
	        });
	        Thread thread2 = new Thread(new Runnable() {
	            public void run() {
	                for (Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
	                    Entry<Integer, Integer> entry = iterator.next();
	                    System.out.println(entry.getKey() + " - " + entry.getValue());
	                }
	            }
	        });
	        thread.start();
	        thread2.start();
	    }
}

