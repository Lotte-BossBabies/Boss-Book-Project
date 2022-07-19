package bossbabies.com.a.dao;

import bossbabies.com.a.dto.RegisteredBookDto;

public interface RegisteredBookDao {

    RegisteredBookDto getRegisteredBookById(String registered_book_id);

}
