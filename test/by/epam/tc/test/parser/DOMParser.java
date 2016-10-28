package by.epam.tc.test.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import by.epam.tc.test.entity.Test;
import by.epam.tc.test.entity.User;
/**
 * Created by Aliaksei Boltak on 27/10/2016.
 */

public class DOMParser {

	private static List<Test> dataList = new ArrayList<Test>();
	
	private static List<User> userList = new ArrayList<User>();
	
	

	public static List<User> getUserList() {
		return userList;
	}

	public static void setUserList(List<User> userList) {
		DOMParser.userList = userList;
	}

	public static List<Test> getDataList() {
		return dataList;
	}

	public static void setDataList(List<Test> dataList) {
		DOMParser.dataList = dataList;
	}

	public static void startShowAllTests(String path) throws ParserConfigurationException, SAXException {

		try {

			File input = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(input);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("subject");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String id = eElement.getAttribute("ID");
					String subject = eElement.getElementsByTagName("name").item(0).getTextContent();

					Test test = new Test(Integer.valueOf(id), subject);
					dataList.add(test);
				}
			}
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
	}

	
	public static void startLogination(String path) throws ParserConfigurationException, SAXException {
		
		try {

			File input = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(input);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("user");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String id = eElement.getAttribute("ID");
					String login = eElement.getElementsByTagName("login").item(0).getTextContent();
					String pass = eElement.getElementsByTagName("pass").item(0).getTextContent();
					String role = eElement.getElementsByTagName("role").item(0).getTextContent();
					String block_status = eElement.getElementsByTagName("block_status").item(0).getTextContent();
					

					User user = new User(Integer.valueOf(id), login, pass, Integer.valueOf(role) ,Integer.valueOf(block_status));
					userList.add(user);
				}
			}
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}

	}

}
