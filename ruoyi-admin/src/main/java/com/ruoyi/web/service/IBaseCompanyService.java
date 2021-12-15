package com.ruoyi.admin.service;

import java.util.List;
import com.ruoyi.admin.domain.BaseCompany;

/**
 * base_company 实有单位Service接口
 * 
 * @author ruoyi
 * @date 2021-12-01
 */
public interface IBaseCompanyService 
{
    /**
     * 查询base_company 实有单位
     * 
     * @param id base_company 实有单位主键
     * @return base_company 实有单位
     */
    public BaseCompany selectBaseCompanyById(Long id);

    /**
     * 导入数据
     *
     * @param baseCompanyList 数据列表
     * @param updateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importCompany(List<BaseCompany> baseCompanyList, Boolean updateSupport, String operName) ;

    /**
     * 查询base_company 实有单位
     *
     * @param CommunityCode base_company 实有单位主键
     * @return base_company 实有单位
     */
    public List<BaseCompany> selectBaseCompanyByCommunityCode(String CommunityCode);

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
     * 批量删除base_company 实有单位
     * 
     * @param ids 需要删除的base_company 实有单位主键集合
     * @return 结果
     */
    public int deleteBaseCompanyByIds(Long[] ids);

    /**
     * 删除base_company 实有单位信息
     * 
     * @param id base_company 实有单位主键
     * @return 结果
     */
    public int deleteBaseCompanyById(Long id);
}
