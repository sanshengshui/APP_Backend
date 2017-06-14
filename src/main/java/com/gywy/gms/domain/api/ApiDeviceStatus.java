package com.gywy.gms.domain.api;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 123 on 2017/4/19.
 */
@XmlRootElement(name = "DeviceStatus")
public class ApiDeviceStatus {
    private int id;
    private String communic;

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    private String attributes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommunic() {
        return communic;
    }

    public void setCommunic(String communic) {
        this.communic = communic;
    }


}
