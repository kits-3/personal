package tp.kits3.livedinner.model;

import java.sql.Timestamp;
//VO -> Value object (Entity , Model)
//Create CRUD
/* DB connect ,crud , convert -> complicate
 * Using DB framework 
 * -Mybatis   :already set db tables      :Spring MVC
 * -Hibernate :new db tables by developer :Spring Boot
 * 
 * path settings is very important
 * 1.config.xml 
 */
public class Book {

    private Integer bkid;

    private String bkname;

    private String bkemail;

    private String bkphone;

    private Timestamp bktime;

    private Integer bknum;

    private String booking;

    private String bkmemo;

    public Integer getBkid() {
        return bkid;
    }

    public void setBkid(Integer bkid) {
        this.bkid = bkid;
    }

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public String getBkemail() {
        return bkemail;
    }

    public void setBkemail(String bkemail) {
        this.bkemail = bkemail;
    }

    public String getBkphone() {
        return bkphone;
    }

    public void setBkphone(String bkphone) {
        this.bkphone = bkphone;
    }

    public Timestamp getBktime() {
        return bktime;
    }

    public void setBktime(Timestamp bktime) {
        this.bktime = bktime;
    }

    public Integer getBknum() {
        return bknum;
    }

    public void setBknum(Integer bknum) {
        this.bknum = bknum;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public String getBkmemo() {
        return bkmemo;
    }

    public void setBkmemo(String bkmemo) {
        this.bkmemo = bkmemo;
    }

    // Book 모델 복사
    public void CopyData(Book param)
    {
        this.bkid = param.getBkid();
        this.bkname = param.getBkname();
        this.bkemail = param.getBkemail();
        this.bkphone = param.getBkphone();
        this.bktime = param.getBktime();
        this.bknum = param.getBknum();
        this.booking = param.getBooking();
        this.bkmemo = param.getBkmemo();
    }
}