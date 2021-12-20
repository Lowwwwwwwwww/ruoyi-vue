<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="单位名称" prop="companyName">
        <el-input
          v-model="queryParams.companyName"
          placeholder="请输入单位名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单位地址" prop="companyAddress">
        <el-input
          v-model="queryParams.companyAddress"
          placeholder="请输入单位地址"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮件" prop="contactEmail">
        <el-input
          v-model="queryParams.contactEmail"
          placeholder="请输入邮件"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['admin:company:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['admin:company:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['admin:company:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['admin:company:export']"
        >导出</el-button>
      </el-col>
      <!-- <el-col :span="1.5">
        <el-button
          type="info"
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
        >导入</el-button>
      </el-col> -->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="companyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="单位名称" align="center" prop="companyName" width="280"/>
      <el-table-column label="单位类型名称" align="center" prop="companyTypeName" show-overflow-tooltip />
      <el-table-column label="营业执照号" align="center" prop="companyLicenseNum" show-overflow-tooltip/>
      <el-table-column label="经营范围名称" align="center" prop="companyScopeName" show-overflow-tooltip/>
      <el-table-column label="单位地址" align="center" prop="companyAddress" show-overflow-tooltip/>
      <el-table-column label="单位坐标" align="center" prop="companyLocation" show-overflow-tooltip/>
      <el-table-column label="单位区域坐标" align="center" prop="companyLocationArea" show-overflow-tooltip/>
      <el-table-column label="单位门面图" prop="companyImage">
      　　<template slot-scope="scope" >
            <el-popover placement="right" title trigger="click">
      　　　　<img :src="'http://172.16.1.155/'+scope.row.companyImage" width="1300" height="500"/>
             <img slot="reference" :src="'http://172.16.1.155/'+scope.row.companyImage"  style="max-height: 100px;max-width: 150px"/>
          </el-popover>
      　　</template>
      </el-table-column>
      <el-table-column label="单位状态名称" align="center" prop="companyStatusName" />
      <el-table-column label="管控类型名称" align="center" prop="groupTypeName" />
      <el-table-column label="邮件" align="center" prop="contactEmail" show-overflow-tooltip />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['admin:company:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:company:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改base_company 实有单位对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="110px">
        <!-- <el-form-item label="小区code" prop="communityCode">
          <el-input v-model="form.communityCode" placeholder="请输入小区code"  V-value="07999"/>
        </el-form-item>
        <el-form-item label="小区name" prop="communityName">
          <el-input v-model="form.communityName" placeholder="请输入小区name" />
        </el-form-item>
        <el-form-item label="单位code" prop="companyCode">
          <el-input v-model="form.companyCode" placeholder="请输入单位code" />
        </el-form-item> -->
        <el-form-item label="单位名称" prop="companyName">
          <el-input v-model="form.companyName" placeholder="请输入单位名称" />
        </el-form-item>
        <el-form-item label="单位类型名称" prop="companyTypeName">
          <el-input v-model="form.companyTypeName" placeholder="请输入单位类型名称" />
        </el-form-item>
        <el-form-item label="是否有营业执照" prop="companyLicense">
          <el-select v-model="form.companyLicense" placeholder="">
            <el-option
              v-for="dict in dict.type.company_license"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="营业执照号" prop="companyLicenseNum">
          <el-input v-model="form.companyLicenseNum" placeholder="请输入营业执照号" />
        </el-form-item>
        <el-form-item label="经营范围名称" prop="companyScopeName">
          <el-input v-model="form.companyScopeName" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="单位地址" prop="companyAddress">
          <el-input v-model="form.companyAddress" placeholder="请输入单位地址" />
        </el-form-item>
        <el-form-item label="单位坐标" prop="companyLocation">
          <el-input v-model="form.companyLocation" placeholder="请输入单位坐标" />
        </el-form-item>
        <el-form-item label="单位区域坐标" prop="companyLocationArea">
          <el-input v-model="form.companyLocationArea" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="单位门面图">
          <imageUpload v-model="form.companyImage" value=""/>
          <!-- <img :src="'http://172.16.1.155/'+form.companyImage" width="300" height="150"/> -->
        </el-form-item>
        <el-form-item label="单位状态名称" prop="companyStatusName">
          <el-select v-model="form.companyStatusName" placeholder="">
            <el-option
              v-for="dict in dict.type.company_status"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="注册时间" prop="licenseTime">
          <el-date-picker clearable size="small"
            v-model="form.licenseTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择注册时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="生产原料" prop="produce">
          <el-input v-model="form.produce" placeholder="请输入生产原料" />
        </el-form-item>
        <el-form-item label="注册地址" prop="licenseAddress">
          <el-input v-model="form.licenseAddress" placeholder="请输入注册地址" />
        </el-form-item>
        <el-form-item label="邮件" prop="contactEmail">
          <el-input v-model="form.contactEmail" placeholder="请输入邮件" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 用户导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px">
      <el-upload
      ref="upload"
      :limit="1"
      accept=".xlsx, .xls"
      :headers="upload.headers"
      :action="upload.url + '?updateSupport=' + upload.updateSupport"
      :disabled="upload.isUploading"
      :on-progress="handleFileUploadProgress"
      :on-success="handleFileSuccess"
      :auto-upload="false"
      drag
      >
      <i class="el-icon-upload"></i>
      <div class="el-upload__text">
        将文件拖到此处，或
        <em>点击上传</em>
      </div>
      <div class="el-upload__tip" slot="tip">
        <el-checkbox v-model="upload.updateSupport" />是否更新已经存在的用户数据
        <el-link type="info" style="font-size:12px" @click="importTemplate">下载模板</el-link>
      </div>
      <div class="el-upload__tip" style="color:red" slot="tip">提示：仅允许导入“xls”或“xlsx”格式文件！</div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="submitFileForm">确 定</el-button>
      <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import { listCompany, getCompany, delCompany, addCompany, updateCompany, importData } from "@/api/admin/company";
// 导入模板接口importTemplate
import { importTemplate } from "@/api/admin/company";
import { getToken } from "@/utils/auth";


export default {
  name: "Company",
  dicts: ['company_license','company_status'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // base_company 实有单位表格数据
      companyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 是否显示选择人员弹出层
      openP: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        communityCode: null,
        communityName: null,
        companyCode: null,
        companyName: null,
        companyType: null,
        companyTypeName: null,
        companyLicense: null,
        companyLicenseNum: null,
        companyAttention: null,
        companyScope: null,
        companyScopeName: null,
        companyAddress: null,
        companyLocation: null,
        companyLocationArea: null,
        companyImage: null,
        roomCode: null,
        ownerCode: null,
        ownerName: null,
        ownerPaperNum: null,
        ownerPhone: null,
        ownerImage: null,
        roomType: null,
        roomTypeName: null,
        legalCode: null,
        legalName: null,
        legalPaperNum: null,
        legalPhone: null,
        legalImage: null,
        companyStatus: null,
        companyStatusName: null,
        groupType: null,
        groupTypeName: null,
        licenseTime: null,
        produce: null,
        licenseAddress: null,
        contactEmail: null
      },
        // 用户导入参数
      upload: {
        // 是否显示弹出层（用户导入）
        open: false,
        // 弹出层标题（用户导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/admin/company/importData"
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询base_company 实有单位列表 */
    getList() {
      this.loading = true;
      listCompany(this.queryParams).then(response => {
        this.companyList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },

    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "用户导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      importTemplate().then(response => {
      this.download(response.msg);
      });
    },
    // 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },
    // 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false;
      this.upload.isUploading = false;
      this.$refs.upload.clearFiles();
      this.$alert(response.msg, "导入结果", { dangerouslyUseHTMLString: true });
      this.getList();
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    },

    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        communityCode: null,
        communityName: null,
        companyCode: null,
        companyName: null,
        companyType: null,
        companyTypeName: null,
        companyLicense: null,
        companyLicenseNum: null,
        companyAttention: null,
        companyScope: null,
        companyScopeName: null,
        companyAddress: null,
        companyLocation: null,
        companyLocationArea: null,
        companyImage: null,
        roomCode: null,
        ownerCode: null,
        ownerName: null,
        ownerPaperNum: null,
        ownerPhone: null,
        ownerImage: null,
        roomType: null,
        roomTypeName: null,
        legalCode: null,
        legalName: null,
        legalPaperNum: null,
        legalPhone: null,
        legalImage: null,
        companyStatus: 0,
        companyStatusName: null,
        groupType: null,
        groupTypeName: null,
        licenseTime: null,
        produce: null,
        licenseAddress: null,
        contactEmail: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加实有单位";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCompany(id).then(response => {
        response.data.companyImage='http://172.16.1.155/'+response.data.companyImage;
        console.log(response.data.companyImage);
        this.form = response.data;
        this.open = true;
        this.title = "修改实有单位";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCompany(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCompany(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除实有单位编号为"' + ids + '"的数据项？').then(function() {
        return delCompany(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin/company/export', {
        ...this.queryParams
      }, `company_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
