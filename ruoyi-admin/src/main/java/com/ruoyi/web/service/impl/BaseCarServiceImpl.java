package com.ruoyi.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.admin.mapper.BaseCarMapper;
import com.ruoyi.admin.domain.BaseCar;
import com.ruoyi.admin.service.IBaseCarService;

/**
 * 车辆信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-02
 */
@Service
public class BaseCarServiceImpl implements IBaseCarService 
{
    @Autowired
    private BaseCarMapper baseCarMapper;

    /**
     * 查询车辆信息
     * 
     * @param id 车辆信息主键
     * @return 车辆信息
     */
    @Override
    public BaseCar selectBaseCarById(Long id)
    {
        return baseCarMapper.selectBaseCarById(id);
    }

    /**
     * 查询车辆信息列表
     * 
     * @param baseCar 车辆信息
     * @return 车辆信息
     */
    @Override
    public List<BaseCar> selectBaseCarList(BaseCar baseCar)
    {
        return baseCarMapper.selectBaseCarList(baseCar);
    }

    /**
     * 新增车辆信息
     * 
     * @param baseCar 车辆信息
     * @return 结果
     */
    @Override
    public int insertBaseCar(BaseCar baseCar)
    {
        return baseCarMapper.insertBaseCar(baseCar);
    }

    /**
     * 修改车辆信息
     * 
     * @param baseCar 车辆信息
     * @return 结果
     */
    @Override
    public int updateBaseCar(BaseCar baseCar)
    {
        return baseCarMapper.updateBaseCar(baseCar);
    }

    /**
     * 批量删除车辆信息
     * 
     * @param ids 需要删除的车辆信息主键
     * @return 结果
     */
    @Override
    public int deleteBaseCarByIds(Long[] ids)
    {
        return baseCarMapper.deleteBaseCarByIds(ids);
    }

    /**
     * 删除车辆信息信息
     * 
     * @param id 车辆信息主键
     * @return 结果
     */
    @Override
    public int deleteBaseCarById(Long id)
    {
        return baseCarMapper.deleteBaseCarById(id);
    }
}
