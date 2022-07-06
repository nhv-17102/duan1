package com.thucung.ui.form;

import com.thucung.dao.DAOHuyen;
import com.thucung.dao.DAONhaCungCap;
import com.thucung.dao.DAOThanhPho;
import com.thucung.dao.DAOXa_Phuong;
import com.thucung.models.Huyen;
import com.thucung.models.NhaCungCap;
import com.thucung.models.ThanhPho;
import com.thucung.models.Xa_Phuong;
import com.thucung.util.DateUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class NhaCungCapForm extends javax.swing.JPanel {

    DAONhaCungCap daoNhaCungCap = new DAONhaCungCap();
    DAOThanhPho daoThanhPho = new DAOThanhPho();
    DAOHuyen daoHuyen = new DAOHuyen();
    DAOXa_Phuong daoXa = new DAOXa_Phuong();
    List<NhaCungCap> dsNhaCungCap, dsNhaCungCapDuocTimThay;
    List<ThanhPho> dsThanhPho;
    List<Huyen> dsHuyen;
    List<Xa_Phuong> dsXa;
    ThanhPho tpDuocChon;
    Huyen huyenDuocChon;
    int dongDuocChon;
    String[] diaChi = new String[]{"xa", "huyen", "thanh pho"};
    boolean dangTimKiem = false;

    public NhaCungCapForm() {
        initComponents();
        setOpaque(false);
        layDuLieuCboThanhPho();
        dsNhaCungCap = daoNhaCungCap.selectAll();
        capNhatBangNhaCungCap();
    }

    public void layDuLieuCboThanhPho() {
        cboThanhPho.removeAllItems();
        dsThanhPho = daoThanhPho.selectAll();
        for (ThanhPho tp : dsThanhPho) {
            cboThanhPho.addItem(tp.getTenThanhPho());
        }
    }

    void capNhatBangNhaCungCap() {
        DefaultTableModel model = (DefaultTableModel) tblNhacungcap.getModel();
        model.setRowCount(0);
        for (NhaCungCap ncc : (dangTimKiem ? dsNhaCungCapDuocTimThay : dsNhaCungCap)) {
            Object row[] = {
                ncc.getIdNhaCungCap(),
                ncc.getTenNhaCungCap(),
                ncc.getTrangThai(),
                DateUtil.changeUStoVN(ncc.getNgayHopTac())

            };
            model.addRow(row);
        }
    }

    void resetGiaoDien() {
        txtManhacungcap.setText(null);
        txtTennhacungcap.setText(null);
        txtSodienthoai.setText(null);
        txtNgayhoptac.setText(null);
        txtDiachi.setText(null);
        txtTimkiem.setText(null);
        layDuLieuCboThanhPho();
        dsNhaCungCap = daoNhaCungCap.selectAll();
        dangTimKiem = false;
        capNhatBangNhaCungCap();
    }

    private boolean formHopLe() {
        ArrayList<String> thongBaoLoi = new ArrayList<>(3);
        kiemTraTxtTen(thongBaoLoi);
        kiemTraTxtSDT(thongBaoLoi);
        kiemTraNgayHopTac(thongBaoLoi);
        if (thongBaoLoi.size() > 0) {
            JOptionPane.showMessageDialog(this, String.join("\n", thongBaoLoi));
            return false;
        }
        return true;
    }

    private void kiemTraTxtTen(ArrayList<String> thongBaoLoi) {
        if (txtTennhacungcap.getText().length() == 0) {
            thongBaoLoi.add("Không được để trống Tên nhà cung cấp");
        } else if (!txtTennhacungcap.getText().matches("^[\\p{L}\\s]+$")) { //tên chỉ gồm các ký tự unicode kể cả ầ, ớ,... và khoảng trắng
            thongBaoLoi.add("Tên nhà cung cấp chỉ bao gồm chữ cái");
        }
    }

    private void kiemTraTxtSDT(ArrayList<String> thongBaoLoi) {
        if (txtSodienthoai.getText().length() != 10) {
            thongBaoLoi.add("Số điện thoại phải đủ 10 số");
        } else if (!txtSodienthoai.getText().matches("^\\d{10}$")) { //SDT gồm 10 ký tự số
            thongBaoLoi.add("Số điện thoại chỉ bao gồm chữ số");
        }
    }

    private void kiemTraNgayHopTac(ArrayList<String> thongBaoLoi) {
        if (!txtNgayhoptac.getText().matches("^\\d{1,2}-\\d{1,2}-\\d{4}$")) { // 2 ký tự ngày, dấu -, 2 ký tự tháng, dấu -, 4 ký tự năm
            thongBaoLoi.add("Định đạng Ngày không hợp lệ: DD-MM-YYYY");
        } else if (!DateUtil.checkDateVN(txtNgayhoptac.getText())) { //ngày thật sự tồn tại, cân nhắc đến năm nhuận, số ngày trong tháng,...
            thongBaoLoi.add("Ngày không hợp lệ");
        }
    }

    void capNhatTruongThongTin() {
        tblNhacungcap.changeSelection(dongDuocChon, 0, false, false);
        NhaCungCap nhaCungCapDaChon = dangTimKiem ? dsNhaCungCapDuocTimThay.get(dongDuocChon) : dsNhaCungCap.get(dongDuocChon);

        txtManhacungcap.setText(nhaCungCapDaChon.getIdNhaCungCap() + "");
        txtTennhacungcap.setText(nhaCungCapDaChon.getTenNhaCungCap());
        txtSodienthoai.setText(nhaCungCapDaChon.getSoDienThoai());
        txtNgayhoptac.setText(DateUtil.changeUStoVN(nhaCungCapDaChon.getNgayHopTac()));
        txtDiachi.setText(nhaCungCapDaChon.getDiaChi());
    }

    NhaCungCap layThongTinTuForm() {
        NhaCungCap ncc = new NhaCungCap();
        ncc.setIdNhaCungCap(Integer.parseInt(txtManhacungcap.getText()));
        ncc.setDiaChi(txtDiachi.getText());
        ncc.setNgayHopTac(DateUtil.changeVNtoUS(txtNgayhoptac.getText()));
        ncc.setSoDienThoai(txtSodienthoai.getText());
        ncc.setTenNhaCungCap(txtTennhacungcap.getText());
        ncc.setTrangThai(1);
        return ncc;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.girlkun.panel.RoundPanel();
        lbllMaNhaCungCap = new javax.swing.JLabel();
        txtManhacungcap = new javax.swing.JTextField();
        lbllTennhacungcap = new javax.swing.JLabel();
        txtTennhacungcap = new javax.swing.JTextField();
        lbllSodienthoai = new javax.swing.JLabel();
        txtSodienthoai = new javax.swing.JTextField();
        lbllDiachi = new javax.swing.JLabel();
        txtDiachi = new javax.swing.JTextField();
        lbllNgayhoptac = new javax.swing.JLabel();
        txtNgayhoptac = new javax.swing.JTextField();
        jPanelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhacungcap = new javax.swing.JTable();
        BTNFirst = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btlThem = new javax.swing.JButton();
        btlSua = new javax.swing.JButton();
        btlXoa = new javax.swing.JButton();
        txtTimkiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        cboThanhPho = new javax.swing.JComboBox<>();
        cboQuanHuyen = new javax.swing.JComboBox<>();
        cboXaPhuong = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        roundPanel1.setBackground(new java.awt.Color(65, 65, 65));

        lbllMaNhaCungCap.setBackground(new java.awt.Color(255, 255, 255));
        lbllMaNhaCungCap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbllMaNhaCungCap.setForeground(new java.awt.Color(255, 255, 255));
        lbllMaNhaCungCap.setText("Mã nhà cung cấp");
        lbllMaNhaCungCap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 25, 225)));

        txtManhacungcap.setEditable(false);
        txtManhacungcap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtManhacungcap.setForeground(new java.awt.Color(51, 51, 51));
        txtManhacungcap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 25, 225)));
        txtManhacungcap.setCaretColor(new java.awt.Color(102, 153, 255));
        txtManhacungcap.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtManhacungcap.setOpaque(false);

        lbllTennhacungcap.setBackground(new java.awt.Color(255, 255, 255));
        lbllTennhacungcap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbllTennhacungcap.setForeground(new java.awt.Color(255, 255, 255));
        lbllTennhacungcap.setText("Tên nhà cung cấp");
        lbllTennhacungcap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 25, 225)));

        txtTennhacungcap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTennhacungcap.setForeground(new java.awt.Color(51, 51, 51));
        txtTennhacungcap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 25, 225)));
        txtTennhacungcap.setCaretColor(new java.awt.Color(102, 153, 255));
        txtTennhacungcap.setOpaque(false);

        lbllSodienthoai.setBackground(new java.awt.Color(255, 255, 255));
        lbllSodienthoai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbllSodienthoai.setForeground(new java.awt.Color(255, 255, 255));
        lbllSodienthoai.setText("Số điện thoại");
        lbllSodienthoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 25, 225)));

        txtSodienthoai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSodienthoai.setForeground(new java.awt.Color(51, 51, 51));
        txtSodienthoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 25, 225)));
        txtSodienthoai.setCaretColor(new java.awt.Color(102, 153, 255));
        txtSodienthoai.setOpaque(false);

        lbllDiachi.setBackground(new java.awt.Color(255, 255, 255));
        lbllDiachi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbllDiachi.setForeground(new java.awt.Color(255, 255, 255));
        lbllDiachi.setText("Địa Chỉ ");
        lbllDiachi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 25, 225)));

        txtDiachi.setEditable(false);
        txtDiachi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDiachi.setForeground(new java.awt.Color(51, 51, 51));
        txtDiachi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 25, 225)));
        txtDiachi.setCaretColor(new java.awt.Color(102, 153, 255));
        txtDiachi.setOpaque(false);

        lbllNgayhoptac.setBackground(new java.awt.Color(255, 255, 255));
        lbllNgayhoptac.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbllNgayhoptac.setForeground(new java.awt.Color(255, 255, 255));
        lbllNgayhoptac.setText("Ngày hợp tác");
        lbllNgayhoptac.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 25, 225)));

        txtNgayhoptac.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNgayhoptac.setForeground(new java.awt.Color(51, 51, 51));
        txtNgayhoptac.setToolTipText("dd-MM-yyyy");
        txtNgayhoptac.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(75, 25, 225)));
        txtNgayhoptac.setCaretColor(new java.awt.Color(102, 153, 255));
        txtNgayhoptac.setOpaque(false);

        jPanelTable.setOpaque(false);

        tblNhacungcap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblNhacungcap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID NCC", "Tên NCC", "Trạng Thái", "Ngày Hợp Tác"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhacungcap.setRowHeight(27);
        tblNhacungcap.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblNhacungcap.getTableHeader().setReorderingAllowed(false);
        tblNhacungcap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhacungcapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhacungcap);
        if (tblNhacungcap.getColumnModel().getColumnCount() > 0) {
            tblNhacungcap.getColumnModel().getColumn(0).setResizable(false);
            tblNhacungcap.getColumnModel().getColumn(1).setResizable(false);
            tblNhacungcap.getColumnModel().getColumn(2).setResizable(false);
        }

        BTNFirst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BTNFirst.setText("|<");
        BTNFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNFirstActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setText("<<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTableLayout = new javax.swing.GroupLayout(jPanelTable);
        jPanelTable.setLayout(jPanelTableLayout);
        jPanelTableLayout.setHorizontalGroup(
            jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTableLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTNFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210))
        );
        jPanelTableLayout.setVerticalGroup(
            jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );

        btlThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btlThem.setText("Thêm");
        btlThem.setOpaque(false);
        btlThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlThemActionPerformed(evt);
            }
        });

        btlSua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btlSua.setText("Sửa");
        btlSua.setOpaque(false);
        btlSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlSuaActionPerformed(evt);
            }
        });

        btlXoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btlXoa.setText("Xóa");
        btlXoa.setOpaque(false);
        btlXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlXoaActionPerformed(evt);
            }
        });

        txtTimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimkiemKeyPressed(evt);
            }
        });

        btnTimkiem.setText("Tìm Kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        cboThanhPho.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThanhPhoItemStateChanged(evt);
            }
        });
        cboThanhPho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThanhPhoActionPerformed(evt);
            }
        });

        cboQuanHuyen.setModel(new javax.swing.DefaultComboBoxModel<>());
        cboQuanHuyen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboQuanHuyenItemStateChanged(evt);
            }
        });

        cboXaPhuong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboXaPhuongItemStateChanged(evt);
            }
        });

        btnReset.setText("RESET BẢNG");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quản Lý Nhà Cung Cấp");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(lbllSodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(lbllMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtManhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(lbllTennhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTennhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(lbllNgayhoptac, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNgayhoptac, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(lbllDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(cboThanhPho, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cboQuanHuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addGap(0, 5, Short.MAX_VALUE)
                                        .addComponent(btlThem, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btlSua, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboXaPhuong, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btlXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        roundPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btlSua, btlThem, btlXoa, cboQuanHuyen, cboThanhPho, cboXaPhuong});

        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbllMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtManhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbllTennhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTennhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbllSodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayhoptac, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbllNgayhoptac, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbllDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboThanhPho, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboQuanHuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboXaPhuong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btlXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btlSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btlThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiem)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btlSua, btlThem, btlXoa, cboQuanHuyen, cboThanhPho, cboXaPhuong});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void btlThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlThemActionPerformed
        if (formHopLe()) {
            if (daoNhaCungCap.insertx(layThongTinTuForm())) {
                JOptionPane.showMessageDialog(this, "Thêm Thành Công!!!");
                resetGiaoDien();
                dongDuocChon = tblNhacungcap.getRowCount() - 1;
                capNhatTruongThongTin();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm KHÔNG Thành Công!!!");
            }
        }
    }//GEN-LAST:event_btlThemActionPerformed

    private void btlXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlXoaActionPerformed
        NhaCungCap nhaCungCapDaChon = daoNhaCungCap.selectAll().get(tblNhacungcap.getSelectedRow());
        if (daoNhaCungCap.deletex(nhaCungCapDaChon.getIdNhaCungCap())) {
            JOptionPane.showMessageDialog(this, "Xóa Thành Công !!!");
            resetGiaoDien();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa Không Thành Công !!!");
        }
    }//GEN-LAST:event_btlXoaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetGiaoDien();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btlSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlSuaActionPerformed
        if (formHopLe()) {
            if (daoNhaCungCap.updatex(layThongTinTuForm())) {
                JOptionPane.showMessageDialog(this, "Sửa Thành Công !!!");
                resetGiaoDien();
                capNhatTruongThongTin();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa Không Thành Công !!!");
            }
        }
    }//GEN-LAST:event_btlSuaActionPerformed


    private void tblNhacungcapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhacungcapMouseClicked
        dongDuocChon = tblNhacungcap.getSelectedRow();
        capNhatTruongThongTin();
    }//GEN-LAST:event_tblNhacungcapMouseClicked

    private void cboThanhPhoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThanhPhoItemStateChanged
        if (cboThanhPho.getSelectedIndex() != -1) {
            tpDuocChon = dsThanhPho.get(cboThanhPho.getSelectedIndex());
            diaChi[2] = tpDuocChon.getTenThanhPho();
            diaChi[0] = diaChi[1] = "";
            txtDiachi.setText(Arrays.stream(diaChi).filter(e -> !e.isEmpty()).collect(Collectors.joining(", ")));
            dsHuyen = daoHuyen.selectByThanhPho(tpDuocChon.getIdThanhPho());
            cboQuanHuyen.removeAllItems();
            cboXaPhuong.removeAllItems();
            for (Huyen huyen : dsHuyen) {
                cboQuanHuyen.addItem(huyen.getTenHuyen());
            }
        }
    }//GEN-LAST:event_cboThanhPhoItemStateChanged

    private void cboQuanHuyenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboQuanHuyenItemStateChanged
        if (cboQuanHuyen.getSelectedIndex() != -1) {
            cboXaPhuong.removeAllItems();
            huyenDuocChon = dsHuyen.get(cboQuanHuyen.getSelectedIndex());
            diaChi[1] = huyenDuocChon.getTenHuyen();
            diaChi[0] = "";
            txtDiachi.setText(Arrays.stream(diaChi).filter(e -> !e.isEmpty()).collect(Collectors.joining(", ")));

            dsXa = daoXa.selectByHuyenThanhPho(huyenDuocChon.getIdHuyen(), tpDuocChon.getIdThanhPho());

            for (Xa_Phuong xa : dsXa) {
                cboXaPhuong.addItem(xa.getTenXa_Phuong());
            }
        }
    }//GEN-LAST:event_cboQuanHuyenItemStateChanged

    private void cboXaPhuongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboXaPhuongItemStateChanged
        if (cboXaPhuong.getSelectedIndex() != -1) {
            Xa_Phuong xaDuocChon = dsXa.get(cboXaPhuong.getSelectedIndex());
            diaChi[0] = xaDuocChon.getTenXa_Phuong();
            txtDiachi.setText(Arrays.stream(diaChi).filter(e -> !e.isEmpty()).collect(Collectors.joining(", ")));
        }
    }//GEN-LAST:event_cboXaPhuongItemStateChanged

    private void BTNFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNFirstActionPerformed
        dongDuocChon = 0;
        capNhatTruongThongTin();
    }//GEN-LAST:event_BTNFirstActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (dongDuocChon > 0) {
            dongDuocChon--;
            capNhatTruongThongTin();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        dongDuocChon = tblNhacungcap.getRowCount() - 1;
        capNhatTruongThongTin();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        int tongSoDong = tblNhacungcap.getRowCount();
        if (dongDuocChon < tongSoDong - 1) {
            dongDuocChon++;
            capNhatTruongThongTin();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void txtTimkiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiemKeyPressed

    }//GEN-LAST:event_txtTimkiemKeyPressed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        if (txtTimkiem.getText().isEmpty()) {
            resetGiaoDien();
        } else {
            dangTimKiem = true;
            dsNhaCungCapDuocTimThay = new ArrayList<>();
            for (NhaCungCap ncc : dsNhaCungCap) {
                if (txtTimkiem.getText().equals(ncc.getIdNhaCungCap() + "") || ncc.getTenNhaCungCap().toLowerCase().contains(txtTimkiem.getText().toLowerCase())) {
                    dsNhaCungCapDuocTimThay.add(ncc);
                }
            }
            capNhatBangNhaCungCap();
        }
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void cboThanhPhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThanhPhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboThanhPhoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNFirst;
    private javax.swing.JButton btlSua;
    private javax.swing.JButton btlThem;
    private javax.swing.JButton btlXoa;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JComboBox<String> cboQuanHuyen;
    private javax.swing.JComboBox<String> cboThanhPho;
    private javax.swing.JComboBox<String> cboXaPhuong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbllDiachi;
    private javax.swing.JLabel lbllMaNhaCungCap;
    private javax.swing.JLabel lbllNgayhoptac;
    private javax.swing.JLabel lbllSodienthoai;
    private javax.swing.JLabel lbllTennhacungcap;
    private com.girlkun.panel.RoundPanel roundPanel1;
    private javax.swing.JTable tblNhacungcap;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtManhacungcap;
    private javax.swing.JTextField txtNgayhoptac;
    private javax.swing.JTextField txtSodienthoai;
    private javax.swing.JTextField txtTennhacungcap;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
