package bossbabies.com.a.dto.mypage;

import java.io.Serializable;
import java.time.Instant;

/**
 * [프로젝트]롯데e커머스_자바전문가과정
 * [시스템명]마이페이지
 * [팀   명]BossBabies
 * -----------------------------------------------------------
 * 수정일자           수정자         수정내용
 * 2022.07.19       이성은         신규생성
 * -----------------------------------------------------------
 */

public class OrderedBookDto implements Serializable {
    private Integer bookId;
    private Integer orderId;
    private String title;
    private Integer price;
    private String imageUrl;
    private Instant orderDate;
    private boolean cancelStatus;
    private boolean deliveryStatus;

    public OrderedBookDto() {
    }

    public OrderedBookDto(Integer bookId, Integer orderId, String title, Integer price, String imageUrl, Instant orderDate, boolean cancelStatus, boolean deliveryStatus) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.title = title;
        this.price = price;
        this.imageUrl = imageUrl;
        this.orderDate = orderDate;
        this.cancelStatus = cancelStatus;
        this.deliveryStatus = deliveryStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
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

    public Instant getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isCancelStatus() {
        return cancelStatus;
    }

    public void setCancelStatus(boolean cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
