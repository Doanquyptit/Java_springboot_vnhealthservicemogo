package demo.respository;

import demo.model.BenhNhanModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BenhNhanRespository extends MongoRepository<BenhNhanModel, ObjectId> {
    Optional<BenhNhanModel> findByIdDinhDanhChinh(String idDinhDanhChinh);
    BenhNhanModel findByidhis(String idhis);
}
