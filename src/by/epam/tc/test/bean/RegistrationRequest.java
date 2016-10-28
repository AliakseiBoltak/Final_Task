package by.epam.tc.test.bean;
/**
 * Created by Aliaksei Boltak on 26/10/2016.
 */

public class RegistrationRequest extends Request{

    private String login;
    private String password;

    public RegistrationRequest() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
