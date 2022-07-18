package bossbabies.com.a.dao.registeredBook;

import bossbabies.com.a.dto.RegistedBookDto;
import bossbabies.com.a.parameterVO.CategoryAndKeywordVO;
import bossbabies.com.a.parameterVO.IdAndCountVO;
import bossbabies.com.a.parameterVO.StatusAndRegisteredBookIdVO;
import java.util.List;

public interface RegisteredBookDao {

    public List<RegistedBookDto> getRegisteredBookList(String category);

    public List<RegistedBookDto> getRegisteredBookListBySellCount(String category);

    public List<RegistedBookDto> getRegisteredBookListByKeyword(CategoryAndKeywordVO vo);

    public int updateStock(IdAndCountVO vo);

    public int updateRegisteredBook(StatusAndRegisteredBookIdVO vo);

    public int updateDeliveryCompleted(StatusAndRegisteredBookIdVO vo);

    // public List<BookDto> getBookList(String name);

}
