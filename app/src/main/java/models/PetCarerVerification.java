package models;

/**
 * Created by SumitBhatia on 9/06/15.
 */
public class PetCarerVerification {
    private String title;
    private String info;
    private Boolean isIcon;
    private String value;
    private Integer qualificationIconImageId;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getIsIcon() {
        return isIcon;
    }

    public void setIsIcon(Boolean isIcon) {
        this.isIcon = isIcon;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getQualificationIconImageId() {
        return qualificationIconImageId;
    }

    public void setQualificationIconImageId(Integer qualificationIconImageId) {
        this.qualificationIconImageId = qualificationIconImageId;
    }
}
