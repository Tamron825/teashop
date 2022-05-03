/*
 * Created by JFormDesigner on Fri Apr 29 17:10:29 CST 2022
 */

package cn.edu.guet.shopdemo.ui;

import cn.edu.guet.shopdemo.been.User;
import cn.edu.guet.shopdemo.dao.UserDao;
import cn.edu.guet.shopdemo.dao.impl.UserDaoImpl;
import cn.edu.guet.shopdemo.util.CatchNullException;

import java.awt.*;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.*;

/**
 * @author 1
 */
public class UpdateUserFrame extends JFrame {
     User user=new User(0);
     private int chose = 0;
     private int lastid;

    public UpdateUserFrame(User user,int lastid) {
        this.user=user;
        this.lastid=lastid;
        initComponents();
    }
    public UpdateUserFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        idtxt = new JTextField(null);
        label2 = new JLabel();
        nametxt = new JTextField();
        label3 = new JLabel();
        passwordtxt = new JTextField();
        label4 = new JLabel();
        ranktxt = new JTextField();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("用户ID");
        contentPane.add(label1);
        label1.setBounds(45, 40,50,25);
        contentPane.add(idtxt);
        idtxt.setBounds(100, 40,75,25);

        //---- label2 ----
        label2.setText("用户名");
        contentPane.add(label2);
        label2.setBounds(200, 40,50,25);
        contentPane.add(nametxt);
        nametxt.setBounds(255, 40,75,25);

        //---- label3 ----
        label3.setText("密   码");
        contentPane.add(label3);
        label3.setBounds(45, 100,50,25);
        contentPane.add(passwordtxt);
        passwordtxt.setBounds(100, 100,75,25);

        //---- label4 ----
        label4.setText("级别");
        contentPane.add(label4);
        label4.setBounds(200, 100, 50,25);
        contentPane.add(ranktxt);
        ranktxt.setBounds(255, 100,75,25);

        if (user.getUser_id()!=0) {
            chose = 1;
            idtxt.setText(String.valueOf(user.getUser_id()));
            nametxt.setText(user.getUsername());
            passwordtxt.setText(user.getPassword());
            ranktxt.setText(String.valueOf(user.getRank()));
        }

        //---- button1 ----
        button1.setText("保存");
        button1.addActionListener(
                e -> {
                    try{
                        String uid = idtxt.getText();
                        String uname = nametxt.getText().trim();
                        String upwd = passwordtxt.getText();
                        String urank = ranktxt.getText();
                        if (uname.length()==0){
                            uname=null;
                        }
                        if (upwd.length()==0){
                            upwd=null;
                        }

                        User user = new User();
                        user.setUser_id(Integer.parseInt(uid));
                        user.setUsername(uname);
                        user.setPassword(upwd);
                        user.setRank(Integer.parseInt(urank));

                        UserDao userDao = new UserDaoImpl();

                        if (chose == 0) {       //判断用新建还行修改
                            if (userDao.addUser(user)) {              //新建
                                JOptionPane.showMessageDialog(null, "保存成功");
                                idtxt.setText("");
                                nametxt.setText("");
                                passwordtxt.setText("");
                                ranktxt.setText("");
                            }
                        } else {                                       //修改
                            if (userDao.updateUser(user, lastid)) {
                                JOptionPane.showMessageDialog(null, "保存成功");
                                this.setVisible(false);
                            }
                        }
                     } catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null,"ID和权限由数字组成");
                    }
                    catch (SQLIntegrityConstraintViolationException ex) {
                        String except = ex.toString();
                        //System.out.println(except);
                        CatchNullException cat = new CatchNullException();
                        //int now = cat.notNull(except);
                        //System.out.println(now);
                        if (cat.notNull(except)==0){
                            JOptionPane.showMessageDialog(null, "用户名不能为空");
                        }
                        if (cat.notNull(except)==1){
                            JOptionPane.showMessageDialog(null, "密码不能为空");
                        }
                        if (cat.notNull(except)==2){
                            JOptionPane.showMessageDialog(null, "ID或用户名已存在");
                        }
                    }
                }
        );
        contentPane.add(button1);
        button1.setBounds(150, 180,70,25);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
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
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField idtxt;
    private JLabel label2;
    private JTextField nametxt;
    private JLabel label3;
    private JTextField passwordtxt;
    private JLabel label4;
    private JTextField ranktxt;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
