package bossbabies.com.a.service;

import bossbabies.com.a.dao.MyPageDao;
import bossbabies.com.a.dto.OrderedBookDto;
import bossbabies.com.a.dto.MyPageDto;
import bossbabies.com.a.dto.LikedBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyPageService {

    @Autowired
    MyPageDao dao;

    public MyPageDto getMember(MyPageDto mem){
        return dao.getMember(mem);
    }

    public List<OrderedBookDto> getOrderList(MyPageDto mem) {
        return dao.getOrderList(mem);
    }

    public List<LikedBookDto> getLikeList(MyPageDto mem) {
        return dao.getLikeList(mem);
    }
}
