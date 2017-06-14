package com.gywy.gms.service;

import com.gywy.gms.domain.DeviceStatus;

/**
 * Created by 123 on 2017/4/19.
 */
public interface DeviceStatusService {
    void createRecord(DeviceStatus record);
    void updateRecord(DeviceStatus record);
}
