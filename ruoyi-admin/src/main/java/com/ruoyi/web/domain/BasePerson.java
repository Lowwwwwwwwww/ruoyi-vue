package com.ruoyi.admin.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.admin.domain.BaseCompany;

/**
 * 人员信息对象 base_person
 * 
 * @author ruoyi
 * @date 2021-12-01
 */
public class BasePerson extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 人员代码 */
    @Excel(name = "人员代码")
    private String code;

    /** 小区代码 */
    @Excel(name = "小区代码")
    private String communityCode;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String communityName;

    /** 房间代码 */
    @Excel(name = "房间代码")
    private String roomCode;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 人员类型 */
    @Excel(name = "人员类型")
    private Long type;

    /** 人员类型名称 */
    @Excel(name = "人员类型名称")
    private String typeName;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 性别名称 */
    @Excel(name = "性别名称")
    private String sexName;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 国别 */
    @Excel(name = "国别")
    private Long country;

    /** 国别名称 */
    @Excel(name = "国别名称")
    private String countryName;

    /** 民族 */
    @Excel(name = "民族")
    private Long nationality;

    /** 民族名称 */
    @Excel(name = "民族名称")
    private String nationalityName;

    /** 证件类型 */
    @Excel(name = "证件类型")
    private Long paperType;

    /** 证件类型名称 */
    @Excel(name = "证件类型名称")
    private String paperTypeName;

    /** 证件号码 */
    @Excel(name = "证件号码")
    private String paperNumber;

    /** 户籍地址 */
    @Excel(name = "户籍地址")
    private String address;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private Long marriage;

    /** 婚姻状态名称 */
    @Excel(name = "婚姻状态名称")
    private String marriageName;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private Long political;

    /** 政治面貌名称 */
    @Excel(name = "政治面貌名称")
    private String politicalName;

    /** 学历 */
    @Excel(name = "学历")
    private Long education;

    /** 学历名称 */
    @Excel(name = "学历名称")
    private String educationName;

    /** 职业 */
    @Excel(name = "职业")
    private String occupation;

    /** 人脸图像 */
    @Excel(name = "人脸图像")
    private String image;

    /** 入住时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入住时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkinTime;

    /** 是否申请居住证（1是 0否） */
    @Excel(name = "是否申请居住证", readConverterExp = "1=是,0=否")
    private Long residencePermit;

    /** 与户主关系 */
    @Excel(name = "与户主关系")
    private Long relation;

    /** 与户主关系名称 */
    @Excel(name = "与户主关系名称")
    private String relationName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String faceGroupDetailId;

    /** 更新日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date opDate;

    /** 布控类型 */
    @Excel(name = "布控类型")
    private String groupType;

    /** 现居地地址 */
    @Excel(name = "现居地地址")
    private String livePlace;

    /** 居住逻辑 */
    @Excel(name = "居住逻辑")
    private Long addressType;

    /** 1人在户在   2人在户不在   3人不在户在 4人不在户不在 */
    @Excel(name = "1人在户在   2人在户不在   3人不在户在 4人不在户不在")
    private Long liveType;

    /** 实有力量类型 */
    @Excel(name = "实有力量类型")
    private Long powerType;

    /** 实有力量类型名称 */
    @Excel(name = "实有力量类型名称")
    private String powerTypeName;

    /** 工作单位 */
    @Excel(name = "工作单位")
    private String company;

    /** 是否持证上岗 */
    @Excel(name = "是否持证上岗")
    private Long haveCertificate;

    /** 所属库的code */
    @Excel(name = "所属库的code")
    private String packageCode;

    /** 关联班级(标签) */
    @Excel(name = "关联班级(标签)")
    private String linkTags;

    /** 迁出时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "迁出时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkoutTime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
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
    public void setRoomCode(String roomCode) 
    {
        this.roomCode = roomCode;
    }

    public String getRoomCode() 
    {
        return roomCode;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setSexName(String sexName) 
    {
        this.sexName = sexName;
    }

    public String getSexName() 
    {
        return sexName;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setCountry(Long country) 
    {
        this.country = country;
    }

    public Long getCountry() 
    {
        return country;
    }
    public void setCountryName(String countryName) 
    {
        this.countryName = countryName;
    }

    public String getCountryName() 
    {
        return countryName;
    }
    public void setNationality(Long nationality) 
    {
        this.nationality = nationality;
    }

    public Long getNationality() 
    {
        return nationality;
    }
    public void setNationalityName(String nationalityName) 
    {
        this.nationalityName = nationalityName;
    }

    public String getNationalityName() 
    {
        return nationalityName;
    }
    public void setPaperType(Long paperType) 
    {
        this.paperType = paperType;
    }

    public Long getPaperType() 
    {
        return paperType;
    }
    public void setPaperTypeName(String paperTypeName) 
    {
        this.paperTypeName = paperTypeName;
    }

    public String getPaperTypeName() 
    {
        return paperTypeName;
    }
    public void setPaperNumber(String paperNumber) 
    {
        this.paperNumber = paperNumber;
    }

    public String getPaperNumber() 
    {
        return paperNumber;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setMarriage(Long marriage) 
    {
        this.marriage = marriage;
    }

    public Long getMarriage() 
    {
        return marriage;
    }
    public void setMarriageName(String marriageName) 
    {
        this.marriageName = marriageName;
    }

    public String getMarriageName() 
    {
        return marriageName;
    }
    public void setPolitical(Long political) 
    {
        this.political = political;
    }

    public Long getPolitical() 
    {
        return political;
    }
    public void setPoliticalName(String politicalName) 
    {
        this.politicalName = politicalName;
    }

    public String getPoliticalName() 
    {
        return politicalName;
    }
    public void setEducation(Long education) 
    {
        this.education = education;
    }

    public Long getEducation() 
    {
        return education;
    }
    public void setEducationName(String educationName) 
    {
        this.educationName = educationName;
    }

    public String getEducationName() 
    {
        return educationName;
    }
    public void setOccupation(String occupation) 
    {
        this.occupation = occupation;
    }

    public String getOccupation() 
    {
        return occupation;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setCheckinTime(Date checkinTime) 
    {
        this.checkinTime = checkinTime;
    }

    public Date getCheckinTime() 
    {
        return checkinTime;
    }
    public void setResidencePermit(Long residencePermit) 
    {
        this.residencePermit = residencePermit;
    }

    public Long getResidencePermit() 
    {
        return residencePermit;
    }
    public void setRelation(Long relation) 
    {
        this.relation = relation;
    }

    public Long getRelation() 
    {
        return relation;
    }
    public void setRelationName(String relationName) 
    {
        this.relationName = relationName;
    }

    public String getRelationName() 
    {
        return relationName;
    }
    public void setFaceGroupDetailId(String faceGroupDetailId) 
    {
        this.faceGroupDetailId = faceGroupDetailId;
    }

    public String getFaceGroupDetailId() 
    {
        return faceGroupDetailId;
    }
    public void setOpDate(Date opDate) 
    {
        this.opDate = opDate;
    }

    public Date getOpDate() 
    {
        return opDate;
    }
    public void setGroupType(String groupType) 
    {
        this.groupType = groupType;
    }

    public String getGroupType() 
    {
        return groupType;
    }
    public void setLivePlace(String livePlace) 
    {
        this.livePlace = livePlace;
    }

    public String getLivePlace() 
    {
        return livePlace;
    }
    public void setAddressType(Long addressType) 
    {
        this.addressType = addressType;
    }

    public Long getAddressType() 
    {
        return addressType;
    }
    public void setLiveType(Long liveType) 
    {
        this.liveType = liveType;
    }

    public Long getLiveType() 
    {
        return liveType;
    }
    public void setPowerType(Long powerType) 
    {
        this.powerType = powerType;
    }

    public Long getPowerType() 
    {
        return powerType;
    }
    public void setPowerTypeName(String powerTypeName) 
    {
        this.powerTypeName = powerTypeName;
    }

    public String getPowerTypeName() 
    {
        return powerTypeName;
    }
    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
    }
    public void setHaveCertificate(Long haveCertificate) 
    {
        this.haveCertificate = haveCertificate;
    }

    public Long getHaveCertificate() 
    {
        return haveCertificate;
    }
    public void setPackageCode(String packageCode) 
    {
        this.packageCode = packageCode;
    }

    public String getPackageCode() 
    {
        return packageCode;
    }
    public void setLinkTags(String linkTags) 
    {
        this.linkTags = linkTags;
    }

    public String getLinkTags() 
    {
        return linkTags;
    }
    public void setCheckoutTime(Date checkoutTime) 
    {
        this.checkoutTime = checkoutTime;
    }

    public Date getCheckoutTime() 
    {
        return checkoutTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("communityCode", getCommunityCode())
            .append("communityName", getCommunityName())
            .append("roomCode", getRoomCode())
            .append("name", getName())
            .append("type", getType())
            .append("typeName", getTypeName())
            .append("phone", getPhone())
            .append("sex", getSex())
            .append("sexName", getSexName())
            .append("birthday", getBirthday())
            .append("country", getCountry())
            .append("countryName", getCountryName())
            .append("nationality", getNationality())
            .append("nationalityName", getNationalityName())
            .append("paperType", getPaperType())
            .append("paperTypeName", getPaperTypeName())
            .append("paperNumber", getPaperNumber())
            .append("address", getAddress())
            .append("marriage", getMarriage())
            .append("marriageName", getMarriageName())
            .append("political", getPolitical())
            .append("politicalName", getPoliticalName())
            .append("education", getEducation())
            .append("educationName", getEducationName())
            .append("occupation", getOccupation())
            .append("image", getImage())
            .append("checkinTime", getCheckinTime())
            .append("residencePermit", getResidencePermit())
            .append("relation", getRelation())
            .append("relationName", getRelationName())
            .append("faceGroupDetailId", getFaceGroupDetailId())
            .append("opDate", getOpDate())
            .append("groupType", getGroupType())
            .append("livePlace", getLivePlace())
            .append("addressType", getAddressType())
            .append("liveType", getLiveType())
            .append("powerType", getPowerType())
            .append("powerTypeName", getPowerTypeName())
            .append("company", getCompany())
            .append("haveCertificate", getHaveCertificate())
            .append("packageCode", getPackageCode())
            .append("linkTags", getLinkTags())
            .append("checkoutTime", getCheckoutTime())
            .toString();
    }
}
