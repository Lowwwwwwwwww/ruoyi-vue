package com.ruoyi.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.admin.domain.BaseCar;
import com.ruoyi.admin.service.IBaseCarService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.admin.service.IBasePersonService;
import com.ruoyi.admin.service.IBaseCompanyService;

/**
 * 车辆信息Controller
 * 
 * @author ruoyi
 * @date 2021-12-02
 */
@RestController
@RequestMapping("/admin/car")
public class BaseCarController extends BaseController
{
    @Autowired
    private IBaseCarService baseCarService;

    @Autowired
    private IBasePersonService basePerson;

    @Autowired
    private IBaseCompanyService baseCompanyService;

    /**
     * 查询车辆信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin:car:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseCar baseCar)
    {
        startPage();
        List<BaseCar> list = baseCarService.selectBaseCarList(baseCar);
        return getDataTable(list);
    }

    /**
     * 获取人员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:car:person')")
    @GetMapping(value = "/person")
    public AjaxResult getBasePerson()
    {
        return AjaxResult.success(basePerson.selectBasePersonByCode("07999"));
    }

    /**
     * 获取单位信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:person:company')")
    @GetMapping(value = "/company")
    public AjaxResult getBaseCompany()
    {
        return AjaxResult.success(baseCompanyService.selectBaseCompanyByCommunityCode("07999"));
    }

    /**
     * 导出车辆信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin:car:export')")
    @Log(title = "车辆信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseCar baseCar)
    {
        List<BaseCar> list = baseCarService.selectBaseCarList(baseCar);
        ExcelUtil<BaseCar> util = new ExcelUtil<BaseCar>(BaseCar.class);
        util.exportExcel(response, list, "车辆信息数据");
    }

    /**
     * 获取车辆信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:car:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseCarService.selectBaseCarById(id));
    }

    /**
     * 新增车辆信息
     */
    @PreAuthorize("@ss.hasPermi('admin:car:add')")
    @Log(title = "车辆信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseCar baseCar)
    {
        return toAjax(baseCarService.insertBaseCar(baseCar));
    }

    /**
     * 修改车辆信息
     */
    @PreAuthorize("@ss.hasPermi('admin:car:edit')")
    @Log(title = "车辆信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseCar baseCar)
    {
        return toAjax(baseCarService.updateBaseCar(baseCar));
    }

    /**
     * 删除车辆信息
     */
    @PreAuthorize("@ss.hasPermi('admin:car:remove')")
    @Log(title = "车辆信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseCarService.deleteBaseCarByIds(ids));
    }
}
