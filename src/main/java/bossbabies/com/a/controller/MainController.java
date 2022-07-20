package bossbabies.com.a.controller;

import bossbabies.com.a.service.BookApiServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]도서 api 데이터 insert/select
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.18       최규진         신규생성
 * 2022.07.19       김혜연         api 연결
 * -----------------------------------------------------------
 */
@Controller
public class MainController {

    @Autowired
    BookApiServiceImpl service;
    Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/main.do")
    public String insertData() throws IOException, ParseException {

        boolean api = service.insertData();

        if (!api) {
            return "book/main";
        }

        return "book/main";
    }

    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    public String mainFunc(HttpServletRequest req) {
        logger.info("MainController mainFunc() " + new Date());
        req.getSession().setAttribute("loginId", "cde");
        return "/user/login";
    }
}
