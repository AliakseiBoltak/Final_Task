package by.epam.tc.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.entity.Question;
import by.epam.tc.test.entity.User;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */

public interface UserDAO {
	

	public boolean registration(String login, String pass) throws DAOException;

	public User logination(String login, String pass)throws DAOException;
	
	public List <Question> chooseTestToPass(int test_id)throws DAOException;
	
	public List <User>  showAllUsers ()throws DAOException;
	
	
	public boolean blockUser(String users_id) throws DAOException;

	public boolean unBlockUser(String users_id) throws DAOException;
	
}
