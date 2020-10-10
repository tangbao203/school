package org.example.common.inf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="teaching",url="${rpc.teaching:}")
public interface TeachingService {
    @GetMapping("/teaching/start")
    String start(@RequestParam("userId") String userId,@RequestParam("classId") String classId);
}
