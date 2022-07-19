package bossbabies.com.a.parameterVO;

public class CategoryAndKeywordVO {

    private String category;
    private String keyword;

    public CategoryAndKeywordVO(String category, String keyword) {
        this.category = category;
        this.keyword = keyword;
    }

    public String getCategory() {
        return category;
    }

    public String getKeyword() {
        return keyword;
    }
}
