package cn.edu.guet.shopdemo.tablemodel;

import cn.edu.guet.shopdemo.been.Order;
import cn.edu.guet.shopdemo.util.ConnectionHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetDataBase {
   private Object[][] data = null;
   private  int num;
   private float orderprice;
   private String ifmo;
   int head=4;

    public String gethh()
    {
        java.util.List<Order> list = new ArrayList<Order>();
        Connection conn = null;
        Statement stmt = null;
        String sql = "select item_id,item_price,item_num,item_price*item_num 'op' from shopping_cart";
        ResultSet rs = null;
        try {
            conn= ConnectionHandler.getConnection();
            //conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Order item = new Order();
                item.setItem_id(rs.getInt(1));
                item.setItem_price(rs.getFloat(2));
                item.setAmount(rs.getInt(3));
                item.setOrder_price(rs.getFloat(4));
                list.add(item);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionHandler.closeConnection();
        }

        String a=";amount,"+list.get(0).getAmount()+";";
        String b=";order_price,"+list.get(0).getItem_price();
        ifmo="id,"+list.get(0).getItem_id()+b+a;

        //System.out.println(a);
        return ifmo;
    }

    public Object[][] getDataFromDatabase() {
        java.util.List<Order> list = new ArrayList<Order>();
        Connection conn = null;
        Statement stmt = null;
        String sql = "select item_id,item_price,amount,item_price*amount 'op',order_time from order_info";
        ResultSet rs = null;
        try {
            conn = ConnectionHandler.getConnection();
            //conn = DriverManager.getConnection(url, user, dbPassword);
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionHandler.closeConnection();
        }
            // 把集合的数据（商品信息）转换成二维数组
        data = new Object[list.size()][head];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head; j++) {
                data[i][0] = list.get(i).getItem_id();
                data[i][1] = list.get(i).getItem_price();
                data[i][2] = list.get(i).getAmount();
                data[i][3] = list.get(i).getOrder_price();
                //data[i][4] = list.get(i).getOrder_time();
            }
        }
        return data;
    }
}
