package bossbabies.com.a.parameterVO;

public class CategoryAndKeywordVO {

    private String category;
    private String keyword;
    private int sellerId;
    private int sellStatus;


    public CategoryAndKeywordVO(String category, String keyword) {
        this.category = category;
        this.keyword = keyword;
    }

    public CategoryAndKeywordVO(String category, String keyword, int sellerId, int sellStatus) {
        this.category = category;
        this.keyword = keyword;
        this.sellerId = sellerId;
        this.sellStatus = sellStatus;
    }

    public String getCategory() {
        return category;
    }

    public String getKeyword() {
        return keyword;
    }


    public int getSellerId() {
        return sellerId;
    }

    public int getSellStatus() {
        return sellStatus;
    }

}
