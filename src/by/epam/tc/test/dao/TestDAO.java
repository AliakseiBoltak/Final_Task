package by.epam.tc.test.dao;
import java.util.List;

import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.entity.Test;

/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */
public interface TestDAO {
	
	public boolean createTest(String subject) throws DAOException;
	
	public List <Test> showAllTests() throws DAOException;
	
	
}
