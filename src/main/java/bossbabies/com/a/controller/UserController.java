package bossbabies.com.a.controller;

import bossbabies.com.a.service.KakaoService;
import bossbabies.com.a.service.UserService;
import bossbabies.com.a.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    @RequestMapping(value = "userSelect.do", method = RequestMethod.GET)
    public String userSelect() {
        logger.info("UserController userSelect() " + new Date());

        return "/user/userSelect.jsp";
    }
    @RequestMapping(value = "memberRegi.do", method = RequestMethod.GET)
    public String commonRegi() {
        logger.info("UserController memberRegi() " + new Date());

        return "/user/memberRegi.jsp";
    }
    @RequestMapping(value = "sellerRegi.do", method = RequestMethod.GET)
    public String sellerRegi() {
        logger.info("UserController sellerRegi() " + new Date());

        return "/user/sellerRegi.jsp";
    }

}
