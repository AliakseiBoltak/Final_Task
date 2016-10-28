package by.epam.tc.test.command.impl;

import by.epam.tc.test.bean.BlockUserRequest;
import by.epam.tc.test.bean.Request;
import by.epam.tc.test.bean.Response;
import by.epam.tc.test.bean.UnBlockUserRequest;
import by.epam.tc.test.command.Command;
import by.epam.tc.test.command.exception.CommandException;
import by.epam.tc.test.service.UserService;
import by.epam.tc.test.service.exception.ServiceException;
import by.epam.tc.test.service.factory.ServiceFactory;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class UnBlockUser implements Command{

	@Override
	public Response execute(Request request) throws CommandException {
		
		UnBlockUserRequest req = null;

		if (request instanceof UnBlockUserRequest ) {
			req = (UnBlockUserRequest ) request;
		} else {
			throw new CommandException("Wrong request");
		}

		Response response = new Response();

		String id = req.getUserId();

		UserService userService = ServiceFactory.getInstance().getUserService();

		try {
			userService.unBlockUser (id);
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
