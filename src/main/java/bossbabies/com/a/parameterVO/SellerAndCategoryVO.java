package bossbabies.com.a.parameterVO;

public class SellerAndCategoryVO {

    private int sellerId;
    private String category;
    private int sellStatus;

    public SellerAndCategoryVO(int sellerId, String category, int sellStatus) {
        this.sellerId = sellerId;
        this.category = category;
        this.sellStatus = sellStatus;
    }

    public String getCategory() {
        return category;
    }

    public int getSellerId() {
        return sellerId;
    }

    public int getSellStatus() {
        return sellStatus;
    }
    
}
