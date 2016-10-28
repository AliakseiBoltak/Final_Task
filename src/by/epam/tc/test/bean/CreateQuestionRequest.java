package by.epam.tc.test.bean;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class CreateQuestionRequest extends Request {

	private int test_id;
	private String question;
	private String options;
	private int correct_answer;

	public CreateQuestionRequest() {

	}

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public int getCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(int correct_answer) {
		this.correct_answer = correct_answer;
	}
	
	
	

}
