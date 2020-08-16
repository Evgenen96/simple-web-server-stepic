package accounts;

import dbService.DBException;
import dbService.DBService;


public class AccountService {

    private final DBService dbService;

    public AccountService(DBService dbService) {
        this.dbService = dbService;
    }

    public void signUp(String login, String password) {
        try {
            dbService.addUser(new UserProfile(login, password));
        } catch (DBException e) {
            System.out.println("Can't sing in: " + e.getMessage());
        }
    }

    public boolean signIn(String login, String password) {
        try {
            UserProfile profile = dbService.getUser(login);
            return profile != null && profile.getPassword().equals(password);
        } catch (DBException e) {
            System.out.println("Can't sing in: " + e.getMessage());
            return false;
        }
    }


}
