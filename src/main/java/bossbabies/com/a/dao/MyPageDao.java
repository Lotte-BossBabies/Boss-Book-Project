package bossbabies.com.a.dao;

import bossbabies.com.a.dto.mypage.OrderedBookDto;
import bossbabies.com.a.dto.mypage.MyPageDto;
import bossbabies.com.a.dto.mypage.LikedBookDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

}
