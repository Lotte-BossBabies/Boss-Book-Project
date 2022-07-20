package bossbabies.com.a.controller;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.dto.ReviewDto;
import bossbabies.com.a.service.DetailedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String getBookDetail(int registered_book_id, Model model) {

        RegisteredBookDto registeredBook = detailedBookService.getRegisteredBook(registered_book_id);
        BookDto book = detailedBookService.getBook(registeredBook.getBook_id());
        Boolean likeStatus = detailedBookService.getLikeStatus(1, registered_book_id);
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
    public boolean addLikes(int registered_book_id) {
        return detailedBookService.addLikes(1, registered_book_id);
    }

    @ResponseBody
    @RequestMapping(value = "cancelLikes.do", method = RequestMethod.GET)
    public boolean cancelLikes(int registered_book_id) {
        return detailedBookService.cancelLikes(1, registered_book_id);
    }

    @RequestMapping(value = "makeOrder.do", method = RequestMethod.GET)
    public String makeOrder(int registered_book_id, Model model){
        boolean makeOrderResult = detailedBookService.makeOrder(1, registered_book_id);
        model.addAttribute("makeOrderResult", makeOrderResult);

        return "orderResult";
    }

    @ResponseBody
    @RequestMapping(value="checkAvailableOrder.do", method = RequestMethod.GET)
    public boolean checkAvailableOrder(int registered_book_id, Model model){
        RegisteredBookDto registeredBook = detailedBookService.getRegisteredBook(registered_book_id);

        if(registeredBook.getBook_count() <= registeredBook.getOrder_count()) {
            return false;
        }
        return true;
    }
}
