package cn.edu.guet.shopdemo.tablemodel;

import cn.edu.guet.shopdemo.been.Order;
import cn.edu.guet.shopdemo.util.ConnectionHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderStatistics {
    public void getdata() {
        java.util.List<Order> list = new ArrayList<Order>();
        Connection conn=null;
        Statement stmt = null;
        String sql = "select item_id,item_price,amount,item_price*amount 'op',order_time from order_info";
        ResultSet rs = null;
        try {
            conn = ConnectionHandler.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Order item = new Order();
                item.setItem_id(rs.getInt(1));
                item.setItem_price(rs.getFloat(2));
                item.setAmount(rs.getInt(3));
                item.setOrder_price(rs.getFloat(4));
                item.setOrder_time(rs.getTimestamp(5));
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
