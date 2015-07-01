package main.java.converter;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import main.java.model.ListModel;
import org.bson.types.ObjectId;

public class ListConverter {

    // convert ListModel Object to MongoDB DBObject
    // take special note of converting id String to ObjectId
    public static DBObject toDBObject(ListModel listModel) {

        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("title", listModel.getTitle()).append("desccription", listModel.getDescription());

        if (listModel.getId() != null)
            builder = builder.append("_id", new ObjectId(listModel.getId()));

        return builder.get();
    }

    public static ListModel toList(DBObject dbObject) {
        ListModel listModel = new ListModel();
        listModel.setTitle((String) dbObject.get("title"));
        listModel.setDescription((String) dbObject.get("description"));
        ObjectId id = (ObjectId) dbObject.get("_id");
        listModel.setId(id.toString());
        return listModel;
    }
}
