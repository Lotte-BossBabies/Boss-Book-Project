package bossbabies.com.a.dto;

import java.io.Serializable;

public class MyPageDto implements Serializable {

    private int memberId;
    private String name;

    public MyPageDto() {
    }

    public MyPageDto(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
