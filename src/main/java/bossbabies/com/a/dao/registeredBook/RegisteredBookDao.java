package bossbabies.com.a.dao.registeredBook;

import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.parameterVO.CategoryAndKeywordVO;
import bossbabies.com.a.parameterVO.IdAndCountVO;
import bossbabies.com.a.parameterVO.SellerAndCategoryVO;
import bossbabies.com.a.parameterVO.StatusAndRegisteredBookIdVO;
import java.util.List;

public interface RegisteredBookDao {

    public List<RegisteredBookDto> getRegisteredBookList(SellerAndCategoryVO vo);

    public List<RegisteredBookDto> getRegisteredBookListBySellCount(SellerAndCategoryVO vo);

    public List<RegisteredBookDto> getRegisteredBookListByKeyword(CategoryAndKeywordVO vo);

    public int updateStock(IdAndCountVO vo);

    public List<RegisteredBookDto> getBookListNotRegistered(int sellerId);

    public int updateRegisteredBook(StatusAndRegisteredBookIdVO vo);

    public int updateDeliveryCompleted(StatusAndRegisteredBookIdVO vo);

    // public List<BookDto> getBookList(String name);

    RegisteredBookDto getRegisteredBookById(int registered_book_id);

    boolean updateOrderCount(int registered_book_id);

}
