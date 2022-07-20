package bossbabies.com.a.service;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.LikesDto;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.dto.ReviewDto;

import java.util.List;

public interface DetailedBookService {

    BookDto getBook(int book_id);

    RegisteredBookDto getRegisteredBook(int registered_book_id);

    boolean getLikeStatus(int member_id, int registered_book_id);

    boolean addLikes(int member_id, int registered_book_id);

    boolean cancelLikes(int member_id, int registered_book_id);

    List<ReviewDto> getReviewByRBookId(int registered_book_id);

    double calculateStarAvg(List<ReviewDto> reviewList);

    boolean makeOrder(int member_id, int registered_book_id);

}
