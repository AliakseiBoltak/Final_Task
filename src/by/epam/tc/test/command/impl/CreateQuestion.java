package by.epam.tc.test.command.impl;

import by.epam.tc.test.bean.CreateQuestionRequest;
import by.epam.tc.test.bean.Request;
import by.epam.tc.test.bean.Response;
import by.epam.tc.test.command.Command;
import by.epam.tc.test.command.exception.CommandException;
import by.epam.tc.test.service.QuestionService;
import by.epam.tc.test.service.exception.ServiceException;
import by.epam.tc.test.service.factory.ServiceFactory;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class CreateQuestion implements Command{
	
	@Override
	public Response execute(Request request) throws CommandException {
		
		CreateQuestionRequest req = null;

		if (request instanceof CreateQuestionRequest) {
			req = (CreateQuestionRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		Response response = new Response();

		int test_id = req.getTest_id();
		
		String question=req.getQuestion();
		
		String options =req.getOptions();
		
		int correct_answer= req.getCorrect_answer();
		

		QuestionService questionService = ServiceFactory.getInstance().getQuestionService();


		try {
			questionService.createQuestion (test_id, question, options ,correct_answer);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			return response;
		}


			response.setErrorStatus(false);
			response.setResultMessage("Success");
			return response;
		
	}

}
