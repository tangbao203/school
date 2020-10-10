package org.example.teacher.service;

import lombok.extern.slf4j.Slf4j;
import org.example.common.inf.ReportService;
import org.example.common.inf.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RestController
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private ReportService reportService;
    private Map<String,String> record=new ConcurrentHashMap<>();

    @Override
    public String receiveMsg(String userId, String classId, String msg) {
        log.info("收到消息: userId:{},classId:{},msg:{}",userId,classId,msg);
        record.put(userId+"_"+classId,msg);
        return "我已经准备好上课啦";
    }

    /**
     * 汇总学习报告
     */
    @Scheduled(cron = "0 50 * * * ?")
    public void studyReport(){
        for(Map.Entry<String,String> entry:record.entrySet()) {
            String[] args=entry.getKey().split("_");
            reportService.genReport(args[0],args[1],entry.getValue());
        }
    }
}
