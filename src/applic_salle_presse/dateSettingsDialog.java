package applic_salle_presse;

import java.text.DateFormat;
import java.util.Locale;

/**
 *
 * @author Eliott
 */
public class dateSettingsDialog extends javax.swing.JDialog {

    private mainWindow mw;
    public dateSettingsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mw = (mainWindow)parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelParamDate = new javax.swing.JLabel();
        jLabelPays = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelTemps = new javax.swing.JLabel();
        jComboBoxPays = new javax.swing.JComboBox<>();
        jComboBoxFDate = new javax.swing.JComboBox<>();
        jComboBoxFHeure = new javax.swing.JComboBox<>();
        jButtonAppliquer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelParamDate.setText("Paramètres date");

        jLabelPays.setText("Pays");

        jLabelDate.setText("Format Date");

        jLabelTemps.setText("Format Temps ");

        jComboBoxPays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " France", "Royaume Uni", "Allemagne", "Italie", "U.S.A." }));
        jComboBoxPays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPaysActionPerformed(evt);
            }
        });

        jComboBoxFDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "short", "medium", "full" }));

        jComboBoxFHeure.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "short", "medium", "full" }));
        jComboBoxFHeure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFHeureActionPerformed(evt);
            }
        });

        jButtonAppliquer.setText("Appliquer");
        jButtonAppliquer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAppliquerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDate)
                    .addComponent(jLabelPays, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTemps))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAppliquer)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelParamDate)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxPays, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxFDate, 0, 161, Short.MAX_VALUE)
                            .addComponent(jComboBoxFHeure, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(88, 88, 88))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabelParamDate)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPays)
                    .addComponent(jComboBoxPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDate)
                    .addComponent(jComboBoxFDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTemps)
                    .addComponent(jComboBoxFHeure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAppliquer)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxFHeureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFHeureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFHeureActionPerformed

    private void jButtonAppliquerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAppliquerActionPerformed
        // TODO add your handling code here:
        int dfHeure; 
        int dfDate;
        Locale pays;
        switch(jComboBoxPays.getSelectedIndex())
        {
            case 0 : pays = Locale.FRANCE;
                     break;
            case 1 : pays = Locale.UK;
                     break;
            case 2 : pays = Locale.GERMANY;
                     break;
            case 3 : pays = Locale.ITALY;
                     break;
            case 4 : pays = Locale.US;
                     break;
            default : pays = Locale.FRANCE;
        }
        switch(jComboBoxFHeure.getSelectedIndex())
        {
            case 0 : dfHeure = DateFormat.SHORT;
                     break;
            case 1 : dfHeure = DateFormat.MEDIUM;
                     break;
            case 2 : dfHeure = DateFormat.FULL;
                     break;
            default : dfHeure = DateFormat.MEDIUM;
        }
        switch(jComboBoxFDate.getSelectedIndex())
        {
            case 0 : dfDate = DateFormat.SHORT;
                     break;
            case 1 : dfDate = DateFormat.MEDIUM;
                     break;
            case 2 : dfDate = DateFormat.FULL;
                     break;
            default: dfDate = DateFormat.MEDIUM;
        }
        
        mw.getThreadDate().setFormatHeure(dfHeure);
        mw.getThreadDate().setFormatDate(dfDate);
        mw.getThreadDate().setPays(pays);
    }//GEN-LAST:event_jButtonAppliquerActionPerformed

    private void jComboBoxPaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPaysActionPerformed

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
            java.util.logging.Logger.getLogger(dateSettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dateSettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dateSettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dateSettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dateSettingsDialog dialog = new dateSettingsDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAppliquer;
    private javax.swing.JComboBox<String> jComboBoxFDate;
    private javax.swing.JComboBox<String> jComboBoxFHeure;
    private javax.swing.JComboBox<String> jComboBoxPays;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelParamDate;
    private javax.swing.JLabel jLabelPays;
    private javax.swing.JLabel jLabelTemps;
    // End of variables declaration//GEN-END:variables
}
