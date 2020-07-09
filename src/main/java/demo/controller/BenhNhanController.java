package demo.controller;

import demo.Utils.CDRUtils;
import demo.Utils.JsonUtil;
import demo.model.BenhNhanModel;
import demo.service.BenhNhanService;
import org.apache.coyote.Response;
import demo.Utils.ResponseUtil;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/benhnhan")
public class BenhNhanController {

    private ObjectMapper objectMapper = CDRUtils.createObjectMapper();

    private @Autowired
    BenhNhanService benhNhanService;

    @GetMapping("/get_all_benhnhan")
    public List<BenhNhanModel> getAllBenhNhan(){
        return benhNhanService.getAll();
    }

    @GetMapping("/get_benhnhan/{id}")
    public BenhNhanModel getBenhNhan(@PathVariable("id") String id){
        return benhNhanService.getById(new ObjectId(id)).get();
    }
    @GetMapping("/get_benhnhan1/{idhis}")
    public BenhNhanModel getBenhNhanHis(@PathVariable("idhis") String idhis){
        return benhNhanService.getByIdhis(idhis);
    }

//    @GetMapping("/add_benhnhan")
////    public BenhNhanModel addBenhNhan(@RequestBody BenhNhanModel benhNhanModel){
////        return benhNhanService.add(benhNhanModel);
////    }

    @GetMapping("/count_benhnhan")
    public long countBenhNhan(@RequestParam String keyword){
        return benhNhanService.countBenhNhan(keyword);
    }

    @GetMapping("/seach_benhnhan")
    public ResponseEntity<?> seachBenhNhanh(@RequestParam String keyword,
                                         @RequestParam Optional<Integer> start,
                                         @RequestParam Optional<Integer> count){
        var benhNhans = benhNhanService.seachBenhNhan(keyword,start.orElse(-1), count.orElse(-1));
        return ResponseEntity.ok(benhNhans);
    }

    @PostMapping("/creatOrUpdate_benhnhan")
    public ResponseEntity<?> creatOrUpdateBenhNhan(@RequestBody String jsonSt) throws IOException {

        try{
            jsonSt = JsonUtil.preprocess(jsonSt);
            var map= JsonUtil.parseJson(jsonSt);
            var benhNhan = objectMapper.convertValue(map, BenhNhanModel.class);
            if(StringUtils.isEmpty(benhNhan.idDinhDanhChinh)){
                benhNhan.idDinhDanhChinh = benhNhan.idhis;
            }

            if(StringUtils.isEmpty(benhNhan.idDinhDanhChinh)){
                throw new RuntimeException("Empty idDinhDanhChinh");
            }

            benhNhan = benhNhanService.createOrUpdate(benhNhan,jsonSt);

            var result = Map.of(
                "success", true,
                "benhNhan", benhNhan
                );
            return ResponseEntity.ok(result);
            }catch(Exception e) {
            return ResponseUtil.errorResponse(e);
        }
    }

}
