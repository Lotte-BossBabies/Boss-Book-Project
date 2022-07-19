package sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.parameterVO.CategoryAndKeywordVO;
import bossbabies.com.a.parameterVO.IdAndCountVO;
import bossbabies.com.a.parameterVO.StatusAndRegisteredBookIdVO;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/applicationContext.xml",
    "file:src/main/webapp/WEB-INF/spring/servlet-context.xml"})
public class RegisteredBookTest {

    @Autowired
    SqlSession session;

    String ns = "registeredBook.";

    @Test
    public void 상품_조회_카테고리별() {

        String category = "소설";

        List<RegisteredBookDto> list =  session.selectList(ns + "regiBookListByCategory", category);

        System.out.println(list.toString());

        assertThat(list.size()).isGreaterThan(0);


    }

    @Test
    public void 상품_조회_판매수() {

        String category = "소설";

        List<RegisteredBookDto> list = session.selectList(ns + "regiBookListBySellCount", category);

        System.out.println(list.toString());
        assertThat(list.size()).isGreaterThan(0);
    }

    @Test
    public void 상품_조회_키워드() {

        CategoryAndKeywordVO vo = new CategoryAndKeywordVO("소설", "한");

        List<RegisteredBookDto> list = session.selectList(ns + "regiBookListByKeyword", vo);

        System.out.println(list.toString());
        assertThat(list.size()).isGreaterThan(0);
    }

    @Test
    public void 수정_재고수() {

        IdAndCountVO vo = new IdAndCountVO(2, 200);

        int result = session.update(ns + "updateBookCount", vo);

        assertEquals(result, 1);
    }

    @Test
    public void 수정_상품판매상태() {

        StatusAndRegisteredBookIdVO vo = new StatusAndRegisteredBookIdVO(0,2);

        int result = session.update(ns + "updateSellStatus", vo);

        assertEquals(result, 1);
    }

    @Test
    public void 수정_상품배송완료상태() {

        StatusAndRegisteredBookIdVO vo = new StatusAndRegisteredBookIdVO(1, 11);

        int result = session.update(ns + "updateDeliveryStatus", vo);

        assertEquals(result, 1);
    }

}
