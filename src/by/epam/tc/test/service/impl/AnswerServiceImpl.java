package by.epam.tc.test.service.impl;

import java.util.List;

import by.epam.tc.test.dao.AnswerDAO;
import by.epam.tc.test.dao.QuestionDAO;
import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.dao.factory.DAOFactory;
import by.epam.tc.test.entity.Answer;
import by.epam.tc.test.service.AnswerService;
import by.epam.tc.test.service.exception.ServiceException;
import by.epam.tc.test.utils.StringUtils;

/**
 * Created by Aliaksei Boltak on 27/10/2016.
 */

public class AnswerServiceImpl implements AnswerService {

	@Override
	public boolean createAnswer(int test_id, int users_id, int mark) throws ServiceException {
		AnswerDAO daoAnswer = DAOFactory.getInstance().getAnswerDAO();
		try {
			return (daoAnswer.createAnswer(test_id, users_id, mark));
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List <Answer> showAnswersByUsersId (int users_id) throws ServiceException {
		AnswerDAO daoAnswer = DAOFactory.getInstance().getAnswerDAO();
		try {
			return (daoAnswer.showAnswersByUsersId(users_id));
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

}
