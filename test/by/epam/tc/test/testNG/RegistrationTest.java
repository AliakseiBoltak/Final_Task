package by.epam.tc.test.testNG;

import org.testng.annotations.Test;
import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.dao.factory.DAOFactory;
import org.testng.Assert;
/**
 * Created by Aliaksei Boltak on 27/10/2016.
 */

public class RegistrationTest {

	@Test
	public void Registration() throws DAOException {

		boolean b = DAOFactory.getInstance().getUserDAO().registration("Admin", "12345");

		boolean bool = DAOFactory.getInstance().getUserDAO().registration("new", "123");

		Assert.assertEquals(false, b);

		Assert.assertEquals(true, bool);
	}

}
