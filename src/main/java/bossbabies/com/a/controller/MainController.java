package bossbabies.com.a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
@Controller
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    public String mainFunc(HttpServletRequest req) {
        logger.info("MainController mainFunc() " + new Date());
        req.getSession().setAttribute("loginId", "cde");
        return "/user/login";
    }
}
