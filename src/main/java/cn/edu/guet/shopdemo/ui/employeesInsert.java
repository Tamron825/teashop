package cn.edu.guet.shopdemo.ui;

import cn.edu.guet.shopdemo.been.Employees;
import cn.edu.guet.shopdemo.dao.EmployeesDao;
import cn.edu.guet.shopdemo.dao.impl.EmployeesDaoImpl;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther wjw
 * @Date 2022/4/30 16:09
 * @Version 1.0
 */
public class employeesInsert extends JFrame{
    public employeesInsert() {
        employeesinsert();
    }
    private void employeesinsert() {
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        setTitle("欢迎新人");
        setSize(500,300);
        setLocationRelativeTo(null);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        label1.setText("id");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(160, 40,50,30));

        //---- label2 ----
        label2.setText("姓名");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(160, 70,50,30));

        //---- label3 ----
        label3.setText("部门");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(160, 100,50,30));

        //---- label4 ----
        label4.setText("职务");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(160, 130,50,30));

        //---- label5 ----
        label5.setText("工资");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(160, 160,50,30));
        contentPane.add(textField1);
        textField1.setBounds(new Rectangle(220,40,100,30));
        contentPane.add(textField2);
        textField2.setBounds(new Rectangle(220,70,100,30));
        contentPane.add(textField3);
        textField3.setBounds(new Rectangle(220,100,100,30));
        contentPane.add(textField4);
        textField4.setBounds(new Rectangle(220,130,100,30));
        contentPane.add(textField5);
        textField5.setBounds(new Rectangle(220,160,100,30));

        button1.setText("确定");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(150,220,60,25));
        button1.addActionListener(
                e->{
                    int id = Integer.parseInt(textField1.getText());
                    String name=textField2.getText();
                    String department=textField3.getText();
                    String posts=textField4.getText();
                    int wages =Integer.parseInt(textField5.getText());
                    Employees employees = new Employees(id,name,department,posts,wages);
                    EmployeesDao employeesDao = new EmployeesDaoImpl();
                    employeesDao.insert(employees);

                    this.setVisible(false);
                }
        );

        //---- button2 ----
        button2.setText("返回");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(270,220,60,25));
        button2.addActionListener(
                e->{
                    this.setVisible(false);
                }
        );
        this.setResizable(false);

    }
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton button1;
    private JButton button2;

}
