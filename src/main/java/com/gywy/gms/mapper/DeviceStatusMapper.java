package com.gywy.gms.mapper;

import com.gywy.gms.domain.DeviceStatus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * Created by 123 on 2017/4/19.
 */
public interface DeviceStatusMapper {
    @Insert("INSERT INTO devicestatus(\n" +
            "communic,attributes)\n" +
            "VALUES(\n" +
            "#{communic},#{attributes}")
    int createDeviceRecord(DeviceStatus record);

    @Update("UPDATE devicestatus \n" +
            "SET attributes=#{attributes}\n" +
            "where communic=#{communic}")
    int updateDeviceRecord(DeviceStatus record);
}
