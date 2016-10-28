package by.epam.tc.test.command.impl;

import java.util.List;

import by.epam.tc.test.bean.ChooseTestToPassRequest;
import by.epam.tc.test.bean.ChooseTestToPassResponse;
import by.epam.tc.test.bean.Request;
import by.epam.tc.test.bean.Response;
import by.epam.tc.test.command.Command;
import by.epam.tc.test.command.exception.CommandException;
import by.epam.tc.test.entity.Question;
import by.epam.tc.test.service.UserService;
import by.epam.tc.test.service.exception.ServiceException;
import by.epam.tc.test.service.factory.ServiceFactory;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class ChooseTestToPass implements Command{

	@Override
	public Response execute(Request request) throws CommandException {
		
		ChooseTestToPassRequest req = null;

		if (request instanceof ChooseTestToPassRequest ) {
			req = (ChooseTestToPassRequest ) request;
		} else {
			throw new CommandException("Wrong request");
		}

		ChooseTestToPassResponse response = new ChooseTestToPassResponse();
		
		List   <Question> result = null;
		
		int test_id=req.getTestId();

		UserService userService = ServiceFactory.getInstance().getUserService();

		try {
			result = userService.chooseTestToPass(test_id);
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
