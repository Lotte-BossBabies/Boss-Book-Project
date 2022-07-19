package bossbabies.com.a.dto;

import java.io.Serializable;
import java.util.Date;

public class OrderDto implements Serializable {

    private int orderId;
    private int memberId;

    private int registered_book_id;
    private boolean cancel_status;
    private Date order_date;
    private boolean delivery_status;

    public OrderDto(){

    }

    public OrderDto(int orderId, int memberId, int registered_book_id, boolean cancel_status, Date order_date, boolean delivery_status) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.registered_book_id = registered_book_id;
        this.cancel_status = cancel_status;
        this.order_date = order_date;
        this.delivery_status = delivery_status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public boolean isDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(boolean delivery_status) {
        this.delivery_status = delivery_status;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderId=" + orderId +
                ", memberId=" + memberId +
                ", registered_book_id=" + registered_book_id +
                ", cancel_status=" + cancel_status +
                ", order_date=" + order_date +
                ", delivery_status=" + delivery_status +
                '}';
    }
}
