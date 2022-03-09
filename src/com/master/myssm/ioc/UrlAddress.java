package com.master.myssm.ioc;

import com.master.myssm.util.StringUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 针对于 urladdress.xml 文件实现的bean工厂
 * @author master
 */
public class UrlAddress {
    /**
    * 用于保存bean对象的hashmap
    */
    private Map<String, Map<String, String>> beanMap = new HashMap<>();

    /**
     * 解析的文件地址
     */
    private String path = "urladdress.xml";
    
    /**
     * 无参构造
     * 调用有参构造，填入默认参数
     */
    public UrlAddress() {
        this("urladdress.xml");
    }
    
    /**
     * 有参构造
     * 解析xml文件，有点臃肿，可以试着拆解为多个方法
     * @param path 文件地址
     */
    public UrlAddress(String path) {
        if (StringUtil.isEmpty(path)) {
            //进行修改，如果参数为空，则使用默认的成员变量
            path = this.path;
        }
        try {
            //将文件转化为输入流
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
            //创建DocumentBuilderFactory对象
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            //创建DocumentBuilder对象
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //创建Document对象
            Document document = documentBuilder.parse(inputStream);
            
            //获取所有bean节点到map中
            NodeList beanNodeList = document.getElementsByTagName("bean");
            for (int i = 0; i < beanNodeList.getLength(); i++) {
                //获取单个node节点
                Node beanNode = beanNodeList.item(i);
                //只需要元素节点
                if (beanNode.getNodeType() == Node.ELEMENT_NODE) {
                    //转换为元素节点
                    Element beanElement = (Element) beanNode;
                    //获取属性
                    String url = beanElement.getAttribute("url");
                    String className = beanElement.getAttribute("class");
                    String function = beanElement.getAttribute("func");

                    //放入map中
                    Map<String, String> funcMap = new HashMap<>();
                    funcMap.put("class", className);
                    funcMap.put("func", function);
                    beanMap.put(url, funcMap);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 通过url，获取对应的类和方法的map
     * @param url url
     * @return 一对应的类和方法的map
     */
    public Map<String, String> getBean(String url) {
        return beanMap.get(url);
    }
}
