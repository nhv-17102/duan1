package com.thucung.ui.form;

import com.thucung.dao.DAOHoaDon;
import com.thucung.dao.DAOHoaDonChiTiet_SanPham_PhuKien;
import com.thucung.dao.DAOHoaDonChiTiet_ThuCung;
import com.thucung.dao.DAONhanVien;
import com.thucung.models.HoaDon;
import com.thucung.models.HoaDonChiTiet_SanPham_PhuKien;
import com.thucung.models.HoaDonChiTiet_ThuCung;
import com.thucung.models.NhanVien;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 💖 Trần Lại 💖
 * @copyright 💖 GirlkuN 💖
 *
 */
public class ThongKeForm extends javax.swing.JPanel {

    public ThongKeForm() {
        initComponents();
        setup();
        load(1);
    }
    ArrayList<String[]> datas = new ArrayList<>();

    void load(int month) {
        datas = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
        model.setRowCount(0);
        double tongDoanhThu = 0;
        try {
            List<HoaDon> dsHoaDonTheoThang = new DAOHoaDon().selectAll().stream()
                    .filter(hd -> Integer.parseInt(hd.getNgayXuatHoaDon().split("-")[1]) == month)
                    .collect(Collectors.toList());
            List<NhanVien> dsNhanVien = new DAONhanVien().selectAll();
            List<HoaDonChiTiet_ThuCung> dsThuCungCuaHoaDon;
            List<HoaDonChiTiet_SanPham_PhuKien> dsSanPham_PhuKien;
            int tongHoaDon = 0;
            double doanhThu = 0;
            for (NhanVien nhanVien : dsNhanVien) {
                for (HoaDon hoaDon : dsHoaDonTheoThang) {
                    if (hoaDon.getNhanVien() == nhanVien.getIdNhanVien()) {
                        tongHoaDon++;
                        dsThuCungCuaHoaDon = new DAOHoaDonChiTiet_ThuCung().selectByIDHoaDon(hoaDon.getIdHoaDon());
                        for (HoaDonChiTiet_ThuCung ct : dsThuCungCuaHoaDon) {
                            doanhThu += ct.getDonGia();
                        }
                        dsSanPham_PhuKien = new DAOHoaDonChiTiet_SanPham_PhuKien().selectByIDHoaDon(hoaDon.getIdHoaDon());
                        for (HoaDonChiTiet_SanPham_PhuKien ct : dsSanPham_PhuKien) {
                            doanhThu += ct.getDongia() * ct.getSoLuong();
                        }
                    }
                }
                if (tongHoaDon > 0) {
                    String row[] = {
                        nhanVien.getIdNhanVien() + "",
                        nhanVien.getTenNhanVien(),
                        tongHoaDon + "",
                        doanhThu + ""};
                    model.addRow(row);
                    datas.add(row);
                }
                tongDoanhThu += doanhThu;
                tongHoaDon = 0;
                doanhThu = 0;
            }
        } catch (Exception e) {

        }
        txtTongDoanhThu.setText(tongDoanhThu + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.girlkun.panel.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        cboThang = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        lblTongDoanhThu = new javax.swing.JLabel();
        txtTongDoanhThu = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();

        roundPanel1.setBackground(new java.awt.Color(65, 65, 65));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thống Kê Doanh Thu");

        cboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12", " " }));
        cboThang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cboThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThangItemStateChanged(evt);
            }
        });
        cboThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThangActionPerformed(evt);
            }
        });

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên NV", "Tổng Hoá Đơn", "Doanh Thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThongKe.setRowHeight(27);
        tblThongKe.setShowGrid(false);
        jScrollPane1.setViewportView(tblThongKe);

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        lblTongDoanhThu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTongDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        lblTongDoanhThu.setText("Tổng Doanh Thu Trong Tháng :");

        txtTongDoanhThu.setEditable(false);
        txtTongDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongDoanhThuActionPerformed(evt);
            }
        });

        btnReset.setText("RESET BẢNG");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(0, 22, Short.MAX_VALUE)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(128, 128, 128))))
        );

        cboThang.getAccessibleContext().setAccessibleName("Tháng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        roundPanel1.getAccessibleContext().setAccessibleName("Tháng");
    }// </editor-fold>//GEN-END:initComponents

    private void cboThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboThangActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        txtTimKiem.getText();
        DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
        model.setRowCount(0);
        datas.stream().filter(data -> (txtTimKiem.getText().equals(data[0]) || data[1].toLowerCase().contains(txtTimKiem.getText()))).forEachOrdered(model::addRow);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void cboThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThangItemStateChanged
        load(cboThang.getSelectedIndex() + 1);
    }//GEN-LAST:event_cboThangItemStateChanged

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        load(cboThang.getSelectedIndex() + 1);
        txtTimKiem.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtTongDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongDoanhThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongDoanhThuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cboThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTongDoanhThu;
    private com.girlkun.panel.RoundPanel roundPanel1;
    private javax.swing.JTable tblThongKe;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongDoanhThu;
    // End of variables declaration//GEN-END:variables

    public void setup() {
        this.setOpaque(false);
    }
}
