package pl.korwel.controller;

import pl.korwel.model.Privilege;
import pl.korwel.model.UserInfo;
import pl.korwel.service.PrivilegeService;
import pl.korwel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    private UserInfo registerUser(@RequestBody UserInfo userInfo) {
        Privilege privilege = privilegeService.getByName("ROLE_USER");
        if(privilege != null) {
            userInfo.getPrivileges().add(privilege);
        }
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userService.addNew(userInfo);
        return userInfo;
    }
}
