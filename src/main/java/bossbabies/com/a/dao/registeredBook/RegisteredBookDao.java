package bossbabies.com.a.dao.registeredBook;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.parameterVO.BookAndSellerVO;
import bossbabies.com.a.parameterVO.CategoryAndKeywordVO;
import bossbabies.com.a.parameterVO.IdAndCountVO;
import bossbabies.com.a.parameterVO.RegisterBookVO;
import bossbabies.com.a.parameterVO.SellerAndCategoryVO;
import bossbabies.com.a.parameterVO.StatusAndRegisteredBookIdVO;
import java.util.List;

public interface RegisteredBookDao {

    List<RegisteredBookDto> getRegisteredBookList(SellerAndCategoryVO vo);

    List<RegisteredBookDto> getRegisteredAllBookList(SellerAndCategoryVO vo);

    public List<RegisteredBookDto> getRegisteredBookListBySellCount(SellerAndCategoryVO vo);

    List<RegisteredBookDto> getRegisteredAllBookListBySellCount(SellerAndCategoryVO vo);

    public List<RegisteredBookDto> getRegisteredBookListByKeyword(CategoryAndKeywordVO vo);

    List<RegisteredBookDto> getRegisteredAllBookListByKeyword(CategoryAndKeywordVO vo);

    public int updateStock(IdAndCountVO vo);

    List<BookDto> getBookListNotRegistered(SellerAndCategoryVO vo);

    List<BookDto> getBookListNotRegisteredByKeyword(CategoryAndKeywordVO vo);

    RegisteredBookDto checkBookRegistered(BookAndSellerVO vo);

    int updateRegisteredBook(StatusAndRegisteredBookIdVO vo);

    int updateDeliveryCompleted(StatusAndRegisteredBookIdVO vo);

    int registerBook(RegisterBookVO vo);

    BookDto getBookDetail(int bookId);

    RegisteredBookDto getRegisteredBookById(int registered_book_id);

    boolean updateOrderCount(int registered_book_id);

}
