package bossbabies.com.a.service;


import bossbabies.com.a.dao.likes.LikesDao;
import bossbabies.com.a.dto.mypage.OrderedBookDto;
import bossbabies.com.a.dto.mypage.MyPageDto;
import bossbabies.com.a.dto.mypage.LikedBookDto;
import bossbabies.com.a.dao.mypage.MyPageDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
