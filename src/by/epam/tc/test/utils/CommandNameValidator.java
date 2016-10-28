package by.epam.tc.test.utils;

import java.util.ArrayList;

public class CommandNameValidator {

    private static ArrayList<String> commandNames = new ArrayList<String>() {
        {
            this.add("AUTHENTICATION");
            this.add("REGISTRATION");
            this.add("CREATE_ANSWER");
            this.add("CREATE_QUESTION");
            this.add("CREATE_TEST");
            this.add("SHOW_ALL_QUESTIONS");
            this.add("SHOW_ALL_TESTS");
            this.add("SHOW_ANSWERS");
            this.add("CHOOSE_TEST_TO_PASS");
            this.add("SHOW_ALL_USERS");
            this.add("BLOCK_USER");
            this.add("UNBLOCK_USER");
        }
    };

    public static boolean isValid(String commandName) {
        if(commandName == null) {
            return false;
        } else if(commandName.equals("")) {
            return false;
        } else if(!commandNames.contains(commandName)) {
            return false;
        }
        return true;
    }
}
