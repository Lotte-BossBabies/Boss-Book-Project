package bossbabies.com.a.dao.book;

import bossbabies.com.a.dto.BookDto;

public interface BookDao {

    BookDto getBookById(int book_id);
}
