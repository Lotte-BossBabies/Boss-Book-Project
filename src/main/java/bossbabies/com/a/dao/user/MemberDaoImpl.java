package bossbabies.com.a.dao.user;

import bossbabies.com.a.dto.user.MemberDto;
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
}
