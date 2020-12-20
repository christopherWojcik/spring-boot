package pl.wojcik.restapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.wojcik.restapi.config.LoginCredentials;

/*
    In Spring Security is also by default enable endpoint: "/login".
    Created for Swagger usage.
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials credentials){

    }
}
