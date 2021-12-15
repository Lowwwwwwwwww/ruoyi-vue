package com.ruoyi.admin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * base_company 实有单位对象 base_company
 * 
 * @author ruoyi
 * @date 2021-12-01
 */
public class BaseCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 小区code */
    @Excel(name = "小区code")
    private String communityCode;

    /** 小区name */
    @Excel(name = "小区name")
    private String communityName;

    /** 单位code */
    @Excel(name = "单位code")
    private String companyCode;

    /** 单位name */
    @Excel(name = "单位name")
    private String companyName;

    /** 单位类型 */
    @Excel(name = "单位类型")
    private Long companyType;

    /** 单位类型 名称 */
    @Excel(name = "单位类型 名称")
    private String companyTypeName;

    /** 是否有营业执照(0/1) */
    @Excel(name = "是否有营业执照(0/1)")
    private Long companyLicense;

    /** 营业执照号 */
    @Excel(name = "营业执照号")
    private String companyLicenseNum;

    /** 重点单位标识(0/1) */
    @Excel(name = "重点单位标识(0/1)")
    private Long companyAttention;

    /** 经营范围 1,2,3…… */
    @Excel(name = "经营范围 1,2,3……")
    private String companyScope;

    /** 经营范围名称 */
    @Excel(name = "经营范围名称")
    private String companyScopeName;

    /** 单位地址 */
    @Excel(name = "单位地址")
    private String companyAddress;

    /** 单位坐标 */
    @Excel(name = "单位坐标")
    private String companyLocation;

    /** 单位区域坐标 */
    @Excel(name = "单位区域坐标")
    private String companyLocationArea;

    /** 单位门面图 */
    @Excel(name = "单位门面图")
    private String companyImage;

    /** 单位绑定多个房间  1,2,3..... */
    @Excel(name = "单位绑定多个房间  1,2,3.....")
    private String roomCode;

    /** 房主code  弃用 */
    @Excel(name = "房主code  弃用")
    private String ownerCode;

    /** 房主name 弃用 */
    @Excel(name = "房主name 弃用")
    private String ownerName;

    /**  弃用 */
    @Excel(name = " 弃用")
    private String ownerPaperNum;

    /** 房主phone 弃用 */
    @Excel(name = "房主phone 弃用")
    private String ownerPhone;

    /** 房主image 弃用 */
    @Excel(name = "房主image 弃用")
    private String ownerImage;

    /** 房类型 弃用 */
    @Excel(name = "房类型 弃用")
    private Long roomType;

    /** 房类型名称 弃用 */
    @Excel(name = "房类型名称 弃用")
    private String roomTypeName;

    /** 法人code  弃用 放在 员工表中 */
    @Excel(name = "法人code  弃用 放在 员工表中")
    private String legalCode;

    /** 法人name 弃用 */
    @Excel(name = "法人name 弃用")
    private String legalName;

    /** 法人身份证号 弃用 */
    @Excel(name = "法人身份证号 弃用")
    private String legalPaperNum;

    /** 法人phone 弃用 */
    @Excel(name = "法人phone 弃用")
    private String legalPhone;

    /** 法人image 弃用 */
    @Excel(name = "法人image 弃用")
    private String legalImage;

    /** 单位状态（1 营业中 2建设中 3 重点单位） */
    @Excel(name = "单位状态", readConverterExp = "1=,营=业中,2=建设中,3=,重=点单位")
    private Long companyStatus;

    /** 单位状态名称 */
    @Excel(name = "单位状态名称")
    private String companyStatusName;

    /** 管控类型(1正常 2异常) */
    @Excel(name = "管控类型(1正常 2异常)")
    private Long groupType;

    /** 管控类型名称 */
    @Excel(name = "管控类型名称")
    private String groupTypeName;

    /** 注册时间 */
    @Excel(name = "注册时间")
    private String licenseTime;

    /** 生产原料 */
    @Excel(name = "生产原料")
    private String produce;

    /** 注册地址 */
    @Excel(name = "注册地址")
    private String licenseAddress;

    /** 邮件 */
    @Excel(name = "邮件")
    private String contactEmail;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setCompanyCode(String companyCode) 
    {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() 
    {
        return companyCode;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setCompanyType(Long companyType) 
    {
        this.companyType = companyType;
    }

    public Long getCompanyType() 
    {
        return companyType;
    }
    public void setCompanyTypeName(String companyTypeName) 
    {
        this.companyTypeName = companyTypeName;
    }

    public String getCompanyTypeName() 
    {
        return companyTypeName;
    }
    public void setCompanyLicense(Long companyLicense) 
    {
        this.companyLicense = companyLicense;
    }

    public Long getCompanyLicense() 
    {
        return companyLicense;
    }
    public void setCompanyLicenseNum(String companyLicenseNum) 
    {
        this.companyLicenseNum = companyLicenseNum;
    }

    public String getCompanyLicenseNum() 
    {
        return companyLicenseNum;
    }
    public void setCompanyAttention(Long companyAttention) 
    {
        this.companyAttention = companyAttention;
    }

    public Long getCompanyAttention() 
    {
        return companyAttention;
    }
    public void setCompanyScope(String companyScope) 
    {
        this.companyScope = companyScope;
    }

    public String getCompanyScope() 
    {
        return companyScope;
    }
    public void setCompanyScopeName(String companyScopeName) 
    {
        this.companyScopeName = companyScopeName;
    }

    public String getCompanyScopeName() 
    {
        return companyScopeName;
    }
    public void setCompanyAddress(String companyAddress) 
    {
        this.companyAddress = companyAddress;
    }

    public String getCompanyAddress() 
    {
        return companyAddress;
    }
    public void setCompanyLocation(String companyLocation) 
    {
        this.companyLocation = companyLocation;
    }

    public String getCompanyLocation() 
    {
        return companyLocation;
    }
    public void setCompanyLocationArea(String companyLocationArea) 
    {
        this.companyLocationArea = companyLocationArea;
    }

    public String getCompanyLocationArea() 
    {
        return companyLocationArea;
    }
    public void setCompanyImage(String companyImage) 
    {
        this.companyImage = companyImage;
    }

    public String getCompanyImage() 
    {
        return companyImage;
    }
    public void setRoomCode(String roomCode) 
    {
        this.roomCode = roomCode;
    }

    public String getRoomCode() 
    {
        return roomCode;
    }
    public void setOwnerCode(String ownerCode) 
    {
        this.ownerCode = ownerCode;
    }

    public String getOwnerCode() 
    {
        return ownerCode;
    }
    public void setOwnerName(String ownerName) 
    {
        this.ownerName = ownerName;
    }

    public String getOwnerName() 
    {
        return ownerName;
    }
    public void setOwnerPaperNum(String ownerPaperNum) 
    {
        this.ownerPaperNum = ownerPaperNum;
    }

    public String getOwnerPaperNum() 
    {
        return ownerPaperNum;
    }
    public void setOwnerPhone(String ownerPhone) 
    {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerPhone() 
    {
        return ownerPhone;
    }
    public void setOwnerImage(String ownerImage) 
    {
        this.ownerImage = ownerImage;
    }

    public String getOwnerImage() 
    {
        return ownerImage;
    }
    public void setRoomType(Long roomType) 
    {
        this.roomType = roomType;
    }

    public Long getRoomType() 
    {
        return roomType;
    }
    public void setRoomTypeName(String roomTypeName) 
    {
        this.roomTypeName = roomTypeName;
    }

    public String getRoomTypeName() 
    {
        return roomTypeName;
    }
    public void setLegalCode(String legalCode) 
    {
        this.legalCode = legalCode;
    }

    public String getLegalCode() 
    {
        return legalCode;
    }
    public void setLegalName(String legalName) 
    {
        this.legalName = legalName;
    }

    public String getLegalName() 
    {
        return legalName;
    }
    public void setLegalPaperNum(String legalPaperNum) 
    {
        this.legalPaperNum = legalPaperNum;
    }

    public String getLegalPaperNum() 
    {
        return legalPaperNum;
    }
    public void setLegalPhone(String legalPhone) 
    {
        this.legalPhone = legalPhone;
    }

    public String getLegalPhone() 
    {
        return legalPhone;
    }
    public void setLegalImage(String legalImage) 
    {
        this.legalImage = legalImage;
    }

    public String getLegalImage() 
    {
        return legalImage;
    }
    public void setCompanyStatus(Long companyStatus) 
    {
        this.companyStatus = companyStatus;
    }

    public Long getCompanyStatus() 
    {
        return companyStatus;
    }
    public void setCompanyStatusName(String companyStatusName) 
    {
        this.companyStatusName = companyStatusName;
    }

    public String getCompanyStatusName() 
    {
        return companyStatusName;
    }
    public void setGroupType(Long groupType) 
    {
        this.groupType = groupType;
    }

    public Long getGroupType() 
    {
        return groupType;
    }
    public void setGroupTypeName(String groupTypeName) 
    {
        this.groupTypeName = groupTypeName;
    }

    public String getGroupTypeName() 
    {
        return groupTypeName;
    }
    public void setLicenseTime(String licenseTime) 
    {
        this.licenseTime = licenseTime;
    }

    public String getLicenseTime() 
    {
        return licenseTime;
    }
    public void setProduce(String produce) 
    {
        this.produce = produce;
    }

    public String getProduce() 
    {
        return produce;
    }
    public void setLicenseAddress(String licenseAddress) 
    {
        this.licenseAddress = licenseAddress;
    }

    public String getLicenseAddress() 
    {
        return licenseAddress;
    }
    public void setContactEmail(String contactEmail) 
    {
        this.contactEmail = contactEmail;
    }

    public String getContactEmail() 
    {
        return contactEmail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("communityCode", getCommunityCode())
            .append("communityName", getCommunityName())
            .append("companyCode", getCompanyCode())
            .append("companyName", getCompanyName())
            .append("companyType", getCompanyType())
            .append("companyTypeName", getCompanyTypeName())
            .append("companyLicense", getCompanyLicense())
            .append("companyLicenseNum", getCompanyLicenseNum())
            .append("companyAttention", getCompanyAttention())
            .append("companyScope", getCompanyScope())
            .append("companyScopeName", getCompanyScopeName())
            .append("companyAddress", getCompanyAddress())
            .append("companyLocation", getCompanyLocation())
            .append("companyLocationArea", getCompanyLocationArea())
            .append("companyImage", getCompanyImage())
            .append("roomCode", getRoomCode())
            .append("ownerCode", getOwnerCode())
            .append("ownerName", getOwnerName())
            .append("ownerPaperNum", getOwnerPaperNum())
            .append("ownerPhone", getOwnerPhone())
            .append("ownerImage", getOwnerImage())
            .append("roomType", getRoomType())
            .append("roomTypeName", getRoomTypeName())
            .append("legalCode", getLegalCode())
            .append("legalName", getLegalName())
            .append("legalPaperNum", getLegalPaperNum())
            .append("legalPhone", getLegalPhone())
            .append("legalImage", getLegalImage())
            .append("companyStatus", getCompanyStatus())
            .append("companyStatusName", getCompanyStatusName())
            .append("groupType", getGroupType())
            .append("groupTypeName", getGroupTypeName())
            .append("licenseTime", getLicenseTime())
            .append("produce", getProduce())
            .append("licenseAddress", getLicenseAddress())
            .append("contactEmail", getContactEmail())
            .toString();
    }
}
