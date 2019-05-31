package applic_salle_presse;

import applic_points_presse.JournalisteWindows;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.beans.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
/**
 *
 * @author Eliott
 */
public class mainWindow extends javax.swing.JFrame implements NotifyNewsListener{

    private ArrayList<News> _listeNews; 
    public void setListNews(ArrayList<News> ln){_listeNews = ln;}
    public ArrayList<News> getListNews(){return _listeNews;}
    
    private DefaultListModel _modInter; 
    public final void setModInter(DefaultListModel m){_modInter = m; }
    public DefaultListModel getModInter() { return _modInter;  }

    private DefaultListModel _modViePol;     
    public final void setModViePol(DefaultListModel m) { _modViePol = m; }
    public DefaultListModel getModViePol() { return _modViePol;}
    
    private DefaultListModel _modInfosSports; 
    public final void setModInfosSports(DefaultListModel m){_modInfosSports = m;}
    public DefaultListModel getModInfosSports(){return _modInfosSports;}
    
    private DefaultListModel _modRagots;
    public final void setModRagots(DefaultListModel m){ _modRagots = m;}
    public DefaultListModel getModRagots(){return _modRagots;}
    
    private DateThread _threadDate;
    public DateThread getThreadDate(){ return _threadDate; }
    public void setThreadDate(DateThread d){ _threadDate = d; }
    
    private News Newstemp;
    private JournalisteWindows Jw;
    public JournalisteWindows getRefjournaliste(){return Jw;}
    
    private String _messagerecu;
    public void setMessageRecu(String m){_messagerecu=m;}
    public String getMessageRecu(){return _messagerecu;}
    
    private PropertyChangeSupport _gestProp;
    public  PropertyChangeSupport getGestProp(){ return _gestProp;}

    private ArrayList<StoreNewsListener> _storeNewsListeners;
    public void setStoreNewsListener(ArrayList<StoreNewsListener> m){ _storeNewsListeners=(m);}
    public void addStoreNewsListener(StoreNewsListener k){ getStoreNewsListener().add(k); }
    public ArrayList<StoreNewsListener> getStoreNewsListener(){return _storeNewsListeners;}

    

    public mainWindow(String nom) throws ClassNotFoundException{
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Journal");
        
        _listeNews = new ArrayList<News>();
        _storeNewsListeners=new ArrayList<StoreNewsListener>();
        jlblJournaliste.setText(nom);
        setModInter(new DefaultListModel());
        setModViePol(new DefaultListModel());
        setModInfosSports(new DefaultListModel());
        setModRagots(new DefaultListModel());
        
        tmpNewsEnvoye1 =new News();
        _messagerecu=new String();
        _threadDate = new DateThread(this);

        InputStream input;
        try {
            input = new FileInputStream("fileProp.properties");
        
            Properties proper = new Properties();

            proper.load(input);
            String[] strformat = proper.getProperty("formatdate").split("-");
            Locale formatpays;
            switch(strformat[2])
            {
                case "fr_FR" :  formatpays = Locale.FRANCE;
                case "de_DE" :  formatpays = Locale.GERMANY;
                case "en_GB" :  formatpays = Locale.UK;
                case "it_IT" :  formatpays = Locale.ITALY;
                case "en_US" :  formatpays = Locale.US;
                default : formatpays = Locale.FRANCE;
                              break;
            }
            _threadDate.setFormatHeure(Integer.parseInt(strformat[0]));
            _threadDate.setFormatDate(Integer.parseInt(strformat[1]));
            _threadDate.setPays(formatpays);
        } catch (IOException ex) {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        _threadDate.start();
        
        
       _gestProp = new PropertyChangeSupport(this);
       NewsCounterBean compteurBean=new NewsCounterBean(jLabelCompteurNews,this);
       addPropertyChangeListener(compteurBean);
        
       
        this.setIconImage(new ImageIcon("img\\icone.png").getImage());
        jLabelImg.setIcon(new ImageIcon("img\\ibra2.jpg"));
        jLabelImg.setSize(177, 149);
         try 
        {
            FileInputStream Fis=new  FileInputStream(System.getProperty("user.home") + System.getProperty("file.separator") + "News.ser");
            ObjectInputStream ois= new ObjectInputStream(Fis);

            _listeNews=(ArrayList<News>)ois.readObject();
            
            jLabelCompteurNews.setText(Integer.toString(_listeNews.size()));
            
            DefaultListModel dlm;
         
            for(int i=0;i<_listeNews.size();i++)
            {
                Newstemp = _listeNews.get(i);
                dlm = getNewsModel(Newstemp);
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
            
        }
        catch (FileNotFoundException e) 
        {
            JOptionPane.showMessageDialog(new JFrame(), "Pas de donnée à charger", "Bienvenue", JOptionPane.INFORMATION_MESSAGE);

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
        jlabelJournaliste = new javax.swing.JLabel();
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
        jMenuItemLogout = new javax.swing.JMenuItem();
        jMenuItemloginJournaliste = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuRecherche = new javax.swing.JMenu();
        jMenuItemRecherche = new javax.swing.JMenuItem();
        jMenuOutil = new javax.swing.JMenu();
        jMenuItemImprimer = new javax.swing.JMenuItem();
        jMenuAide = new javax.swing.JMenu();
        jMenuItemAffLog = new javax.swing.JMenuItem();
        jMenuItemDateSetting = new javax.swing.JMenuItem();
        jMenuItemApropos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jlabelJournaliste.setText("Journaliste :");

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

        jMenuItemLogout.setText("Logout");
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogoutActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemLogout);

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

        jMenuRecherche.setText("Recherche");
        jMenuRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRechercheActionPerformed(evt);
            }
        });

        jMenuItemRecherche.setText("Recherche mot cle");
        jMenuItemRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRechercheActionPerformed(evt);
            }
        });
        jMenuRecherche.add(jMenuItemRecherche);

        jMenuBar1.add(jMenuRecherche);

        jMenuOutil.setText("Outils");

        jMenuItemImprimer.setText("Imprimer");
        jMenuItemImprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImprimerActionPerformed(evt);
            }
        });
        jMenuOutil.add(jMenuItemImprimer);

        jMenuBar1.add(jMenuOutil);

        jMenuAide.setText("Aide");
        jMenuAide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAideActionPerformed(evt);
            }
        });

        jMenuItemAffLog.setText("Afficher le log");
        jMenuItemAffLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAffLogActionPerformed(evt);
            }
        });
        jMenuAide.add(jMenuItemAffLog);

        jMenuItemDateSetting.setText("Date");
        jMenuItemDateSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDateSettingActionPerformed(evt);
            }
        });
        jMenuAide.add(jMenuItemDateSetting);

        jMenuItemApropos.setText("A propos");
        jMenuItemApropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAproposActionPerformed(evt);
            }
        });
        jMenuAide.add(jMenuItemApropos);

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
                            .addComponent(jlabelJournaliste, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jlabelJournaliste)
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

    
    
    private void jCBnewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBnewsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBnewsActionPerformed

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        // TODO add your handling code here:
        boolean isAlreadyCreated = true;
        if(!jTextFieldAjouterNews.getText().isBlank())
        {
            for(int i = 0; i< jCBnews.getItemCount() && isAlreadyCreated; i++)
            {
                if(jCBnews.getItemAt(i).equalsIgnoreCase(jTextFieldAjouterNews.getText()))
                {
                    isAlreadyCreated = false;
                    JOptionPane.showMessageDialog(new JFrame(), "News  déja existante", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }      
        
            if(isAlreadyCreated)
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
        setSelectedList(Color.WHITE, Color.WHITE, Color.lightGray, Color.WHITE);
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

    private void jMenuItemAproposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAproposActionPerformed
        // TODO add your handling code here:
        AProposDialog APDialog = new AProposDialog(this, true);
        APDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemAproposActionPerformed

    private void jMenuRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRechercheActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuRechercheActionPerformed

    private void jMenuItemRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRechercheActionPerformed
        // TODO add your handling code here:
        rechercherDialog rDialog = new rechercherDialog(this, true, _listeNews);
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
            String motCles = "";
            if(jListInter.getSelectedValue() == null)
                JOptionPane.showMessageDialog(null, "Pas de news selectionnée", 
                        "Information manquante", JOptionPane.ERROR_MESSAGE);
            else 
            {
                _listeNews.forEach((ntmp)->{
                if(ntmp.getTitre().equals(jListInter.getSelectedValue()))
                {
                    creationModificationWindow(ntmp);
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
                _listeNews.forEach((ntmp)->{
                if(ntmp.getTitre().equals(jListViePol.getSelectedValue()))
                {
                    creationModificationWindow(ntmp);
                }
            });
            }
        }
        else if(jListInfosSports.getBackground() == Color.lightGray)
        {
            News n;
            String motCles = "";
            if(jListInfosSports.getSelectedValue() == null)
                JOptionPane.showMessageDialog(new JFrame(), "Pas de news selectionnée", 
                        "Information manquante", JOptionPane.ERROR_MESSAGE);
            else 
            {
                _listeNews.forEach((ntmp)->{
                if(ntmp.getTitre().equals(jListInfosSports.getSelectedValue()))
                {
                    creationModificationWindow(ntmp);
                }
            });
            }
        }
        else if(jListRagots.getBackground() == Color.lightGray)
        {
            News n;
            String motCles = "";
            if(jListRagots.getSelectedValue() == null)
                JOptionPane.showMessageDialog(new JFrame(), "Pas de news selectionnée", 
                        "Information manquante", JOptionPane.ERROR_MESSAGE);
            else 
            {
                _listeNews.forEach((ntmp)->{
                if(ntmp.getTitre().equals(jListRagots.getSelectedValue()))
                {
                    creationModificationWindow(ntmp);
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
        setSelectedList(Color.lightGray, Color.WHITE, Color.WHITE, Color.WHITE);
    }//GEN-LAST:event_jRadioInterActionPerformed

    private void jRadioPolitiqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioPolitiqueActionPerformed
        // TODO add your handling code here:
        setSelectedList(Color.WHITE, Color.lightGray, Color.WHITE, Color.WHITE);
    }//GEN-LAST:event_jRadioPolitiqueActionPerformed

    private void jRadioRagotsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioRagotsActionPerformed
        // TODO add your handling code here:
        setSelectedList(Color.WHITE, Color.WHITE, Color.WHITE, Color.lightGray);
    }//GEN-LAST:event_jRadioRagotsActionPerformed

    private void jMenuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        loginWindow logWin = new loginWindow();
        logWin.setVisible(true);
    }//GEN-LAST:event_jMenuItemLogoutActionPerformed

    private void jMenuItemDateSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDateSettingActionPerformed
        // TODO add your handling code here:
        dateSettingsDialog dateDialog = new dateSettingsDialog(this, true);
        dateDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemDateSettingActionPerformed

    private void jlblDate2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblDate2MouseClicked
        // TODO add your handling code here:
        jlblDate2.setText(DateFormat.getDateTimeInstance(DateFormat.DATE_FIELD,DateFormat.LONG, Locale.FRANCE).format(new Date()));
    }//GEN-LAST:event_jlblDate2MouseClicked

    private void jMenuItemloginJournalisteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemloginJournalisteActionPerformed
         Jw=new JournalisteWindows(this);
         Jw.setVisible(true);
    }//GEN-LAST:event_jMenuItemloginJournalisteActionPerformed

    private void jTextFieldTitrenotifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTitrenotifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTitrenotifActionPerformed

    private void jButtonLireNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLireNewsActionPerformed

    }//GEN-LAST:event_jButtonLireNewsActionPerformed

    private void jCheckBoxMessageRecuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMessageRecuActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxMessageRecuActionPerformed

    private void jButtonConfirmerReceptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmerReceptionActionPerformed
    
        if(!(jTextFieldTitrenotif.getText().equals("")))
        {
            News stockernews=new News();
            stockernews=tmpNewsEnvoye1;
            int old = _listeNews.size();
            StoreNewsEvent storeNewsEvent =new StoreNewsEvent();
            storeNewsEvent.setStoreNews(stockernews);
            storeNewsEvent.setRefWindow(this);
            StoringNewsBeans stockNewsBeans=new StoringNewsBeans();
            addStoreNewsListener(stockNewsBeans);
            for(int i=0;i<getStoreNewsListener().size();i++)
            {
                getStoreNewsListener().get(i).storeNewsDetected(storeNewsEvent);
            }

            getGestProp().firePropertyChange("listeNews", old, _listeNews.size());
            jTextFieldTitrenotif.setText("");
        }   
    }//GEN-LAST:event_jButtonConfirmerReceptionActionPerformed

    private void jButtonEnvoyeMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnvoyeMessageActionPerformed
        // TODO add your handling code here:
        if(!(jTextFieldTitrenotif.getText().equals("")))
        {
            EnvoieMessage em =new EnvoieMessage(Jw,tmpNewsEnvoye1.getTitre());
            em.setVisible(true); 
        }
    }//GEN-LAST:event_jButtonEnvoyeMessageActionPerformed

    private DefaultListModel getNewsModel(News n)
    {
        switch(n.getCat().toString())
                {
                    case "Internationnales" : return this.getModInter();
                    case "Vie politique" :  return this.getModViePol();
                    case "Ragots et potins" : return this.getModRagots();
                    case "Sport" : return this.getModInfosSports();
                    default : return null;
                }
    }
    /*
    private JList getNewsModelJList(News n)
    {
        
        switch(n.getCat().toString())
                {
                    case "Internationnales" : return this.jListInter;
                    case "Vie politique" :  return this.jListViePol;
                    case "Ragots et potins" : return this.jListRagots;
                    case "Sport" : return this.jListInfosSports;
                    default : return null;
                }
    }*/
    
    private void jMenuItemImprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImprimerActionPerformed
        // TODO add your handling code here:
        Impression threadImp = new Impression(this);
        threadImp.start();
    }//GEN-LAST:event_jMenuItemImprimerActionPerformed

    private void jMenuItemAffLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAffLogActionPerformed
        // TODO add your handling code here:
        AfficherLogDialog ald = new AfficherLogDialog(this, true);
        ald.setVisible(true);
    }//GEN-LAST:event_jMenuItemAffLogActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Properties fileProp = new Properties();
        
        fileProp.setProperty("fichiernews", "News.ser");
        fileProp.setProperty("fichierlog", "fichierlog.txt");
        //fileProp.setProperty("Charleroi", "50002");
        //fileProp.setProperty("Liège", "50003");
        fileProp.setProperty("formatdate", _threadDate.getFormatDateString());
        
        try {
            fileProp.store(new FileOutputStream("fileProp.properties"),null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_formWindowClosing

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
                try {
                    new mainWindow("Dev").setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @Override
    
    public void notificationNewsDetected(NotifyNewsEvent NtNE)
    {
        JOptionPane.showMessageDialog(new JFrame(), "Une news est arrivée", "Notification", JOptionPane.INFORMATION_MESSAGE);
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
                                            break;
            case  "Vie politique"  : tmpNewsEnvoye1 . setCat ( Categorie . POLITIQUE );
                                            break;
            case  "Ragots et potins"  : tmpNewsEnvoye1 . setCat ( Categorie . RAGOT );
                                           break;
            case  "Sport"  : tmpNewsEnvoye1 . setCat ( Categorie . SPORT );
                                            break;    
        }
        tmpNewsEnvoye1.setImportance(tmp[4].equals("true"));
        jTextFieldTitrenotif.setText(tmpNewsEnvoye1.getTitre());
    }
    
    @Override
    public void addPropertyChangeListener(PropertyChangeListener l)
    {
        getGestProp().addPropertyChangeListener(l);
    }
    
    public void setSelectedList(Color c1, Color c2, Color c3, Color c4)
    {
        jListInter.setBackground(c1);
        jListViePol.setBackground(c2);
        jListInfosSports.setBackground(c3);
        jListRagots.setBackground(c4);
    }
    
    public void creationModificationWindow(News n)
    {
        newsProcessingWindow npWindow = new newsProcessingWindow(this, false, n,jLabelCompteurNews);
        npWindow.setVisible(true);
        npWindow.jTextNomNews.setText(n.getTitre());
        npWindow.jTextComments.setText(n.getTexte());
        npWindow.jRadioInter.setSelected(true);
        npWindow.tmpCat = n.getCat();
        npWindow.jCheckBox1.setSelected(n.getImportance());
        npWindow.jTextMotsCles.setText(n.getMotCles1String());
    }
                    
        
  
    public News tmpNewsEnvoye1;
    public javax.swing.JLabel getCompteur(){return jLabelCompteurNews;}
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
    private javax.swing.JMenu jMenuAide;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAffLog;
    private javax.swing.JMenuItem jMenuItemApropos;
    private javax.swing.JMenuItem jMenuItemDateSetting;
    private javax.swing.JMenuItem jMenuItemImprimer;
    private javax.swing.JMenuItem jMenuItemLogout;
    private javax.swing.JMenuItem jMenuItemRecherche;
    private javax.swing.JMenuItem jMenuItemloginJournaliste;
    private javax.swing.JMenu jMenuOutil;
    private javax.swing.JMenu jMenuRecherche;
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
    private javax.swing.JLabel jlabelJournaliste;
    private javax.swing.JLabel jlblAddNews;
    private javax.swing.JLabel jlblDate;
    protected javax.swing.JLabel jlblDate2;
    private javax.swing.JLabel jlblJournaliste;
    private javax.swing.JLabel jlblNewsRecues;
    private javax.swing.JLabel jlblNomJournaliste;
    // End of variables declaration//GEN-END:variables
}
