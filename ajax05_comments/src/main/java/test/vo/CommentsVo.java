package test.vo;

public class CommentsVo {
    private int num;
    private int mnum;
    private String id;
    private String comments;
    public CommentsVo(){}

    public CommentsVo(int num, int mnum, String id, String comments) {
        this.num = num;
        this.mnum = mnum;
        this.id = id;
        this.comments = comments;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMnum() {
        return mnum;
    }

    public void setMnum(int mnum) {
        this.mnum = mnum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
