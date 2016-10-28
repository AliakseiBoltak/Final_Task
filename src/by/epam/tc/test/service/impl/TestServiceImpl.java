package by.epam.tc.test.service.impl;

import java.util.List;
import by.epam.tc.test.dao.TestDAO;
import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.dao.factory.DAOFactory;
import by.epam.tc.test.entity.Test;
import by.epam.tc.test.service.TestService;
import by.epam.tc.test.service.exception.ServiceException;
import by.epam.tc.test.utils.StringUtils;

/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class TestServiceImpl implements TestService {

	@Override
	public boolean createTest(String subject) throws ServiceException {
		if (!StringUtils.isValid(subject)) {
			throw new ServiceException("Incorrect parametres");
		} else {
			TestDAO daoTest = DAOFactory.getInstance().getTestDAO();
			try {
				return (daoTest.createTest(subject));
			} catch (DAOException e) {
				throw new ServiceException(e.getMessage());
			}
		}
	}

	@Override
	public List<Test> showAllTests() throws ServiceException {
		TestDAO daoTest = DAOFactory.getInstance().getTestDAO();
		try {
			return (daoTest.showAllTests());
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
