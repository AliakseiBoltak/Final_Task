package by.epam.tc.test.service;

import java.util.List;

import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.entity.Question;
import by.epam.tc.test.entity.User;
import by.epam.tc.test.service.exception.ServiceException;

/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */


public interface UserService {

	public boolean registration(String login, String pass) throws ServiceException;

	public User logination(String login, String pass)throws ServiceException;
	
	public List <Question> chooseTestToPass(int test_id)throws ServiceException;
	
	public List <User>  showAllUsers () throws ServiceException;
	

	public boolean blockUser(String users_id) throws ServiceException;

	public boolean unBlockUser(String users_id) throws ServiceException;
	
}
