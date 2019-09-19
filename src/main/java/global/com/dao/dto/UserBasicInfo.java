package global.com.dao.dto;

import java.util.Date;
import java.util.Objects;

public class UserBasicInfo {
private Integer wid;
private String userId;
private String name;
private Integer age;
private String idno;
private String gener;
private String booldtype;
private String clothsize;
private String phone;
private String email;
private String address;
private String emgerconcat;
private String emgcellphone;
private Date borndate;
private String idtype;
private String idnumber;
private String healthPic;
private String bestScorePic;
private String degree;
private String province;
private String city;
private String bestscorematch;
private String annincome;
private String profession;
private String bestscoreitem;
private String bestScore;
private Date createtime;
private Date updateTime;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public String getBooldtype() {
        return booldtype;
    }

    public void setBooldtype(String booldtype) {
        this.booldtype = booldtype;
    }

    public String getClothsize() {
        return clothsize;
    }

    public void setClothsize(String clothsize) {
        this.clothsize = clothsize;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmgerconcat() {
        return emgerconcat;
    }

    public void setEmgerconcat(String emgerconcat) {
        this.emgerconcat = emgerconcat;
    }

    public String getEmgcellphone() {
        return emgcellphone;
    }

    public void setEmgcellphone(String emgcellphone) {
        this.emgcellphone = emgcellphone;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getHealthPic() {
        return healthPic;
    }

    public void setHealthPic(String healthPic) {
        this.healthPic = healthPic;
    }

    public String getBestScorePic() {
        return bestScorePic;
    }

    public void setBestScorePic(String bestScorePic) {
        this.bestScorePic = bestScorePic;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBestscorematch() {
        return bestscorematch;
    }

    public void setBestscorematch(String bestscorematch) {
        this.bestscorematch = bestscorematch;
    }

    public String getAnnincome() {
        return annincome;
    }

    public void setAnnincome(String annincome) {
        this.annincome = annincome;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getBestscoreitem() {
        return bestscoreitem;
    }

    public void setBestscoreitem(String bestscoreitem) {
        this.bestscoreitem = bestscoreitem;
    }

    public String getBestScore() {
        return bestScore;
    }

    public void setBestScore(String bestScore) {
        this.bestScore = bestScore;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBasicInfo that = (UserBasicInfo) o;
        return Objects.equals(wid, that.wid) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(age, that.age) &&
                Objects.equals(idno, that.idno) &&
                Objects.equals(gener, that.gener) &&
                Objects.equals(booldtype, that.booldtype) &&
                Objects.equals(clothsize, that.clothsize) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(address, that.address) &&
                Objects.equals(emgerconcat, that.emgerconcat) &&
                Objects.equals(emgcellphone, that.emgcellphone) &&
                Objects.equals(borndate, that.borndate) &&
                Objects.equals(idtype, that.idtype) &&
                Objects.equals(idnumber, that.idnumber) &&
                Objects.equals(healthPic, that.healthPic) &&
                Objects.equals(bestScorePic, that.bestScorePic) &&
                Objects.equals(degree, that.degree) &&
                Objects.equals(province, that.province) &&
                Objects.equals(city, that.city) &&
                Objects.equals(bestscorematch, that.bestscorematch) &&
                Objects.equals(annincome, that.annincome) &&
                Objects.equals(profession, that.profession) &&
                Objects.equals(bestscoreitem, that.bestscoreitem) &&
                Objects.equals(bestScore, that.bestScore) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wid, userId, name, age, idno, gener, booldtype, clothsize, phone, email, address, emgerconcat, emgcellphone, borndate, idtype, idnumber, healthPic, bestScorePic, degree, province, city, bestscorematch, annincome, profession, bestscoreitem, bestScore, createtime, updateTime);
    }

    @Override
    public String toString() {
        return "UserBasicInfo{" +
                "wid=" + wid +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", idno='" + idno + '\'' +
                ", gener='" + gener + '\'' +
                ", booldtype='" + booldtype + '\'' +
                ", clothsize='" + clothsize + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", emgerconcat='" + emgerconcat + '\'' +
                ", emgcellphone='" + emgcellphone + '\'' +
                ", borndate=" + borndate +
                ", idtype='" + idtype + '\'' +
                ", idnumber='" + idnumber + '\'' +
                ", healthPic='" + healthPic + '\'' +
                ", bestScorePic='" + bestScorePic + '\'' +
                ", degree='" + degree + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", bestscorematch='" + bestscorematch + '\'' +
                ", annincome='" + annincome + '\'' +
                ", profession='" + profession + '\'' +
                ", bestscoreitem='" + bestscoreitem + '\'' +
                ", bestScore='" + bestScore + '\'' +
                ", createtime=" + createtime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public UserBasicInfo(){
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}
