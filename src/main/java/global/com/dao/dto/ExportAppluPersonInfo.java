package global.com.dao.dto;

public class ExportAppluPersonInfo {
    private String apply_channel;
    private String marathontype;
    private String phone;
    private String lover_phone;
    private String name;
    private String lover_name;
    private String country;
    private String isForeigner;
    private String gender;
    private String lover_gender;
    private String bloodtype;
    private String lover_bloodtype;
    private String age;
    private String lover_age;
    private String emgerconcat;
    private String emcp;
    private String idType;
    private String lover_idType;
    private String idNumber;
    private String lover_idNumber;

    public ExportAppluPersonInfo() {
    }

    @Override
    public String toString() {
        return "ExportAppluPersonInfo{" +
                "marathontype='" + marathontype + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodtype=" + bloodtype +
                ", age='" + age + '\'' +
                ", emgerconcat='" + emgerconcat + '\'' +
                ", emcp='" + emcp + '\'' +
                ", idType='" + idType + '\'' +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }

    public String getIsForeigner() {
        return isForeigner;
    }

    public void setIsForeigner(String isForeigner) {
        this.isForeigner = isForeigner;
    }

    public String getApply_channel() {
        return apply_channel;
    }

    public void setApply_channel(String apply_channel) {
        this.apply_channel = apply_channel;
    }

    public String getLover_phone() {
        return lover_phone;
    }

    public void setLover_phone(String lover_phone) {
        this.lover_phone = lover_phone;
    }

    public String getLover_name() {
        return lover_name;
    }

    public void setLover_name(String lover_name) {
        this.lover_name = lover_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLover_gender() {
        return lover_gender;
    }

    public void setLover_gender(String lover_gender) {
        this.lover_gender = lover_gender;
    }

    public String getLover_bloodtype() {
        return lover_bloodtype;
    }

    public void setLover_bloodtype(String lover_bloodtype) {
        this.lover_bloodtype = lover_bloodtype;
    }

    public String getLover_age() {
        return lover_age;
    }

    public void setLover_age(String lover_age) {
        this.lover_age = lover_age;
    }

    public String getLover_idType() {
        return lover_idType;
    }

    public void setLover_idType(String lover_idType) {
        this.lover_idType = lover_idType;
    }

    public String getLover_idNumber() {
        return lover_idNumber;
    }

    public void setLover_idNumber(String lover_idNumber) {
        this.lover_idNumber = lover_idNumber;
    }
    public String getMarathontype() {
        return marathontype;
    }

    public void setMarathontype(String marathontype) {
        this.marathontype = marathontype;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmgerconcat() {
        return emgerconcat;
    }

    public void setEmgerconcat(String emgerconcat) {
        this.emgerconcat = emgerconcat;
    }

    public String getEmcp() {
        return emcp;
    }

    public void setEmcp(String emcp) {
        this.emcp = emcp;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
