/*
 * Created by JFormDesigner on Sat Apr 30 09:07:21 CST 2022
 */

package cn.edu.guet.shopdemo.ui;

import cn.edu.guet.shopdemo.been.User;
import cn.edu.guet.shopdemo.tablemodel.GetDataBase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author 1
 */
public class CashierConsole extends JFrame {
    User user;
    public CashierConsole(User user) {
        this.user=user;
        initComponents();
        this.setSize(1000,450);
    }

    public CashierConsole() {
        initComponents();
        this.setSize(1000,450);
    }

    private void initComponents() {
        GetDataBase getDataBase=new GetDataBase();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();



        DefaultTableModel tableModel = new DefaultTableModel(getDataBase.getDataFromDatabase(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table1.setModel(tableModel);


        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("结算");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(860, 335), button1.getPreferredSize()));
        button1.addActionListener(
                (e)->{
                    PayMent payMent=new PayMent(user);
                    payMent.setVisible(true);
                }
        );
        //---- button2 ----
        button2.setText("清空");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(650, 335), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("删除当前商品");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(420, 335), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("修改");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(250, 335), button4.getPreferredSize()));

        //---- button5 ----
        button5.setText("添加");
        contentPane.add(button5);
        button5.setBounds(new Rectangle(new Point(80, 335), button5.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 50, 800, 265);

        //---- label1 ----
        label1.setText("实收：");
        contentPane.add(label1);
        label1.setBounds(835, 70, 55, label1.getPreferredSize().height);
        contentPane.add(textField1);
        textField1.setBounds(885, 70,85,textField1.getPreferredSize().height);


        //---- label2 ----
        label2.setText("应收：");
        contentPane.add(label2);
        label2.setBounds(835, 150, 55, label2.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(885, 150,85,textField2.getPreferredSize().height);
        textField2.setText(Float.toString(sum));

        //---- label3 ----
        label3.setText("找零：");
        contentPane.add(label3);
        label3.setBounds(835, 230, 55,label3.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(885, 230,85,textField3.getPreferredSize().height);

        //---- label4 ----
        label4.setText("商品信息");
        contentPane.add(label4);
        label4.setBounds(490, 10, 90, 27);

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
        //this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private  String head[]={"商品id","商品价格","商品数量","结算"};
    private  float sum;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
