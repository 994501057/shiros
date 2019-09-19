package global.com.dao.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@JsonSerialize(
        include = Inclusion.NON_NULL
)
public class ApplyPersonInfo implements Serializable {
    private static final long serialVersionUID = -2033983662217735217L;
    private String userid;
    private String matchId;
    private String teamId;
    private String jsonparams;
    private Date applydate;
    private String astatus;
    private String auditOPinion;
    private String itemvalue;
    private String teamGroupId;
    private String idNum;
    private Integer isForeigner = 0;
    private String platform;
    private String gender;
    private String payno;
    private String applyType;
    private Map<String, Object> params;

    public ApplyPersonInfo() {
    }

    public Integer getIsForeigner() {
        return this.isForeigner;
    }

    public void setIsForeigner(Integer isForeigner) {
        this.isForeigner = isForeigner;
    }

    public String getIdNum() {
        return this.idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getTeamGroupId() {
        return this.teamGroupId;
    }

    public void setTeamGroupId(String teamGroupId) {
        this.teamGroupId = teamGroupId;
    }
    public String getItemValue() {
        return this.itemvalue;
    }

    public void setItemValue(String itemValue) {
        this.itemvalue = itemValue;
    }

    public String getPayNo() {
        return this.payno;
    }

    public void setPayNo(String payno) {
        this.payno = payno;
    }
    public String getAuditOPinion() {
        return this.auditOPinion;
    }

    public void setAuditOPinion(String auditOPinion) {
        this.auditOPinion = auditOPinion;
    }

    public String getApplyType() {
        return this.applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public Map<String, Object> getParams() {
        return this.params;
    }


    public String getJsonParams() {
        return this.jsonparams;
    }

    public void setJsonParams(String jsonParams) {
        this.jsonparams = jsonParams;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Date getApplyDate() {
        return this.applydate;
    }

    public void setApplyDate(Date applyDate) {
        this.applydate = applyDate;
    }

    public String getAstatus() {
        return this.astatus;
    }

    public void setAstatus(String astatus) {
        this.astatus = astatus;
    }

    public String getUserId() {
        return this.userid;
    }

    public void setUserId(String userId) {
        this.userid = userId;
    }

    public String getMatchId() {
        return this.matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}