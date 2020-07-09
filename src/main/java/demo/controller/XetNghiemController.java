package demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.Utils.CDRUtils;
import demo.model.XetNghiemModel;
import demo.service.HoSoBenhAnReponsitory;
import demo.service.XetNghiemService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xet_nghiem")
public class XetNghiemController {

    @Autowired private XetNghiemService xetNghiemService;
    @Autowired private HoSoBenhAnReponsitory hoSoBenhAnReponsitory;
    private ObjectMapper objectMapper= CDRUtils.createObjectMapper();

    @GetMapping("/get_all_xetnghiem")
    public List<XetNghiemModel> getAllXetNghiem(){
        return xetNghiemService.getAll();
    }

    @GetMapping("/get_xetnghiemById")
    public ResponseEntity<?> getXetNghiemById(@RequestParam("benhNhanId") String benhNhanId){
        var xetNghiemByIdList =xetNghiemService.getByBenhNhanId(new ObjectId(benhNhanId));
        return ResponseEntity.ok(xetNghiemByIdList);
    }





//    @GetMapping("/get_xetnghiemByHSBAId")
//    public ResponseEntity<?> getDsXetNghiem(@RequestParam("hsba_id") String id) {
//        var xetNghiemByHSBAId = xetNghiemService.getByHoSoBenhAnId(new ObjectId(id));
//        return ResponseEntity.ok(xetNghiemByHSBAId);
//    }
}
