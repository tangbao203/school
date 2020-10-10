package org.example.common.inf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="message",url="${rpc.message:}")
public interface MessageService {
    @GetMapping("/message/notify/msg")
    String notifyMsg(@RequestParam("userId") String userId,@RequestParam("classId") String classId,@RequestParam("msg") String msg);
}
