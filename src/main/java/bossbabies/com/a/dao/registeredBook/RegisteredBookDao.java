package bossbabies.com.a.dao.registeredBook;

import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.parameterVO.CategoryAndKeywordVO;
import bossbabies.com.a.parameterVO.IdAndCountVO;
import bossbabies.com.a.parameterVO.StatusAndRegisteredBookIdVO;
import java.util.List;

public interface RegisteredBookDao {

    public List<RegisteredBookDto> getRegisteredBookList(String category);

    public List<RegisteredBookDto> getRegisteredBookListBySellCount(String category);

    public List<RegisteredBookDto> getRegisteredBookListByKeyword(CategoryAndKeywordVO vo);

    public int updateStock(IdAndCountVO vo);

    public int updateRegisteredBook(StatusAndRegisteredBookIdVO vo);

    public int updateDeliveryCompleted(StatusAndRegisteredBookIdVO vo);

    // public List<BookDto> getBookList(String name);

}
