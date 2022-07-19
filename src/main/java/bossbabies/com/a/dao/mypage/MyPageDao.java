package bossbabies.com.a.dao.mypage;

import bossbabies.com.a.dto.mypage.OrderedBookDto;
import bossbabies.com.a.dto.mypage.MyPageDto;
import bossbabies.com.a.dto.mypage.LikedBookDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]마이페이지
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.19       이성은         신규생성
 * -----------------------------------------------------------
 */
@Repository
public class MyPageDao {

    @Autowired
    SqlSession session;

    String ns = "MemberDetail.";

    public MyPageDto getMember(MyPageDto mem){
        return session.selectOne(ns + "getMember", mem);
    }

    public List<OrderedBookDto> getOrderList(MyPageDto mem) {
        return session.selectList(ns + "memberOrderItems", mem);
    }

    public List<LikedBookDto> getLikeList(MyPageDto mem) {
        return session.selectList(ns + "memberLikeItems", mem);
    }

    public void cancelOrder(int orderId){
        session.update(ns+"cancelOrder", orderId);
    }

}
