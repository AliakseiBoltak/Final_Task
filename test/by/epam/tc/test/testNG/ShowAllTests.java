package by.epam.tc.test.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.dao.factory.DAOFactory;
import by.epam.tc.test.parser.DOMParser;
import org.testng.annotations.BeforeMethod;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
/**
 * Created by Aliaksei Boltak on 27/10/2016.
 */


public class ShowAllTests {
	
	
	public static List <by.epam.tc.test.entity.Test> actual = new ArrayList <by.epam.tc.test.entity.Test>();
	
	public static List <by.epam.tc.test.entity.Test> expected = new ArrayList <by.epam.tc.test.entity.Test>();

	@Test
	public void ShowAllTest() {

		Assert.assertEquals(actual, expected);
		
	}

	@BeforeMethod
	public void beforeMethod() throws DAOException, ParserConfigurationException, SAXException {

		actual = DAOFactory.getInstance().getTestDAO().showAllTests();
		
		DOMParser.startShowAllTests("src/test.xml");
		
		expected=DOMParser.getDataList();
		
	}

}
