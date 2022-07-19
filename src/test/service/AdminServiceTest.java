package service;

import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.parameterVO.StatusAndRegisteredBookIdVO;
import bossbabies.com.a.service.admin.AdminServiceImpl;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/applicationContext.xml",
    "file:src/main/webapp/WEB-INF/spring/servlet-context.xml"})
public class AdminServiceTest {

    @Autowired
    AdminServiceImpl service;

    @Test
    public void 상품_책_조회_카테고리() {

        int sellerId = 1;
        String category = "소설";

        List<RegisteredBookDto> list = service.getRegisteredBookList(sellerId, category);

        list.forEach(System.out::println);

        assertThat(list.size()).isGreaterThan(0);
    }

    @Test
    public void 상품_책_조회_판매수() {

        int sellerId = 1;
        String category = "소설";

        List<RegisteredBookDto> list = service.getRegisteredBookListBySellCount(sellerId, category);

        list.forEach(System.out::println);

        assertThat(list.size()).isGreaterThan(0);
    }

    @Test
    public void 상품_책_조회_키워드() {

        int sellerId = 1;
        String category = "소설";
        String keyword = "꿈";

        List<RegisteredBookDto> list = service.getRegisteredBookListByKeyword(sellerId, category, keyword);

        list.forEach(System.out::println);

        assertThat(list.size()).isGreaterThan(0);
    }

    @Test
    public void 상품_판매상태_수정() {

        int status = 0; // 판매 등록 해제
        int id = 13;

        int result = service.updateRegisteredBook(status, id);

        assertEquals(result, 1);
    }

}
