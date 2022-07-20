package bossbabies.com.a.dto;

import java.time.Instant;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]온라인도서쇼핑몰 구현 프로젝트
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.19       천예원         신규생성
 * -----------------------------------------------------------
 */
public class LikesDto {

    private int like_id;

    private int member_id;

    private int registered_book_id;

    private Instant like_date;

    public LikesDto(int member_id, int registered_book_id, Instant like_date) {
        this.member_id = member_id;
        this.registered_book_id = registered_book_id;
        this.like_date = like_date;
    }

    public LikesDto(int like_id, int member_id, int registered_book_id, Instant like_date) {
        this.like_id = like_id;
        this.member_id = member_id;
        this.registered_book_id = registered_book_id;
        this.like_date = like_date;
    }

    public int getLike_id() {
        return like_id;
    }

    public void setLike_id(int like_id) {
        this.like_id = like_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getRegistered_book_id() {
        return registered_book_id;
    }

    public void setRegistered_book_id(int registered_book_id) {
        this.registered_book_id = registered_book_id;
    }

    public Instant getLike_date() {
        return like_date;
    }

    public void setLike_date(Instant like_date) {
        this.like_date = like_date;
    }

    @Override
    public String toString() {
        return "LikesDto{" +
                "like_id=" + like_id +
                ", member_id=" + member_id +
                ", registered_book_id=" + registered_book_id +
                ", like_date=" + like_date +
                '}';
    }
}
