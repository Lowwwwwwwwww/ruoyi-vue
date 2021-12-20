package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * POI点对象 poi
 * 
 * @author xwm
 * @date 2021-11-08
 */
public class Poi
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 经度 */
    @Excel(name = "经度")
    private String lng;

    /** 维度 */
    @Excel(name = "维度")
    private String lat;



    /** 经纬度 */
    @Excel(name = "经纬度")
    private String lnglat;

    /** 地址 */
    @Excel(name = "地址")
    private String location;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 分类 */
    @Excel(name = "分类")
    private String sort;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setLng(String lng) 
    {
        this.lng = lng;
    }

    public String getLng() 
    {
        return lng;
    }
    public void setLat(String lat) 
    {
        this.lat = lat;
    }

    public String getLat() 
    {
        return lat;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setSort(String sort) 
    {
        this.sort = sort;
    }

    public String getSort() 
    {
        return sort;
    }


    public String getLnglat() {
        return lnglat;
    }

    public void setLnglat(String lnglat) {
        this.lnglat = lnglat;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("lng", getLng())
            .append("lat", getLat())
            .append("location", getLocation())
            .append("phone", getPhone())
            .append("sort", getSort())
            .toString();
    }
}
