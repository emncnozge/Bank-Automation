package bankacilik;

import static bankacilik.Login.A;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class YoneticiEkran extends javax.swing.JFrame {

    Yonetici y1;

    public YoneticiEkran(Yonetici y1) throws IOException {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/bank.png")).getImage());
        this.y1 = y1;
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Emin Bank Yönetim Sistemi");
        hesapGetir();
        setbasvuruhesaplarTbl(hesaplarTbl);
        tablodoldur();
        krediGetir();
        setkredilerTbl(kredilerTbl);
        kreditablodoldur();
        limitGetir();
        setlimitTbl(limitTbl);
        limittablodoldur();
        personelGetir();
        setpersonelTbl(personelTbl);
        personeltablodoldur();
        yoneticiPnl.setVisible(false);
        krediBasvuruPnl.setVisible(false);
        personelPnl.setVisible(false);
        hesapBasvuruPnl.setVisible(true);
        kartBasvuruPnl.setVisible(false);
        limitPnl.setVisible(false);
        kredilerTbl.getTableHeader().setDefaultRenderer(new HeaderColor());
        hesaplarTbl.getTableHeader().setDefaultRenderer(new HeaderColor());
        kartlarTbl.getTableHeader().setDefaultRenderer(new HeaderColor());
        limitTbl.getTableHeader().setDefaultRenderer(new HeaderColor());
        personelTbl.getTableHeader().setDefaultRenderer(new HeaderColor());
        jScrollPane1.getViewport().setBackground(new Color(23, 23, 26));
        jScrollPane2.getViewport().setBackground(new Color(23, 23, 26));
        jScrollPane3.getViewport().setBackground(new Color(23, 23, 26));
        jScrollPane4.getViewport().setBackground(new Color(23, 23, 26));
        jScrollPane5.getViewport().setBackground(new Color(23, 23, 26));
        adP.setText("Ad: " + y1.getAd());
        soyadP.setText("Soyad: " + y1.getSoyad());
        dgP.setText("Doğum tarihi: " + y1.getDgmgn());
        mailP.setText("E-mail: " + y1.getEmail());
        tcP.setText("T.C. Kimlik No: " + y1.getTc());
        maasP.setText("Maaş: " + y1.getMaas());
        telP.setText("Telefon: " + y1.getTel());
        maasgunP.setText("Maaş günü: " + y1.getMaasgun());

    }
public ArrayList<Object[]> personelGetir() {
        ArrayList<Object[]> temp = new ArrayList<>();
        for (int i = 0; i < y1.personelKimlik.size(); i++) {
            Object[] obj = {i + 1, y1.personelKimlik.get(i),y1.personelAd.get(i),y1.personelSoyad.get(i),y1.personelAnne.get(i),y1.personelSifre.get(i),y1.personelTel.get(i),y1.personelMail.get(i),y1.personelDg.get(i),y1.personelMaasGun.get(i),y1.personelMaas.get(i)};
            temp.add(obj);
        }
        return temp;
    }
public void setpersonelTbl(JTable personelTbl) throws IOException {
        File file = new File("src/files/personelInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int count = 0;
        y1.personelAd.clear();
          y1.personelSoyad.clear();
          y1.personelKimlik.clear();
          y1.personelAnne.clear();
          y1.personelDg.clear();
          y1.personelMaas.clear();
          y1.personelMaasGun.clear();
          y1.personelSifre.clear();
          y1.personelTel.clear();
          y1.personelMail.clear();

        while ((st = br.readLine()) != null) {
            count++;
          y1.personelKimlik.add(st.split("/")[0]);
          y1.personelAd.add(st.split("/")[3]);
          y1.personelSoyad.add(st.split("/")[4]);
          y1.personelAnne.add(st.split("/")[2]);
          y1.personelSifre.add(st.split("/")[1]);
          y1.personelTel.add(st.split("/")[5]);
          y1.personelMail.add(st.split("/")[6]);
          y1.personelDg.add(st.split("/")[7]);
          y1.personelMaasGun.add(st.split("/")[8]);
          y1.personelMaas.add(st.split("/")[9]);

        }
        br.close();
    }
    public void setbasvuruhesaplarTbl(JTable hesaplarTbl) throws IOException {
        File file = new File("src/files/hesapBasvuru.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int count = 0;
        y1.hesaplar.clear();
        y1.hesap_adi.clear();
        y1.kimlik.clear();
        while ((st = br.readLine()) != null) {
            count++;
            y1.hesaplar.add(st.split("/")[2]);
            y1.hesap_adi.add(st.split("/")[1]);
            y1.kimlik.add(st.split("/")[0]);
        }
        br.close();
    }
    public void personeltablodoldur() throws IOException {
        DefaultTableModel m = (DefaultTableModel) personelTbl.getModel();
        m.setRowCount(0);
        try {
            ArrayList<Object[]> krediler = personelGetir();
            for (int i = 0; i < krediler.size(); i++) {
                m.addRow(krediler.get(i));
            }
        } catch (Exception e) {
        }
        setpersonelTbl(personelTbl);
    }
    public void kreditablodoldur() throws IOException {
        DefaultTableModel m = (DefaultTableModel) kredilerTbl.getModel();
        m.setRowCount(0);
        try {
            ArrayList<Object[]> krediler = krediGetir();
            for (int i = 0; i < krediler.size(); i++) {
                m.addRow(krediler.get(i));
            }
        } catch (Exception e) {
        }
        setkredilerTbl(kredilerTbl);
    }

    public void setkredilerTbl(JTable kredilerTbl) throws IOException {
        File file = new File("src/files/krediBasvuru.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        y1.kredimiktari.clear();
        y1.kredikalanborc.clear();
        y1.kredisonodeme.clear();
        y1.kredikimlik.clear();
        y1.kredineden.clear();
        while ((st = br.readLine()) != null) {
            y1.kredimiktari.add(st.split("/")[1]);
            y1.kredikalanborc.add(st.split("/")[2]);
            y1.kredisonodeme.add(st.split("/")[3]);
            y1.kredikimlik.add(st.split("/")[0]);
            y1.kredineden.add(st.split("/")[4]);
        }
        br.close();
    }

    public void setlimitTbl(JTable limitTbl) throws IOException {
        File file = new File("src/files/KrediKartiLimitBasvuru.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        y1.kartno.clear();
        y1.kart_adi.clear();
        y1.kart_limit.clear();
        y1.kart_ay.clear();
        y1.kart_yil.clear();
        y1.kart_cvv.clear();
        y1.kart_ekstre.clear();
        y1.kart_bakiye.clear();
        while ((st = br.readLine()) != null) {
            y1.kartkimlik.add(st.split("/")[0]);
            y1.kartno.add(st.split("/")[1]);
            y1.kart_ay.add(st.split("/")[2]);
            y1.kart_yil.add(st.split("/")[3]);
            y1.kart_cvv.add(st.split("/")[4]);
            y1.kart_limit.add(st.split("/")[5]);
            y1.kart_adi.add(st.split("/")[6]);
            y1.kart_ekstre.add(st.split("/")[7]);
            y1.kart_bakiye.add(st.split("/")[8]);
            y1.kartyenilimit.add(st.split("/")[9]);
        }
        br.close();
    }

    public ArrayList<Object[]> limitGetir() {
        ArrayList<Object[]> temp = new ArrayList<>();
        for (int i = 0; i < y1.kartno.size(); i++) {
            Object[] obj = {i + 1, y1.kartkimlik.get(i), y1.kart_adi.get(i), y1.kartno.get(i), y1.kart_ay.get(i), y1.kart_yil.get(i), y1.kart_cvv.get(i), y1.kart_limit.get(i), y1.kartyenilimit.get(i), y1.kart_ekstre.get(i), y1.kart_bakiye.get(i)};
            temp.add(obj);
        }
        return temp;
    }

    public void limittablodoldur() throws IOException {
        DefaultTableModel m = (DefaultTableModel) limitTbl.getModel();
        m.setRowCount(0);
        try {
            ArrayList<Object[]> kartlar = limitGetir();
            for (int i = 0; i < kartlar.size(); i++) {
                m.addRow(kartlar.get(i));
            }
        } catch (Exception e) {
        }
        setlimitTbl(limitTbl);
    }

    public ArrayList<Object[]> krediGetir() {
        ArrayList<Object[]> temp = new ArrayList<>();
        for (int i = 0; i < y1.kredimiktari.size(); i++) {
            Object[] obj = {i + 1, y1.kredikimlik.get(i), y1.kredimiktari.get(i), y1.kredisonodeme.get(i), y1.kredineden.get(i)};
            temp.add(obj);
        }
        return temp;
    }

    public void tablodoldur() throws IOException {
        DefaultTableModel m = (DefaultTableModel) hesaplarTbl.getModel();
        m.setRowCount(0);
        try {
            ArrayList<Object[]> hesaplar2 = hesapGetir();
            for (int i = 0; i < hesaplar2.size(); i++) {
                m.addRow(hesaplar2.get(i));
            }
        } catch (Exception e) {
        }
        setbasvuruhesaplarTbl(hesaplarTbl);
    }

    public ArrayList<Object[]> hesapGetir() {
        ArrayList<Object[]> temp = new ArrayList<>();
        for (int i = 0; i < y1.hesaplar.size(); i++) {
            Object[] obj = {i + 1, y1.kimlik.get(i), y1.hesap_adi.get(i), y1.hesaplar.get(i)};
            temp.add(obj);
        }
        return temp;
    }

    public void kartlartablodoldur() throws IOException {
        DefaultTableModel m = (DefaultTableModel) kartlarTbl.getModel();
        m.setRowCount(0);
        try {
            ArrayList<Object[]> kartlar = y1.kartGetir();
            for (int i = 0; i < kartlar.size(); i++) {
                m.addRow(kartlar.get(i));
            }
        } catch (Exception e) {
        }
        y1.setkredikartlariTbl(kartlarTbl);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        limitPnl = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        limitTbl = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        personelPnl = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        personelTbl = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        krediBasvuruPnl = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        kredilerTbl = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        hesapBasvuruPnl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hesaplarTbl = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        kartBasvuruPnl = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        kartlarTbl = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        yoneticiPnl = new javax.swing.JPanel();
        adP = new javax.swing.JLabel();
        soyadP = new javax.swing.JLabel();
        tcP = new javax.swing.JLabel();
        dgP = new javax.swing.JLabel();
        telP = new javax.swing.JLabel();
        mailP = new javax.swing.JLabel();
        maasP = new javax.swing.JLabel();
        maasgunP = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        yenileBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 550));
        getContentPane().setLayout(null);

        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(12, 63, 122));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hesap Başvuruları");
        jLabel1.setToolTipText("");
        jLabel1.setMaximumSize(new java.awt.Dimension(140, 45));
        jLabel1.setMinimumSize(new java.awt.Dimension(140, 45));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(140, 45));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 140, 45));

        jLabel2.setBackground(new java.awt.Color(12, 63, 122));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Kredi Kartı Başvuruları");
        jLabel2.setMaximumSize(new java.awt.Dimension(140, 45));
        jLabel2.setMinimumSize(new java.awt.Dimension(140, 45));
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(140, 45));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel2MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 140, 45));

        jLabel3.setBackground(new java.awt.Color(12, 63, 122));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Kredi Başvuruları");
        jLabel3.setMaximumSize(new java.awt.Dimension(140, 45));
        jLabel3.setMinimumSize(new java.awt.Dimension(140, 45));
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(140, 45));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel3MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 140, 45));

        jLabel4.setBackground(new java.awt.Color(12, 63, 122));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Limit  Başvuruları");
        jLabel4.setMaximumSize(new java.awt.Dimension(140, 45));
        jLabel4.setMinimumSize(new java.awt.Dimension(140, 45));
        jLabel4.setOpaque(true);
        jLabel4.setPreferredSize(new java.awt.Dimension(140, 45));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel4MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 140, 45));

        jLabel5.setBackground(new java.awt.Color(12, 63, 122));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Yönetici Bilgileri");
        jLabel5.setMaximumSize(new java.awt.Dimension(140, 45));
        jLabel5.setMinimumSize(new java.awt.Dimension(140, 45));
        jLabel5.setOpaque(true);
        jLabel5.setPreferredSize(new java.awt.Dimension(140, 45));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel5MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 140, 45));

        jLabel7.setBackground(new java.awt.Color(12, 63, 122));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Personel İşlemleri");
        jLabel7.setMaximumSize(new java.awt.Dimension(140, 45));
        jLabel7.setMinimumSize(new java.awt.Dimension(140, 45));
        jLabel7.setOpaque(true);
        jLabel7.setPreferredSize(new java.awt.Dimension(140, 45));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel7MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 140, 45));

        limitPnl.setOpaque(false);
        limitPnl.setLayout(null);

        limitTbl.setBackground(new java.awt.Color(23, 23, 26));
        limitTbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        limitTbl.setForeground(new java.awt.Color(255, 255, 255));
        limitTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "T.C. Kimlik No", "Kart Adı", "Kart No", "Kart SKT Ay", "Kart SKT Yıl", "Kart CVV", "Eski Limit", "Yeni Limit", "Ekstre Tarihi", "Bakiye"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        limitTbl.setGridColor(new java.awt.Color(12, 63, 122));
        limitTbl.setPreferredSize(new java.awt.Dimension(470, 80));
        limitTbl.setRowHeight(20);
        limitTbl.setSelectionBackground(new java.awt.Color(29, 121, 212));
        limitTbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        limitTbl.setShowGrid(true);
        jScrollPane4.setViewportView(limitTbl);
        if (limitTbl.getColumnModel().getColumnCount() > 0) {
            limitTbl.getColumnModel().getColumn(0).setMinWidth(45);
            limitTbl.getColumnModel().getColumn(0).setPreferredWidth(45);
            limitTbl.getColumnModel().getColumn(0).setMaxWidth(45);
            limitTbl.getColumnModel().getColumn(1).setMinWidth(90);
            limitTbl.getColumnModel().getColumn(1).setPreferredWidth(90);
            limitTbl.getColumnModel().getColumn(1).setMaxWidth(90);
            limitTbl.getColumnModel().getColumn(2).setMinWidth(120);
            limitTbl.getColumnModel().getColumn(2).setPreferredWidth(120);
            limitTbl.getColumnModel().getColumn(2).setMaxWidth(120);
            limitTbl.getColumnModel().getColumn(3).setMinWidth(130);
            limitTbl.getColumnModel().getColumn(3).setPreferredWidth(130);
            limitTbl.getColumnModel().getColumn(3).setMaxWidth(130);
            limitTbl.getColumnModel().getColumn(4).setMinWidth(75);
            limitTbl.getColumnModel().getColumn(4).setPreferredWidth(75);
            limitTbl.getColumnModel().getColumn(4).setMaxWidth(75);
            limitTbl.getColumnModel().getColumn(5).setMinWidth(75);
            limitTbl.getColumnModel().getColumn(5).setPreferredWidth(75);
            limitTbl.getColumnModel().getColumn(5).setMaxWidth(75);
            limitTbl.getColumnModel().getColumn(6).setMinWidth(70);
            limitTbl.getColumnModel().getColumn(6).setPreferredWidth(70);
            limitTbl.getColumnModel().getColumn(6).setMaxWidth(70);
        }

        limitPnl.add(jScrollPane4);
        jScrollPane4.setBounds(10, 10, 940, 270);

        jButton7.setBackground(new java.awt.Color(12, 63, 122));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Seçili limit güncelleme talebini sil");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        limitPnl.add(jButton7);
        jButton7.setBounds(500, 320, 221, 48);

        jButton8.setBackground(new java.awt.Color(12, 63, 122));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Seçili limit  talebini onayla");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        limitPnl.add(jButton8);
        jButton8.setBounds(250, 320, 221, 48);

        jPanel1.add(limitPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 960, 370));

        personelPnl.setOpaque(false);

        jScrollPane5.setOpaque(false);

        personelTbl.setBackground(new java.awt.Color(23, 23, 26));
        personelTbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        personelTbl.setForeground(new java.awt.Color(255, 255, 255));
        personelTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "T.C. Kimlik No", "Ad", "Soyad", "Anne Kızlık Soyadı", "Şifre", "Telefon", "E-Mail", "Doğum Tarihi", "Maaş Tarihi", "Maaş"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        personelTbl.setGridColor(new java.awt.Color(12, 63, 122));
        personelTbl.setPreferredSize(new java.awt.Dimension(470, 80));
        personelTbl.setRowHeight(20);
        personelTbl.setSelectionBackground(new java.awt.Color(29, 121, 212));
        personelTbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        personelTbl.setShowGrid(true);
        jScrollPane5.setViewportView(personelTbl);
        if (personelTbl.getColumnModel().getColumnCount() > 0) {
            personelTbl.getColumnModel().getColumn(0).setMinWidth(35);
            personelTbl.getColumnModel().getColumn(0).setPreferredWidth(35);
            personelTbl.getColumnModel().getColumn(0).setMaxWidth(35);
            personelTbl.getColumnModel().getColumn(1).setMinWidth(100);
            personelTbl.getColumnModel().getColumn(1).setPreferredWidth(100);
            personelTbl.getColumnModel().getColumn(1).setMaxWidth(100);
            personelTbl.getColumnModel().getColumn(2).setMinWidth(90);
            personelTbl.getColumnModel().getColumn(2).setPreferredWidth(90);
            personelTbl.getColumnModel().getColumn(2).setMaxWidth(90);
            personelTbl.getColumnModel().getColumn(3).setMinWidth(90);
            personelTbl.getColumnModel().getColumn(3).setPreferredWidth(90);
            personelTbl.getColumnModel().getColumn(3).setMaxWidth(90);
            personelTbl.getColumnModel().getColumn(4).setMinWidth(120);
            personelTbl.getColumnModel().getColumn(4).setPreferredWidth(120);
            personelTbl.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        jButton12.setBackground(new java.awt.Color(12, 63, 122));
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Seçili personel bilgilerini düzenle");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(12, 63, 122));
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Seçili personeli sil");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(12, 63, 122));
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Yeni personel ekle");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout personelPnlLayout = new javax.swing.GroupLayout(personelPnl);
        personelPnl.setLayout(personelPnlLayout);
        personelPnlLayout.setHorizontalGroup(
            personelPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personelPnlLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(personelPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(personelPnlLayout.createSequentialGroup()
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        personelPnlLayout.setVerticalGroup(
            personelPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personelPnlLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(personelPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel1.add(personelPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1000, 370));

        krediBasvuruPnl.setOpaque(false);

        kredilerTbl.setBackground(new java.awt.Color(23, 23, 26));
        kredilerTbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kredilerTbl.setForeground(new java.awt.Color(255, 255, 255));
        kredilerTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "T.C. Kimlik No", "Kredi Miktarı", "Son Ödeme Tarihi", "Kredi Nedeni"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        kredilerTbl.setGridColor(new java.awt.Color(12, 63, 122));
        kredilerTbl.setPreferredSize(new java.awt.Dimension(470, 80));
        kredilerTbl.setRowHeight(20);
        kredilerTbl.setSelectionBackground(new java.awt.Color(29, 121, 212));
        kredilerTbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        kredilerTbl.setShowGrid(true);
        jScrollPane3.setViewportView(kredilerTbl);
        if (kredilerTbl.getColumnModel().getColumnCount() > 0) {
            kredilerTbl.getColumnModel().getColumn(0).setMinWidth(35);
            kredilerTbl.getColumnModel().getColumn(0).setPreferredWidth(35);
            kredilerTbl.getColumnModel().getColumn(0).setMaxWidth(35);
            kredilerTbl.getColumnModel().getColumn(1).setMinWidth(100);
            kredilerTbl.getColumnModel().getColumn(1).setPreferredWidth(100);
            kredilerTbl.getColumnModel().getColumn(1).setMaxWidth(100);
            kredilerTbl.getColumnModel().getColumn(2).setMinWidth(90);
            kredilerTbl.getColumnModel().getColumn(2).setPreferredWidth(90);
            kredilerTbl.getColumnModel().getColumn(2).setMaxWidth(90);
            kredilerTbl.getColumnModel().getColumn(3).setMinWidth(90);
            kredilerTbl.getColumnModel().getColumn(3).setPreferredWidth(90);
            kredilerTbl.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        jButton5.setBackground(new java.awt.Color(12, 63, 122));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Seçili kredi başvurusunu sil");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(12, 63, 122));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Seçili kredi başvurusunu onayla");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout krediBasvuruPnlLayout = new javax.swing.GroupLayout(krediBasvuruPnl);
        krediBasvuruPnl.setLayout(krediBasvuruPnlLayout);
        krediBasvuruPnlLayout.setHorizontalGroup(
            krediBasvuruPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, krediBasvuruPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
        );
        krediBasvuruPnlLayout.setVerticalGroup(
            krediBasvuruPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(krediBasvuruPnlLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(krediBasvuruPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel1.add(krediBasvuruPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 940, 380));

        hesapBasvuruPnl.setBackground(new java.awt.Color(23, 23, 26));
        hesapBasvuruPnl.setOpaque(false);

        hesaplarTbl.setBackground(new java.awt.Color(23, 23, 26));
        hesaplarTbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        hesaplarTbl.setForeground(new java.awt.Color(255, 255, 255));
        hesaplarTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "T.C. Kimlik No", "Hesap Adı", "IBAN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hesaplarTbl.setGridColor(new java.awt.Color(12, 63, 122));
        hesaplarTbl.setOpaque(false);
        hesaplarTbl.setRowHeight(20);
        hesaplarTbl.setSelectionBackground(new java.awt.Color(29, 121, 212));
        hesaplarTbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        hesaplarTbl.setShowGrid(true);
        jScrollPane1.setViewportView(hesaplarTbl);
        if (hesaplarTbl.getColumnModel().getColumnCount() > 0) {
            hesaplarTbl.getColumnModel().getColumn(0).setMinWidth(45);
            hesaplarTbl.getColumnModel().getColumn(0).setPreferredWidth(45);
            hesaplarTbl.getColumnModel().getColumn(0).setMaxWidth(45);
            hesaplarTbl.getColumnModel().getColumn(1).setMinWidth(100);
            hesaplarTbl.getColumnModel().getColumn(1).setPreferredWidth(100);
            hesaplarTbl.getColumnModel().getColumn(1).setMaxWidth(100);
            hesaplarTbl.getColumnModel().getColumn(3).setMinWidth(250);
            hesaplarTbl.getColumnModel().getColumn(3).setPreferredWidth(250);
            hesaplarTbl.getColumnModel().getColumn(3).setMaxWidth(250);
        }

        jButton1.setBackground(new java.awt.Color(12, 63, 122));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Seçili hesap başvurusunu sil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(12, 63, 122));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Seçili hesap başvurusunu onayla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hesapBasvuruPnlLayout = new javax.swing.GroupLayout(hesapBasvuruPnl);
        hesapBasvuruPnl.setLayout(hesapBasvuruPnlLayout);
        hesapBasvuruPnlLayout.setHorizontalGroup(
            hesapBasvuruPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hesapBasvuruPnlLayout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227))
        );
        hesapBasvuruPnlLayout.setVerticalGroup(
            hesapBasvuruPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hesapBasvuruPnlLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(hesapBasvuruPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(hesapBasvuruPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 940, 360));

        kartBasvuruPnl.setOpaque(false);
        kartBasvuruPnl.setLayout(null);

        kartlarTbl.setBackground(new java.awt.Color(23, 23, 26));
        kartlarTbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        kartlarTbl.setForeground(new java.awt.Color(255, 255, 255));
        kartlarTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "T.C. Kimlik No", "Kart Adı", "Kart Numarası", "Kart SKT Ay", "Kart SKT Yıl", "Kart Limiti", "Kart CVV", "Ekstre Tarihi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        kartlarTbl.setGridColor(new java.awt.Color(12, 63, 122));
        kartlarTbl.setPreferredSize(new java.awt.Dimension(470, 80));
        kartlarTbl.setRowHeight(20);
        kartlarTbl.setSelectionBackground(new java.awt.Color(29, 121, 212));
        kartlarTbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        kartlarTbl.setShowGrid(true);
        kartlarTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(kartlarTbl);
        if (kartlarTbl.getColumnModel().getColumnCount() > 0) {
            kartlarTbl.getColumnModel().getColumn(0).setMinWidth(45);
            kartlarTbl.getColumnModel().getColumn(0).setPreferredWidth(45);
            kartlarTbl.getColumnModel().getColumn(0).setMaxWidth(45);
            kartlarTbl.getColumnModel().getColumn(1).setMinWidth(90);
            kartlarTbl.getColumnModel().getColumn(1).setPreferredWidth(90);
            kartlarTbl.getColumnModel().getColumn(1).setMaxWidth(90);
            kartlarTbl.getColumnModel().getColumn(3).setMinWidth(135);
            kartlarTbl.getColumnModel().getColumn(3).setPreferredWidth(135);
            kartlarTbl.getColumnModel().getColumn(3).setMaxWidth(135);
            kartlarTbl.getColumnModel().getColumn(4).setMinWidth(75);
            kartlarTbl.getColumnModel().getColumn(4).setPreferredWidth(75);
            kartlarTbl.getColumnModel().getColumn(4).setMaxWidth(75);
            kartlarTbl.getColumnModel().getColumn(5).setMinWidth(75);
            kartlarTbl.getColumnModel().getColumn(5).setPreferredWidth(75);
            kartlarTbl.getColumnModel().getColumn(5).setMaxWidth(75);
            kartlarTbl.getColumnModel().getColumn(6).setMinWidth(100);
            kartlarTbl.getColumnModel().getColumn(6).setPreferredWidth(100);
            kartlarTbl.getColumnModel().getColumn(6).setMaxWidth(100);
            kartlarTbl.getColumnModel().getColumn(7).setMinWidth(65);
            kartlarTbl.getColumnModel().getColumn(7).setPreferredWidth(65);
            kartlarTbl.getColumnModel().getColumn(7).setMaxWidth(65);
            kartlarTbl.getColumnModel().getColumn(8).setMinWidth(100);
            kartlarTbl.getColumnModel().getColumn(8).setPreferredWidth(100);
            kartlarTbl.getColumnModel().getColumn(8).setMaxWidth(100);
        }

        kartBasvuruPnl.add(jScrollPane2);
        jScrollPane2.setBounds(10, 10, 940, 270);

        jButton3.setBackground(new java.awt.Color(12, 63, 122));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Seçili kart başvurusunu sil");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        kartBasvuruPnl.add(jButton3);
        jButton3.setBounds(500, 320, 221, 48);

        jButton4.setBackground(new java.awt.Color(12, 63, 122));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Seçili kart başvurusunu onayla");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        kartBasvuruPnl.add(jButton4);
        jButton4.setBounds(250, 320, 221, 48);

        jPanel1.add(kartBasvuruPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 960, 370));

        yoneticiPnl.setOpaque(false);

        adP.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        adP.setForeground(new java.awt.Color(255, 255, 255));
        adP.setText("Ad:");
        adP.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        soyadP.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        soyadP.setForeground(new java.awt.Color(255, 255, 255));
        soyadP.setText("Soyad:");
        soyadP.setToolTipText("");
        soyadP.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        tcP.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tcP.setForeground(new java.awt.Color(255, 255, 255));
        tcP.setText("T.C. Kimlik No:");
        tcP.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        dgP.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        dgP.setForeground(new java.awt.Color(255, 255, 255));
        dgP.setText("Doğum Tarihi:");
        dgP.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        telP.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        telP.setForeground(new java.awt.Color(255, 255, 255));
        telP.setText("Telefon:");
        telP.setToolTipText("");
        telP.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        mailP.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mailP.setForeground(new java.awt.Color(255, 255, 255));
        mailP.setText("E-mail:");
        mailP.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        maasP.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        maasP.setForeground(new java.awt.Color(255, 255, 255));
        maasP.setText("Maaş:");
        maasP.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        maasgunP.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        maasgunP.setForeground(new java.awt.Color(255, 255, 255));
        maasgunP.setText("Maaş günü:");
        maasgunP.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jButton9.setBackground(new java.awt.Color(12, 63, 122));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setLabel("E-mail güncelle");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(12, 63, 122));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setLabel("Şifre değiştir");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(12, 63, 122));
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setLabel("Telefon numarasını güncelle");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout yoneticiPnlLayout = new javax.swing.GroupLayout(yoneticiPnl);
        yoneticiPnl.setLayout(yoneticiPnlLayout);
        yoneticiPnlLayout.setHorizontalGroup(
            yoneticiPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yoneticiPnlLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(yoneticiPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telP)
                    .addComponent(dgP)
                    .addComponent(maasgunP)
                    .addComponent(maasP)
                    .addComponent(tcP)
                    .addComponent(mailP)
                    .addComponent(soyadP)
                    .addComponent(adP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 426, Short.MAX_VALUE)
                .addGroup(yoneticiPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(133, 133, 133))
        );
        yoneticiPnlLayout.setVerticalGroup(
            yoneticiPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yoneticiPnlLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(tcP)
                .addGap(18, 18, 18)
                .addGroup(yoneticiPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(yoneticiPnlLayout.createSequentialGroup()
                        .addComponent(adP)
                        .addGap(18, 18, 18)
                        .addComponent(soyadP))
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(yoneticiPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(yoneticiPnlLayout.createSequentialGroup()
                        .addComponent(dgP)
                        .addGap(18, 18, 18)
                        .addComponent(telP))
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(yoneticiPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(yoneticiPnlLayout.createSequentialGroup()
                        .addComponent(mailP)
                        .addGap(18, 18, 18)
                        .addComponent(maasP))
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(maasgunP)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel1.add(yoneticiPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1000, 360));

        yenileBtn.setAlignmentY(0.0F);
        yenileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        yenileBtn.setMaximumSize(new java.awt.Dimension(0, 0));
        yenileBtn.setMinimumSize(new java.awt.Dimension(0, 0));
        yenileBtn.setOpaque(false);
        yenileBtn.setPreferredSize(new java.awt.Dimension(0, 0));
        yenileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yenileBtnActionPerformed(evt);
            }
        });
        jPanel1.add(yenileBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(988, 10, 0, 0));

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
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 475, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ekran.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1000, 550));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        try {
            // TODO add your handling code here:
            jLabel1.setBackground(new Color(21, 46, 121));
            hesapBasvuruPnl.setVisible(true);
            kartBasvuruPnl.setVisible(false);
            krediBasvuruPnl.setVisible(false);
            yoneticiPnl.setVisible(false);
            limitPnl.setVisible(false);
            personelPnl.setVisible(false);
            hesapGetir();
            setbasvuruhesaplarTbl(hesaplarTbl);
            tablodoldur();
        } catch (IOException ex) {
            Logger.getLogger(YoneticiEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel1MousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            Personel.hesapOnay(hesaplarTbl.getValueAt(hesaplarTbl.getSelectedRow(), 1).toString(), hesaplarTbl.getValueAt(hesaplarTbl.getSelectedRow(), 2).toString(), hesaplarTbl.getValueAt(hesaplarTbl.getSelectedRow(), 3).toString());
            hesapGetir();
            setbasvuruhesaplarTbl(hesaplarTbl);
            tablodoldur();
        } catch (IOException ex) {
            Logger.getLogger(YoneticiEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            Personel.hesapSil(hesaplarTbl.getValueAt(hesaplarTbl.getSelectedRow(), 1).toString(), hesaplarTbl.getValueAt(hesaplarTbl.getSelectedRow(), 2).toString(), hesaplarTbl.getValueAt(hesaplarTbl.getSelectedRow(), 3).toString());
            hesapGetir();
            setbasvuruhesaplarTbl(hesaplarTbl);
            tablodoldur();
        } catch (IOException ex) {
            Logger.getLogger(YoneticiEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        try {
            // TODO add your handling code here:
            jLabel2.setBackground(new Color(21, 46, 121));
            hesapBasvuruPnl.setVisible(false);
            krediBasvuruPnl.setVisible(false);
            limitPnl.setVisible(false);
            yoneticiPnl.setVisible(false);
            kartBasvuruPnl.setVisible(true);
            personelPnl.setVisible(false);
            y1.kartGetir();
            y1.setkredikartlariTbl(kartlarTbl);
            kartlartablodoldur();
            y1.setkredikartlariTbl(kartlarTbl);
        } catch (IOException ex) {
            Logger.getLogger(YoneticiEkran.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel2MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            Personel.kartSil(kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 1).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 3).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 4).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 5).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 7).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 6).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 2).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 8).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 6).toString());
            y1.kartGetir();
            y1.setkredikartlariTbl(kartlarTbl);
            kartlartablodoldur();
        } catch (IOException ex) {
            Logger.getLogger(YoneticiEkran.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            Personel.kartOnay(kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 1).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 3).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 4).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 5).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 7).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 6).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 2).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 8).toString() + "/" + kartlarTbl.getValueAt(kartlarTbl.getSelectedRow(), 6).toString());
            y1.kartGetir();
            y1.setkredikartlariTbl(kartlarTbl);
            kartlartablodoldur();
        } catch (IOException ex) {
            Logger.getLogger(YoneticiEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:
            Personel.krediSil(kredilerTbl.getValueAt(kredilerTbl.getSelectedRow(), 1).toString() + "/" + kredilerTbl.getValueAt(kredilerTbl.getSelectedRow(), 2).toString() + "/" + kredilerTbl.getValueAt(kredilerTbl.getSelectedRow(), 2).toString() + "/" + kredilerTbl.getValueAt(kredilerTbl.getSelectedRow(), 3).toString(), kredilerTbl.getValueAt(kredilerTbl.getSelectedRow(), 4).toString());
            krediGetir();
            setkredilerTbl(kredilerTbl);
            kreditablodoldur();
        } catch (IOException ex) {
            Logger.getLogger(YoneticiEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
            Personel.krediOnay(kredilerTbl.getValueAt(kredilerTbl.getSelectedRow(), 1).toString() + "/" + kredilerTbl.getValueAt(kredilerTbl.getSelectedRow(), 2).toString() + "/" + kredilerTbl.getValueAt(kredilerTbl.getSelectedRow(), 2).toString() + "/" + kredilerTbl.getValueAt(kredilerTbl.getSelectedRow(), 3).toString(), kredilerTbl.getValueAt(kredilerTbl.getSelectedRow(), 4).toString());
            krediGetir();
            setkredilerTbl(kredilerTbl);
            kreditablodoldur();
        } catch (IOException ex) {
            Logger.getLogger(YoneticiEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        try {
            // TODO add your handling code here:
            jLabel3.setBackground(new Color(21, 46, 121));
            krediGetir();
            setkredilerTbl(kredilerTbl);
            kreditablodoldur();
            hesapBasvuruPnl.setVisible(false);
            kartBasvuruPnl.setVisible(false);
            personelPnl.setVisible(false);
            krediBasvuruPnl.setVisible(true);
            yoneticiPnl.setVisible(false);
            limitPnl.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(YoneticiEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel3MousePressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Personel.limitSil((limitTbl.getValueAt(limitTbl.getSelectedRow(), 1).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 3).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 4).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 5).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 6).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 8).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 2).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 9).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 10).toString()), (limitTbl.getValueAt(limitTbl.getSelectedRow(), 1).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 3).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 4).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 5).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 6).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 7).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 2).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 9).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 10).toString()));

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Personel.limitOnay((limitTbl.getValueAt(limitTbl.getSelectedRow(), 1).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 3).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 4).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 5).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 6).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 8).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 2).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 9).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 10).toString()), (limitTbl.getValueAt(limitTbl.getSelectedRow(), 1).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 3).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 4).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 5).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 6).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 7).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 2).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 9).toString() + "/" + limitTbl.getValueAt(limitTbl.getSelectedRow(), 10).toString()));

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        try {
            // TODO add your handling code here:
            jLabel4.setBackground(new Color(21, 46, 121));
            limitPnl.setVisible(true);
            hesapBasvuruPnl.setVisible(false);
            personelPnl.setVisible(false);
            yoneticiPnl.setVisible(false);
            kartBasvuruPnl.setVisible(false);
            krediBasvuruPnl.setVisible(false);
            limitGetir();
            setlimitTbl(limitTbl);
            limittablodoldur();
        } catch (IOException ex) {
            Logger.getLogger(YoneticiEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        // TODO add your handling code here:
        jLabel5.setBackground(new Color(21, 46, 121));
        limitPnl.setVisible(false);
        hesapBasvuruPnl.setVisible(false);
        kartBasvuruPnl.setVisible(false);
        krediBasvuruPnl.setVisible(false);
        personelPnl.setVisible(false);
        yoneticiPnl.setVisible(true);
    }//GEN-LAST:event_jLabel5MousePressed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String mail = JOptionPane.showInputDialog("Lütfen yeni E-mail giriniz.");
        //y1.mailDegistir(y1, mail);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        String eskisifre = JOptionPane.showInputDialog("Lütfen eski şifrenizi giriniz.");
        String yenisifre = JOptionPane.showInputDialog("Lütfen yeni şifrenizi giriniz.");
        //y1.sifreDegistir(y1, eskisifre, yenisifre);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        String tel = JOptionPane.showInputDialog("Lütfen yeni telefon numaranızı giriniz.");
        //y1.telDegistir(y1, tel);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        try {
            // TODO add your handling code here:
            jLabel7.setBackground(new Color(21, 46, 121));
            personelGetir();
            setpersonelTbl(personelTbl);
            personeltablodoldur();
            personelPnl.setVisible(true);
            limitPnl.setVisible(false);
            hesapBasvuruPnl.setVisible(false);
            kartBasvuruPnl.setVisible(false);
            krediBasvuruPnl.setVisible(false);
            yoneticiPnl.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(YoneticiEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }//GEN-LAST:event_jLabel7MousePressed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        System.out.println(personelTbl.getValueAt(personelTbl.getSelectedRow(),4));
        PersonelGuncelle pg = new PersonelGuncelle(y1,yenileBtn,personelTbl);
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        Yonetici.personelSil(personelTbl.getValueAt(personelTbl.getSelectedRow(),1).toString()+"/"+personelTbl.getValueAt(personelTbl.getSelectedRow(),5).toString()+"/"+personelTbl.getValueAt(personelTbl.getSelectedRow(),4).toString()+"/"+personelTbl.getValueAt(personelTbl.getSelectedRow(),2).toString()+"/"+personelTbl.getValueAt(personelTbl.getSelectedRow(),3).toString()+"/"+personelTbl.getValueAt(personelTbl.getSelectedRow(),6).toString()+"/"+personelTbl.getValueAt(personelTbl.getSelectedRow(),7).toString()+"/"+personelTbl.getValueAt(personelTbl.getSelectedRow(),8).toString()+"/"+personelTbl.getValueAt(personelTbl.getSelectedRow(),9).toString()+"/"+personelTbl.getValueAt(personelTbl.getSelectedRow(),10).toString());
        yenileBtn.doClick();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
            PersonelKaydet pk = new PersonelKaydet(y1,yenileBtn);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void yenileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yenileBtnActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
        
        personelGetir();
        setpersonelTbl(personelTbl);
        personeltablodoldur();
        personelGetir();
        setpersonelTbl(personelTbl);
        personeltablodoldur();

        } catch (IOException ex) {
            Logger.getLogger(MusteriEkran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_yenileBtnActionPerformed

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        jLabel2.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
        jLabel3.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        jLabel4.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // TODO add your handling code here:
        jLabel5.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        // TODO add your handling code here:
        jLabel7.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        jLabel1.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel5.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased
        jLabel1.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_jLabel1MouseReleased

    private void jLabel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseReleased
        jLabel2.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_jLabel2MouseReleased

    private void jLabel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseReleased
        jLabel3.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_jLabel3MouseReleased

    private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased
        jLabel4.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_jLabel4MouseReleased

    private void jLabel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseReleased
        jLabel5.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_jLabel5MouseReleased

    private void jLabel7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseReleased
        jLabel7.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_jLabel7MouseReleased

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked

        this.dispose();
        A.setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

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
            java.util.logging.Logger.getLogger(YoneticiEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YoneticiEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YoneticiEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YoneticiEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adP;
    private javax.swing.JLabel dgP;
    private javax.swing.JPanel hesapBasvuruPnl;
    private javax.swing.JTable hesaplarTbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel kartBasvuruPnl;
    private javax.swing.JTable kartlarTbl;
    private javax.swing.JPanel krediBasvuruPnl;
    private javax.swing.JTable kredilerTbl;
    private javax.swing.JPanel limitPnl;
    private javax.swing.JTable limitTbl;
    private javax.swing.JLabel maasP;
    private javax.swing.JLabel maasgunP;
    private javax.swing.JLabel mailP;
    private javax.swing.JPanel personelPnl;
    private javax.swing.JTable personelTbl;
    private javax.swing.JLabel soyadP;
    private javax.swing.JLabel tcP;
    private javax.swing.JLabel telP;
    private javax.swing.JButton yenileBtn;
    private javax.swing.JPanel yoneticiPnl;
    // End of variables declaration//GEN-END:variables
}
