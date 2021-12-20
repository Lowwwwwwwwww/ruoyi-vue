package com.ruoyi.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.framework.web.service.TokenService;
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
import com.ruoyi.admin.domain.BaseCompany;
import com.ruoyi.admin.service.IBaseCompanyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * base_company 实有单位Controller
 * 
 * @author ruoyi
 * @date 2021-12-01
 */
@RestController
@RequestMapping("/admin/company")
public class BaseCompanyController extends BaseController
{
    @Autowired
    private IBaseCompanyService baseCompanyService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询base_company 实有单位列表
     */
    @PreAuthorize("@ss.hasPermi('admin:company:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaseCompany baseCompany)
    {
        startPage();
        List<BaseCompany> list = baseCompanyService.selectBaseCompanyList(baseCompany);
        return getDataTable(list);
    }

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<BaseCompany> util = new ExcelUtil<BaseCompany>(BaseCompany.class);
        List<BaseCompany> userList = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = baseCompanyService.importCompany(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<BaseCompany> util = new ExcelUtil<BaseCompany>(BaseCompany.class);
        return util.importTemplateExcel("用户数据");
    }

    /**
     * 导出base_company 实有单位列表
     */
    @PreAuthorize("@ss.hasPermi('admin:company:export')")
    @Log(title = "base_company 实有单位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BaseCompany baseCompany)
    {
        List<BaseCompany> list = baseCompanyService.selectBaseCompanyList(baseCompany);
        ExcelUtil<BaseCompany> util = new ExcelUtil<BaseCompany>(BaseCompany.class);
        util.exportExcel(response, list, "base_company 实有单位数据");
    }

    /**
     * 获取base_company 实有单位详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:company:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(baseCompanyService.selectBaseCompanyById(id));
    }

    /**
     * 新增base_company 实有单位
     */
    @PreAuthorize("@ss.hasPermi('admin:company:add')")
    @Log(title = "base_company 实有单位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaseCompany baseCompany)
    {
        baseCompany.setCommunityCode("07999");
        baseCompany.setCommunityName("董家口化工园区");
        baseCompany.setCompanyCode(UUID.randomUUID().toString());
        return toAjax(baseCompanyService.insertBaseCompany(baseCompany));
    }

    /**
     * 修改base_company 实有单位
     */
    @PreAuthorize("@ss.hasPermi('admin:company:edit')")
    @Log(title = "base_company 实有单位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaseCompany baseCompany)
    {
        return toAjax(baseCompanyService.updateBaseCompany(baseCompany));
    }

    /**
     * 删除base_company 实有单位
     */
    @PreAuthorize("@ss.hasPermi('admin:company:remove')")
    @Log(title = "base_company 实有单位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(baseCompanyService.deleteBaseCompanyByIds(ids));
    }
}
