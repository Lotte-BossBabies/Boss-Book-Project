package bossbabies.com.a.dao.orders;

import bossbabies.com.a.dto.mypage.OrderDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]온라인도서쇼핑몰 구현 프로젝트
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.19       천예원         신규생성
 * -----------------------------------------------------------
 */
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
