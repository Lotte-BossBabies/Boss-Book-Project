package bossbabies.com.a.parameterVO;

public class UpdateMemberVO {
    private String password;
    private String address;
    private String phone;
    private String id;

    public UpdateMemberVO(String password, String address, String phone, String id) {
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UpdateMemberVO{" +
                "password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
