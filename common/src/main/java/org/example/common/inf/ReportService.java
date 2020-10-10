package org.example.common.inf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="report",url="${rpc.report:}")
public interface ReportService {
    @GetMapping("/report/gen")
    void genReport(@RequestParam("userId") String userId, @RequestParam("classId") String classId,@RequestParam("record") String record);
}
