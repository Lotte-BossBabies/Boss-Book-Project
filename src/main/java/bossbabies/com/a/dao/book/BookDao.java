package bossbabies.com.a.dao.book;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.main.RegisteredBookInfoDto;

import java.util.List;

public interface BookDao {
    BookDto getBookById(int book_id);
    BookDto getBookByRId(int r_book_id);
    List<BookDto> topOfFindByPubdate();
    List<RegisteredBookInfoDto> topOfFindByOrderCount();
}
