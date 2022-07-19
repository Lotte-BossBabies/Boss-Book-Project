package bossbabies.com.a.dao.book;

import bossbabies.com.a.dto.BookDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]도서 데이터 삽입
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.18       김혜연         신규생성
 * -----------------------------------------------------------
 */
@Repository
public class BookApiDaoImpl implements BookApiDao{

    @Autowired
    SqlSession session;

    String ns = "Api.";

    public boolean insertData(List<BookDto> dtos) {

        int insert = -1;

        System.out.println("dto.size()" + dtos.size());
        for (int i = 0; i < dtos.size(); i++) {
            insert = session.insert(ns + "apiData", dtos.get(i));

            if (insert < 0) {
                return false;
            }
        }

        return true;
    }

    public List<BookDto> findAll() {
        return session.selectList(ns + "findAll");
    }
}
