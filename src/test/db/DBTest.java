package db;

<<<<<<< HEAD
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
=======
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
>>>>>>> 046ef80bbeda88042a02de2dfb23b7a6f795a0c0
public class DBTest {

    @Autowired
    SqlSession session;

    String ns = "Text.";

    @Test
    public void test() {

<<<<<<< HEAD
        TestDto dto = session.selectOne(ns + "test");
=======
        //dao.getRegisteredBookList("소설");
        List<TestDto> dto = session.selectList(ns + "aaa");
>>>>>>> 046ef80bbeda88042a02de2dfb23b7a6f795a0c0
        System.out.println(dto.toString());

    }
}