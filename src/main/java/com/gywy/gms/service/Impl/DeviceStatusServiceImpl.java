package com.gywy.gms.service.Impl;

import com.gywy.gms.domain.DeviceStatus;
import com.gywy.gms.mapper.DeviceStatusMapper;
import com.gywy.gms.service.DeviceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 123 on 2017/4/19.
 */
@Service
@Transactional
public class DeviceStatusServiceImpl implements DeviceStatusService{
    private DeviceStatusMapper deviceStatusMapper;

    @Autowired
    public void setDeviceStatusMapper(DeviceStatusMapper deviceStatusMapper) {
        this.deviceStatusMapper = deviceStatusMapper;
    }

    @Override
    public void createRecord(DeviceStatus record) {
        deviceStatusMapper.createDeviceRecord(record);

    }

    @Override
    public void updateRecord(DeviceStatus record) {
        deviceStatusMapper.updateDeviceRecord(record);

    }
}
