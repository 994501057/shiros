package global.com.dao.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Map;

@JsonSerialize(
        include = JsonSerialize.Inclusion.NON_NULL
)
public class TeamApplyInfo {
    private static final long serialVersionUID = -461910611633601116L;
    private String matchId;
    private String teamId;
    private String teamName;
    private String teamAvatar;
    private String astatus;
    private String auditOPinion;
    private String userId;
    @JsonIgnore
    private String applyType;
    private String payNo;
    @JsonIgnore
    private String jsonParams;
    private Map<String, Object> params;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTeamAvatar() {
        return this.teamAvatar;
    }

    public void setTeamAvatar(String teamAvatar) {
        this.teamAvatar = teamAvatar;
    }

    public String getPayNo() {
        return this.payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
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

    public TeamApplyInfo() {
    }

    public String getAstatus() {
        return this.astatus;
    }

    public void setAstatus(String astatus) {
        this.astatus = astatus;
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

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getJsonParams() {
        return this.jsonParams;
    }

    public void setJsonParams(String jsonParams) {
        this.jsonParams = jsonParams;
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
