package by.epam.tc.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.epam.tc.test.dao.TestDAO;
import by.epam.tc.test.dao.UserDAO;
import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.dao.factory.DAOFactory;
import by.epam.tc.test.entity.Question;
import by.epam.tc.test.entity.User;
import by.epam.tc.test.service.UserService;
import by.epam.tc.test.service.exception.ServiceException;
import by.epam.tc.test.utils.StringUtils;



/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class UserServiceImpl implements UserService {

	@Override
	public boolean registration(String login, String pass) throws ServiceException {
		if (!StringUtils.isValid(login) || !StringUtils.isValid(pass)) {
			throw new ServiceException("Incorrect parametres");
		} else {
			UserDAO daoUser = DAOFactory.getInstance().getUserDAO();
			try {
				return (daoUser.registration(login, pass));
			} catch (DAOException e) {
				throw new ServiceException(e.getMessage());
			}
		}
	}

	@Override
	public User logination(String login, String pass) throws ServiceException {
		User user = null;
		if (!StringUtils.isValid(login) || !StringUtils.isValid(pass)) {
			throw new ServiceException("Incorrect parametres");
		} else {
			UserDAO daoUser = DAOFactory.getInstance().getUserDAO();
			try {
				user = daoUser.logination(login, pass);
			} catch (DAOException e1) {
				throw new ServiceException(e1.getMessage());
			}
		}
		return user;
	}
	
	@Override
	public List<Question> chooseTestToPass(int test_id) throws ServiceException {
		UserDAO daoUser = DAOFactory.getInstance().getUserDAO();
		try {
			return (daoUser.chooseTestToPass(test_id));
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	
	@Override
	public List<User> showAllUsers() throws ServiceException {
		UserDAO daoUser = DAOFactory.getInstance().getUserDAO();
		try {
			return (daoUser.showAllUsers());
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	

	@Override
	public boolean blockUser(String users_id) throws ServiceException {
		if (!StringUtils.isValid(users_id) || !StringUtils.isInteger(users_id)) {
			throw new ServiceException("Incorrect parametres");
		} else {
			UserDAO daoUser = DAOFactory.getInstance().getUserDAO();
			try {
				return daoUser.blockUser(users_id);
			} catch (DAOException e1) {
				throw new ServiceException(e1.getMessage());
			}
		}
	}

	@Override
	public boolean unBlockUser(String users_id) throws ServiceException {
		if (!StringUtils.isValid(users_id) || !StringUtils.isInteger(users_id)) {
			throw new ServiceException("Incorrect parametres");
		} else {
			UserDAO daoUser = DAOFactory.getInstance().getUserDAO();
			try {
				return daoUser.unBlockUser(users_id);
			} catch (DAOException e1) {
				throw new ServiceException(e1.getMessage());
			}
		}
	}



}
