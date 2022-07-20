package bossbabies.com.a.service;

import bossbabies.com.a.dto.BookDto;
import bossbabies.com.a.dto.LikesDto;
import bossbabies.com.a.dto.RegisteredBookDto;
import bossbabies.com.a.dto.ReviewDto;
import bossbabies.com.a.dto.user.SellerDto;

import java.util.List;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]온라인도서쇼핑몰 구현 프로젝트
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.18       천예원         신규생성
 * -----------------------------------------------------------
 */
public interface DetailedBookService {

    BookDto getBook(int book_id);

    BookDto getBookByRId(int r_book_id);

    RegisteredBookDto getRegisteredBook(int registered_book_id);

    boolean getLikeStatus(int member_id, int registered_book_id);

    boolean addLikes(int member_id, int registered_book_id);

    boolean cancelLikes(int member_id, int registered_book_id);

    List<ReviewDto> getReviewByRBookId(int registered_book_id);

    double calculateStarAvg(List<ReviewDto> reviewList);

    boolean makeOrder(int member_id, int registered_book_id);

    int getLoginMember(String id);

    SellerDto getSeller(String id);
}
