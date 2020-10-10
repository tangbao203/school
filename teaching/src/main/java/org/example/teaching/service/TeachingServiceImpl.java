package org.example.teaching.service;

import lombok.extern.slf4j.Slf4j;
import org.example.common.inf.MessageService;
import org.example.common.inf.TeachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TeachingServiceImpl implements TeachingService {
    @Autowired
    private MessageService messageService;
    @Value("${version}")
    private String version;

    @Override
    public String start(String userId, String classId) {
        log.info("current version: "+version);
        return messageService.notifyMsg(userId,classId,"我要上课");
    }
}
