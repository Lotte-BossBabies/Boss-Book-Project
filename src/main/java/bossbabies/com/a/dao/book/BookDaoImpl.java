package bossbabies.com.a.dao.book;

import bossbabies.com.a.dto.BookDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    SqlSession session;

    String namespace = "Book.";

    public BookDto getBookById(String book_id){
        return session.selectOne(namespace+"getBook", book_id);
    }
}
