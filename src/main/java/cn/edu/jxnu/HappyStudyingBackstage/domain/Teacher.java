package cn.edu.jxnu.HappyStudyingBackstage.domain;

public class Teacher {
    private String tId;
    private String tName;
    private String tSex;
    private String tCollege;
    private String tTitle;

    public Teacher() {
    }
    public Teacher(String tId, String tName, String tSex, String tCollege, String tTitle) {
        this.tId = tId;
        this.tName = tName;
        this.tSex = tSex;
        this.tCollege = tCollege;
        this.tTitle = tTitle;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tId='" + tId + '\'' +
                ", tName='" + tName + '\'' +
                ", tSex='" + tSex + '\'' +
                ", tCollege='" + tCollege + '\'' +
                ", tTitle='" + tTitle + '\'' +
                '}';
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettSex() {
        return tSex;
    }

    public void settSex(String tSex) {
        this.tSex = tSex;
    }

    public String gettCollege() {
        return tCollege;
    }

    public void settCollege(String tCollege) {
        this.tCollege = tCollege;
    }

    public String gettTitle() {
        return tTitle;
    }

    public void settTitle(String tTitle) {
        this.tTitle = tTitle;
    }
}
