package bossbabies.com.a.dto.mypage;

import java.io.Serializable;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]마이페이지
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.19       이성은         신규생성
 * -----------------------------------------------------------
 */
public class LikedBookDto implements Serializable {
    private int bookId;
    private int likeId;
    private String title;
    private int price;
    private String imageUrl;


    public LikedBookDto() {
    }

    public LikedBookDto(int bookId, int likeId, String title, int price, String imageUrl) {
        this.bookId = bookId;
        this.likeId = likeId;
        this.title = title;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int book_id) {
        this.bookId = book_id;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int like_id) {
        this.likeId = like_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
