package bossbabies.com.a.dto;

public class TestDto {

    private int member_id;
    private String id;
    private String password;
    private String name;
    private String email;
    private String address;
    private String phone;

    public TestDto(int member_id, String id, String password, String name, String email,
        String address,
        String phone) {
        this.member_id = member_id;
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public int getMember_id() {
        return member_id;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "TestDto{" +
            "member_id=" + member_id +
            ", id='" + id + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            '}';
    }
}
