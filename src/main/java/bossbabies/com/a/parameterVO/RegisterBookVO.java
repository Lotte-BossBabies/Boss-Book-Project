package bossbabies.com.a.parameterVO;

public class RegisterBookVO {

    private int bookId;
    private int sellerId;
    private int bookCount;
    private int discountRate;

    public RegisterBookVO(int bookId, int sellerId, int bookCount, int discountRate) {
        this.bookId = bookId;
        this.sellerId = sellerId;
        this.bookCount = bookCount;
        this.discountRate = discountRate;
    }

    public int getSellerId() {
        return sellerId;
    }

    public int getBookCount() {
        return bookCount;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public int getBookId() {
        return bookId;
    }
}
