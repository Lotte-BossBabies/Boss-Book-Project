package bossbabies.com.a.dto;

import java.time.Instant;

public class ReviewDto {

    private int review_id;

    private int member_id;

    private int registered_book_id;

    private String content;

    private int star;

    private Instant review_date;

    public ReviewDto(int review_id, int member_id, int registered_book_id, String content, int star, Instant review_date) {
        this.review_id = review_id;
        this.member_id = member_id;
        this.registered_book_id = registered_book_id;
        this.content = content;
        this.star = star;
        this.review_date = review_date;
    }

    public ReviewDto(int member_id, int registered_book_id, String content, int star, Instant review_date) {
        this.member_id = member_id;
        this.registered_book_id = registered_book_id;
        this.content = content;
        this.star = star;
        this.review_date = review_date;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Instant getReview_date() {
        return review_date;
    }

    public void setReview_date(Instant review_date) {
        this.review_date = review_date;
    }
}
