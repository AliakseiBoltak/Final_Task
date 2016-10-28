package by.epam.tc.test.controller;


import java.util.HashMap;
import java.util.Map;

import by.epam.tc.test.command.Command;
import by.epam.tc.test.command.impl.Authentication;
import by.epam.tc.test.command.impl.BlockUser;
import by.epam.tc.test.command.impl.ChooseTestToPass;
import by.epam.tc.test.command.impl.CreateAnswer;
import by.epam.tc.test.command.impl.CreateQuestion;
import by.epam.tc.test.command.impl.CreateTest;
import by.epam.tc.test.command.impl.Registration;
import by.epam.tc.test.command.impl.ShowAllQuestions;
import by.epam.tc.test.command.impl.ShowAllTests;
import by.epam.tc.test.command.impl.ShowAllUsers;
import by.epam.tc.test.command.impl.ShowAnswers;
import by.epam.tc.test.command.impl.UnBlockUser;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */

public class CommandHelper {

	private Map<String, Command> commands = new HashMap<String, Command>();

	public CommandHelper() {
		commands.put("AUTHENTICATION", new Authentication());
		commands.put("REGISTRATION", new Registration());
		commands.put("CREATE_ANSWER", new CreateAnswer());
		commands.put("CREATE_QUESTION", new CreateQuestion());
		commands.put("CREATE_TEST", new CreateTest());
		commands.put("SHOW_ALL_QUESTIONS", new ShowAllQuestions());
		commands.put("SHOW_ALL_TESTS", new ShowAllTests());
		commands.put("SHOW_ANSWERS", new ShowAnswers());
		commands.put("CHOOSE_TEST_TO_PASS", new ChooseTestToPass());
		commands.put("SHOW_ALL_USERS", new ShowAllUsers());
		commands.put("BLOCK_USER", new BlockUser());
		commands.put("UNBLOCK_USER", new UnBlockUser());
		
		
	}

	
	public Command getCommand(String commandName) {
		Command command;

		command = commands.get(commandName);

		return command;

	}

}
