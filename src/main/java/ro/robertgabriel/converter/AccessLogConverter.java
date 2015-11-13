package ro.robertgabriel.converter;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import ro.robertgabriel.model.AccessLogModel;

public class AccessLogConverter {

    public static AccessLogModel toItem(DBObject dbObject) {
        AccessLogModel accessLogModel = new AccessLogModel();
        ObjectId id = (ObjectId) dbObject.get("_id");
        accessLogModel.setId(id.toString());
        accessLogModel.setIp(dbObject.get("ip").toString());
        accessLogModel.setCreatedFromString(dbObject.get("created").toString());
        accessLogModel.setUrlPath(dbObject.get("url_path").toString());
        accessLogModel.setUserAgent(dbObject.get("user_agent").toString());
        accessLogModel.setRequestTime(dbObject.get("request_time").toString());
        return accessLogModel;
    }

    public static DBObject toDBObject(AccessLogModel accessLogModel) {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("ip", accessLogModel.getIp())
                .append("created", accessLogModel.getCreatedString())
                .append("url_path", accessLogModel.getUrlPath())
                .append("request_time", accessLogModel.getRequestTime())
                .append("user_agent", accessLogModel.getUserAgent());

        if (accessLogModel.getId() != null){
            builder = builder.append("_id", new ObjectId(accessLogModel.getId()));
        }
        return  builder.get();
    }
}
