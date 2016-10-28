package by.epam.tc.test.service;

import java.util.List;
import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.entity.Answer;
import by.epam.tc.test.service.exception.ServiceException;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */
public interface AnswerService {
	
   public boolean createAnswer(int test_id, int users_id, int mark) throws ServiceException;
	
	public List <Answer> showAnswersByUsersId( int users_id) throws ServiceException ;


}
