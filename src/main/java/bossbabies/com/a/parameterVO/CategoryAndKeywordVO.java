package bossbabies.com.a.parameterVO;

public class CategoryAndKeywordVO {

    private String category;
    private String keyword;
    private int sellerId;

    public CategoryAndKeywordVO(String category, String keyword) {
        this.category = category;
        this.keyword = keyword;
    }

    public CategoryAndKeywordVO(String category, String keyword, int sellerId) {
        this.category = category;
        this.keyword = keyword;
        this.sellerId = sellerId;
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
}
