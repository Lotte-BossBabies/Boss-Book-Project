package bossbabies.com.a.dto.avg;

public class CategorySaleRateDto {

    private Integer sellerId;       // 판매자 아이디
    private String category;    // 카테고리
    private Integer orderCount;     // 주문횟수
    private double percent;     // 비율

    public CategorySaleRateDto() {
    }

    public CategorySaleRateDto(Integer sellerId, String category, Integer orderCount, double percent) {
        this.sellerId = sellerId;
        this.category = category;
        this.orderCount = orderCount;
        this.percent = percent;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "sellerId=" + sellerId +
                ", category='" + category + '\'' +
                ", orderCount=" + orderCount +
                ", percent=" + percent +
                '}';
    }
}
