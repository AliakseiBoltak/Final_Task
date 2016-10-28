package by.epam.tc.test.dao.factory;


import by.epam.tc.test.dao.AnswerDAO;
import by.epam.tc.test.dao.QuestionDAO;
import by.epam.tc.test.dao.TestDAO;
import by.epam.tc.test.dao.UserDAO;
import by.epam.tc.test.dao.impl.AnswerDAOImpl;
import by.epam.tc.test.dao.impl.QuestionDAOImpl;
import by.epam.tc.test.dao.impl.TestDAOImpl;
import by.epam.tc.test.dao.impl.UserDAOImpl;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */
public class DAOFactory {

	private static final DAOFactory INSTANCE = new DAOFactory();

	private static final UserDAO userDAO = new UserDAOImpl();
	
	private static final TestDAO testDAO = new TestDAOImpl();
	
	private static final QuestionDAO questionDAO = new QuestionDAOImpl();
	
	private static final AnswerDAO answerDAO = new AnswerDAOImpl();
	

	private DAOFactory() {

	}

	public static DAOFactory getInstance() {
		return INSTANCE;
	}


	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public TestDAO getTestDAO() {
		return testDAO;
	}
	
	public QuestionDAO getQuestionDAO() {
		return questionDAO;
	}
	
	public AnswerDAO getAnswerDAO() {
		return answerDAO;
	}
	
}
