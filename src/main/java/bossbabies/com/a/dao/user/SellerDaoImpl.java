package bossbabies.com.a.dao.user;

import bossbabies.com.a.dto.user.MemberDto;
import bossbabies.com.a.dto.user.SellerDto;
import bossbabies.com.a.parameterVO.LoginVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SellerDaoImpl implements SellerDao{

    @Autowired
    SqlSession session;
    String ns = "Seller.";
    @Override
    public int regiSeller(SellerDto sellerDto) {
        return session.insert(ns + "regiSeller", sellerDto);
    }

    @Override
    public SellerDto loginSeller(LoginVO vo) {
        return session.selectOne(ns + "loginSeller", vo);
    }

    @Override
    public SellerDto getSeller(String id) {
        return session.selectOne(ns + "getSeller", id);
    }
}
