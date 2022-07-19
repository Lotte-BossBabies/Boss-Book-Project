package bossbabies.com.a.dao;

import bossbabies.com.a.dto.BookDto;

import java.util.List;

public interface BookApiDao {
    boolean insertData(List<BookDto> dtos);
    List<BookDto> findAll();
}
