package demo.respository;


import demo.model.HoSoBenhAnModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface HoSoBenhAnRepository extends MongoRepository<HoSoBenhAnModel, ObjectId> {
    List<HoSoBenhAnModel> findByBenhNhanIdAndTrangThai(ObjectId benhNhanId, int trangthai);
    Optional<HoSoBenhAnModel> findByMaTraoDoi(String maTraoDoi);

}
