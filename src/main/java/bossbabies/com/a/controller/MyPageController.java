package bossbabies.com.a.controller;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.mypage.MyPageReviewDto;
import bossbabies.com.a.dto.mypage.OrderedBookDto;
import bossbabies.com.a.dto.mypage.MyPageDto;
import bossbabies.com.a.dto.mypage.LikedBookDto;
import bossbabies.com.a.dto.user.MemberDto;
import bossbabies.com.a.parameterVO.ReviewVO;
import bossbabies.com.a.service.DetailedBookService;
import bossbabies.com.a.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]마이페이지
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.19       이성은         신규생성
 * -----------------------------------------------------------
 */

@Controller
public class MyPageController {

    @Autowired
    MyPageService myPageService;

    @Autowired
    DetailedBookService bookService;

    @GetMapping("mypage.do")
    public String getMyPage(Model model, HttpSession session) {
        MemberDto md = (MemberDto) session.getAttribute("login");
        MyPageDto member = new MyPageDto(md.getMember_id(),md.getName());
        List<OrderedBookDto> orderItemList = myPageService.getOrderList(member);
        List<LikedBookDto> likeItemList = myPageService.getLikeList(member);
        List<MyPageReviewDto> reviewList = myPageService.getReviewList(member);

        model.addAttribute("member", member);
        model.addAttribute("orderList", orderItemList);
        model.addAttribute("likeList", likeItemList);
        model.addAttribute("reviewList", reviewList);

        return "myPage";
    }

    @GetMapping("cancelOrder.do")
    public String cancelOrder(int orderId) {
        myPageService.cancelOrder(orderId);

        return "redirect:/mypage.do";
    }

    @GetMapping("deleteLike.do")
    public String deleteLike(int likeId){
        myPageService.deleteLike(likeId);

        return "redirect:/mypage.do";
    }

    @GetMapping("writeReview.do")
    public String writeReview(int bookId, int memberId, ReviewVO rvo, Model model,
                              HttpServletResponse response) throws Exception {
        BookDto book = bookService.getBookByRId(bookId);
        MyPageReviewDto review = myPageService.getReview(rvo);

        if (review != null) {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('이미 리뷰를 등록한 책입니다!');" +
                    "location.href='mypage.do';" +
                    "</script>");
            out.flush();
            return "";
        }

        model.addAttribute("book", book);

        return "writeReview";
    }

    @PostMapping("writeReviewAf.do")
    public String writeReviewAf(ReviewVO reviewVO) {
        myPageService.writeReview(reviewVO);

        return "redirect:/mypage.do";
    }

    @GetMapping("deleteReview.do")
    public String deleteReview(int reviewId) {
        myPageService.deleteReview(reviewId);

        return "redirect:/mypage.do";
    }

}
