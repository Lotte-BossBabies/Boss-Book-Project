package bossbabies.com.a.service;

import bossbabies.com.a.dao.ApiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    @Autowired
    ApiDao dao;
}
