package bossbabies.com.a.service.admin;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.dto.admin.DeliveryDto;
import bossbabies.com.a.dto.mypage.OrderDto;
import bossbabies.com.a.parameterVO.CategoryAndKeywordVO;
import bossbabies.com.a.parameterVO.IdAndCountVO;
import bossbabies.com.a.parameterVO.StatusAndRegisteredBookIdVO;
import java.util.List;
import java.util.Map;


/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]온라인도서쇼핑몰 구현 프로젝트
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.19       안채영         신규생성
 * -----------------------------------------------------------
 */
public interface AdminService {

    public List<RegisteredBookDto> getRegisteredBookList(int sellerId, String category, int sellStatus);

    public List<RegisteredBookDto> getRegisteredBookListBySellCount(int sellerId, String category, int sellStatus);

    public List<RegisteredBookDto> getRegisteredBookListByKeyword(int sellerId, String category, String keyword, int sellStatus);

    public int updateStock(int registeredBookId, int newCount, int discount);

    public List<BookDto> getBooksNotRegistered(int sellerId, String category);

    public List<BookDto> getBooksNotRegisteredByKeyword(int sellerId, String category, String keyword);

    public int updateRegisteredBook(int status, int registeredBookId);

    public int updateDeliveryCompleted(int status, int registeredBookId);

    List<DeliveryDto> getPreDeliveryBooks(int seller_id);

    boolean updateDeliveryStatus(int order_id);

    List<DeliveryDto> getCompletedDeliveryBooks(int seller_id, String startDate, String endDate);

//    List<DeliveryDto> getCompletedDeliveryBooks(int seller_id);

}
