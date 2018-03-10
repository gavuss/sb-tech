package user;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public class User {

    private String name;
    private String password;

    public User() {
    }

    public User(UserBuilder builder) {
        this.name = builder.getName();
        this.password = builder.getPassword();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public User generateName(int leigh, List<String> blackName) {
        String eggName = randomAlphanumeric(leigh);
        if (blackName.contains(eggName)) {
            generateName(leigh, blackName);
        }
        name = eggName;
        return this;
    }

    public User generatePass(int leigh) {
        this.password = randomAlphanumeric(leigh);
        return this;
    }

    private String randomAlphanumeric(int leigh) {
        return RandomStringUtils.randomAlphanumeric(leigh);
    }


}
