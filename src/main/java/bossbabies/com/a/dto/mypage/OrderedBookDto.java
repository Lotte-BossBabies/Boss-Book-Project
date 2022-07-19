package bossbabies.com.a.dto.mypage;

import java.io.Serializable;
import java.time.Instant;

public class OrderedBookDto implements Serializable {
    private int bookId;
    private int orderId;
    private String title;
    private int price;
    private String imageUrl;
    private Instant orderDate;

    public OrderedBookDto() {
    }

    public OrderedBookDto(int bookId, int orderId, String title, int price, String imageUrl, Instant orderDate) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.title = title;
        this.price = price;
        this.imageUrl = imageUrl;
        this.orderDate = orderDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int book_id) {
        this.bookId = book_id;
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int order_id) {
        this.orderId = order_id;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
    }
}
