package by.epam.tc.test.service;

import java.util.List;

import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.entity.Question;
import by.epam.tc.test.service.exception.ServiceException;

/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */

public interface QuestionService {
	
    public boolean createQuestion(int test_id, String question, String options, int correct_answer)throws ServiceException;
	
	public List <Question> showAllQuestions() throws ServiceException;
	

}
