package bossbabies.com.a.controller;

import bossbabies.com.a.dto.user.MemberDto;
import bossbabies.com.a.service.MemberService;
import bossbabies.com.a.service.SellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    MemberService memberService;

//    @Autowired
//    SellerService sellerService;


    @RequestMapping(value = "userSelect.do", method = RequestMethod.GET)
    public String userSelect() {
        logger.info("UserController userSelect() " + new Date());

        return "/user/userSelect";
    }
    @RequestMapping(value = "memberRegi.do", method = RequestMethod.GET)
    public String commonRegi() {
        logger.info("UserController memberRegi() " + new Date());

        return "/user/memberRegi";
    }
    @RequestMapping(value = "sellerRegi.do", method = RequestMethod.GET)
    public String sellerRegi() {
        logger.info("UserController sellerRegi() " + new Date());

        return "/user/sellerRegi";
    }

    @RequestMapping(value = "regiMember.do", method = RequestMethod.GET)
    public String regiMember(MemberDto memberDto, HttpServletRequest req){
        logger.info("UserController regiMember() " + new Date());
        String id = memberDto.getId();
        String password = memberDto.getPassword();
        String name = memberDto.getName();
        String email = memberDto.getEmail();
        String phone = memberDto.getPhone();
        String address = memberDto.getAddress();
        MemberDto insertDto = new MemberDto(id, password, name, email, phone, address);
        System.out.println("Dto = " + insertDto);
        int count = memberService.regiMember(insertDto);
        String msg = "NO";
        if(count > 0){
            msg = "OK";
        }
        System.out.println("msg = " + msg);
        return "/user/login";
    }


}
