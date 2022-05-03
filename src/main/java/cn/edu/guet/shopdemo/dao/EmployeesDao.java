package cn.edu.guet.shopdemo.dao;

import cn.edu.guet.shopdemo.been.Employees;

/**
 * @Auther wjw
 * @Date 2022/4/30 10:37
 * @Version 1.0
 */
public interface EmployeesDao {

    void delete(int id);//删除,得到id
    void update(Employees employees, int oId);//修改
    void insert(Employees employees);
}
