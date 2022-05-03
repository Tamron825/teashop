/*
 * Created by JFormDesigner on Thu Apr 28 22:37:34 CST 2022
 */

package cn.edu.guet.shopdemo.ui;

import cn.edu.guet.shopdemo.been.Employees;
import cn.edu.guet.shopdemo.been.Product;
import cn.edu.guet.shopdemo.been.User;
import cn.edu.guet.shopdemo.dao.EmployeesDao;
import cn.edu.guet.shopdemo.dao.ProductDao;
import cn.edu.guet.shopdemo.dao.UserDao;
import cn.edu.guet.shopdemo.dao.impl.EmployeesDaoImpl;
import cn.edu.guet.shopdemo.dao.impl.ProductDaoImpl;
import cn.edu.guet.shopdemo.dao.impl.UserDaoImpl;
import cn.edu.guet.shopdemo.tablemodel.EmployeesTableModel;
import cn.edu.guet.shopdemo.tablemodel.ProductTableModel;
import cn.edu.guet.shopdemo.tablemodel.UserTableModel;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class MainFrame extends JFrame {
    User user;
    public MainFrame(User user) {
        this.user=user;
        initComponents();
    }

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar2 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menu2 = new JMenu();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        tabbedPane4 = new JTabbedPane();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        select = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button13 = new JButton();
        panel2 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        textField2 = new JTextField();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button14 = new JButton();
        panel3 = new JPanel();
        scrollPane3 = new JScrollPane();
        table3 = new JTable();
        textField3 = new JTextField();
        button9 = new JButton();
        button10 = new JButton();
        button11 = new JButton();
        button12 = new JButton();
        button15 = new JButton();
        panel4 = new JPanel();
        scrollPane4 = new JScrollPane();
        table4 = new JTable();
        button16 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar2 ========
        {

            //======== menu1 ========
            {
                menu1.setText("选项");

                //---- menuItem1 ----
                menuItem1.setText("收银界面");
                menuItem1.addActionListener(
                        e -> {
                            CashierConsole cash = new CashierConsole(user);
                            cash.setVisible(true);
                        }
                );
                menu1.add(menuItem1);
            }
            menuBar2.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("系统");

                //---- menuItem2 ----
                menuItem2.setText("切换账号");
                menuItem2.addActionListener(
                        e -> {
                            Login login = new Login();
                            this.setVisible(false);
                            login.setVisible(true);
                        }
                );
                menu2.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("当前用户");
                menuItem3.addActionListener(
                        e -> {
                            ActiveUserFrame active = new ActiveUserFrame(user);
                            active.setVisible(true);
                        }
                );
                menu2.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("退出系统");
                menuItem4.addActionListener(
                        e -> {
                            System.exit(0);
                        }
                );
                menu2.add(menuItem4);
            }
            menuBar2.add(menu2);
        }
        setJMenuBar(menuBar2);

        //======== tabbedPane4 ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(null);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table1);
                    String temp=null;
                    usertableModel = new DefaultTableModel(UserTableModel.getDataFromDatabase(temp), head) {
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    table1.setModel(usertableModel);
                }
                panel1.add(scrollPane1);
                scrollPane1.setBounds(0, 0, 700, 265);//表的位置大小
                panel1.add(select);
                select.setBounds(65, 275,60,25);

                //---- button1 ----
                button1.setText("查询");
                button1.addActionListener(
                        e -> {
                            String temp = select.getText();
                            ((DefaultTableModel)table2.getModel()).getDataVector().clear();//清空表格
                            usertableModel = new DefaultTableModel(UserTableModel.getDataFromDatabase(temp), head) {
                                public boolean isCellEditable(int row, int column) {
                                    return false;
                                }
                            };
                            table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            table1.setModel(usertableModel);
                        }
                );
                panel1.add(button1);
                button1.setBounds(new Rectangle(new Point(150, 275), button1.getPreferredSize()));

                //---- button2 ----
                button2.setText("新增");
                button2.addActionListener(
                        e -> {
                            UpdateUserFrame updateUserFrame=new UpdateUserFrame();
                            updateUserFrame.setVisible(true);
                        }
                );
                panel1.add(button2);
                button2.setBounds(new Rectangle(new Point(245, 275), button2.getPreferredSize()));

                //---- button3 ----
                button3.setText("删除");
                button3.addActionListener(
                        e -> {
                            int rowNo = table1.getSelectedRow();//获取所选的行号
                            int id = (int) table1.getValueAt(rowNo, 0);
                            User user = new User();
                            user.setUser_id(id);
                            UserDao userDao = new UserDaoImpl();
                            if (userDao.delectUser(user)){
                                JOptionPane.showMessageDialog(null,"删除成功");
                            } else {
                                JOptionPane.showMessageDialog(null,"删除失败");
                            }
                        }
                );
                panel1.add(button3);
                button3.setBounds(new Rectangle(new Point(340, 275), button3.getPreferredSize()));

                //---- button4 ----
                button4.setText("修改");
                button4.addActionListener(
                        e -> {
                            try {
                                int rowNo = table1.getSelectedRow();//获取所选的行号
                                int id = (int) table1.getValueAt(rowNo, 0);
                                int lastid = (int) table1.getValueAt(rowNo, 0);
                                String username = (String) table1.getValueAt(rowNo, 1);
                                String password = (String) table1.getValueAt(rowNo, 2);
                                int rank = (int) table1.getValueAt(rowNo, 3);

                                User user=new User(id,username,password,rank);

                                UpdateUserFrame updateItem=new UpdateUserFrame(user,lastid);
                                updateItem.setVisible(true);
                            } catch (Exception ex){
                                JOptionPane.showMessageDialog(null,"请选择要修改的数据");
                            }
                        }
                );
                panel1.add(button4);
                button4.setBounds(new Rectangle(new Point(435, 275), button4.getPreferredSize()));

                //---- button13 ----
                button13.setText("刷新");
                button13.addActionListener(
                        e -> {
                            String temp=null;
                            usertableModel = new DefaultTableModel(UserTableModel.getDataFromDatabase(null), head) {
                                public boolean isCellEditable(int row, int column) {
                                    return false;
                                }
                            };
                            table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            table1.setModel(usertableModel);
                        }
                );

                panel1.add(button13);
                button13.setBounds(new Rectangle(new Point(530, 275), button13.getPreferredSize()));

            }
            if (user.getRank()!=3){
                tabbedPane4.addTab("用户管理", panel1);
            }


            //======== panel2 ========
            {
                panel2.setLayout(null);

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(table2);
                    String temp=null;
                    employeesTableModel = new DefaultTableModel(EmployeesTableModel.getDataFromDatabase(temp), heademp) {
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    table2.setModel(employeesTableModel);
                }
                panel2.add(scrollPane2);
                scrollPane2.setBounds(0, 0, 690, 265);
                panel2.add(textField2);
                textField2.setBounds(65, 275,60,25);

                //---- button5 ----
                button5.setText("查询"); //员工查询
                button5.addActionListener(
                        e->{
                            String temp = textField2.getText();
                            ((DefaultTableModel)table2.getModel()).getDataVector().clear();//清空表格
                            employeesTableModel = new DefaultTableModel(EmployeesTableModel.getDataFromDatabase(temp), heademp) {
                                public boolean isCellEditable(int row, int column) {
                                    return false;
                                }
                            };
                            table2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            table2.setModel(employeesTableModel);
                        }
                );
                panel2.add(button5);
                button5.setBounds(new Rectangle(new Point(150, 275), button5.getPreferredSize()));

                //---- button6 ----
                button6.setText("新增");
                button6.addActionListener(
                        e->{
                            employeesInsert employeesInsert = new employeesInsert();
                            employeesInsert.setVisible(true);
                        }
                );
                panel2.add(button6);
                button6.setBounds(new Rectangle(new Point(245, 275), button6.getPreferredSize()));

                //---- button7 ----
                button7.setText("删除");
                button7.addActionListener(
                        e->{
                            EmployeesDao employeesDao=new EmployeesDaoImpl();
                            int index1 = table2.getSelectedRow();//获取选中行
                            int id =(int)table2.getValueAt(index1, 0);//将Object转为int
                            employeesDao.delete(id);//删除选中行
                        }
                );
                panel2.add(button7);
                button7.setBounds(new Rectangle(new Point(340, 275), button7.getPreferredSize()));

                //---- button8 ----
                button8.setText("修改");
                button8.addActionListener(
                        e->{
                            int index1 = table2.getSelectedRow();//获取选中行
                            int id =(int)table2.getValueAt(index1,0);
                            String name= (String) table2.getValueAt(index1,1);
                            String department= (String) table2.getValueAt(index1,2);
                            String posts= (String) table2.getValueAt(index1,3);
                            int wages =(int)table2.getValueAt(index1, 4);
                            Employees employees = new Employees(id,name,department,posts,wages);
                            employeesUpdate employeesupdate = new employeesUpdate(employees);
                            employeesupdate.setVisible(true);
                        }
                );
                panel2.add(button8);
                button8.setBounds(new Rectangle(new Point(435, 275), button8.getPreferredSize()));

                //---- button14 ----
                button14.setText("刷新");
                button14.addActionListener(
                        e->{
                            String temp = null;
                            employeesTableModel = new DefaultTableModel(EmployeesTableModel.getDataFromDatabase(temp), heademp) {
                                public boolean isCellEditable(int row, int column) {
                                    return false;
                                }
                            };
                            table2.setModel(employeesTableModel);
                        }
                );
                panel2.add(button14);
                button14.setBounds(new Rectangle(new Point(530, 275), button14.getPreferredSize()));

            }
            if (user.getRank()!=3){
                tabbedPane4.addTab("员工管理", panel2);
            }

            //======== panel3 ========
            {
                panel3.setLayout(null);

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(table3);
                    String temp=null;
                    producttableModel = new DefaultTableModel(ProductTableModel.getDataFromDatabase(temp), head_product) {
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    table3.setModel(producttableModel);
                }
                panel3.add(scrollPane3);
                scrollPane3.setBounds(0, 0, 690, 265);
                panel3.add(textField3);
                textField3.setBounds(65, 275,60,25);

                //---- button9 ----
                button9.setText("查询");
                panel3.add(button9);
                button9.setBounds(new Rectangle(new Point(150, 275), button9.getPreferredSize()));
                button9.addActionListener(
                        e->{
                            String temp = textField2.getText();
                            ((DefaultTableModel)table3.getModel()).getDataVector().clear();//清空表格
                            producttableModel = new DefaultTableModel(ProductTableModel.getDataFromDatabase(temp),head_product) {
                                public boolean isCellEditable(int row, int column) {
                                    return false;
                                }
                            };
                            table2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            table2.setModel(producttableModel);
                        }
                );
                //---- button10 ----
                button10.setText("新增");
                panel3.add(button10);
                button10.setBounds(new Rectangle(new Point(245, 275), button10.getPreferredSize()));
                button10.setText("新增");
                panel3.add(button10);
                button10.setBounds(new Rectangle(new Point(245, 275), button10.getPreferredSize()));
                button10.addActionListener(
                        (e)->{
                            Product product=new Product();
                            ProductInsert in=new ProductInsert(product);
                            in.setVisible(true);
                        }
                );
                //---- button11 ----
                button11.setText("删除");
                panel3.add(button11);
                button11.setBounds(new Rectangle(new Point(340, 275), button11.getPreferredSize()));
                button11.addActionListener(
                        e->{
                            ProductDao productDao=new ProductDaoImpl();
                            int index1 = table2.getSelectedRow();//获取选中行
                            int id =(int)table2.getValueAt(index1, 0);
                            productDao.deletep(id);//删除选中行
                        }
                );
                //---- button12 ----
                button12.setText("修改");
                panel3.add(button12);
                button12.setBounds(new Rectangle(new Point(435, 275), button12.getPreferredSize()));
                button12.addActionListener(
                        e->{
                            try{
                                int rowNo=table3.getSelectedRow();
                                int id=(int)table3.getValueAt(rowNo, 0);
                                String name=(String)table3.getValueAt(rowNo,1);
                                float price=(float)table3.getValueAt(rowNo,2);
                                String comment=(String)table3.getValueAt(rowNo,3);

                                Product product=new Product(id,name,price,comment);

                                ProductUpdate up=new ProductUpdate(product);
                                up.setVisible(true);
                            }
                            catch(Exception E){
                                E.printStackTrace();
                            }
                        }
                );
                //---- button15 ----
                button15.setText("刷新");
                panel3.add(button15);
                button15.setBounds(new Rectangle(new Point(530, 275), button15.getPreferredSize()));
                button15.addActionListener(
                        e->{
                            String temp=null;
                            producttableModel = new DefaultTableModel(ProductTableModel.getDataFromDatabase(temp),head_product){
                                public boolean isCellEditable(int row, int column) {
                                return false;
                                }
                            };
                        }
                );
            }
            tabbedPane4.addTab("商品管理", panel3);

            //======== panel4 ========
            {
                panel4.setLayout(null);

                //======== scrollPane4 ========
                {
                    scrollPane4.setViewportView(table4);
                }
                panel4.add(scrollPane4);
                scrollPane4.setBounds(0, 0, 690, 265);

                //---- button16 ----
                button16.setText("\u5237\u65b0");
                panel4.add(button16);
                button16.setBounds(new Rectangle(new Point(300, 275), button16.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel4.getComponentCount(); i++) {
                        Rectangle bounds = panel4.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel4.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel4.setMinimumSize(preferredSize);
                    panel4.setPreferredSize(preferredSize);
                }
            }
            tabbedPane4.addTab("订单统计", panel4);
        }
        contentPane.add(tabbedPane4);
        tabbedPane4.setBounds(0, 0, 800, 350);//界面大小
        tabbedPane4.setTabPlacement(JTabbedPane.LEFT);

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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar2;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenu menu2;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JTabbedPane tabbedPane4;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JTextField select;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button13;
    private JPanel panel2;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JTextField textField2;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button14;
    private JPanel panel3;
    private JScrollPane scrollPane3;
    private JTable table3;
    private JTextField textField3;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button15;
    private JPanel panel4;
    private JScrollPane scrollPane4;
    private JTable table4;
    private JButton button16;
    private String head[] = {"ID","用户名", "用户密码", "级别"};
    private DefaultTableModel usertableModel;
    private String heademp[]={"ID","姓名","部门","职务","工资"};
    private DefaultTableModel employeesTableModel;
    private String head_product[]={"ID","商品名","价格","商品描述"};
    private DefaultTableModel producttableModel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new MainFrame();
    }
}
