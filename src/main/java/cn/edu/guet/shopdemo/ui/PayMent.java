/*
 * Created by JFormDesigner on Sat Apr 30 14:51:40 CST 2022
 */

package cn.edu.guet.shopdemo.ui;


import cn.edu.guet.shopdemo.been.User;
import cn.edu.guet.shopdemo.pay.WXPay;
import cn.edu.guet.shopdemo.util.GetImageIcon;

import javax.swing.*;
import java.awt.*;

/**
 * @author 1
 */
public class PayMent extends JFrame {
    User user;
    public PayMent(User user) {
        this.user=user;
        initComponents();
        this.setSize(700,450);
    }

    public PayMent() {
        initComponents();
        this.setSize(700,450);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();
        label = new JLabel();
        textField1 =new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("微信二维码支付");
        contentPane.add(button1);
        button1.setBounds(35, 350, 120, button1.getPreferredSize().height);
        button1.addActionListener(
                (e)->{
                    WXPay.unifiedOrder(user);
                    GetImageIcon getimage=new GetImageIcon();
                    imageIcon=getimage.getImageIcon();
                    label= new JLabel();
                    this.add(label);
                    label.setBounds(100, 0, 350, 350);
                    label.setIcon(imageIcon);//label内容为图片
                });

        //---- button4 ----
        button2.setText("微信条形码支付");
        contentPane.add(button2);
        button2.setBounds(450, 350, 120, button2.getPreferredSize().height);
        button2.addActionListener((e)->{
            try {
                WXPay.scanCodeToPay(textField1.getText());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        textField1.setText("");
        contentPane.add(textField1);
        textField1.setBounds(450,75,100,50);


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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    private JLabel label;
    private JTextField textField1;
    private  ImageIcon imageIcon;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
