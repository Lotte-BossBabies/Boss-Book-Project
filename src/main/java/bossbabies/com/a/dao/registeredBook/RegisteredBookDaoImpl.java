package bossbabies.com.a.dao.registeredBook;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.parameterVO.BookAndSellerVO;
import bossbabies.com.a.parameterVO.CategoryAndKeywordVO;
import bossbabies.com.a.parameterVO.IdAndCountVO;
import bossbabies.com.a.parameterVO.RegisterBookVO;
import bossbabies.com.a.parameterVO.SellerAndCategoryVO;
import bossbabies.com.a.parameterVO.StatusAndRegisteredBookIdVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegisteredBookDaoImpl implements RegisteredBookDao{

    @Autowired
    SqlSession session;

    String namespace = "registeredBook.";

    /***
     * 카테고리별 상품 책 조회 메소드
     * @param vo
     * @return
     */
    @Override
    public List<RegisteredBookDto> getRegisteredBookList(SellerAndCategoryVO vo) {
        return session.selectList(namespace + "regiBookListByCategory", vo);
    }

    @Override
    public List<RegisteredBookDto> getRegisteredAllBookList(SellerAndCategoryVO vo) {
        return session.selectList(namespace + "regiBookListByAllCategory", vo);
    }

    /***
     * 카테고리별 상품 책 판매량 순 조회 메소드
     * @param vo
     * @return
     */
    @Override
    public List<RegisteredBookDto> getRegisteredBookListBySellCount(SellerAndCategoryVO vo) {
        return session.selectList(namespace + "regiBookListBySellCount", vo);
    }

    public List<RegisteredBookDto> getRegisteredAllBookListBySellCount(SellerAndCategoryVO vo) {
        return session.selectList(namespace + "regiAllBookListBySellCount", vo);
    }

    /***
     * 카테고리별 상품 책 키워드 조회 메소드
     * @param vo
     * @return
     */
    @Override
    public List<RegisteredBookDto> getRegisteredBookListByKeyword(CategoryAndKeywordVO vo) {
        return session.selectList(namespace + "regiBookListByKeyword", vo);
    }

    @Override
    public List<RegisteredBookDto> getRegisteredAllBookListByKeyword(CategoryAndKeywordVO vo) {
        return session.selectList(namespace + "regiAllBookListByKeyword", vo);
    }

    /***
     * 상품 책 재고량 수정 메소드
     * @param vo
     * @return
     */
    @Override
    public int updateStock(IdAndCountVO vo) {
        return session.update(namespace + "updateBookCountAndDiscount", vo);
    }

    @Override
    public List<BookDto> getBookListNotRegistered(SellerAndCategoryVO vo) {
        return session.selectList(namespace + "getBooks", vo);
    }

    @Override
    public List<BookDto> getBookListNotRegisteredByKeyword(CategoryAndKeywordVO vo) {
        return session.selectList(namespace + "getBooksByKeyword", vo);
    }

    @Override
    public RegisteredBookDto checkBookRegistered(BookAndSellerVO vo) {
        return session.selectOne(namespace + "checkBookRegistered", vo);
    }

    /***
     * 상품 책 등록 상태 수정 메소드 - 등록 목록에서 삭제
     * 1 -> 0 : 판매 등록 해지
     * 0 -> 1 : 판매 재등록
     * @param vo
     * @return
     */
    @Override
    public int updateRegisteredBook(StatusAndRegisteredBookIdVO vo) {
        return session.update(namespace + "updateSellStatus", vo);
    }

    /***
     * 판매 상품 배송완료 수정 메소드
     * @param vo
     * @return
     */
    @Override
    public int updateDeliveryCompleted(StatusAndRegisteredBookIdVO vo) {
        return session.update(namespace + "updateDeliveryStatus", vo);
    }

    @Override
    public int registerBook(RegisterBookVO vo) {
        return session.insert(namespace + "registerBook", vo);
    }

    @Override
    public BookDto getBookDetail(int bookId) {
        return session.selectOne(namespace + "getBookDetail", bookId);
    }

    @Override
    public RegisteredBookDto getRegisteredBookById(int registered_book_id){
        return session.selectOne(namespace+"getRegisteredBook", registered_book_id);
    }

    @Override
    public boolean updateOrderCount(int registered_book_id){
        int result = session.update(namespace+"updateOrderCount", registered_book_id);
        if(result == 0){
            return false;
        }
        return true;
    }


}
