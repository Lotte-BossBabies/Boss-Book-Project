package bossbabies.com.a.service.admin;

import bossbabies.com.a.dao.orders.OrdersDao;
import bossbabies.com.a.dao.registeredBook.RegisteredBookDao;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.dto.admin.DeliveryDto;
import bossbabies.com.a.dto.mypage.OrderDto;
import bossbabies.com.a.parameterVO.CategoryAndKeywordVO;
import bossbabies.com.a.parameterVO.IdAndCountVO;
import bossbabies.com.a.parameterVO.SellerAndCategoryVO;
import bossbabies.com.a.parameterVO.StatusAndRegisteredBookIdVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]온라인도서쇼핑몰 구현 프로젝트
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.19       안채영         신규생성
 * -----------------------------------------------------------
 */

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    RegisteredBookDao dao;

    @Autowired
    OrdersDao ordersDao;

    @Override
    public List<RegisteredBookDto> getRegisteredBookList(int sellerId, String category) {

        SellerAndCategoryVO vo = new SellerAndCategoryVO(sellerId, category);

        return dao.getRegisteredBookList(vo);
    }

    @Override
    public List<RegisteredBookDto> getRegisteredBookListBySellCount(int sellerId, String category) {

        SellerAndCategoryVO vo = new SellerAndCategoryVO(sellerId, category);

        return dao.getRegisteredBookListBySellCount(vo);
    }

    @Override
    public List<RegisteredBookDto> getRegisteredBookListByKeyword(int sellerId, String category, String keyword) {

        CategoryAndKeywordVO vo = new CategoryAndKeywordVO(category, keyword, sellerId);

        return dao.getRegisteredBookListByKeyword(vo);
    }

    @Override
    public int updateStock(int registeredBookId, int newCount) {

        IdAndCountVO vo = new IdAndCountVO(registeredBookId, newCount);

        return dao.updateStock(vo);
    }

    @Override
    public int updateRegisteredBook(int status, int registeredBookId) {

        StatusAndRegisteredBookIdVO vo = new StatusAndRegisteredBookIdVO(status, registeredBookId);

        return dao.updateRegisteredBook(vo);
    }

    @Override
    public int updateDeliveryCompleted(int status, int registeredBookId) {

        StatusAndRegisteredBookIdVO vo = new StatusAndRegisteredBookIdVO(status, registeredBookId);

        return dao.updateDeliveryCompleted(vo);
    }

    @Override
    public List<DeliveryDto> getPreDeliveryBooks(int seller_id) {
        return ordersDao.getPreDeliveryBooks(seller_id);
    }

    @Override
    public boolean updateDeliveryStatus(int order_id) {
        return ordersDao.updateDeliveryStatus(order_id);
    }

    @Override
    public List<DeliveryDto> getCompletedDeliveryBooks(int seller_id, String startDate, String endDate) {
        Map<String, String> deliveryMap = new HashMap<>();
        deliveryMap.put("seller_id", Integer.toString(seller_id));
        deliveryMap.put("start_date", startDate);
        deliveryMap.put("end_date", endDate);

        return ordersDao.getCompletedDeliveryBooksWithPeriod(deliveryMap);
    }

//    @Override
//    public List<DeliveryDto> getCompletedDeliveryBooks(int seller_id) {
//        return ordersDao.getCompletedDeliveryBooks(seller_id);
//    }
}
