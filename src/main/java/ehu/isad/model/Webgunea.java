package ehu.isad.model;

import ehu.isad.utils.Utils;
import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.Properties;

public class Webgunea {

    private String url;
    private String cms;
    private String version;
    private LocalDate lastupdated;
    private Image screenshot;

    private Properties properties = Utils.loadProperties();

    public Webgunea(String url, String cms, String version, LocalDate lastupdated, String screenshot) {
        this.url = url;
        this.cms = cms;
        this.version = version;
        this.lastupdated = lastupdated;
        String path = properties.getProperty("imagespath") + screenshot;
        try {
            this.screenshot = new Image(new File(path).toURI().toURL().toExternalForm());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
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

    public LocalDate getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(LocalDate lastupdated) {
        this.lastupdated = lastupdated;
    }

    public Image getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(Image screenshot) {
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
