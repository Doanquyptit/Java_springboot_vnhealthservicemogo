package demo.service;

import demo.Utils.Constants;
import demo.Utils.JsonUtil;
import demo.model.BenhNhanModel;
import demo.respository.BenhNhanRespository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

    @Service
    public class BenhNhanService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private LogService logService;

    @Autowired private BenhNhanRespository benhNhanRespository;

    public List<BenhNhanModel> getAll() {
        return benhNhanRespository.findAll();
    }

    public Optional<BenhNhanModel> getById(ObjectId id) {
        return benhNhanRespository.findById(id);
    }

    public BenhNhanModel getByIdhis(String idh) {
        return benhNhanRespository.findByidhis(idh);
    }

    public BenhNhanModel createOrUpdate(BenhNhanModel benhNhanModel, String jsonSt){
        boolean creatNew = benhNhanModel.id == null;
        benhNhanModel.id = benhNhanRespository.findByIdDinhDanhChinh(benhNhanModel.idDinhDanhChinh).map(x -> x.id).orElse(null);
        benhNhanModel= benhNhanRespository.save(benhNhanModel);

        if(creatNew){
            logService.logAction(BenhNhanModel.class.getName(),benhNhanModel.id, Constants.MA_HANH_DONG.TAO_MOI, new Date(), null, " ", jsonSt);
        }
            logService.logAction(BenhNhanModel.class.getName(), benhNhanModel.id, Constants.MA_HANH_DONG.CHINH_SUA, new Date(), null,
                    JsonUtil.dumpObject(benhNhanModel), jsonSt);
            return benhNhanModel;

    }

//    public BenhNhanModel add(BenhNhanModel bn){
//        return benhNhanRespository.save(bn);
//    }


    public List<BenhNhanModel> seachBenhNhan(String keyword , int offset, int limit) {
        var criteria =  new Criteria().orOperator(
                Criteria.where("tenDayDu").regex(keyword),
                Criteria.where("idDinhDanhChinh").regex(keyword)
        );
        var query = new Query(criteria);
        if(offset > 0 && limit >0){
            query = query.skip(offset).limit(limit);
        }

        return mongoTemplate.find(new Query(criteria), BenhNhanModel.class);
    }

    public long countBenhNhan(String keyword) {
         var criteria =  new Criteria().orOperator(
               Criteria.where("tenDayDu").regex(keyword),
                Criteria.where("idDinhDanhChinh").regex(keyword)
        );

        return mongoTemplate.count(new Query(criteria), BenhNhanModel.class);
    }

}
