package bossbabies.com.a.parameterVO;

public class IdAndCountVO {

    private int registeredBookId;
    private int newCount;

    public IdAndCountVO(int registeredBookId, int newCount) {
        this.registeredBookId = registeredBookId;
        this.newCount = newCount;
    }

    public int getRegisteredBookId() {
        return registeredBookId;
    }

    public int getNewCount() {
        return newCount;
    }
}
