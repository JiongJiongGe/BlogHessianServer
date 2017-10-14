package com.mybatis.domain.pen;

import java.io.Serializable;

/**
 * 笔 model
 *
 * Created by yunkai on 2017/5/24.
 */
public class CalmWangPenModel implements Serializable{

    private Short ID;

    private String pen_name;//笔名称

    private Short user_id;//用户ID

    public Short getID() {
        return ID;
    }

    public void setID(Short ID) {
        this.ID = ID;
    }

    public String getPen_name() {
        return pen_name;
    }

    public void setPen_name(String pen_name) {
        this.pen_name = pen_name;
    }

    public Short getUser_id() {
        return user_id;
    }

    public void setUser_id(Short user_id) {
        this.user_id = user_id;
    }
}
