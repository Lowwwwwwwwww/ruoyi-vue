package com.ruoyi.web.service.impl;

import java.util.List;

import com.ruoyi.web.domain.Poi;
import com.ruoyi.web.mapper.PoiMapper;
import com.ruoyi.web.service.IPoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;

/**
 * POI点Service业务层处理
 * 
 * @author xwm
 * @date 2021-11-08
 */
@Service
public class PoiServiceImpl implements IPoiService
{
    @Autowired
    private PoiMapper poiMapper;

    /**
     * 查询POI点
     * 
     * @param id POI点主键
     * @return POI点
     */
    @Override
    public Poi selectPoiById(Long id)
    {
        return poiMapper.selectPoiById(id);
    }

    /**
     * 查询POI点列表
     * 
     * @param poi POI点
     * @return POI点
     */
    @Override
    public List<Poi> selectPoiList(Poi poi)
    {
        return poiMapper.selectPoiList(poi);
    }

    /**
     * 新增POI点
     * 
     * @param poi POI点
     * @return 结果
     */
    @Override
    public int insertPoi(Poi poi)
    {
        return poiMapper.insertPoi(poi);
    }

    /**
     * 修改POI点
     * 
     * @param poi POI点
     * @return 结果
     */
    @Override
    public int updatePoi(Poi poi)
    {
        return poiMapper.updatePoi(poi);
    }

    /**
     * 批量删除POI点
     * 
     * @param ids 需要删除的POI点主键
     * @return 结果
     */
    @Override
    public int deletePoiByIds(String ids)
    {
        return poiMapper.deletePoiByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除POI点信息
     * 
     * @param id POI点主键
     * @return 结果
     */
    @Override
    public int deletePoiById(Long id)
    {
        return poiMapper.deletePoiById(id);
    }
}
