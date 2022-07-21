package bossbabies.com.a.controller;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.dto.ReviewDto;
import bossbabies.com.a.dto.user.MemberDto;
import bossbabies.com.a.service.DetailedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]온라인도서쇼핑몰 구현 프로젝트
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.18       천예원         신규생성
 * -----------------------------------------------------------
 */

@Controller
public class DetailedBookController {

    @Autowired
    DetailedBookService detailedBookService;


    @RequestMapping(value = "getDetailedBook.do", method = RequestMethod.GET)
    public String getBookDetail(int registered_book_id, Model model, HttpServletRequest request) {

        Boolean likeStatus = false;

        String userType = (String) request.getSession().getAttribute("userType");
        if(userType!=null && userType.equals("member")){
            MemberDto memberDto = (MemberDto) request.getSession().getAttribute("login");
            int member_id = detailedBookService.getLoginMember(memberDto.getId());
            likeStatus = detailedBookService.getLikeStatus(member_id, registered_book_id);
        }

        RegisteredBookDto registeredBook = detailedBookService.getRegisteredBook(registered_book_id);
        BookDto book = detailedBookService.getBook(registeredBook.getBook_id());
        List<ReviewDto> reviewList = detailedBookService.getReviewByRBookId(registered_book_id);

        double starAvg = 0.0;
        if(reviewList.size() > 0){
            starAvg = detailedBookService.calculateStarAvg(reviewList);
        }

        model.addAttribute("registered_book", registeredBook);
        model.addAttribute("book", book);
        model.addAttribute("likeStatus", likeStatus);
        model.addAttribute("reviewList", reviewList);
        model.addAttribute("starAvg", starAvg);

        return "book/detailedBook";
    }

    @ResponseBody
    @RequestMapping(value = "addLikes.do", method = RequestMethod.GET)
    public boolean addLikes(int registered_book_id, HttpServletRequest request) {

        int member_id = 0;

        String userType = (String) request.getSession().getAttribute("userType");
        if(userType.equals("member")){
            MemberDto memberDto = (MemberDto) request.getSession().getAttribute("login");
            member_id = detailedBookService.getLoginMember(memberDto.getId());
        }

        return detailedBookService.addLikes(member_id, registered_book_id);
    }

    @ResponseBody
    @RequestMapping(value = "cancelLikes.do", method = RequestMethod.GET)
    public boolean cancelLikes(int registered_book_id, HttpServletRequest request) {
        int member_id = 0;

        String userType = (String) request.getSession().getAttribute("userType");
        if(userType.equals("member")){
            MemberDto memberDto = (MemberDto) request.getSession().getAttribute("login");
            member_id = detailedBookService.getLoginMember(memberDto.getId());
        }

        return detailedBookService.cancelLikes(member_id, registered_book_id);
    }

    @RequestMapping(value = "makeOrder.do", method = RequestMethod.GET)
    public String makeOrder(int registered_book_id, Model model, HttpServletRequest request){
        int member_id = 0;

        String userType = (String) request.getSession().getAttribute("userType");
        if(userType.equals("member")){
            MemberDto memberDto = (MemberDto) request.getSession().getAttribute("login");
            member_id = detailedBookService.getLoginMember(memberDto.getId());
        }

        boolean makeOrderResult = detailedBookService.makeOrder(member_id, registered_book_id);
        model.addAttribute("makeOrderResult", makeOrderResult);

        return "book/orderResult";
    }

    @ResponseBody
    @RequestMapping(value="checkAvailableOrder.do", method = RequestMethod.GET)
    public boolean checkAvailableOrder(int registered_book_id){
        RegisteredBookDto registeredBook = detailedBookService.getRegisteredBook(registered_book_id);

        if(registeredBook.getBook_count() <= registeredBook.getOrder_count()) {
            return false;
        }
        return true;
    }

    //구매를 눌렀을 때 로그인 여부
    @ResponseBody
    @RequestMapping(value="checkLogin.do", method = RequestMethod.GET)
    public boolean checkLogin(HttpServletRequest request){
        Object loginUser = request.getSession().getAttribute("login");

        if(loginUser == null){
            return false;
        }
        return true;
    }

    //구매를 눌렀을 때 관리자인 경우
    @ResponseBody
    @RequestMapping(value="checkAdmin.do", method = RequestMethod.GET)
    public boolean checkAdmin(HttpServletRequest request){
        String userType = (String) request.getSession().getAttribute("userType");

        if(userType.equals("seller")){
            return true;
        }
        return false;
    }
}
