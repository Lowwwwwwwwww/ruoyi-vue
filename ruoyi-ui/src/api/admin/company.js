import request from '@/utils/request'

// 查询base_company 实有单位列表
export function listCompany(query) {
  return request({
    url: '/admin/company/list',
    method: 'get',
    params: query
  })
}

// 查询base_company 实有单位详细
export function getCompany(id) {
  return request({
    url: '/admin/company/' + id,
    method: 'get'
  })
}

// 新增base_company 实有单位
export function addCompany(data) {
  return request({
    url: '/admin/company',
    method: 'post',
    data: data
  })
}

// 修改base_company 实有单位
export function updateCompany(data) {
  return request({
    url: '/admin/company',
    method: 'put',
    data: data
  })
}

// 删除base_company 实有单位
export function delCompany(id) {
  return request({
    url: '/admin/company/' + id,
    method: 'delete'
  })
}
