/*
 * Created by JFormDesigner on Sat Apr 30 15:13:40 CST 2022
 */

package cn.edu.guet.shopdemo.ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author 1
 */
public class Succeed extends JFrame {
    public Succeed(String succeed) {
        initComponents(succeed);
    }
    private void initComponents(String succeed) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        jFrame = new JFrame();
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========

        jFrame=new JFrame("删除");
        //设置窗口大小
        setSize(200,220);
        //使窗口剧中
        setLocationRelativeTo(null);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----


            label1.setText(succeed);

        contentPane.add(label1);
        label1.setBounds(new Rectangle(70, 40,60,25));

        //---- button1 ----
        button1.setText("确定");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(65,100,60,25));

        button1.addActionListener(
                e->{
                    this.setVisible(false);
                }
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setResizable(false);
    }
    private JFrame jFrame;
    private JLabel label1;
    private JButton button1;

}
