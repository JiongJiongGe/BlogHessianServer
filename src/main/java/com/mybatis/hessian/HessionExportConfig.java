package com.mybatis.hessian;

import com.mybatis.service.pen.CalmWangPenServiceI;
import com.mybatis.service.user.CalmWangUserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

/**
 * Created by yunkai on 2017/9/19.
 */
@Configuration
public class HessionExportConfig {

    @Autowired
    private CalmWangUserServiceI calmWangUserService;

    @Autowired
    private CalmWangPenServiceI calmWangPenService;

    @Bean(name = "/calmWangUserServiceExporter.hessian")
    public HessianServiceExporter accountService() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(calmWangUserService);
        exporter.setServiceInterface(CalmWangUserServiceI.class);
        return exporter;
    }

    @Bean(name = "/calmWangPenServiceExporter.hessian")
    public HessianServiceExporter penService(){
        HessianServiceExporter proxy = new HessianServiceExporter();
        proxy.setService(calmWangPenService);
        proxy.setServiceInterface(CalmWangPenServiceI.class);
        return proxy;
    }
}
