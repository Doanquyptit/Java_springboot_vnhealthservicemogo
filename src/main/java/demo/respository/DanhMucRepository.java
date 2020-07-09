package demo.respository;

import demo.model.DanhMucModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DanhMucRepository extends MongoRepository<DanhMucModel, ObjectId> {

}
