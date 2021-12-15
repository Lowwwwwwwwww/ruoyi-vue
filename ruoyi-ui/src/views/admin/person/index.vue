<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入手机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="sexName">
        <el-input
          v-model="queryParams.sexName"
          placeholder="请输入性别"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出生日期" prop="birthday">
        <el-date-picker clearable size="small"
          v-model="queryParams.birthday"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择出生日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="国别名称" prop="countryName">
        <el-input
          v-model="queryParams.countryName"
          placeholder="请输入国别名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="民族名称" prop="nationalityName">
        <el-input
          v-model="queryParams.nationalityName"
          placeholder="请输入民族名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="证件号码" prop="paperNumber">
        <el-input
          v-model="queryParams.paperNumber"
          placeholder="请输入证件号码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="户籍地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入户籍地址"
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
          v-hasPermi="['admin:person:add']"
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
          v-hasPermi="['admin:person:edit']"
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
          v-hasPermi="['admin:person:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['admin:person:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="personList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="主键ID" align="center" prop="id" /> -->
      <!-- <el-table-column label="人员代码" align="center" prop="code" /> -->
      <!-- <el-table-column label="小区代码" align="center" prop="communityCode" /> -->
      <!-- <el-table-column label="小区名称" align="center" prop="communityName" /> -->
      <!-- <el-table-column label="房间代码" align="center" prop="roomCode" /> -->
      <el-table-column label="姓名" align="center" prop="name" />
      <!-- <el-table-column label="人员类型" align="center" prop="type" /> -->
      <el-table-column label="人员类型名称" align="center" prop="typeName">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.person_type" :value="scope.row.typeName"/>
        </template>
      </el-table-column>
      <el-table-column label="手机号" align="center" prop="phone" />
      <!-- <el-table-column label="性别" align="center" prop="sex" /> -->
      <el-table-column label="性别名称" align="center" prop="sexName" />
      <!-- <el-table-column label="出生日期" align="center" prop="birthday" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column> -->
      <!-- <el-table-column label="国别" align="center" prop="country" /> -->
      <!-- <el-table-column label="国别名称" align="center" prop="countryName" /> -->
      <!-- <el-table-column label="民族" align="center" prop="nationality" /> -->
      <!-- <el-table-column label="民族名称" align="center" prop="nationalityName" /> -->
      <!-- <el-table-column label="证件类型" align="center" prop="paperType" /> -->
      <!-- <el-table-column label="证件类型名称" align="center" prop="paperTypeName" /> -->
      <el-table-column label="证件号码" align="center" prop="paperNumber" />
      <el-table-column label="户籍地址" align="center" prop="address" />
      <!-- <el-table-column label="婚姻状况" align="center" prop="marriage" /> -->
      <!-- <el-table-column label="婚姻状态名称" align="center" prop="marriageName" /> -->
      <!-- <el-table-column label="政治面貌" align="center" prop="political" /> -->
      <!-- <el-table-column label="政治面貌名称" align="center" prop="politicalName" /> -->
      <!-- <el-table-column label="学历" align="center" prop="education" /> -->
      <!-- <el-table-column label="学历名称" align="center" prop="educationName" /> -->
      <!-- <el-table-column label="职业" align="center" prop="occupation" /> -->
      <el-table-column label="人脸图像" prop="image">
        <template slot-scope="scope" >
            <el-popover placement="right" title trigger="click">
      　　　　<img :src="'http://172.16.1.155/'+scope.row.image" width="300" height="600"/>
             <img slot="reference" :src="'http://172.16.1.155/'+scope.row.image"  style="max-height: 150px;max-width: 80px"/>
          </el-popover>
      　</template>
      </el-table-column>
      <el-table-column label="现居地地址" align="center" prop="livePlace" />
      <el-table-column label="实有力量类型名称" align="center" prop="powerTypeName">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.power_type" :value="scope.row.powerTypeName"/>
        </template>
      </el-table-column>
      <el-table-column label="工作单位" align="center" prop="company" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['admin:person:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:person:remove']"
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

    <!-- 添加或修改人员信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="110px">
        <!-- <el-form-item label="人员代码" prop="code">
          <el-input v-model="form.code" placeholder="请输入人员代码" />
        </el-form-item> -->
        <!-- <el-form-item label="小区代码" prop="communityCode">
          <el-input v-model="form.communityCode" placeholder="请输入小区代码" />
        </el-form-item>
        <el-form-item label="小区名称" prop="communityName">
          <el-input v-model="form.communityName" placeholder="请输入小区名称" />
        </el-form-item> -->
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="人员类型名称" prop="typeName">
          <!-- <el-input v-model="form.typeName" placeholder="请输入人员类型名称" /> -->
          <el-select v-model="form.typeName" placeholder="请选择人员类型">
            <el-option
              v-for="dict in dict.type.person_type"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="性别" prop="sexName">
          <!-- <el-input v-model="form.sexName" placeholder="请输入性别" /> -->
          <el-select v-model="form.sexName" placeholder="">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="证件号码" prop="paperNumber">
          <el-input v-model="form.paperNumber" placeholder="请输入证件号码" />
        </el-form-item>
        <el-form-item label="户籍地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入户籍地址" />
        </el-form-item>
        <el-form-item label="人脸图像">
          <imageUpload v-model="form.image"/>
        </el-form-item>
        <el-form-item label="现居地地址" prop="livePlace">
          <el-input v-model="form.livePlace" placeholder="请输入现居地地址" />
        </el-form-item>

        <el-form-item label="居住逻辑" prop="addressType">
          <el-select v-model="form.addressType" placeholder="请选择居住逻辑">
            <el-option
              v-for="dict in dict.type.address_type"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="实有力量类型" prop="powerTypeName">
          <el-select v-model="form.powerTypeName" placeholder="请选择实有力量类型">
            <el-option
              v-for="dict in dict.type.power_type"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="工作单位" prop="company">
          <!-- <el-input v-model="form.company" placeholder="请输入工作单位" /> -->
          <el-select v-model="form.company" placeholder="">
            <el-option
              v-for="item in companyList"
              :key="item.companyCode"
              :label="item.companyName"
              :value="item.companyCode"
            ></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="是否持证上岗" prop="haveCertificate">
          <!-- <el-input v-model="form.haveCertificate" placeholder="请输入是否持证上岗" /> -->
          <el-select v-model="form.haveCertificate" placeholder="是否持证上岗">
            <el-option
              v-for="dict in dict.type.have_certificate"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
            </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listPerson, getPerson, delPerson, addPerson, updatePerson,listCompany } from "@/api/admin/person";

export default {
  name: "Person",
  dicts: ['address_type','power_type','have_certificate','person_type','sys_user_sex'],
  data() {
    return {
      companyList:[],
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
      // 人员信息表格数据
      personList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        code: null,
        communityCode: null,
        communityName: null,
        roomCode: null,
        name: null,
        type: null,
        typeName: null,
        phone: null,
        sex: null,
        sexName: null,
        birthday: null,
        country: null,
        countryName: null,
        nationality: null,
        nationalityName: null,
        paperType: null,
        paperTypeName: null,
        paperNumber: null,
        address: null,
        marriage: null,
        marriageName: null,
        political: null,
        politicalName: null,
        education: null,
        educationName: null,
        occupation: null,
        image: null,
        checkinTime: null,
        residencePermit: null,
        relation: null,
        relationName: null,
        faceGroupDetailId: null,
        opDate: null,
        groupType: null,
        livePlace: null,
        addressType: null,
        liveType: null,
        powerType: null,
        powerTypeName: null,
        company: null,
        haveCertificate: null,
        packageCode: null,
        linkTags: null,
        checkoutTime: null
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
    this.getCompany();
  },
  methods: {
    /** 查询人员信息列表 */
    getList() {
      this.loading = true;
      listPerson(this.queryParams).then(response => {
        this.personList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询单位信息列表 */
    getCompany() {
      this.loading = true;
      listCompany(this.queryParams).then(response => {
        this.companyList = response.data;
      });
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
        code: null,
        communityCode: null,
        communityName: null,
        roomCode: null,
        name: null,
        type: null,
        typeName: null,
        phone: null,
        sex: null,
        sexName: null,
        birthday: null,
        country: null,
        countryName: null,
        nationality: null,
        nationalityName: null,
        paperType: null,
        paperTypeName: null,
        paperNumber: null,
        address: null,
        marriage: null,
        marriageName: null,
        political: null,
        politicalName: null,
        education: null,
        educationName: null,
        occupation: null,
        image: null,
        checkinTime: null,
        residencePermit: null,
        relation: null,
        relationName: null,
        faceGroupDetailId: null,
        opDate: null,
        groupType: null,
        livePlace: null,
        addressType: null,
        liveType: null,
        powerType: null,
        powerTypeName: null,
        company: null,
        haveCertificate: null,
        packageCode: null,
        linkTags: null,
        checkoutTime: null
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
      this.title = "添加人员信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPerson(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改人员信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePerson(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPerson(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除人员信息编号为"' + ids + '"的数据项？').then(function() {
        return delPerson(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin/person/export', {
        ...this.queryParams
      }, `person_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
