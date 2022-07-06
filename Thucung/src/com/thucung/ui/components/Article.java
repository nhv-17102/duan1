package com.thucung.ui.components;

import com.girlkun.button.ButtonMenu;
import com.girlkun.scrollbar.ScrollBarCustom;
import com.thucung.event.EventMenu;
import com.thucung.main.Main;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author 💖 Trần Lại 💖
 * @copyright 💖 GirlkuN 💖
 *
 */
public class Article extends javax.swing.JPanel {
    
    public Article() {
        initComponents();
        setup();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.girlkun.panel.RoundPanel();
        avatar = new com.girlkun.avatar.Avatar();
        nameUser = new javax.swing.JLabel();
        role = new javax.swing.JLabel();
        roundPanel2 = new com.girlkun.panel.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();
        panelShoppingCart = new com.girlkun.panel.RoundPanel();

        roundPanel1.setBackground(new java.awt.Color(65, 65, 65));

        avatar.setBackground(new java.awt.Color(255, 51, 51));
        avatar.setForeground(new java.awt.Color(255, 255, 255));
        avatar.setBorderSize(2);
        avatar.setIcon(new javax.swing.ImageIcon("D:\\Image\\Girl\\a2.jpg")); // NOI18N

        nameUser.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nameUser.setForeground(new java.awt.Color(255, 255, 255));
        nameUser.setText("USER NAME");

        role.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        role.setForeground(new java.awt.Color(255, 255, 255));
        role.setText("Nhân viên");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(avatar, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(nameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(role, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        roundPanel2.setBackground(new java.awt.Color(65, 65, 65));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelMenu.setBackground(new java.awt.Color(65, 65, 65));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelMenu);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1)
                .addGap(5, 5, 5))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelShoppingCart.setBackground(new java.awt.Color(65, 65, 65));

        javax.swing.GroupLayout panelShoppingCartLayout = new javax.swing.GroupLayout(panelShoppingCart);
        panelShoppingCart.setLayout(panelShoppingCartLayout);
        panelShoppingCartLayout.setHorizontalGroup(
            panelShoppingCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelShoppingCartLayout.setVerticalGroup(
            panelShoppingCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelShoppingCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(panelShoppingCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void initMenu(EventMenu event) {
        this.event = event;
        addButtonMenu("Trang chủ", new ImageIcon("data/icon/home.png"), Main.Menu.TRANGCHU);
        addButtonMenu("Thú cưng", new ImageIcon("data/icon/dog.png"), Main.Menu.THUCUNG);
        addButtonMenu("Sản phẩm - Phụ kiện", new ImageIcon("data/icon/dog-treat.png"), Main.Menu.SANPHAM_PHUKIEN);
        addButtonMenu("Tài khoản", new ImageIcon("data/icon/bank-account.png"), Main.Menu.TAIKHOAN);
        addButtonMenu("Nhà cung cấp", new ImageIcon("data/icon/inventory.png"), Main.Menu.NHACUNGCAP);
        addButtonMenu("Nhân viên", new ImageIcon("data/icon/team.png"), Main.Menu.NHANVIEN);
        addButtonMenu("Khách hàng", new ImageIcon("data/icon/guests.png"), Main.Menu.KHACHHANG);
        addButtonMenu("Hóa đơn", new ImageIcon("data/icon/bill.png"), Main.Menu.HOADON);
        addButtonMenu("Mã giảm giá", new ImageIcon("data/icon/coupons.png"), Main.Menu.MAGIAMGIA);
        addButtonMenu("Thống kê", new ImageIcon("data/icon/bar-chart.png"), Main.Menu.THONGKE);
        addButtonMenu("Đổi mật khẩu", new ImageIcon("data/icon/padlock.png"), Main.Menu.DOIMATKHAU);
        addEmpty();
        addButtonMenu("Logout", new ImageIcon("data/icon/logout.png"), Main.Menu.DANGXUAT);
        setShoppingCartButton();
    }
    
    private void addButtonMenu(String text, Icon icon, Main.Menu choose) {
        ButtonMenu menu = new ButtonMenu();
        menu.setText(text);
        menu.setIcon(icon);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.selected(choose);
                setSelected(menu);
            }
        });
        panelMenu.add(menu);
    }
    
    private void setSelected(ButtonMenu menu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof ButtonMenu) {
                ButtonMenu b = (ButtonMenu) com;
                b.setSelected(false);
            }
        }
        menu.setSelected(true);
    }
    
    private void addEmpty() {
        panelMenu.add(new JLabel(), "push");
    }
    
    public void choseTrangChu() {
        setSelected(((ButtonMenu) panelMenu.getComponent(0)));
    }
    
    private void setShoppingCartButton(){
        ButtonMenu shoppingCart = new ButtonMenu();
        shoppingCart.setText("Giỏ hàng");
        shoppingCart.setIcon(new ImageIcon("data/icon/shopping-cart.png"));
        shoppingCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.selected(Main.Menu.GIOHANG);
            }
        });
        panelShoppingCart.add(shoppingCart);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.girlkun.avatar.Avatar avatar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameUser;
    private javax.swing.JPanel panelMenu;
    private com.girlkun.panel.RoundPanel panelShoppingCart;
    private javax.swing.JLabel role;
    private com.girlkun.panel.RoundPanel roundPanel1;
    private com.girlkun.panel.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables

    public void setup() {
        this.setOpaque(false);
        
        ScrollBarCustom sb = new ScrollBarCustom();
        sb.setForeground(new Color(130, 130, 130, 100));
        jScrollPane1.setVerticalScrollBar(sb);
        
        panelMenu.setLayout(new MigLayout("wrap, fillx", "[fill]", "[]0[]"));
        panelShoppingCart.setLayout(new MigLayout("fillx", "[fill]", ""));
    }
    
    public void setAvatar(Icon avt){
        avatar.setIcon(avt);
    }
    
    public void setName(String name){
        nameUser.setText(name);
    }
    
    public void setRole(String roleUser){
        role.setText(roleUser);
    }
    
    private EventMenu event;
}
