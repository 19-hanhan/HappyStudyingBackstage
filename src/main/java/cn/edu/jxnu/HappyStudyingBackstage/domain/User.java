package cn.edu.jxnu.HappyStudyingBackstage.domain;

public class User {
    private int uId; // 用户编号
    private String uName; // 用户姓名
    private String aEmail; // 电子邮件
    private String uPassword; // 用户密码
    private String isPost; // 职位
    private String uNo; // 工号、学号
    private String uAvatar; // 用户头像
    private String uSubDivision; // 用户权限
    private String uDiamondNumber; // 钻石数

    public User() { }
    public User(int uId, String uName, String aEmail, String uPassword, String isPost, String uNo, String uSubDivision, String uDiamondNumber) {
        this.uId = uId;
        this.uName = uName;
        this.aEmail = aEmail;
        this.uPassword = uPassword;
        this.isPost = isPost;
        this.uNo = uNo;
        this.uSubDivision = uSubDivision;
        this.uDiamondNumber = uDiamondNumber;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", aEmail='" + aEmail + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", isPost='" + isPost + '\'' +
                ", uNo='" + uNo + '\'' +
                ", uAvatar='" + uAvatar + '\'' +
                ", uSubDivision='" + uSubDivision + '\'' +
                ", uDiamondNumber='" + uDiamondNumber + '\'' +
                '}';
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getaEmail() {
        return aEmail;
    }

    public void setaEmail(String aEmail) {
        this.aEmail = aEmail;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getIsPost() {
        return isPost;
    }

    public void setIsPost(String isPost) {
        this.isPost = isPost;
    }

    public String getuNo() {
        return uNo;
    }

    public void setuNo(String uNo) {
        this.uNo = uNo;
    }

    public String getuAvatar() {
        return uAvatar;
    }

    public void setuAvatar(String uAvatar) {
        this.uAvatar = uAvatar;
    }

    public String getuSubDivision() {
        return uSubDivision;
    }

    public void setuSubDivision(String uSubDivision) {
        this.uSubDivision = uSubDivision;
    }

    public String getuDiamondNumber() {
        return uDiamondNumber;
    }

    public void setuDiamondNumber(String uDiamondNumber) {
        this.uDiamondNumber = uDiamondNumber;
    }

}
