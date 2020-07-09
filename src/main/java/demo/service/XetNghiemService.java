package demo.service;

import demo.Utils.Constants;
import demo.model.XetNghiemModel;
import demo.respository.XetNghiemRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XetNghiemService {

    @Autowired
    private XetNghiemRepository xetNghiemRepository;

    @Autowired LogService logService;

//    public List<XetNghiemModel> getByHoSoBenhAnId(ObjectId hoSoBenhAnId) {
//        return xetNghiemRepository.findByHoSoBenhAnId(hoSoBenhAnId);
//    }

    public List<XetNghiemModel> getByBenhNhanId(ObjectId benhNhanId) {
        return xetNghiemRepository.findByBenhNhanId(benhNhanId);
    }

    public List<XetNghiemModel> getAll() {
        return xetNghiemRepository.findAll();
    }


}
