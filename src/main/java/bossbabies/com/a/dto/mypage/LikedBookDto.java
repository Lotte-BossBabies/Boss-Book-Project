package bossbabies.com.a.dto.mypage;

import java.io.Serializable;

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
