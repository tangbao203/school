package org.example.common.inf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="classGrade",url="${rpc.classGrade:}")
public interface ClassGradeService {
    @GetMapping("/classGrade/selectRoom")
    String selectRoom(@RequestParam("userId") String userId,@RequestParam("classGrade") String classGrade);
}
