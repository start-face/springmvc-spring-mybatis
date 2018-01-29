package com.ssm.model;

import com.google.common.base.MoreObjects;

/**
 * @author FaceFeel
 * @Created 2018-01-28 20:27
 */

public class Student implements java.io.Serializable {

    private String sname;
    private String kecheng;
    private Integer fenshu;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("sname", sname)
                .add("kecheng", kecheng)
                .add("fenshu", fenshu)
                .toString();
    }

    public String getSname() {
        return sname;
    }

    public Student setSname(String sname) {
        this.sname = sname;
        return this;
    }

    public String getKecheng() {
        return kecheng;
    }

    public Student setKecheng(String kecheng) {
        this.kecheng = kecheng;
        return this;
    }

    public Integer getFenshu() {
        return fenshu;
    }

    public Student setFenshu(Integer fenshu) {
        this.fenshu = fenshu;
        return this;
    }
}
