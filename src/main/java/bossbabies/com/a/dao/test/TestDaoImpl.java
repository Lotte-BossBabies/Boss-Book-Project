package bossbabies.com.a.dao.test;

import bossbabies.com.a.dto.TestDto;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImpl implements TestDao {

    @Autowired
    SqlSession session;

    String ns = "Text.";

    @Override
    public List<TestDto> getMember() {
        return session.selectList(ns + "aaa");
    }


}
