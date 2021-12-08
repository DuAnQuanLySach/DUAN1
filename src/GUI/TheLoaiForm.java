/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DAO.SachDAO;
import DAO.TheLoaiDAO;
import DAO.TheLoaiSachDAO;
import Entity.Sach;
import Entity.TheLoai;
import Entity.TheLoaiSach;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import utils.MsgBox;
import utils.Validator;
import utils.XHeper;

/**
 *
 * @author ADMIN
 */
public class TheLoaiForm extends javax.swing.JPanel {

    /**
     * Creates new form TheLoaiForm
     */
    TheLoaiDAO daotl = new TheLoaiDAO();
    List<TheLoai> listtl = new ArrayList<>();
    TheLoaiSachDAO daotls = new TheLoaiSachDAO();
    SachDAO daosach = new SachDAO();
    List<TheLoaiSach> listtls = new ArrayList<>();
    List<Sach> lists;
    int row = -1;

    public TheLoaiForm() {
        initComponents();
        init();
    }

    private void init() {
        fillComboBox();
        fillTableTL();
        fillTableTLS();
        updateStatus();
    }

    private void showInforTL() {
        int MaTl = (Integer) tblTheLoai.getValueAt(this.row, 0);
        TheLoai tl = daotl.selectById(MaTl);
        this.setFormTL(tl);
    }

    private void setFormTL(TheLoai tl) {
        txtMaTL.setText(tl.getMaTL()+"");
        txtTenTL.setText(tl.getTenTL());
        txtMaVt.setText(tl.getMaVT());
        if (tl.getTrangThai() == 1) {
            rdbHDTL.setSelected(true);
        } else {
            rdbUnHDTL.setSelected(true);
        }
    }

    private TheLoai getFormTL() {
        TheLoai tl = new TheLoai();
        tl.setMaTL(Integer.parseInt(txtMaTL.getText()));
        tl.setTenTL(txtTenTL.getText());
        tl.setMaVT(txtMaVt.getText());
        if (rdbHDTL.isSelected()) {
            tl.setTrangThai(1);
        } else {
            tl.setTrangThai(0);
        }
        return tl;
    }

    private void setFormTLS(TheLoaiSach tls) {
        Sach sach = daosach.selectById(tls.getMaSach());
        txtMaTLS.setText(tls.getMaTLS());
        if (tls.getTrangThai() == 1) {
            rdbHDTLS.setSelected(true);
        } else {
            rdbUnHDTLS.setSelected(true);
        }
    }

    private TheLoaiSach getFormTLs() {
        TheLoaiSach tls = new TheLoaiSach();
        String mas = (String) cbbMaS.getSelectedItem();
        tls.setMaTLS(txtMaTLS.getText());
        tls.setMaTL(Integer.parseInt(txtMaTL.getText()));
        tls.setMaSach(mas);
        tls.setTenTL(txtTenTL.getText());
        if (rdbHDTLS.isSelected()) {
            tls.setTrangThai(1);
        } else {
            tls.setTrangThai(0);
        }
        return tls;
    }

    private void showInforTLS() {
        String MaTlS = (String) tblTheLoaiSach.getValueAt(this.row, 0);
        TheLoaiSach tls = daotls.selectById(MaTlS);
        this.setFormTLS(tls);
    }

    private void updateStatus() {
        boolean edit = (row >= 0);
        // Trạng thái form Tác Giả
        this.txtMaTL.setEditable(!edit);
        this.txtTenTL.setEditable(!edit);
        this.txtMaVt.setEditable(!edit);
        this.btnInsertTL.setEnabled(!edit);
        this.btnUpdateTL.setEnabled(edit);
        this.btnCleanTL.setEnabled(edit);
        //Trạng thái form Tác Giả
        this.txtMaTLS.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTheLoai = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        rdbUnHDTL = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTheLoaiSach = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaTLS = new javax.swing.JTextField();
        cbbMaS = new javax.swing.JComboBox<>();
        txtMaTL = new javax.swing.JTextField();
        txtTenTL = new javax.swing.JTextField();
        rdbHDTL = new javax.swing.JRadioButton();
        btnUpdateTL = new javax.swing.JButton();
        btnInsertTL = new javax.swing.JButton();
        btnInsertTLS = new javax.swing.JButton();
        btnUpdateTLS = new javax.swing.JButton();
        btnCleanTL = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        rdbHDTLS = new javax.swing.JRadioButton();
        rdbUnHDTLS = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtMaVt = new javax.swing.JTextField();
        btnSelectAll = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jLabel1.setText("Mã Thể Loại");

        jLabel2.setText("Tên Thể Loại");

        tblTheLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Thể Loại", "Tên Thể Loại", "Mã Vị Trí", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTheLoai.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTheLoaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTheLoai);

        jLabel3.setText("Trạng Thái");

        buttonGroup1.add(rdbUnHDTL);
        rdbUnHDTL.setText("Đang Ẩn");

        tblTheLoaiSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MaTLS", "Mã Thể Loại", "Mã Sách", "Tên Thể Loại", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTheLoaiSach.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTheLoaiSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTheLoaiSachMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblTheLoaiSach);

        jLabel10.setText("Mã TLS");

        jLabel9.setText("Mã Sách");

        txtMaTLS.setName("mã thể loại sách"); // NOI18N

        cbbMaS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMaSItemStateChanged(evt);
            }
        });
        cbbMaS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaSActionPerformed(evt);
            }
        });

        txtMaTL.setName("mã thể loại"); // NOI18N

        txtTenTL.setName("tên thể loại"); // NOI18N

        buttonGroup1.add(rdbHDTL);
        rdbHDTL.setSelected(true);
        rdbHDTL.setText("Đang Hoạt Động");

        btnUpdateTL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Save as.png"))); // NOI18N
        btnUpdateTL.setText("Sửa");
        btnUpdateTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTLActionPerformed(evt);
            }
        });

        btnInsertTL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btnInsertTL.setText("Thêm");
        btnInsertTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertTLActionPerformed(evt);
            }
        });

        btnInsertTLS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btnInsertTLS.setText("Thêm");
        btnInsertTLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertTLSActionPerformed(evt);
            }
        });

        btnUpdateTLS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Save as.png"))); // NOI18N
        btnUpdateTLS.setText("Sửa");
        btnUpdateTLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTLSActionPerformed(evt);
            }
        });

        btnCleanTL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Document.png"))); // NOI18N
        btnCleanTL.setText("Mới");
        btnCleanTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanTLActionPerformed(evt);
            }
        });

        jLabel4.setText("Trạng Thái");

        buttonGroup2.add(rdbHDTLS);
        rdbHDTLS.setSelected(true);
        rdbHDTLS.setText("Đang Hoạt Động");

        buttonGroup2.add(rdbUnHDTLS);
        rdbUnHDTLS.setText("Đang Ẩn");

        jLabel5.setText("Mã Vị Trí");

        txtMaVt.setName("mã vị trí"); // NOI18N

        btnSelectAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Lists.png"))); // NOI18N
        btnSelectAll.setText("Hiện Thị Tất Cả");
        btnSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectAllActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Thể Loại");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Thể Loại Sách");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaTL, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaVt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenTL, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdbHDTL)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdbUnHDTL)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInsertTL, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCleanTL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdateTL)
                            .addComponent(btnSelectAll))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMaTLS, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdbHDTLS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbUnHDTLS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInsertTLS)
                            .addComponent(btnUpdateTLS, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71))))
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane4)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtMaVt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenTL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdateTL)
                            .addComponent(btnInsertTL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCleanTL)
                            .addComponent(btnSelectAll))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbHDTL)
                        .addComponent(rdbUnHDTL)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbHDTLS)
                        .addComponent(rdbUnHDTLS)
                        .addComponent(jLabel4)
                        .addComponent(btnInsertTLS))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(cbbMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaTLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateTLS))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTheLoaiMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblTheLoai.getSelectedRow();
            this.showInforTL();
            this.updateStatus();
            resetColorTL();
        }
    }//GEN-LAST:event_tblTheLoaiMouseClicked

    private void btnCleanTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanTLActionPerformed
        if (MsgBox.comfirm(this, "Bạn có muốn làm mới form?")) {
            resetColorTL();
            clearFrom();
            txtMaTL.requestFocus();
        }
    }//GEN-LAST:event_btnCleanTLActionPerformed

    private void btnInsertTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertTLActionPerformed
        if (MsgBox.comfirm(this, "Bạn muốn thêm thể loại không?")) {
            resetColorTL();
            if (XHeper.checkNullText(txtMaTL) && XHeper.checkNullText(txtTenTL) && XHeper.checkNullText(txtMaVt)) {
                insert();
            }
        }
    }//GEN-LAST:event_btnInsertTLActionPerformed

    private void btnUpdateTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTLActionPerformed
        if (MsgBox.comfirm(this, "Bạn chắc chắn muốn sửa không?")) {
            if (XHeper.checkNullText(txtMaTL) && XHeper.checkNullText(txtTenTL) && XHeper.checkNullText(txtMaVt)) {
                update();
            }
        }
    }//GEN-LAST:event_btnUpdateTLActionPerformed

    private void tblTheLoaiSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTheLoaiSachMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblTheLoaiSach.getSelectedRow();
            this.showInforTLS();
            this.updateStatus();
            txtMaTLS.setBackground(Color.white);
        }
    }//GEN-LAST:event_tblTheLoaiSachMouseClicked

    private void cbbMaSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMaSItemStateChanged
        fillTableTLS();
    }//GEN-LAST:event_cbbMaSItemStateChanged

    private void cbbMaSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaSActionPerformed

    }//GEN-LAST:event_cbbMaSActionPerformed

    private void btnInsertTLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertTLSActionPerformed
        if (MsgBox.comfirm(this, "Bạn muốn thêm thể loại sách không?")) {
            txtMaTLS.setBackground(Color.white);
            if (XHeper.checkNullText(txtMaTLS)) {
                insertTLS();
            }
        }
    }//GEN-LAST:event_btnInsertTLSActionPerformed

    private void btnUpdateTLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTLSActionPerformed
        if (MsgBox.comfirm(this, "Bạn có chắc muốn sửa không?")) {
            updateTLS();
        }
    }//GEN-LAST:event_btnUpdateTLSActionPerformed

    private void btnSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectAllActionPerformed
        if (MsgBox.comfirm(this, "Bạn muốn hiển thị tất cả thể loại không?")) {
            DefaultTableModel model = (DefaultTableModel) tblTheLoai.getModel();
            model.setRowCount(0); // xoá tất cả các hàng trên Table
            try {
                this.listtl = daotl.selecALLL(); // đọc dữ liệu từ CSDL
                for (TheLoai tl : listtl) {
                    // thêm một hàng vào table
                    model.addRow(new Object[]{tl.getMaTL(), tl.getTenTL(), tl.getMaVT(), tl.getTrangThai() == 1 ? "Đang hoạt động" : "Đang Ẩn"});
                }
            } catch (Exception e) {
                MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSelectAllActionPerformed

    void clearFrom() {
        TheLoai tl = new TheLoai();
        this.setFormTL(tl);
        this.row = -1;
        updateStatus();
    }

    private void insert() {
        StringBuilder sb = new StringBuilder();
        if (!Validator.isNull(txtMaTL, "Mã người dạy chưa nhập", sb)) {
            for (TheLoai theloai : listtl) {
                if (!Validator.checkId(txtMaTL, theloai.getMaTL()+"", sb, "Mã thể loại " + txtMaTL.getText() + " đã tồn tại")) {
                    break;
                }
            }
        }
        Validator.isNull(txtTenTL, "Chưa nhập tên thể loại!", sb);
        Validator.isNull(txtMaVt, "Chưa nhập mã vị trí!", sb);
        if (sb.length() > 0) {
            MsgBox.alert(this, sb.toString());
        } else {
            TheLoai tl = getFormTL();
            try {
                daotl.insert(tl);
                this.fillTableTL();
                this.clearFrom();
                tblTheLoai.setRowSelectionInterval(tblTheLoai.getRowCount() - 1, tblTheLoai.getRowCount() - 1);
                MsgBox.alert(this, "Thêm thành công" + tl.getMaTL());
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm thất bại");
                e.printStackTrace();
            }
        }
    }

//    private void delete() {
//        if (MsgBox.comfirm(this, "Bạn thực sự muốn xóa " + txtMaTL.getText() + "?")) {
//            try {
//                daotl.delete(txtMaTL.getText());
//                fillTableTL();
//                clearFrom();
//                MsgBox.alert(this, "Xóa Thành Công");
//            } catch (Exception e) {
//                MsgBox.alert(this, "Xóa Thất Bại!");
//            }
//        }
//    }

    private void update() {
        StringBuilder sb = new StringBuilder();
        Validator.isNull(txtTenTL, "Chưa nhập tên thể loại!", sb);
        Validator.isNull(txtMaVt, "Chưa nhập vị trí!", sb);
        if (sb.length() > 0) {
            MsgBox.alert(this, sb.toString());
        } else {
            TheLoai tl = getFormTL();
            try {
                daotl.update(tl);
                fillTableTL();
                tblTheLoai.setRowSelectionInterval(row, row);
                MsgBox.alert(this, "Cập nhật thành công");
            } catch (Exception e) {
                MsgBox.alert(this, "Cập nhật thất bại");
            }
        }
    }

    private void insertTLS() {
        try {
            TheLoaiSach tls = getFormTLs();
            daotls.insert(tls);
            this.fillTableTLS();
            tblTheLoaiSach.setRowSelectionInterval(tblTheLoaiSach.getRowCount() - 1, tblTheLoaiSach.getRowCount() - 1);
            MsgBox.alert(this, "Thêm thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm thất bại");
            e.printStackTrace();
        }
    }

    private void updateTLS() {
        try {
            TheLoaiSach tls = getFormTLs();
            daotls.update(tls);
            fillTableTLS();
            tblTheLoaiSach.setRowSelectionInterval(tblTheLoaiSach.getRowCount() - 1, tblTheLoaiSach.getRowCount() - 1);
            MsgBox.alert(this, "Sửa thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Sửa thất bại");
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCleanTL;
    private javax.swing.JButton btnInsertTL;
    private javax.swing.JButton btnInsertTLS;
    private javax.swing.JButton btnSelectAll;
    private javax.swing.JButton btnUpdateTL;
    private javax.swing.JButton btnUpdateTLS;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbMaS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton rdbHDTL;
    private javax.swing.JRadioButton rdbHDTLS;
    private javax.swing.JRadioButton rdbUnHDTL;
    private javax.swing.JRadioButton rdbUnHDTLS;
    private javax.swing.JTable tblTheLoai;
    private javax.swing.JTable tblTheLoaiSach;
    private javax.swing.JTextField txtMaTL;
    private javax.swing.JTextField txtMaTLS;
    private javax.swing.JTextField txtMaVt;
    private javax.swing.JTextField txtTenTL;
    // End of variables declaration//GEN-END:variables

    private void fillTableTL() {
        DefaultTableModel tableModel = (DefaultTableModel) tblTheLoai.getModel();
        tableModel.setRowCount(0);
        try {
            listtl = daotl.selecALL();
            listtl.stream().forEach((tl) -> {
                tableModel.addRow(new Object[]{
                    tl.getMaTL(), tl.getTenTL(), tl.getMaVT(), tl.getTrangThai() == 1 ? "Đang hoạt động" : "Đang Ẩn"
                });
            });
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn");
        }
    }

    private void fillTableTLS() {
        DefaultTableModel mode = (DefaultTableModel) tblTheLoaiSach.getModel();
        mode.setRowCount(0);
        try {
            String sa = (String) cbbMaS.getSelectedItem();
            listtls = daotls.selectbySach(sa);
            for (TheLoaiSach tls : listtls) {
                mode.addRow(new Object[]{
                    tls.getMaTLS(),
                    tls.getMaTL(),
                    tls.getMaSach(),
                    tls.getTenTL(),
                    tls.getTrangThai() == 1 ? "Đang hoạt động" : "Đang Ẩn"
                });
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn");
            e.printStackTrace();
        }
    }

    private void fillComboBox() {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbMaS.getModel();
        cbbModel.removeAllElements();
        lists = daosach.selecALL();
        for (Sach sa : lists) {
            cbbMaS.addItem(sa.getMaSach());
        }
    }

    private void resetColorTL() {
        txtMaTL.setBackground(Color.WHITE);
        txtTenTL.setBackground(Color.WHITE);
        txtMaVt.setBackground(Color.WHITE);
    }
}
