package bossbabies.com.a.controller;

import bossbabies.com.a.dto.main.RegisteredBookInfoDto;
import bossbabies.com.a.service.BookInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryByBookController {

    @Autowired
    BookInfoServiceImpl service;

    //서점
    @RequestMapping(value = "bookstore.do", method = RequestMethod.GET)
    public String bookstore(Model model, String cateName) {

        List<RegisteredBookInfoDto> byCategoryList = service.findByCategoryList(cateName);

        model.addAttribute("cateName", cateName);
        model.addAttribute("byCategoryList", byCategoryList);

        return "book/bookstore";
    }

    @RequestMapping("searchRegisteredBook.do")
    @ResponseBody
    public List<RegisteredBookInfoDto> searchRegisteredBook(String search) {

        List<RegisteredBookInfoDto> bookInfoDtos = service.searchRegisteredBook(search);

        return bookInfoDtos;
    }
}
