package accounts;

public class UserProfile {
    private final String name;
    private final String password;

    public UserProfile(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserProfile(String name) {
        this.name = name;
        this.password = name;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
