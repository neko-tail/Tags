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
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 针对于 applicationContext.xml 文件实现的bean工厂
 * @author master
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
    /**
     * 用于保存bean对象的hashmap
     */
    private Map<String, Object> beanMap = new HashMap<>();
    /**
     * 解析的文件地址
     */
    private String path = "applicationContext.xml";
    
    /**
     * 无参构造
     * 调用有参构造，填入默认参数
     */
    public ClassPathXmlApplicationContext() {
        this("applicationContext.xml");
    }
    
    /**
     * 有参构造
     * 解析xml文件，有点臃肿，可以试着拆解为多个方法
     * @param path 文件地址
     */
    public ClassPathXmlApplicationContext(String path) {
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
                    //获取id和class属性
                    String beanId = beanElement.getAttribute("id");
                    String className = beanElement.getAttribute("class");
                    //获取对应bean的类
                    Class beanClass = Class.forName(className);
                    //创建对应bean对象
                    Object beanObj = beanClass.newInstance();
                    //放入map中
                    beanMap.put(beanId, beanObj);
                }
            }
    
            //我本想将这两块组装在一起，结果发现有点麻烦，就先这样吧
            //组装依赖关系
            //通过bean中的property来设置bean对象中的字段
            for (int i = 0; i > beanNodeList.getLength(); i++) {
                //获取单个node节点
                Node beanNode = beanNodeList.item(i);
                //只需要元素节点
                if (beanNode.getNodeType() == Node.ELEMENT_NODE) {
                    //转换为元素节点
                    Element beanElement = (Element) beanNode;
                    //获取id属性
                    String beanId = beanElement.getAttribute("id");
                    //获取子节点list
                    NodeList beanChildNodeList = beanElement.getChildNodes();
                    for (int j = 0; j < beanChildNodeList.getLength(); j++) {
                        //获取单个子节点
                        Node beanChildNode = beanChildNodeList.item(j);
                        //只要元素节点且是property节点
                        if (beanChildNode.getNodeType() == Node.ELEMENT_NODE && "property".equals(beanChildNode.getNodeName())) {
                            //转换为元素节点
                            Element propertyElement = (Element) beanChildNode;
                            //获取name和ref属性值
                            String propertyName = propertyElement.getAttribute("name");
                            String propertyRef = propertyElement.getAttribute("ref");
                            //获取ref对象
                            Object refObj = beanMap.get(propertyRef);
                            //获取bean对象
                            Object beanObj = beanMap.get(beanId);
                            //获取bean的类
                            Class beanClazz = beanObj.getClass();
                            //创建property字段，通过查找bean类中字段名为propertyName字段
                            Field propertyField = beanClazz.getDeclaredField(propertyName);
                            //关闭安全检查
                            propertyField.setAccessible(true);
                            //设置bean的字段
                            propertyField.set(beanObj, refObj);
                        }
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 通过id，从beanMap中拿去一个bean对象
     * @param id bean的id
     * @return 一个bean对象
     */
    @Override
    public Object getBean(String id) {
        return beanMap.get(id);
    }
}
