package by.epam.tc.test.command;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */

import by.epam.tc.test.bean.Request;
import by.epam.tc.test.bean.Response;
import by.epam.tc.test.command.exception.CommandException;

public interface Command {
	Response execute(Request request) throws CommandException;
}
