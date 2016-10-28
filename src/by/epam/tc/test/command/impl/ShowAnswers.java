package by.epam.tc.test.command.impl;

import java.util.List;

import by.epam.tc.test.bean.Request;
import by.epam.tc.test.bean.Response;
import by.epam.tc.test.bean.ShowAllTestsResponse;
import by.epam.tc.test.bean.ShowAnswersRequest;
import by.epam.tc.test.bean.ShowAnswersResponse;
import by.epam.tc.test.command.Command;
import by.epam.tc.test.command.exception.CommandException;
import by.epam.tc.test.entity.Answer;
import by.epam.tc.test.entity.Test;
import by.epam.tc.test.service.AnswerService;
import by.epam.tc.test.service.TestService;
import by.epam.tc.test.service.exception.ServiceException;
import by.epam.tc.test.service.factory.ServiceFactory;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class ShowAnswers implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		
		ShowAnswersRequest req = null;

		if (request instanceof ShowAnswersRequest) {
			req = (ShowAnswersRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		ShowAnswersResponse response = new ShowAnswersResponse ();
		
		List <Answer> result = null;
		
		int users_id = req.getUserId();

		AnswerService answerService = ServiceFactory.getInstance().getAnswerService();

		try {
			result = answerService.showAnswersByUsersId(users_id);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			return response;
		}

		response.setAnswers(result);
		response.setErrorStatus(false);
		response.setResultMessage("Success!");

		return response;

	}
}
