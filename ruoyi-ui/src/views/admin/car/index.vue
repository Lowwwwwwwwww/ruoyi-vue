<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="80px">
      <el-form-item label="车牌" prop="num">
        <el-input
          v-model="queryParams.num"
          placeholder="请输入车牌"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车牌颜色" prop="numColorName">
        <el-input
          v-model="queryParams.numColorName"
          placeholder="请输入车牌颜色"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="车类型" prop="typeName">
        <el-input
          v-model="queryParams.typeName"
          placeholder="请输入车类型"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="品牌" prop="brandName">
        <el-input
          v-model="queryParams.brandName"
          placeholder="请输入品牌"
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
          v-hasPermi="['admin:car:add']"
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
          v-hasPermi="['admin:car:edit']"
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
          v-hasPermi="['admin:car:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['admin:car:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="carList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="id" align="center" prop="id" /> -->
      <el-table-column label="车牌" align="center" prop="num" />
      <!-- <el-table-column label="车牌颜色" align="center" prop="numColor" /> -->
      <el-table-column label="车牌颜色名称" align="center" prop="numColorName" />
      <!-- <el-table-column label="颜色" align="center" prop="color" /> -->
      <el-table-column label="颜色名称" align="center" prop="colorName" />
      <!-- <el-table-column label="类型" align="center" prop="type" /> -->
      <el-table-column label="车类型名称" align="center" prop="typeName">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.car_type_name" :value="scope.row.typeName"/>
        </template>
      </el-table-column>
      <!-- <el-table-column label="品牌" align="center" prop="brand" /> -->
      <el-table-column label="品牌名称" align="center" prop="brandName" />
      <el-table-column label="车辆照片" prop="image">
        <template slot-scope="scope" >
          <el-popover placement="right" title trigger="click">
      　　　　<img :src="'http://172.16.1.155/'+scope.row.image" width="1300" height="500"/>
             <img slot="reference" :src="'http://172.16.1.155/'+scope.row.image"  style="max-height: 100px;max-width: 150px"/>
          </el-popover>
      　</template>
      </el-table-column>
      <el-table-column label="人员code" align="center" prop="personCode" />
      <!-- <el-table-column label="小区code" align="center" prop="communityCode" /> -->
      <el-table-column label="小区名称" align="center" prop="communityName" />
      <!-- <el-table-column label="${comment}" align="center" prop="carGroupDetailId" /> -->
      <el-table-column label="操作时间" align="center" prop="opTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.opTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column label="车辆所属单位编码" align="center" prop="companyCode" /> -->
      <!-- <el-table-column label="车辆属性(1私家车 2公车)" align="center" prop="properties">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.car_properties" :value="scope.row.properties"/>
        </template>
      </el-table-column>
      <el-table-column label="车辆运输货物 内容和质量" align="center" prop="carTransport" />
      <el-table-column label="车辆标识 0正常物品 1危化物品" align="center" prop="carSign" />
      <el-table-column label="${comment}" align="center" prop="groupTypeName" />
      <el-table-column label="库的code" align="center" prop="packageCode" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['admin:car:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['admin:car:remove']"
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

    <!-- 添加或修改车辆信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="车牌" prop="num">
          <el-input v-model="form.num" placeholder="请输入车牌" />
        </el-form-item>

        <el-form-item label="车牌颜色名称" prop="numColorName">
          <el-input v-model="form.numColorName" placeholder="请输入车牌颜色名称" />
        </el-form-item>

        <el-form-item label="颜色名称" prop="colorName">
          <el-input v-model="form.colorName" placeholder="请输入颜色名称" />
        </el-form-item>
        <el-form-item label="车类型名称" prop="typeName">
          <!-- <el-input v-model="form.typeName" placeholder="请输入车类型名称" /> -->
          <el-select v-model="form.typeName" placeholder="请选择车辆车类型">
            <el-option
              v-for="dict in dict.type.car_type_name"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="品牌名称" prop="brandName">
          <el-input v-model="form.brandName" placeholder="请输入品牌名称" />
        </el-form-item>
        <el-form-item label="车辆照片">
          <imageUpload v-model="form.image"/>
        </el-form-item>
        <el-form-item label="人员code" prop="personCode">
          <el-input v-model="form.personCode" @focus="openPerson()" placeholder="请输入人员code" />
        </el-form-item>

        <el-form-item label="车辆所属单位" prop="companyCode">
          <!-- <el-input v-model="form.companyCode" placeholder="请输入车辆单位" /> -->
          <el-select v-model="form.companyCode" placeholder="">
            <el-option
              v-for="item in companyList"
              :key="item.companyCode"
              :label="item.companyName"
              :value="item.companyCode"
            ></el-option>
            </el-select>
        </el-form-item>

        <el-form-item label="操作时间" prop="opTime">
          <el-date-picker clearable size="small"
            v-model="form.opTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择操作时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="车辆属性" prop="properties">
          <el-select v-model="form.properties" placeholder="请选择车辆属性">
            <el-option
              v-for="dict in dict.type.car_properties"
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
import { listCar, getCar, delCar, addCar, updateCar, listCompany, listPerson } from "@/api/admin/car";

export default {
  name: "Car",
  dicts: ['car_properties','car_type_name'],
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
      // 车辆信息表格数据
      carList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        num: null,
        numColor: null,
        numColorName: null,
        color: null,
        colorName: null,
        type: null,
        typeName: null,
        brand: null,
        brandName: null,
        image: null,
        personCode: null,
        communityCode: null,
        communityName: null,
        carGroupDetailId: null,
        opTime: null,
        companyCode: null,
        properties: null,
        carTransport: null,
        carSign: null,
        groupTypeName: null,
        packageCode: null
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
    /** 查询车辆信息列表 */
    getList() {
      this.loading = true;
      listCar(this.queryParams).then(response => {
        this.carList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 查询人员信息列表 */
    getPerson() {
      this.loading = true;
      listPerson(this.queryParams).then(response => {
        this.personList = response.data;
      });
    },
    openPerson() {
      // this.dialogFormVisible = true
      // setTimeout(() => {
      //   //这里是请求后端的方法，生成表格数据
      //   this.getPerson()
      //   }, 50)
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
        num: null,
        numColor: null,
        numColorName: null,
        color: null,
        colorName: null,
        type: null,
        typeName: null,
        brand: null,
        brandName: null,
        image: null,
        personCode: null,
        communityCode: null,
        communityName: null,
        carGroupDetailId: null,
        opTime: null,
        companyCode: null,
        properties: null,
        carTransport: null,
        carSign: null,
        groupTypeName: null,
        packageCode: null
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
      this.title = "添加车辆信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCar(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改车辆信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCar(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCar(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除车辆信息编号为"' + ids + '"的数据项？').then(function() {
        return delCar(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('admin/car/export', {
        ...this.queryParams
      }, `car_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
