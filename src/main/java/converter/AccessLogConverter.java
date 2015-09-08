package main.java.converter;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import main.java.model.AccessLogModel;
import org.bson.types.ObjectId;

public class AccessLogConverter {

    public static AccessLogModel toItem(DBObject dbObject) {
        AccessLogModel accessLogModel = new AccessLogModel();
        ObjectId id = (ObjectId) dbObject.get("_id");
        accessLogModel.setId(id.toString());
        accessLogModel.setIp(dbObject.get("ip").toString());
        accessLogModel.setCreatedFromString(dbObject.get("created").toString());
        return accessLogModel;
    }

    public static DBObject toDBObject(AccessLogModel accessLogModel) {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("ip", accessLogModel.getIp())
                .append("created", accessLogModel.getCreatedString());

        if (accessLogModel.getId() != null){
            builder = builder.append("_id", new ObjectId(accessLogModel.getId()));
        }
        return  builder.get();
    }
}
