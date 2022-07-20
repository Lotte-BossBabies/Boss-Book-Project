package bossbabies.com.a.dao.user;

import bossbabies.com.a.dto.user.MemberDto;
import bossbabies.com.a.parameterVO.LoginVO;
import bossbabies.com.a.parameterVO.UpdateMemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao{

    @Autowired
    SqlSession session;

    String ns = "Member.";

    @Override
    public int regiMember(MemberDto dto) {
        return session.insert(ns + "regiMember", dto);
    }

    @Override
    public MemberDto loginMember(LoginVO vo) {
        return session.selectOne(ns + "loginMember", vo);
    }

    @Override
    public MemberDto getMember(String id) {
        return session.selectOne(ns + "getMember", id);
    }

    @Override
    public int updateMember(UpdateMemberVO vo) {
        return session.update(ns + "updateMember", vo);
    }
}
