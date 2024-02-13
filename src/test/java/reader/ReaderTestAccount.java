package reader;

public enum ReaderTestAccount {


    testUserCredentials(System.getProperty("username"),System.getProperty("password"));

    private final String username;
    private final String password;

    ReaderTestAccount(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
