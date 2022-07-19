package bossbabies.com.a.service;

import bossbabies.com.a.dao.book.BookDao;
import bossbabies.com.a.dao.likes.LikesDao;
import bossbabies.com.a.dao.orders.OrdersDao;
import bossbabies.com.a.dao.registeredBook.RegisteredBookDao;
import bossbabies.com.a.dao.review.ReviewDao;
import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.LikesDto;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.dto.ReviewDto;
import bossbabies.com.a.dto.mypage.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

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


    @Override
    public BookDto getBook(int book_id) {
        return bookDao.getBookById(book_id);
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
        OrderDto orderDto = new OrderDto(member_id, registered_book_id, false, Instant.now(), false);
        return ordersDao.makeOrder(orderDto);
    }

}
