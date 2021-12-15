package com.ruoyi.admin.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.uuid.UUID;
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
import com.ruoyi.admin.domain.BasePerson;
import com.ruoyi.admin.service.IBasePersonService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.admin.service.IBaseCompanyService;

/**
 * 人员信息Controller
 * 
 * @author ruoyi
 * @date 2021-12-01
 */
@RestController
@RequestMapping("/admin/person")
public class BasePersonController extends BaseController
{
    @Autowired
    private IBasePersonService basePersonService;

    @Autowired
    private IBaseCompanyService baseCompanyService;

    /**
     * 查询人员信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin:person:list')")
    @GetMapping("/list")
    public TableDataInfo list(BasePerson basePerson)
    {
        startPage();
        List<BasePerson> list = basePersonService.selectBasePersonList(basePerson);
        return getDataTable(list);
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
     * 导出人员信息列表
     */
    @PreAuthorize("@ss.hasPermi('admin:person:export')")
    @Log(title = "人员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BasePerson basePerson)
    {
        List<BasePerson> list = basePersonService.selectBasePersonList(basePerson);
        ExcelUtil<BasePerson> util = new ExcelUtil<BasePerson>(BasePerson.class);
        util.exportExcel(response, list, "人员信息数据");
    }

    /**
     * 获取人员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:person:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(basePersonService.selectBasePersonById(id));
    }

    /**
     * 新增人员信息
     */
    @PreAuthorize("@ss.hasPermi('admin:person:add')")
    @Log(title = "人员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BasePerson basePerson)
    {
        basePerson.setCommunityCode("07999");
        basePerson.setCommunityName("董家口化工园区");
        basePerson.setCode(UUID.randomUUID().toString());
        return toAjax(basePersonService.insertBasePerson(basePerson));
    }

    /**
     * 修改人员信息
     */
    @PreAuthorize("@ss.hasPermi('admin:person:edit')")
    @Log(title = "人员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BasePerson basePerson)
    {
        basePerson.setOpDate(new Date());
        return toAjax(basePersonService.updateBasePerson(basePerson));
    }

    /**
     * 删除人员信息
     */
    @PreAuthorize("@ss.hasPermi('admin:person:remove')")
    @Log(title = "人员信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(basePersonService.deleteBasePersonByIds(ids));
    }
}
