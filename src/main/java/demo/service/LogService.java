package demo.service;

import demo.model.LogModel;
import demo.respository.LogRepository;
import org.bson.types.ObjectId;

import org.hibernate.validator.internal.util.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogService {
    Logger logger = LoggerFactory.getLogger(LogService.class);
    @Autowired
    LogRepository logRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    public LogModel logAction(String objectClass, ObjectId objectId, String maHanhDong, Date ngayThucHien, ObjectId nguoiThucHienId, String noiDung, String ghiChu) {
        var log = new LogModel();
        log.nguoiThucHienId = nguoiThucHienId;
        log.ngayThucHien = new Date();
        log.objectId = objectId;
        log.objectClass = objectClass;
        log.maHanhDong = maHanhDong;
        log.ghiChu = ghiChu != null? ghiChu : "";
        log.noiDung = noiDung;
        return logRepository.save(log);
    }

    public long countLog(String objectClass, ObjectId objectId, String maHanhDong, boolean asc){
        var query = new Query(Criteria.where("objectClass").is(objectClass).and("objectId").is("objectId").and("maHanhDong").is("maHanhDong"));
        return mongoTemplate.count(query, Log.class);
    }

    public List<Log> getLog(String objectClass, ObjectId objectId, String maHanhDong, boolean asc, int limit, int offset){
        var sortDirection = asc? Sort.Direction.ASC: Sort.Direction.DESC;
        var sort = new Sort(sortDirection, "ngayThucHien");
        var query = new Query(Criteria.where("objectClass").is(objectClass)
                .and("objectId").is(objectId)
                .and("maHanhDong").is(maHanhDong))
                .with(sort);

        if(offset >= 0 && limit >= 0) {
            query = query.skip(offset).limit(limit);
        }

        return mongoTemplate.find(query, Log.class);
    }
}
