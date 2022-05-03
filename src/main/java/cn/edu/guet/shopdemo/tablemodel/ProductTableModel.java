package cn.edu.guet.shopdemo.tablemodel;

import cn.edu.guet.shopdemo.been.Product;
import cn.edu.guet.shopdemo.util.ConnectionHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductTableModel {
    private static ResultSet rs = null;
    private static Connection conn = null;
    private static Statement stmt = null;
    private static Object[][] data = null;
    private static Object[][] datapro = null;

    public static Object[][] getDataFromDatabase(String temp) {
        int head = 5;
        List<Product> list = new ArrayList<Product>();
        String sql = "SELECT * FROM Product";
        try {
            conn = ConnectionHandler.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Product product= new Product();
                product.setproduct_id(rs.getInt(1));
                product.setproduct_name(rs.getString(2));
                product.setproduct_price(rs.getFloat(3));
                product.setproduct_comment(rs.getString(4));
                list.add(product);
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
                data[i][0] = list.get(i).getproduct_id();
                data[i][1] = list.get(i).getproduct_name();
                data[i][2] = list.get(i).getproduct_price();
                data[i][3] = list.get(i).getproduct_comment();
            }
        }

        if (temp != null) {
            int x = 0;
            datapro = new Object[list.size()][head];
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < head; j++) {
                    String a = String.valueOf(data[i][j]);
                    if (a.equals(temp)) {
                        datapro[x][0] = list.get(i).getproduct_id();
                        datapro[x][1] = list.get(i).getproduct_name();
                        datapro[x][2] = list.get(i).getproduct_price();
                        datapro[x][3] = list.get(i).getproduct_comment();
                        x++;
                        break;
                    }
                }
            }
            return datapro;
        }
        return data;
    }


}
