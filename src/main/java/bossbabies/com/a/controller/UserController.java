package bossbabies.com.a.controller;

import bossbabies.com.a.dto.user.MemberDto;
import bossbabies.com.a.dto.user.SellerDto;
import bossbabies.com.a.parameterVO.*;
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
import java.util.Map;

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
    public String commonRegi(String email, Model model) {
        logger.info("UserController memberRegi() " + new Date());
        model.addAttribute("email", email);
        return "/user/memberRegi";
    }
    @RequestMapping(value = "sellerRegi.do", method = RequestMethod.GET)
    public String sellerRegi(String email, Model model) {
        logger.info("UserController sellerRegi() " + new Date());
        model.addAttribute("email", email);

        return "/user/sellerRegi";
    }

    @RequestMapping(value = "regiMember.do", method = RequestMethod.GET)
    public String regiMember(MemberDto memberDto){
        logger.info("UserController regiMember() " + new Date());
        int member_id = memberDto.getMember_id();
        System.out.println(member_id);
        String id = memberDto.getId();
        String password = memberDto.getPassword();
        String name = memberDto.getName();
        String email = memberDto.getEmail();
        String phone = memberDto.getPhone();
        String address = memberDto.getAddress();
        MemberDto insertDto = new MemberDto(member_id, id, password, name, email, address, phone);
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
        int seller_id = sellerDto.getSeller_id();
        String id = sellerDto.getId();
        String password = sellerDto.getPassword();
        String name = sellerDto.getName();
        String email = sellerDto.getEmail();
        String phone = sellerDto.getPhone();
        String store = sellerDto.getStore_name();
        SellerDto insertDto = new SellerDto(seller_id, id, password, name, email, phone, store);
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
        String userType = "";
        LoginVO vo = new LoginVO(id, password);
        MemberDto member = memberService.loginMember(vo);
        System.out.println("member = "  + member);
        System.out.println("vo = " +  vo);

        if(member != null && !member.getId().equals("")){
            userType = "member";
            msg = "loginSuccess";
        }

        SellerDto seller = sellerService.loginSeller(vo);

        if(seller != null && !seller.getId().equals("")){
            userType = "seller";
            msg = "loginSuccess";
        }
        System.out.println("seller = "  + seller);
        System.out.println("vo = " +  vo);
        System.out.println("userType = " + userType);
        System.out.println(msg);
        if(userType.equals("member")) {
            System.out.println("member");
            req.getSession().setAttribute("login", member);
        }
        else if(userType.equals("seller")){
            System.out.println("seller");
            req.getSession().setAttribute("login", seller);
        }
        req.getSession().setAttribute("userType", userType);
        if (msg.equals("loginSuccess")) {
            return "/user/temp";
        } else {
            return "/user/loginFail";
        }
    }

    @RequestMapping(value = "updateUser.do", method = RequestMethod.GET)
    public String updateUser(HttpServletRequest req, Model model){
        Object user = req.getSession().getAttribute("login");
        if(user.getClass().equals(MemberDto.class)){
            model.addAttribute("member", user);
            return "/user/updateMember";
        }
        else{
            model.addAttribute("seller", user);
            return "/user/updateSeller";
        }
        /*
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
         */
    }
    @RequestMapping(value = "updateMember.do", method = RequestMethod.GET)
    public String updateMember(HttpServletRequest req){
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String id = req.getParameter("id");
        UpdateMemberVO vo = new UpdateMemberVO(password, address, phone, id);
        System.out.println(vo);
        int updateMember = memberService.updateMember(vo);
        System.out.println(updateMember);
        String msg = "updateFail";
        if(updateMember > 0){
            msg = "updateSuccess";
        }
        System.out.println(msg);
        return "user/login";
    }
    @RequestMapping(value = "updateSeller.do", method = RequestMethod.GET)
    public String updateSeller(HttpServletRequest req){
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String store_name = req.getParameter("store_name");
        String id = req.getParameter("id");
        UpdateSellerVO vo = new UpdateSellerVO(password, store_name, phone, id);
        System.out.println(vo);
        int updateSeller = sellerService.updateSeller(vo);
        System.out.println(updateSeller);
        String msg = "updateFail";
        if(updateSeller > 0){
            msg = "updateSuccess";
        }
        System.out.println(msg);
        return "user/login";
    }

    @RequestMapping(value = "findId.do", method = RequestMethod.GET)
    public String findId(HttpServletRequest req, Model model){
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        FindIdVO find = new FindIdVO(name, email);
        System.out.println(find);
        String msg = "findIdFail";

        String id = memberService.findMemberId(find);
        if(id != null){
            model.addAttribute("id", id);
            msg = "findIdSuccess";
            System.out.println(msg + id);
            return "user/findIdOk";
        }
        id = sellerService.findSellerId(find);
        if(id != null){
            model.addAttribute("id", id);
            msg = "findIdSuccess";
            System.out.println(msg + id);
            return "user/findIdOk";
        }

        System.out.println(msg + id);
        return "user/findId";

    }
    @RequestMapping(value = "findPassword.do", method = RequestMethod.GET)
    public String findPassword(HttpServletRequest req, Model model){
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        FindPasswordVO find = new FindPasswordVO(id, name, email);
        System.out.println(find);
        String msg = "findIdFail";

        String password = memberService.findMemberPassword(find);
        if(password != null){
            model.addAttribute("password", password);
            msg = "findIdSuccess";
            System.out.println(msg + password);
            return "user/findPasswordOk";
        }
        password = sellerService.findSellerPassword(find);
        if(password != null){
            model.addAttribute("password", password);
            msg = "findIdSuccess";
            System.out.println(msg + password);
            return "user/findPasswordOk";
        }

        System.out.println(msg + password);
        return "user/findPassword";

    }
    @RequestMapping(value = "duplicateId.do", method = RequestMethod.GET)
    @ResponseBody
    public String duplicateId(@RequestParam Map<String, Object> map){
        String msg = "";
        String id = (String)map.get("user_id");
        String dupId = memberService.memberDuplicateId(id);
        System.out.println("id = " + id + "dupId = " + dupId);
        if(id.equals("")){
            return msg;
        }
        if(id.equals(dupId)){
            msg = "NO";
            System.out.println(msg);
            return msg;
        }
        dupId = sellerService.sellerDuplicateId(id);
        if(id.equals(dupId)){
            msg = "NO";
            System.out.println(msg);
            return msg;
        }
        msg = "YES";
        System.out.println(msg);
        return msg;
    }



}
