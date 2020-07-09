package demo.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    private static HoSoBenhAnReponsitory ho_so_banh_anService;
    private static BenhNhanService benhNhanService;
    private static CoSoKhamBenhReponsitory co_so_kham_benhService;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        ServiceFactory.applicationContext = applicationContext;
    }

    public static HoSoBenhAnReponsitory getHo_so_banh_anModel(){
        if(ho_so_banh_anService ==null){
            ho_so_banh_anService = applicationContext.getBean(HoSoBenhAnReponsitory.class);
        }
        return ho_so_banh_anService;
    }

    public static BenhNhanService getBenhNhanService(){
        if(benhNhanService ==null){
            benhNhanService = applicationContext.getBean(BenhNhanService.class);
        }
        return benhNhanService;
    }

    public static CoSoKhamBenhReponsitory getCo_so_kham_benhService(){
        if(co_so_kham_benhService == null){
            co_so_kham_benhService = applicationContext.getBean(CoSoKhamBenhReponsitory.class);
        }
        return co_so_kham_benhService;
    }
}
