package main.java.dao;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import main.java.converter.AccessLogConverter;
import main.java.model.AccessLogModel;
import org.bson.types.ObjectId;

public class MongoDBAccessLogDao extends MongoDB{

    private final DBCollection collection;

    public MongoDBAccessLogDao() {
        DB mongoClient = getDbConnection();
        this.collection = mongoClient.getCollection("access_logs");
    }

    public AccessLogModel createAccessLog(AccessLogModel accessLogModel) {
        DBObject dbObject = AccessLogConverter.toDBObject(accessLogModel);
        this.collection.insert(dbObject);
        ObjectId id = (ObjectId) dbObject.get("_id");
        accessLogModel.setId(id.toString());
        return accessLogModel;
    }
}
