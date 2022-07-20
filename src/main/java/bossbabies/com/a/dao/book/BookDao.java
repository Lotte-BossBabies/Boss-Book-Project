package bossbabies.com.a.dao.book;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.main.PopularBookInfoDto;
import bossbabies.com.a.dto.main.RegisteredBookInfoDto;

import java.util.List;

public interface BookDao {
    BookDto getBookById(int book_id);
    List<PopularBookInfoDto> topOfFindByStar();
    List<RegisteredBookInfoDto> topOfFindByOrderCount();

    List<RegisteredBookInfoDto> findByCategoryList(String cateName);
    List<RegisteredBookInfoDto> findByList();

}
