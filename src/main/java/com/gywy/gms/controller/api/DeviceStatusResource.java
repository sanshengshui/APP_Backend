package com.gywy.gms.controller.api;

import com.alibaba.fastjson.JSON;
import com.gywy.gms.domain.DeviceStatus;
import com.gywy.gms.domain.Result;
import com.gywy.gms.domain.api.ApiDeviceStatus;
import com.gywy.gms.service.DeviceStatusService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


/**
 * Created by 123 on 2017/4/19.
 */
@Path("v1")
public class DeviceStatusResource {
    private DeviceStatusService deviceStatusService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String createRecord(@Context ServletContext servletContext,
                               final ApiDeviceStatus record) throws IOException {
        ApplicationContext ctx= WebApplicationContextUtils.getWebApplicationContext(servletContext);
        deviceStatusService=ctx.getBean("deviceStatusService",DeviceStatusService.class);

        DeviceStatus deviceStatus=new DeviceStatus();
        deviceStatus.setAttributes(record.getAttributes());
        deviceStatus.setCommunic(record.getCommunic());
        System.out.println(record.getAttributes());
        System.out.println(record.getCommunic());
        System.out.println("= = = = =");

        //这里的问题很大 是一个爆炸点
        Socket sock=new Socket("localhost",8090);
        OutputStream out=sock.getOutputStream();
        byte buf[];
        String CA=record.getCommunic()+record.getAttributes();
        buf=CA.getBytes();
        out.write(buf);
        out.flush();


        Result result=new Result();
        result.setResult("0");
        result.setErrmsg("ok");
        result.setCode("000");

        // 对象转JSON串
        String jsonString=JSON.toJSONString(result);

        return jsonString;
    }
}
