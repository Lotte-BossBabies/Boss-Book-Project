package bossbabies.com.a.dto.mypage;

import java.io.Serializable;

public class LikedBookDto implements Serializable {
    private int book_id;
    private int like_id;
    private String title;
    private int price;
    private String image_url;


    public LikedBookDto() {
    }

    public LikedBookDto(int book_id, int like_id, String title, int price, String image_url) {
        this.book_id = book_id;
        this.like_id = like_id;
        this.title = title;
        this.price = price;
        this.image_url = image_url;
    }

    public int getBookId() {
        return book_id;
    }

    public void setBookId(int book_id) {
        this.book_id = book_id;
    }

    public int getLikeId() {
        return like_id;
    }

    public void setLikeId(int like_id) {
        this.like_id = like_id;
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
        return image_url;
    }

    public void setImageUrl(String imageUrl) {
        this.image_url = imageUrl;
    }


}
