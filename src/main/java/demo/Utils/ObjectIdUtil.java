package demo.Utils;

import org.bson.types.ObjectId;

public class ObjectIdUtil {
    public static String IdtoString(ObjectId id){
        return id != null ? id.toHexString() : null;
    }

    public static ObjectId StringtoId(String id){
        return id!= null ? new ObjectId(id) : null;
    }
}
