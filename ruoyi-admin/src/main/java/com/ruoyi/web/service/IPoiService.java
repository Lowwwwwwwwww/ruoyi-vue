package com.ruoyi.web.service;

import com.ruoyi.web.domain.Poi;

import java.util.List;


/**
 * POI点Service接口
 * 
 * @author xwm
 * @date 2021-11-08
 */
public interface IPoiService 
{
    /**
     * 查询POI点
     * 
     * @param id POI点主键
     * @return POI点
     */
    public Poi selectPoiById(Long id);

    /**
     * 查询POI点列表
     * 
     * @param poi POI点
     * @return POI点集合
     */
    public List<Poi> selectPoiList(Poi poi);

    /**
     * 新增POI点
     * 
     * @param poi POI点
     * @return 结果
     */
    public int insertPoi(Poi poi);

    /**
     * 修改POI点
     * 
     * @param poi POI点
     * @return 结果
     */
    public int updatePoi(Poi poi);

    /**
     * 批量删除POI点
     * 
     * @param ids 需要删除的POI点主键集合
     * @return 结果
     */
    public int deletePoiByIds(String ids);

    /**
     * 删除POI点信息
     * 
     * @param id POI点主键
     * @return 结果
     */
    public int deletePoiById(Long id);
}
