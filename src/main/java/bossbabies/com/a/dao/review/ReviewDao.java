package bossbabies.com.a.dao.review;

import bossbabies.com.a.dto.ReviewDto;

import java.util.List;

public interface ReviewDao {

    List<ReviewDto> getReviewByRBookId(int registered_book_id);

}
