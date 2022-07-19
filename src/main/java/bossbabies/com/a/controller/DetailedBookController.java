package bossbabies.com.a.controller;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.service.DetailedBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DetailedBookController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    DetailedBookService detailedBookService;


    @RequestMapping(value = "getDetailedBook.do", method = RequestMethod.GET)
    public String getBookDetail(String registered_book_id, Model model) {

        RegisteredBookDto registeredBook = detailedBookService.getRegisteredBook(registered_book_id);
        BookDto book = detailedBookService.getBook(Integer.toString(registeredBook.getBook_id()));
        Boolean likeStatus = detailedBookService.getLikeStatus("1", registered_book_id);

        model.addAttribute("registered_book", registeredBook);
        model.addAttribute("book", book);
        model.addAttribute("likeStatus", likeStatus);

        return "book/detailedBook";
    }

    @RequestMapping(value = "addLikes.do", method = RequestMethod.GET)
    public String addLikes(String registered_book_id, Model model) {

        //로그인 유저의 아이디와 registered_book_id

        return "redirect:/getDetailedBook.do";
    }
}
