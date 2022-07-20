package bossbabies.com.a.dao.user;

import bossbabies.com.a.dto.user.MemberDto;
import bossbabies.com.a.dto.user.SellerDto;
import bossbabies.com.a.parameterVO.LoginVO;
import bossbabies.com.a.parameterVO.UpdateSellerVO;

public interface SellerDao {
    int regiSeller(SellerDto sellerDto);

    SellerDto loginSeller(LoginVO vo);

    SellerDto getSeller(String id);
    int updateSeller(UpdateSellerVO vo);
}
