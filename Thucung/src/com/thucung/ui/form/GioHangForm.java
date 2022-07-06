package com.thucung.ui.form;
import com.thucung.main.Main;
import com.thucung.models.GioHang;
import com.thucung.models.SanPham_PhuKien;
import com.thucung.models.ThuCung;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 💖 Trần Lại 💖
 * @copyright 💖 GirlkuN 💖
 *
 */
public class GioHangForm extends javax.swing.JFrame {

    public GioHangForm(Main main) {
        this.main = main;
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.girlkun.panel.RoundPanel();
        header = new com.thucung.ui.components.Header();
        roundPanel2 = new com.girlkun.panel.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThuCung = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham_PhuKien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnXoaSanPham = new com.girlkun.button.Button();
        btnThanhToan = new com.girlkun.button.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        roundPanel1.setBackground(new java.awt.Color(204, 204, 0));

        roundPanel2.setBackground(new java.awt.Color(80, 80, 80));

        tblThuCung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblThuCung.setSelectionBackground(new java.awt.Color(255, 255, 153));
        tblThuCung.setSelectionForeground(new java.awt.Color(0, 0, 51));
        tblThuCung.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblThuCung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuCungMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThuCung);

        tblSanPham_PhuKien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSanPham_PhuKien.setSelectionBackground(new java.awt.Color(255, 255, 153));
        tblSanPham_PhuKien.setSelectionForeground(new java.awt.Color(0, 0, 51));
        tblSanPham_PhuKien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSanPham_PhuKien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPham_PhuKienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham_PhuKien);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Giỏ hàng");

        btnXoaSanPham.setBackground(new java.awt.Color(255, 0, 0));
        btnXoaSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaSanPham.setText("Xóa khỏi giỏ");
        btnXoaSanPham.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(0, 0, 204));
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))))
        );

        roundPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnThanhToan, btnXoaSanPham});

        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        roundPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnThanhToan, btnXoaSanPham});

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblThuCungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuCungMouseClicked
        isThuCung = true;
        index = tblThuCung.getSelectedRow();
    }//GEN-LAST:event_tblThuCungMouseClicked

    private void tblSanPham_PhuKienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPham_PhuKienMouseClicked
        isThuCung = false;
        index = tblSanPham_PhuKien.getSelectedRow();
    }//GEN-LAST:event_tblSanPham_PhuKienMouseClicked

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        removeProduct();
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

    }//GEN-LAST:event_btnThanhToanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.girlkun.button.Button btnThanhToan;
    private com.girlkun.button.Button btnXoaSanPham;
    private com.thucung.ui.components.Header header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.girlkun.panel.RoundPanel roundPanel1;
    private com.girlkun.panel.RoundPanel roundPanel2;
    private javax.swing.JTable tblSanPham_PhuKien;
    private javax.swing.JTable tblThuCung;
    // End of variables declaration//GEN-END:variables

    private void setup() {
        this.setLocationRelativeTo(main);
        this.setResizable(false);
        this.setBackground(new Color(0, 0, 0, 0));
        header.setButton(this);
        main.setEnabled(false);
        init();
        fillToTableThuCung();
        fillToTableSanPham_PhuKien();
    }

    private void init() {
        String[] columnThuCung = {"ID", "Tên thú cưng", "Hình ảnh"};
        modelThuCung = new DefaultTableModel(columnThuCung, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblThuCung.setModel(modelThuCung);
        tblThuCung.setRowHeight(50);

        String[] columnSanPham_PhuKien = {"ID", "Tên sản phẩm - phụ kiện", "Hình ảnh","Số lượng"};
        modelSanPham_PhuKien = new DefaultTableModel(columnSanPham_PhuKien, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblSanPham_PhuKien.setModel(modelSanPham_PhuKien);
        tblSanPham_PhuKien.setRowHeight(50);
    }

    private void fillToTableThuCung() {
        for (ThuCung thuCung : GioHang.getInstance().getListThuCung()) {
            modelThuCung.addRow(new Object[]{
                "TC" + thuCung.getIdThuCung(), thuCung.getTenThuCung(), thuCung.getHinhAnh()
            });
            tblThuCung.getColumnModel().getColumn(2).setCellRenderer(new ImageRender());
        }
    }

    private void fillToTableSanPham_PhuKien() {
        int indexSanPham_PhuKien = 0;
        for (SanPham_PhuKien sanPham_PhuKien : GioHang.getInstance().getListSanPham_PhuKien()) {
            modelSanPham_PhuKien.addRow(new Object[]{
                "SP" + sanPham_PhuKien.getIdSanPham_PhuKien(), sanPham_PhuKien.getTenSanPham_PhuKien(),
                sanPham_PhuKien.getHinhAnh(), GioHang.getInstance().getSoLuongSanPham_PhuKien().get(indexSanPham_PhuKien)
            });
            indexSanPham_PhuKien++;
            tblSanPham_PhuKien.getColumnModel().getColumn(2).setCellRenderer(new ImageRender());
        }
    }
    
    private void removeProduct(){
        if(index != -1 && isThuCung){
            GioHang.getInstance().removeThuCungIndex(index);
            modelThuCung.removeRow(index);
        }
        if(index != -1 && !isThuCung){
            GioHang.getInstance().removeSanPham_PhuKienIndex(index);
            modelSanPham_PhuKien.removeRow(index);
        }
        index = -1;
    }

    public Main main;
    private boolean isThuCung;
    private int index = -1;
    private DefaultTableModel modelThuCung;
    private DefaultTableModel modelSanPham_PhuKien;

    private class ImageRender extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            String photoName = value.toString();
            ImageIcon icon = new ImageIcon(new ImageIcon(photoName).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            return new JLabel(icon);
        }
    }
}
