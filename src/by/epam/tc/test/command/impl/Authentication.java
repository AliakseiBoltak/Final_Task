package by.epam.tc.test.command.impl;

import by.epam.tc.test.bean.AuthenticationRequest;
import by.epam.tc.test.bean.AuthenticationResponse;
import by.epam.tc.test.bean.Request;
import by.epam.tc.test.bean.Response;
import by.epam.tc.test.command.Command;
import by.epam.tc.test.command.exception.CommandException;
import by.epam.tc.test.entity.User;
import by.epam.tc.test.service.UserService;
import by.epam.tc.test.service.exception.ServiceException;
import by.epam.tc.test.service.factory.ServiceFactory;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class Authentication implements Command {
	
    @Override
    public Response execute(Request request) throws CommandException {
        AuthenticationRequest req = null;

        if(request instanceof AuthenticationRequest) {
            req = (AuthenticationRequest) request;
        } else {
            throw new CommandException("Wrong request");
        }

        AuthenticationResponse response = new AuthenticationResponse();

        String login = req.getLogin();
        String password = req.getPassword();

        UserService userService = ServiceFactory.getInstance().getUserService();

        User currentUser = null;

        try {
            currentUser = userService.logination(login, password);
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());
            return response;
        }

        if(currentUser == null) {
            response.setErrorStatus(true);
            response.setErrorMessage("Authentication error, user does not exist!");
            return response;
        } else {
            response.setErrorStatus(false);
            response.setResultMessage("Success");
            response.setUser(currentUser);
            return response;
        }
    }
}
