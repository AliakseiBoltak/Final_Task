package by.epam.tc.test.testNG;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.dao.factory.DAOFactory;
import by.epam.tc.test.entity.User;
import by.epam.tc.test.parser.DOMParser;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
/**
 * Created by Aliaksei Boltak on 27/10/2016.
 */

public class LoginationTest {

	public static List<User> actual = new ArrayList<User>();

	public static List<User> expected = new ArrayList<User>();

	@Test
	public void Logination() {

		Assert.assertEquals(actual, expected);
	}

	@BeforeMethod
	public void beforeMethod() throws DAOException, ParserConfigurationException, SAXException {
		
		
		DAOFactory.getInstance().getUserDAO().unBlockUser("2");

		actual.add(DAOFactory.getInstance().getUserDAO().logination("Admin", "12345"));

		actual.add(DAOFactory.getInstance().getUserDAO().logination("User", "user"));

		DOMParser.startLogination("src/user.xml");

		expected = DOMParser.getUserList();

	}

}
