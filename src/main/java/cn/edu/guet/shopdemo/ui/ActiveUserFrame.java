/*
 * Created by JFormDesigner on Sun May 01 21:06:48 CST 2022
 */

package cn.edu.guet.shopdemo.ui;

import cn.edu.guet.shopdemo.been.User;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class ActiveUserFrame extends JFrame {
    User user;
    public ActiveUserFrame(User user) {
        this.user=user;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("当前用户");
        contentPane.add(label1);
        label1.setBounds(60, 16,80,25);
        contentPane.add(textField1);
        textField1.setText(user.getUsername());
        textField1.setBounds(130,16,80,25);


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
        this.setBounds(750, 330, 300, 100);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField textField1;
    private JLabel label1;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
