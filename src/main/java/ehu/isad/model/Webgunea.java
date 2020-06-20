package ehu.isad.model;

import java.sql.Timestamp;

public class Webgunea {

    private String url;
    private String cms;
    private String version;
    private Long lastupdated;
    private String screenshot;

    public Webgunea(String url, String cms, String version, Long lastupdated, String screenshot) {
        this.url = url;
        this.cms = cms;
        this.version = version;
        this.lastupdated = lastupdated;
        this.screenshot = screenshot;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCms() {
        return cms;
    }

    public void setCms(String cms) {
        this.cms = cms;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Long lastupdated) {
        this.lastupdated = lastupdated;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    @Override
    public String toString() {
        return "Webgunea{" +
                "url='" + url + '\'' +
                ", cms='" + cms + '\'' +
                ", version='" + version + '\'' +
                ", lastUpdated='" + lastupdated + '\'' +
                ", screenshot='" + screenshot + '\'' +
                '}';
    }
}
