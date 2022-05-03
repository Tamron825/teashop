/*
 * Created by JFormDesigner on Mon Apr 25 21:09:13 CST 2022
 */

package cn.edu.guet.shopdemo.ui;

import cn.edu.guet.shopdemo.been.User;
import cn.edu.guet.shopdemo.dao.UserDao;
import cn.edu.guet.shopdemo.dao.impl.UserDaoImpl;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 1
 */
public class Login extends JFrame {
    public Login() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        JPanel panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        username = new JTextField();
        password = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("登录界面");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setFont(new Font("STHeiti Light", Font.BOLD, 14));
        label1.setText("用户名:");
        contentPane.add(label1);
        label1.setBounds(110, 100, 50, 25);

        //---- label2 ----
        label2.setFont(new Font("STHeiti Light", Font.BOLD, 14));
        label2.setText("密    码:");
        contentPane.add(label2);
        label2.setBounds(110, 140, 50, 25);
        contentPane.add(username);
        username.setBounds(175, 100, 100, 24);
        contentPane.add(password);
        password.setBounds(175, 140, 100, 24);

        //---- label3 ----
        label3.setFont(new Font("STHeiti Light", Font.BOLD, 35));
        label3.setText("超市管理系统");
        contentPane.add(label3);
        label3.setBounds(82,36,300,35);

        //---- button1 ----
        button1.setText("登录");
        button1.addActionListener(
                (e) -> {
                    ResultSet rs;

                    String name = username.getText();
                    String pswd = String.valueOf(password.getPassword());

                    User user = new User();
                    user.setUsername(name);
                    user.setPassword(pswd);

                    UserDao userDao = new UserDaoImpl();
                    rs=userDao.onceUser(user);
                    try {
                        if (rs.next()) {
                            user_id=Integer.parseInt(rs.getString(1));
                            rank=Integer.parseInt(rs.getString(4));
                            user.setUser_id(user_id);
                            user.setRank(rank);
                            MainFrame mianFrame = new MainFrame(user);
                            this.setVisible(false);
                            mianFrame.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null,"账号或密码错误");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
        );

        contentPane.add(button1);
        button1.setBounds(110, 190,65,25);

        //---- button2 ----
        button2.setText("取消");
        button2.addActionListener(
                (e) -> {
                    System.exit(0);
                }
        );

        contentPane.add(button2);
        button2.setBounds(205, 190,65,25);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        this.setBounds(750, 330, 400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField username;
    private JPasswordField password;
    private JButton button1;
    private JButton button2;
    private int rank;
    private int user_id;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        new Login();
    }
}
