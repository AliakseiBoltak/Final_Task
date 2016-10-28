package by.epam.tc.test.command.impl;

import java.util.List;
import by.epam.tc.test.bean.Request;
import by.epam.tc.test.bean.Response;
import by.epam.tc.test.bean.ShowAllTestsResponse;
import by.epam.tc.test.bean.ShowAllUsersResponse;
import by.epam.tc.test.command.Command;
import by.epam.tc.test.command.exception.CommandException;
import by.epam.tc.test.entity.Test;
import by.epam.tc.test.entity.User;
import by.epam.tc.test.service.TestService;
import by.epam.tc.test.service.UserService;
import by.epam.tc.test.service.exception.ServiceException;
import by.epam.tc.test.service.factory.ServiceFactory;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class ShowAllUsers implements Command{

	@Override
	public Response execute(Request request) throws CommandException {
		
		Request req = null;

		if (request instanceof Request) {
			req =  request;
		} else {
			throw new CommandException("Wrong request");
		}

		ShowAllUsersResponse response = new ShowAllUsersResponse();
		List <User> result = null;

		UserService userService = ServiceFactory.getInstance().getUserService();

		try {
			result = userService.showAllUsers();
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			return response;
		}

		response.setUsers(result);
		response.setErrorStatus(false);
		response.setResultMessage("Success!");

		return response;

	
	}

}
