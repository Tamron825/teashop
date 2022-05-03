package cn.edu.guet.shopdemo.util;

import javax.swing.*;

public class GetImageIcon extends JPanel{
    private ImageIcon imageIcon;
    public ImageIcon getImageIcon()
    {
        //WXPay wxPay=new WXPay();
        //wxPay.unifiedOrder();
        imageIcon = new ImageIcon("src\\main\\picture\\new.jpg");
        return imageIcon;
    }
    public void updateImage(ImageIcon img)
    {
        imageIcon=img;
        repaint();
    }
}
