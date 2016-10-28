package by.epam.tc.test.entity;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */


public class Question {
	
	private int id;
	private int test_id;
	private String question;
	private String options;
	private int correct_answer;
	
	
	public Question (int test_id, String question , String options, int correct_answer){
		this.test_id=test_id;
		this.question=question;
		this.options=options;
		this.correct_answer=correct_answer;
	}

	
	public Question (int id, int test_id, String question , String options, int correct_answer){
		this.id=id;
		this.test_id=test_id;
		this.question=question;
		this.options=options;
		this.correct_answer=correct_answer;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + correct_answer;
		result = prime * result + id;
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + test_id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (correct_answer != other.correct_answer)
			return false;
		if (id != other.id)
			return false;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (test_id != other.test_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Question [id=" + id + ", test_id=" + test_id + ", question=" + question + ", options=" + options
				+ ", correct_answer=" + correct_answer + "]";
	}
}
