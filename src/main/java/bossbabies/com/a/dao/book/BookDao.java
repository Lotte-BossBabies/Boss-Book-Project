package bossbabies.com.a.dao.book;

import bossbabies.com.a.dto.BookDto;

import java.util.List;

public interface BookDao {
    BookDto getBookById(int book_id);
    List<BookDto> topOfFindByPubdate();
}
