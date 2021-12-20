package com.ruoyi.web.controller;

import java.util.List;

import com.ruoyi.web.domain.Poi;
import com.ruoyi.web.service.IPoiService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * POI点Controller
 * 
 * @author xwm
 * @date 2021-11-08
 */
@Controller
@RequestMapping("/manage/poi")
public class PoiController extends BaseController
{
    private String prefix = "manage/poi";

    @Autowired
    private IPoiService poiService;

    @RequiresPermissions("manage:poi:view")
    @GetMapping()
    public String poi()
    {
        return prefix + "/poi";
    }

    /**
     * 查询POI点列表
     */
    @RequiresPermissions("manage:poi:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Poi poi)
    {
        startPage();
        List<Poi> list = poiService.selectPoiList(poi);
        return getDataTable(list);
    }

    /**
     * 导出POI点列表
     */
    @RequiresPermissions("manage:poi:export")
    @Log(title = "POI点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Poi poi)
    {
        List<Poi> list = poiService.selectPoiList(poi);
        ExcelUtil<Poi> util = new ExcelUtil<Poi>(Poi.class);
        return util.exportExcel(list, "POI点数据");
    }

    /**
     * 新增POI点
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存POI点
     */
    @RequiresPermissions("manage:poi:add")
    @Log(title = "POI点", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Poi poi)
    {
        return toAjax(poiService.insertPoi(poi));
    }

    /**
     * 修改POI点
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Poi poi = poiService.selectPoiById(id);
        mmap.put("poi", poi);
        return prefix + "/edit";
    }

    /**
     * 修改保存POI点
     */
    @RequiresPermissions("manage:poi:edit")
    @Log(title = "POI点", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Poi poi)
    {
        return toAjax(poiService.updatePoi(poi));
    }

    /**
     * 删除POI点
     */
    @RequiresPermissions("manage:poi:remove")
    @Log(title = "POI点", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(poiService.deletePoiByIds(ids));
    }
}
