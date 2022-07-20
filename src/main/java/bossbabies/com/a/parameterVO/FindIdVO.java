package bossbabies.com.a.parameterVO;

public class FindIdVO {
    private String name;
    private String email;

    public FindIdVO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FindIdVO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
