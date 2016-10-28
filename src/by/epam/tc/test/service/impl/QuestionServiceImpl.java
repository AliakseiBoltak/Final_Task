package by.epam.tc.test.service.impl;

import java.util.List;

import by.epam.tc.test.dao.QuestionDAO;
import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.dao.factory.DAOFactory;
import by.epam.tc.test.entity.Question;
import by.epam.tc.test.service.QuestionService;
import by.epam.tc.test.service.exception.ServiceException;
import by.epam.tc.test.utils.StringUtils;

/**
 * Created by Aliaksei Boltak on 27/10/2016.
 */

public class QuestionServiceImpl implements QuestionService {

	@Override
	public boolean createQuestion(int test_id, String question, String options, int correct_answer)
			throws ServiceException {
		if (!StringUtils.isValid(question) || !StringUtils.isValid(options)) {
			throw new ServiceException("Incorrect parametres");
		} else {
			QuestionDAO daoQuestion = DAOFactory.getInstance().getQuestionDAO();
			try {
				return (daoQuestion.createQuestion(test_id, question, options, correct_answer));
			} catch (DAOException e) {
				throw new ServiceException(e.getMessage());
			}
		}
	}

	@Override
	public List<Question> showAllQuestions() throws ServiceException {
		QuestionDAO daoQuestion = DAOFactory.getInstance().getQuestionDAO();
		try {
			return (daoQuestion.showAllQuestions());
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
