package bossbabies.com.a.service;

import bossbabies.com.a.dao.user.MemberDao;
import bossbabies.com.a.dto.user.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDao dao;

    @Override
    public int regiMember(MemberDto dto) {
        return dao.regiMember(dto);
    }
}
