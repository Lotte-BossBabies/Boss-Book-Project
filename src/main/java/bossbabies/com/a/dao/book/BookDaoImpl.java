package bossbabies.com.a.dao.book;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.dto.main.PopularBookInfoDto;
import bossbabies.com.a.dto.main.RegisteredBookInfoDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    SqlSession session;

    String namespace = "Book.";

    public BookDto getBookById(int book_id){
        return session.selectOne(namespace+"getBook", book_id);
    }

    @Override
    public List<PopularBookInfoDto> topOfFindByStar() {
        return session.selectList(namespace+"topOfFindByStar");
    }

    @Override
    public List<RegisteredBookInfoDto> topOfFindByOrderCount() {
        return session.selectList(namespace+"topOfFindByOrderCount");
    }

    @Override
    public List<RegisteredBookInfoDto> findByCategoryList(String cateName) {
        return session.selectList(namespace+"findByCategoryList",cateName);
    }

    @Override
    public List<RegisteredBookInfoDto> findByList() {
        return session.selectList(namespace+"findByList");
    }
}
