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
    private Integer bookId;
    private Integer likeId;
    private String title;
    private Integer price;
    private String imageUrl;


    public LikedBookDto() {
    }

    public LikedBookDto(Integer bookId, Integer likeId, String title, Integer price, String imageUrl) {
        this.bookId = bookId;
        this.likeId = likeId;
        this.title = title;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(Integer book_id) {
        this.bookId = book_id;
    }

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer like_id) {
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

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
