/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.*;
import DAO.NhaXuatBanDAO;
import DAO.SachDAO;
import Entity.CTSach;
import Entity.DoTuoi;
import Entity.HinhThuc;
import Entity.LoaiBia;
import Entity.NgonNgu;
import Entity.NhaCungCap;
import Entity.NhaXuatBan;
import Entity.Sach;
import Entity.TacGia;
import Entity.TacGiaChiTiet;
import Entity.TheLoai;
import Entity.TheLoaiSach;
import Entity.ViTri;
import java.awt.Color;
import java.awt.MouseInfo;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import utils.MsgBox;
import utils.XHeper;
import utils.XImage;

/**
 *
 * @author User
 */
public class CTS extends javax.swing.JPanel {

    /**
     * Creates new form CTS
     */
    SachDAO sD = new SachDAO();
    CTSachDAO CTSD = new CTSachDAO();
    TacGiaChiTietDAO tgctd = new TacGiaChiTietDAO();
    NhaXuatBanDAO NXBD = new NhaXuatBanDAO();
    TheLoaiDAO tlDao = new TheLoaiDAO();
    TacGiaDAO tgd = new TacGiaDAO();
    TheLoaiSachDAO tlsDao = new TheLoaiSachDAO();
    DoTuoiDAO dtDao = new DoTuoiDAO();
    LoaiBiaDAO lbDao = new LoaiBiaDAO();
    HinhThucDAO HTD = new HinhThucDAO();
    NhaCungCapDAO NCCD = new NhaCungCapDAO();
    ViTriDAO vtD = new ViTriDAO();
    List<ViTri> listVT = vtD.selecALL();
    NgonNguDAO NND = new NgonNguDAO();
    List<NgonNgu> listNN = NND.selecALL();
    List<HinhThuc> listHT = HTD.selecALL();
    List<DoTuoi> listDT = dtDao.selecALL();
    List<TheLoai> listTL = tlDao.selecALL();
    List<TheLoaiSach> listTLS = tlsDao.selecALL();
    List<Sach> listS = sD.selecALL();
    List<CTSach> list = CTSD.selecALL();
    List<LoaiBia> listLB = lbDao.selecALL();
    List<NhaXuatBan> listNXB = NXBD.selecALL();
    List<NhaCungCap> listNhaCungCap = NCCD.selecALL();
    int row = -1;
    String linKImg = "";
    List<TacGiaChiTiet> listtgct = tgctd.selecALL();
    List<TacGia> ListTG = tgd.selecALL();

    public CTS() {
        initComponents();
        LoadTBSach();
        LoadQLCTS();
        ComboBoxFoTuoi();
        ComboBoxHinhThuc();
        ComboBoxLB();
        ComboBoxMaS();
        ComboBoxNgonNgu();
        ComboBoxNhaCC();
        ComboBoxNhaXB();
        ComboBoxTheLoai();
        ComboBoxViTri();
    }

    void LoadTBSach() {
        listS = sD.selecALL();
        DefaultTableModel model = (DefaultTableModel) tblQlS.getModel();
        model.setRowCount(0);
        for (Sach s : listS) {
            model.addRow(new Object[]{s.getMaSach(), s.getTieuDe(), s.getTenNhaXB(), s.getTongSach(), s.isTrangThai() == 1 ? "Đang bán" : "Không còn bán"});
        }
    }

    void LoadQLCTS() {
        list = CTSD.selecALL();
        DefaultTableModel model = (DefaultTableModel) tblQLCTS.getModel();
        model.setRowCount(0);
        for (CTSach s : list) {
            model.addRow(new Object[]{s.getMaSach(), s.getGia(), s.getSl(), s.getMaHT(), s.getSoTrang(), s.getTenNhaCP(), s.getHinh(), s.getMaLB(), s.getMaDTuoi(), s.getMaNN(), s.getTrangThai() == 1 ? "Đang bán" : "Không còn bán"});
        }
    }

    void ComboBoxMaS() {
        listS = sD.selecALL();
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbMas.getModel();
        model.removeAllElements();
        for (Sach s : listS) {
            cbbMas.addItem(s.getMaSach());
        }
    }

    void ComboBoxNhaXB() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbNXB1.getModel();
        model.removeAllElements();
        for (NhaXuatBan NXB : listNXB) {
            cbbNXB1.addItem(NXB.getTenNhaXB());
        }
    }

    void ComboBoxTheLoai() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbTheLoai.getModel();
        model.removeAllElements();
        for (TheLoai tl : listTL) {
            cbbTheLoai.addItem(tl.getTenTL());
        }
    }

    void ComboBoxNhaCC() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbNcc.getModel();
        model.removeAllElements();
        for (NhaCungCap Ncc : listNhaCungCap) {
            cbbNcc.addItem(Ncc.getTenNhaCP());
        }
    }

    void ComboBoxFoTuoi() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbDoTuoi.getModel();
        model.removeAllElements();
        for (DoTuoi dt : listDT) {
            cbbDoTuoi.addItem(dt.getDoTuoi());
        }
    }

    void ComboBoxNgonNgu() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbNN.getModel();
        model.removeAllElements();
        for (NgonNgu nn : listNN) {
            cbbNN.addItem(nn.getLoaiNN());
        }
    }

    void ComboBoxLB() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbLoaiBia.getModel();
        model.removeAllElements();
        for (LoaiBia lb : listLB) {
            cbbLoaiBia.addItem(lb.getTenLB());
        }
    }

    void ComboBoxHinhThuc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbHinhThuc.getModel();
        model.removeAllElements();
        for (HinhThuc ht : listHT) {
            cbbHinhThuc.addItem(ht.getMaHT());
        }
    }

    void ComboBoxViTri() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbVT.getModel();
        model.removeAllElements();
        for (ViTri VT : listVT) {
            cbbVT.addItem(VT.getTenHang());
        }
    }

    void insertS() {
        Sach s = getFromSach();
        sD.insert(s);

    }

    void Updates() {
        Sach s = getFromSach();
        sD.update(s);

    }

    void Deletes() {
        Sach s = getFromSach();
        sD.deletems(s);
    }

    void insertctS() {
        CTSach s = getFromSCTSach();
        CTSD.insert(s);

    }

    void Updatects() {
        CTSach s = getFromSCTSach();
        CTSD.update(s);

    }

    void Deletects() {
        CTSach s = getFromSCTSach();
        CTSD.deletems(s);
    }

    Sach getFromSach() {
        Sach s = new Sach();
        s.setMaSach(txtMaS.getText());
        s.setTieuDe(txtTieuDe.getText());
        s.setTongSach(Integer.parseInt(txtSL.getText()));
        s.setTenNhaXB(cbbNXB1.getSelectedItem().toString());
        if (rdbDB.isSelected()) {
            s.setTrangThai(1);
        } else {
            s.setTrangThai(0);
        }
        return s;

    }

    void SetFromS(Sach s) {
        txtMaS.setText(s.getMaSach());
        txtTieuDe.setText(s.getTieuDe());
        cbbNXB1.setSelectedItem(s.getTenNhaXB());
        txtSL.setText(s.getTongSach() + "");
        if (s.isTrangThai() == 1) {
            rdbDB.setSelected(true);
        } else {
            rdbKB.setSelected(true);
        }
    }

    CTSach getFromSCTSach() {
        int roww = tblQLCTS.getSelectedRow();
        CTSach cts = new CTSach();
        cts.setMaCTS(list.get(row).getMaCTS());
        cts.setMaSach(cbbMas.getSelectedItem() + "");
        cts.setGia(Float.parseFloat(txtGia.getText()));
        cts.setSl(Integer.parseInt(txtSLS.getText()));
        cts.setHinh(linKImg);
        cts.setSoTrang(Integer.parseInt(txtSotra.getText()));
        cts.setMaHT(cbbHinhThuc.getSelectedItem() + "");
        cts.setTenNhaCP(cbbNcc.getSelectedItem() + "");
        int i = listLB.get(cbbLoaiBia.getSelectedIndex()).getMaLB();
        cts.setMaLB(i);
        cts.setMaDTuoi(cbbDoTuoi.getSelectedIndex() + 1);
        cts.setMaNN(listNN.get(cbbNN.getSelectedIndex()).getMaNN());

        cts.setTrangThai(rdbDban.isSelected() ? 1 : 0);

        return cts;

    }

    void SetFromCTS(CTSach cts) {
        txtGia.setText(cts.getGia() + "");
        txtSLS.setText(cts.getSl() + "");
        cbbMas.setSelectedItem(cts.getMaSach());
        cbbHinhThuc.setSelectedItem(cts.getMaHT());
        cbbNcc.setSelectedItem(cts.getTenNhaCP());
        txtSotra.setText(cts.getSoTrang() + "");
        for (DoTuoi doTuoi : listDT) {
            if (doTuoi.getMaDTuoi() == cts.getMaDTuoi()) {
                cbbDoTuoi.setSelectedIndex(listDT.indexOf(doTuoi));
                break;
            }
        }
        for (LoaiBia loaiBia : listLB) {
            if (loaiBia.getMaLB() == cts.getMaLB()) {
                cbbLoaiBia.setSelectedIndex(listLB.indexOf(loaiBia));
                break;
            }
        }
        for (NgonNgu ngonNgu : listNN) {
            if (ngonNgu.getMaNN().equals(cts.getMaNN())) {
                cbbNN.setSelectedIndex(listNN.indexOf(ngonNgu));
                break;
            }
        }
        for (TheLoaiSach theLoaiSach : listTLS) {
            if (theLoaiSach.getMaSach().equals(cts.getMaSach())) {
                for (TheLoai theLoai : listTL) {
                    if (theLoai.getMaTL() == theLoaiSach.getMaTL()) {
                        cbbTheLoai.setSelectedIndex(listTL.indexOf(theLoai));
                        break;
                    }
                }
            }
        }
        for (TheLoai theLoai : listTL) {
            if (theLoai.getMaTL() == theLoai.getMaTL()) {
                for (ViTri viTri : listVT) {
                    if (viTri.getMaVT() == viTri.getMaVT()) {
                        cbbVT.setSelectedIndex(listVT.indexOf(viTri));
                        break;
                    }
                }
            }

        }
        if (cts.getTrangThai() == 1) {
            rdbDban.setSelected(true);
        } else {
            rdbKoBan.setSelected(true);
        }
        if (cts.getHinh() != null) {
            lblHinh.setIcon(XImage.readLogo(cts.getHinh()));
            linKImg = cts.getHinh();
        }
    }

    void edit() {
        String mas = (String) tblQlS.getValueAt(row, 0);
        Sach s = sD.selectById(mas);
        this.SetFromS(s);
    }

    void selectImage() {
        try {
            JFileChooser jfc = new JFileChooser();
            // mặc định chỉ được chọn ảnh
            FileFilter imgFilter = new FileNameExtensionFilter("Image Only", ImageIO.getReaderFileSuffixes());
            jfc.setFileFilter(imgFilter);
            if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = jfc.getSelectedFile();
                XImage.saveLogo(file); // lưu hình vào thư mục logos
                ImageIcon icon = XImage.readLogo(file.getName());
                this.lblHinh.setIcon(icon);
                linKImg = file.getName();
                this.lblHinh.setToolTipText(file.getName()); // giữ tên hình trong tooltip
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Chọn ảnh thất bại");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQLCTS = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        cbbMas = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbbTheLoai = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbbNcc = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbbDoTuoi = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbbNN = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbbVT = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbbLoaiBia = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbbHinhThuc = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtSLS = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        rdbDban = new javax.swing.JRadioButton();
        rdbKoBan = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        txtSotra = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtMaS = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTieuDe = new javax.swing.JTextField();
        cbbNXB1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        rdbDB = new javax.swing.JRadioButton();
        rdbKB = new javax.swing.JRadioButton();
        btnThem1 = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQlS = new javax.swing.JTable();

        jPopupMenu1.setToolTipText("");

        jMenuItem1.setText("Xóa");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));

        jPanel8.setBackground(new java.awt.Color(51, 204, 255));

        tblQLCTS.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tblQLCTS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Giá", "Số lượng", "Mã hình thức", "Số trang", "Tên nhà cung cấp", "Hình", "Mã LB", "MãDTuoi", "MãNN", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQLCTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLCTSMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQLCTS);

        jPanel3.setBackground(new java.awt.Color(51, 204, 255));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        );

        cbbMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMasActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã Sách");

        jLabel3.setText("Thể Loại");

        cbbTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTheLoaiActionPerformed(evt);
            }
        });

        jLabel4.setText("Giá");

        txtGia.setName("giá"); // NOI18N

        jLabel5.setText("Nhà cung cấp");

        cbbNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNccActionPerformed(evt);
            }
        });

        jLabel7.setText("Độ tuổi");

        cbbDoTuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDoTuoiActionPerformed(evt);
            }
        });

        jLabel8.setText("Ngôn ngữ");

        jLabel1.setText("Vị Trí");

        cbbVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbVTActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel6.setText("Loại Bìa");

        jLabel14.setText("Hình Thức");

        jLabel15.setText("Số Lượng");

        txtSLS.setName("số lượng"); // NOI18N

        jLabel16.setText("Trạng thái");

        buttonGroup2.add(rdbDban);
        rdbDban.setSelected(true);
        rdbDban.setText("Đang bán");

        buttonGroup2.add(rdbKoBan);
        rdbKoBan.setText("Không còn bán");

        jLabel18.setText("Số trang");

        jLabel19.setText("Load");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtGia, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbbTheLoai, javax.swing.GroupLayout.Alignment.LEADING, 0, 227, Short.MAX_VALUE)
                        .addComponent(cbbMas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(cbbDoTuoi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNcc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(cbbLoaiBia, 0, 220, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(cbbHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbbNN, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbVT, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSLS))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(103, 103, 103)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThem))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(rdbDban)
                            .addGap(33, 33, 33)
                            .addComponent(rdbKoBan)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSotra, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(109, 109, 109))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbMas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbDoTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 16, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addComponent(cbbLoaiBia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(txtSLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel18)
                                        .addComponent(txtSotra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbbVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(1, 1, 1))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdbDban)
                                    .addComponent(rdbKoBan))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSua)
                                    .addComponent(btnThem))))
                        .addGap(23, 23, 23)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(51, 204, 255));

        jLabel10.setText("Mã Sách");

        jLabel2.setText("Tiêu Đề");

        txtTieuDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTieuDeActionPerformed(evt);
            }
        });

        jLabel11.setText("Tên Nhà Xuất Bản");

        jLabel12.setText("Số Lượng");

        jLabel13.setText("Trạng Thái");

        buttonGroup1.add(rdbDB);
        rdbDB.setSelected(true);
        rdbDB.setText("Đang bán");
        rdbDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbDBActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbKB);
        rdbKB.setText("Không Còn Bán");

        btnThem1.setText("Thêm");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnSua1.setText("Sửa");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        btnClean.setText("Mới");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Sách");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaS, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(txtSL))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(rdbDB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbKB))
                            .addComponent(cbbNXB1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(btnThem1)
                        .addGap(43, 43, 43)
                        .addComponent(btnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(364, 364, 364))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNXB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(btnSua1)
                    .addComponent(btnThem1)
                    .addComponent(btnClean))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(rdbDB)
                    .addComponent(rdbKB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblQlS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Tiêu Đề", "Tên Nhà xuất bản", "Số Lượng", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQlS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQlSMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblQlSMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblQlS);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbbMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMasActionPerformed

    }//GEN-LAST:event_cbbMasActionPerformed

    private void cbbNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNccActionPerformed

    private void cbbDoTuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDoTuoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbDoTuoiActionPerformed

    private void cbbVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbVTActionPerformed
//       cbbTheLoai.setSelectedItem(listTLS.get(listTL.lastIndexOf(cbbVT.getSelectedItem())));

    }//GEN-LAST:event_cbbVTActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (MsgBox.comfirm(this, "Bạn có chắc muốn sửa không?") == true) {
            if (utils.XHeper.checkNullText(txtGia) && XHeper.checkTien(txtGia) && utils.XHeper.checkNullText(txtSLS) && XHeper.checkNunBer(txtSLS) && utils.XHeper.checkNullText(txtSotra) && XHeper.checkNunBer(txtSotra)) {
                Updatects();
                LoadQLCTS();
            } else {
                MsgBox.alert(this, "loi");
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblQlSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQlSMouseClicked

        this.row = tblQlS.getSelectedRow();
        edit();
    }//GEN-LAST:event_tblQlSMouseClicked

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        if (MsgBox.comfirm(this, "Bạn muốn thêm sách không?") == true) {
            if (XHeper.checkNullText(txtMaS) && XHeper.checkS(txtMaS) && XHeper.checkNullText(txtTieuDe) && XHeper.checkNullText(txtSL) && XHeper.checkNunBer(txtSL)) {
                resetColorS();
                insertS();
                LoadTBSach();
            }
        }
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        if (MsgBox.comfirm(this, "Bạn có chắc muốn sửa không?") == true) {
            if (XHeper.checkNullText(txtMaS) && XHeper.checkS(txtMaS) && XHeper.checkNullText(txtTieuDe) && XHeper.checkNullText(txtSL) && XHeper.checkNunBer(txtSL)) {
                Updates();
                edit();
                LoadTBSach();
            }
        }
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        if (MsgBox.comfirm(this, "Bạn có muốn làm mới không?") == true) {
            Sach s = new Sach();
            this.SetFromS(s);
            this.row = -1;
        }
    }//GEN-LAST:event_btnCleanActionPerformed

    private void txtTieuDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTieuDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTieuDeActionPerformed

    private void tblQlSMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQlSMousePressed
        int m = MouseInfo.getPointerInfo().getLocation().x;
        int n = MouseInfo.getPointerInfo().getLocation().y;
        this.jPopupMenu1.show(this, m, n);
    }//GEN-LAST:event_tblQlSMousePressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Deletes();
        edit();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (MsgBox.comfirm(this, "Bạn có muốn thêm chi tiết sách không?") == true) {
            if (utils.XHeper.checkNullText(txtGia) && XHeper.checkTien(txtGia) && utils.XHeper.checkNullText(txtSLS) && XHeper.checkNunBer(txtSLS)) {
                insertctS();
                LoadQLCTS();
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        selectImage();
    }//GEN-LAST:event_lblHinhMouseClicked

    private void cbbTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTheLoaiActionPerformed

    }//GEN-LAST:event_cbbTheLoaiActionPerformed

    private void tblQLCTSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLCTSMouseClicked
        // TODO add your handling code here:
        this.row = tblQLCTS.getSelectedRow();
        int ma = list.get(row).getMaCTS();
        CTSach s = CTSD.selectById(ma);
        SetFromCTS(s);
    }//GEN-LAST:event_tblQLCTSMouseClicked

    private void rdbDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbDBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbDBActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        ComboBoxMaS();
    }//GEN-LAST:event_jLabel19MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbDoTuoi;
    private javax.swing.JComboBox<String> cbbHinhThuc;
    private javax.swing.JComboBox<String> cbbLoaiBia;
    private javax.swing.JComboBox<String> cbbMas;
    private javax.swing.JComboBox<String> cbbNN;
    private javax.swing.JComboBox<String> cbbNXB1;
    private javax.swing.JComboBox<String> cbbNcc;
    private javax.swing.JComboBox<String> cbbTheLoai;
    private javax.swing.JComboBox<String> cbbVT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JRadioButton rdbDB;
    private javax.swing.JRadioButton rdbDban;
    private javax.swing.JRadioButton rdbKB;
    private javax.swing.JRadioButton rdbKoBan;
    private javax.swing.JTable tblQLCTS;
    private javax.swing.JTable tblQlS;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaS;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtSLS;
    private javax.swing.JTextField txtSotra;
    private javax.swing.JTextField txtTieuDe;
    // End of variables declaration//GEN-END:variables

    private void resetColorS() {
        txtMaS.setBackground(Color.WHITE);
        txtTieuDe.setBackground(Color.WHITE);
        txtSL.setBackground(Color.WHITE);
    }
}
