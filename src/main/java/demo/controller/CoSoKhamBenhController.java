package demo.controller;


import demo.model.CoSoKhamBenhModel;
import demo.service.CoSoKhamBenhReponsitory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/co_so_kham_benh")
public class CoSoKhamBenhController {
    private @Autowired
    CoSoKhamBenhReponsitory co_so_kham_benhService;

    @GetMapping("/get_all_cosokhambenh")
    public List<CoSoKhamBenhModel> getAllCosokhambenh(){
        return co_so_kham_benhService.getAll();
    }

    @GetMapping("/get_cosokhambenh/{id}")
    public CoSoKhamBenhModel get_Cosokhambenh(@PathVariable("id") String id){
        return co_so_kham_benhService.getById(new ObjectId(id)).get();
    }

}
