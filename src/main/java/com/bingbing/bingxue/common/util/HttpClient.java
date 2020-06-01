package com.bingbing.bingxue.common.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * http客户端
 */
public class HttpClient {
	
	private static RequestConfig requestConfig ;
    static {
        requestConfig = RequestConfig.custom()
                .setSocketTimeout(1000*60)
                .setConnectionRequestTimeout(1000*60)
                .setConnectTimeout(1000*60).build();
    }
    
    public static String postText(String url,String text){
    	Header[] headers = {
      		     new BasicHeader("","")
      		    ,new BasicHeader("","")
      		    ,new BasicHeader("","")
      		};
        CloseableHttpClient httpClient = HttpClients.createDefault();;
        String result= "";
        CloseableHttpResponse response = null;
        try{
            HttpPost httpPost= new HttpPost(url);
            httpPost.setConfig(requestConfig);
            httpPost.setHeaders(headers);
            StringEntity strEntity = new StringEntity(text, ContentType.create("text/xml", Charset.forName("utf-8")));
            httpPost.setEntity(strEntity);
            response= httpClient.execute(httpPost);
            if(response.getStatusLine().getStatusCode()==200){
                result= EntityUtils.toString(response.getEntity(),"utf-8");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
	
    public static String postForm(String url,Map<String,String> params){
        CloseableHttpClient httpClient = HttpClients.createDefault();;
        String result= "";
        CloseableHttpResponse response = null;
        try{
            HttpPost httpPost= new HttpPost(url);
            httpPost.setConfig(requestConfig);
            if(params!=null){
                List<NameValuePair> nameValuePairs= new ArrayList<NameValuePair>();
                Set<String> keys= params.keySet();
                for(String key:keys){
                    nameValuePairs.add(new BasicNameValuePair(key,params.get(key)));
                }
                UrlEncodedFormEntity entity= new UrlEncodedFormEntity(nameValuePairs,"utf-8");
                httpPost.setEntity(entity);
            }
            response= httpClient.execute(httpPost);
            if(response.getStatusLine().getStatusCode()==200){
                result= EntityUtils.toString(response.getEntity(),"utf-8");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}