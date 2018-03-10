package user;

public class UserBuilder {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        return new User(this);
    }
}
