package cn.edu.jxnu.HappyStudyingBackstage.domain;

public class admin {
    private int aId; // 管理员编号
    private String aPassword; // 管理员密码
    private String aName; // 管理员姓名
    private String aEmail; // 电子邮件

    public admin() { }
    public admin(String aPassword, String aName, String aEmail) {
        this.aPassword = aPassword;
        this.aName = aName;
        this.aEmail = aEmail;
    }
    public admin(int aId, String aPassword, String aName, String aEmail) {
        this.aId = aId;
        this.aPassword = aPassword;
        this.aName = aName;
        this.aEmail = aEmail;
    }

    @Override
    public String toString() {
        return "admin{" +
                "aId=" + aId +
                ", aPassword='" + aPassword + '\'' +
                ", aName='" + aName + '\'' +
                ", aEmail='" + aEmail + '\'' +
                '}';
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaEmail() {
        return aEmail;
    }

    public void setaEmail(String aEmail) {
        this.aEmail = aEmail;
    }
}
