package MessagesClientServer;

import java.io.Serializable;

public class InnerMessageSystemExistUserLogin implements InnerMessage, Serializable {

    private String login;
    private String password;

    private static final long serialVersionUID = 6529685098267757693L;

    public InnerMessageSystemExistUserLogin(String[] userData) {
        this.login = userData[0];
        this.password = userData[1];
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
