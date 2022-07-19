package bossbabies.com.a.parameterVO;

public class StatusAndRegisteredBookIdVO {

    private int status;
    private int registeredBookId;

    public StatusAndRegisteredBookIdVO(int status, int registeredBookId) {
        this.status = status;
        this.registeredBookId = registeredBookId;
    }

    public int getStatus() {
        return status;
    }

    public int getRegisteredBookId() {
        return registeredBookId;
    }
}
