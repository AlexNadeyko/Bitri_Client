package MessagesClientServer;

import java.io.Serializable;

public class InnerMessageSystemAddUserSignUp implements InnerMessage, Serializable {

    private String login;
    private String password;
    private String name;
    private String surname;

    private static final long serialVersionUID = 6529685098267757691L;

    public InnerMessageSystemAddUserSignUp(String[] userData){
        name = userData[0];
        surname = userData[1];
        login = userData[2];
        password = userData[3];
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
