package demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import demo.Utils.ObjectIdUtil;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "xet_nghiem")
public class XetNghiemModel {
    @Id
    public ObjectId id;
    public ObjectId hoSoBenhAnId;
    public ObjectId benhNhanId;
    public ObjectId coSoKhamBenhId;
    public int trangThai;
    public String idhis;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date ngayYeuCau;

    public CanBoYTeModel bacSiYeuCau;

    public String noiDungYeuCau;


    public DanhMucModel dmLoaiXetNghiem;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date ngayThucHien;

    public CanBoYTeModel bacSyXetNghiem;
    public String nhanXet;

    public List<FileDinhKemModel> dsFileDinhKemXetNghiem = new ArrayList<>();


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class DichVuXetNghiem {

        public DanhMucModel dmXetNghiem;
        public List<XetNghiemKetQua> dsKetQuaXetNghiem = new ArrayList<XetNghiemKetQua>();

        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class XetNghiemKetQua {
            public DanhMucModel dmDichVuKetQuaXetNghiem;

            public DanhMucModel dmChiSoXetNghiem;

            public String giaTriDo;
        }

    }


    public List<DichVuXetNghiem> dsDichVuXetNghiem = new ArrayList<>();


    public String getId() {
        return ObjectIdUtil.IdtoString(id);
    }

    public void setId(String id) {
        this.id = ObjectIdUtil.StringtoId(id);
    }

    public String getHoSoBenhAnId() {
        return ObjectIdUtil.IdtoString(hoSoBenhAnId);
    }

    public void setHoSoBenhAnId(String hoSoBenhAnId) {
        this.hoSoBenhAnId = ObjectIdUtil.StringtoId(hoSoBenhAnId);
    }

    public String getBenhNhanId() {
        return ObjectIdUtil.IdtoString(benhNhanId);
    }

    public void setBenhNhanId(String benhNhanId) {
        this.benhNhanId = ObjectIdUtil.StringtoId(benhNhanId);
    }

    public String getCoSoKhamBenhId() {
        return ObjectIdUtil.IdtoString(coSoKhamBenhId);
    }

    public void setCoSoKhamBenhId(String coSoKhamBenhId) {
        this.coSoKhamBenhId = ObjectIdUtil.StringtoId(coSoKhamBenhId);
    }
}
