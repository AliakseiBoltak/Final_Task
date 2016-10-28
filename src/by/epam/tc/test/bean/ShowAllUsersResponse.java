package by.epam.tc.test.bean;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

import java.util.List;

import by.epam.tc.test.entity.User;

public class ShowAllUsersResponse extends Response{
	
	private List <User> users = null;

    public List <User> getUsers() {
        return users;
    }

    public void setUsers(List <User> users) {
        this.users = users;
	
    }
}
