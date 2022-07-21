package bossbabies.com.a.dto.admin;

import java.io.Serializable;
import java.time.Instant;

public class DeliveryDto {

    private int order_id;
    private int member_id;
    private int registered_book_id;
    private boolean cancel_status;
    private String order_date;
    private boolean delivery_status;
    private String title;
    private String image_url;
    private String name;
    private String address;
    private String phone;

    public DeliveryDto(int order_id, int member_id, int registered_book_id, boolean cancel_status, String order_date, boolean delivery_status, String title, String image_url, String name, String address, String phone) {
        this.order_id = order_id;
        this.member_id = member_id;
        this.registered_book_id = registered_book_id;
        this.cancel_status = cancel_status;
        this.order_date = order_date;
        this.delivery_status = delivery_status;
        this.title = title;
        this.image_url = image_url;
        this.name = name;
        this.address = address;
        this.phone = phone;
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

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public boolean isDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(boolean delivery_status) {
        this.delivery_status = delivery_status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
