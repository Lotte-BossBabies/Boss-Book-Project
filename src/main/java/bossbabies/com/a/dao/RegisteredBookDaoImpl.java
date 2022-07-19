package bossbabies.com.a.dao;

import bossbabies.com.a.dto.RegisteredBookDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegisteredBookDaoImpl implements RegisteredBookDao{

    @Autowired
    SqlSession session;

    String namespace = "RegisteredBook.";

    public RegisteredBookDto getRegisteredBookById(String registered_book_id){
        return session.selectOne(namespace+"getRegisteredBook", registered_book_id);
    }
}
