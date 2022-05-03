package cn.edu.guet.shopdemo.dao.impl;

import cn.edu.guet.shopdemo.been.Employees;
import cn.edu.guet.shopdemo.dao.EmployeesDao;
import cn.edu.guet.shopdemo.ui.Succeed;
import cn.edu.guet.shopdemo.util.ConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther wjw
 * @Date 2022/4/30 10:38
 * @Version 1.0
 */
public class EmployeesDaoImpl implements EmployeesDao {
    public void delete(int id){
        Connection conn =null;
        String sql="DELETE FROM employees where e_id=?";
        try {
            conn= ConnectionHandler.getConnection();
            PreparedStatement pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            if(1==pstmt.executeUpdate()){
                Succeed deleteSucceed = new Succeed("删除成功");
                deleteSucceed.setVisible(true);
            }
            else{
                Succeed deleteSucceed = new Succeed("删除失败");
                deleteSucceed.setVisible(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Employees employees, int oId){
        Connection conn =null;
        try{
            String sql;
            conn= ConnectionHandler.getConnection();
            sql = "UPDATE employees SET e_id =?,e_name =?,e_department =?,e_posts =?,e_wages =? WHERE e_id= ?";
            PreparedStatement pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,employees.getE_id());
            pstmt.setString(2,employees.getE_name());
            pstmt.setString(3,employees.getE_department());
            pstmt.setString(4,employees.getE_posts());
            pstmt.setInt(5,employees.getE_wages());
            pstmt.setInt(6,oId);

            if(1==pstmt.executeUpdate()){//执行sql语句
                Succeed deleteSucceed = new Succeed("修改成功");
                deleteSucceed.setVisible(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void insert(Employees employees){
        Connection conn =null;
        ResultSet rs = null;
        String sql ="insert into employees Values(?,?,?,?,?); ";
        try{
            conn= ConnectionHandler.getConnection();
            PreparedStatement pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,employees.getE_id());
            pstmt.setString(2,employees.getE_name());
            pstmt.setString(3,employees.getE_department());
            pstmt.setString(4,employees.getE_posts());
            pstmt.setInt(5,employees.getE_wages());
            if(1==pstmt.executeUpdate()){
                Succeed deleteSucceed = new Succeed("插入成功");
                deleteSucceed.setVisible(true);
            }
            else{
                Succeed deleteSucceed = new Succeed("插入失败");
                deleteSucceed.setVisible(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
