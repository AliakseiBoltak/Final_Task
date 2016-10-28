 package by.epam.tc.test.dao;
import java.util.List;

import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.entity.Answer;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */
public interface AnswerDAO {
	
	public boolean createAnswer(int test_id, int users_id, int mark) throws DAOException;
	
	public List <Answer> showAnswersByUsersId( int users_id) throws DAOException;

}
