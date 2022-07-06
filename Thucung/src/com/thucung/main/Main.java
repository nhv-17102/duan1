package com.thucung.main;

import com.thucung.event.EventMenu;
import com.thucung.ui.form.*;
import java.awt.Color;
import java.awt.Component;

/**
 *
 * @author 💖 Trần Lại 💖
 * @copyright 💖 GirlkuN 💖
 *
 */
public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        setup();
        
        /*change info
        article.setAvatar(new ImageIcon("data/icon/home.png"));
        article.setName("TQL");
        article.setRole("ADMIN");
        */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.girlkun.panel.RoundPanel();
        body = new javax.swing.JPanel();
        header = new com.thucung.ui.components.Header();
        article = new com.thucung.ui.components.Article();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        roundPanel1.setBackground(new java.awt.Color(20, 20, 20));

        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(article, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                    .addComponent(article, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.thucung.ui.components.Article article;
    private javax.swing.JPanel body;
    private com.thucung.ui.components.Header header;
    private com.girlkun.panel.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables

    private void setup() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setBackground(new Color(0, 0, 0, 0));
        that = this;

        initEvent();
        header.setButton(this);
        body.setOpaque(false);

        article.initMenu(event);
        //setdefault form 1
        event.selected(Menu.TRANGCHU);
        article.choseTrangChu();
    }

    private void initEvent() {
        event = new EventMenu() {
            @Override
            public void selected(Menu chose) {
                switch (chose) {
                    case GIOHANG:
                        new GioHangForm(that).setVisible(true);
                        break;
                    case TRANGCHU:
                        showForm(new TrangChuForm());
                        break;
                    case THUCUNG:
                        showForm(new ThuCungForm());
                        break;
                    case SANPHAM_PHUKIEN:
                        showForm(new SanPham_PhuKienForm());
                        break;
                    case TAIKHOAN:
                        showForm(new TaiKhoanForm());
                        break;
                    case NHACUNGCAP:
                        showForm(new NhaCungCapForm());
                        break;
                    case NHANVIEN:
                        showForm(new NhanVienForm());
                        break;
                    case KHACHHANG:
                        showForm(new KhachHangForm());
                        break;
                    case HOADON:
                        showForm(new HoaDonForm());
                        break;
                    case MAGIAMGIA:
                        showForm(new MaGiamGiaForm());
                        break;
                    case THONGKE:
                        showForm(new ThongKeForm());
                        break;
                    case DOIMATKHAU:
                        showForm(new DoiMatKhauForm());
                        break;
                    case DANGXUAT:
                        System.exit(0);
                        break;
                }
            }
        };
    }

    private void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.revalidate();
        body.repaint();
    }

    private Main that;
    private EventMenu event;
    
    public enum Menu {
        TRANGCHU, THUCUNG,
        SANPHAM_PHUKIEN, NHANVIEN,
        KHACHHANG, TAIKHOAN,
        MAGIAMGIA, NHACUNGCAP,
        HOADON, DANGXUAT,
        GIOHANG, THONGKE, DOIMATKHAU
    }
}
