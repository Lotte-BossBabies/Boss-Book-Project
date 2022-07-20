package bossbabies.com.a.dao.orders;

import bossbabies.com.a.dto.mypage.OrderDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDaoImpl implements OrdersDao{

    @Autowired
    SqlSession session;

    String namespace = "Orders.";


    @Override
    public boolean makeOrder(OrderDto orderDto) {
        int count = session.insert(namespace+"makeOrder", orderDto);
        if(count == 0){
            return false;
        }
        return true;
    }
}
