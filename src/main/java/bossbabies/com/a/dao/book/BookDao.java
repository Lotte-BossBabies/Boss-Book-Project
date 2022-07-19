package bossbabies.com.a.dao.book;

import bossbabies.com.a.dto.BookDto;

public interface BookDao {

    BookDto getBookById(String book_id);
}
