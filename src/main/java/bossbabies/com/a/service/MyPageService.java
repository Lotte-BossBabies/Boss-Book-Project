package bossbabies.com.a.service;

import bossbabies.com.a.dao.likes.LikesDao;
import bossbabies.com.a.dto.mypage.OrderedBookDto;
import bossbabies.com.a.dto.mypage.MyPageDto;
import bossbabies.com.a.dto.mypage.LikedBookDto;
import bossbabies.com.a.dao.mypage.MyPageDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class MyPageService {

    @Autowired
    MyPageDao myPageDao;

    @Autowired
    LikesDao likesDao;

    public MyPageDto getMember(MyPageDto mem){
        return myPageDao.getMember(mem);
    }

    public List<OrderedBookDto> getOrderList(MyPageDto mem) {
        return myPageDao.getOrderList(mem);
    }

    public List<LikedBookDto> getLikeList(MyPageDto mem) {
        return myPageDao.getLikeList(mem);
    }

    public void cancelOrder(int orderId) {
        myPageDao.cancelOrder(orderId);
    }

    public void deleteLike(int likeId) { likesDao.deleteLieks(likeId); }
}
