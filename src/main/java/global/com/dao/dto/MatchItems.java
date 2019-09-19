package global.com.dao.dto;

public class MatchItems {
    private String wid;
    private String matchId;
    private String itemtext;
    private String engitemtext;
    private String itemValue;
    private Integer limitnums;
    private Integer orders;
    private Integer canshow;
    private String shortItemText;

    public MatchItems() {
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getItemtext() {
        return itemtext;
    }

    public void setItemtext(String itemtext) {
        this.itemtext = itemtext;
    }

    public String getEngitemtext() {
        return engitemtext;
    }

    public void setEngitemtext(String engitemtext) {
        this.engitemtext = engitemtext;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public Integer getLimitnums() {
        return limitnums;
    }

    public void setLimitnums(Integer limitnums) {
        this.limitnums = limitnums;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Integer getCanshow() {
        return canshow;
    }

    public void setCanshow(Integer canshow) {
        this.canshow = canshow;
    }

    public String getShortItemText() {
        return shortItemText;
    }

    public void setShortItemText(String shortItemText) {
        this.shortItemText = shortItemText;
    }

    @Override
    public String toString() {
        return "MatchItems{" +
                "wid='" + wid + '\'' +
                ", matchId='" + matchId + '\'' +
                ", itemtext='" + itemtext + '\'' +
                ", engitemtext='" + engitemtext + '\'' +
                ", itemValue='" + itemValue + '\'' +
                ", limitnums=" + limitnums +
                ", orders=" + orders +
                ", canshow=" + canshow +
                ", shortItemText='" + shortItemText + '\'' +
                '}';
    }
}
