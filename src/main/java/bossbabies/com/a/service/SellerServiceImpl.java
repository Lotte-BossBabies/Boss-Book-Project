package bossbabies.com.a.service;

import bossbabies.com.a.dao.user.SellerDao;
import org.springframework.beans.factory.annotation.Autowired;

public class SellerServiceImpl implements SellerService{
    @Autowired
    SellerDao dao;
}
