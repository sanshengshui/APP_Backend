package com.gywy.gms.domain;

/**
 * Created by 123 on 2017/4/19.
 */
public class DeviceStatus {
    private int id;
    private String communic;
   private String attributes;

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

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
