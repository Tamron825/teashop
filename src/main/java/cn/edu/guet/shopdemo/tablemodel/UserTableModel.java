package cn.edu.guet.shopdemo.tablemodel;

import cn.edu.guet.shopdemo.been.User;
import cn.edu.guet.shopdemo.util.ConnectionHandler;

import java.sql.*;
import java.util.ArrayList;

public class UserTableModel {
    private static ResultSet rs = null;
    private static Connection conn = null;
    private static Statement stmt = null;
    private static Object[][] data = null;
    private static Object[][] dataEmp = null;

    public static Object[][] getDataFromDatabase(String temp) {
        int head = 4;
        java.util.List<User> list = new ArrayList<User>();
        String sql = "SELECT * FROM users";
        try {
            conn = ConnectionHandler.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRank(rs.getInt(4));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionHandler.closeConnection();
        }
        // 把集合的数据（商品信息）转换成二维数组
        data = new Object[list.size()][head];

        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getUser_id();
            data[i][1] = list.get(i).getUsername();
            data[i][2] = list.get(i).getPassword();
            data[i][3] = list.get(i).getRank();
        }

        if (temp != null) {
            int x = 0;
            dataEmp = new Object[list.size()][head];
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < head; j++) {
                    String a = String.valueOf(data[i][j]);
                    if (a.equals(temp)) {
                        dataEmp[x][0] = list.get(i).getUser_id();
                        dataEmp[x][1] = list.get(i).getUsername();
                        dataEmp[x][2] = list.get(i).getPassword();
                        dataEmp[x][3] = list.get(i).getRank();
                        x++;
                        break;
                    }
                }
            }
            return dataEmp;
        }
        return data;
    }

}
