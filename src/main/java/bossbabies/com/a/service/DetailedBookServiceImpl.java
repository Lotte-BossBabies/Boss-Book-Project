package bossbabies.com.a.service;

import bossbabies.com.a.dao.book.BookDao;
import bossbabies.com.a.dao.likes.LikesDao;
import bossbabies.com.a.dao.orders.OrdersDao;
import bossbabies.com.a.dao.registeredBook.RegisteredBookDao;
import bossbabies.com.a.dao.review.ReviewDao;
import bossbabies.com.a.dao.user.MemberDao;
import bossbabies.com.a.dao.user.SellerDao;
import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.LikesDto;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.dto.ReviewDto;
import bossbabies.com.a.dto.mypage.OrderDto;
import bossbabies.com.a.dto.user.MemberDto;
import bossbabies.com.a.dto.user.SellerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]온라인도서쇼핑몰 구현 프로젝트
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.18       천예원         신규생성
 * -----------------------------------------------------------
 */
@Service
public class DetailedBookServiceImpl implements DetailedBookService{

    @Autowired
    BookDao bookDao;

    @Autowired
    RegisteredBookDao registeredBookDao;

    @Autowired
    LikesDao likesDao;

    @Autowired
    ReviewDao reviewDao;

    @Autowired
    OrdersDao ordersDao;

    @Autowired
    MemberDao memberDao;

    @Autowired
    SellerDao sellerDao;


    @Override
    public BookDto getBook(int book_id) {
        return bookDao.getBookById(book_id);
    }

    @Override
    public BookDto getBookByRId(int r_book_id) {
        return bookDao.getBookByRId(r_book_id);
    }

    @Override
    public RegisteredBookDto getRegisteredBook(int registered_book_id) {
        return registeredBookDao.getRegisteredBookById(registered_book_id);
    }


    @Override
    public boolean getLikeStatus(int member_id, int registered_book_id) {
        LikesDto likesDto = likesDao.getLikeByMIdAndRId(member_id, registered_book_id);

        if(likesDto == null){
            return false;
        }
        return true;
    }

    @Override
    public boolean addLikes(int member_id, int registered_book_id){
        LikesDto likesDto = likesDao.getLikeByMIdAndRId(member_id, registered_book_id);

        if(likesDto == null) {
            likesDto = new LikesDto(member_id, registered_book_id, Instant.now());
            return likesDao.addLikes(likesDto);
        }
        else{
            return true;
        }
    }

    @Override
    public boolean cancelLikes(int member_id, int registered_book_id) {
        LikesDto likesDto = likesDao.getLikeByMIdAndRId(member_id, registered_book_id);

        if(likesDto == null) {
            return false;
        }
        else{
            return likesDao.cancelLikes(member_id, registered_book_id);
        }
    }

    @Override
    public List<ReviewDto> getReviewByRBookId(int registered_book_id) {
        return reviewDao.getReviewByRBookId(registered_book_id);
    }

    @Override
    public double calculateStarAvg(List<ReviewDto> reviewList) {
        int sum = 0;
        for(ReviewDto r : reviewList){
            sum += r.getStar();
        }
        return (double)sum/reviewList.size();
    }

    @Override
    public boolean makeOrder(int member_id, int registered_book_id) {
        boolean makeOrderResult = true;

        OrderDto orderDto = new OrderDto(member_id, registered_book_id, false, Instant.now(), false);
        boolean orderCountResult = registeredBookDao.updateOrderCount(registered_book_id);
        if(orderCountResult) {
            makeOrderResult = ordersDao.makeOrder(orderDto);
        }

        return makeOrderResult;
    }

    @Override
    public int getLoginMember(String id) {
        MemberDto loginMember = memberDao.getMember(id);

        return loginMember.getMember_id();
    }

    @Override
    public SellerDto getSellerBySId(int seller_id) {
        return sellerDao.getSellerBySId(seller_id);
    }

}
