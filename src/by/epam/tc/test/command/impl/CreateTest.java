package by.epam.tc.test.command.impl;

import by.epam.tc.test.bean.CreateTestRequest;
import by.epam.tc.test.bean.Request;
import by.epam.tc.test.bean.Response;
import by.epam.tc.test.command.Command;
import by.epam.tc.test.command.exception.CommandException;
import by.epam.tc.test.service.TestService;
import by.epam.tc.test.service.exception.ServiceException;
import by.epam.tc.test.service.factory.ServiceFactory;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class CreateTest implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		
		CreateTestRequest req = null;

		if (request instanceof CreateTestRequest) {
			req = (CreateTestRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}

		Response response = new Response();

		String subject = req.getSubject();

		TestService testService = ServiceFactory.getInstance().getTestService();


		try {
			testService.createTest (subject);
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
