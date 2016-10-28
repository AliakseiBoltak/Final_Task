package by.epam.tc.test.bean;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

import java.util.List;

import by.epam.tc.test.entity.Answer;

public class ShowAnswersResponse extends Response{
	
	private List <Answer> answers= null;
    private int userId;

    public List <Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List <Answer> answers) {
        this.answers = answers;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
