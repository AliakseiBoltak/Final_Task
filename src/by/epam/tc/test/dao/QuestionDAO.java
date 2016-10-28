package by.epam.tc.test.dao;
import java.util.List;

import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.entity.Question;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */
public interface QuestionDAO {
	
	public boolean createQuestion(int test_id, String question, String options, int correct_answer)throws DAOException;
	
	public List <Question> showAllQuestions() throws DAOException;
	
}
