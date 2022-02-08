package bankacilik;

import static bankacilik.MusteriEkran.hesapGetir;
import static bankacilik.MusteriEkran.krediGetir;
import static bankacilik.MusteriEkran.sethesaplarTbl;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class KrediBorcOde extends javax.swing.JFrame {

    JTable hesaplartable;
    JTable kredilertable;
    Musteri m1;
    Double borc;
    Double kredi;
    int row2;
    JButton btn;

    public KrediBorcOde(Musteri m1, Double borc, Double kredi, JTable hesaplartable, JTable kredilertable, int row2, JButton btn) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/images/bank.png")).getImage());
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Kredi Borç Ödeme");
        jScrollPane1.getViewport().setBackground(new Color(23, 23, 26));
        this.m1 = m1;
        this.btn = btn;
        this.borc = borc;
        this.kredi = kredi;
        this.row2 = row2;
        this.hesaplartable = hesaplartable;
        this.kredilertable = kredilertable;
        kredihesaplartablodoldur();
    }

    public void kredihesaplartablodoldur() {
        DefaultTableModel m = (DefaultTableModel) kredihesTbl.getModel();
        m.setRowCount(0);
        try {
            ArrayList<Object[]> hesaplar2 = hesapGetir(m1);
            for (int i = 0; i < hesaplar2.size(); i++) {
                m.addRow(hesaplar2.get(i));
            }
            sethesaplarTbl(m1, kredihesTbl);
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        kredihesTbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(23, 23, 26));
        jPanel1.setMinimumSize(new java.awt.Dimension(770, 458));
        jPanel1.setLayout(null);

        kredihesTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Hesap adı", "Hesap numarası", "Hesap türü", "Bakiye"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(kredihesTbl);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 50, 770, 160);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ödeme yapmak istediğiniz hesabı seçiniz.");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 320, 20);

        jButton1.setText("Bu hesaptan öde");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(310, 260, 150, 24);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int row = kredihesTbl.getSelectedRow();
            String miktar = JOptionPane.showInputDialog(null, "Lütfen ödemek istediğiniz miktarı giriniz.");
            if (Double.valueOf(miktar) <= 0) {
                JOptionPane.showMessageDialog(null, "Bu miktarda ödeme yapamazsınız!");
            } else if (Double.valueOf(miktar) > Double.valueOf(kredihesTbl.getValueAt(row, 4).toString())) {
                JOptionPane.showMessageDialog(null, "Hesabınızda bu kadar bakiye bulunmuyor!");
            } else if (Double.valueOf(miktar) > borc) {
                JOptionPane.showMessageDialog(null, "Borcunuzdan fazla ödeme yapamazsınız!");
            } else {
                m1.krediOde(m1, String.valueOf(kredi), String.valueOf(borc), miktar, kredihesTbl.getValueAt(row, 2).toString());
                sethesaplarTbl(m1, kredihesTbl);
                sethesaplarTbl(m1, hesaplartable);
                hesapGetir(m1);
                krediGetir(m1);
                kredihesaplartablodoldur();
                btn.doClick();
                borc = borc - Double.valueOf(miktar);
                this.dispose();
            }

        } catch (IOException ex) {
            Logger.getLogger(KrediBorcOde.class.getName()).log(Level.SEVERE, null, ex);

        }
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KrediBorcOde.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KrediBorcOde.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KrediBorcOde.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KrediBorcOde.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable kredihesTbl;
    // End of variables declaration//GEN-END:variables
}
