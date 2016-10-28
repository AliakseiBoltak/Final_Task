package by.epam.tc.test.testNG;

import org.testng.annotations.Test;
import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.dao.factory.DAOFactory;
import by.epam.tc.test.entity.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
/**
 * Created by Aliaksei Boltak on 27/10/2016.
 */

public class BlockUserTest {

	@Test
	public void BlockUser() throws DAOException {

		User user = DAOFactory.getInstance().getUserDAO().logination("User", "user");

		int id = user.getBlock_status();

		Assert.assertEquals(1, id);

	}

	@BeforeMethod
	public void beforeMethod() throws DAOException {

		DAOFactory.getInstance().getUserDAO().blockUser("2");

	}

}
