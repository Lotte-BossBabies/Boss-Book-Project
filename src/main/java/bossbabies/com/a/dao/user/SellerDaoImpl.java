package bossbabies.com.a.dao.user;

import bossbabies.com.a.dto.user.MemberDto;
import bossbabies.com.a.dto.user.SellerDto;
import bossbabies.com.a.parameterVO.FindIdVO;
import bossbabies.com.a.parameterVO.FindPasswordVO;
import bossbabies.com.a.parameterVO.LoginVO;
import bossbabies.com.a.parameterVO.UpdateSellerVO;
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

    @Override
    public SellerDto getSellerBySId(int seller_id) {
        return session.selectOne(ns + "getSellerBySId", seller_id);
    }

    @Override
    public int updateSeller(UpdateSellerVO vo) {
        return session.update(ns + "updateSeller", vo);
    }

    @Override
    public String findSellerId(FindIdVO vo) {
        return session.selectOne(ns + "findSellerId", vo);
    }

    @Override
    public String findSellerPassword(FindPasswordVO vo) {
        return session.selectOne(ns + "findSellerPassword", vo);
    }

    @Override
    public String sellerDuplicateID(String id) {
        return session.selectOne(ns + "sellerDuplicateId", id);
    }
}
