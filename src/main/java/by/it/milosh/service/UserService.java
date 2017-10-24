package by.it.milosh.service;

import by.it.milosh.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static List<User> users;

    public boolean findUserByUsername(String username) {
        boolean userExist = false;

        for (User user : users) {
            if (username.equals(user.getUsername())) {
                userExist = true;
            }
        }

        return userExist;
    }

    @PostConstruct
    private void initializingUsers() {

        this.users = new ArrayList<User>();

        User user1 = new User("u");
        User user2 = new User("us");
        User user3 = new User("use");
        User user4 = new User("user");
        User user5 = new User("user1");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

}
