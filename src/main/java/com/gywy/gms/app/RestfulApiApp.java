package com.gywy.gms.app;

import com.gywy.gms.controller.api.DeviceStatusResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 123 on 2017/4/19.
 */
public class RestfulApiApp extends Application{

    @Override
    public Set<Class<?>> getClasses(){
        final Set<Class<?>> classes=new HashSet<>();
        classes.add(DeviceStatusResource.class);
        return classes;
    }
}
