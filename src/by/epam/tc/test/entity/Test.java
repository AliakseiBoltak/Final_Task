package by.epam.tc.test.entity;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */

public class Test {
	private int id;
	private String subject;
	
	public Test(String subject){
		this.subject=subject;
	}
	
	public Test(int id, String subject){
		this.id=id;
		this.subject=subject;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		Test other = (Test) obj;
		if (id != other.id)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", subject=" + subject + "]";
	}
	
	
	

}
