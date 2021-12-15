package com.ruoyi.admin.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆信息对象 base_car
 * 
 * @author ruoyi
 * @date 2021-12-02
 */
public class BaseCar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 车牌 */
    @Excel(name = "车牌")
    private String num;

    /** 车牌颜色 */
    @Excel(name = "车牌颜色")
    private Long numColor;

    /** 车牌颜色名称 */
    @Excel(name = "车牌颜色名称")
    private String numColorName;

    /** 颜色 */
    @Excel(name = "颜色")
    private Long color;

    /** 颜色名称 */
    @Excel(name = "颜色名称")
    private String colorName;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    /** 车类型名称 */
    @Excel(name = "车类型名称")
    private String typeName;

    /** 品牌 */
    @Excel(name = "品牌")
    private Long brand;

    /** 品牌名称 */
    @Excel(name = "品牌名称")
    private String brandName;

    /** 车辆照片 */
    @Excel(name = "车辆照片")
    private String image;

    /** 人员code */
    @Excel(name = "人员code")
    private String personCode;

    /** 小区code */
    @Excel(name = "小区code")
    private String communityCode;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String communityName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String carGroupDetailId;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date opTime;

    /** 车辆所属单位编码 */
    @Excel(name = "车辆所属单位编码")
    private String companyCode;

    /** 车辆属性(1私家车 2公车) */
    @Excel(name = "车辆属性(1私家车 2公车)")
    private Long properties;

    /** 车辆运输货物 内容和质量 */
    @Excel(name = "车辆运输货物 内容和质量")
    private String carTransport;

    /** 车辆标识 0正常物品 1危化物品 */
    @Excel(name = "车辆标识 0正常物品 1危化物品")
    private String carSign;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String groupTypeName;

    /** 库的code */
    @Excel(name = "库的code")
    private String packageCode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setNum(String num) 
    {
        this.num = num;
    }

    public String getNum() 
    {
        return num;
    }
    public void setNumColor(Long numColor) 
    {
        this.numColor = numColor;
    }

    public Long getNumColor() 
    {
        return numColor;
    }
    public void setNumColorName(String numColorName) 
    {
        this.numColorName = numColorName;
    }

    public String getNumColorName() 
    {
        return numColorName;
    }
    public void setColor(Long color) 
    {
        this.color = color;
    }

    public Long getColor() 
    {
        return color;
    }
    public void setColorName(String colorName) 
    {
        this.colorName = colorName;
    }

    public String getColorName() 
    {
        return colorName;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setBrand(Long brand) 
    {
        this.brand = brand;
    }

    public Long getBrand() 
    {
        return brand;
    }
    public void setBrandName(String brandName) 
    {
        this.brandName = brandName;
    }

    public String getBrandName() 
    {
        return brandName;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setPersonCode(String personCode) 
    {
        this.personCode = personCode;
    }

    public String getPersonCode() 
    {
        return personCode;
    }
    public void setCommunityCode(String communityCode) 
    {
        this.communityCode = communityCode;
    }

    public String getCommunityCode() 
    {
        return communityCode;
    }
    public void setCommunityName(String communityName) 
    {
        this.communityName = communityName;
    }

    public String getCommunityName() 
    {
        return communityName;
    }
    public void setCarGroupDetailId(String carGroupDetailId) 
    {
        this.carGroupDetailId = carGroupDetailId;
    }

    public String getCarGroupDetailId() 
    {
        return carGroupDetailId;
    }
    public void setOpTime(Date opTime) 
    {
        this.opTime = opTime;
    }

    public Date getOpTime() 
    {
        return opTime;
    }
    public void setCompanyCode(String companyCode) 
    {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() 
    {
        return companyCode;
    }
    public void setProperties(Long properties) 
    {
        this.properties = properties;
    }

    public Long getProperties() 
    {
        return properties;
    }
    public void setCarTransport(String carTransport) 
    {
        this.carTransport = carTransport;
    }

    public String getCarTransport() 
    {
        return carTransport;
    }
    public void setCarSign(String carSign) 
    {
        this.carSign = carSign;
    }

    public String getCarSign() 
    {
        return carSign;
    }
    public void setGroupTypeName(String groupTypeName) 
    {
        this.groupTypeName = groupTypeName;
    }

    public String getGroupTypeName() 
    {
        return groupTypeName;
    }
    public void setPackageCode(String packageCode) 
    {
        this.packageCode = packageCode;
    }

    public String getPackageCode() 
    {
        return packageCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("num", getNum())
            .append("numColor", getNumColor())
            .append("numColorName", getNumColorName())
            .append("color", getColor())
            .append("colorName", getColorName())
            .append("type", getType())
            .append("typeName", getTypeName())
            .append("brand", getBrand())
            .append("brandName", getBrandName())
            .append("image", getImage())
            .append("personCode", getPersonCode())
            .append("communityCode", getCommunityCode())
            .append("communityName", getCommunityName())
            .append("carGroupDetailId", getCarGroupDetailId())
            .append("opTime", getOpTime())
            .append("companyCode", getCompanyCode())
            .append("properties", getProperties())
            .append("carTransport", getCarTransport())
            .append("carSign", getCarSign())
            .append("groupTypeName", getGroupTypeName())
            .append("packageCode", getPackageCode())
            .toString();
    }
}
