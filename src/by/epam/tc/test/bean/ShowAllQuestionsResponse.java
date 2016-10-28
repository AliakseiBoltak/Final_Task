package by.epam.tc.test.bean;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

import java.util.List;
import by.epam.tc.test.entity.Question;

public class ShowAllQuestionsResponse extends Response{

	
	private List<Question> questions = null;

    public List <Question> getQuestions() {
        return questions;
    }

    public void setQuestions (List<Question> questions) {
        this.questions = questions;
    }
}
