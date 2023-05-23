package entity;

public class User {
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", gender='" + gender + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getGender() {
        return gender;
    }

    public String getAddr() {
        return addr;
    }

    public User(Integer id, String username, String PASSWORD, String gender, String addr) {
        this.id = id;
        this.username = username;
        this.PASSWORD = PASSWORD;
        this.gender = gender;
        this.addr = addr;
    }

    private Integer id;
    private String username;
    private String PASSWORD;
    private String gender;
    private String addr;
}
