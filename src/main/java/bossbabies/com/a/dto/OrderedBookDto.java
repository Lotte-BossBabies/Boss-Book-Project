package bossbabies.com.a.dto;

import java.io.Serializable;
import java.time.Instant;

public class OrderedBookDto implements Serializable {
    private int book_id;

    private int order_id;
    private String title;
    private int price;
    private String image_url;
    private Instant order_date;

    public OrderedBookDto() {
    }

    public OrderedBookDto(int book_id, int order_id, String title, int price, String image_url, Instant order_date) {
        this.book_id = book_id;
        this.order_id = order_id;
        this.title = title;
        this.price = price;
        this.image_url = image_url;
        this.order_date = order_date;
    }

    public int getBookId() {
        return book_id;
    }

    public void setBookId(int book_id) {
        this.book_id = book_id;
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

    public int getOrderId() {
        return order_id;
    }

    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }

    public Instant getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Instant order_date) {
        this.order_date = order_date;
    }
}
