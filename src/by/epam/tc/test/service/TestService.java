package by.epam.tc.test.service;

import java.util.List;

import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.entity.Test;
import by.epam.tc.test.service.exception.ServiceException;

/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */

public interface TestService {
	
	
   public boolean createTest(String subject) throws ServiceException;
	
	public List <Test> showAllTests() throws ServiceException;

}
