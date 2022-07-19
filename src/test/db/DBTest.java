package db;

import bossbabies.com.a.dao.registeredBook.RegisteredBookDao;
import bossbabies.com.a.dao.registeredBook.RegisteredBookDaoImpl;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/applicationContext.xml",
    "file:src/main/webapp/WEB-INF/spring/servlet-context.xml"})
public class DBTest {

    @Autowired
    SqlSession session;

    String ns = "Text.";

    @Test
    public void test() {

        //dao.getRegisteredBookList("소설");
        List<TestDto> dto = session.selectList(ns + "aaa");
        System.out.println(dto.toString());

    }
}