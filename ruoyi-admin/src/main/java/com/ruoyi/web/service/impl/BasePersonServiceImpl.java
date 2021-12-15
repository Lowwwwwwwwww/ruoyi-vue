package com.ruoyi.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.admin.mapper.BasePersonMapper;
import com.ruoyi.admin.domain.BasePerson;
import com.ruoyi.admin.service.IBasePersonService;

/**
 * 人员信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-01
 */
@Service
public class BasePersonServiceImpl implements IBasePersonService 
{
    @Autowired
    private BasePersonMapper basePersonMapper;

    /**
     * 查询人员信息
     * 
     * @param id 人员信息主键
     * @return 人员信息
     */
    @Override
    public BasePerson selectBasePersonById(Long id)
    {
        return basePersonMapper.selectBasePersonById(id);
    }

    @Override
    public List<BasePerson> selectBasePersonByCode(String code) {
        return basePersonMapper.selectBasePersonByCode(code);
    }

    /**
     * 查询人员信息列表
     * 
     * @param basePerson 人员信息
     * @return 人员信息
     */
    @Override
    public List<BasePerson> selectBasePersonList(BasePerson basePerson)
    {
        return basePersonMapper.selectBasePersonList(basePerson);
    }

    /**
     * 新增人员信息
     * 
     * @param basePerson 人员信息
     * @return 结果
     */
    @Override
    public int insertBasePerson(BasePerson basePerson)
    {
        return basePersonMapper.insertBasePerson(basePerson);
    }

    /**
     * 修改人员信息
     * 
     * @param basePerson 人员信息
     * @return 结果
     */
    @Override
    public int updateBasePerson(BasePerson basePerson)
    {
        return basePersonMapper.updateBasePerson(basePerson);
    }

    /**
     * 批量删除人员信息
     * 
     * @param ids 需要删除的人员信息主键
     * @return 结果
     */
    @Override
    public int deleteBasePersonByIds(Long[] ids)
    {
        return basePersonMapper.deleteBasePersonByIds(ids);
    }

    /**
     * 删除人员信息信息
     * 
     * @param id 人员信息主键
     * @return 结果
     */
    @Override
    public int deleteBasePersonById(Long id)
    {
        return basePersonMapper.deleteBasePersonById(id);
    }
}
