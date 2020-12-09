package com.mt.model;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_city")
public class City {
    private Integer id;// 主键（integer别名areaId）
    private String province;// （城市string）
    private Integer pid;//（integer）

    public City() {
    }

    public City(Integer id, String province, Integer pid) {
        this.id = id;
        this.province = province;
        this.pid = pid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
