package main.java.converter;

import com.mongodb.DBObject;
import main.java.model.ItemModel;
import org.bson.types.ObjectId;

public class ItemConverter {

    public static ItemModel toItem(DBObject dbObject) {
        ItemModel itemModel = new ItemModel();
        itemModel.setTitle((String) dbObject.get("title"));
        itemModel.setDescription((String) dbObject.get("description"));
        itemModel.setDate((String) dbObject.get("date"));
        itemModel.setListId((String) dbObject.get("list_id"));
        ObjectId id = (ObjectId) dbObject.get("_id");
        itemModel.setId(id.toString());
        return itemModel;
    }
}
