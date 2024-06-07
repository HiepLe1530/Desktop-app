/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controled.DichVuDAO;
import Controled.HoaDonDVDAO;
import Controled.HoaDonPhongDAO;
import Controled.KhachHangDAO;
import Controled.PhieuDangKyDAO;
import Controled.PhieuDichVuDAO;
import Controled.PhieuThueDAO;
import Controled.PhieuTruyVanDAO;
import Controled.PhongDAO;
import Model.DichVu;
import Model.HoaDonDV;
import Model.HoaDonPhong;
import Model.KhachHang;
import Model.PhieuDangKy;
import Model.PhieuDichVu;
import Model.PhieuThue;
import Model.PhieuTruyVan;
import Model.Phong;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class GDTrangChu extends javax.swing.JFrame {

    /**
     * Creates new form GDTrangChu
     */
    
    private int selectedrowKH;
    private int selectedrowP;
    private int selectedrowPDKTK, selectedrowPDK;
    private int selectedrowDV;
    private int selectedrowPDV;
    private int selectedrowPTtheoPhong;
    private int selectedrowPT;
    private int selectedrowHDP;
    private int selectedrowHDDV;
    
    private ArrayList<Phong> dsPhong, dsPhongTrongTK;
    private ArrayList<KhachHang> dsKhachHang, dsTKKHThueNgay, dsTKKHTraNgay, dsTKKHDangO;
    private ArrayList<PhieuThue> dsPhieuThue, dsPhieuThueTKtheoPhong;
    private ArrayList<PhieuTruyVan> dsPhieuTruyVanTK;
    private ArrayList<DichVu> dsDichVu;
    private ArrayList<PhieuDangKy> dsPhieuDangKy, dsPhieuDangKyTKNgay, dsPhieuDangKyTKCMND;
    private ArrayList<PhieuDichVu> dsPhieuDichVu;
    private ArrayList<HoaDonPhong> dsHoaDonPhong, dsThongKeHDPtheoNgay, dsThongKeHDPtheoThang, dsThongKeHDPtheoNam ;
    private ArrayList<HoaDonDV> dsHoaDonDV, dsThongKeHDDVtheoNgay, dsThongKeHDDVtheoThang, dsThongKeHDDVtheoNam;
    
    private DefaultTableModel tblPhongMD;
    private DefaultTableModel tblKhachHangMD;
    private DefaultTableModel tblTKKhachHangMD;
    private DefaultTableModel tblPhieuThueMD;
    private DefaultTableModel tblDichVuMD;
    private DefaultTableModel tblPhieuDangKyMD;
    private DefaultTableModel tblTimKiemPDKMD;
    private DefaultTableModel tblPhieuDichVuMD;
    private DefaultTableModel tblTimKiem1MD;
    private DefaultTableModel tblTimKiem2MD;
    private DefaultTableModel tblTimKiemPTtheoPhongMD;
    private DefaultTableModel tblHoaDonPhongMD;
    private DefaultTableModel tblHoaDonDVMD;
    private DefaultTableModel tblThongKeHDPMD;
    private DefaultTableModel tblThongKeHDDVMD;
    
    
    public GDTrangChu() {
        initComponents();
        this.setTitle("Giao diện trang chủ");
        this.setLocationRelativeTo(null);
        ButtonGroup bt = new ButtonGroup();
        bt.add(rbtTimKiemCMND);
        bt.add(rbtTimKiemNgayDK);
        bt.add(rbtThongKeNgayP);
        bt.add(rbtThongKeThangP);
        bt.add(rbtThongKeNamP);
        bt.add(rbtThongKeNgayDV);
        bt.add(rbtThongKeThangDV);
        bt.add(rbtThongKeNamDV);
        
        ButtonGroup bt1 = new ButtonGroup();
        bt1.add(rbtTKKHThueNgay);
        bt1.add(rbtTKKHTraNgay);
        bt1.add(rbtTKKHDangOtheoNgay);
        
        
        dsPhong = new PhongDAO().getListPhong();
        dsKhachHang = new KhachHangDAO().getListKhachHang();
        dsPhieuThue = new PhieuThueDAO().getListPhieuThue();
        dsDichVu = new DichVuDAO().getListDichVu();
        dsPhieuDangKy = new PhieuDangKyDAO().getListPhieuDangKy();
        dsPhieuDichVu = new PhieuDichVuDAO().getListPhieuDichVu();
        dsHoaDonPhong = new HoaDonPhongDAO().getListHoaDonPhong();
        dsHoaDonDV = new HoaDonDVDAO().getListHoaDonDV();
        
        tblPhongMD = (DefaultTableModel) tblPhong.getModel();
        tblKhachHangMD = (DefaultTableModel) tblKhachHang.getModel();
        tblPhieuThueMD = (DefaultTableModel) tblPhieuThue.getModel();
        tblDichVuMD = (DefaultTableModel) tblDichVu.getModel();
        tblPhieuDangKyMD = (DefaultTableModel) tblPhieuDangKy.getModel();
        tblTimKiemPDKMD = (DefaultTableModel) tblTimKiemPDK.getModel();
        tblPhieuDichVuMD = (DefaultTableModel) tblPhieuDichVu.getModel();
        tblTimKiem1MD = (DefaultTableModel) tblTimKiem1.getModel();
        tblTimKiem2MD = (DefaultTableModel) tblTimKiem2.getModel();
        tblTimKiemPTtheoPhongMD = (DefaultTableModel) tblTimKiemPTtheoPhong.getModel();
        tblHoaDonPhongMD = (DefaultTableModel) tblHoaDonPhong.getModel();
        tblHoaDonDVMD = (DefaultTableModel) tblHoaDonDV.getModel();
        tblThongKeHDPMD = (DefaultTableModel) tblThongKeHDP.getModel();
        tblThongKeHDDVMD = (DefaultTableModel) tblThongKeHDDV.getModel();
        tblTKKhachHangMD = (DefaultTableModel) tblTKKhachHang.getModel();
        
        showKH();
        showPhong();
        showPT();
        showPDK();
        showDV();
        showPDV();
        showHDP();
        showHDDV();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JTabbedPane = new javax.swing.JTabbedPane();
        tabKhachHang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnSuaKH = new javax.swing.JButton();
        btnXoaKH = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        rbtTKKHThueNgay = new javax.swing.JRadioButton();
        rbtTKKHTraNgay = new javax.swing.JRadioButton();
        txtNgayThue = new javax.swing.JTextField();
        txtNgayTra = new javax.swing.JTextField();
        btnTimKiemKH = new javax.swing.JButton();
        rbtTKKHDangOtheoNgay = new javax.swing.JRadioButton();
        txtNgayO = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblTKKhachHang = new javax.swing.JTable();
        tabPhong = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPhong = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnThemP = new javax.swing.JButton();
        btnSuaP = new javax.swing.JButton();
        btnXoaP = new javax.swing.JButton();
        btnLapPT = new javax.swing.JButton();
        btnLapPDV = new javax.swing.JButton();
        btnLapPDK = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblTimKiem1 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        txtTimKiemNgay = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnTimKiemPhong = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblTimKiem2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tabDichVu = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        btnThemDV = new javax.swing.JButton();
        btnSuaDV = new javax.swing.JButton();
        btnXoaDV = new javax.swing.JButton();
        tabPhieuDichVu = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPhieuDichVu = new javax.swing.JTable();
        btnSuaPDV = new javax.swing.JButton();
        btnXoaPDV = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPDV_P_MaP = new javax.swing.JTextField();
        btnLapHDDV = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tabPhieuThue = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPhieuThue = new javax.swing.JTable();
        btnSuaPT = new javax.swing.JButton();
        btnXoaPT = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPT_P_MaP = new javax.swing.JTextField();
        btnTimKiemPTtheoPhong = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblTimKiemPTtheoPhong = new javax.swing.JTable();
        btnLapHDP = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblPhieuDangKy = new javax.swing.JTable();
        btnSuaPDK = new javax.swing.JButton();
        btnXoaPDK = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        rbtTimKiemNgayDK = new javax.swing.JRadioButton();
        rbtTimKiemCMND = new javax.swing.JRadioButton();
        txtTimKiemNgayDK = new javax.swing.JTextField();
        txtTimKiemCMND = new javax.swing.JTextField();
        btnTimKiemPDK = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblTimKiemPDK = new javax.swing.JTable();
        btnLapPt = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblHoaDonPhong = new javax.swing.JTable();
        btnXoaHDP = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblThongKeHDP = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        rbtThongKeNgayP = new javax.swing.JRadioButton();
        rbtThongKeThangP = new javax.swing.JRadioButton();
        rbtThongKeNamP = new javax.swing.JRadioButton();
        btnThongKeP = new javax.swing.JButton();
        txtNamP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblHoaDonDV = new javax.swing.JTable();
        btnXoaHDDV = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblThongKeHDDV = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        txtNamDV = new javax.swing.JTextField();
        rbtThongKeNgayDV = new javax.swing.JRadioButton();
        rbtThongKeThangDV = new javax.swing.JRadioButton();
        rbtThongKeNamDV = new javax.swing.JRadioButton();
        btnThongKeDV = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTabbedPane.setBackground(new java.awt.Color(204, 204, 204));

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaKH", "TenKH", "CMND", "QuocTich", "DiaChi", "GioiTinh"
            }
        ));
        jScrollPane1.setViewportView(tblKhachHang);

        btnSuaKH.setText("Sửa KH");
        btnSuaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKHActionPerformed(evt);
            }
        });

        btnXoaKH.setText("Xoá KH");
        btnXoaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKHActionPerformed(evt);
            }
        });

        rbtTKKHThueNgay.setText("Tìm kiếm khách hàng nhận phòng vào ngày: ");

        rbtTKKHTraNgay.setText("Tìm kiếm khách hàng trả phòng vào ngày: ");

        btnTimKiemKH.setText("Tìm kiếm");
        btnTimKiemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKHActionPerformed(evt);
            }
        });

        rbtTKKHDangOtheoNgay.setText("Tìm kiếm những khách hàng đang ở khách sạn vào ngày: ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Tìm kiếm khách hàng");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtTKKHTraNgay)
                            .addComponent(rbtTKKHThueNgay)
                            .addComponent(rbtTKKHDangOtheoNgay))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNgayTra, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(txtNgayO))
                                .addGap(57, 57, 57)
                                .addComponent(btnTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNgayThue, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel12)
                .addGap(30, 30, 30)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtTKKHThueNgay)
                    .addComponent(txtNgayThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtTKKHTraNgay)
                    .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtTKKHDangOtheoNgay)
                    .addComponent(txtNgayO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        tblTKKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane16.setViewportView(tblTKKhachHang);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(btnSuaKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 408, Short.MAX_VALUE)
                .addComponent(btnXoaKH)
                .addGap(206, 206, 206))
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaKH)
                    .addComponent(btnXoaKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabKhachHangLayout = new javax.swing.GroupLayout(tabKhachHang);
        tabKhachHang.setLayout(tabKhachHangLayout);
        tabKhachHangLayout.setHorizontalGroup(
            tabKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabKhachHangLayout.setVerticalGroup(
            tabKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabKhachHangLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JTabbedPane.addTab("DSKhachHang", tabKhachHang);

        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaP", "DienTich(m2)", "DonGia", "TinhTrang"
            }
        ));
        jScrollPane2.setViewportView(tblPhong);

        btnThemP.setText("Thêm phòng");
        btnThemP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPActionPerformed(evt);
            }
        });

        btnSuaP.setText("Cập nhật tình trạng phòng");
        btnSuaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPActionPerformed(evt);
            }
        });

        btnXoaP.setText("Xoá phòng");
        btnXoaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPActionPerformed(evt);
            }
        });

        btnLapPT.setText("Lập phiếu thuê");
        btnLapPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapPTActionPerformed(evt);
            }
        });

        btnLapPDV.setText("Lập phiếu dịch vụ");
        btnLapPDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapPDVActionPerformed(evt);
            }
        });

        btnLapPDK.setText("Lập phiếu đăng ký");
        btnLapPDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapPDKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnThemP, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addComponent(btnSuaP)
                .addGap(38, 38, 38)
                .addComponent(btnXoaP)
                .addGap(76, 76, 76)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLapPDK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLapPT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLapPDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemP)
                            .addComponent(btnSuaP)
                            .addComponent(btnXoaP)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLapPDK)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLapPT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLapPDV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblTimKiem1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane11.setViewportView(tblTimKiem1);

        jLabel3.setText("Tìm kiếm phòng theo ngày");

        btnTimKiemPhong.setText("Tìm Kiếm");
        btnTimKiemPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addComponent(txtTimKiemNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnTimKiemPhong)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTimKiemNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnTimKiemPhong))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jScrollPane12.setViewportView(tblTimKiem2);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Danh sách phòng đang được thuê và phòng đã được đăng ký");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Danh sách phòng trống");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Tìm kiếm phòng");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jLabel6)
                .addGap(0, 477, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 877, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout tabPhongLayout = new javax.swing.GroupLayout(tabPhong);
        tabPhong.setLayout(tabPhongLayout);
        tabPhongLayout.setHorizontalGroup(
            tabPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabPhongLayout.setVerticalGroup(
            tabPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPhongLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTabbedPane.addTab("DSPhong", tabPhong);

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaDV", "TenDV", "DonGia"
            }
        ));
        jScrollPane3.setViewportView(tblDichVu);

        btnThemDV.setText("Thêm DV");
        btnThemDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDVActionPerformed(evt);
            }
        });

        btnSuaDV.setText("Sửa DV");
        btnSuaDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDVActionPerformed(evt);
            }
        });

        btnXoaDV.setText("Xoá DV");
        btnXoaDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(btnThemDV)
                .addGap(118, 118, 118)
                .addComponent(btnSuaDV)
                .addGap(118, 118, 118)
                .addComponent(btnXoaDV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDV)
                    .addComponent(btnSuaDV)
                    .addComponent(btnXoaDV))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout tabDichVuLayout = new javax.swing.GroupLayout(tabDichVu);
        tabDichVu.setLayout(tabDichVuLayout);
        tabDichVuLayout.setHorizontalGroup(
            tabDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
            .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabDichVuLayout.setVerticalGroup(
            tabDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDichVuLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 231, Short.MAX_VALUE))
        );

        JTabbedPane.addTab("DSDichVu", tabDichVu);

        tblPhieuDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaPDV", "MaDV", "MaP", "SoLuong", "NgaySuDung", "TrangThai"
            }
        ));
        jScrollPane5.setViewportView(tblPhieuDichVu);

        btnSuaPDV.setText("Sửa PDV");
        btnSuaPDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPDVActionPerformed(evt);
            }
        });

        btnXoaPDV.setText("Xoá PDV");
        btnXoaPDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPDVActionPerformed(evt);
            }
        });

        jLabel1.setText("Tìm kiếm PDV theo phòng");

        btnLapHDDV.setText("Lập hoá đơn DV");
        btnLapHDDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapHDDVActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("Tìm kiếm phiêu dịch vụ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPDV_P_MaP))
                .addGap(18, 18, 18)
                .addComponent(btnLapHDDV, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel11)
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPDV_P_MaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLapHDDV))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabPhieuDichVuLayout = new javax.swing.GroupLayout(tabPhieuDichVu);
        tabPhieuDichVu.setLayout(tabPhieuDichVuLayout);
        tabPhieuDichVuLayout.setHorizontalGroup(
            tabPhieuDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane5)
            .addGroup(tabPhieuDichVuLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(btnSuaPDV)
                .addGap(250, 250, 250)
                .addComponent(btnXoaPDV)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabPhieuDichVuLayout.setVerticalGroup(
            tabPhieuDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPhieuDichVuLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(tabPhieuDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaPDV)
                    .addComponent(btnXoaPDV))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );

        JTabbedPane.addTab("DSPhieuDIchVu", tabPhieuDichVu);

        tblPhieuThue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaPT", "MaKH", "MaP", "TienCoc", "Checkin", "Checkout", "TrangThai"
            }
        ));
        jScrollPane4.setViewportView(tblPhieuThue);

        btnSuaPT.setText("Sửa PT");
        btnSuaPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPTActionPerformed(evt);
            }
        });

        btnXoaPT.setText("Xoá PT");
        btnXoaPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPTActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Phòng");

        btnTimKiemPTtheoPhong.setText("Tìm kiếm");
        btnTimKiemPTtheoPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemPTtheoPhongActionPerformed(evt);
            }
        });

        jScrollPane10.setViewportView(tblTimKiemPTtheoPhong);

        btnLapHDP.setText("Lập hoá đơn phòng");
        btnLapHDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapHDPActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Tìm kiếm phiếu thuê");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(btnLapHDP))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtPT_P_MaP, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiemPTtheoPhong))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPT_P_MaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemPTtheoPhong))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLapHDP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout tabPhieuThueLayout = new javax.swing.GroupLayout(tabPhieuThue);
        tabPhieuThue.setLayout(tabPhieuThueLayout);
        tabPhieuThueLayout.setHorizontalGroup(
            tabPhieuThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(tabPhieuThueLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(btnSuaPT)
                .addGap(193, 193, 193)
                .addComponent(btnXoaPT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabPhieuThueLayout.setVerticalGroup(
            tabPhieuThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabPhieuThueLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(tabPhieuThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaPT)
                    .addComponent(btnXoaPT))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JTabbedPane.addTab("DSPhieuThue", tabPhieuThue);

        tblPhieuDangKy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaPDK", "MaKH", "MaP", "TienCoc", "NgayDangKy", "Checkin", "Checkout"
            }
        ));
        jScrollPane7.setViewportView(tblPhieuDangKy);

        btnSuaPDK.setText("Sửa");
        btnSuaPDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPDKActionPerformed(evt);
            }
        });

        btnXoaPDK.setText("Xoá");
        btnXoaPDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPDKActionPerformed(evt);
            }
        });

        rbtTimKiemNgayDK.setText("Tìm kiếm theo ngày đăng ký");

        rbtTimKiemCMND.setText("Tìm kiếm theo CMND");

        btnTimKiemPDK.setText("Tìm kiếm");
        btnTimKiemPDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemPDKActionPerformed(evt);
            }
        });

        tblTimKiemPDK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(tblTimKiemPDK);

        btnLapPt.setText("Lập phiếu thuê");
        btnLapPt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapPtActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Tìm kiếm phiếu đăng ký");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(btnLapPt))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rbtTimKiemCMND)
                                .addGap(53, 53, 53)
                                .addComponent(txtTimKiemCMND))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rbtTimKiemNgayDK)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimKiemNgayDK, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addComponent(btnTimKiemPDK, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtTimKiemNgayDK)
                            .addComponent(txtTimKiemNgayDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnTimKiemPDK)
                        .addGap(1, 1, 1)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtTimKiemCMND)
                    .addComponent(txtTimKiemCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLapPt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(btnSuaPDK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaPDK)
                .addGap(224, 224, 224))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaPDK)
                    .addComponent(btnXoaPDK))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JTabbedPane.addTab("DSPhieuDangKy", jPanel4);

        tblHoaDonPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaHDP", "MaPT", "NgayLap", "TongTien"
            }
        ));
        jScrollPane13.setViewportView(tblHoaDonPhong);

        btnXoaHDP.setText("Xóa hóa đơn");
        btnXoaHDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDPActionPerformed(evt);
            }
        });

        jScrollPane15.setViewportView(tblThongKeHDP);

        rbtThongKeNgayP.setText("Thông kê doanh thu từng ngày");

        rbtThongKeThangP.setText("Thống kê doanh thu từng tháng trong năm");

        rbtThongKeNamP.setText("Thống kê doanh thu từng năm");

        btnThongKeP.setText("Thống kê");
        btnThongKeP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKePActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(rbtThongKeThangP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNamP, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbtThongKeNgayP)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnThongKeP)
                        .addComponent(rbtThongKeNamP)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(rbtThongKeNgayP)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtThongKeThangP)
                    .addComponent(txtNamP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rbtThongKeNamP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnThongKeP)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 0));
        jLabel7.setText("Thống kê");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addComponent(jLabel7)
                .addContainerGap(424, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(31, 31, 31)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(btnXoaHDP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaHDP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JTabbedPane.addTab("DSHoaDonPhong", jPanel11);

        tblHoaDonDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaHDDV", "NgayLap", "TongTien"
            }
        ));
        jScrollPane9.setViewportView(tblHoaDonDV);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnXoaHDDV.setText("Xóa hóa đơn");
        btnXoaHDDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDDVActionPerformed(evt);
            }
        });

        jScrollPane14.setViewportView(tblThongKeHDDV);

        rbtThongKeNgayDV.setText("Thông kê doanh thu từng ngày");

        rbtThongKeThangDV.setText("Thống kê doanh thu từng tháng trong năm");

        rbtThongKeNamDV.setText("Thống kê doanh thu từng năm");

        btnThongKeDV.setText("Thống kê");
        btnThongKeDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeDVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtThongKeNamDV)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(rbtThongKeThangDV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNamDV, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rbtThongKeNgayDV)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnThongKeDV)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(rbtThongKeNgayDV)
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtThongKeThangDV)
                    .addComponent(txtNamDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rbtThongKeNamDV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnThongKeDV)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 0));
        jLabel8.setText("Thống kê");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel8)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(btnXoaHDDV, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaHDDV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JTabbedPane.addTab("DSHoaDonDV", jPanel13);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTabbedPane)
        );

        JTabbedPane.getAccessibleContext().setAccessibleName("\n");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLapPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapPTActionPerformed
        // TODO add your handling code here:
        selectedrowP = tblPhong.getSelectedRow();
        if(selectedrowP == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn phòng rồi thao tác");
        }
        else if(dsPhong.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm phòng");
        }
    
        else{
            GDPhieuThue phieuthue = new GDPhieuThue();
            phieuthue.seteditdataPhong(dsPhong.get(selectedrowP));
            phieuthue.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLapPTActionPerformed

    private void btnLapPDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapPDVActionPerformed
        // TODO add your handling code here:
        int selectedrowP = tblPhong.getSelectedRow();
        if(selectedrowP == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn phòng rồi thao tác");
        }
        else if(dsPhong.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm phòng");
        }
    
        else{
            GDPhieuDichVu GDPDV = new GDPhieuDichVu();
            GDPDV.editPDV(dsPhong.get(selectedrowP));
            GDPDV.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLapPDVActionPerformed

    private void btnSuaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKHActionPerformed
        // TODO add your handling code here:
        selectedrowKH = tblKhachHang.getSelectedRow();
        if(selectedrowKH == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn khách hàng rồi thao tác");
        }
        else if(dsKhachHang.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm khách hàng");
        }
    
        else{
            GDSuaKH GDSKH = new GDSuaKH(this, rootPaneCheckingEnabled);
            GDSKH.editDataKH(dsKhachHang.get(selectedrowKH));
            GDSKH.setVisible(true);
        }
        
    }//GEN-LAST:event_btnSuaKHActionPerformed

    private void btnLapHDDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapHDDVActionPerformed
        // TODO add your handling code here:
        
        String p = txtPDV_P_MaP.getText();
        ArrayList<PhieuDichVu> listPDV = new PhieuDichVuDAO().getListPhieuDichVu(p);
        
        if(listPDV.size() > 0){
            GDHoaDonDV GDHDDV = new GDHoaDonDV();
            GDHDDV.editThongTin(p);
            GDHDDV.setVisible(true);
            this.dispose();
        } else JOptionPane.showMessageDialog(rootPane, "Phòng "+p+" không sử dụng dịch vụ");
        
        
        
    }//GEN-LAST:event_btnLapHDDVActionPerformed

    private void btnLapHDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapHDPActionPerformed
        // TODO add your handling code here:
        selectedrowPTtheoPhong = tblTimKiemPTtheoPhong.getSelectedRow();
        if(selectedrowPTtheoPhong == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn phiếu thuê rồi thao tác");
        }
        else if(dsPhieuThueTKtheoPhong.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu tìm phiếu thuê phòng");
        }
    
        else{
            GDHoaDonPhong GDHDP = new GDHoaDonPhong();
            GDHDP.editThongTin(dsPhieuThueTKtheoPhong.get(selectedrowPTtheoPhong));
            GDHDP.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLapHDPActionPerformed

    private void btnThemPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPActionPerformed
        // TODO add your handling code here:
        GDThemPhong GDTP = new GDThemPhong(this, rootPaneCheckingEnabled);
        GDTP.setVisible(true);
    }//GEN-LAST:event_btnThemPActionPerformed

    private void btnSuaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPActionPerformed
        // TODO add your handling code here:
        selectedrowP = tblPhong.getSelectedRow();
        if(selectedrowP == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn phòng rồi thao tác");
        }
        else if(dsPhong.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm phòng");
        }
    
        else{
            GDSuaPhong GDSP = new GDSuaPhong(this, rootPaneCheckingEnabled);
            GDSP.edit(dsPhong.get(selectedrowP));
            GDSP.setVisible(true);
        }
    }//GEN-LAST:event_btnSuaPActionPerformed

    private void btnXoaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKHActionPerformed
        // TODO add your handling code here:
        selectedrowKH = tblKhachHang.getSelectedRow();
        if(selectedrowKH == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn khách hàng rồi thao tác");
        }
        else if(dsKhachHang.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm khách hàng");
        } 
        else{
            KhachHang kh = dsKhachHang.get(selectedrowKH);
            if(new KhachHangDAO().Xoa(kh)){
                dsKhachHang.remove(selectedrowKH);
                tblKhachHangMD.setRowCount(0);
                showKH();
            }else JOptionPane.showMessageDialog(rootPane, "Xoá không thành công");
            
        }
    }//GEN-LAST:event_btnXoaKHActionPerformed

    private void btnXoaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPActionPerformed
        // TODO add your handling code here:
        selectedrowP = tblPhong.getSelectedRow();
        if(selectedrowP == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn phòng rồi thao tác");
        }
        else if(dsPhong.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm phòng");
        }
    
        else{
            if(new PhongDAO().xoaPhong(dsPhong.get(selectedrowP))){
                dsPhong.remove(selectedrowP);
                tblPhongMD.setRowCount(0);
                showPhong();
            } else JOptionPane.showMessageDialog(rootPane, "Xóa phòng không thành công");
        }
    }//GEN-LAST:event_btnXoaPActionPerformed

    private void btnThemDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDVActionPerformed
        // TODO add your handling code here:
        GDThemDV GDTDV = new GDThemDV(this, rootPaneCheckingEnabled);
        GDTDV.setVisible(true);
    }//GEN-LAST:event_btnThemDVActionPerformed

    private void btnLapPDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapPDKActionPerformed
        // TODO add your handling code here:
        selectedrowP = tblPhong.getSelectedRow();
        if(selectedrowP == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn phòng rồi thao tác");     
        }
        else if(dsPhong.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm phòng");
        }
    
        else{
            GDPhieuDangKy phieudangky = new GDPhieuDangKy();
            phieudangky.seteditdataPhong(dsPhong.get(selectedrowP));
            phieudangky.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLapPDKActionPerformed

    private void btnSuaPDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPDKActionPerformed
        // TODO add your handling code here:
        selectedrowPDK = tblPhieuDangKy.getSelectedRow();
        if(selectedrowPDK == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn phiếu đăng ký rồi thao tác");
        }
        else if(dsPhieuDangKy.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm phiếu đăng ký");
        }
        else{
            GDSuaPDK GDSPDK = new GDSuaPDK(this, rootPaneCheckingEnabled);
            GDSPDK.editdata(dsPhieuDangKy.get(selectedrowPDK));
            GDSPDK.setVisible(true);
        }
    }//GEN-LAST:event_btnSuaPDKActionPerformed

    private void btnTimKiemPDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemPDKActionPerformed
        // TODO add your handling code here:
        if(rbtTimKiemNgayDK.isSelected()){
            String s = txtTimKiemNgayDK.getText();
            dsPhieuDangKyTKNgay = new PhieuDangKyDAO().getListPhieuDangKyTKNgay(s);
            tblTimKiemPDKMD.setColumnIdentifiers(new Object[]{"MaPDK","MaKH",
                "MaP","TienCoc","NgayDK","Checkin","Checkout"});
            tblTimKiemPDKMD.setRowCount(0);
            for(PhieuDangKy pdk : dsPhieuDangKyTKNgay){
                tblTimKiemPDKMD.addRow(new Object[]{pdk.getMaPDK(), pdk.getMaKH(), pdk.getMaP(),
                pdk.getTienCoc(),pdk.getNgayDK(),pdk.getCheck_in(),pdk.getCheck_out()});
            }
        }
        if(rbtTimKiemCMND.isSelected()){
            String s = txtTimKiemCMND.getText();
            dsPhieuDangKyTKCMND = new PhieuDangKyDAO().getListPhieuDangKyTKCCCD(s);
            tblTimKiemPDKMD.setColumnIdentifiers(new Object[]{"MaPDK","MaKH",
                "MaP","TienCoc","NgayDK","Checkin","Checkout"});
            tblTimKiemPDKMD.setRowCount(0);
            for(PhieuDangKy pdk : dsPhieuDangKyTKCMND){
                tblTimKiemPDKMD.addRow(new Object[]{pdk.getMaPDK(), pdk.getMaKH(), pdk.getMaP(),
                pdk.getTienCoc(),pdk.getNgayDK(),pdk.getCheck_in(),pdk.getCheck_out()});
            }
        }
    }//GEN-LAST:event_btnTimKiemPDKActionPerformed

    private void btnLapPtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapPtActionPerformed
        // TODO add your handling code here:
        selectedrowPDKTK = tblTimKiemPDK.getSelectedRow();
        if(selectedrowPDKTK == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn phiếu đăng ký cần lập");
        }
        else if(dsPhieuDangKy.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "Phiếu đăng ký trống");
        }
    
        else{
            
            if(rbtTimKiemCMND.isSelected()){
                GDThemPT GDTPT = new GDThemPT(this, rootPaneCheckingEnabled);
                GDTPT.seteditdataPDK(dsPhieuDangKyTKCMND.get(selectedrowPDKTK));
                GDTPT.setVisible(true);
            }
            if(rbtTimKiemNgayDK.isSelected()){
                GDThemPT GDTPT = new GDThemPT(this, rootPaneCheckingEnabled);
                GDTPT.seteditdataPDK(dsPhieuDangKyTKNgay.get(selectedrowPDKTK));
                GDTPT.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnLapPtActionPerformed

    private void btnXoaPDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPDKActionPerformed
        // TODO add your handling code here:
        selectedrowPDK = tblPhieuDangKy.getSelectedRow();
        if(selectedrowPDK == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn phiếu đăng ký cần lập");
        }
        else if(dsPhieuDangKy.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "Phiếu đăng ký trống");
        }
        else{
            if(new PhieuDangKyDAO().XoaPDK(dsPhieuDangKy.get(selectedrowPDK))){
                dsPhieuDangKy.remove(selectedrowPDK);
                tblPhieuDangKyMD.setRowCount(0);
                showPDK();
            }
            else JOptionPane.showMessageDialog(rootPane, "Xoá phiếu đăng ký không thành công");
        }
             
                
    }//GEN-LAST:event_btnXoaPDKActionPerformed

    private void btnSuaDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDVActionPerformed
        // TODO add your handling code here:
        selectedrowDV = tblDichVu.getSelectedRow();
        if(selectedrowDV == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn dịch vụ rồi thao tác");
        }
        else if(dsDichVu.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm dịch vụ");
        }
    
        else{
            GDSuaDV GDSDV = new GDSuaDV(this, rootPaneCheckingEnabled);
            GDSDV.editDataDV(dsDichVu.get(selectedrowDV));
            GDSDV.setVisible(true);
        }
    }//GEN-LAST:event_btnSuaDVActionPerformed

    private void btnXoaDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDVActionPerformed
        // TODO add your handling code here:
        selectedrowDV = tblDichVu.getSelectedRow();
        if(selectedrowDV == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn dịch vụ rồi thao tác");
        }
        else if(dsDichVu.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm dịch vụ");
        }
        else{
            if(new DichVuDAO().xoaDV(dsDichVu.get(selectedrowDV))){
                JOptionPane.showMessageDialog(rootPane, "Xoá thành công");
                xoaDV(selectedrowDV);
            } else JOptionPane.showMessageDialog(rootPane, "Xoá không thành công");
        }
    }//GEN-LAST:event_btnXoaDVActionPerformed

    private void btnTimKiemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemPhongActionPerformed
        // TODO add your handling code here:

        String s = txtTimKiemNgay.getText().trim();
        //dsPhieuThueTK = new PhieuThueDAO().getListPhieuThueTK(s);
        dsPhieuTruyVanTK = new PhieuTruyVanDAO().getListPhieuTruyVanTK(s);
        tblTimKiem1MD.setColumnIdentifiers(new Object[]{"MaP",
                "PT_Checkin", "PT_Checkout", "PDK_Checkin", "PDK_Checkout"});
        tblTimKiem1MD.setRowCount(0);
        for(PhieuTruyVan ptv : dsPhieuTruyVanTK){
            tblTimKiem1MD.addRow(new Object[]{ptv.getMaP(),
                ptv.getNgay_checkin(), ptv.getNgay_checkout(),
                ptv.getCheck_in(), ptv.getCheck_out()});
        }
        dsPhongTrongTK = new PhieuTruyVanDAO().getListPhieuTruyVanTKTrong(s);
        tblTimKiem2MD.setColumnIdentifiers(new Object[]{"MaP"});
        tblTimKiem2MD.setRowCount(0);
        for(Phong p : dsPhongTrongTK){
            tblTimKiem2MD.addRow(new Object[]{p.getMaP()});
        }

    }//GEN-LAST:event_btnTimKiemPhongActionPerformed

    private void btnTimKiemPTtheoPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemPTtheoPhongActionPerformed
        // TODO add your handling code here:
        String s = txtPT_P_MaP.getText();
        dsPhieuThueTKtheoPhong = new PhieuThueDAO().getListPhieuThueTKPhong(s);
        tblTimKiemPTtheoPhongMD.setColumnIdentifiers(new Object[]{"MaPT", "MaKH", 
            "MaP", "TienCoc", "Checkin", "Checkout", "TrangThai"});
        tblTimKiemPTtheoPhongMD.setRowCount(0);
        for(PhieuThue pt : dsPhieuThueTKtheoPhong){
            tblTimKiemPTtheoPhongMD.addRow(new Object[]{pt.getMaPT(), pt.getMaKH(), 
                pt.getMaP(), pt.getTienCoc(), pt.getNgay_checkin(), pt.getNgay_checkout(), pt.getTrangThai()});
        }
    }//GEN-LAST:event_btnTimKiemPTtheoPhongActionPerformed

    private void btnSuaPDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPDVActionPerformed
        // TODO add your handling code here:
        selectedrowPDV = tblPhieuDichVu.getSelectedRow();
        if(selectedrowPDV == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn phiếu dịch vụ rồi thao tác");
        }
        else if(dsPhieuDichVu.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm phiếu dịch vụ");
        }
    
        else{
            GDSuaPDV GDSPDV = new GDSuaPDV(this, rootPaneCheckingEnabled);
            GDSPDV.editDataPDV(dsPhieuDichVu.get(selectedrowPDV));
            GDSPDV.setVisible(true);
        }
    }//GEN-LAST:event_btnSuaPDVActionPerformed

    private void btnXoaPDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPDVActionPerformed
        // TODO add your handling code here:
        selectedrowPDV = tblPhieuDichVu.getSelectedRow();
        if(selectedrowPDV == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn phiếu dịch vụ rồi thao tác");
        }
        else if(dsPhieuDichVu.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm phiếu dịch vụ");
        }
    
        else{
            if(new PhieuDichVuDAO().xoaPDV(dsPhieuDichVu.get(selectedrowPDV))){
                dsPhieuDichVu.remove(selectedrowPDV);
                tblPhieuDichVuMD.setRowCount(0);
                showPDV();
            }else JOptionPane.showMessageDialog(rootPane, "Xóa phiếu dịch vụ không thành công");
        }
    }//GEN-LAST:event_btnXoaPDVActionPerformed

    private void btnSuaPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPTActionPerformed
        // TODO add your handling code here:
        selectedrowPT = tblPhieuThue.getSelectedRow();
        if(selectedrowPT == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn phiếu thuê rồi thao tác");
        }
        else if(dsPhieuThue.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm phiếu thuê");
        }
    
        else{
            GDSuaPhieuThue GDSPT = new GDSuaPhieuThue(this, rootPaneCheckingEnabled);
            GDSPT.editdata(dsPhieuThue.get(selectedrowPT));
            GDSPT.setVisible(true);
        }
    }//GEN-LAST:event_btnSuaPTActionPerformed

    private void btnXoaPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPTActionPerformed
        // TODO add your handling code here:
        selectedrowPT = tblPhieuThue.getSelectedRow();
        if(selectedrowPT == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn phiếu thuê rồi thao tác");
        }
        else if(dsPhieuThue.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm phiếu thuê");
        }
    
        else{
            if(new PhieuThueDAO().xoaPT(dsPhieuThue.get(selectedrowPT))){
                dsPhieuThue.remove(selectedrowPT);
                tblPhieuThueMD.setRowCount(0);
                showPT();
            }else JOptionPane.showMessageDialog(rootPane, "Xóa phiếu thuê không thành công");
        }
    }//GEN-LAST:event_btnXoaPTActionPerformed

    private void btnThongKePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKePActionPerformed
        // TODO add your handling code here:
        if(rbtThongKeNgayP.isSelected()){
            txtNamP.setText("");
            txtNamDV.setText("");
            dsThongKeHDPtheoNgay = new HoaDonPhongDAO().getListThongKeHDPtheoNgay();
            tblThongKeHDPMD.setColumnIdentifiers(new Object[]{"Ngày", "Doanh thu"});
            tblThongKeHDPMD.setRowCount(0);
            for(HoaDonPhong hdp : dsThongKeHDPtheoNgay){
                tblThongKeHDPMD.addRow(new Object[]{hdp.getNgayLap(), hdp.getTongTien()});
            }
        }
        if(rbtThongKeThangP.isSelected()){
            txtNamDV.setText("");
            String s = txtNamP.getText();
            dsThongKeHDPtheoThang = new HoaDonPhongDAO().getListThongKeHDPtheoThang(s);
            tblThongKeHDPMD.setColumnIdentifiers(new Object[]{"Tháng", "Doanh thu"});
            tblThongKeHDPMD.setRowCount(0);
            for(HoaDonPhong hdp : dsThongKeHDPtheoThang){
                tblThongKeHDPMD.addRow(new Object[]{hdp.getMaHDP(), hdp.getTongTien()});
            }
        }
        if(rbtThongKeNamP.isSelected()){
            txtNamP.setText("");
            txtNamDV.setText("");
            dsThongKeHDPtheoNam = new HoaDonPhongDAO().getListThongKeHDPtheoNam();
            tblThongKeHDPMD.setColumnIdentifiers(new Object[]{"Năm", "Doanh thu"});
            tblThongKeHDPMD.setRowCount(0);
            for(HoaDonPhong hdp : dsThongKeHDPtheoNam){
                tblThongKeHDPMD.addRow(new Object[]{hdp.getMaHDP(), hdp.getTongTien()});
            }
        }
    }//GEN-LAST:event_btnThongKePActionPerformed

    private void btnThongKeDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeDVActionPerformed
        // TODO add your handling code here:
        if(rbtThongKeNgayDV.isSelected()){
            txtNamDV.setText("");
            txtNamP.setText("");
            dsThongKeHDDVtheoNgay = new HoaDonDVDAO().getListThongKeHDDVtheoNgay();
            tblThongKeHDDVMD.setColumnIdentifiers(new Object[]{"Ngày", "Doanh thu"});
            tblThongKeHDDVMD.setRowCount(0);
            for(HoaDonDV hddv : dsThongKeHDDVtheoNgay){
                tblThongKeHDDVMD.addRow(new Object[]{hddv.getNgayLap(), hddv.getTongTien()});
            }
        }
        if(rbtThongKeThangDV.isSelected()){
            txtNamP.setText("");
            String s = txtNamDV.getText();
            dsThongKeHDDVtheoThang = new HoaDonDVDAO().getListThongKeHDDVtheoThang(s);
            tblThongKeHDDVMD.setColumnIdentifiers(new Object[]{"Tháng", "Doanh thu"});
            tblThongKeHDDVMD.setRowCount(0);
            for(HoaDonDV hddv : dsThongKeHDDVtheoThang){
                tblThongKeHDDVMD.addRow(new Object[]{hddv.getMaHDDV(), hddv.getTongTien()});
            }
        }
        if(rbtThongKeNamDV.isSelected()){
            txtNamDV.setText("");
            txtNamP.setText("");
            dsThongKeHDDVtheoNam = new HoaDonDVDAO().getListThongKeHDDVtheoNam();
            tblThongKeHDDVMD.setColumnIdentifiers(new Object[]{"Năm", "Doanh thu"});
            tblThongKeHDDVMD.setRowCount(0);
            for(HoaDonDV hddv : dsThongKeHDDVtheoNam){
                tblThongKeHDDVMD.addRow(new Object[]{hddv.getMaHDDV(), hddv.getTongTien()});
            }
        }
    }//GEN-LAST:event_btnThongKeDVActionPerformed

    private void btnXoaHDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDPActionPerformed
        // TODO add your handling code here:
        selectedrowHDP = tblHoaDonPhong.getSelectedRow();
        if(selectedrowHDP == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hóa đơn rồi thao tác");
        }
        else if(dsHoaDonPhong.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm hóa đơn");
        }
    
        else{
            if(new HoaDonPhongDAO().xoaHDP(dsHoaDonPhong.get(selectedrowHDP))){
                dsHoaDonPhong.remove(selectedrowHDP);
                tblHoaDonPhongMD.setRowCount(0);
                showHDP();
            }else JOptionPane.showMessageDialog(rootPane, "Xóa hóa đơn không thành công");
        }
    }//GEN-LAST:event_btnXoaHDPActionPerformed

    private void btnXoaHDDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDDVActionPerformed
        // TODO add your handling code here:
        selectedrowHDDV = tblHoaDonDV.getSelectedRow();
        if(selectedrowHDDV == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn hóa đơn rồi thao tác");
        }
        else if(dsHoaDonDV.size()==0) {
            JOptionPane.showMessageDialog(rootPane, "yêu cầu thêm hóa đơn");
        }
    
        else{
            if(new HoaDonDVDAO().xoaHDDV(dsHoaDonDV.get(selectedrowHDDV))){
                dsHoaDonDV.remove(selectedrowHDDV);
                tblHoaDonDVMD.setRowCount(0);
                showHDDV();
            }else JOptionPane.showMessageDialog(rootPane, "Xóa hóa đơn không thành công");
        }
    }//GEN-LAST:event_btnXoaHDDVActionPerformed

    private void btnTimKiemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKHActionPerformed
        // TODO add your handling code here:
        if(rbtTKKHThueNgay.isSelected()){
            txtNgayTra.setText("");
            txtNgayO.setText("");
            String s = txtNgayThue.getText();
            dsTKKHThueNgay = new KhachHangDAO().getListTKKHThueNgay(s);
            tblTKKhachHangMD.setColumnIdentifiers(new Object[]{"MaKH", "TenKH", 
                "CMND", "DiaChi", "QuocTich", "GioiTinh"});
            tblTKKhachHangMD.setRowCount(0);
            for(KhachHang kh : dsTKKHThueNgay){
                tblTKKhachHangMD.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), 
                    kh.getCMND(), kh.getDiaChi(), kh.getQuocTich(), kh.getGioiTinh()});
            }
        }
        if(rbtTKKHTraNgay.isSelected()){
            txtNgayThue.setText("");
            txtNgayO.setText("");
            String s = txtNgayTra.getText();
            dsTKKHTraNgay = new KhachHangDAO().getListTKKHTraNgay(s);
            tblTKKhachHangMD.setColumnIdentifiers(new Object[]{"MaKH", "TenKH", 
                "CMND", "DiaChi", "QuocTich", "GioiTinh"});
            tblTKKhachHangMD.setRowCount(0);
            for(KhachHang kh : dsTKKHTraNgay){
                tblTKKhachHangMD.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), 
                    kh.getCMND(), kh.getDiaChi(), kh.getQuocTich(), kh.getGioiTinh()});
            }
        }
        if(rbtTKKHDangOtheoNgay.isSelected()){
            txtNgayThue.setText("");
            txtNgayTra.setText("");
            String s = txtNgayO.getText();
            dsTKKHDangO = new KhachHangDAO().getListTKKHDangO(s);
            tblTKKhachHangMD.setColumnIdentifiers(new Object[]{"MaKH", "TenKH", 
                "CMND", "DiaChi", "QuocTich", "GioiTinh"});
            tblTKKhachHangMD.setRowCount(0);
            for(KhachHang kh : dsTKKHDangO){
                tblTKKhachHangMD.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), 
                    kh.getCMND(), kh.getDiaChi(), kh.getQuocTich(), kh.getGioiTinh()});
            }
        }
    }//GEN-LAST:event_btnTimKiemKHActionPerformed
    
    
    
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
            java.util.logging.Logger.getLogger(GDTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GDTrangChu().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTabbedPane;
    private javax.swing.JButton btnLapHDDV;
    private javax.swing.JButton btnLapHDP;
    private javax.swing.JButton btnLapPDK;
    private javax.swing.JButton btnLapPDV;
    private javax.swing.JButton btnLapPT;
    private javax.swing.JButton btnLapPt;
    private javax.swing.JButton btnSuaDV;
    private javax.swing.JButton btnSuaKH;
    private javax.swing.JButton btnSuaP;
    private javax.swing.JButton btnSuaPDK;
    private javax.swing.JButton btnSuaPDV;
    private javax.swing.JButton btnSuaPT;
    private javax.swing.JButton btnThemDV;
    private javax.swing.JButton btnThemP;
    private javax.swing.JButton btnThongKeDV;
    private javax.swing.JButton btnThongKeP;
    private javax.swing.JButton btnTimKiemKH;
    private javax.swing.JButton btnTimKiemPDK;
    private javax.swing.JButton btnTimKiemPTtheoPhong;
    private javax.swing.JButton btnTimKiemPhong;
    private javax.swing.JButton btnXoaDV;
    private javax.swing.JButton btnXoaHDDV;
    private javax.swing.JButton btnXoaHDP;
    private javax.swing.JButton btnXoaKH;
    private javax.swing.JButton btnXoaP;
    private javax.swing.JButton btnXoaPDK;
    private javax.swing.JButton btnXoaPDV;
    private javax.swing.JButton btnXoaPT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbtTKKHDangOtheoNgay;
    private javax.swing.JRadioButton rbtTKKHThueNgay;
    private javax.swing.JRadioButton rbtTKKHTraNgay;
    private javax.swing.JRadioButton rbtThongKeNamDV;
    private javax.swing.JRadioButton rbtThongKeNamP;
    private javax.swing.JRadioButton rbtThongKeNgayDV;
    private javax.swing.JRadioButton rbtThongKeNgayP;
    private javax.swing.JRadioButton rbtThongKeThangDV;
    private javax.swing.JRadioButton rbtThongKeThangP;
    private javax.swing.JRadioButton rbtTimKiemCMND;
    private javax.swing.JRadioButton rbtTimKiemNgayDK;
    private javax.swing.JPanel tabDichVu;
    private javax.swing.JPanel tabKhachHang;
    private javax.swing.JPanel tabPhieuDichVu;
    private javax.swing.JPanel tabPhieuThue;
    private javax.swing.JPanel tabPhong;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblHoaDonDV;
    private javax.swing.JTable tblHoaDonPhong;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblPhieuDangKy;
    private javax.swing.JTable tblPhieuDichVu;
    private javax.swing.JTable tblPhieuThue;
    private javax.swing.JTable tblPhong;
    private javax.swing.JTable tblTKKhachHang;
    private javax.swing.JTable tblThongKeHDDV;
    private javax.swing.JTable tblThongKeHDP;
    private javax.swing.JTable tblTimKiem1;
    private javax.swing.JTable tblTimKiem2;
    private javax.swing.JTable tblTimKiemPDK;
    private javax.swing.JTable tblTimKiemPTtheoPhong;
    private javax.swing.JTextField txtNamDV;
    private javax.swing.JTextField txtNamP;
    private javax.swing.JTextField txtNgayO;
    private javax.swing.JTextField txtNgayThue;
    private javax.swing.JTextField txtNgayTra;
    private javax.swing.JTextField txtPDV_P_MaP;
    private javax.swing.JTextField txtPT_P_MaP;
    private javax.swing.JTextField txtTimKiemCMND;
    private javax.swing.JTextField txtTimKiemNgay;
    private javax.swing.JTextField txtTimKiemNgayDK;
    // End of variables declaration//GEN-END:variables

    void ThemKH(KhachHang kh) {
        dsKhachHang.add(kh);
        tblKhachHangMD.setRowCount(0);
        showKH();
    }
    
    void CapNhatKH(KhachHang kh) {
        dsKhachHang.remove(selectedrowKH);
        ThemKH(kh);
    }
    
    void showKH(){
        for(KhachHang khachhang : dsKhachHang){
            tblKhachHangMD.addRow(new Object[]{khachhang.getMaKH(),
                khachhang.getTenKH(), khachhang.getCMND() ,khachhang.getQuocTich(), 
                khachhang.getDiaChi(), khachhang.getGioiTinh()});
        }
    }

    void ThemPhong(Phong p) {
        dsPhong.add(p);
        tblPhongMD.setRowCount(0);
        showPhong();
    }
    void showPhong(){
        for(Phong P : dsPhong){
            tblPhongMD.addRow(new Object[]{P.getMaP(), P.getDienTich(), 
                P.getDonGia(), P.getTinhTrang()});
        }
    }
    
    void updatePhong(Phong p) {
        if(new PhongDAO().update(p.getTinhTrang(), p.getMaP() )){
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
            dsPhong.remove(selectedrowP);
            ThemPhong(p);
        }
    }
    
    
    void ThemPT(PhieuThue phieuthue) {
        dsPhieuThue.add(phieuthue);
        tblPhieuThueMD.setRowCount(0);
        showPT();
    }
    
    void updatePT(PhieuThue phieuthue) {
        dsPhieuThue.remove(selectedrowPT);
        ThemPT(phieuthue);
    }
    
    void updateTrangThaiPT(String maPT) {
        new PhieuThueDAO().updateTrangThaiPT(maPT);
    }
    
    void showPT(){
        for(PhieuThue pt : dsPhieuThue){
            tblPhieuThueMD.addRow(new Object[]{pt.getMaPT(), pt.getMaKH(), 
                pt.getMaP(), pt.getTienCoc(), pt.getNgay_checkin(), pt.getNgay_checkout(), pt.getTrangThai()});
        }
    }

    void themDV(DichVu dv) {
        dsDichVu.add(dv);
        tblDichVuMD.setRowCount(0);
        showDV();
    }
    
    void updateDV(DichVu dv) {
        dsDichVu.remove(selectedrowDV);
        themDV(dv);
    }
    
    private void xoaDV(int s) {
        dsDichVu.remove(s);
        tblDichVuMD.setRowCount(0);
        showDV();
    }

    private void showDV() {
        for(DichVu dv : dsDichVu){
            tblDichVuMD.addRow(new Object[]{dv.getMaDV(), dv.getTenDV(), dv.getDonGia()});
        }
    }

    void ThemPDK(PhieuDangKy phieudangky) {
        dsPhieuDangKy.add(phieudangky);
        tblPhieuDangKyMD.setRowCount(0);
        showPDK();
    }
    
    void updatePDK() {
        String t1,t2;
        if(rbtTimKiemNgayDK.isSelected()){
            PhieuDangKy pdk = dsPhieuDangKyTKNgay.get(selectedrowPDKTK);
            
            if(new PhieuDangKyDAO().XoaPDK(pdk)){
                int count = 0;
                t1 = pdk.toString();
                dsPhieuDangKyTKNgay.remove(selectedrowPDKTK);
                tblTimKiemPDKMD.setRowCount(0);
                for(PhieuDangKy Pdk : dsPhieuDangKyTKNgay){
                    tblTimKiemPDKMD.addRow(new Object[]{Pdk.getMaPDK(), Pdk.getMaKH(), 
                        Pdk.getMaP(), Pdk.getTienCoc(), Pdk.getNgayDK(), Pdk.getCheck_in(), Pdk.getCheck_out()});
                }
                for(PhieuDangKy Pdk : dsPhieuDangKy){
                    t2 = Pdk.toString();
                    if(t1.equals(t2)){
                        dsPhieuDangKy.remove(count);
                        break;
                    }
                    count++;
                }
                
                tblPhieuDangKyMD.setRowCount(0);
                showPDK();
                
                
            } else JOptionPane.showMessageDialog(rootPane, "Xoá không thành công");
        }
        if(rbtTimKiemCMND.isSelected()){
            PhieuDangKy pdk = dsPhieuDangKyTKCMND.get(selectedrowPDKTK);
            
            if(new PhieuDangKyDAO().XoaPDK(pdk)){
                int count = 0;
                t1 = pdk.toString();
                dsPhieuDangKyTKCMND.remove(selectedrowPDKTK);
                tblTimKiemPDKMD.setRowCount(0);
                for(PhieuDangKy Pdk : dsPhieuDangKyTKCMND){
                    tblTimKiemPDKMD.addRow(new Object[]{Pdk.getMaPDK(), Pdk.getMaKH(), 
                        Pdk.getMaP(), Pdk.getTienCoc(), Pdk.getNgayDK(), Pdk.getCheck_in(), Pdk.getCheck_out()});
                }
                for(PhieuDangKy Pdk : dsPhieuDangKy){
                    t2 = Pdk.toString();
                    if(t1.equals(t2)){
                        dsPhieuDangKy.remove(count);
                        break;
                    }
                    count++;
                }
                
                tblPhieuDangKyMD.setRowCount(0);
                showPDK();   
            } else JOptionPane.showMessageDialog(rootPane, "Xoá không thành công");
        } 
    }
    
    void updatePDK(PhieuDangKy phieudangky) {
        dsPhieuDangKy.remove(selectedrowPDK);
        ThemPDK(phieudangky);
    }
    
    void showPDK(){
        for(PhieuDangKy pdk : dsPhieuDangKy){
            tblPhieuDangKyMD.addRow(new Object[]{pdk.getMaPDK(), pdk.getMaKH(), 
                pdk.getMaP(), pdk.getTienCoc(), pdk.getNgayDK(), pdk.getCheck_in(), pdk.getCheck_out()});
        }
    }

    void ThemPDV(PhieuDichVu pdv) {
        dsPhieuDichVu.add(pdv);
        tblPhieuDichVuMD.setRowCount(0);
        showPDV();
    }
    
    void updatePDV(String maHDDV) {
        new PhieuDichVuDAO().updateTrangThaiPDV(maHDDV);
    }
    
    void updatePDV(PhieuDichVu pdv) {
       dsPhieuDichVu.remove(selectedrowPDV);
       ThemPDV(pdv);
    }
    
    void showPDV(){
        for(PhieuDichVu Pdv : dsPhieuDichVu){
            tblPhieuDichVuMD.addRow(new Object[]{Pdv.getMaHDDV(), Pdv.getMaDV(), Pdv.getMaP(), 
                Pdv.getSoLuong(), Pdv.getNgaySuDung(), Pdv.getTrangThai()});
            } 
    }

    private void showHDP() {
        for(HoaDonPhong hdp : dsHoaDonPhong){
            tblHoaDonPhongMD.addRow(new Object[]{hdp.getMaHDP(), hdp.getMaPT(),
                hdp.getNgayLap(), hdp.getTongTien()});
        }
    }

    private void showHDDV() {
        for(HoaDonDV hddv : dsHoaDonDV){
            tblHoaDonDVMD.addRow(new Object[]{hddv.getMaHDDV(), hddv.getNgayLap(), hddv.getTongTien()});
        }
    }

    

    
    
}
