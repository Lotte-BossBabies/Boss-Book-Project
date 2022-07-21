package bossbabies.com.a.service;

import bossbabies.com.a.dao.user.SellerDao;
import bossbabies.com.a.dto.user.SellerDto;
import bossbabies.com.a.parameterVO.FindIdVO;
import bossbabies.com.a.parameterVO.FindPasswordVO;
import bossbabies.com.a.parameterVO.LoginVO;
import bossbabies.com.a.parameterVO.UpdateSellerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService{
    @Autowired
    SellerDao dao;

    @Override
    public int regiSeller(SellerDto sellerDto) {
        return dao.regiSeller(sellerDto);
    }

    @Override
    public SellerDto loginSeller(LoginVO vo) {
        return dao.loginSeller(vo);
    }

    @Override
    public SellerDto getSeller(String id) {
        return dao.getSeller(id);
    }

    @Override
    public int updateSeller(UpdateSellerVO vo) {
        return dao.updateSeller(vo);
    }

    @Override
    public String findSellerId(FindIdVO vo) {
        return dao.findSellerId(vo);
    }

    @Override
    public String findSellerPassword(FindPasswordVO vo) {
        return dao.findSellerPassword(vo);
    }
}
