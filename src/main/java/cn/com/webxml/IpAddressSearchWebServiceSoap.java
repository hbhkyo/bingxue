
package cn.com.webxml;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "IpAddressSearchWebServiceSoap", targetNamespace = "http://WebXml.com.cn/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IpAddressSearchWebServiceSoap {


    /**
     * <br /><h3>通过输入IP地址查询国家、城市、所有者等信息。没有注明国家的为中国</h3><p>输入参数：IP地址（自动替换 " 。" 为 "."），返回数据： 一个一维字符串数组String(1)，String(0) = IP地址；String(1) = 查询结果或提示信息</p><br />
     * 
     * @param theIpAddress
     * @return
     *     returns cn.com.webxml.ArrayOfString
     */
    @WebMethod(action = "http://WebXml.com.cn/getCountryCityByIp")
    @WebResult(name = "getCountryCityByIpResult", targetNamespace = "http://WebXml.com.cn/")
    @RequestWrapper(localName = "getCountryCityByIp", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetCountryCityByIp")
    @ResponseWrapper(localName = "getCountryCityByIpResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetCountryCityByIpResponse")
    public ArrayOfString getCountryCityByIp(
        @WebParam(name = "theIpAddress", targetNamespace = "http://WebXml.com.cn/")
        String theIpAddress);

    /**
     * <br /><h3>获得您的IP地址和地址信息</h3><p>输入参数：无，返回数据： 一个一维字符串数组String(1)，String(0) = IP地址；String(1) = 地址信息</p><br />
     * 
     * @return
     *     returns cn.com.webxml.ArrayOfString
     */
    @WebMethod(action = "http://WebXml.com.cn/getGeoIPContext")
    @WebResult(name = "getGeoIPContextResult", targetNamespace = "http://WebXml.com.cn/")
    @RequestWrapper(localName = "getGeoIPContext", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetGeoIPContext")
    @ResponseWrapper(localName = "getGeoIPContextResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetGeoIPContextResponse")
    public ArrayOfString getGeoIPContext();

    /**
     * <br /><h3>获得本IP地址搜索 WEB 服务的数据库版本更新时间</h3><p>输入参数：无，输出参数 String</p><br />
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://WebXml.com.cn/getVersionTime")
    @WebResult(name = "getVersionTimeResult", targetNamespace = "http://WebXml.com.cn/")
    @RequestWrapper(localName = "getVersionTime", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetVersionTime")
    @ResponseWrapper(localName = "getVersionTimeResponse", targetNamespace = "http://WebXml.com.cn/", className = "cn.com.webxml.GetVersionTimeResponse")
    public String getVersionTime();

}
