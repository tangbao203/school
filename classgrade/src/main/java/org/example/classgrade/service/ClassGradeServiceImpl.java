package org.example.classgrade.service;

import lombok.extern.slf4j.Slf4j;
import org.example.common.inf.ClassGradeService;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ClassGradeServiceImpl implements ClassGradeService {
    private int classId=0;

    @Override
    public String selectRoom(String userId, String classGrade) {
        log.info("选择一个房间, userId:{},classGrade:{}",userId,classGrade);
        classId++;
        return "No"+classId;
    }
}
