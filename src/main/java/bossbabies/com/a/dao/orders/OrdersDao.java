package bossbabies.com.a.dao.orders;

import bossbabies.com.a.dto.mypage.OrderDto;

public interface OrdersDao {

    boolean makeOrder(OrderDto orderDto);
}
