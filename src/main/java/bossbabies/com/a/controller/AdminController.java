package bossbabies.com.a.controller;

import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.service.admin.AdminServiceImpl;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]온라인도서쇼핑몰 구현 프로젝트
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.19       안채영         신규생성
 * -----------------------------------------------------------
 */

@Controller
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping(value = "adminMain.do", method = RequestMethod.GET)
    public String main(int sellerId, String category, Model model) {

        logger.info(new Date() + " AdminController main");

        category = "소설";

        List<RegisteredBookDto> resultList = adminService.getRegisteredBookList(sellerId, category);
        model.addAttribute("resultList", resultList);

        return "/admin/books";
    }

    @RequestMapping(value = "category.do", method = RequestMethod.POST)
    @ResponseBody
    public List<RegisteredBookDto> getBooksBycategory(@RequestBody Map<String, String> map) {

        logger.info(new Date() + " AdminController getBooksBycategory()");

        List<RegisteredBookDto> resultList = adminService.getRegisteredBookList(
            Integer.parseInt(map.get("sellerId")), map.get("category"));

        return resultList;

    }

    @RequestMapping(value = "keyword.do", method = RequestMethod.POST)
    @ResponseBody
    public List<RegisteredBookDto> getBooksByKeyword(@RequestBody Map<String, String> map) {
        logger.info(new Date() + " AdminController getBooksByKeyword()");

        int sellerId = Integer.parseInt(map.get("sellerId"));
        System.out.println("$$$$$$$$$$$$$" + sellerId);
        String category = map.get("category");
        String keyword = map.get("keyword");

        List<RegisteredBookDto> resultList = adminService.getRegisteredBookListByKeyword(sellerId, category, keyword);

        return resultList;

    }


}
