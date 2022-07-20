package bossbabies.com.a.dao.mypage;

import bossbabies.com.a.dto.mypage.LikedBookDto;
import bossbabies.com.a.dto.mypage.MyPageDto;
import bossbabies.com.a.dto.mypage.MyPageReviewDto;
import bossbabies.com.a.dto.mypage.OrderedBookDto;
import bossbabies.com.a.parameterVO.ReviewVO;

import java.util.List;

public interface MyPageDao {
    MyPageDto getMember(MyPageDto mem);
    List<OrderedBookDto> getOrderList(MyPageDto mem);
    List<LikedBookDto> getLikeList(MyPageDto mem);
    List<MyPageReviewDto> getReviewList(MyPageDto mem);
    void cancelOrder(int orderId);
    void writeReview(ReviewVO reviewVO);
    MyPageReviewDto getReview(ReviewVO reviewVO);
}
