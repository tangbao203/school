package org.example.report.service;

import lombok.extern.slf4j.Slf4j;
import org.example.common.inf.ReportService;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ReportServiceImpl implements ReportService {

    @Override
    public void genReport(String userId, String classId, String record) {
        log.info("生产学习报告: userId:{}, classId:{}  record:{}",userId,classId,record);
    }
}
