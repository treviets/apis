package net.cd.common.util;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.beust.jcommander.internal.Lists;

/**
 * utils for convert XML file to java object, java object convert to XML
 * 
 * @author Steven & bill lee
 * @version 11302017:115051
 */
public class XmlUtils {
	/**
	 * convert object to xml string
	 * 
	 * @param obj
	 * @return
	 */
	public static String convertToXml(Object obj) {
		// 创建输出流
		StringWriter sw = new StringWriter();
		try {
			// 利用jdk中自带的转换类实现
			JAXBContext context = JAXBContext.newInstance(obj.getClass());

			Marshaller marshaller = context.createMarshaller();
			// 格式化xml输出的格式
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 将对象转换成输出流形式的xml
			marshaller.marshal(obj, sw);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}

	/**
	 * convert object to xml file path
	 * 
	 * @param obj
	 * @param path
	 * @return
	 */
	public static void convertToXml(Object obj, String path) {
		try {
			// 利用jdk中自带的转换类实现
			JAXBContext context = JAXBContext.newInstance(obj.getClass());

			Marshaller marshaller = context.createMarshaller();
			// 格式化xml输出的格式
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 将对象转换成输出流形式的xml
			// 创建输出流
			FileWriter fw = null;
			try {
				fw = new FileWriter(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
			marshaller.marshal(obj, fw);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * convert xml string to java object
	 * 
	 * @param clazz
	 * @param xmlStr
	 * @return
	 */
	public static Object convertXmlStrToObject(Class<?> clazz, String xmlStr) {
		Object xmlObject = null;
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			// 进行将Xml转成对象的核心接口
			Unmarshaller unmarshaller = context.createUnmarshaller();
			StringReader sr = new StringReader(xmlStr);
			xmlObject = unmarshaller.unmarshal(sr);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xmlObject;
	}

	/**
	 * convert xml file to java object
	 * 
	 * @param clazz
	 * @param xmlPath
	 * @return
	 */
	public static Object convertXmlFileToObject(Class<?> clazz, String xmlPath) {
		Object xmlObject = null;
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			FileReader fr = null;
			try {
				fr = new FileReader(xmlPath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			xmlObject = unmarshaller.unmarshal(fr);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xmlObject;
	}

	/**
	 * 
	 * @param unmarshaller
	 * @param clazz
	 * @param string
	 * @param stringType
	 * @return
	 * @throws JAXBException
	 */
	private static <T> List<T> unmarshal(javax.xml.bind.Unmarshaller unmarshaller, Class<T> clazz, String string,
			int stringType) throws JAXBException {
		StreamSource xml = null;
		if (stringType == 1) {
			xml = new StreamSource(new ByteArrayInputStream(string.getBytes()));
		} else {
			xml = new StreamSource(string);
		}
		@SuppressWarnings("unchecked")
		ListResultWrapper<T> wrapper = (ListResultWrapper<T>) unmarshaller.unmarshal(xml, ListResultWrapper.class)
				.getValue();
		return wrapper.getItems();
	}

	/**
	 * Parse xml string To Java object list
	 * 
	 * @param topLevelClass
	 * @param xmlString
	 * @return
	 */
	public static <T> List<T> parseXmlStringToList(Class<T> topLevelClass, String xmlString) {
		try {
			JAXBContext jc = JAXBContext.newInstance(ListResultWrapper.class, topLevelClass);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			List<T> list = unmarshal(unmarshaller, topLevelClass, xmlString, 1);
			return list;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Parse xml file To Java object list
	 * 
	 * @param topLevelClass
	 * @param xmlLocation
	 * @return
	 */
	public static <T> List<T> parseXmlFileToList(Class<T> topLevelClass, String xmlLocation) {
		try {
			JAXBContext jc = JAXBContext.newInstance(ListResultWrapper.class, topLevelClass);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			List<T> list = unmarshal(unmarshaller, topLevelClass, xmlLocation, 2);
			return list;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * parse xml child node to string list
	 * @param xmlString
	 * @param nodeName
	 * @return
	 */
	public static List<String> parseXmlChildNodeToStringList(String xmlString,String nodeName){
		 List<String> result = Lists.newArrayList();
		try {
			Document doc = DocumentHelper.parseText(xmlString);
			Element rootElt = doc.getRootElement(); // 获取根节点
			@SuppressWarnings("unchecked")
			Iterator<Element> iter = rootElt.elementIterator(nodeName); // 获取根节点下的子节点head
			while (iter.hasNext()) {
				Element itemEle = (Element) iter.next();
				result.add(itemEle.getStringValue());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
		 return result;
	}
}
