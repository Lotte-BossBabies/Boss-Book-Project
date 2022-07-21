package bossbabies.com.a.controller;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.dto.admin.DeliveryDto;
import bossbabies.com.a.dto.user.SellerDto;
import bossbabies.com.a.service.DetailedBookService;
import bossbabies.com.a.service.SellerService;
import bossbabies.com.a.service.admin.AdminServiceImpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
    AdminServiceImpl adminService;

    @Autowired
    DetailedBookService detailedBookService;

    @Autowired
    SellerService sellerService;

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping(value = "adminMain.do", method = RequestMethod.GET)
    public String main(HttpSession session, int sellStatus, Model model) {

        logger.info(new Date() + " AdminController main");

        SellerDto seller = (SellerDto) session.getAttribute("login");

        int sellerId = seller.getSeller_id();

        String category = "소설";

        List<RegisteredBookDto> resultList = adminService.getRegisteredBookList(sellerId, category, sellStatus);
        model.addAttribute("resultList", resultList);

        return "/admin/books";
    }

    @RequestMapping(value = "category.do", method = RequestMethod.POST)
    @ResponseBody
    public List<RegisteredBookDto> getBooksBycategory(@RequestBody Map<String, String> map) {

        logger.info(new Date() + " AdminController getBooksBycategory()");

        int sellerId = Integer.parseInt(map.get("sellerId"));
        String category = map.get("category");
        int sellStatus = Integer.parseInt(map.get("sellStatus"));

        List<RegisteredBookDto> resultList = adminService.getRegisteredBookList(sellerId, category, sellStatus);

        return resultList;

    }

    @RequestMapping(value = "keyword.do", method = RequestMethod.POST)
    @ResponseBody
    public List<RegisteredBookDto> getBooksByKeyword(@RequestBody Map<String, String> map) {
        logger.info(new Date() + " AdminController getBooksByKeyword()");

        int sellerId = Integer.parseInt(map.get("sellerId"));
        String category = map.get("category");
        String keyword = map.get("keyword");
        int sellStatus = Integer.parseInt(map.get("sellStatus"));

        List<RegisteredBookDto> resultList = adminService.getRegisteredBookListByKeyword(sellerId, category, keyword, sellStatus);

        return resultList;

    }

    @RequestMapping(value = "sales.do", method = RequestMethod.POST)
    @ResponseBody
    public List<RegisteredBookDto> getBooksBySales(@RequestBody Map<String, String> map) {

        logger.info(new Date() + " AdminController getBooksBySales()");

        int sellerId = Integer.parseInt(map.get("sellerId"));
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
    public String updateBook(int sellerId, Model model) {

        logger.info(new Date() + " AdminController updateBook()");

        String category = "소설";

        List<BookDto> resultList = adminService.getBooksNotRegistered(sellerId, category);
        // List<RegisteredBookDto> resultList = adminService.getRegisteredBookList(sellerId, category, sellStatus);

        model.addAttribute("resultList", resultList);

        return "/admin/bookRegister";
    }

    @RequestMapping(value = "notRegisteredBooks.do", method = RequestMethod.POST)
    @ResponseBody
    public List<BookDto> notRegisters(@RequestBody Map<String, String> map) {

        logger.info(new Date() + " AdminController notRegisters()");

        int sellerId = Integer.parseInt(map.get("sellerId"));
        String category = map.get("category");
        //int sellStatus = Integer.parseInt(map.get("sellStatus"));

        return adminService.getBooksNotRegistered(sellerId, category);
    }

    @RequestMapping(value = "notRegisteredBooksByKeyword.do", method = RequestMethod.POST)
    @ResponseBody
    public List<BookDto> notRegistersByKeyword(@RequestBody Map<String, String> map) {

        logger.info(new Date() + " AdminController notRegistersByKeyword()");

        int sellerId = Integer.parseInt(map.get("sellerId"));
        String category = map.get("category");
        String keyword = map.get("keyword");
        //int sellStatus = Integer.parseInt(map.get("sellStatus"));

        return adminService.getBooksNotRegisteredByKeyword(sellerId, category, keyword);
        // return adminService.getRegisteredBookListByKeyword(sellerId, category, keyword, sellStatus);
    }

    @RequestMapping(value="manageDelivery.do", method = RequestMethod.GET)
    public String manageDelivery(int seller_id, Model model){
        List<DeliveryDto> preDeliveryList = adminService.getPreDeliveryBooks(seller_id);

        model.addAttribute("preDeliveryList", preDeliveryList);
        model.addAttribute("seller_id", seller_id);

        return "/admin/manageDelivery";
    }

    @RequestMapping(value="updateDeliveryStatus.do", method = RequestMethod.GET)
    public String updateDeliveryStatus(int order_id, int seller_id){
        adminService.updateDeliveryStatus(order_id);

        return "redirect:/manageDelivery.do?seller_id="+seller_id;
    }

    @ResponseBody
    @RequestMapping(value="searchDelivery.do", method = RequestMethod.GET)
    public List<DeliveryDto> searchDelivery(int seller_id, String start_date, String end_date){
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

        List<DeliveryDto> completedDeliveryList = adminService.getCompletedDeliveryBooks(seller_id, startDate, endDate);

        return completedDeliveryList;
    }



}
