package bossbabies.com.a.dao.review;

import bossbabies.com.a.dto.ReviewDto;

import java.util.List;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]온라인도서쇼핑몰 구현 프로젝트
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.19       천예원         신규생성
 * -----------------------------------------------------------
 */
public interface ReviewDao {

    List<ReviewDto> getReviewByRBookId(int registered_book_id);

}
