package demo.respository;

import demo.model.CoSoKhamBenhModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CoSoKhamBenhRepository extends MongoRepository<CoSoKhamBenhModel, ObjectId> {
    public Optional<CoSoKhamBenhModel> findByMa(String ma);
}
