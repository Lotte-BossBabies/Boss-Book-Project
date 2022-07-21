package bossbabies.com.a.parameterVO;

public class BookAndSellerVO {

    private int bookId;
    private int sellerId;

    public BookAndSellerVO(int bookId, int sellerId) {
        this.bookId = bookId;
        this.sellerId = sellerId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getSellerId() {
        return sellerId;
    }
}
