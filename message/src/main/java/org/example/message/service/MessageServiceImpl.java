package org.example.message.service;

import org.example.common.inf.MessageService;
import org.example.common.inf.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageServiceImpl implements MessageService {
    @Autowired
    private TeacherService teacherService;

    @Override
    public String notifyMsg(String userId, String classId, String msg) {
        return teacherService.receiveMsg(userId,classId,msg);
    }
}
