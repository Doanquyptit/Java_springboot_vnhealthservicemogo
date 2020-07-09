package demo.respository;
import demo.model.LogModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogModel, ObjectId> {
}
