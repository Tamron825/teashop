package cn.edu.guet.shopdemo.dao.impl;


import cn.edu.guet.shopdemo.been.Product;
import cn.edu.guet.shopdemo.dao.ProductDao;
import cn.edu.guet.shopdemo.ui.Succeed;
import cn.edu.guet.shopdemo.util.ConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl implements ProductDao {
    public void deletep(int PID){
        Connection conn =null;
        String sql="DELETE FROM Product where Product_id=?";
        try {
            conn= ConnectionHandler.getConnection();
            PreparedStatement pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,PID);
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
    public void updatep(Product product, int PID){
        Connection conn =null;
        try{
            String sql;
            conn= ConnectionHandler.getConnection();
            sql = "UPDATE Product SET Product_id =?,Product_name =?,Product_price =?,Product_comment =? WHERE Product_id =?";
            PreparedStatement pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,product.getproduct_id());
            pstmt.setString(2,product.getproduct_name());
            pstmt.setFloat(3,product.getproduct_price());
            pstmt.setString(4,product.getproduct_comment());
            pstmt.setInt(5,PID);


            if(1==pstmt.executeUpdate()){//执行sql语句
                Succeed deleteSucceed = new Succeed("修改成功");
                deleteSucceed.setVisible(true);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void insertp(Product product){
        Connection conn =null;
        ResultSet rs = null;
        String sql ="insert into Product Values(?,?,?,?); ";
        try{
            conn= ConnectionHandler.getConnection();
            PreparedStatement pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,product.getproduct_id());
            pstmt.setString(2,product.getproduct_name());
            pstmt.setFloat(3,product.getproduct_price());
            pstmt.setString(4,product.getproduct_comment());
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