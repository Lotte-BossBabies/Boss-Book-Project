package bossbabies.com.a.parameterVO;

public class IdAndCountVO {

    private int registeredBookId;
    private int newCount;

    private int discount;

    public IdAndCountVO(int registeredBookId, int newCount, int discount) {
        this.registeredBookId = registeredBookId;
        this.newCount = newCount;
        this.discount = discount;
    }

    public int getRegisteredBookId() {
        return registeredBookId;
    }

    public int getNewCount() {
        return newCount;
    }

    public int getDiscount() {
        return discount;
    }
}
