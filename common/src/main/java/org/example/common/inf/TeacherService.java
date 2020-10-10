package org.example.common.inf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="teacher",url="${rpc.teacher:}")
public interface TeacherService {
    @GetMapping("/teacher/receive/msg")
    String receiveMsg(@RequestParam("userId") String userId,@RequestParam("classId") String classId,@RequestParam("msg") String msg);
}
