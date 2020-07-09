package demo.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import demo.Utils.ObjectIdUtil;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "logModel")
public class LogModel {
    @Id
    public ObjectId id;

    public String getId(){
        return ObjectIdUtil.IdtoString(id);
    }

    public void setId(String id){
        this.id= ObjectIdUtil.StringtoId(id);
    }

    public ObjectId nguoiThucHienId;

    public String maHanhDong;

    public Date ngayThucHien;

    public String noiDung;

    public String ghiChu;

    public String objectClass;

    public ObjectId objectId;
}
