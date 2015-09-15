package main.java.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccessLogModel extends BaseModel{

    public static final String CREATED_FORMAT = "yyyy-MM-dd hh:mm:ss";

    private String Ip;

    private Date created;

    private String urlPath;

    private String userAgent;

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedString() {
        SimpleDateFormat ft = new SimpleDateFormat(CREATED_FORMAT);
        return ft.format(this.created);
    }

    public void setCreatedFromString(String dateString) {
        SimpleDateFormat ft = new SimpleDateFormat(CREATED_FORMAT);
        try {
            this.created = ft.parse(dateString);
        }catch (ParseException e){
            System.out.println("Unparseable using " + ft);
        }
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}