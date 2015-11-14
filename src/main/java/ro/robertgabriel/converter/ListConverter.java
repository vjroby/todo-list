package ro.robertgabriel.converter;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import ro.robertgabriel.model.ListModel;

public class ListConverter {

    // convert ListModel Object to MongoDB DBObject
    // take special note of converting id String to ObjectId
    public static DBObject toDBObject(ListModel listModel) {

        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("title", listModel.getTitle()).append("description", listModel.getDescription());

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
