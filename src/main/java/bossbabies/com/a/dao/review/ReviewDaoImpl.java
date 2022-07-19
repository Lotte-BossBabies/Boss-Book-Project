package bossbabies.com.a.dao.review;

import bossbabies.com.a.dto.ReviewDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDaoImpl implements ReviewDao{

    @Autowired
    SqlSession session;

    String namespace = "Review.";


    @Override
    public List<ReviewDto> getReviewByRBookId(int registered_book_id) {
        return session.selectList(namespace+"getReviewByRBookId", registered_book_id);
    }

}
