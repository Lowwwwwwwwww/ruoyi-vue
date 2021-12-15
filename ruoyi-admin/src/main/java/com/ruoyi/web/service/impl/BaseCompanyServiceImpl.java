package com.ruoyi.admin.service.impl;

import java.util.List;
import java.util.logging.Logger;

import com.mchange.v2.log.LogUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.exception.GlobalExceptionHandler;
import org.apache.commons.math3.analysis.function.Log;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.admin.mapper.BaseCompanyMapper;
import com.ruoyi.admin.domain.BaseCompany;
import com.ruoyi.admin.service.IBaseCompanyService;

/**
 * base_company 实有单位Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-01
 */
@Service
public class BaseCompanyServiceImpl implements IBaseCompanyService 
{
    @Autowired
    private BaseCompanyMapper baseCompanyMapper;


    /**
     * 查询base_company 实有单位
     * 
     * @param id base_company 实有单位主键
     * @return base_company 实有单位
     */
    @Override
    public BaseCompany selectBaseCompanyById(Long id)
    {
        return baseCompanyMapper.selectBaseCompanyById(id);
    }

    @Override
    public String importCompany(List<BaseCompany> baseCompanyList, Boolean updateSupport, String operName) {
        if (StringUtils.isNull(baseCompanyList) || baseCompanyList.size() == 0) {
            try {
                throw new Exception("导入用户数据不能为空！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (BaseCompany company : baseCompanyList) {
            try {
                // 验证是否存在这个用户
                BaseCompany u = baseCompanyMapper.selectBaseCompanyByName(company.getCompanyName());
                if (StringUtils.isNull(u)) {
                    company.setCompanyName(company.getCompanyName());
                    this.insertBaseCompany(company);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "学校信息" + company.getCompanyName() + " 导入成功");
                } else if (updateSupport) {
                    company.setUpdateBy(operName);
                    this.updateBaseCompany(company);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "学校信息 " + company.getCompanyName() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "学校信息" + company.getCompanyName() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "学校信息" + company.getCompanyName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
//                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            try {
                throw new Exception(failureMsg.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public List<BaseCompany> selectBaseCompanyByCommunityCode(String CommunityCode) {
        return baseCompanyMapper.selectBaseCompanyByCommunityCode(CommunityCode);
    }

    /**
     * 查询base_company 实有单位列表
     * 
     * @param baseCompany base_company 实有单位
     * @return base_company 实有单位
     */
    @Override
    public List<BaseCompany> selectBaseCompanyList(BaseCompany baseCompany)
    {
        return baseCompanyMapper.selectBaseCompanyList(baseCompany);
    }

    /**
     * 新增base_company 实有单位
     * 
     * @param baseCompany base_company 实有单位
     * @return 结果
     */
    @Override
    public int insertBaseCompany(BaseCompany baseCompany)
    {
        return baseCompanyMapper.insertBaseCompany(baseCompany);
    }

    /**
     * 修改base_company 实有单位
     * 
     * @param baseCompany base_company 实有单位
     * @return 结果
     */
    @Override
    public int updateBaseCompany(BaseCompany baseCompany)
    {
        return baseCompanyMapper.updateBaseCompany(baseCompany);
    }

    /**
     * 批量删除base_company 实有单位
     * 
     * @param ids 需要删除的base_company 实有单位主键
     * @return 结果
     */
    @Override
    public int deleteBaseCompanyByIds(Long[] ids)
    {
        return baseCompanyMapper.deleteBaseCompanyByIds(ids);
    }

    /**
     * 删除base_company 实有单位信息
     * 
     * @param id base_company 实有单位主键
     * @return 结果
     */
    @Override
    public int deleteBaseCompanyById(Long id)
    {
        return baseCompanyMapper.deleteBaseCompanyById(id);
    }
}
