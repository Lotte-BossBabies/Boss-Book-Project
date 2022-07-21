package bossbabies.com.a.parameterVO;

public class UpdateSellerVO {
    private String password;
    private String store_name;
    private String phone;
    private String id;

    public UpdateSellerVO(String password, String store_name, String phone, String id) {
        this.password = password;
        this.store_name = store_name;
        this.phone = phone;
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
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
        return "UpdateSellerVO{" +
                "password='" + password + '\'' +
                ", store_name='" + store_name + '\'' +
                ", phone='" + phone + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
