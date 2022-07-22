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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    MemberService memberService;

    @Autowired
    SellerService sellerService;


    @RequestMapping(value = "userSelect.do", method = RequestMethod.POST)
    public String userSelect() {
        logger.info("UserController userSelect() " + new Date());

        return "/user/userSelect";
    }
    @RequestMapping(value = "memberRegi.do", method = RequestMethod.POST)
    public String commonRegi(String email, Model model) {
        logger.info("UserController memberRegi() " + new Date());
        model.addAttribute("email", email);
        return "/user/memberRegi";
    }
    @RequestMapping(value = "sellerRegi.do", method = RequestMethod.POST)
    public String sellerRegi(String email, Model model) {
        logger.info("UserController sellerRegi() " + new Date());
        model.addAttribute("email", email);

        return "/user/sellerRegi";
    }

    @RequestMapping(value = "regiMember.do", method = RequestMethod.POST)
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
    @RequestMapping(value = "regiSeller.do", method = RequestMethod.POST)
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
    @RequestMapping(value = "loginAf.do", method = RequestMethod.POST)
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
            return "redirect:/main.do";
        } else {
            return "/user/loginFail";
        }
    }

    @RequestMapping(value = "updateUser.do", method = RequestMethod.POST)
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
    @RequestMapping(value = "updateMember.do", method = RequestMethod.POST)
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
        return "redirect:/mypage.do";
    }
    @RequestMapping(value = "updateSeller.do", method = RequestMethod.POST)
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
        return "redirect:/adminMain.do";
    }
    @RequestMapping(value = "findIdView.do", method = RequestMethod.GET)
    public String findIdView(HttpServletRequest req, Model model){
        logger.info("UserController findIdView() " + new Date());

        return "/user/findId";

    }
    @RequestMapping(value = "findIdOk.do", method = RequestMethod.POST)
    public String findIdOk(String id, Model model){
        logger.info("UserController findIdOk() " + new Date());
        //String password = req.getParameter("password");
        System.out.println(id);
        model.addAttribute("id", id);
        return "/user/findIdOk";

    }
    @RequestMapping(value = "findId.do", method = RequestMethod.POST)
    @ResponseBody
    public String findId(@RequestBody Map<String, String> map, HttpServletRequest req, Model model){
        String name = map.get("name");
        String email = map.get("email");
        FindIdVO find = new FindIdVO(name, email);
        System.out.println(find);
        String msg = "findIdFail";

        String my_id = memberService.findMemberId(find);
        if(my_id != null){
            msg = "findIdSuccess";
            System.out.println(msg + my_id);
            return my_id;
        }
        my_id = sellerService.findSellerId(find);
        if(my_id != null){
            msg = "findIdSuccess";
            System.out.println(msg + my_id);
            return my_id;
        }
        System.out.println(msg);

        return "nothing";

    }
    @RequestMapping(value = "findPasswordView.do", method = RequestMethod.GET)
    public String findPasswordView(HttpServletRequest req, Model model){
        logger.info("UserController userSelect() " + new Date());

        return "/user/findPassword";

    }
    @RequestMapping(value = "findPasswordOk.do", method = RequestMethod.POST)
    public String findPasswordOk(String password, Model model){
        logger.info("UserController findPasswordOk() " + new Date());
        //String password = req.getParameter("password");
        System.out.println(password);
        model.addAttribute("password", password);
        return "/user/findPasswordOk";

    }
    @RequestMapping(value = "findPassword.do", method = RequestMethod.POST)
    @ResponseBody
    public String findPassword(@RequestBody Map<String, String> map, HttpServletRequest req, Model model){
        String id = map.get("id");
        String name = map.get("name");
        String email = map.get("email");
        FindPasswordVO find = new FindPasswordVO(id, name, email);
        System.out.println(find);
        String msg = "findPasswordFail";

        String password = memberService.findMemberPassword(find);
        if(password != null){
            model.addAttribute("password", password);
            msg = "findPasswordSuccess";
            System.out.println(msg + password);
            return password;
        }
        password = sellerService.findSellerPassword(find);
        if(password != null){
            model.addAttribute("password", password);
            msg = "findPasswordSuccess";
            System.out.println(msg + password);
            return password;
        }
        System.out.println(msg);

        return "nothing";

    }
    @RequestMapping(value = "duplicateId.do", method = RequestMethod.POST)
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

    @GetMapping("logout.do")
    public String logout(HttpSession session, HttpServletResponse response) throws Exception {
        session.invalidate();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('로그아웃 되었습니다.');" +
                "location.href='main.do';" +
                "</script>");
        out.flush();
        return "";
    }
}
