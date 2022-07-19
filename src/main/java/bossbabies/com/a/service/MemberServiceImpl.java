package bossbabies.com.a.service;

import bossbabies.com.a.dao.user.MemberDao;
import bossbabies.com.a.dto.user.MemberDto;
import bossbabies.com.a.parameterVO.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDao dao;

    @Override
    public int regiMember(MemberDto memberDto) {
        return dao.regiMember(memberDto);
    }

    @Override
    public MemberDto loginMember(LoginVO vo) {
        return dao.loginMember(vo);
    }

    @Override
    public MemberDto getMember(String id) {
        return dao.getMember(id);
    }
}
