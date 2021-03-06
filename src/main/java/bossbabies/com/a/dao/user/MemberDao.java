package bossbabies.com.a.dao.user;

import bossbabies.com.a.dto.user.MemberDto;
import bossbabies.com.a.parameterVO.FindIdVO;
import bossbabies.com.a.parameterVO.FindPasswordVO;
import bossbabies.com.a.parameterVO.LoginVO;
import bossbabies.com.a.parameterVO.UpdateMemberVO;

public interface MemberDao {
    int regiMember(MemberDto dto);
    MemberDto loginMember(LoginVO vo);

    MemberDto getMember(String id);

    int updateMember(UpdateMemberVO vo);
    String findMemberId(FindIdVO vo);
    String findMemberPassword(FindPasswordVO vo);
    String memberDuplicateId(String id);
}
