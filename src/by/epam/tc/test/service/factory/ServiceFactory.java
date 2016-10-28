package by.epam.tc.test.service.factory;

import by.epam.tc.test.service.AnswerService;
import by.epam.tc.test.service.QuestionService;
import by.epam.tc.test.service.TestService;
import by.epam.tc.test.service.UserService;
import by.epam.tc.test.service.impl.AnswerServiceImpl;
import by.epam.tc.test.service.impl.QuestionServiceImpl;
import by.epam.tc.test.service.impl.TestServiceImpl;
import by.epam.tc.test.service.impl.UserServiceImpl;

/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class ServiceFactory {

	private static final ServiceFactory INSTANCE = new ServiceFactory();

	private static final UserService userService = new UserServiceImpl();
	
	private static final TestService testService = new TestServiceImpl();
	
	private static final AnswerService answerService = new AnswerServiceImpl();
	
	private static final QuestionService questionService = new QuestionServiceImpl();
	
	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return INSTANCE;
	}

	public UserService getUserService() {
		return userService;
	}
	
	public TestService getTestService() {
		return testService;
	}
	
	public QuestionService getQuestionService() {
		return questionService;
	}
	
	public AnswerService getAnswerService() {
		return answerService;
	}
}
