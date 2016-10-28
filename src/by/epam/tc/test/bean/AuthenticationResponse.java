package by.epam.tc.test.bean;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

import by.epam.tc.test.entity.User;

public class AuthenticationResponse extends Response {

    private User user;

    public AuthenticationResponse() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
