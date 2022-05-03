package cn.edu.guet.shopdemo.ui;

import cn.edu.guet.shopdemo.been.Product;
import cn.edu.guet.shopdemo.dao.ProductDao;
import cn.edu.guet.shopdemo.dao.impl.ProductDaoImpl;
import cn.edu.guet.shopdemo.tablemodel.ProductTableModel;

import javax.swing.*;
import java.awt.*;

/**
 * @STL
 */
public class ProductUpdate extends JFrame {
    Product product;

    public ProductUpdate(Product product) {
        this.product = product;
        initComponents();
    }

    private void initComponents() {
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        button1 = new JButton();

        //======== this ========
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("商品ID：");
        contentPane.add(label1);
        label1.setBounds(20, 20, 55, 20);
        contentPane.add(textField1);
        textField1.setBounds(70, 20, 130, 20);
        textField1.setText(String.valueOf(product.getproduct_id()));

        //---- label2 ----
        label2.setText("商品名称：");
        contentPane.add(label2);
        label2.setBounds(240, 20, 90, 20);
        contentPane.add(textField2);
        textField2.setBounds(300, 20, 130, 20);
        textField2.setText(product.getproduct_name());

        //---- label3 ----
        label3.setText("单价：");
        contentPane.add(label3);
        label3.setBounds(20, 80, 55, 20);
        contentPane.add(textField3);
        textField3.setBounds(70, 80, 130, 20);
        textField3.setText(String.valueOf(product.getproduct_price()));

        //---- label5 ----
        label5.setText("商品描述：");
        contentPane.add(label5);
        label5.setBounds(20, 140, 55, 20);
        contentPane.add(textField5);
        textField5.setBounds(70, 140, 130, 20);
        textField5.setText(String.valueOf(product.getproduct_comment()));


        //---- button1 ----
        button1.setText("保存");
        contentPane.add(button1);
        button1.setBounds(200, 300, 100, 30);
        button1.addActionListener(
                (e)->{
                    int PID=product.getproduct_id();
                    int id=(Integer.valueOf(textField1.getText()));
                    String name=textField2.getText();
                    float price=Float.valueOf(textField3.getText());
                    String comment=textField5.getText();
                    Product pro =new Product(id,name,price,comment);
                    ProductDao productDao=new ProductDaoImpl();
                    productDao.updatep(pro,PID);
                    this.setVisible(false);
                    // 执行UPDATE
                }
        );

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
        this.setBounds(600, 300, 480, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label5;
    private JTextField textField5;
    private JButton button1;
}
