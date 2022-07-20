package bossbabies.com.a.service;

import bossbabies.com.a.dao.book.BookDaoImpl;
import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.main.RegisteredBookInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService{

    @Autowired
    BookDaoImpl dao;

    @Override
    public List<BookDto> topOfFindByPubdate() {

        return dao.topOfFindByPubdate();

    }

    @Override
    public List<RegisteredBookInfoDto> topOfFindByOrderCount() {

        return dao.topOfFindByOrderCount();
    }
}
