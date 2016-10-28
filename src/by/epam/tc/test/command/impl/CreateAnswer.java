package by.epam.tc.test.command.impl;

import by.epam.tc.test.bean.CreateAnswerRequest;
import by.epam.tc.test.bean.CreateQuestionRequest;
import by.epam.tc.test.bean.Request;
import by.epam.tc.test.bean.Response;
import by.epam.tc.test.command.Command;
import by.epam.tc.test.command.exception.CommandException;
import by.epam.tc.test.service.AnswerService;
import by.epam.tc.test.service.QuestionService;
import by.epam.tc.test.service.exception.ServiceException;
import by.epam.tc.test.service.factory.ServiceFactory;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class CreateAnswer implements Command{
	
	@Override
	public Response execute(Request request) throws CommandException {
		
		CreateAnswerRequest req = null;

		if (request instanceof CreateAnswerRequest) {
			req = (CreateAnswerRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		Response response = new Response();

		int test_id = req.getTest_id();
		
		int users_id = req.getUsers_id();
		
		int mark= req.getMark();
		

		AnswerService answerService = ServiceFactory.getInstance().getAnswerService();


		try {
			answerService.createAnswer (test_id, users_id, mark);
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
