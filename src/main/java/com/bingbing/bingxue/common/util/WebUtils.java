package com.bingbing.bingxue.common.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


public class WebUtils {
	
	/**
	 * 生成输出到客户端浏览器的HTML(自动post相关参数到相关地址)
	 * 
	 * @param url post目标地址
	 * @param parameters  需要post的参数名字和值
	 * @param charset 编码
	 * @return
	 */
	public static String genForwardHtml(String url, Map<String, String> parameters, String charset) {
		StringBuffer returnHtml = new StringBuffer("");
			returnHtml.append("<html>");
			String head = "<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=" + charset
					+ "\" pageEncoding=\"" + charset + "\" />";
			returnHtml.append(head);
			returnHtml.append("<title>loading</title>");
			returnHtml.append("<style type=\"text/css\">");
			returnHtml.append("body{margin:200px auto;font-family: \"宋体\", Arial;font-size: 12px;color: #369;text-align: center;}");
			returnHtml.append("#1{height:auto; width:78px; margin:0 auto;}");
			returnHtml.append("#2{height:auto; width:153px; margin:0 auto;}");
			returnHtml.append("vertical-align: bottom;}");
			returnHtml.append("</style>");
			returnHtml.append("</head>");
			returnHtml.append("<body OnLoad=\"OnLoadEvent();\" >");
			returnHtml.append("<form name=\"forwardForm\" action=\"").append(url).append("\" method=\"POST\">");
			Iterator<String> keyIterator = parameters.keySet().iterator();
			while (keyIterator.hasNext()) {
				Object key = keyIterator.next();
				returnHtml.append("  <input type=\"hidden\" name=\"").append(key.toString()).append("\" value=\"")
						.append((String) parameters.get(key)).append("\"/>");
			}
			returnHtml.append("</form>");
			returnHtml.append("<SCRIPT LANGUAGE=\"Javascript\">");
			returnHtml.append("  function OnLoadEvent(){");
			returnHtml.append("    document.forwardForm.submit();");
			returnHtml.append("  }");
			returnHtml.append("</SCRIPT>");
			returnHtml.append("</body>");
			returnHtml.append("</html>");
		return returnHtml.toString();
	}
	
	/**
	 * response返回String
	 * @param response
	 * @param result
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public static void write(HttpServletResponse response, String result) {
		try {
			OutputStream out = response.getOutputStream();
			out.write(result.getBytes("UTF-8"));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * response返回byte[]
	 * @param response
	 * @param result
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public static void write(HttpServletResponse response, byte[] result) {
		try {
			if(result == null){
				return;
			}
			OutputStream out = response.getOutputStream();
			out.write(result);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
