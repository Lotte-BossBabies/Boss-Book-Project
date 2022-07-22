package bossbabies.com.a.controller;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.dto.admin.DeliveryDto;
import bossbabies.com.a.dto.user.SellerDto;
import bossbabies.com.a.service.DetailedBookService;
import bossbabies.com.a.service.SellerService;
import bossbabies.com.a.service.admin.AdminService;
import bossbabies.com.a.service.admin.AdminServiceImpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    AdminService adminService;

    @Autowired
    DetailedBookService detailedBookService;

    @Autowired
    SellerService sellerService;

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping(value = "adminMain.do", method = RequestMethod.GET)
    public String main(HttpServletRequest req, Model model) {

        logger.info(new Date() + " AdminController main");

        SellerDto seller = (SellerDto) req.getSession().getAttribute("login");
        int sellerId = seller.getSeller_id();

        String category = "전체";
        int sellStatus = 1;

        List<RegisteredBookDto> resultList = adminService.getRegisteredBookList(sellerId, category, sellStatus);
        model.addAttribute("resultList", resultList);
        model.addAttribute("seller", seller);

        return "/admin/books";
    }

    @RequestMapping(value = "category.do", method = RequestMethod.POST)
    @ResponseBody
    public List<RegisteredBookDto> getBooksBycategory(@RequestBody Map<String, String> map, HttpServletRequest req) {

        logger.info(new Date() + " AdminController getBooksBycategory()");

        SellerDto seller = (SellerDto) req.getSession().getAttribute("login");
        int sellerId = seller.getSeller_id();

        String category = map.get("category");
        int sellStatus = Integer.parseInt(map.get("sellStatus"));

        List<RegisteredBookDto> resultList = adminService.getRegisteredBookList(sellerId, category, sellStatus);

        return resultList;

    }

    @RequestMapping(value = "keyword.do", method = RequestMethod.POST)
    @ResponseBody
    public List<RegisteredBookDto> getBooksByKeyword(@RequestBody Map<String, String> map, HttpServletRequest req) {
        logger.info(new Date() + " AdminController getBooksByKeyword()");

        SellerDto seller = (SellerDto) req.getSession().getAttribute("login");
        int sellerId = seller.getSeller_id();

        String category = map.get("category");
        String keyword = map.get("keyword");
        int sellStatus = Integer.parseInt(map.get("sellStatus"));

        List<RegisteredBookDto> resultList = adminService.getRegisteredBookListByKeyword(sellerId, category, keyword, sellStatus);

        return resultList;

    }

    @RequestMapping(value = "sales.do", method = RequestMethod.POST)
    @ResponseBody
    public List<RegisteredBookDto> getBooksBySales(@RequestBody Map<String, String> map, HttpServletRequest req) {

        logger.info(new Date() + " AdminController getBooksBySales()");

        SellerDto seller = (SellerDto) req.getSession().getAttribute("login");
        int sellerId = seller.getSeller_id();

        String category = map.get("category");
        int sellStatus = Integer.parseInt(map.get("sellStatus"));

        List<RegisteredBookDto> resultList = adminService.getRegisteredBookListBySellCount(sellerId, category, sellStatus);

        return resultList;
    }

    @RequestMapping(value = "bookEdit.do", method = RequestMethod.GET)
    public String getBook(String registeredBookId, Model model) {

        logger.info(new Date() + " AdminController getBook()");

        int bookId = Integer.parseInt(registeredBookId);

        RegisteredBookDto resultDto = detailedBookService.getRegisteredBook(bookId);

        model.addAttribute("registeredBook", resultDto);

        return "/admin/bookEdit";
    }


    @RequestMapping(value = "updateSellStatus.do", method = RequestMethod.POST)
    @ResponseBody
    public int cancelBook(@RequestBody Map<String, String> map) {

        logger.info(new Date() + " AdminController cancelBook()");

        int status = Integer.parseInt(map.get("sellStatus"));
        int id = Integer.parseInt(map.get("registeredBookId"));

        int result = adminService.updateRegisteredBook(status, id);

        return result;
    }

    @RequestMapping(value = "update.do", method = RequestMethod.POST)
    @ResponseBody
    public int updateStockAndDiscount(@RequestBody Map<String, String> map) {

        logger.info(new Date() + " AdminController updateStockAndDiscount()");

        int registeredBookId = Integer.parseInt(map.get("id"));
        int stock = Integer.parseInt(map.get("stock"));
        int discount = Integer.parseInt(map.get("discount"));

        int result = adminService.updateStock(registeredBookId, stock, discount);

        return result;
    }

    @RequestMapping(value = "updateBook.do", method = RequestMethod.GET)
    public String updateBook(HttpServletRequest req, Model model) {

        logger.info(new Date() + " AdminController updateBook()");

        String category = "전체";

        SellerDto seller = (SellerDto) req.getSession().getAttribute("login");
        int sellerId = seller.getSeller_id();

        List<BookDto> resultList = adminService.getBooksNotRegistered(sellerId, category);
        model.addAttribute("resultList", resultList);

        return "/admin/bookRegister";
    }

    @RequestMapping(value = "notRegisteredBooks.do", method = RequestMethod.POST)
    @ResponseBody
    public List<BookDto> notRegisters(@RequestBody Map<String, String> map, HttpServletRequest req) {

        logger.info(new Date() + " AdminController notRegisters()");

        SellerDto seller = (SellerDto) req.getSession().getAttribute("login");
        int sellerId = seller.getSeller_id();

        String category = map.get("category");

        return adminService.getBooksNotRegistered(sellerId, category);
    }

    @RequestMapping(value = "notRegisteredBooksByKeyword.do", method = RequestMethod.POST)
    @ResponseBody
    public List<BookDto> notRegistersByKeyword(@RequestBody Map<String, String> map, HttpServletRequest req) {

        logger.info(new Date() + " AdminController notRegistersByKeyword()");

        SellerDto seller = (SellerDto) req.getSession().getAttribute("login");
        int sellerId = seller.getSeller_id();

        String category = map.get("category");
        String keyword = map.get("keyword");

        return adminService.getBooksNotRegisteredByKeyword(sellerId, category, keyword);
    }

    @RequestMapping(value = "registerDetail.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> registerDetail(@RequestBody Map<String, String> reqMap, HttpServletRequest req) {

        SellerDto seller = (SellerDto) req.getSession().getAttribute("login");
        int sellerId = seller.getSeller_id();

        int bookId = Integer.parseInt(reqMap.get("bookId"));

        Map<String, Integer> map = new HashMap<>();

        RegisteredBookDto dto = adminService.checkBookRegistered(bookId, sellerId);

        if(dto == null) {
            map.put("bookId", bookId);
            return map;
        }

        int result = adminService.updateRegisteredBook(1, dto.getRegistered_book_id());

        map.put("result", result);
        System.out.println("update book registered!!!!");

        return map;
    }

    @RequestMapping(value = "registerBookDetail.do", method = RequestMethod.GET)
    public String moveToRegisterPage(int bookId, Model model) {

        BookDto book = adminService.getBookDetail(bookId);

        model.addAttribute("book", book);

        return "/admin/bookRegisterDetail";
    }


    @RequestMapping(value = "insertRegisterBook.do", method = RequestMethod.POST)
    public String insertBook(HttpServletRequest req, String bookId, String bookCount, String discountRate) {

        SellerDto seller = (SellerDto) req.getSession().getAttribute("login");
        int sellerId = seller.getSeller_id();

        int book = Integer.parseInt(bookId);
        int count = Integer.parseInt(bookCount);
        int rate = Integer.parseInt(discountRate);


        int result = adminService.registerBook(book, sellerId, count, rate);

        if(result == 0) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return "registerBookDetail";
        }else {
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            return "redirect:/updateBook.do?sellerId=3";
        }

    }


    @RequestMapping(value="manageDelivery.do", method = RequestMethod.GET)
    public String manageDelivery(HttpServletRequest req, Model model){

        SellerDto seller = (SellerDto) req.getSession().getAttribute("login");
        int sellerId = seller.getSeller_id();

        List<DeliveryDto> preDeliveryList = adminService.getPreDeliveryBooks(sellerId);

        model.addAttribute("preDeliveryList", preDeliveryList);
        model.addAttribute("seller_id", sellerId);

        return "/admin/manageDelivery";
    }

    @RequestMapping(value="updateDeliveryStatus.do", method = RequestMethod.GET)
    public String updateDeliveryStatus(int order_id, HttpServletRequest req){

        SellerDto seller = (SellerDto) req.getSession().getAttribute("login");
        int sellerId = seller.getSeller_id();

        adminService.updateDeliveryStatus(order_id);

        return "redirect:/manageDelivery.do";
    }

    @ResponseBody
    @RequestMapping(value="searchDelivery.do", method = RequestMethod.GET)
    public List<DeliveryDto> searchDelivery(HttpServletRequest req, String start_date, String end_date){

        SellerDto seller = (SellerDto) req.getSession().getAttribute("login");
        int sellerId = seller.getSeller_id();

        String startDate = start_date;
        String endDate = end_date;

        if(start_date.equals("")){
            startDate = "1900-01-01";
        }
        if(end_date.equals("")){
            endDate = LocalDateTime.now().toString();
        }

        startDate = startDate.substring(0, 10).replace("-", "");
        endDate = endDate.substring(0, 10).replace("-", "");

        List<DeliveryDto> completedDeliveryList = adminService.getCompletedDeliveryBooks(sellerId, startDate, endDate);

        return completedDeliveryList;
    }



}
