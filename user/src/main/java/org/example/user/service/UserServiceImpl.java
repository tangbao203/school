package org.example.user.service;

import lombok.extern.slf4j.Slf4j;
import org.example.common.inf.UserService;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserServiceImpl implements UserService {

    @Override
    public String login(String username) {
        log.info("==用户登录 username:{}",username);
        return username.substring(0,1)+username.substring(username.length()-1)+"02311";
    }
}
