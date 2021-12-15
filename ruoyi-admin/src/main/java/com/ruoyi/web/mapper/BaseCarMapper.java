package com.ruoyi.admin.mapper;

import java.util.List;
import com.ruoyi.admin.domain.BaseCar;

/**
 * 车辆信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-02
 */
public interface BaseCarMapper 
{
    /**
     * 查询车辆信息
     * 
     * @param id 车辆信息主键
     * @return 车辆信息
     */
    public BaseCar selectBaseCarById(Long id);

    /**
     * 查询车辆信息列表
     * 
     * @param baseCar 车辆信息
     * @return 车辆信息集合
     */
    public List<BaseCar> selectBaseCarList(BaseCar baseCar);

    /**
     * 新增车辆信息
     * 
     * @param baseCar 车辆信息
     * @return 结果
     */
    public int insertBaseCar(BaseCar baseCar);

    /**
     * 修改车辆信息
     * 
     * @param baseCar 车辆信息
     * @return 结果
     */
    public int updateBaseCar(BaseCar baseCar);

    /**
     * 删除车辆信息
     * 
     * @param id 车辆信息主键
     * @return 结果
     */
    public int deleteBaseCarById(Long id);

    /**
     * 批量删除车辆信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBaseCarByIds(Long[] ids);
}
