package by.epam.tc.test.command.impl;

import java.util.List;


import by.epam.tc.test.bean.Request;
import by.epam.tc.test.bean.Response;
import by.epam.tc.test.bean.ShowAllQuestionsResponse;

import by.epam.tc.test.bean.ShowAllTestsResponse;
import by.epam.tc.test.command.Command;
import by.epam.tc.test.command.exception.CommandException;
import by.epam.tc.test.entity.Question;
import by.epam.tc.test.entity.Test;
import by.epam.tc.test.service.QuestionService;
import by.epam.tc.test.service.TestService;
import by.epam.tc.test.service.exception.ServiceException;
import by.epam.tc.test.service.factory.ServiceFactory;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class ShowAllQuestions implements Command{
	
	@Override
	public Response execute(Request request) throws CommandException {

		Request req = null;

		if (request instanceof Request) {
			req =  request;
		} else {
			throw new CommandException("Wrong request");
		}

		ShowAllQuestionsResponse response = new ShowAllQuestionsResponse ();
		
		List <Question> result = null;

		QuestionService questionService = ServiceFactory.getInstance().getQuestionService();

		try {
			result = questionService .showAllQuestions();
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			return response;
		}

		response.setQuestions(result);
		response.setErrorStatus(false);
		response.setResultMessage("Success!");

		return response;

	}
	

}
