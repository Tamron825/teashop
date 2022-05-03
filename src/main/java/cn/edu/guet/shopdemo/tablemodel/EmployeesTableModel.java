package cn.edu.guet.shopdemo.tablemodel;

import cn.edu.guet.shopdemo.been.Employees;
import cn.edu.guet.shopdemo.util.ConnectionHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther wjw
 * @Date 2022/4/30 10:11
 * @Version 1.0
 */
public class EmployeesTableModel {
    private static ResultSet rs = null;
    private static Connection conn = null;
    private static Statement stmt = null;
    private static Object[][] data = null;
    private static Object[][] dataEmp = null;



    public static Object[][] getDataFromDatabase(String temp) {
        int head = 5;
        List<Employees> list = new ArrayList<Employees>();
        String sql = "SELECT * FROM employees";
        try {
            conn = ConnectionHandler.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employees eml = new Employees();
                eml.setE_id(rs.getInt(1));
                eml.setE_name(rs.getString(2));
                eml.setE_department((rs.getString(3)));
                eml.setE_posts(rs.getString(4));
                eml.setE_wages(rs.getInt(5));
                list.add(eml);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionHandler.closeConnection();
        }
        data = new Object[list.size()][head];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getE_id();
            data[i][1] = list.get(i).getE_name();
            data[i][2] = list.get(i).getE_department();
            data[i][3] = list.get(i).getE_posts();
            data[i][4] = list.get(i).getE_wages();

        }

        if (temp != null) {
            int x = 0;
            dataEmp = new Object[list.size()][head];
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < head; j++) {
                    String a = String.valueOf(data[i][j]);
                    if (a.equals(temp)) {
                        dataEmp[x][0] = list.get(i).getE_id();
                        dataEmp[x][1] = list.get(i).getE_name();
                        dataEmp[x][2] = list.get(i).getE_department();
                        dataEmp[x][3] = list.get(i).getE_posts();
                        dataEmp[x][4] = list.get(i).getE_wages();
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
