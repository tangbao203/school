package org.example.common.inf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="book",url="${rpc.book:}")
public interface BookService {
    @GetMapping("/book/selectBook")
    String selectBook(@RequestParam("userId") String userId,@RequestParam("roomId") String roomId,@RequestParam("bookNo") String bookNo);
}
