package bossbabies.com.a.dto.avg;

import java.sql.Date;

public class SalesByPeriodDto {

    private Integer sellerId;       // 판매자 아이디
    private String orderDate;       // 주문 날짜
    private Integer countBook;      // 주문한 책 수
    private String category;        // 카테고리

    public SalesByPeriodDto() {
    }

    public SalesByPeriodDto(int sellerId, String orderDate, Integer countBook, String category) {
        this.sellerId = sellerId;
        this.orderDate = orderDate;
        this.countBook = countBook;
        this.category = category;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String  getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getCountBook() {
        return countBook;
    }

    public void setCountBook(int countBook) {
        this.countBook = countBook;
    }

    @Override
    public String toString() {
        return "SalesByPeriodDto{" +
                "sellerId=" + sellerId +
                ", orderDate=" + orderDate +
                ", countBook=" + countBook +
                ", category='" + category + '\'' +
                '}';
    }
}
