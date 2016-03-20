package ro.robertgabriel.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
@Document(collection = "access_logs")
public class AccessLogOld {

    public static final String CREATED_FORMAT = "yyyy-MM-dd hh:mm:ss";

    @Id
    private String id;
    private String Ip;
//    @DateTimeFormat
    private String created;
    private String urlPath;
    private String userAgent;
    private String requestTime;

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public String getCreated() {
        return created;
    }

//    public void setCreated(Date created) {
//        this.created = created;
//    }
    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedString() {
        SimpleDateFormat ft = new SimpleDateFormat(CREATED_FORMAT);
        return ft.format(this.created);
    }

//    public void setCreatedFromString(String dateString) {
//        SimpleDateFormat ft = new SimpleDateFormat(CREATED_FORMAT);
//        try {
//            this.created = ft.parse(dateString);
//        }catch (ParseException e){
//            System.out.println("Unparseable using " + ft);
//        }
//    }

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

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
