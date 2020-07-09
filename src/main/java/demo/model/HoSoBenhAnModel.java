package demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import demo.Utils.ObjectIdUtil;
import demo.service.ServiceFactory;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document("Ho_so_benh_an")
public class HoSoBenhAnModel {

    @Id
    public ObjectId id;
    public String getId(){
        return id != null? id.toHexString() : null;
    }

    public DanhMucModel dmLoaiBenhAn;

    public ObjectId benhNhanId;

    public ObjectId coSoKhamBenhId;

    public int nguonDuLieu;

    public int trangThai;

    public String maYTe;

    public String maTraoDoi;

    public String maLuuTru;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date ngayTiepNhan;

    public String nguoiTiepNhan;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date ngayTao;

    public ObjectId nguoiTaoId;



    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class QuanLyNguoiBenh{
        public DanhMucModel dmNoiGioiThieu;

        public DanhMucModel dmLoaiRaVien;

        public DanhMucModel dmNoiTrucTiepVao;

        public DanhMucModel dmLoaiChuyenVien;

        public String soVaoVien;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        public Date ngayGioVaoVien;

        public int vaoVienLanThu;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        public Date ngayGioRaVien;

        public Integer tongSoNgayDieuTri;

        public String noiChuyenDen;
    }

    public QuanLyNguoiBenh quanLyNguoiBenh;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class TinhTrangRaVien{
        public DanhMucModel dmMaBenhNguyenNhanTuVong;
        public DanhMucModel dmKetQuaDieuTri;
        public DanhMucModel dmMaBenhGiaiPhauTuThi;
        public DanhMucModel dmKetQuaGiaiPhauBenh;
        public DanhMucModel dmLiDoTuVong;
        public DanhMucModel dmThoiDiemTuVong;

        public boolean khamNghiemTuThi;
        public String moTaNguyenNhanTuVong;
        public String moTaGiaiPhauTuThi;
    }

    public TinhTrangRaVien tinhTrangRaVien;


//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    public static class VaoKhoa {
//
//        public DanhMucModel dmKhoaDieuTri;
//
//        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//        public Date ngayGioVaoKhoa;
//
//        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//        public Date ngayKetThucDieuTri;
//
//        public String tenKhoa;
//        public CanBoYTeModel bacSiDieuTri;
//        public String phong;
//        public String giuong;
//        public Integer soNgayDieuTri;
//        public String tenTruongKhoa;
//    }


//    public Map<String, Object> benhAn;
//    public List<VaoKhoa> dsVaoKhoa = new ArrayList<>();

    public Map<String, Object> chanDoan = new HashMap<>();


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date ngayKyBenhAn;

    public CanBoYTeModel bacSyLamBenhAn;

    public String nguoiGiaoHoSo;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date ngayGiaoHoSo;

    public String nguoiNhanHoSo;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date ngaynhanhoso;

   // public CanBoYTeModel bacsyDieuTri;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date ngaybacSyDieuTriky;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ToDieuTri {
        public String ma;
        public String ten;
        public int soLuong;
    }
    public List<ToDieuTri> soToDieuTri = new ArrayList<>();

    public List<FileDinhKemModel> dsFileDinhKem = new ArrayList<>();

    public String GetId() {
        return ObjectIdUtil.IdtoString(id);
    }

    public void setId(String id) {
        this.id = ObjectIdUtil.StringtoId(id);
    }

//    public String getBenhNhanId(){
//        return ObjectIdUtil.IdtoString(id);
//    }
//
//    public BenhNhanModel getBenhNhan(){
//        return ServiceFactory.getBenhNhanService().getById(benhNhanId).orElse(null);
//    }
//
//    public void setBenhNhanId(String benhNhanId){
//        this.benhNhanId = ObjectIdUtil.StringtoId(benhNhanId);
//    }
//
//    public CoSoKhamBenhModel getCoSoKhamBenh() {
//        return ServiceFactory.getCo_so_kham_benhService().getById(coSoKhamBenhId).orElse(null);
//    }
//
//    public void setCoSoKhamBenhId(String coSoKhamBenhId){
//        this.coSoKhamBenhId = ObjectIdUtil.StringtoId(coSoKhamBenhId);
//    }
//
//    public String getNguoiTaoId() {
//        return ObjectIdUtil.IdtoString(nguoiTaoId);
//    }
//
//    public void setNguoiTaoId(String nguoiTaoId){
//        this.nguoiTaoId = ObjectIdUtil.StringtoId(nguoiTaoId);
//    }


//    public String getKhoaRaVien() {
//
//        if(dsVaoKhoa != null && dsVaoKhoa.size() > 0) {
//            var khoaRaVien = dsVaoKhoa.get(dsVaoKhoa.size() - 1);
//            var tenKhoaRaVien = khoaRaVien.tenKhoa;
//            if(StringUtils.isEmpty(tenKhoaRaVien) && khoaRaVien.dmKhoaDieuTri != null) {
//                tenKhoaRaVien = khoaRaVien.dmKhoaDieuTri.ten;
//            }
//            return tenKhoaRaVien;
//        }
//
//        return "";
//    }






}
