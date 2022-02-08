package bankacilik;

import static bankacilik.SifreUnuttum.B;
import bankacilik.MusteriKaydol.*;
import static bankacilik.MusteriKaydol.C;
import java.awt.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.text.MaskFormatter;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static bankacilik.Kullanici.giristmm;
import javax.swing.ImageIcon;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/bank.png")).getImage());
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Emin Bank Giriş Ekranı");
        setResizable(false);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        LocalDateTime now = LocalDateTime.now();
        jLabel2.setText(dtf.format(now));
        dtf = DateTimeFormatter.ofPattern("EEEE");
        jLabel3.setText(dtf.format(now));
        personelPanel.setVisible(false);
        yoneticiPanel.setVisible(false);
        errorLbl1.setVisible(false);
        errorLbl2.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        musteriBtn = new javax.swing.JLabel();
        personelBtn = new javax.swing.JLabel();
        yoneticiBtn = new javax.swing.JLabel();
        creditcard = new javax.swing.JLabel();
        tl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        mottoText = new javax.swing.JLabel();
        welcomeText = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        entranceinf = new javax.swing.JLabel();
        musteriPanel = new javax.swing.JPanel();
        kimlikLbl = new javax.swing.JLabel();
        passText = new javax.swing.JPasswordField();
        passLbl = new javax.swing.JLabel();
        girisBtn = new javax.swing.JButton();
        iforgot = new javax.swing.JLabel();
        try{
            MaskFormatter mf= new MaskFormatter("###########");
            tcText = new javax.swing.JFormattedTextField(mf);
        }

        catch (ParseException e){}
        errorLbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        yoneticiPanel = new javax.swing.JPanel();
        kimlikLbl2 = new javax.swing.JLabel();
        passTexty = new javax.swing.JPasswordField();
        passLbl2 = new javax.swing.JLabel();
        girisBtny = new javax.swing.JButton();
        try{
            MaskFormatter mf= new MaskFormatter("###########");
            tcText = new javax.swing.JFormattedTextField(mf);
            tcTexty = new javax.swing.JFormattedTextField(mf);
        }

        catch (ParseException e){}
        errorLbl2 = new javax.swing.JLabel();
        personelPanel = new javax.swing.JPanel();
        kimlikLbl1 = new javax.swing.JLabel();
        passTextp = new javax.swing.JPasswordField();
        passLbl1 = new javax.swing.JLabel();
        girisBtnp = new javax.swing.JButton();
        try{
            MaskFormatter mf= new MaskFormatter("###########");
            tcText = new javax.swing.JFormattedTextField(mf);
            tcTextp = new javax.swing.JFormattedTextField(mf);
        }

        catch (ParseException e){}
        errorLbl1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));
        mainpanel.setOpaque(false);
        mainpanel.setPreferredSize(new java.awt.Dimension(800, 600));
        mainpanel.setLayout(null);

        jPanel3.setOpaque(false);

        musteriBtn.setBackground(new java.awt.Color(12, 63, 122));
        musteriBtn.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        musteriBtn.setForeground(new java.awt.Color(255, 255, 255));
        musteriBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        musteriBtn.setText("MÜŞTERİ");
        musteriBtn.setMaximumSize(new java.awt.Dimension(94, 40));
        musteriBtn.setMinimumSize(new java.awt.Dimension(94, 40));
        musteriBtn.setOpaque(true);
        musteriBtn.setPreferredSize(new java.awt.Dimension(94, 40));
        musteriBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                musteriBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                musteriBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                musteriBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                musteriBtnMouseReleased(evt);
            }
        });

        personelBtn.setBackground(new java.awt.Color(12, 63, 122));
        personelBtn.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        personelBtn.setForeground(new java.awt.Color(255, 255, 255));
        personelBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        personelBtn.setText("PERSONEL");
        personelBtn.setMaximumSize(new java.awt.Dimension(94, 40));
        personelBtn.setMinimumSize(new java.awt.Dimension(94, 40));
        personelBtn.setOpaque(true);
        personelBtn.setPreferredSize(new java.awt.Dimension(94, 40));
        personelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                personelBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                personelBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                personelBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                personelBtnMouseReleased(evt);
            }
        });

        yoneticiBtn.setBackground(new java.awt.Color(12, 63, 122));
        yoneticiBtn.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        yoneticiBtn.setForeground(new java.awt.Color(255, 255, 255));
        yoneticiBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yoneticiBtn.setText("YÖNETİCİ");
        yoneticiBtn.setMaximumSize(new java.awt.Dimension(94, 40));
        yoneticiBtn.setMinimumSize(new java.awt.Dimension(94, 40));
        yoneticiBtn.setOpaque(true);
        yoneticiBtn.setPreferredSize(new java.awt.Dimension(94, 40));
        yoneticiBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                yoneticiBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                yoneticiBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                yoneticiBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                yoneticiBtnMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(musteriBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(personelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yoneticiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(musteriBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yoneticiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainpanel.add(jPanel3);
        jPanel3.setBounds(470, 120, 274, 52);

        creditcard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/credit-card.png"))); // NOI18N
        mainpanel.add(creditcard);
        creditcard.setBounds(670, 490, 130, 110);

        tl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lira.png"))); // NOI18N
        tl.setText("jLabel11");
        mainpanel.add(tl);
        tl.setBounds(0, 490, 120, 100);

        jPanel1.setOpaque(false);

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bank.png"))); // NOI18N

        mottoText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mottoText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/welcome2.png"))); // NOI18N

        welcomeText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/welcome.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mottoText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(welcomeText))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mottoText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        mainpanel.add(jPanel1);
        jPanel1.setBounds(50, 100, 300, 310);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/separator.png"))); // NOI18N
        mainpanel.add(jLabel4);
        jLabel4.setBounds(400, 60, 15, 380);

        entranceinf.setForeground(new java.awt.Color(255, 255, 255));
        entranceinf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        entranceinf.setText("Şu anda müşteri olarak giriş yapıyorsunuz.");
        mainpanel.add(entranceinf);
        entranceinf.setBounds(480, 180, 260, 16);

        musteriPanel.setOpaque(false);
        musteriPanel.setLayout(null);

        kimlikLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kimlikLbl.setForeground(new java.awt.Color(255, 255, 255));
        kimlikLbl.setText("T.C. Kimlik No:");
        musteriPanel.add(kimlikLbl);
        kimlikLbl.setBounds(15, 16, 99, 20);

        passText.setBackground(new java.awt.Color(12, 63, 122));
        passText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        passText.setForeground(new java.awt.Color(255, 255, 255));
        passText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        passText.setToolTipText("<html>\nŞifrenizi giriniz.\n<html>");
        passText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        musteriPanel.add(passText);
        passText.setBounds(120, 56, 148, 20);

        passLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passLbl.setForeground(new java.awt.Color(255, 255, 255));
        passLbl.setText("Şifre:");
        musteriPanel.add(passLbl);
        passLbl.setBounds(79, 55, 35, 20);

        girisBtn.setBackground(new java.awt.Color(12, 63, 122));
        girisBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        girisBtn.setForeground(new java.awt.Color(255, 255, 255));
        girisBtn.setText("Giriş Yap");
        girisBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                girisBtnMousePressed(evt);
            }
        });
        musteriPanel.add(girisBtn);
        girisBtn.setBounds(162, 94, 106, 30);

        iforgot.setBackground(new java.awt.Color(29, 121, 212));
        iforgot.setFont(new java.awt.Font("Segoe UI", 2, 11)); // NOI18N
        iforgot.setForeground(new java.awt.Color(29, 121, 212));
        iforgot.setText("Şifrenizi mi unuttunuz?");
        iforgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iforgotMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iforgotMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iforgotMouseExited(evt);
            }
        });
        musteriPanel.add(iforgot);
        iforgot.setBounds(10, 100, 130, 15);
        iforgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        tcText.setBackground(new java.awt.Color(12, 63, 122));
        tcText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tcText.setForeground(new java.awt.Color(255, 255, 255));
        try {
            tcText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tcText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tcText.setText("");
        tcText.setToolTipText("<html>\nT.C. Kimlik Numaranızı giriniz.\n<html>");
        tcText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcTextActionPerformed(evt);
            }
        });
        musteriPanel.add(tcText);
        tcText.setBounds(120, 17, 148, 20);

        errorLbl.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        errorLbl.setForeground(new java.awt.Color(255, 0, 0));
        errorLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLbl.setText("Hatalı giriş yaptınız! Lütfen tekrar deneyiniz.");
        errorLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        errorLbl.setVisible(false);
        musteriPanel.add(errorLbl);
        errorLbl.setBounds(0, 170, 274, 20);

        jButton1.setBackground(new java.awt.Color(12, 63, 122));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Kaydol");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        musteriPanel.add(jButton1);
        jButton1.setBounds(162, 128, 106, 30);

        mainpanel.add(musteriPanel);
        musteriPanel.setBounds(470, 200, 274, 200);

        yoneticiPanel.setOpaque(false);
        yoneticiPanel.setLayout(null);

        kimlikLbl2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kimlikLbl2.setForeground(new java.awt.Color(255, 255, 255));
        kimlikLbl2.setText("T.C. Kimlik No:");
        yoneticiPanel.add(kimlikLbl2);
        kimlikLbl2.setBounds(15, 16, 99, 20);

        passTexty.setBackground(new java.awt.Color(12, 63, 122));
        passTexty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        passTexty.setForeground(new java.awt.Color(255, 255, 255));
        passTexty.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        passTexty.setToolTipText("<html>\nŞifrenizi giriniz.\n<html>");
        passTexty.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        yoneticiPanel.add(passTexty);
        passTexty.setBounds(120, 56, 148, 20);

        passLbl2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passLbl2.setForeground(new java.awt.Color(255, 255, 255));
        passLbl2.setText("Şifre:");
        yoneticiPanel.add(passLbl2);
        passLbl2.setBounds(79, 55, 35, 20);

        girisBtny.setBackground(new java.awt.Color(12, 63, 122));
        girisBtny.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        girisBtny.setForeground(new java.awt.Color(255, 255, 255));
        girisBtny.setText("Giriş Yap");
        girisBtny.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                girisBtnyMousePressed(evt);
            }
        });
        girisBtny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girisBtnyActionPerformed(evt);
            }
        });
        yoneticiPanel.add(girisBtny);
        girisBtny.setBounds(150, 107, 106, 26);

        tcTexty.setBackground(new java.awt.Color(12, 63, 122));
        tcTexty.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tcTexty.setForeground(new java.awt.Color(255, 255, 255));
        try {
            tcTexty.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tcTexty.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tcTexty.setText("");
        tcTexty.setToolTipText("<html>\nT.C. Kimlik Numaranızı giriniz.\n<html>");
        yoneticiPanel.add(tcTexty);
        tcTexty.setBounds(120, 17, 148, 20);

        errorLbl2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        errorLbl2.setForeground(new java.awt.Color(255, 0, 0));
        errorLbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLbl2.setText("Hatalı giriş yaptınız! Lütfen tekrar deneyiniz.");
        errorLbl.setVisible(false);
        yoneticiPanel.add(errorLbl2);
        errorLbl2.setBounds(0, 153, 274, 20);

        mainpanel.add(yoneticiPanel);
        yoneticiPanel.setBounds(470, 200, 274, 190);

        personelPanel.setOpaque(false);
        personelPanel.setLayout(null);

        kimlikLbl1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kimlikLbl1.setForeground(new java.awt.Color(255, 255, 255));
        kimlikLbl1.setText("T.C. Kimlik No:");
        personelPanel.add(kimlikLbl1);
        kimlikLbl1.setBounds(15, 16, 99, 20);

        passTextp.setBackground(new java.awt.Color(12, 63, 122));
        passTextp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        passTextp.setForeground(new java.awt.Color(255, 255, 255));
        passTextp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        passTextp.setToolTipText("<html>\nŞifrenizi giriniz.\n<html>");
        passTextp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        personelPanel.add(passTextp);
        passTextp.setBounds(120, 56, 148, 20);

        passLbl1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passLbl1.setForeground(new java.awt.Color(255, 255, 255));
        passLbl1.setText("Şifre:");
        personelPanel.add(passLbl1);
        passLbl1.setBounds(79, 55, 35, 20);

        girisBtnp.setBackground(new java.awt.Color(12, 63, 122));
        girisBtnp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        girisBtnp.setForeground(new java.awt.Color(255, 255, 255));
        girisBtnp.setText("Giriş Yap");
        girisBtnp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                girisBtnpMousePressed(evt);
            }
        });
        girisBtnp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girisBtnpActionPerformed(evt);
            }
        });
        personelPanel.add(girisBtnp);
        girisBtnp.setBounds(150, 107, 106, 26);

        tcTextp.setBackground(new java.awt.Color(12, 63, 122));
        tcTextp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tcTextp.setForeground(new java.awt.Color(255, 255, 255));
        try {
            tcTextp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tcTextp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tcTextp.setText("");
        tcTextp.setToolTipText("<html>\nT.C. Kimlik Numaranızı giriniz.\n<html>");
        tcTextp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcTextpActionPerformed(evt);
            }
        });
        personelPanel.add(tcTextp);
        tcTextp.setBounds(120, 17, 148, 20);

        errorLbl1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        errorLbl1.setForeground(new java.awt.Color(255, 0, 0));
        errorLbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLbl1.setText("Hatalı giriş yaptınız! Lütfen tekrar deneyiniz.");
        errorLbl.setVisible(false);
        personelPanel.add(errorLbl1);
        errorLbl1.setBounds(0, 153, 274, 20);

        mainpanel.add(personelPanel);
        personelPanel.setBounds(470, 200, 274, 190);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        mainpanel.add(background);
        background.setBounds(0, 0, 800, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void musteriBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musteriBtnMouseEntered
        // TODO add your handling code here:

        musteriBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_musteriBtnMouseEntered

    private void musteriBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musteriBtnMouseExited
        // TODO add your handling code here:
        musteriBtn.setBackground(new Color(12, 63, 122));

    }//GEN-LAST:event_musteriBtnMouseExited

    private void musteriBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musteriBtnMousePressed
        // TODO add your handling code here:

        musteriBtn.setBackground(new Color(21, 46, 121));
        entranceinf.setText("Şu anda müşteri olarak giriş yapıyorsunuz.");
        musteriPanel.setVisible(true);
        personelPanel.setVisible(false);
        yoneticiPanel.setVisible(false);

    }//GEN-LAST:event_musteriBtnMousePressed

    private void musteriBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musteriBtnMouseReleased
        // TODO add your handling code here:
        musteriBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_musteriBtnMouseReleased

    private void personelBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personelBtnMouseEntered
        // TODO add your handling code here:
        personelBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_personelBtnMouseEntered

    private void personelBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personelBtnMouseExited
        // TODO add your handling code here:
        personelBtn.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_personelBtnMouseExited

    private void personelBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personelBtnMousePressed
        // TODO add your handling code here:
        errorLbl1.setVisible(false);
        personelBtn.setBackground(new Color(21, 46, 121));
        musteriPanel.setVisible(false);
        yoneticiPanel.setVisible(false);
        entranceinf.setText("Şu anda personel olarak giriş yapıyorsunuz.");
        personelPanel.setVisible(true);
    }//GEN-LAST:event_personelBtnMousePressed

    private void personelBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personelBtnMouseReleased
        // TODO add your handling code here:
        personelBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_personelBtnMouseReleased

    private void yoneticiBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yoneticiBtnMouseEntered
        // TODO add your handling code here:
        yoneticiBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_yoneticiBtnMouseEntered

    private void yoneticiBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yoneticiBtnMouseExited
        // TODO add your handling code here:
        yoneticiBtn.setBackground(new Color(12, 63, 122));
    }//GEN-LAST:event_yoneticiBtnMouseExited

    private void yoneticiBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yoneticiBtnMousePressed
        // TODO add your handling code here:
        yoneticiBtn.setBackground(new Color(21, 46, 121));
        entranceinf.setText("Şu anda yönetici olarak giriş yapıyorsunuz.");
        musteriPanel.setVisible(false);
        errorLbl2.setVisible(false);
        personelPanel.setVisible(false);
        yoneticiPanel.setVisible(true);
    }//GEN-LAST:event_yoneticiBtnMousePressed

    private void yoneticiBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yoneticiBtnMouseReleased
        // TODO add your handling code here:
        yoneticiBtn.setBackground(new Color(29, 121, 212));
    }//GEN-LAST:event_yoneticiBtnMouseReleased

    private void iforgotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iforgotMouseEntered
        // TODO add your handling code here:
        iforgot.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_iforgotMouseEntered

    private void iforgotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iforgotMouseExited
        // TODO add your handling code here:

        iforgot.setForeground(new Color(29, 121, 212));
    }//GEN-LAST:event_iforgotMouseExited

    private void iforgotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iforgotMouseClicked
        // TODO add your handling code here:
        B.setVisible(true);
    }//GEN-LAST:event_iforgotMouseClicked

    private void girisBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_girisBtnMousePressed
        try {
            Musteri m1 = new Musteri(Long.valueOf(tcText.getText()));
            // TODO add your handling code here:
            if (m1.giris(tcText.getText(), String.valueOf(passText.getPassword())) == null) {
                errorLbl.setText("Hatalı giriş yaptınız! Lütfen tekrar deneyiniz.");
                errorLbl.setVisible(true);
            }
            else{
                giristmm(m1);
                errorLbl.setVisible(false);
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_girisBtnMousePressed

    private void girisBtnpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_girisBtnpMousePressed
        // TODO add your handling code here:
        try {
            Personel p1 = new Personel(Long.valueOf(tcTextp.getText()));
            // TODO add your handling code here:
            if (p1.giris(tcTextp.getText(), String.valueOf(passTextp.getPassword())) == null) {
                errorLbl1.setText("Hatalı giriş yaptınız! Lütfen tekrar deneyiniz.");
                errorLbl1.setVisible(true);
            }
            else{
                giristmm(p1);
                errorLbl1.setVisible(false);
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_girisBtnpMousePressed

    private void girisBtnyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_girisBtnyMousePressed
        // TODO add your handling code here:
        try {
            Yonetici y1 = new Yonetici(Long.valueOf(tcTexty.getText()));
            // TODO add your handling code here:
            if (y1.giris(tcTexty.getText(), String.valueOf(passTexty.getPassword())) == null) {
                errorLbl2.setText("Hatalı giriş yaptınız! Lütfen tekrar deneyiniz.");
                errorLbl2.setVisible(true);
            }
            else{
                giristmm(y1);
                errorLbl2.setVisible(false);
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_girisBtnyMousePressed

    private void tcTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcTextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        C.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void girisBtnpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girisBtnpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_girisBtnpActionPerformed

    private void tcTextpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcTextpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcTextpActionPerformed

    private void girisBtnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girisBtnyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_girisBtnyActionPerformed

    static Login A = new Login();

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel creditcard;
    private javax.swing.JLabel entranceinf;
    private javax.swing.JLabel errorLbl;
    private javax.swing.JLabel errorLbl1;
    private javax.swing.JLabel errorLbl2;
    private javax.swing.JButton girisBtn;
    private javax.swing.JButton girisBtnp;
    private javax.swing.JButton girisBtny;
    private javax.swing.JLabel iforgot;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel kimlikLbl;
    private javax.swing.JLabel kimlikLbl1;
    private javax.swing.JLabel kimlikLbl2;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JLabel mottoText;
    private javax.swing.JLabel musteriBtn;
    private javax.swing.JPanel musteriPanel;
    private javax.swing.JLabel passLbl;
    private javax.swing.JLabel passLbl1;
    private javax.swing.JLabel passLbl2;
    private javax.swing.JPasswordField passText;
    private javax.swing.JPasswordField passTextp;
    private javax.swing.JPasswordField passTexty;
    private javax.swing.JLabel personelBtn;
    private javax.swing.JPanel personelPanel;
    public javax.swing.JFormattedTextField tcText;
    public javax.swing.JFormattedTextField tcTextp;
    public javax.swing.JFormattedTextField tcTexty;
    private javax.swing.JLabel tl;
    private javax.swing.JLabel welcomeText;
    private javax.swing.JLabel yoneticiBtn;
    private javax.swing.JPanel yoneticiPanel;
    // End of variables declaration//GEN-END:variables
}
