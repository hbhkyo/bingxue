package com.bingbing.bingxue.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

/**
 * 
 * Title:XStream输出xml和解析xml的工具类
 * Description: 
 * Company: fuiou
 * @author hubh
 * @date 2018年1月4日 下午5:30:38
 */
public class XmlUtils {

	/**
	 * 对象转XML
	 * 
	 * @param obj
	 * @return
	 */
	public static String obj2xml(Object obj) {
		XStream xstream = new XStream(new DomDriver("UTF-8",
				new XmlFriendlyNameCoder("-_", "_")));
		xstream.processAnnotations(obj.getClass());
		return xstream.toXML(obj);
	}

	/**
	 * xml转对象
	 * 
	 * @param xmlStr
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xml2obj(String xmlStr, Class<T> cls) {
		XStream xstream = new XStream(new DomDriver("UTF-8",
				new XmlFriendlyNameCoder("-_", "_")));
		xstream.processAnnotations(cls);
		T obj = (T) xstream.fromXML(xmlStr);
		return obj;
	}

	/**
	 * 对象写到XML文件
	 * 
	 * @param obj
	 * @param absPath
	 * @param fileName
	 */
	public static void obj2xmlFile(Object obj, String absPath, String fileName) {
		String strXml = obj2xml(obj);
		String filePath = absPath + fileName;
		File file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		OutputStream ous = null;
		try {
			ous = new FileOutputStream(file);
			ous.write(strXml.getBytes());
			ous.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ous != null)
				try {
					ous.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/**
	 * 读XML文件到对象
	 * 
	 * @param absPath
	 * @param fileName
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xml2objFromFile(String absPath, String fileName,
			Class<T> cls) {
		String filePath = absPath + fileName;
		InputStream ins = null;
		try {
			ins = new FileInputStream(new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		XStream xstream = new XStream(new DomDriver("UTF-8",
				new XmlFriendlyNameCoder("-_", "_")));
		xstream.processAnnotations(cls);
		T obj = null;
		try {
			obj = (T) xstream.fromXML(ins);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ins != null) {
			try {
				ins.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public static String trimXml(String xml) {
		return xml.replaceAll(">\\s+<", "><");
	}
	
}