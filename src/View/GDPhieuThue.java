/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controled.PhieuThueDAO;
import Controled.PhongDAO;
import Model.KhachHang;
import Model.PhieuThue;
import Model.Phong;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class GDPhieuThue extends javax.swing.JFrame {

    /**
     * Creates new form GDPhieuThue
     */
    
    private GDTrangChu GDTC;
    
    private ArrayList<KhachHang> Dskhachhang;
    private DefaultTableModel tblKhachHangMD;
    
    private PhieuThue phieuthue;
    private ArrayList<PhieuThue> dsPhieuThue;
    private DefaultTableModel tblPhieuThueMD;
    
    public GDPhieuThue() {
        initComponents();
        this.setTitle("Giao diện phiếu thuê");

        ButtonGroup bt = new ButtonGroup();
        bt.add(rbtDaDong);
        bt.add(rbtChuaDong);
        this.setLocationRelativeTo(null);
        //Dskhachhang = new ArrayList<>();
        phieuthue = new PhieuThue();
        dsPhieuThue = new PhieuThueDAO().getListPhieuThue();
        
        tblPhieuThueMD = (DefaultTableModel) tblPhieuThue.getModel();
        tblKhachHangMD = (DefaultTableModel) tblKhachHang.getModel();
        
        showPT();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaPT = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        txtMaP = new javax.swing.JTextField();
        txtTienCoc = new javax.swing.JTextField();
        txtCheckin = new javax.swing.JTextField();
        txtCheckout = new javax.swing.JTextField();
        btnThemKH = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        rbtDaDong = new javax.swing.JRadioButton();
        rbtChuaDong = new javax.swing.JRadioButton();
        btnThemPT = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuThue = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MaPT");

        jLabel2.setText("MaKH");

        jLabel3.setText("MaP");

        jLabel4.setText("TienCoc");

        jLabel5.setText("Ngay_checkin");

        jLabel6.setText("Ngay_checkout");

        btnThemKH.setText("Thêm KH");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        jLabel7.setText("TrangThai");

        rbtDaDong.setText("Đã đóng");

        rbtChuaDong.setSelected(true);
        rbtChuaDong.setText("Chưa đóng");

        btnThemPT.setText("Thêm PT");
        btnThemPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaPT)
                            .addComponent(txtMaKH)
                            .addComponent(txtMaP)
                            .addComponent(txtTienCoc)
                            .addComponent(txtCheckin)
                            .addComponent(txtCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(8, 8, 8)
                        .addComponent(rbtDaDong, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbtChuaDong))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemKH)
                            .addComponent(btnThemPT))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rbtDaDong)
                    .addComponent(rbtChuaDong))
                .addGap(18, 18, 18)
                .addComponent(btnThemPT)
                .addGap(103, 103, 103)
                .addComponent(btnThemKH)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        tblPhieuThue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaPT", "MaKH", "MaP", "TienCoc", "Ngay_checkin", "Ngay_checkout", "TrangThai"
            }
        ));
        jScrollPane1.setViewportView(tblPhieuThue);

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaKH", "HoTen", "CMND", "QuocTich", "DiaChi", "GioiTinh"
            }
        ));
        jScrollPane2.setViewportView(tblKhachHang);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        // TODO add your handling code here:
        GDThem GDT = new GDThem(this, rootPaneCheckingEnabled);
        GDT.setVisible(true);
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btnThemPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPTActionPerformed
                                        
            // TODO add your handling code here:
        phieuthue = new PhieuThue();
        phieuthue.setMaP(Integer.parseInt(txtMaP.getText()));
        phieuthue.setMaKH(txtMaKH.getText());
        phieuthue.setMaPT(txtMaPT.getText());
        phieuthue.setTienCoc(Long.parseLong(txtTienCoc.getText()));
        try {
            phieuthue.setNgay_checkin(new SimpleDateFormat("dd/MM/yyyy").parse(txtCheckin.getText()));
        } catch (ParseException ex) {  
        }
        try {
            phieuthue.setNgay_checkout(new SimpleDateFormat("dd/MM/yyyy").parse(txtCheckout.getText())); 
        } catch (ParseException ex) {  
        }
        String TT = "Đã đóng";
        if(rbtDaDong.isSelected())  TT = "Đã đóng";
        if(rbtChuaDong.isSelected())  TT = "Chưa đóng";
        phieuthue.setTrangThai(TT);
        
        if(new PhieuThueDAO().addPhieuThue(phieuthue)){
            themPhieuThue(phieuthue);
            JOptionPane.showMessageDialog(rootPane, "Thêm phiếu thuê thành công");
            new PhongDAO().updatePhongDaThue(phieuthue.getMaP()+"");
        }else{
            JOptionPane.showMessageDialog(rootPane, "Trùng MaPT -> yêu cầu nhập lại");
        }
        

    }//GEN-LAST:event_btnThemPTActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new GDTrangChu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed
    
    public void themPhieuThue(PhieuThue PT){
        dsPhieuThue.add(PT);
        tblPhieuThueMD.setRowCount(0);
        showPT();
    }
    public void showPT(){
        for(PhieuThue pt : dsPhieuThue){
            tblPhieuThueMD.addRow(new Object[]{pt.getMaPT(), pt.getMaKH(), 
                pt.getMaP(), pt.getTienCoc(), pt.getNgay_checkin(), pt.getNgay_checkout(), pt.getTrangThai()});
        }
    }
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
            java.util.logging.Logger.getLogger(GDPhieuThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDPhieuThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDPhieuThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDPhieuThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GDPhieuThue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnThemPT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbtChuaDong;
    private javax.swing.JRadioButton rbtDaDong;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblPhieuThue;
    private javax.swing.JTextField txtCheckin;
    private javax.swing.JTextField txtCheckout;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaP;
    private javax.swing.JTextField txtMaPT;
    private javax.swing.JTextField txtTienCoc;
    // End of variables declaration//GEN-END:variables

    public void seteditdataPhong(Phong p) {
        txtMaP.setText(p.getMaP()+"");
        txtMaP.setEditable(false);
    }

    public void ThemKH(KhachHang kh) {
        Dskhachhang = new ArrayList<>();
        Dskhachhang.add(kh);
        tblKhachHangMD.setRowCount(0);
        for(KhachHang khachhang : Dskhachhang){
            tblKhachHangMD.addRow(new Object[]{khachhang.getMaKH(), khachhang.getTenKH(),
                khachhang.getCMND(), khachhang.getQuocTich(), khachhang.getDiaChi(), khachhang.getGioiTinh()});
        }
    }

    void GanThongTin(KhachHang kh) {
        txtMaKH.setText(kh.getMaKH());
        txtMaKH.setEditable(false);
    }
    
    
    
    void layMaKH(Phong p) {
//        for(PhieuThue PT : Dsphieuthue){
//            if((PT.getMaP() == p.getMaP()) && (PT.getTrangThai() == "Chưa đóng")){
//                GDPhieuDichVu phieuDV = new GDPhieuDichVu();
//                phieuDV.seteditdataDV(PT.getMaKH());
//                phieuDV.setVisible(true);
//            }
//        }
        
//        for(vidudemoPT PT : Pts){
//            if((PT.getMaP() == p.getMaP()) && (PT.getTrangThai() == "chua dong")){
//                GDPhieuDichVu phieuDV = new GDPhieuDichVu();
//                phieuDV.seteditdataDV(PT.getMaKH());
//                phieuDV.setVisible(true);
//            }
//        }
    }

    void ganMaKH(KhachHang kh) {
        txtMaKH.setText(kh.getMaKH());
        txtMaKH.setEditable(false);
    }

}