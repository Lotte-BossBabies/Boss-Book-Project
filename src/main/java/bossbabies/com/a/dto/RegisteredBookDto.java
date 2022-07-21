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
public class RegisteredBookDto {

    private int registered_book_id;

    private int book_id;

    private int seller_id;

    private int order_count;

    private int book_count;

    private String register_date;

    private boolean sell_status;

    private Integer discount_rate;

    private String image_url;

    private String title;

    public RegisteredBookDto(int registered_book_id, int book_id, int seller_id, int order_count, int book_count, String register_date, boolean sell_status, Integer discount_rate) {
        this.registered_book_id = registered_book_id;
        this.book_id = book_id;
        this.seller_id = seller_id;
        this.order_count = order_count;
        this.book_count = book_count;
        this.register_date = register_date;
        this.sell_status = sell_status;
        this.discount_rate = discount_rate;
    }

    public RegisteredBookDto(int registered_book_id, int book_id, int seller_id, int order_count,
        int book_count, String register_date, boolean sell_status, Integer discount_rate,
        String image_url,
        String title) {
        this.registered_book_id = registered_book_id;
        this.book_id = book_id;
        this.seller_id = seller_id;
        this.order_count = order_count;
        this.book_count = book_count;
        this.register_date = register_date;
        this.sell_status = sell_status;
        this.discount_rate = discount_rate;
        this.image_url = image_url;
        this.title = title;
    }

    public int getRegistered_book_id() {
        return registered_book_id;
    }

    public void setRegistered_book_id(int registered_book_id) {
        this.registered_book_id = registered_book_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public int getOrder_count() {
        return order_count;
    }

    public void setOrder_count(int order_count) {
        this.order_count = order_count;
    }

    public int getBook_count() {
        return book_count;
    }

    public void setBook_count(int book_count) {
        this.book_count = book_count;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public boolean isSell_status() {
        return sell_status;
    }

    public void setSell_status(boolean sell_status) {
        this.sell_status = sell_status;
    }

    public Integer getDiscount_rate() {
        return discount_rate;
    }

    public void setDiscount_rate(Integer discount_rate) {
        this.discount_rate = discount_rate;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "RegisteredBookDto{" +
                "registered_book_id=" + registered_book_id +
                ", book_id=" + book_id +
                ", seller_id=" + seller_id +
                ", order_count=" + order_count +
                ", book_count=" + book_count +
                ", register_date=" + register_date +
                ", sell_status=" + sell_status +
                ", discount_rate=" + discount_rate +
                ", image_url=" + image_url +
                ", title=" + title +
                '}';
    }
}
