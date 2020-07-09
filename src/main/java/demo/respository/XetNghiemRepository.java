package demo.respository;


import demo.model.XetNghiemModel;
import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface XetNghiemRepository extends MongoRepository<XetNghiemModel, ObjectId> {
    public Optional<XetNghiemModel> findByIdhis(String idhis);
    public List<XetNghiemModel> findByHoSoBenhAnId(ObjectId hoSoBenhAnId);
    public List<XetNghiemModel> findByBenhNhanId(ObjectId benhNhanId);

}
