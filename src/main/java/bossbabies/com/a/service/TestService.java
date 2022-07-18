package bossbabies.com.a.service;

import bossbabies.com.a.dao.TestDaoImpl;
import bossbabies.com.a.dto.TestDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestDaoImpl dao;

    public List<TestDto> getMember() {
        return dao.getMember();
    }


}
