package bossbabies.com.a.parameterVO;

public class ReviewVO {
    private int memberId;
    private int bookId;
    private String content;
    private Integer star;

    public ReviewVO(int memberId, int bookId, String content, Integer star) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.content = content;
        this.star = star;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getBookId() {
        return bookId;
    }
}
