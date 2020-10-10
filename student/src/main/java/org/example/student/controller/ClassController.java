package org.example.student.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.common.config.Constant;
import org.example.common.inf.BookService;
import org.example.common.inf.ClassGradeService;
import org.example.common.inf.TeachingService;
import org.example.common.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/class")
@RestController
public class ClassController {
    @Autowired
    private UserService userService;
    @Autowired
    private ClassGradeService classGradeService;
    @Autowired
    private BookService bookService;
    @Autowired
    private TeachingService teachingService;

    @GetMapping("/begin")
    public String begin(String username,String classGrade,String bookNo){
        log.info(">>>>开始登录啦～～～");
        //登录
        Object userInfo=userService.login(username);
        if(userInfo==null)
            return Constant.fail;
        log.info("===请求 user->login服务成功  username:{}, 返回:{}",username,userInfo);

        //选择班级
        String userId=(String)userInfo;
        String roomId=classGradeService.selectRoom(userId,classGrade);
        if(roomId==null)
            return  Constant.fail;
        log.info("===请求 classGrade->selectRoom服务成功  userId:{},classGrade:{} 返回:{}",userId,classGrade,roomId);

        //选择教材
        String classId=bookService.selectBook(userId,roomId,bookNo);
        if(roomId==null)
            return  Constant.fail;
        log.info("===请求 book->selectBook服务成功  userId:{},roomId:{},bookNo:{} 返回:{}",userId,roomId,bookNo,classId);

        //准备上课了
        return teachingService.start(userId,classId);
    }
}
