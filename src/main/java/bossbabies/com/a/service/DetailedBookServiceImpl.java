package bossbabies.com.a.service;

import bossbabies.com.a.dao.book.BookDao;
import bossbabies.com.a.dao.likes.LikesDao;
import bossbabies.com.a.dao.registeredBook.RegisteredBookDao;
import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.LikesDto;
import bossbabies.com.a.dto.RegisteredBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class DetailedBookServiceImpl implements DetailedBookService{

    @Autowired
    BookDao bookDao;

    @Autowired
    RegisteredBookDao registeredBookDao;

    @Autowired
    LikesDao likesDao;


    @Override
    public BookDto getBook(String book_id) {
        return bookDao.getBookById(book_id);
    }

    @Override
    public RegisteredBookDto getRegisteredBook(String registered_book_id) {
        return registeredBookDao.getRegisteredBookById(registered_book_id);
    }


    @Override
    public boolean getLikeStatus(String member_id, String registered_book_id) {
        LikesDto likesDto = likesDao.getLikeByMIdAndRId(member_id, registered_book_id);

        if(likesDto == null){
            return false;
        }
        return true;
    }

    //이거 파라미터 받고 interface에 추가해야함...!!
    public boolean addLikes(int member_id, int registered_book_id){
        LikesDto likesDto = new LikesDto(member_id, registered_book_id, Instant.now());
        return likesDao.addLikes(likesDto);
    }
}
