package bossbabies.com.a.parameterVO;

public class SellerAndCategoryVO {

    private int sellerId;
    private String category;

    public SellerAndCategoryVO(int sellerId, String category) {
        this.sellerId = sellerId;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public int getSellerId() {
        return sellerId;
    }
}
