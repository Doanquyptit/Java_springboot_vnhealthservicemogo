package demo.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Document(collection = "benh_nhan")
public class BenhNhanModel {

    @Id
    public ObjectId id;

    public String getId() { return id != null? id.toHexString() : null; }

    public int trangThai;

    public DanhMucModel dmGioiTinh;

    public DanhMucModel dmDanToc;

    public DanhMucModel dmQuocGia;

    public DanhMucModel dmNgheNghiep;

    public DanhMucModel dmPhuongXa;

    public DanhMucModel dmQuanHuyen;

    public DanhMucModel dmTinhThanh;

    public DanhMucModel dmNgheNghiepBo;

    public DanhMucModel dmNgheNghiepMe;

    public DanhMucModel dmLoaiDoiTuongTaiChinh;

    public String idDinhDanhChinh;

    public String idDinhDanhPhu;

    public String idhis;

    public String tenDayDu;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date ngaysinh;

    public String diachi;

    public String noilamviec;

    public String sobhyt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date ngayHetHanTheBhyt;

    public String hoTenBo;

    public String hoTenMe;

    public String tenNguoiBaoTin;

    public String diaChiNguoiBaoTin;

    public String soDienThoaiNguoiBaoTin;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date ngaySinhCuaBo;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date ngaySinhCuaMe;

    public String trinhDoVanHoaCuaBo;

    public String trinhDoVanHoaCuaMe;

    @JsonIgnore
    public ObjectId ttCaNhanId;

}