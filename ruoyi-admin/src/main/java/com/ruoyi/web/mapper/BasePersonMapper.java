package com.ruoyi.admin.mapper;

import java.util.List;
import com.ruoyi.admin.domain.BasePerson;

/**
 * 人员信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-01
 */
public interface BasePersonMapper 
{
    /**
     * 查询人员信息
     * 
     * @param id 人员信息主键
     * @return 人员信息
     */
    public BasePerson selectBasePersonById(Long id);

    /**
     * 查询人员信息
     *
     * @param code 人员信息主键
     * @return 人员信息
     */
    public List<BasePerson> selectBasePersonByCode(String code);

    /**
     * 查询人员信息列表
     * 
     * @param basePerson 人员信息
     * @return 人员信息集合
     */
    public List<BasePerson> selectBasePersonList(BasePerson basePerson);

    /**
     * 新增人员信息
     * 
     * @param basePerson 人员信息
     * @return 结果
     */
    public int insertBasePerson(BasePerson basePerson);

    /**
     * 修改人员信息
     * 
     * @param basePerson 人员信息
     * @return 结果
     */
    public int updateBasePerson(BasePerson basePerson);

    /**
     * 删除人员信息
     * 
     * @param id 人员信息主键
     * @return 结果
     */
    public int deleteBasePersonById(Long id);

    /**
     * 批量删除人员信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBasePersonByIds(Long[] ids);
}
