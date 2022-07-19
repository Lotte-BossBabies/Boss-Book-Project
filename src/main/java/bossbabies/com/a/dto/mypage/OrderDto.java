package bossbabies.com.a.dto.mypage;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public class OrderDto implements Serializable {

    private int order_id;
    private int member_id;

    private int registered_book_id;
    private boolean cancel_status;
    private Instant order_date;
    private boolean delivery_status;

    public OrderDto(){

    }

    public OrderDto(int order_id, int member_id, int registered_book_id, boolean cancel_status, Instant order_date, boolean delivery_status) {
        this.order_id = order_id;
        this.member_id = member_id;
        this.registered_book_id = registered_book_id;
        this.cancel_status = cancel_status;
        this.order_date = order_date;
        this.delivery_status = delivery_status;
    }

    public OrderDto(int member_id, int registered_book_id, boolean cancel_status, Instant order_date, boolean delivery_status) {
        this.member_id = member_id;
        this.registered_book_id = registered_book_id;
        this.cancel_status = cancel_status;
        this.order_date = order_date;
        this.delivery_status = delivery_status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public boolean isCancel_status() {
        return cancel_status;
    }

    public void setCancel_status(boolean cancel_status) {
        this.cancel_status = cancel_status;
    }

    public Instant getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Instant order_date) {
        this.order_date = order_date;
    }

    public boolean isDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(boolean delivery_status) {
        this.delivery_status = delivery_status;
    }
}
