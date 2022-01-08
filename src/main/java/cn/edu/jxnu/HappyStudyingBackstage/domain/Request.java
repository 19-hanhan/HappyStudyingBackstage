package cn.edu.jxnu.HappyStudyingBackstage.domain;

import java.util.Date;

public class Request {
    private int tId;
    private String tActivityId;
    private Date tRequestTime;
    private String tWhy;

    public Request() {
    }
    public Request(int tId, String tActivityId, Date tRequestTime, String tWhy) {
        this.tId = tId;
        this.tActivityId = tActivityId;
        this.tRequestTime = tRequestTime;
        this.tWhy = tWhy;
    }

    @Override
    public String toString() {
        return "Request{" +
                "tId=" + tId +
                ", tActivityId='" + tActivityId + '\'' +
                ", tRequestTime=" + tRequestTime +
                ", tWhy='" + tWhy + '\'' +
                '}';
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettActivityId() {
        return tActivityId;
    }

    public void settActivityId(String tActivityId) {
        this.tActivityId = tActivityId;
    }

    public Date gettRequestTime() {
        return tRequestTime;
    }

    public void settRequestTime(Date tRequestTime) {
        this.tRequestTime = tRequestTime;
    }

    public String gettWhy() {
        return tWhy;
    }

    public void settWhy(String tWhy) {
        this.tWhy = tWhy;
    }
}
