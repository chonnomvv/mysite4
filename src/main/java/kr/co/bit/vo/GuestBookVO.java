package kr.co.bit.vo;

public class GuestBookVO {
    private String name;
    private String password;
    private String content;
    private int no;
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public GuestBookVO(String name, String password, String content) {
        this.name = name;
        this.password = password;
        this.content = content;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "GuestBookVO{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", content='" + content + '\'' +
                ", no=" + no +
                ", date='" + date + '\'' +
                '}';
    }

    public GuestBookVO(int no, String name, String password, String content, String date) {
        this.name = name;
        this.password = password;
        this.content = content;
        this.no = no;
        this.date = date;
    }

    public GuestBookVO() {
    }
}
