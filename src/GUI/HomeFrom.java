/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import menu.MenuItem;
import GUI.*;
import utils.MsgBox;

/**
 *
 * @author User
 */
public class HomeFrom extends javax.swing.JFrame {

    /**
     * Creates new form HomeFrom
     */
    int index = 0;

    public HomeFrom() {
        initComponents();
       this.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
       panelBody.add(new PageForm());
        execute();
    }
      public static void loadfrom() {
        panelBody.removeAll();
        panelBody.add(new BanHangFromms());
        
    }
    private void execute() {
        ImageIcon iconHome = new ImageIcon("src\\menu\\home.png");
        ImageIcon iconBook = new ImageIcon("src\\menu\\book.png");
        ImageIcon iconPay = new ImageIcon("src\\menu\\pay.png");
        ImageIcon iconUser = new ImageIcon("src\\menu\\userr.png");
        ImageIcon iconClient = new ImageIcon("src\\menu\\khach.png");
        ImageIcon iconSubMenu = new ImageIcon("src\\menu\\subMenu.png");
        ImageIcon iconNext = new ImageIcon("src\\menu\\next.png");
        //Tạo Menu Quản Lý Sách
        MenuItem menuStaff1 = new MenuItem(iconSubMenu, "Sách và Chi Tiết Sách", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (utils.Auth.isLogin()) {
                    if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new CTS());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new CTS());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
                }else{
                   utils.MsgBox.alert(panelBody, "Mời bạn đăng nhập");
                }
                
            }
        });

        MenuItem menuStaff2 = new MenuItem(iconSubMenu, " Thể Loại", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (utils.Auth.isLogin()) {
                    if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new TheLoaiForm());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new TheLoaiForm());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
                }else{
                   utils.MsgBox.alert(panelBody, "Mời bạn đăng nhập");
                }
                
            }
        });
        MenuItem menuStaff3 = new MenuItem(iconSubMenu, "Tác Giả ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (utils.Auth.isLogin()) {
                    if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new TacGiaForm());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new TacGiaForm());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
                }else{
                   utils.MsgBox.alert(panelBody, "Mời bạn đăng nhập");
                }
                
            }
        });
        MenuItem menuStaff4 = new MenuItem(iconSubMenu, "Nhà Xuất Bản và Nhà Cung Cấp", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (utils.Auth.isLogin()) {
                    if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new NhaXBvsCC());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new NhaXBvsCC());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
                }else{
                   utils.MsgBox.alert(panelBody, "Mời bạn đăng nhập");
                }
                
            }
        });
        MenuItem menuNNDT = new MenuItem(iconSubMenu, "Ngôn Ngữ Và Độ Tuổi", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (utils.Auth.isLogin()) {
                    if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new NgonNguFrom());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new NgonNguFrom());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
                }else{
                   utils.MsgBox.alert(panelBody, "Mời bạn đăng nhập");
                }
                
            }
        });
        MenuItem menuHTLB = new MenuItem(iconSubMenu, "Hình Thức,Loại Bìa", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (utils.Auth.isLogin()) {
                    if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new HinhThucLoaiBia());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new HinhThucLoaiBia());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
                }else{
                   utils.MsgBox.alert(panelBody, "Mời bạn đăng nhập");
                }
                
            }
        });

        //Tạo Menu Giao Dịch
        MenuItem menuBanHang = new MenuItem(iconNext, "Bán Hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (utils.Auth.isLogin()) {
                    if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new BanHangFromms());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new BanHangFromms());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
                }else{
                   utils.MsgBox.alert(panelBody, "Mời bạn đăng nhập");
                }
                
            }
        });
        MenuItem menuNhanHang = new MenuItem(iconNext, "Nhập Hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (utils.Auth.isLogin()) {
                    if (index == 1) {

                } else {
                    index = 1;
                    MsgBox.alert(panelBody, "Hiện chức năng đang bảo trì!");
                }
                }else{
                   utils.MsgBox.alert(panelBody, "Mời bạn đăng nhập");
                }
                
            }
        });
        MenuItem menuDoanhThu = new MenuItem(iconNext, "Doanh Thu", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (utils.Auth.isLogin()) {
                    if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new ThongKe());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new ThongKe());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
                }else{
                   utils.MsgBox.alert(panelBody, "Mời bạn đăng nhập");
                }
                
            }
        });

        MenuItem menuHome = new MenuItem(iconHome, "Trang Chủ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (utils.Auth.isLogin()) {
                    if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new PageForm());
                    panelBody.repaint();
                    panelBody.revalidate();
                }else{
                    index =1;
                    panelBody.removeAll();
                    panelBody.add(new PageForm());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
                }else{
                   utils.MsgBox.alert(panelBody, "Mời bạn đăng nhập");
                }
                
            }
        });
          MenuItem menuQLHD = new MenuItem(iconNext, "QL Hóa Đơn", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (utils.Auth.isLogin()) {
                    if (index == 1) {
                  panelBody.removeAll();
                    panelBody.add(new QLHoaDon());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new QLHoaDon());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
                }else{
                   utils.MsgBox.alert(panelBody, "Mời bạn đăng nhập");
                }
                
            }
        });
        MenuItem menuQLSach = new MenuItem(iconBook, "Quản Lý Sách", null, menuStaff1, menuStaff2,menuStaff3, menuStaff4, menuNNDT,menuHTLB);
        MenuItem menuQLGD = new MenuItem(iconPay, "Quản Lý Giao Dịch", null, menuBanHang, menuNhanHang, menuDoanhThu,menuQLHD);
        MenuItem menuQLNV = new MenuItem(iconUser, "Quản Lý Nhân viên", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (utils.Auth.isLogin()) {
                    if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new NhanVienvsVaitro());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new NhanVienvsVaitro());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
                }else{
                   utils.MsgBox.alert(panelBody, "Mời bạn đăng nhập");
                }
                
            }
        });
        MenuItem menuQLKH = new MenuItem(iconClient, "Quản Lý Khách Hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (utils.Auth.isLogin()) {
                    if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new KhachHangForm1());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new KhachHangForm1());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
                }else{
                   utils.MsgBox.alert(panelBody, "Mời bạn đăng nhập");
                }
                
            }
        });
      

        addMenu(menuHome, menuQLSach, menuQLGD, menuQLNV, menuQLKH);
    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        panelBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cửa hàng bán sách");

        panelMenu.setBackground(new java.awt.Color(0, 51, 153));
        panelMenu.setPreferredSize(new java.awt.Dimension(250, 486));

        jScrollPane1.setBorder(null);

        menus.setBackground(new java.awt.Color(51, 102, 255));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(859, 575));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menus;
    public static javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables

}
