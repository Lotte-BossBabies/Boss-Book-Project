package bossbabies.com.a.dao.user;

import bossbabies.com.a.dto.user.MemberDto;
import bossbabies.com.a.parameterVO.FindIdVO;
import bossbabies.com.a.parameterVO.FindPasswordVO;
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

    @Override
    public String findMemberId(FindIdVO vo) {
        return session.selectOne(ns + "findMemberId", vo);
    }

    @Override
    public String findMemberPassword(FindPasswordVO vo) {
        return session.selectOne(ns + "findMemberPassword", vo);
    }

    @Override
    public String memberDuplicateId(String id) {
        return session.selectOne(ns + "memberDuplicateId", id);
    }

}
