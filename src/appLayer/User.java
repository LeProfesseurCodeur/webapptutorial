package appLayer;

public class User {

    public boolean isValidUserCredentials(String sUserName, String sUserPassword) {
        if(sUserName.equals("dylan.luchmun@epitech.eu") && sUserPassword.equals("test")) {
            return true;
        }
        return false;
    }
}
