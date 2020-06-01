package com.bingbing.bingxue.design.memcache;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.auth.AuthInfo;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.transcoders.SerializingTranscoder;
import net.rubyeye.xmemcached.utils.AddrUtil;

/**
 * 
 * 
 * 常见方案如下：
A. 客户端直接访问多个memcache 实例
优点：简单，未引入新的节点；
缺点：维护不方便，未实现集中管理；性能不满足，实例宕机后不能自动踢出（hash到该实例的请求都要等到超时才能转到其他正常实例）。
B. magent代理
优点：简单，满足缓存对代理的大部分要求；
缺点：无成熟案例；性能不满足，实例宕机后不能自动踢出。
C. moxi代理
优点：功能丰富，提供本地缓存、Memcache实例数据复制等。
缺点：无成熟案例；代码很久没更新。
D. twemproxy代理
优点：twitter的成熟案例。
缺点：主要配合是twemproxy+redis，与memcache配合使用的案例较少；不支持缓存的复制功能。
E. mcrouter
优点：facebook的成熟案例；功能强大，支持Memcache实例分组、实例复制功能，实例宕机后可自动踢出。
缺点：一般用于ubuntu平台，在centos上安装较复杂。
原文：https://blog.csdn.net/sdmei/article/details/78696868 
* <p>Description: </p>  
* @author Administrator    
* @date 2019年3月13日  
* @version 1.0
 */
public class MemcacheClient {
	
	private static MemcachedClient build;
	private static String memcachedServer = "127.0.0.1:8089";
	private static String memcachedUsername = "user";
	private static String memcachedPassword = "123456";
	private static int memcachedPoolSize = 5;
	
	static{
		XMemcachedClientBuilder client;
		client = new XMemcachedClientBuilder(memcachedServer);
		client.setConnectionPoolSize(memcachedPoolSize);
		client.setCommandFactory(new BinaryCommandFactory());
		client.setSessionLocator(new KetamaMemcachedSessionLocator());
		client.setTranscoder(new SerializingTranscoder());
		HashMap<InetSocketAddress, AuthInfo> authMap = new HashMap<InetSocketAddress, AuthInfo>();
		authMap.put(AddrUtil.getOneAddress(memcachedServer), AuthInfo.plain(memcachedUsername, memcachedPassword));
		client.setAuthInfoMap(authMap);
		try {
			 build = client.build();
		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("初始化memecache异常");
		}
	}
	
	public static void put(String key,String val){
		try {
			build.set(key, 60*2, val);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("memecache异常");
		}
	}
	
	public static String get(String key){
		try {
			return build.get(key);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("memecache异常");
		}
	}
	
	public static boolean del(String key){
		try {
			return build.delete(key);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("memecache异常");
		}
	}
	
}
