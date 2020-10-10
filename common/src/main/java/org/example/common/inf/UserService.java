package org.example.common.inf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="user",url="${rpc.user:}")
public interface UserService {
    @GetMapping("/user/login")
    String login(@RequestParam("username") String username);
}
