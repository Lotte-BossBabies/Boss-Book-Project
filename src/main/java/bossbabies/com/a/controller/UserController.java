package bossbabies.com.a.controller;

import bossbabies.com.a.dto.user.MemberDto;
import bossbabies.com.a.dto.user.SellerDto;
import bossbabies.com.a.parameterVO.LoginVO;
import bossbabies.com.a.service.MemberService;
import bossbabies.com.a.service.SellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    MemberService memberService;

    @Autowired
    SellerService sellerService;


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
    public String regiMember(MemberDto memberDto){
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
    @RequestMapping(value = "regiSeller.do", method = RequestMethod.GET)
    public String regiSeller(SellerDto sellerDto){
        logger.info("UserController regiSeller() " + new Date());
        String id = sellerDto.getId();
        String password = sellerDto.getPassword();
        String name = sellerDto.getName();
        String email = sellerDto.getEmail();
        String phone = sellerDto.getPhone();
        String store = sellerDto.getStore_name();
        SellerDto insertDto = new SellerDto(id, password, name, email, phone, store);
        System.out.println("Dto = " + insertDto);
        int count = sellerService.regiSeller(insertDto);
        String msg = "NO";
        if(count > 0){
            msg = "OK";
        }
        System.out.println("msg = " + msg);
        return "/user/login";
    }
    @RequestMapping(value = "loginAf.do", method = RequestMethod.GET)
    public String loginAf(HttpServletRequest req) throws IOException {
        logger.info("UserController loginAf()" + new Date());
        String msg = "loginFail";
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        LoginVO vo = new LoginVO(id, password);
        MemberDto member = memberService.loginMember(vo);
        System.out.println("member = "  + member);
        System.out.println("vo = " +  vo);

        if(member != null && !member.getId().equals("")){
            msg = "loginSuccess";
        }

        SellerDto seller = sellerService.loginSeller(vo);

        if(seller != null && !seller.getId().equals("")){
            msg = "loginSuccess";
        }

        System.out.println(msg);

        req.getSession().setAttribute("login", id);
        if (msg.equals("loginSuccess")) {
            return "/user/temp";
        } else {
            return "/user/loginFail";
        }
    }

    @RequestMapping(value = "updateUser.do", method = RequestMethod.GET)
    public String updateUser(HttpServletRequest req, Model model){
        String id = (String)req.getSession().getAttribute("login");
        System.out.println("updateUser = " + id);
        logger.info("UserController updateUser()" + new Date());
        MemberDto member= memberService.getMember(id);
        if(member != null && !member.getId().equals("")){
            model.addAttribute("member", member);
            return "/user/updateMember";
        }
        else{
            SellerDto seller = sellerService.getSeller(id);
            model.addAttribute("seller", seller);
            return "/user/updateSeller";
        }
    }



}
