package by.it.milosh.controllers;

import by.it.milosh.model.Response;
import by.it.milosh.model.User;
import by.it.milosh.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWebController {

    UserService userService = new UserService();

    @PostMapping(value = "/getResponse")
    public Response postCustomer(@RequestBody User user) {

        boolean userExist = userService.findUserByUsername(user.getUsername());
        String message;

        if (userExist) {
            message = "true";
        } else {
            message = "false";
        }

        Response response = new Response("message", message);
        return response;
    }

}
