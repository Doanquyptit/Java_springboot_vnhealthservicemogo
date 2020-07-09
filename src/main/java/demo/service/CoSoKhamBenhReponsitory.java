package demo.service;


import demo.model.CoSoKhamBenhModel;
import demo.respository.CoSoKhamBenhRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoSoKhamBenhReponsitory {
    @Autowired
    CoSoKhamBenhRepository co_so_kham_benhRepository;
    public List<CoSoKhamBenhModel> getAll() {
        return co_so_kham_benhRepository.findAll();
    }
    public Optional<CoSoKhamBenhModel> getById(ObjectId id){
        return co_so_kham_benhRepository.findById(id);
    }
    public Optional<CoSoKhamBenhModel> getByMa(String ma){
        return co_so_kham_benhRepository.findByMa(ma);
    }
}
