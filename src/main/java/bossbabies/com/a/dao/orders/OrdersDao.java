package bossbabies.com.a.dao.orders;

import bossbabies.com.a.dto.admin.DeliveryDto;
import bossbabies.com.a.dto.mypage.OrderDto;

import java.util.List;
import java.util.Map;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]온라인도서쇼핑몰 구현 프로젝트
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.19       천예원         신규생성
 * -----------------------------------------------------------
 */
public interface OrdersDao {

    boolean makeOrder(OrderDto orderDto);

    List<DeliveryDto> getPreDeliveryBooks(int seller_id);

    boolean updateDeliveryStatus(int order_id);

//    List<DeliveryDto> getCompletedDeliveryBooks(int seller_id);

    List<DeliveryDto>  getCompletedDeliveryBooksWithPeriod(Map<String , String> deliveryMap);
}
