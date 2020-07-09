package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "co_so_kham_benh")
public class CoSoKhamBenhModel {

    @Id
    public ObjectId id;
    public String getId(){
        return id !=null ? id.toHexString() : null;
    }
    public int trangthai;

    public String ma;

    public String ten;

    public String donViChuQuan;

}
