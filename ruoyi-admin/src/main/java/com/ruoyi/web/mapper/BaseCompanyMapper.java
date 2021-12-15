package com.ruoyi.admin.mapper;

import java.util.List;
import com.ruoyi.admin.domain.BaseCompany;

/**
 * base_company 实有单位Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-01
 */
public interface BaseCompanyMapper 
{
    /**
     * 查询base_company 实有单位
     * 
     * @param id base_company 实有单位主键
     * @return base_company 实有单位
     */
    public BaseCompany selectBaseCompanyById(Long id);

    /**
     * 查询base_company 实有单位
     *
     * @param communityCode base_company 实有单位主键
     * @return base_company 实有单位
     */
    public List<BaseCompany> selectBaseCompanyByCommunityCode(String communityCode);

    /**
     * 通过姓名查询
     *
     * @param name 用户名
     * @return 用户对象信息
     */
    BaseCompany selectBaseCompanyByName(String name);

    /**
     * 查询base_company 实有单位列表
     * 
     * @param baseCompany base_company 实有单位
     * @return base_company 实有单位集合
     */
    public List<BaseCompany> selectBaseCompanyList(BaseCompany baseCompany);

    /**
     * 新增base_company 实有单位
     * 
     * @param baseCompany base_company 实有单位
     * @return 结果
     */
    public int insertBaseCompany(BaseCompany baseCompany);

    /**
     * 修改base_company 实有单位
     * 
     * @param baseCompany base_company 实有单位
     * @return 结果
     */
    public int updateBaseCompany(BaseCompany baseCompany);

    /**
     * 删除base_company 实有单位
     * 
     * @param id base_company 实有单位主键
     * @return 结果
     */
    public int deleteBaseCompanyById(Long id);

    /**
     * 批量删除base_company 实有单位
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseCompanyByIds(Long[] ids);
}
