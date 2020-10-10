package org.example.book.service;

import lombok.extern.slf4j.Slf4j;
import org.example.common.inf.BookService;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BookServiceImpl implements BookService {

    @Override
    public String selectBook(String userId, String roomId, String bookNo) {
        log.info("选择一个教材: userId:{},roomId:{},bookNo:{}",userId,roomId,bookNo);
        return String.valueOf(System.currentTimeMillis()).substring(5);
    }
}
