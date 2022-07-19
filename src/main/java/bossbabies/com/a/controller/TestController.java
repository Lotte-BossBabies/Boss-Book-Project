package bossbabies.com.a.controller;

import bossbabies.com.a.dto.TestDto;
import bossbabies.com.a.service.TestService;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestService service;

    @RequestMapping(value = "test.do", method = RequestMethod.GET)
    public String getMember(Model model) {
        logger.info("TestController getMember()" + new Date());

        List<TestDto> dto = service.getMember();
        model.addAttribute("member", dto);

        return "test";
    }
}
