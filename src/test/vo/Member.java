package test.vo;

import java.sql.Date;

public class Member {
    private String id;
    private String pwd;
    private String email;
    private int age;
    private Date regdate;
    private String name;
    private int age1;

    public Member() {
    }

    public Member(String id, String pwd, String email, int age, Date regdate, String name, int age1) {
        super();
        this.id = id;
        this.pwd = pwd;
        this.email = email;
        this.age = age;
        this.regdate = regdate;
        this.name = name;
        this.age1 = age1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

}
