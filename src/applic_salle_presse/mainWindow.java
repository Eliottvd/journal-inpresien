/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applic_salle_presse;

import applic_points_presse.JournalisteWindows;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.NetworkBasicServer;
/**
 *
 * @author Eliott
 */
public class mainWindow extends javax.swing.JFrame implements NotifyNewsListener{

    /**
     * Creates new form mainWindow
     */
    ArrayList<News> listeNews;
   
            
    public mainWindow() {
        initComponents();
    }
    
    private DefaultListModel _modInter; 
    private DefaultListModel _modViePol; 
    private DefaultListModel _modInfosSports; 
    private DefaultListModel _modRagots;
    public News tmpNewsEnvoye;
    private News Newstemp;
   // public NetworkBasicServer NBS;
    private JournalisteWindows Jw;
    private String _messagerecu;
    public void setMessageRecu(String m){_messagerecu=m;}
    public String getMessageRecu(){return _messagerecu;}
    
    private ArrayList<StoreNewsListener> _storeNewsListeners;
    public void setStoreNewsListener(ArrayList<StoreNewsListener> m)
    {
       _storeNewsListeners=(m);
    }
    public void addStoreNewsListener(StoreNewsListener k)
    {
        getStoreNewsListener().add(k);
    }
    public ArrayList<StoreNewsListener> getStoreNewsListener(){return _storeNewsListeners;}
    
    private ArrayList<NewsCounterListener> _newsCounterListeners;
    public void setNewsCounterListener(ArrayList<NewsCounterListener> m)
    {
       _newsCounterListeners=(m);
    }
    public void addNewsCounterListener(NewsCounterListener k)
    {
        getNewsCounterListener().add(k);
    }
    public ArrayList<NewsCounterListener> getNewsCounterListener(){return _newsCounterListeners;}

    
    public mainWindow(String nom) throws ClassNotFoundException{
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Journal");
        listeNews = new ArrayList<News>();
        _storeNewsListeners=new ArrayList<StoreNewsListener>();
        _newsCounterListeners=new ArrayList<NewsCounterListener>();
        jlblJournaliste.setText(nom);
        Date maintenant = new Date();
        String maDate = DateFormat.getDateTimeInstance(DateFormat.DATE_FIELD,DateFormat.LONG, Locale.FRANCE).format(maintenant);
        jlblDate2.setText(maDate);
        setModInter(new DefaultListModel());
        setModViePol(new DefaultListModel());
        setModInfosSports(new DefaultListModel());
        setModRagots(new DefaultListModel());
        tmpNewsEnvoye1 =new News();
        //NBS=new NetworkBasicServer(60003, jCheckBoxMessageRecu);
        _messagerecu=new String();
        
       
        
        
        
        String rep;
        String sep;
        String cheminNews;
        rep = System.getProperty("user.home");
        sep=System.getProperty("file.separator");
        cheminNews=rep+sep+"News.ser";
         try 
        {
            FileInputStream Fis=new  FileInputStream(cheminNews);
            ObjectInputStream ois= new ObjectInputStream(Fis);

            listeNews=(ArrayList<News>)ois.readObject();
            //System.out.println(listeNews.size());
         //du ajouter throws ClassNotFoundException a la ligne 40
            for(int i=0;i<listeNews.size();i++)
            {
                Newstemp=listeNews.get(i);
                switch(Newstemp.getCat().toString())
                {
                    case "Internationnales" : this.getModInter().addElement(Newstemp.getTitre());
                                              this.jListInter.setModel(this.getModInter());
                                              this.jCBnews.removeItem(this.jCBnews.getSelectedItem());
                                              this.dispose();
                                              break;
                    case "Vie politique" : this.getModViePol().addElement(Newstemp.getTitre());
                                           this.jListViePol.setModel(this.getModViePol());
                                           this.jCBnews.removeItem(this.jCBnews.getSelectedItem());
                                           this.dispose();
                                           break;
                    case "Ragots et potins" : this.getModRagots().addElement(Newstemp.getTitre());
                                              this.jListRagots.setModel(this.getModRagots());
                                              this.jCBnews.removeItem(this.jCBnews.getSelectedItem());
                                              this.dispose();
                                              break;
                    case "Sport" : this.getModInfosSports().addElement(Newstemp.getTitre());
                                   this.jListInfosSports.setModel(this.getModInfosSports());
                                   this.jCBnews.removeItem(this.jCBnews.getSelectedItem());
                                   this.dispose();
                                   break;
                    default : JOptionPane.showMessageDialog(new JFrame(), "Veuillez choisir une catégorie", 
                            "Information manquante", JOptionPane.ERROR_MESSAGE);                                                                              
                }
                        //System.out.println(i);
            }
            
        }
        catch (EOFException e) 
        {
            String imgUrl="img\\ibra2.jpg";
            ImageIcon icone = new ImageIcon(imgUrl);
            jLabelImg.setIcon(icone);
            jLabelImg.setSize(177, 149);
        }
        catch (FileNotFoundException e) 
        {
            JOptionPane.showMessageDialog(new JFrame(), "Pas de donnée à charger", "Bienvenue", JOptionPane.INFORMATION_MESSAGE);
            String imgUrl="img\\ibra2.jpg";
            ImageIcon icone = new ImageIcon(imgUrl);
            jLabelImg.setIcon(icone);
            jLabelImg.setSize(177, 149);
        }

        catch(IOException e)
        {
             JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Imposteur !", JOptionPane.ERROR_MESSAGE);
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RadioButtonGroup = new javax.swing.ButtonGroup();
        jlabel1 = new javax.swing.JLabel();
        jlblNomJournaliste = new javax.swing.JLabel();
        jlblNewsRecues = new javax.swing.JLabel();
        jCBnews = new javax.swing.JComboBox<>();
        jlblAddNews = new javax.swing.JLabel();
        jlblDate = new javax.swing.JLabel();
        jlblDate2 = new javax.swing.JLabel();
        jButtonAjouter = new javax.swing.JButton();
        jButtonTraiter = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();
        jRadioInter = new javax.swing.JRadioButton();
        jRadioPolitique = new javax.swing.JRadioButton();
        jRadioSport = new javax.swing.JRadioButton();
        jRadioRagots = new javax.swing.JRadioButton();
        jlblJournaliste = new javax.swing.JLabel();
        jTextFieldAjouterNews = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListRagots = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListInter = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListViePol = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        jListInfosSports = new javax.swing.JList<>();
        jToggleButtonEditer = new javax.swing.JToggleButton();
        jLabelImg = new javax.swing.JLabel();
        jCheckBoxMessageRecu = new javax.swing.JCheckBox();
        jTextFieldTitrenotif = new javax.swing.JTextField();
        jButtonLireNews = new javax.swing.JButton();
        jButtonConfirmerReception = new javax.swing.JButton();
        jButtonEnvoyeMessage = new javax.swing.JButton();
        jLabelStockNews = new javax.swing.JLabel();
        jLabelCompteurNews = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItemloginJournaliste = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemRecherche = new javax.swing.JMenuItem();
        jMenuAide = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlabel1.setText("Journaliste :");

        jlblNomJournaliste.setText(" ");

        jlblNewsRecues.setText("News reçues");

        jCBnews.setMinimumSize(new java.awt.Dimension(33, 126));
        jCBnews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBnewsActionPerformed(evt);
            }
        });
        jCBnews.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCBnewsKeyPressed(evt);
            }
        });

        jlblAddNews.setText("Ajouter news : ");

        jlblDate.setText("Nous sommes le : ");

        jlblDate2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblDate2MouseClicked(evt);
            }
        });

        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jButtonTraiter.setText("Traiter");
        jButtonTraiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraiterActionPerformed(evt);
            }
        });

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        RadioButtonGroup.add(jRadioInter);
        jRadioInter.setText("Internationnales");
        jRadioInter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioInterActionPerformed(evt);
            }
        });

        RadioButtonGroup.add(jRadioPolitique);
        jRadioPolitique.setText("Vie politique");
        jRadioPolitique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioPolitiqueActionPerformed(evt);
            }
        });

        RadioButtonGroup.add(jRadioSport);
        jRadioSport.setText("Infos Sports ");
        jRadioSport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioSportActionPerformed(evt);
            }
        });

        RadioButtonGroup.add(jRadioRagots);
        jRadioRagots.setText("Ragots et potins");
        jRadioRagots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioRagotsActionPerformed(evt);
            }
        });

        jlblJournaliste.setText("Nom du journaliste");

        jTextFieldAjouterNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAjouterNewsActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(jListRagots);

        jScrollPane6.setViewportView(jListInter);

        jListViePol.setMaximumSize(new java.awt.Dimension(135, 131));
        jScrollPane7.setViewportView(jListViePol);

        jScrollPane8.setViewportView(jListInfosSports);

        jToggleButtonEditer.setText("Editer");
        jToggleButtonEditer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonEditerActionPerformed(evt);
            }
        });

        jCheckBoxMessageRecu.setText("Message notif");
        jCheckBoxMessageRecu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMessageRecuActionPerformed(evt);
            }
        });

        jTextFieldTitrenotif.setEnabled(false);
        jTextFieldTitrenotif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTitrenotifActionPerformed(evt);
            }
        });

        jButtonLireNews.setText("Lire News");
        jButtonLireNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLireNewsActionPerformed(evt);
            }
        });

        jButtonConfirmerReception.setText("Confirmer reception");
        jButtonConfirmerReception.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmerReceptionActionPerformed(evt);
            }
        });

        jButtonEnvoyeMessage.setText("Envoye message");
        jButtonEnvoyeMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnvoyeMessageActionPerformed(evt);
            }
        });

        jLabelStockNews.setText("Stock de News: ");

        jLabelCompteurNews.setText("0");

        jMenu2.setText("Utilisateurs");

        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItemloginJournaliste.setText("loginJournaliste");
        jMenuItemloginJournaliste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemloginJournalisteActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemloginJournaliste);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu3.setText("Recherche");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItemRecherche.setText("Recherche mot cle");
        jMenuItemRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRechercheActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemRecherche);

        jMenuBar1.add(jMenu3);

        jMenuAide.setText("Aide");
        jMenuAide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAideActionPerformed(evt);
            }
        });

        jMenuItem4.setText("Afficher le log");
        jMenuAide.add(jMenuItem4);

        jMenuItem1.setText("Date");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuAide.add(jMenuItem1);

        jMenuItem5.setText("A propos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenuAide.add(jMenuItem5);

        jMenuBar1.add(jMenuAide);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioInter)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonLireNews)
                                .addGap(28, 28, 28)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioPolitique)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioSport)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldTitrenotif, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jButtonConfirmerReception)))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEnvoyeMessage)
                            .addComponent(jRadioRagots)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(58, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlblAddNews, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlblNewsRecues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAjouterNews)
                            .addComponent(jlblJournaliste, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(jCBnews, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonTraiter, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonSupprimer)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jLabelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jlblNomJournaliste, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlblDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelStockNews)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelCompteurNews, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jlblDate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jCheckBoxMessageRecu))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(jToggleButtonEditer)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblDate2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlabel1)
                        .addComponent(jlblNomJournaliste)
                        .addComponent(jlblDate)
                        .addComponent(jlblJournaliste)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblNewsRecues)
                            .addComponent(jCBnews, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonTraiter)
                            .addComponent(jButtonSupprimer))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAjouter)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlblAddNews)
                                .addComponent(jTextFieldAjouterNews, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioSport)
                        .addComponent(jRadioRagots))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioInter)
                        .addComponent(jRadioPolitique)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButtonEditer)
                    .addComponent(jLabelStockNews)
                    .addComponent(jLabelCompteurNews))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxMessageRecu)
                    .addComponent(jTextFieldTitrenotif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLireNews)
                    .addComponent(jButtonConfirmerReception)
                    .addComponent(jButtonEnvoyeMessage))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public final void setModInter(DefaultListModel m)
    {
        _modInter = m;
    }
    
    public DefaultListModel getModInter()
    {
        return _modInter;
    }
    
    public final void setModViePol(DefaultListModel m)
    {
        _modViePol = m;
    }
    
    public DefaultListModel getModViePol()
    {
        return _modViePol;
    }
    
    public final void setModInfosSports(DefaultListModel m)
    {
        _modInfosSports = m;
    }
    
    public DefaultListModel getModInfosSports()
    {
        return _modInfosSports;
    }
    
    public final void setModRagots(DefaultListModel m)
    {
        _modRagots = m;
    }
    
    public DefaultListModel getModRagots()
    {
        return _modRagots;
    }
    
    private void jCBnewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBnewsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBnewsActionPerformed

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        // TODO add your handling code here:
        boolean test = true;
        if(!jTextFieldAjouterNews.getText().isBlank())
        {
            for(int i = 0; i< jCBnews.getItemCount() && test; i++)
            {
                if(jCBnews.getItemAt(i).equalsIgnoreCase(jTextFieldAjouterNews.getText()))
                {
                    test = false;
                    JOptionPane.showMessageDialog(new JFrame(), "News  déja existante", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }      
        
            if(test)
            {
                jCBnews.addItem(jTextFieldAjouterNews.getText());
                jTextFieldAjouterNews.setText("");
            }
        }
        else
            JOptionPane.showMessageDialog(new JFrame(), "Le titre ne peut pas être vide", "Erreur", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jButtonTraiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraiterActionPerformed
        // TODO add your handling code here:
        if(jCBnews.getSelectedItem() != null)
        {
            newsProcessingWindow npw = new newsProcessingWindow(this, true,(String)jCBnews.getSelectedItem(),jLabelCompteurNews);
            npw.setVisible(true);
            
        }
        else
        {
            JOptionPane.showMessageDialog(new JFrame(), "Pas de news selectionnée !", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonTraiterActionPerformed

    private void jRadioSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioSportActionPerformed
        // TODO add your handling code here:
        jListInter.setBackground(Color.WHITE);
        jListViePol.setBackground(Color.WHITE);
        jListInfosSports.setBackground(Color.lightGray);
        jListRagots.setBackground(Color.WHITE);
    }//GEN-LAST:event_jRadioSportActionPerformed

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        // TODO add your handling code here:
        
        if(jCBnews.getSelectedItem() != null)
            jCBnews.removeItem(jCBnews.getSelectedItem());
        else
            JOptionPane.showMessageDialog(new JFrame(), "Pas de news selectionnée !", "Erreur", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void jMenuAideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAideActionPerformed
        
    }//GEN-LAST:event_jMenuAideActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        AProposDialog APDialog = new AProposDialog(this, true);
        APDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItemRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRechercheActionPerformed
        // TODO add your handling code here:
        rechercherDialog rDialog = new rechercherDialog(this, true, listeNews);
        rDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemRechercheActionPerformed

    private void jTextFieldAjouterNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAjouterNewsActionPerformed
        // TODO add your handling code here:
        jButtonAjouterActionPerformed(evt);
    }//GEN-LAST:event_jTextFieldAjouterNewsActionPerformed

    private void jCBnewsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCBnewsKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_DELETE)
        {
            if(jCBnews.getSelectedItem() != null)
                jCBnews.removeItem(jCBnews.getSelectedItem());
        }
    }//GEN-LAST:event_jCBnewsKeyPressed

    private void jToggleButtonEditerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonEditerActionPerformed
        // TODO add your handling code here:
        if(jListInter.getBackground() == Color.lightGray)
        {
            News n;
            String motCles = new String("");
            if(jListInter.getSelectedValue() == null)
                JOptionPane.showMessageDialog(new JFrame(), "Pas de news selectionnée", 
                        "Information manquante", JOptionPane.ERROR_MESSAGE);
            else 
            {
                listeNews.forEach((ntmp)->{
                if(ntmp.getTitre().equals(jListInter.getSelectedValue()))
                {
                    newsProcessingWindow npWin = new newsProcessingWindow(this, false, ntmp,jLabelCompteurNews);
                    npWin.setVisible(true);
                    npWin.jTextNomNews.setText(ntmp.getTitre());
                    npWin.jTextComments.setText(ntmp.getTexte());
                    npWin.jRadioInter.setSelected(true);
                    npWin.tmpCat = ntmp.getCat();
                    npWin.jCheckBox1.setSelected(ntmp.getImportance());
                    npWin.jTextMotsCles.setText(ntmp.getMotCles1String());
                }
            });
            }
        }
        else if(jListViePol.getBackground() == Color.lightGray)
        {
            if(jListViePol.getSelectedValue() == null)
                JOptionPane.showMessageDialog(new JFrame(), "Pas de news selectionnée", 
                        "Information manquante", JOptionPane.ERROR_MESSAGE);
            else 
            {
                listeNews.forEach((ntmp)->{
                if(ntmp.getTitre().equals(jListViePol.getSelectedValue()))
                {
                    newsProcessingWindow npWin = new newsProcessingWindow(this, false, ntmp,jLabelCompteurNews);
                    npWin.setVisible(true);
                    npWin.jTextNomNews.setText(ntmp.getTitre());
                    npWin.jTextComments.setText(ntmp.getTexte());
                    npWin.jRadioPolitique.setSelected(true);
                    npWin.tmpCat = ntmp.getCat();
                    npWin.jCheckBox1.setSelected(ntmp.getImportance());
                    npWin.jTextMotsCles.setText(ntmp.getMotCles1String());
                }
            });
            }
        }
        else if(jListInfosSports.getBackground() == Color.lightGray)
        {
            News n;
            String motCles = new String("");
            if(jListInfosSports.getSelectedValue() == null)
                JOptionPane.showMessageDialog(new JFrame(), "Pas de news selectionnée", 
                        "Information manquante", JOptionPane.ERROR_MESSAGE);
            else 
            {
                listeNews.forEach((ntmp)->{
                if(ntmp.getTitre().equals(jListInfosSports.getSelectedValue()))
                {
                    newsProcessingWindow npWin = new newsProcessingWindow(this, false, ntmp,jLabelCompteurNews);
                    npWin.setVisible(true);
                    npWin.jTextNomNews.setText(ntmp.getTitre());
                    npWin.jTextComments.setText(ntmp.getTexte());
                    npWin.jRadioSport.setSelected(true);
                    npWin.tmpCat = ntmp.getCat();
                    npWin.jCheckBox1.setSelected(ntmp.getImportance());
                    npWin.jTextMotsCles.setText(ntmp.getMotCles1String());
                }
            });
            }
        }
        else if(jListRagots.getBackground() == Color.lightGray)
        {
            News n;
            String motCles = new String("");
            if(jListRagots.getSelectedValue() == null)
                JOptionPane.showMessageDialog(new JFrame(), "Pas de news selectionnée", 
                        "Information manquante", JOptionPane.ERROR_MESSAGE);
            else 
            {
                listeNews.forEach((ntmp)->{
                if(ntmp.getTitre().equals(jListRagots.getSelectedValue()))
                {
                    newsProcessingWindow npWin = new newsProcessingWindow(this, false, ntmp,jLabelCompteurNews);
                    npWin.setVisible(true);
                    npWin.jTextNomNews.setText(ntmp.getTitre());
                    npWin.jTextComments.setText(ntmp.getTexte());
                    npWin.jRadioRagots.setSelected(true);
                    npWin.tmpCat = ntmp.getCat();
                    npWin.jCheckBox1.setSelected(ntmp.getImportance());
                    npWin.jTextMotsCles.setText(ntmp.getMotCles1String());
                }
            });
            }
        }
        else
        {
            JOptionPane.showMessageDialog(new JFrame(), "Pas de catégorie selectionnée", "Information manquante", JOptionPane.ERROR_MESSAGE);   
        }
    }//GEN-LAST:event_jToggleButtonEditerActionPerformed

    private void jRadioInterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioInterActionPerformed
        // TODO add your handling code here:
        jListInter.setBackground(Color.lightGray);
        jListViePol.setBackground(Color.WHITE);
        jListInfosSports.setBackground(Color.WHITE);
        jListRagots.setBackground(Color.WHITE);
    }//GEN-LAST:event_jRadioInterActionPerformed

    private void jRadioPolitiqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioPolitiqueActionPerformed
        // TODO add your handling code here:
        jListInter.setBackground(Color.WHITE);
        jListViePol.setBackground(Color.lightGray);
        jListInfosSports.setBackground(Color.WHITE);
        jListRagots.setBackground(Color.WHITE);
    }//GEN-LAST:event_jRadioPolitiqueActionPerformed

    private void jRadioRagotsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioRagotsActionPerformed
        // TODO add your handling code here:
        jListInter.setBackground(Color.WHITE);
        jListViePol.setBackground(Color.WHITE);
        jListInfosSports.setBackground(Color.WHITE);
        jListRagots.setBackground(Color.lightGray);
    }//GEN-LAST:event_jRadioRagotsActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        loginWindow logWin = new loginWindow();
        logWin.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        dateSettingsDialog dateDialog = new dateSettingsDialog(this, true);
        dateDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jlblDate2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblDate2MouseClicked
        // TODO add your handling code here:
        jlblDate2.setText(DateFormat.getDateTimeInstance(DateFormat.DATE_FIELD,DateFormat.LONG, Locale.FRANCE).format(new Date()));
    }//GEN-LAST:event_jlblDate2MouseClicked

    private void jMenuItemloginJournalisteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemloginJournalisteActionPerformed
         //NBS=new NetworkBasicServer(60001, jCheckBoxMessageRecu);
         Jw=new JournalisteWindows(this);
         //Jw.addListener(this);
         Jw.setVisible(true);
         
         
         
         
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemloginJournalisteActionPerformed

    private void jTextFieldTitrenotifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTitrenotifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTitrenotifActionPerformed

    private void jButtonLireNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLireNewsActionPerformed
        // TODO add your handling code here:
       /* if(jCheckBoxMessageRecu.isSelected())
        {
                       this.ActionReceive();

            
        }*/
    }//GEN-LAST:event_jButtonLireNewsActionPerformed

    private void jCheckBoxMessageRecuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMessageRecuActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxMessageRecuActionPerformed

    private void jButtonConfirmerReceptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmerReceptionActionPerformed
    
        News stockernews=new News();
        stockernews=tmpNewsEnvoye1;
       // System.out.println(stockernews.getTitre());
        StoreNewsEvent storeNewsEvent =new StoreNewsEvent();
        storeNewsEvent.setStoreNews(stockernews);
        storeNewsEvent.setRefWindow(this);
        
        
        StoringNewsBeans stockNewsBeans=new StoringNewsBeans();
        addStoreNewsListener(stockNewsBeans);
        for(int i=0;i<getStoreNewsListener().size();i++)
        {
            getStoreNewsListener().get(i).storeNewsDetected(storeNewsEvent);
        }
        
        NewsCounterEvent comptNewsCounterEvent=new NewsCounterEvent();
        comptNewsCounterEvent.setRefWindowCounter(this);
        
        NewsCounterBean compteurBean=new NewsCounterBean(jLabelCompteurNews);
        addNewsCounterListener(compteurBean);
        
        for(int i=0;i<getNewsCounterListener().size();i++)
        {
            getNewsCounterListener().get(i).ajoutCompteur(comptNewsCounterEvent);
        }
        
       


        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButtonConfirmerReceptionActionPerformed

    private void jButtonEnvoyeMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnvoyeMessageActionPerformed
        // TODO add your handling code here:
        if(!(jTextFieldTitrenotif.getText().equals("")))
        {
            
        }
    }//GEN-LAST:event_jButtonEnvoyeMessageActionPerformed

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
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainWindow().setVisible(true);
            }
        });
    }

    @Override
    
    public void notificationNewsDetected(NotifyNewsEvent NtNE)
    {
        
        
       /* try 
        {
            Thread.sleep(1000, 0);
        } catch (InterruptedException ex) 
        {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(NBS.getMessage());*/
        
        JOptionPane.showMessageDialog(new JFrame(), "Une news est arrivée", "Notification", JOptionPane.INFORMATION_MESSAGE);
        
       // setMessageRecu(NBS.getMessage());
       
        setMessageRecu(NtNE.getMessageRecu());
        
        String [] tmp;
        tmp=getMessageRecu().split("/");
        
        
        
        tmpNewsEnvoye1.setTitre(tmp[0]);
        tmpNewsEnvoye1.setTexte(tmp[1]);
        tmpNewsEnvoye1.setSource(tmp[2]);
        
        System.out.println(tmp[3]);
        
        switch(tmp[3])
        {
            
            case  "Internationnales"  : tmpNewsEnvoye1 . setCat ( Categorie . INTERNATIONNAL );
                System.out.println("INTERRRRRR");
                                            break;
            case  "Vie politique"  : tmpNewsEnvoye1 . setCat ( Categorie . POLITIQUE );
                System.out.println("POLITIIIIIIIIQUE");
                                            break;
                                   
            case  "Ragots et potins"  : tmpNewsEnvoye1 . setCat ( Categorie . RAGOT );
            System.out.println("RAGOOOOOOOOt");
                                           break;
            case  "Sport"  : tmpNewsEnvoye1 . setCat ( Categorie . SPORT );
                                        System.out.println("SPPPPPPPPPPPORT");
                                            break;    
        }
        if(tmp[4].equals("true"))
        {
            tmpNewsEnvoye1.setImportance(true);
        }
        else
        {
            tmpNewsEnvoye1.setImportance(false);
        }
        
        jTextFieldTitrenotif.setText(tmpNewsEnvoye1.getTitre());
    }
  
    public News tmpNewsEnvoye1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup RadioButtonGroup;
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonConfirmerReception;
    private javax.swing.JButton jButtonEnvoyeMessage;
    private javax.swing.JButton jButtonLireNews;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JButton jButtonTraiter;
    protected javax.swing.JComboBox<String> jCBnews;
    private javax.swing.JCheckBox jCheckBoxMessageRecu;
    private javax.swing.JLabel jLabelCompteurNews;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JLabel jLabelStockNews;
    protected javax.swing.JList<String> jListInfosSports;
    protected javax.swing.JList<String> jListInter;
    protected javax.swing.JList<String> jListRagots;
    protected javax.swing.JList<String> jListViePol;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenuAide;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItemRecherche;
    private javax.swing.JMenuItem jMenuItemloginJournaliste;
    private javax.swing.JRadioButton jRadioInter;
    private javax.swing.JRadioButton jRadioPolitique;
    private javax.swing.JRadioButton jRadioRagots;
    private javax.swing.JRadioButton jRadioSport;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField jTextFieldAjouterNews;
    private javax.swing.JTextField jTextFieldTitrenotif;
    private javax.swing.JToggleButton jToggleButtonEditer;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel jlblAddNews;
    private javax.swing.JLabel jlblDate;
    protected javax.swing.JLabel jlblDate2;
    private javax.swing.JLabel jlblJournaliste;
    private javax.swing.JLabel jlblNewsRecues;
    private javax.swing.JLabel jlblNomJournaliste;
    // End of variables declaration//GEN-END:variables
}
