package by.epam.tc.test.entity;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */

public class Answer {
	
	private int id;
	private int test_id;
	private int users_id;
	private int mark;
	
	public Answer (int test_id, int users_id, int mark){
		this.test_id=test_id;
		this.users_id=users_id;
		this.mark=mark;
	}
	
	public Answer (int id,int test_id, int users_id, int mark){
		this.id=id;
		this.test_id=test_id;
		this.users_id=users_id;
		this.mark=mark;
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

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + mark;
		result = prime * result + test_id;
		result = prime * result + users_id;
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
		Answer other = (Answer) obj;
		if (id != other.id)
			return false;
		if (mark != other.mark)
			return false;
		if (test_id != other.test_id)
			return false;
		if (users_id != other.users_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", test_id=" + test_id + ", users_id=" + users_id + ", mark=" + mark + "]";
	}
	
	
	

}
