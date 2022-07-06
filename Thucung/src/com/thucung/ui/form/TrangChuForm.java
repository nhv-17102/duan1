package com.thucung.ui.form;

import com.thucung.notification.NodifyBanner;
import javax.swing.ImageIcon;

/**
 *
 * @author 💖 Trần Lại 💖
 * @copyright 💖 GirlkuN  💖
 *
 */
public class TrangChuForm extends javax.swing.JPanel {
        
    public TrangChuForm() {
        initComponents();
        setup();
    }
    
    
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slideshow1 = new com.girlkun.slideshow.Slideshow();
        slideshow2 = new com.girlkun.slideshow.Slideshow();
        slideshow3 = new com.girlkun.slideshow.Slideshow();
        slideshow4 = new com.girlkun.slideshow.Slideshow();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slideshow1, javax.swing.GroupLayout.DEFAULT_SIZE, 1228, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(slideshow3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slideshow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(slideshow4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(slideshow1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(slideshow4, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(slideshow2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(slideshow3, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.girlkun.slideshow.Slideshow slideshow1;
    private com.girlkun.slideshow.Slideshow slideshow2;
    private com.girlkun.slideshow.Slideshow slideshow3;
    private com.girlkun.slideshow.Slideshow slideshow4;
    // End of variables declaration//GEN-END:variables
    
    public void setup(){
        this.setOpaque(false);
        slideshow1.initSlideshow(new NodifyBanner(new ImageIcon("D:\\Image\\Girl\\a1.jpg")),
                new NodifyBanner(new ImageIcon("D:\\Image\\Girl\\a2.jpg")),
                new NodifyBanner(new ImageIcon("D:\\Image\\Girl\\a3.jpg"))
        );
        slideshow2.initSlideshow(new NodifyBanner(new ImageIcon("D:\\Image\\Girl\\a1.jpg")),
                new NodifyBanner(new ImageIcon("D:\\Image\\Girl\\a2.jpg")),
                new NodifyBanner(new ImageIcon("D:\\Image\\Girl\\a3.jpg"))
        );
        slideshow3.initSlideshow(new NodifyBanner(new ImageIcon("D:\\Image\\Girl\\a1.jpg")),
                new NodifyBanner(new ImageIcon("D:\\Image\\Girl\\a2.jpg")),
                new NodifyBanner(new ImageIcon("D:\\Image\\Girl\\a3.jpg"))
        );
        slideshow4.initSlideshow(new NodifyBanner(new ImageIcon("D:\\Image\\Girl\\a1.jpg")),
                new NodifyBanner(new ImageIcon("D:\\Image\\Girl\\a2.jpg")),
                new NodifyBanner(new ImageIcon("D:\\Image\\Girl\\a3.jpg"))
        );
    }
}
