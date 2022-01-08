package cn.edu.jxnu.HappyStudyingBackstage.domain;

public class Student {
    private String sId;
    private String sName;
    private String sSex;
    private String sCollege;
    private String sClass;

    public Student() {
    }
    public Student(String sId, String sName, String sSex, String sCollege, String sClass) {
        this.sId = sId;
        this.sName = sName;
        this.sSex = sSex;
        this.sCollege = sCollege;
        this.sClass = sClass;
    }

    @Override
    public String toString() {
        return "TeacherDao{" +
                "sId='" + sId + '\'' +
                ", sName='" + sName + '\'' +
                ", sSex='" + sSex + '\'' +
                ", sCollege='" + sCollege + '\'' +
                ", sClass='" + sClass + '\'' +
                '}';
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsCollege() {
        return sCollege;
    }

    public void setsCollege(String sCollege) {
        this.sCollege = sCollege;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }
}
