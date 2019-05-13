/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_points_presse;
import applic_salle_presse.*;
import java.util.*;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import network.NetworkBasicClient;

/**
 *
 * @author Admin
 */
public class JournalisteWindows extends javax.swing.JFrame {

    /**
     * Creates new form JournalisteWindows
     */
    public String tmpCategorie;
    public ArrayList<News> listeJournalisteNews;
    public NetworkBasicClient NBC;
    private ArrayList<mainWindow> _framePrincipale;
    public void setPrincipale(mainWindow m)
    {
        _framePrincipale=new ArrayList<mainWindow>();
        _framePrincipale.add(m);
    }
    public mainWindow getPrincipale(){return _framePrincipale.get(0);}
    
     
    
    
    
   
    
    public JournalisteWindows() {
        initComponents();
        listeJournalisteNews=new ArrayList<News>();
        NBC=new NetworkBasicClient("localhost", 60001);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldJournaliste = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTitre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTexte = new javax.swing.JTextField();
        jRadioButtonPolitique = new javax.swing.JRadioButton();
        jRadioButtonInternational = new javax.swing.JRadioButton();
        jRadioButtonSports = new javax.swing.JRadioButton();
        jRadioButtonRagotPotin = new javax.swing.JRadioButton();
        jCheckBoxImportant = new javax.swing.JCheckBox();
        jButtonAnnuler = new javax.swing.JButton();
        jButtonEnvoyer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNews = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelCompteurNews = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabelReponse = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonEnregistrer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nouvelle News");

        jLabel1.setText("Journaliste:");

        jTextFieldJournaliste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJournalisteActionPerformed(evt);
            }
        });

        jLabel2.setText("Titre:");

        jLabel3.setText("Texte:");

        buttonGroup1.add(jRadioButtonPolitique);
        jRadioButtonPolitique.setText("Politique");
        jRadioButtonPolitique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPolitiqueActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonInternational);
        jRadioButtonInternational.setText("International");
        jRadioButtonInternational.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonInternationalActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonSports);
        jRadioButtonSports.setText("Sports");
        jRadioButtonSports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSportsActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonRagotPotin);
        jRadioButtonRagotPotin.setText("Ragots et Potins");
        jRadioButtonRagotPotin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRagotPotinActionPerformed(evt);
            }
        });

        jCheckBoxImportant.setText("Important");

        jButtonAnnuler.setText("Annuler");

        jButtonEnvoyer.setText("Envoyer");
        jButtonEnvoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnvoyerActionPerformed(evt);
            }
        });

        jTableNews.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "News", "Type", "Important ?", "Journaliste"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableNews);

        jLabel4.setText("Log des evenements :");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabelCompteurNews.setText("0");

        jCheckBox1.setText("News envoyé");

        jLabel5.setText("Reponse:");

        jLabelReponse.setText("_");

        jLabel6.setText("Nombre de News envoyes durant cette session :");

        jButtonEnregistrer.setText("Enregister");
        jButtonEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnregistrerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonRagotPotin)
                            .addComponent(jRadioButtonSports)
                            .addComponent(jRadioButtonInternational)
                            .addComponent(jRadioButtonPolitique)
                            .addComponent(jCheckBoxImportant))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelReponse, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonEnregistrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonEnvoyer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonAnnuler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(74, 74, 74)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(31, 31, 31)
                                .addComponent(jCheckBox1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelCompteurNews, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addComponent(jScrollPane2)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldTexte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldTitre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldJournaliste, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 534, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelCompteurNews, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldJournaliste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldTitre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTexte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addComponent(jRadioButtonPolitique)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonInternational)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonSports)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonRagotPotin)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelReponse))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxImportant)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonAnnuler))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEnvoyer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEnregistrer)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonPolitiqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPolitiqueActionPerformed
             
        tmpCategorie="Politique";    
// TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonPolitiqueActionPerformed

    private void jRadioButtonInternationalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonInternationalActionPerformed
       tmpCategorie="Internationnales"; 
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonInternationalActionPerformed

    private void jRadioButtonSportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSportsActionPerformed
            
        tmpCategorie="Sport"; 

            // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonSportsActionPerformed

    private void jRadioButtonRagotPotinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRagotPotinActionPerformed
       tmpCategorie="Ragots et potins"; 
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonRagotPotinActionPerformed

    private void jTextFieldJournalisteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJournalisteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJournalisteActionPerformed

    private void jButtonEnvoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnvoyerActionPerformed
       News tmps=new News();
       String Envoye =new String();
        
       if(jTableNews.getRowSelectionAllowed())
       {
           int i;
           for(i=0;i<jTableNews.getSelectedRow();i++)
           {
                
  
           }
           tmps= listeJournalisteNews.get(i);
           Envoye=tmps.getTitre()+"/"+tmps.getTexte()+"/"+tmps.getSource()+"/"+tmps.getCat()+"/"+tmps.getImportance();
           
           System.out.println(Envoye);
          
           NBC.sendStringWithoutWaiting(Envoye);
           

       }
       else
       {
           JOptionPane.showMessageDialog(new JFrame(), "Pas de catégorie selectionnée", "Information manquante", JOptionPane.ERROR_MESSAGE);
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEnvoyerActionPerformed

    private void jButtonEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnregistrerActionPerformed
        // TODO add your handling code here:
        News newsJournaliste= new News();
        newsJournaliste.setTitre(jTextFieldTitre.getText());
        newsJournaliste.setCat(tmpCategorie);
        newsJournaliste.setImportance(jCheckBoxImportant.isSelected());
        newsJournaliste.setTexte(jTextFieldTexte.getText());
        newsJournaliste.setSource(jTextFieldJournaliste.getText());
        
        listeJournalisteNews.add(newsJournaliste);
        int i;
        for( i=0;i<listeJournalisteNews.size();i++)
        {
            News tmps;
            tmps= listeJournalisteNews.get(i);
             jTableNews.getModel().setValueAt(tmps.getTitre(), i, 0);
             jTableNews.getModel().setValueAt(tmps.getCat(), i, 1);
             if(tmps.getImportance())
             {
                 jTableNews.getModel().setValueAt("Y", i, 2);
             }
             else
             {
                 jTableNews.getModel().setValueAt("N", i, 2);
             }
             
             jTableNews.getModel().setValueAt(tmps.getSource(), i, 3);

                 
        }
        String Nbrenvoye=Integer.toString(i);
        jLabelCompteurNews.setText(Nbrenvoye);
        
        Date date=new Date();
        Calendar calendar= GregorianCalendar.getInstance();
        calendar.setTime(date);
        String sep=System.getProperty("line.separator");
        
        jTextArea1.append("["+ calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+"]"+"Une news enregistree avec succes("+newsJournaliste.getSource()+")-"+newsJournaliste.getTitre()+sep);
        
        
        
        
        
        
        //newsJournaliste.sets
    }//GEN-LAST:event_jButtonEnregistrerActionPerformed

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
            java.util.logging.Logger.getLogger(JournalisteWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JournalisteWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JournalisteWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JournalisteWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JournalisteWindows().setVisible(true);
            }
        });
    }
    
    public void Addliste(mainWindow m)
    {
        setPrincipale(m);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonEnregistrer;
    private javax.swing.JButton jButtonEnvoyer;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxImportant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCompteurNews;
    private javax.swing.JLabel jLabelReponse;
    private javax.swing.JRadioButton jRadioButtonInternational;
    private javax.swing.JRadioButton jRadioButtonPolitique;
    private javax.swing.JRadioButton jRadioButtonRagotPotin;
    private javax.swing.JRadioButton jRadioButtonSports;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableNews;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldJournaliste;
    private javax.swing.JTextField jTextFieldTexte;
    private javax.swing.JTextField jTextFieldTitre;
    // End of variables declaration//GEN-END:variables
}
