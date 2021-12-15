import request from '@/utils/request'

// 查询车辆信息列表
export function listCar(query) {
  return request({
    url: '/admin/car/list',
    method: 'get',
    params: query
  })
}

// 查询人员信息列表
export function listPerson(query) {
  return request({
    url: '/admin/car/person',
    method: 'get',
    params: query
  })
}

// 查询单位信息列表
export function listCompany(query) {
  return request({
    url: '/admin/car/company',
    method: 'get',
    params: query
  })
}

// 查询车辆信息详细
export function getCar(id) {
  return request({
    url: '/admin/car/' + id,
    method: 'get'
  })
}

// 新增车辆信息
export function addCar(data) {
  return request({
    url: '/admin/car',
    method: 'post',
    data: data
  })
}

// 修改车辆信息
export function updateCar(data) {
  return request({
    url: '/admin/car',
    method: 'put',
    data: data
  })
}

// 删除车辆信息
export function delCar(id) {
  return request({
    url: '/admin/car/' + id,
    method: 'delete'
  })
}
