package by.epam.tc.test.controller;

import by.epam.tc.test.bean.Request;
import by.epam.tc.test.bean.Response;
import by.epam.tc.test.command.Command;
import by.epam.tc.test.command.exception.CommandException;
import by.epam.tc.test.utils.CommandNameValidator;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */

public class Controller {
	private CommandHelper helper = new CommandHelper();

	public Controller(){}

	public Response doRequest(Request request) {
		Response response = null;
		if(request != null && CommandNameValidator.isValid(request.getCommandName())) {

			String commandName = request.getCommandName();
			Command command = helper.getCommand(commandName);

			try {
				response = command.execute(request);
			} catch (CommandException e) {
				response = new Response();
				response.setErrorStatus(true);
				response.setErrorMessage("ERROR!");
			}
			return response;
		} else {
			response = new Response();
			response.setErrorMessage("BAD REQUEST!");
			response.setErrorStatus(true);
			return response;
		}
	}
}