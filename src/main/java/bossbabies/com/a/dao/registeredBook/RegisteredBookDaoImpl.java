package bossbabies.com.a.dao.registeredBook;

import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.parameterVO.CategoryAndKeywordVO;
import bossbabies.com.a.parameterVO.IdAndCountVO;
import bossbabies.com.a.parameterVO.StatusAndRegisteredBookIdVO;
import java.util.List;
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
     * @param category
     * @return
     */
    @Override
    public List<RegisteredBookDto> getRegisteredBookList(String category) {
        return null;
    }

    /***
     * 카테고리별 상품 책 판매량 순 조회 메소드
     * @param category
     * @return
     */
    @Override
    public List<RegisteredBookDto> getRegisteredBookListBySellCount(String category) {
        return null;
    }

    /***
     * 카테고리별 상품 책 키워드 조회 메소드
     * @param vo
     * @return
     */
    @Override
    public List<RegisteredBookDto> getRegisteredBookListByKeyword(CategoryAndKeywordVO vo) {
        return null;
    }

    /***
     * 상품 책 재고량 수정 메소드
     * @param vo
     * @return
     */
    @Override
    public int updateStock(IdAndCountVO vo) {
        return 0;
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
        return 0;
    }

    /***
     * 판매 상품 배송완료 수정 메소드
     * @param vo
     * @return
     */
    @Override
    public int updateDeliveryCompleted(StatusAndRegisteredBookIdVO vo) {
        return 0;
    }

    public RegisteredBookDto getRegisteredBookById(int registered_book_id){
        return session.selectOne(namespace+"getRegisteredBook", registered_book_id);
    }


}
