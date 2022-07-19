package bossbabies.com.a.service;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.LikesDto;
import bossbabies.com.a.dto.RegisteredBookDto;

public interface DetailedBookService {

    BookDto getBook(String book_id);

    RegisteredBookDto getRegisteredBook(String registered_book_id);

    boolean getLikeStatus(String member_id, String registered_book_id);
}
