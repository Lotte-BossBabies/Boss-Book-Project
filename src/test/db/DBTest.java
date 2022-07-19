package db;

import bossbabies.com.a.dto.TestDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DBTest {

    @Autowired
    SqlSession session;

    String ns = "Text.";

    @Test
    public void test() {

        TestDto dto = session.selectOne(ns + "test");
        System.out.println(dto.toString());

    }
}