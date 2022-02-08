package bankacilik;

import static bankacilik.Login.A;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;

class HeaderColor extends DefaultTableCellRenderer {

    public HeaderColor() {
        setOpaque(true);
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        setBackground(new java.awt.Color(12, 63, 122));
        return this;
    }

}

public class MusteriEkran extends javax.swing.JFrame {

    Musteri m1;

    public MusteriEkran(Musteri m1) throws IOException {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/bank.png")).getImage());
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Emin Bank");
        this.m1 = m1;
        kredilerTbl.getTableHeader().setDefaultRenderer(new HeaderColor());
        hesaplarTbl.getTableHeader().setDefaultRenderer(new HeaderColor());
        kartlarTbl.getTableHeader().setDefaultRenderer(new HeaderColor());
        gecmisTbl.getTableHeader().setDefaultRenderer(new HeaderColor());
        hesaplarimPnl.setVisible(false);
        kullaniciPnl.setVisible(false);
        kartlarPnl.setVisible(false);
        basvurularPnl.setVisible(false);
        kredilerPnl.setVisible(false);
        faturaPnl.setVisible(false);
        gecmisPnl.setVisible(false);
        tclbl.setText("T.C. Kimlik No: " + m1.getTc());
        adlbl.setText("Ad: " + m1.getAd());
        soyadlbl.setText("Soyad: " + m1.getSoyad());
        emaillbl.setText("E-mail: " + m1.getEmail());
        dglbl.setText("Doğum tarihi: " + m1.getDgmgn());
        tellbl.setText("Telefon: " + m1.getTel());
        girisLbl.setText(m1.getAd() + " " + m1.getSoyad());
        toplamBak.setText("0");
        yenileBtn.setVisible(false);
        sethesaplarTbl(m1, hesaplarTbl);
        tablodoldur();
        setkredilerTbl(m1, kredilerTbl);
        kreditablodoldur();
        setkredikartlariTbl(m1, kartlarTbl);
        kartlartablodoldur();
        hesapSayiLbl.setText("Hesap Sayınız: " + String.valueOf(m1.hesaplar.size()));
        krediKartiSayiLbl.setText("Kredi Kartı Sayınız: " + String.valueOf(m1.kartno.size()));
        for (int i = 0; i < m1.bakiye.size(); i++) {
            toplamBak.setText(String.valueOf(Double.valueOf(toplamBak.getText()) + Double.valueOf(m1.bakiye.get(i))));
        }
        toplamBak.setText("Toplam Bakiyeniz: " + toplamBak.getText());
        jScrollPane1.getViewport().setBackground(new Color(23, 23, 26));
        jScrollPane2.getViewport().setBackground(new Color(23, 23, 26));
        jScrollPane5.getViewport().setBackground(new Color(23, 23, 26));
        jScrollPane4.getViewport().setBackground(new Color(23, 23, 26));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hesaplarimPnl = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        hesaplarTbl = new javax.swing.JTable();
        paraGonderBtn = new javax.swing.JButton();
        paraYatirBtn = new javax.swing.JButton();
        paraCekBtn = new javax.swing.JButton();
        kredilerPnl = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        kredilerTbl = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        kartlarPnl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        kartlarTbl = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        gecmisPnl = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        gecmisTbl = new javax.swing.JTable();
        basvurularPnl = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        faturaPnl = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        kullaniciPnl = new javax.swing.JPanel();
        telDegisBtn = new javax.swing.JButton();
        maildegisBtn = new javax.swing.JButton();
        sifredegisBtn = new javax.swing.JButton();
        dglbl = new javax.swing.JLabel();
        emaillbl = new javax.swing.JLabel();
        soyadlbl = new javax.swing.JLabel();
        tellbl = new javax.swing.JLabel();
        adlbl = new javax.swing.JLabel();
        tclbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        kullaniciBtn = new javax.swing.JLabel();
        hesaplarimBtn = new javax.swing.JLabel();
        kredilerimBtn = new javax.swing.JLabel();
        kredikartlarimBtn = new javax.swing.JLabel();
        basvurularBtn = new javax.swing.JLabel();
        faturaBtn = new javax.swing.JLabel();
        yenileBtn = new javax.swing.JButton();
        hesapGecmisBtn = new javax.swing.JLabel();
        girisPnl = new javax.swing.JPanel();
        girisLbl = new javax.swing.JLabel();
        toplamBak = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        hesapSayiLbl = new javax.swing.JLabel();
        krediKartiSayiLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 550));
        getContentPane().setLayout(null);

        hesaplarimPnl.setBackground(new java.awt.Color(51, 51, 51));
        hesaplarimPnl.setOpaque(false);
        hesaplarimPnl.setLayout(null);

        jScrollPane2.setBackground(new java.awt.Color(23, 23, 26));

        hesaplarTbl.setBackground(new java.awt.Color(23, 23, 26));
        hesaplarTbl.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        hesaplarTbl.setForeground(new java.awt.Color(255, 255, 255));
        hesaplarTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Hesap Adı", "Hesap Numarası", "Hesap Türü", "Bakiye"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hesaplarTbl.setGridColor(new java.awt.Color(12, 63, 122));
        hesaplarTbl.setOpaque(false);
        hesaplarTbl.setSelectionBackground(new java.awt.Color(29, 121, 212));
        hesaplarTbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        hesaplarTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        hesaplarTbl.setShowGrid(true);
        hesaplarTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(hesaplarTbl);
        if (hesaplarTbl.getColumnModel().getColumnCount() > 0) {
            hesaplarTbl.getColumnModel().getColumn(0).setPreferredWidth(5);
            hesaplarTbl.getColumnModel().getColumn(1).setPreferredWidth(100);
            hesaplarTbl.getColumnModel().getColumn(2).setPreferredWidth(135);
            hesaplarTbl.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        hesaplarimPnl.add(jScrollPane2);
        jScrollPane2.setBounds(30, 10, 930, 260);

        paraGonderBtn.setBackground(new java.awt.Color(12, 63, 122));
        paraGonderBtn.setForeground(new java.awt.Color(255, 255, 255));
        paraGonderBtn.setText("Seçili hesaptan para gönder");
        paraGonderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paraGonderBtnActionPerformed(evt);
            }
        });
        hesaplarimPnl.add(paraGonderBtn);
        paraGonderBtn.setBounds(50, 280, 260, 30);

        paraYatirBtn.setBackground(new java.awt.Color(12, 63, 122));
        paraYatirBtn.setForeground(new java.awt.Color(255, 255, 255));
        paraYatirBtn.setText("Seçili hesaba para yatır");
        paraYatirBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paraYatirBtnMousePressed(evt);
            }
        });
        paraYatirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paraYatirBtnActionPerformed(evt);
            }
        });
        hesaplarimPnl.add(paraYatirBtn);
        paraYatirBtn.setBounds(350, 280, 260, 30);

        paraCekBtn.setBackground(new java.awt.Color(12, 63, 122));
        paraCekBtn.setForeground(new java.awt.Color(255, 255, 255));
        paraCekBtn.setText("Seçili hesaptan para çek");
        paraCekBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paraCekBtnMousePressed(evt);
            }
        });
        hesaplarimPnl.add(paraCekBtn);
        paraCekBtn.setBounds(660, 280, 260, 30);

        getContentPane().add(hesaplarimPnl);
        hesaplarimPnl.setBounds(10, 110, 980, 430);

        kredilerPnl.setOpaque(false);
        kredilerPnl.setLayout(null);

        jScrollPane4.setBackground(new java.awt.Color(102, 102, 255));

        kredilerTbl.setBackground(new java.awt.Color(23, 23, 26));
        kredilerTbl.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        kredilerTbl.setForeground(new java.awt.Color(255, 255, 255));
        kredilerTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Kredi Miktarı", "Kalan Borç", "Son Borç Kapatma Tarihi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        kredilerTbl.setGridColor(new java.awt.Color(12, 63, 122));
        kredilerTbl.setMaximumSize(new java.awt.Dimension(335, 80));
        kredilerTbl.setMinimumSize(new java.awt.Dimension(335, 80));
        kredilerTbl.setSelectionBackground(new java.awt.Color(29, 121, 212));
        kredilerTbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        kredilerTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        kredilerTbl.setShowGrid(true);
        kredilerTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(kredilerTbl);
        if (kredilerTbl.getColumnModel().getColumnCount() > 0) {
            kredilerTbl.getColumnModel().getColumn(0).setResizable(false);
            kredilerTbl.getColumnModel().getColumn(0).setPreferredWidth(35);
            kredilerTbl.getColumnModel().getColumn(1).setResizable(false);
            kredilerTbl.getColumnModel().getColumn(1).setPreferredWidth(100);
            kredilerTbl.getColumnModel().getColumn(2).setResizable(false);
            kredilerTbl.getColumnModel().getColumn(2).setPreferredWidth(100);
            kredilerTbl.getColumnModel().getColumn(3).setResizable(false);
            kredilerTbl.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        kredilerPnl.add(jScrollPane4);
        jScrollPane4.setBounds(0, 0, 930, 200);

        jButton4.setBackground(new java.awt.Color(12, 63, 122));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Seçili kredi borcunu öde");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        kredilerPnl.add(jButton4);
        jButton4.setBounds(360, 250, 220, 30);

        getContentPane().add(kredilerPnl);
        kredilerPnl.setBounds(40, 120, 930, 310);

        kartlarPnl.setBackground(new java.awt.Color(51, 51, 51));
        kartlarPnl.setOpaque(false);
        kartlarPnl.setPreferredSize(new java.awt.Dimension(1000, 550));
        kartlarPnl.setLayout(null);

        jScrollPane1.setOpaque(false);

        kartlarTbl.setBackground(new java.awt.Color(23, 23, 26));
        kartlarTbl.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        kartlarTbl.setForeground(new java.awt.Color(255, 255, 255));
        kartlarTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Kart Adı", "Kart Numarası", "Kart SKT", "Kart Limiti", "Kalan Bakiye", "Kart CVV", "Kart Ekstre Tarihi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        kartlarTbl.setGridColor(new java.awt.Color(12, 63, 122));
        kartlarTbl.setSelectionBackground(new java.awt.Color(29, 121, 212));
        kartlarTbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        kartlarTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        kartlarTbl.setShowGrid(true);
        kartlarTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(kartlarTbl);
        kartlarTbl.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (kartlarTbl.getColumnModel().getColumnCount() > 0) {
            kartlarTbl.getColumnModel().getColumn(0).setResizable(false);
            kartlarTbl.getColumnModel().getColumn(0).setPreferredWidth(35);
            kartlarTbl.getColumnModel().getColumn(1).setResizable(false);
            kartlarTbl.getColumnModel().getColumn(1).setPreferredWidth(120);
            kartlarTbl.getColumnModel().getColumn(2).setResizable(false);
            kartlarTbl.getColumnModel().getColumn(2).setPreferredWidth(125);
            kartlarTbl.getColumnModel().getColumn(3).setResizable(false);
            kartlarTbl.getColumnModel().getColumn(4).setResizable(false);
            kartlarTbl.getColumnModel().getColumn(4).setPreferredWidth(70);
            kartlarTbl.getColumnModel().getColumn(5).setResizable(false);
            kartlarTbl.getColumnModel().getColumn(5).setPreferredWidth(70);
            kartlarTbl.getColumnModel().getColumn(6).setResizable(false);
            kartlarTbl.getColumnModel().getColumn(6).setPreferredWidth(30);
            kartlarTbl.getColumnModel().getColumn(7).setResizable(false);
        }

        kartlarPnl.add(jScrollPane1);
        jScrollPane1.setBounds(50, 10, 900, 180);

        jButton6.setBackground(new java.awt.Color(12, 63, 122));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Seçili kartın limitini güncelle");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        kartlarPnl.add(jButton6);
        jButton6.setBounds(530, 210, 200, 22);

        jButton7.setBackground(new java.awt.Color(12, 63, 122));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Seçili kart borcunu öde");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        kartlarPnl.add(jButton7);
        jButton7.setBounds(60, 210, 160, 22);

        jComboBox4.setBackground(new java.awt.Color(12, 63, 122));
        jComboBox4.setForeground(new java.awt.Color(255, 255, 255));
        kartlarPnl.add(jComboBox4);
        jComboBox4.setBounds(60, 270, 420, 22);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ödeme hesabınızı seçiniz.");
        kartlarPnl.add(jLabel5);
        jLabel5.setBounds(60, 250, 160, 16);

        jButton8.setBackground(new java.awt.Color(12, 63, 122));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Seçili kartı iptal et");
        jButton8.setMaximumSize(new java.awt.Dimension(160, 24));
        jButton8.setMinimumSize(new java.awt.Dimension(160, 24));
        jButton8.setPreferredSize(new java.awt.Dimension(160, 24));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        kartlarPnl.add(jButton8);
        jButton8.setBounds(750, 210, 200, 24);

        getContentPane().add(kartlarPnl);
        kartlarPnl.setBounds(0, 120, 1000, 310);

        gecmisPnl.setLayout(null);

        jScrollPane5.setBackground(new java.awt.Color(102, 102, 255));

        gecmisTbl.setBackground(new java.awt.Color(23, 23, 26));
        gecmisTbl.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        gecmisTbl.setForeground(new java.awt.Color(255, 255, 255));
        gecmisTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "İşlem", "Tarih"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gecmisTbl.setGridColor(new java.awt.Color(12, 63, 122));
        gecmisTbl.setSelectionBackground(new java.awt.Color(29, 121, 212));
        gecmisTbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        gecmisTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        gecmisTbl.setShowGrid(true);
        gecmisTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(gecmisTbl);
        if (gecmisTbl.getColumnModel().getColumnCount() > 0) {
            gecmisTbl.getColumnModel().getColumn(0).setMinWidth(45);
            gecmisTbl.getColumnModel().getColumn(0).setPreferredWidth(45);
            gecmisTbl.getColumnModel().getColumn(0).setMaxWidth(45);
            gecmisTbl.getColumnModel().getColumn(2).setMinWidth(135);
            gecmisTbl.getColumnModel().getColumn(2).setPreferredWidth(135);
            gecmisTbl.getColumnModel().getColumn(2).setMaxWidth(135);
        }

        gecmisPnl.add(jScrollPane5);
        jScrollPane5.setBounds(0, 0, 930, 310);

        getContentPane().add(gecmisPnl);
        gecmisPnl.setBounds(40, 120, 930, 310);

        basvurularPnl.setOpaque(false);
        basvurularPnl.setLayout(null);

        jButton1.setBackground(new java.awt.Color(12, 63, 122));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Hesap başvurusu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        basvurularPnl.add(jButton1);
        jButton1.setBounds(100, 150, 240, 50);

        jButton2.setBackground(new java.awt.Color(12, 63, 122));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Kredi kartı başvurusu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        basvurularPnl.add(jButton2);
        jButton2.setBounds(380, 150, 240, 50);

        jButton3.setBackground(new java.awt.Color(12, 63, 122));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Kredi başvurusu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        basvurularPnl.add(jButton3);
        jButton3.setBounds(660, 150, 240, 50);

        getContentPane().add(basvurularPnl);
        basvurularPnl.setBounds(0, 110, 1000, 320);

        faturaPnl.setOpaque(false);
        faturaPnl.setLayout(null);

        jComboBox1.setBackground(new java.awt.Color(12, 63, 122));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doğalgaz", "Elektrik", "Su", "İnternet", "Telefon" }));
        faturaPnl.add(jComboBox1);
        jComboBox1.setBounds(40, 80, 210, 22);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ödemek istdiğiniz faturayı seçiniz.");
        faturaPnl.add(jLabel1);
        jLabel1.setBounds(40, 60, 210, 16);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ödeme şeklini seçiniz.");
        faturaPnl.add(jLabel2);
        jLabel2.setBounds(350, 60, 150, 16);

        jComboBox2.setBackground(new java.awt.Color(12, 63, 122));
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banka Hesabı", "Kredi Kartı" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        faturaPnl.add(jComboBox2);
        jComboBox2.setBounds(350, 80, 160, 22);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hesabınızı seçiniz.");
        faturaPnl.add(jLabel3);
        jLabel3.setBounds(40, 170, 130, 16);

        jComboBox3.setBackground(new java.awt.Color(12, 63, 122));
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        faturaPnl.add(jComboBox3);
        jComboBox3.setBounds(40, 190, 470, 22);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fatura miktarını giriniz.");
        faturaPnl.add(jLabel4);
        jLabel4.setBounds(640, 60, 150, 16);

        jTextField1.setBackground(new java.awt.Color(23, 23, 26));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        faturaPnl.add(jTextField1);
        jTextField1.setBounds(640, 80, 130, 22);

        jButton5.setBackground(new java.awt.Color(12, 63, 122));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Ödeme Yap");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        faturaPnl.add(jButton5);
        jButton5.setBounds(640, 160, 140, 50);

        getContentPane().add(faturaPnl);
        faturaPnl.setBounds(40, 120, 930, 310);

        kullaniciPnl.setOpaque(false);
        kullaniciPnl.setLayout(null);

        telDegisBtn.setBackground(new java.awt.Color(12, 63, 122));
        telDegisBtn.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        telDegisBtn.setForeground(new java.awt.Color(255, 255, 255));
        telDegisBtn.setText("Telefon numarasını değiştir");
        telDegisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telDegisBtnActionPerformed(evt);
            }
        });
        kullaniciPnl.add(telDegisBtn);
        telDegisBtn.setBounds(630, 40, 200, 30);

        maildegisBtn.setBackground(new java.awt.Color(12, 63, 122));
        maildegisBtn.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        maildegisBtn.setForeground(new java.awt.Color(255, 255, 255));
        maildegisBtn.setText("E-mail değiştir");
        maildegisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maildegisBtnActionPerformed(evt);
            }
        });
        kullaniciPnl.add(maildegisBtn);
        maildegisBtn.setBounds(630, 80, 200, 30);

        sifredegisBtn.setBackground(new java.awt.Color(12, 63, 122));
        sifredegisBtn.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        sifredegisBtn.setForeground(new java.awt.Color(255, 255, 255));
        sifredegisBtn.setText("Şifreyi değiştir");
        sifredegisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sifredegisBtnActionPerformed(evt);
            }
        });
        kullaniciPnl.add(sifredegisBtn);
        sifredegisBtn.setBounds(630, 120, 200, 30);

        dglbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dglbl.setForeground(new java.awt.Color(255, 255, 255));
        dglbl.setText("Doğum Tarihi:");
        dglbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kullaniciPnl.add(dglbl);
        dglbl.setBounds(80, 160, 860, 30);

        emaillbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        emaillbl.setForeground(new java.awt.Color(255, 255, 255));
        emaillbl.setText("E-mail:");
        emaillbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kullaniciPnl.add(emaillbl);
        emaillbl.setBounds(80, 130, 860, 30);

        soyadlbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        soyadlbl.setForeground(new java.awt.Color(255, 255, 255));
        soyadlbl.setText("Soyad:");
        soyadlbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kullaniciPnl.add(soyadlbl);
        soyadlbl.setBounds(80, 70, 860, 30);

        tellbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tellbl.setForeground(new java.awt.Color(255, 255, 255));
        tellbl.setText("Telefon:");
        tellbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        tellbl.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        kullaniciPnl.add(tellbl);
        tellbl.setBounds(80, 100, 860, 30);

        adlbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        adlbl.setForeground(new java.awt.Color(255, 255, 255));
        adlbl.setText("Ad: ");
        adlbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kullaniciPnl.add(adlbl);
        adlbl.setBounds(80, 40, 860, 30);

        tclbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tclbl.setForeground(new java.awt.Color(255, 255, 255));
        tclbl.setText("T.C. Kimlik No:");
        tclbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kullaniciPnl.add(tclbl);
        tclbl.setBounds(80, 10, 860, 30);

        getContentPane().add(kullaniciPnl);
        kullaniciPnl.setBounds(50, 180, 900, 210);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        kullaniciBtn.setBackground(new java.awt.Color(12, 63, 122));
        kullaniciBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        kullaniciBtn.setForeground(new java.awt.Color(255, 255, 255));
        kullaniciBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kullaniciBtn.setText("Kullanıcı Bilgileri");
        kullaniciBtn.setOpaque(true);
        kullaniciBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kullaniciBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kullaniciBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kullaniciBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                kullaniciBtnMouseReleased(evt);
            }
        });
        jPanel1.add(kullaniciBtn);
        kullaniciBtn.setBounds(840, 60, 110, 40);

        hesaplarimBtn.setBackground(new java.awt.Color(12, 63, 122));
        hesaplarimBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        hesaplarimBtn.setForeground(new java.awt.Color(255, 255, 255));
        hesaplarimBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hesaplarimBtn.setText("Hesaplarım");
        hesaplarimBtn.setOpaque(true);
        hesaplarimBtn.setPreferredSize(new java.awt.Dimension(105, 18));
        hesaplarimBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hesaplarimBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hesaplarimBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hesaplarimBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                hesaplarimBtnMouseReleased(evt);
            }
        });
        jPanel1.add(hesaplarimBtn);
        hesaplarimBtn.setBounds(60, 60, 110, 40);

        kredilerimBtn.setBackground(new java.awt.Color(12, 63, 122));
        kredilerimBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        kredilerimBtn.setForeground(new java.awt.Color(255, 255, 255));
        kredilerimBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kredilerimBtn.setText("Kredilerim");
        kredilerimBtn.setOpaque(true);
        kredilerimBtn.setPreferredSize(new java.awt.Dimension(105, 18));
        kredilerimBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kredilerimBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kredilerimBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kredilerimBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                kredilerimBtnMouseReleased(evt);
            }
        });
        jPanel1.add(kredilerimBtn);
        kredilerimBtn.setBounds(320, 60, 110, 40);

        kredikartlarimBtn.setBackground(new java.awt.Color(12, 63, 122));
        kredikartlarimBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        kredikartlarimBtn.setForeground(new java.awt.Color(255, 255, 255));
        kredikartlarimBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kredikartlarimBtn.setText("Kredi Kartlarım");
        kredikartlarimBtn.setOpaque(true);
        kredikartlarimBtn.setPreferredSize(new java.awt.Dimension(105, 18));
        kredikartlarimBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kredikartlarimBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kredikartlarimBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kredikartlarimBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                kredikartlarimBtnMouseReleased(evt);
            }
        });
        jPanel1.add(kredikartlarimBtn);
        kredikartlarimBtn.setBounds(190, 60, 110, 40);

        basvurularBtn.setBackground(new java.awt.Color(12, 63, 122));
        basvurularBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        basvurularBtn.setForeground(new java.awt.Color(255, 255, 255));
        basvurularBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        basvurularBtn.setText("Başvurular");
        basvurularBtn.setOpaque(true);
        basvurularBtn.setPreferredSize(new java.awt.Dimension(105, 18));
        basvurularBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                basvurularBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                basvurularBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                basvurularBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                basvurularBtnMouseReleased(evt);
            }
        });
        jPanel1.add(basvurularBtn);
        basvurularBtn.setBounds(450, 60, 110, 40);

        faturaBtn.setBackground(new java.awt.Color(12, 63, 122));
        faturaBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        faturaBtn.setForeground(new java.awt.Color(255, 255, 255));
        faturaBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        faturaBtn.setText("Fatura İşlemleri");
        faturaBtn.setOpaque(true);
        faturaBtn.setPreferredSize(new java.awt.Dimension(105, 18));
        faturaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                faturaBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                faturaBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                faturaBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                faturaBtnMouseReleased(evt);
            }
        });
        jPanel1.add(faturaBtn);
        faturaBtn.setBounds(580, 60, 110, 40);

        yenileBtn.setAlignmentY(0.0F);
        yenileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        yenileBtn.setMaximumSize(new java.awt.Dimension(0, 0));
        yenileBtn.setMinimumSize(new java.awt.Dimension(0, 0));
        yenileBtn.setPreferredSize(new java.awt.Dimension(0, 0));
        yenileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yenileBtnActionPerformed(evt);
            }
        });
        jPanel1.add(yenileBtn);
        yenileBtn.setBounds(990, 0, 0, 0);

        hesapGecmisBtn.setBackground(new java.awt.Color(12, 63, 122));
        hesapGecmisBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        hesapGecmisBtn.setForeground(new java.awt.Color(255, 255, 255));
        hesapGecmisBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hesapGecmisBtn.setText("Hesap Geçmişi");
        hesapGecmisBtn.setOpaque(true);
        hesapGecmisBtn.setPreferredSize(new java.awt.Dimension(105, 18));
        hesapGecmisBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hesapGecmisBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hesapGecmisBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hesapGecmisBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                hesapGecmisBtnMouseReleased(evt);
            }
        });
        jPanel1.add(hesapGecmisBtn);
        hesapGecmisBtn.setBounds(710, 60, 110, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 550);

        girisPnl.setBackground(new java.awt.Color(51, 51, 51));
        girisPnl.setOpaque(false);
        girisPnl.setLayout(null);

        girisLbl.setBackground(new java.awt.Color(255, 255, 255));
        girisLbl.setFont(new java.awt.Font("Segoe UI Semilight", 1, 40)); // NOI18N
        girisLbl.setForeground(new java.awt.Color(255, 255, 255));
        girisLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        girisLbl.setText("Kişi Adı");
        girisPnl.add(girisLbl);
        girisLbl.setBounds(0, 70, 490, 90);

        toplamBak.setFont(new java.awt.Font("Segoe UI Semilight", 1, 32)); // NOI18N
        toplamBak.setForeground(new java.awt.Color(255, 255, 255));
        toplamBak.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toplamBak.setText("Toplam Bakiyeniz: Değer");
        girisPnl.add(toplamBak);
        toplamBak.setBounds(520, 60, 470, 70);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 1, 40)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Hoş Geldiniz!");
        jLabel6.setToolTipText("");
        girisPnl.add(jLabel6);
        jLabel6.setBounds(0, 160, 490, 60);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/separator.png"))); // NOI18N
        girisPnl.add(jLabel7);
        jLabel7.setBounds(500, 0, 15, 350);

        hesapSayiLbl.setFont(new java.awt.Font("Segoe UI Semilight", 1, 32)); // NOI18N
        hesapSayiLbl.setForeground(new java.awt.Color(255, 255, 255));
        hesapSayiLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hesapSayiLbl.setText("Hesap Sayınız: Değer");
        girisPnl.add(hesapSayiLbl);
        hesapSayiLbl.setBounds(520, 120, 470, 70);

        krediKartiSayiLbl.setFont(new java.awt.Font("Segoe UI Semilight", 1, 32)); // NOI18N
        krediKartiSayiLbl.setForeground(new java.awt.Color(255, 255, 255));
        krediKartiSayiLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        krediKartiSayiLbl.setText("Kredi Kartı Sayınız: Değer");
        girisPnl.add(krediKartiSayiLbl);
        krediKartiSayiLbl.setBounds(520, 180, 470, 70);

        getContentPane().add(girisPnl);
        girisPnl.setBounds(0, 120, 1000, 430);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(23, 23, 26));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        jLabel8.setText("Çıkış Yap");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8);
        jLabel8.setBounds(880, 475, 90, 30);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ekran.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, -30, 1000, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void setgecmisTbl(Musteri m1, JTable gecmisTbl) throws IOException {
        File file = new File("src/files/musteriGecmis.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        DefaultTableModel m = (DefaultTableModel) gecmisTbl.getModel();
        m.setRowCount(0);
        int count = 1;
        while ((st = br.readLine()) != null) {
            if (st.split("/")[0].equals(String.valueOf(m1.getTc()))) {
                Object obj[] = {count, st.split("/")[1], st.split("/")[2]};
                m.addRow(obj);
                count++;
            }
        }
        br.close();
    }

    private void paraGonderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paraGonderBtnActionPerformed
        int col = hesaplarTbl.getSelectedColumn();
        int row = hesaplarTbl.getSelectedRow();
        String iban = hesaplarTbl.getValueAt(row, 2).toString();
        String iban2 = JOptionPane.showInputDialog("Göndermek istediğiniz IBAN'ı giriniz.");
        String miktar = JOptionPane.showInputDialog("Göndermek istediğiniz miktarı giriniz.");
        File file = new File("src/files/hesaplar.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            boolean worked = false;
            while ((st = br.readLine()) != null) {
                if (st.split("/")[2].equals(String.valueOf(iban2))) {
                    worked = true;
                    if (Double.valueOf(miktar) < 0) {
                        JOptionPane.showMessageDialog(null, "Sıfırdan az para gönderemezsiniz!", "Hata", JOptionPane.WARNING_MESSAGE);
                    } else if (Double.valueOf(miktar) > Double.valueOf(hesaplarTbl.getValueAt(row, 4).toString())) {
                        JOptionPane.showMessageDialog(null, "Bakiyenizden fazla para gönderemezsiniz!", "Hata", JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            m1.paraGonder(m1, iban, iban2, miktar, hesaplarTbl);
                            sethesaplarTbl(m1, hesaplarTbl);
                            tablodoldur();
                        } catch (IOException ex) {
                            Logger.getLogger(MusteriEkran.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            if (worked == false) {
                JOptionPane.showMessageDialog(null, "Böyle bir hesap bulunamadı!", "Hata", JOptionPane.WARNING_MESSAGE);
            }
            br.close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_paraGonderBtnActionPerformed

    private void kullaniciBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kullaniciBtnMousePressed
        
        kullaniciBtn.setBackground(new Color(21, 46, 121));
        hesaplarimPnl.setVisible(false);
        girisPnl.setVisible(false);
        kartlarPnl.setVisible(false);
        gecmisPnl.setVisible(false);
        kredilerPnl.setVisible(false);
        basvurularPnl.setVisible(false);
        faturaPnl.setVisible(false);
        kullaniciPnl.setVisible(true);


    }//GEN-LAST:event_kullaniciBtnMousePressed

    private void paraYatirBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paraYatirBtnMousePressed

        int col = hesaplarTbl.getSelectedColumn();
        int row = hesaplarTbl.getSelectedRow();
        String iban = hesaplarTbl.getValueAt(row, 2).toString();
        String miktar = JOptionPane.showInputDialog("Yatırmak istediğiniz miktarı giriniz.");
        if (Double.valueOf(miktar) < 0) {
            JOptionPane.showMessageDialog(null, "Sıfırdan az para yatıramazsınız!", "Hata", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                m1.paraYatir(m1, iban, miktar, hesaplarTbl);
                sethesaplarTbl(m1, hesaplarTbl);
                tablodoldur();
            } catch (IOException ex) {
                Logger.getLogger(MusteriEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_paraYatirBtnMousePressed

    private void paraCekBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paraCekBtnMousePressed
        
        int col = hesaplarTbl.getSelectedColumn();
        int row = hesaplarTbl.getSelectedRow();
        String iban = hesaplarTbl.getValueAt(row, 2).toString();
        String miktar = JOptionPane.showInputDialog("Çekmek istediğiniz miktarı giriniz.");
        if (Double.valueOf(miktar) < 0) {
            JOptionPane.showMessageDialog(null, "Sıfırdan az para çekemezsiniz!", "Hata", JOptionPane.WARNING_MESSAGE);
        } else if (Double.valueOf(miktar) > Double.valueOf(hesaplarTbl.getValueAt(row, 4).toString())) {
            JOptionPane.showMessageDialog(null, "Bakiyenizden fazla para çekemezsiniz!", "Hata", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                m1.paraCek(m1, iban, miktar, hesaplarTbl);
                sethesaplarTbl(m1, hesaplarTbl);
                tablodoldur();
            } catch (IOException ex) {
                Logger.getLogger(MusteriEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_paraCekBtnMousePressed

    private void hesaplarimBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hesaplarimBtnMousePressed
        hesaplarimBtn.setBackground(new Color(21, 46, 121));
        try {
            
            sethesaplarTbl(m1, hesaplarTbl);
            tablodoldur();
            kredilerPnl.setVisible(false);
            faturaPnl.setVisible(false);
            girisPnl.setVisible(false);
            kullaniciPnl.setVisible(false);
            basvurularPnl.setVisible(false);
            kartlarPnl.setVisible(false);
            gecmisPnl.setVisible(false);
            hesaplarimPnl.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MusteriEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hesaplarimBtnMousePressed

    private void kredikartlarimBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kredikartlarimBtnMousePressed
        kredikartlarimBtn.setBackground(new Color(21, 46, 121));
        try {
            
            setkredikartlariTbl(m1, kartlarTbl);
            kartlartablodoldur();
            girisPnl.setVisible(false);
            kredilerPnl.setVisible(false);
            kullaniciPnl.setVisible(false);
            gecmisPnl.setVisible(false);
            faturaPnl.setVisible(false);
            hesaplarimPnl.setVisible(false);
            basvurularPnl.setVisible(false);
            kartlarPnl.setVisible(true);
            jComboBox4.removeAllItems();
            sethesaplarTbl(m1, hesaplarTbl);
            setkredikartlariTbl(m1, kartlarTbl);
            for (int i = 0; i < m1.hesaplar.size(); i++) {
                jComboBox4.addItem(m1.hesap_adi.get(i) + ", " + m1.hesaplar.get(i) + ", " + m1.bakiye.get(i));
            }
        } catch (IOException ex) {
            Logger.getLogger(MusteriEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kredikartlarimBtnMousePressed

    private void hesaplarimBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hesaplarimBtnMouseEntered
        
        hesaplarimBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_hesaplarimBtnMouseEntered

    private void hesaplarimBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hesaplarimBtnMouseExited
        
        hesaplarimBtn.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_hesaplarimBtnMouseExited

    private void hesaplarimBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hesaplarimBtnMouseReleased
        
        hesaplarimBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_hesaplarimBtnMouseReleased

    private void kredikartlarimBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kredikartlarimBtnMouseEntered
        
        kredikartlarimBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_kredikartlarimBtnMouseEntered

    private void kredikartlarimBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kredikartlarimBtnMouseExited
        
        kredikartlarimBtn.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_kredikartlarimBtnMouseExited

    private void kredikartlarimBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kredikartlarimBtnMouseReleased
        
        kredikartlarimBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_kredikartlarimBtnMouseReleased

    private void basvurularBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_basvurularBtnMouseEntered
        
        basvurularBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_basvurularBtnMouseEntered

    private void basvurularBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_basvurularBtnMouseExited
        
        basvurularBtn.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_basvurularBtnMouseExited

    private void basvurularBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_basvurularBtnMousePressed
        
        basvurularBtn.setBackground(new Color(21, 46, 121));
        girisPnl.setVisible(false);
        hesaplarimPnl.setVisible(false);
        kullaniciPnl.setVisible(false);
        gecmisPnl.setVisible(false);
        faturaPnl.setVisible(false);
        kredilerPnl.setVisible(false);
        kartlarPnl.setVisible(false);
        basvurularPnl.setVisible(true);

    }//GEN-LAST:event_basvurularBtnMousePressed

    private void basvurularBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_basvurularBtnMouseReleased
        
        basvurularBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_basvurularBtnMouseReleased

    private void faturaBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faturaBtnMouseEntered
        
        faturaBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_faturaBtnMouseEntered

    private void faturaBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faturaBtnMouseExited
        
        faturaBtn.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_faturaBtnMouseExited

    private void faturaBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faturaBtnMousePressed
        try {
            
            faturaBtn.setBackground(new Color(21, 46, 121));
            basvurularPnl.setVisible(false);
            gecmisPnl.setVisible(false);
            girisPnl.setVisible(false);
            hesaplarimPnl.setVisible(false);
            kredilerPnl.setVisible(false);
            kullaniciPnl.setVisible(false);
            kartlarPnl.setVisible(false);
            gecmisPnl.setVisible(false);
            faturaPnl.setVisible(true);
            jComboBox3.removeAllItems();
            sethesaplarTbl(m1, hesaplarTbl);
            setkredikartlariTbl(m1, kartlarTbl);
            if (jComboBox2.getSelectedIndex() == 0) {
                for (int i = 0; i < m1.hesaplar.size(); i++) {
                    jComboBox3.addItem(m1.hesap_adi.get(i) + ", " + m1.hesaplar.get(i) + ", " + m1.bakiye.get(i));
                }
            } else {
                jLabel3.setText("Kredi kartınızı seçiniz.");
                for (int i = 0; i < m1.kart_adi.size(); i++) {
                    jComboBox3.addItem(m1.kart_adi.get(i) + ", " + m1.kartno.get(i) + ", " + m1.kart_bakiye.get(i));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MusteriEkran.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_faturaBtnMousePressed

    private void faturaBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faturaBtnMouseReleased
        
        faturaBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_faturaBtnMouseReleased

    private void kullaniciBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kullaniciBtnMouseEntered
        
        kullaniciBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_kullaniciBtnMouseEntered

    private void kullaniciBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kullaniciBtnMouseExited
        
        kullaniciBtn.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_kullaniciBtnMouseExited

    private void kullaniciBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kullaniciBtnMouseReleased
        
        kullaniciBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_kullaniciBtnMouseReleased

    private void sifredegisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sifredegisBtnActionPerformed
        
        String sifre = JOptionPane.showInputDialog(null, "Lütfen eski şifrenizi giriniz.");
        String yenisifre = JOptionPane.showInputDialog(null, "Lütfen yeni şifrenizi giriniz.");

        m1.sifreDegistir(m1, sifre, yenisifre);
    }//GEN-LAST:event_sifredegisBtnActionPerformed

    private void maildegisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maildegisBtnActionPerformed
        
        String mail = JOptionPane.showInputDialog(null, "Lütfen yeni e-mailinizi giriniz.");
        m1.mailDegistir(m1, mail);
        emaillbl.setText("E-mail: " + m1.getTel());
    }//GEN-LAST:event_maildegisBtnActionPerformed

    private void telDegisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telDegisBtnActionPerformed
        
        String tel = JOptionPane.showInputDialog(null, "Lütfen yeni telefon numaranızı giriniz.");
        m1.telDegistir(m1, tel);
        tellbl.setText("Telefon: " + m1.getTel());
    }//GEN-LAST:event_telDegisBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        HesapBasvurusu hesapekran = new HesapBasvurusu(String.valueOf(m1.getTc()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        KrediKartiBasvuru kredikartıekran = new KrediKartiBasvuru(String.valueOf(m1.getTc()));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void kredilerimBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kredilerimBtnMouseEntered
        
        kredilerimBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_kredilerimBtnMouseEntered

    private void kredilerimBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kredilerimBtnMouseExited
        
        kredilerimBtn.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_kredilerimBtnMouseExited

    private void kredilerimBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kredilerimBtnMousePressed
        try {
            
            kredilerimBtn.setBackground(new Color(21, 46, 121));
            hesaplarimPnl.setVisible(false);
            gecmisPnl.setVisible(false);
            kullaniciPnl.setVisible(false);
            faturaPnl.setVisible(false);
            kartlarPnl.setVisible(false);
            basvurularPnl.setVisible(false);
            girisPnl.setVisible(false);
            setkredilerTbl(m1, kredilerTbl);
            kreditablodoldur();
            kredilerPnl.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MusteriEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kredilerimBtnMousePressed

    private void kredilerimBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kredilerimBtnMouseReleased
        
        kredilerimBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_kredilerimBtnMouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        
        int row = kredilerTbl.getSelectedRow();
        String borc = kredilerTbl.getValueAt(row, 2).toString();
        String kredi = kredilerTbl.getValueAt(row, 1).toString();
        KrediBorcOde X = new KrediBorcOde(m1, Double.valueOf(borc), Double.valueOf(kredi), hesaplarTbl, kredilerTbl, row, yenileBtn);


    }//GEN-LAST:event_jButton4ActionPerformed

    private void paraYatirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paraYatirBtnActionPerformed
        
    }//GEN-LAST:event_paraYatirBtnActionPerformed

    private void yenileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yenileBtnActionPerformed
        
        try {
            
            setkredilerTbl(m1, kredilerTbl);
            sethesaplarTbl(m1, hesaplarTbl);
            setkredikartlariTbl(m1, kartlarTbl);
            kreditablodoldur();
            tablodoldur();
            kartlartablodoldur();

        } catch (IOException ex) {
            Logger.getLogger(MusteriEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_yenileBtnActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        try {
            
            jComboBox3.removeAllItems();
            sethesaplarTbl(m1, hesaplarTbl);
            setkredikartlariTbl(m1, kartlarTbl);
            if (jComboBox2.getSelectedIndex() == 0) {
                jLabel3.setText("Hesabınızı seçiniz.");
                for (int i = 0; i < m1.hesaplar.size(); i++) {
                    jComboBox3.addItem(m1.hesap_adi.get(i) + ", " + m1.hesaplar.get(i) + ", " + m1.bakiye.get(i));
                }
            } else {
                jLabel3.setText("Kredi kartınızı seçiniz.");
                for (int i = 0; i < m1.kart_adi.size(); i++) {
                    jComboBox3.addItem(m1.kart_adi.get(i) + ", " + m1.kartno.get(i) + ", " + m1.kart_bakiye.get(i));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MusteriEkran.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            
            String iban = "";
            iban = jComboBox3.getSelectedItem().toString().split(", ")[1];
            String miktar = jTextField1.getText();
            if (Double.parseDouble(miktar) > Double.parseDouble(jComboBox3.getSelectedItem().toString().split(", ")[2])) {
                JOptionPane.showMessageDialog(null, "Bu kadar paranız bulunmuyor!");
            } else if (Double.parseDouble(miktar) <= 0) {
                JOptionPane.showMessageDialog(null, "Bu miktarda ödeme yapamazsınız!");
            } else {
                boolean bank;
                if (jComboBox2.getSelectedIndex() == 0) {
                    bank = true;
                } else {
                    bank = false;
                }
                m1.faturaOde(m1, iban, miktar, bank, jComboBox1.getSelectedItem().toString());
                sethesaplarTbl(m1, hesaplarTbl);
                setkredikartlariTbl(m1, kartlarTbl);
                jComboBox2ActionPerformed(evt);
            }
        } catch (IOException ex) {
            Logger.getLogger(MusteriEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        KrediBasvurusu krediekran = new KrediBasvurusu(String.valueOf(m1.getTc()));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            
            Double borc = Double.parseDouble(kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 4).toString()) - Double.parseDouble(kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 5).toString());
            String miktar = JOptionPane.showInputDialog("Kart borcunuz: " + borc);
            if (Double.parseDouble(miktar) <= 0) {
                JOptionPane.showMessageDialog(null, "Bu miktarda ödeme yapamazsınız!");
            } else if (Double.parseDouble(miktar) > borc) {
                JOptionPane.showMessageDialog(null, "Borcunuzdan fazla ödeme yapamazsınız!");
            } else if (Double.parseDouble(jComboBox4.getSelectedItem().toString().split(", ")[2]) < Double.parseDouble(miktar)) {
                JOptionPane.showMessageDialog(null, "Hesabınızda bu miktarda bakiye bulunmuyor!");
            } else {
                m1.kartBorcOde(m1, kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 2).toString(), miktar, kartlarTbl, jComboBox4.getSelectedItem().toString().split(", ")[1], hesaplarTbl);
                sethesaplarTbl(m1, hesaplarTbl);
                setkredikartlariTbl(m1, kartlarTbl);
                yenileBtn.doClick();
                jComboBox4.removeAllItems();
                sethesaplarTbl(m1, hesaplarTbl);
                setkredikartlariTbl(m1, kartlarTbl);
                for (int i = 0; i < m1.hesaplar.size(); i++) {
                    jComboBox4.addItem(m1.hesap_adi.get(i) + ", " + m1.hesaplar.get(i) + ", " + m1.bakiye.get(i));
                }
                JOptionPane.showMessageDialog(null, "Ödeme işlemi başarıyla tamamlandı.");
            }

        } catch (IOException ex) {
            Logger.getLogger(MusteriEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        

        String yenilimit = JOptionPane.showInputDialog("İstediğiniz limit miktarını giriniz.");
        if (Double.parseDouble(yenilimit) < Double.parseDouble(kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 5).toString())) {
            JOptionPane.showMessageDialog(null, "Borcunuzun altında limit güncelleme talebinde bulunamazsınız!");
        } else if (Double.parseDouble(yenilimit) <= 0) {
            JOptionPane.showMessageDialog(null, "Bu miktarda güncelleme talebinde bulunamazsınız!");
        } else {
            m1.limitGuncelle(m1, kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 2).toString(), yenilimit);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        if (Double.parseDouble(kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 4).toString()) == (Double.parseDouble(kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 5).toString()))) {
            try {
                m1.kredikartiIptal(kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 2).toString(),String.valueOf(m1.getTc()));
                yenileBtn.doClick();
            } catch (Throwable ex) {
                Logger.getLogger(MusteriEkran.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
            JOptionPane.showMessageDialog(null, "Kart borcunuzu ödemeden kapatma işlemi yapamazsınız!");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void hesapGecmisBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hesapGecmisBtnMouseEntered
        
        hesapGecmisBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_hesapGecmisBtnMouseEntered

    private void hesapGecmisBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hesapGecmisBtnMouseExited
        
        hesapGecmisBtn.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_hesapGecmisBtnMouseExited

    private void hesapGecmisBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hesapGecmisBtnMousePressed
        hesapGecmisBtn.setBackground(new Color(21, 46, 121));
        basvurularPnl.setVisible(false);
        girisPnl.setVisible(false);
        hesaplarimPnl.setVisible(false);
        kredilerPnl.setVisible(false);
        kullaniciPnl.setVisible(false);
        kartlarPnl.setVisible(false);
        gecmisPnl.setVisible(true);
        faturaPnl.setVisible(false);
        try {
            
            setgecmisTbl(m1, gecmisTbl);
        } catch (IOException ex) {
            Logger.getLogger(MusteriEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hesapGecmisBtnMousePressed

    private void hesapGecmisBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hesapGecmisBtnMouseReleased
        
        hesapGecmisBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_hesapGecmisBtnMouseReleased

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        
        this.dispose();
        A.setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked
    public void tablodoldur() throws IOException {
        DefaultTableModel m = (DefaultTableModel) hesaplarTbl.getModel();
        m.setRowCount(0);
        try {
            ArrayList<Object[]> hesaplar2 = hesapGetir(m1);
            for (int i = 0; i < hesaplar2.size(); i++) {
                m.addRow(hesaplar2.get(i));
            }
        } catch (Exception e) {
        }
        sethesaplarTbl(m1, hesaplarTbl);
    }

    public static ArrayList<Object[]> krediGetir(Musteri m1) {
        ArrayList<Object[]> temp = new ArrayList<>();
        for (int i = 0; i < m1.kredimiktari.size(); i++) {
            Object[] obj = {i + 1, m1.kredimiktari.get(i), m1.kredikalanborc.get(i), m1.kredisonodeme.get(i)};
            temp.add(obj);
        }
        return temp;
    }

    public static ArrayList<Object[]> hesapGetir(Musteri m1) {
        ArrayList<Object[]> temp = new ArrayList<>();
        for (int i = 0; i < m1.hesaplar.size(); i++) {
            Object[] obj = {i + 1, m1.hesap_adi.get(i), m1.hesaplar.get(i), m1.tur.get(i), m1.bakiye.get(i)};
            temp.add(obj);
        }
        return temp;
    }

    public static ArrayList<Object[]> kartGetir(Musteri m1) {
        ArrayList<Object[]> temp = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("LLLL yyyy");
        LocalDateTime now = LocalDateTime.now();
        for (int i = 0; i < m1.kartno.size(); i++) {
            if (Integer.valueOf(m1.kart_ekstre.get(i)) > now.getDayOfMonth()) {
                now = LocalDateTime.now();
            } else {
                now = LocalDateTime.now().plusMonths(1);
            }
            Object[] obj = {i + 1, m1.kart_adi.get(i), m1.kartno.get(i), (m1.kart_ay.get(i) + "/" + m1.kart_yil.get(i)), m1.kart_limit.get(i), m1.kart_bakiye.get(i), m1.kart_cvv.get(i), m1.kart_ekstre.get(i) + " " + dtf.format(now)};
            temp.add(obj);
        }
        return temp;
    }

    public void kartlartablodoldur() throws IOException {
        DefaultTableModel m = (DefaultTableModel) kartlarTbl.getModel();
        m.setRowCount(0);
        try {
            ArrayList<Object[]> kartlar = kartGetir(m1);
            for (int i = 0; i < kartlar.size(); i++) {
                m.addRow(kartlar.get(i));
            }
        } catch (Exception e) {
        }
        setkredikartlariTbl(m1, kartlarTbl);
    }

    public void kreditablodoldur() throws IOException {
        DefaultTableModel m = (DefaultTableModel) kredilerTbl.getModel();
        m.setRowCount(0);
        try {
            ArrayList<Object[]> krediler = krediGetir(m1);
            for (int i = 0; i < krediler.size(); i++) {
                m.addRow(krediler.get(i));
            }
        } catch (Exception e) {
        }
        setkredilerTbl(m1, kredilerTbl);
    }

    public static void sethesaplarTbl(Musteri m1, JTable hesaplarTbl) throws IOException {
        File file = new File("src/files/hesaplar.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int count = 0;
        m1.hesaplar.clear();
        m1.hesap_adi.clear();
        m1.tur.clear();
        m1.bakiye.clear();
        while ((st = br.readLine()) != null) {
            if (st.split("/")[0].equals(String.valueOf(m1.getTc()))) {
                count++;
                m1.hesaplar.add(st.split("/")[2]);
                m1.hesap_adi.add(st.split("/")[1]);
                m1.tur.add(st.split("/")[4]);
                m1.bakiye.add(st.split("/")[3]);
            }
        }
        br.close();
    }

    public static void setkredikartlariTbl(Musteri m1, JTable kartlarTbl) throws IOException {
        File file = new File("src/files/kredikartlari.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int count = 0;
        m1.kartno.clear();
        m1.kart_adi.clear();
        m1.kart_limit.clear();
        m1.kart_ay.clear();
        m1.kart_yil.clear();
        m1.kart_cvv.clear();
        m1.kart_ekstre.clear();
        m1.kart_bakiye.clear();

        while ((st = br.readLine()) != null) {
            if (st.split("/")[0].equals(String.valueOf(m1.getTc()))) {
                count++;
                m1.kartno.add(st.split("/")[1]);
                m1.kart_ay.add(st.split("/")[2]);
                m1.kart_yil.add(st.split("/")[3]);
                m1.kart_cvv.add(st.split("/")[4]);
                m1.kart_limit.add(st.split("/")[5]);
                m1.kart_adi.add(st.split("/")[6]);
                m1.kart_ekstre.add(st.split("/")[7]);
                m1.kart_bakiye.add(st.split("/")[8]);

            }
        }
        br.close();
    }

    public void setkredilerTbl(Musteri m1, JTable kredilerTbl) throws IOException {
        File file = new File("src/files/krediler.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int count = 0;
        m1.kredimiktari.clear();
        m1.kredikalanborc.clear();
        m1.kredisonodeme.clear();
        while ((st = br.readLine()) != null) {
            if (st.split("/")[0].equals(String.valueOf(m1.getTc()))) {
                count++;
                m1.kredimiktari.add(st.split("/")[1]);
                m1.kredikalanborc.add(st.split("/")[2]);
                m1.kredisonodeme.add(st.split("/")[3]);
            }
        }
        br.close();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MusteriEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusteriEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusteriEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusteriEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adlbl;
    private javax.swing.JLabel background;
    private javax.swing.JLabel basvurularBtn;
    private javax.swing.JPanel basvurularPnl;
    private javax.swing.JLabel dglbl;
    private javax.swing.JLabel emaillbl;
    private javax.swing.JLabel faturaBtn;
    private javax.swing.JPanel faturaPnl;
    private javax.swing.JPanel gecmisPnl;
    private javax.swing.JTable gecmisTbl;
    private javax.swing.JLabel girisLbl;
    private javax.swing.JPanel girisPnl;
    private javax.swing.JLabel hesapGecmisBtn;
    private javax.swing.JLabel hesapSayiLbl;
    private javax.swing.JTable hesaplarTbl;
    private javax.swing.JLabel hesaplarimBtn;
    private javax.swing.JPanel hesaplarimPnl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel kartlarPnl;
    private javax.swing.JTable kartlarTbl;
    private javax.swing.JLabel krediKartiSayiLbl;
    private javax.swing.JLabel kredikartlarimBtn;
    private javax.swing.JPanel kredilerPnl;
    private javax.swing.JTable kredilerTbl;
    private javax.swing.JLabel kredilerimBtn;
    private javax.swing.JLabel kullaniciBtn;
    private javax.swing.JPanel kullaniciPnl;
    private javax.swing.JButton maildegisBtn;
    private javax.swing.JButton paraCekBtn;
    private javax.swing.JButton paraGonderBtn;
    private javax.swing.JButton paraYatirBtn;
    private javax.swing.JButton sifredegisBtn;
    private javax.swing.JLabel soyadlbl;
    private javax.swing.JLabel tclbl;
    private javax.swing.JButton telDegisBtn;
    private javax.swing.JLabel tellbl;
    private javax.swing.JLabel toplamBak;
    private javax.swing.JButton yenileBtn;
    // End of variables declaration//GEN-END:variables
}
