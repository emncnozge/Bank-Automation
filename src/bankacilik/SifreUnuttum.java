package bankacilik;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class SifreUnuttum extends javax.swing.JFrame {
    public SifreUnuttum() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/bank.png")).getImage());
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Şifremi Unuttum");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        try{
            MaskFormatter mf= new MaskFormatter("###########");
            tcText = new javax.swing.JFormattedTextField(mf);
            tcText = new javax.swing.JFormattedTextField(mf);
        }

        catch (ParseException e){}
        kimlikLbl = new javax.swing.JLabel();
        kimlikLbl1 = new javax.swing.JLabel();
        annekizlik = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        errorLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(null);

        tcText.setBackground(new java.awt.Color(12, 63, 122));
        tcText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tcText.setForeground(new java.awt.Color(255, 255, 255));
        tcText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tcText.setToolTipText("<html>\nT.C. Kimlik Numaranızı giriniz.\n<html>");
        jPanel2.add(tcText);
        tcText.setBounds(210, 80, 120, 20);

        kimlikLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kimlikLbl.setForeground(new java.awt.Color(255, 255, 255));
        kimlikLbl.setText("T.C. Kimlik No:");
        jPanel2.add(kimlikLbl);
        kimlikLbl.setBounds(100, 80, 99, 20);

        kimlikLbl1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kimlikLbl1.setForeground(new java.awt.Color(255, 255, 255));
        kimlikLbl1.setText("Anne Kızlık Soyadı:");
        kimlikLbl1.setToolTipText("");
        jPanel2.add(kimlikLbl1);
        kimlikLbl1.setBounds(70, 120, 130, 20);

        annekizlik.setBackground(new java.awt.Color(12, 63, 122));
        annekizlik.setForeground(new java.awt.Color(255, 255, 255));
        annekizlik.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        annekizlik.setToolTipText("<html>\nAnne kızlık soyadınızı giriniz.\n<html>");
        annekizlik.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(annekizlik);
        annekizlik.setBounds(210, 120, 120, 20);

        jButton1.setBackground(new java.awt.Color(12, 63, 122));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Şifre Göster");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(140, 160, 120, 30);

        errorLbl.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        errorLbl.setForeground(new java.awt.Color(255, 0, 0));
        errorLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLbl.setText("Hatalı giriş yaptınız! Lütfen tekrar deneyiniz.");
        errorLbl.setVisible(false);
        jPanel2.add(errorLbl);
        errorLbl.setBounds(90, 200, 239, 16);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundForgot.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 400, 300);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents
public String pass2(String pass) throws FileNotFoundException, IOException {
        File file = new File("src/files/musteriInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            if (st.split("/")[0].equals(pass)) {
                return st.split("/")[2];
            } 
            }
        br.close();
        return "";
        }

public String pass3(String pass) throws FileNotFoundException, IOException {
        File file = new File("src/files/musteriInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            if (st.split("/")[0].equals(pass)) {
                br.close();
                return st.split("/")[1];
            }
        }
        br.close();
        return "";
    }
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            if(pass2(tcText.getText()).toLowerCase().equals(annekizlik.getText().toLowerCase())){
                errorLbl.setVisible(false);
                JOptionPane.showMessageDialog(null, "Şifreniz: " + pass3(tcText.getText()), "Sonuç" , JOptionPane.INFORMATION_MESSAGE);
            }
            else errorLbl.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(SifreUnuttum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SifreUnuttum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold
        
        //</editor-fold
    }
static SifreUnuttum B = new SifreUnuttum();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField annekizlik;
    private javax.swing.JLabel errorLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel kimlikLbl;
    private javax.swing.JLabel kimlikLbl1;
    public javax.swing.JFormattedTextField tcText;
    // End of variables declaration//GEN-END:variables
}
