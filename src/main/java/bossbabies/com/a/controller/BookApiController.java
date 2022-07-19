package bossbabies.com.a.controller;

import bossbabies.com.a.service.BookApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

import java.text.ParseException;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]도서 api 데이터 insert/select
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.18       김혜연         신규생성
 * -----------------------------------------------------------
 */
@Controller
public class BookApiController {
    @Autowired
    BookApiServiceImpl service;

//    @RequestMapping("/main.do")
//    public String insertData() throws IOException, ParseException {
//
//        boolean api = service.insertData();
//
//        if (!api) {
//            return "book/main";
//        }
//
//        return "book/main";
//    }
}
