/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dao.CollectionDao;
import static GUI.FrameGestionProduitAdmin.prod_id;

//import com.teamdev.jxbrowser.chromium.Browser;
//import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;
import com.restfb.types.User;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import dao.CategorieDao;
import dao.CommentDao;
//import com.teamdev.jxbrowser.chromium.Browser;
//import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import dao.MessageDao;
import dao.NotificationDao;
import dao.ProduitDao;
import dao.ReclamationDao;
import utils.ServiceByZoneModel;
import dao.ServiceDao;
import dao.UserDao;
import dao.ZoneDao;
import de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel;
import entite.Comment;
import entite.Message;
import entite.Notification;
import entite.Produit;
import entite.Reclamation;
import entite.Service;
import entite.Zone;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import utils.ProduitClientModel;
import utils.ProduitModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.http.ParseException;
import sun.applet.Main;
import utils.*;

/**
 *
 * @author Lilya Thebti
 */
public class AllForDealFrame extends javax.swing.JFrame {

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;
    PanelVideo pv = new PanelVideo();
    ///////////////AUDIO
    public static Mixer mixer;
    public static Clip clip;

    //private static int categorie;
    private static int service_id;
    private static int produit_id;
    private static int serv_uid;

    private Connection conn = null;
    private PreparedStatement pst = null;

    ResultSet rsNom = null;

    ServiceDao sdao = new ServiceDao();
    ZoneDao zoneDAO = new ZoneDao();

    private static String nomS;
    //kmar

    /**
     * Creates new form AllForDealFrame
     */
    static Connection con;
    static ResultSet res;
    static PreparedStatement ps;
    static Statement stm;
    ResultSet rs = null;
    ResultSet rsId = null;
    ResultSet rsIdC = null;
    ResultSet rsIdCol = null;

    private static String categorie;
    private static String collection;
    String im;

    public static String getNomS() {
        return nomS;
    }

    public static void setNomS(String nomS) {
        AllForDealFrame.nomS = nomS;
    }

    public static String getCategorie() {
        return categorie;
    }

    public static String getCollection() {
        return collection;
    }

    public static int getService_id() {
        return service_id;
    }

    public static int getProduit_id() {
        return produit_id;
    }

    public static int getServ_uid() {
        return serv_uid;
    }

    public static void setServ_uid(int serv_uid) {
        AllForDealFrame.serv_uid = serv_uid;
    }

    public static void setProduit_id(int produit_id) {
        AllForDealFrame.produit_id = produit_id;
    }

    ProduitDao pdao = new ProduitDao();
    ZoneDao zdao = new ZoneDao();
    CategorieDao cdao = new CategorieDao();
    CollectionDao coldao = new CollectionDao();
//    Browser browser = new Browser();
    // BrowserView view = new BrowserView(browser);

    //fin Partie Lilya
    public AllForDealFrame() throws UnsupportedLookAndFeelException, ParseException, java.text.ParseException {
        UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
        initComponents();
        loadAllVille();
        loadAllCategories();
        loadAllCollection();

        // System.out.println(user_id);
        labelId.setVisible(false);

        accueillabel.setVisible(false);
        produitsLabel.setVisible(false);
        servicesLabel.setVisible(false);
        reclamationLabel.setVisible(false);

        btnProduits.setOpaque(false);
        btnProduits.setContentAreaFilled(false);
        btnProduits.setBorderPainted(false);

        btnAccueil.setOpaque(false);
        btnAccueil.setContentAreaFilled(false);
        btnAccueil.setBorderPainted(false);

        btnPanier.setOpaque(false);
        btnPanier.setContentAreaFilled(false);
        btnPanier.setBorderPainted(false);

        btnMessage.setOpaque(false);
        btnMessage.setContentAreaFilled(false);
        btnMessage.setBorderPainted(false);

        btnNotif.setOpaque(false);
        btnNotif.setContentAreaFilled(false);
        btnNotif.setBorderPainted(false);

        btnServices.setOpaque(false);
        btnServices.setContentAreaFilled(false);
        btnServices.setBorderPainted(false);

        btnReclam.setOpaque(false);
        btnReclam.setContentAreaFilled(false);
        btnReclam.setBorderPainted(false);

        btnProfile.setOpaque(false);
        btnProfile.setContentAreaFilled(false);
        btnProfile.setBorderPainted(false);

        msgEnvoyesLabel.setVisible(false);
        ecrireMsgLabel.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPanel = new javax.swing.JPanel();
        btnPanier = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnReclam = new javax.swing.JButton();
        btnMessage = new javax.swing.JButton();
        btnNotif = new javax.swing.JButton();
        btnServices = new javax.swing.JButton();
        btnProduits = new javax.swing.JButton();
        btnAccueil = new javax.swing.JButton();
        accueillabel = new javax.swing.JLabel();
        produitsLabel = new javax.swing.JLabel();
        servicesLabel = new javax.swing.JLabel();
        reclamationLabel = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        btnSonOn = new javax.swing.JButton();
        btnSonOff = new javax.swing.JButton();
        ParentPanel = new javax.swing.JPanel();
        AccueilPanel2 = new javax.swing.JPanel();
        btnPlay2 = new javax.swing.JButton();
        videoPlayer = new javax.swing.JInternalFrame();
        btnPause = new javax.swing.JButton();
        ProduitPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        AjoutProduitPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAjouter = new javax.swing.JButton();
        tfNomP = new javax.swing.JTextField();
        tfPrix = new javax.swing.JTextField();
        cbCategorie = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        LAlerte = new javax.swing.JTextField();
        tfReduction = new javax.swing.JTextField();
        tfQuantite = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfPointBonus = new javax.swing.JTextField();
        cbZone = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        tfTVA = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tfPhoto = new javax.swing.JTextField();
        btnParcourir = new javax.swing.JButton();
        GridProduitsPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        p2 = new javax.swing.JPanel();
        limage1 = new javax.swing.JLabel();
        lcat1 = new javax.swing.JLabel();
        lquantite1 = new javax.swing.JLabel();
        lprix1 = new javax.swing.JLabel();
        lbonus1 = new javax.swing.JLabel();
        lnom1 = new javax.swing.JLabel();
        p4 = new javax.swing.JPanel();
        limage2 = new javax.swing.JLabel();
        lcat2 = new javax.swing.JLabel();
        lquantite2 = new javax.swing.JLabel();
        lprix2 = new javax.swing.JLabel();
        lbonus2 = new javax.swing.JLabel();
        lnom2 = new javax.swing.JLabel();
        p5 = new javax.swing.JPanel();
        limage3 = new javax.swing.JLabel();
        lcat3 = new javax.swing.JLabel();
        lquantite3 = new javax.swing.JLabel();
        lprix3 = new javax.swing.JLabel();
        lbonus3 = new javax.swing.JLabel();
        lnom3 = new javax.swing.JLabel();
        p3 = new javax.swing.JPanel();
        lcat4 = new javax.swing.JLabel();
        lnom4 = new javax.swing.JLabel();
        limage4 = new javax.swing.JLabel();
        lbonus4 = new javax.swing.JLabel();
        lquantite4 = new javax.swing.JLabel();
        lprix4 = new javax.swing.JLabel();
        p6 = new javax.swing.JPanel();
        lcat5 = new javax.swing.JLabel();
        lnom5 = new javax.swing.JLabel();
        limage5 = new javax.swing.JLabel();
        lbonus5 = new javax.swing.JLabel();
        lquantite5 = new javax.swing.JLabel();
        lprix5 = new javax.swing.JLabel();
        p1 = new javax.swing.JPanel();
        lnom = new javax.swing.JLabel();
        lprix = new javax.swing.JLabel();
        lquantite = new javax.swing.JLabel();
        lbonus = new javax.swing.JLabel();
        lcat = new javax.swing.JLabel();
        limage = new javax.swing.JLabel();
        AjouterProduitPanier = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnext = new javax.swing.JButton();
        RechercheProduitPanel = new javax.swing.JPanel();
        lTitreRechercheS1 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblRechercheS1 = new javax.swing.JTable();
        bntRechercheS1 = new javax.swing.JButton();
        tfRechercheS1 = new javax.swing.JTextField();
        rbNom1 = new javax.swing.JRadioButton();
        rbCat1 = new javax.swing.JRadioButton();
        rbZone1 = new javax.swing.JRadioButton();
        MesProduitsConsultationPanel = new javax.swing.JPanel();
        MesProduitsPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblMesProduits = new javax.swing.JTable();
        tfNomP2 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        cbCategorie2 = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();
        tfPrix2 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        cbZone3 = new javax.swing.JComboBox();
        jLabel54 = new javax.swing.JLabel();
        tfTVA2 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        tfReduction2 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        tfQuantite2 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        tfPointBonus2 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        taDescription2 = new javax.swing.JTextArea();
        labelId2 = new javax.swing.JLabel();
        bntConsulter1 = new javax.swing.JButton();
        btnSupprimer1 = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        btnModifierP1 = new javax.swing.JButton();
        labelId = new javax.swing.JLabel();
        ConsultationPanel = new javax.swing.JPanel();
        lNomProduit = new javax.swing.JLabel();
        lCategorie = new javax.swing.JLabel();
        lQuantite = new javax.swing.JLabel();
        lDescription = new javax.swing.JLabel();
        lPrix = new javax.swing.JLabel();
        lPointBonus = new javax.swing.JLabel();
        lZone = new javax.swing.JLabel();
        lTVA = new javax.swing.JLabel();
        lReduction = new javax.swing.JLabel();
        btnBackP = new javax.swing.JButton();
        offresProduitsPan = new javax.swing.JPanel();
        OffresProduitsTableauPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProduits = new javax.swing.JTable();
        btnPartager = new javax.swing.JButton();
        AjoutPanier = new javax.swing.JButton();
        btnConsulterProduit = new javax.swing.JButton();
        ConsultationPanel1 = new javax.swing.JPanel();
        lNomProduit1 = new javax.swing.JLabel();
        lCategorie1 = new javax.swing.JLabel();
        lQuantite1 = new javax.swing.JLabel();
        lDescription1 = new javax.swing.JLabel();
        lPrix1 = new javax.swing.JLabel();
        lPointBonus1 = new javax.swing.JLabel();
        lZone1 = new javax.swing.JLabel();
        lTVA1 = new javax.swing.JLabel();
        lReduction1 = new javax.swing.JLabel();
        btnBackP1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbCommentairesProduits = new javax.swing.JTable();
        tfCommentP = new javax.swing.JTextField();
        btnCommenterP = new javax.swing.JButton();
        btnSupprimerCommentaire1 = new javax.swing.JButton();
        PanelService = new javax.swing.JPanel();
        tpService = new javax.swing.JTabbedPane();
        pAjoutS = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tfNomS = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tfDescription = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cbCat = new javax.swing.JComboBox();
        cbZone2 = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        btnAjoutS = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblService = new javax.swing.JTable();
        lerror = new javax.swing.JLabel();
        ParentPanel2 = new javax.swing.JPanel();
        pAllServices = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblAllServices = new javax.swing.JTable();
        btnConsulterS1 = new javax.swing.JButton();
        pConsulterS2 = new javax.swing.JPanel();
        btnBackS2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbCommentairesService = new javax.swing.JTable();
        btnSupprimerCommentaire = new javax.swing.JButton();
        bntMap = new javax.swing.JButton();
        pDetailS = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        lNomSAll = new javax.swing.JLabel();
        lDescriptionSAll = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lCategorieServiceAll = new javax.swing.JLabel();
        lEtatSAll = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lZoneSAll = new javax.swing.JLabel();
        pShowMap = new javax.swing.JPanel();
        tfComment = new javax.swing.JTextField();
        btnCommenter1 = new javax.swing.JButton();
        pShowMap1 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        ParentPanel1 = new javax.swing.JPanel();
        pMesServices = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblMesServices = new javax.swing.JTable();
        lMsg = new javax.swing.JLabel();
        btnModifier = new javax.swing.JButton();
        bntSupprimer = new javax.swing.JButton();
        cbZoneX = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cbEtat = new javax.swing.JComboBox();
        cbCat1 = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        tfDescription1 = new javax.swing.JTextField();
        tfNomService = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        labelId1 = new javax.swing.JLabel();
        btnConsulterS = new javax.swing.JButton();
        pConsulterS = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        tfNomService1 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        tfDescription2 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        cbCat2 = new javax.swing.JComboBox();
        cbEtat1 = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cbZone5 = new javax.swing.JComboBox();
        btnBackS = new javax.swing.JButton();
        btnMap = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCommentMesServ = new javax.swing.JTable();
        pRechercheS = new javax.swing.JPanel();
        lTitreRechercheS = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblRechercheS = new javax.swing.JTable();
        bntRechercheS = new javax.swing.JButton();
        tfRechercheS = new javax.swing.JTextField();
        rbNom = new javax.swing.JRadioButton();
        rbCat = new javax.swing.JRadioButton();
        rbZone = new javax.swing.JRadioButton();
        PanierReclamation = new javax.swing.JPanel();
        MessagesPanel = new javax.swing.JPanel();
        msgR = new javax.swing.JPanel();
        btnTestMsg = new javax.swing.JButton();
        btnTestMsg2 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        tbMesMsgR = new javax.swing.JTable();
        ecrireMsgLabel = new javax.swing.JLabel();
        msgEnvoyesLabel = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        msgRediger = new javax.swing.JPanel();
        lMsg1 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();
        btnEnvMsg = new javax.swing.JButton();
        tfDest = new javax.swing.JTextField();
        tfObjet = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        taMsg = new javax.swing.JTextArea();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        msgEnvoye = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        btnBack2 = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbMsgEnvs = new javax.swing.JTable();
        ReclamationPanel = new javax.swing.JPanel();
        erreur1 = new javax.swing.JLabel();
        erreur2 = new javax.swing.JLabel();
        tfSujetRec = new javax.swing.JTextField();
        jScrollPane15 = new javax.swing.JScrollPane();
        taDescriptionRec = new javax.swing.JTextArea();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        btnEnvoyerRec = new javax.swing.JButton();
        NotificationPanel = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbNotification = new javax.swing.JTable();
        labelNotification = new javax.swing.JLabel();
        btnSupNotification = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 1000));

        btnPanier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panier.png"))); // NOI18N
        btnPanier.setPreferredSize(new java.awt.Dimension(50, 40));
        btnPanier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPanierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPanierMouseExited(evt);
            }
        });

        btnProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        btnProfile.setPreferredSize(new java.awt.Dimension(50, 40));
        btnProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProfileMouseExited(evt);
            }
        });
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnReclam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reclamation.png"))); // NOI18N
        btnReclam.setOpaque(false);
        btnReclam.setPreferredSize(new java.awt.Dimension(50, 40));
        btnReclam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReclamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReclamMouseExited(evt);
            }
        });
        btnReclam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReclamActionPerformed(evt);
            }
        });

        btnMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mail.png"))); // NOI18N
        btnMessage.setPreferredSize(new java.awt.Dimension(50, 40));
        btnMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMessageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMessageMouseExited(evt);
            }
        });
        btnMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageActionPerformed(evt);
            }
        });

        btnNotif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flag.png"))); // NOI18N
        btnNotif.setPreferredSize(new java.awt.Dimension(50, 40));
        btnNotif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNotifMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNotifMouseExited(evt);
            }
        });
        btnNotif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifActionPerformed(evt);
            }
        });

        btnServices.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tools.png"))); // NOI18N
        btnServices.setBorder(null);
        btnServices.setOpaque(false);
        btnServices.setPreferredSize(new java.awt.Dimension(50, 40));
        btnServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnServicesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnServicesMouseExited(evt);
            }
        });
        btnServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicesActionPerformed(evt);
            }
        });

        btnProduits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/store.png"))); // NOI18N
        btnProduits.setBorder(null);
        btnProduits.setPreferredSize(new java.awt.Dimension(50, 40));
        btnProduits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProduitsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProduitsMouseExited(evt);
            }
        });
        btnProduits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduitsActionPerformed(evt);
            }
        });

        btnAccueil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        btnAccueil.setPreferredSize(new java.awt.Dimension(50, 40));
        btnAccueil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAccueilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAccueilMouseExited(evt);
            }
        });
        btnAccueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccueilActionPerformed(evt);
            }
        });

        accueillabel.setText("Accueil");

        produitsLabel.setText("Produits");

        servicesLabel.setText("Services");

        reclamationLabel.setText("Réclamation");

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/12992809_10209373323591078_871475137_n.jpg"))); // NOI18N

        btnSonOn.setText("On");
        btnSonOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSonOnActionPerformed(evt);
            }
        });

        btnSonOff.setText("Off");
        btnSonOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSonOffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAccueil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accueillabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addComponent(btnProduits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(produitsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(servicesLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addComponent(reclamationLabel)
                        .addGap(127, 127, 127)
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPanier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNotif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addComponent(btnReclam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSonOff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSonOn)
                        .addGap(18, 18, 18))))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSonOn)
                            .addComponent(btnSonOff))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPanier, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MenuPanelLayout.createSequentialGroup()
                                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(accueillabel)
                                        .addComponent(produitsLabel)
                                        .addComponent(servicesLabel)
                                        .addComponent(reclamationLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnReclam, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnServices, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnProduits, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAccueil, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );

        ParentPanel.setLayout(new java.awt.CardLayout());

        AccueilPanel2.setLayout(null);

        btnPlay2.setText("Play");
        btnPlay2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlay2ActionPerformed(evt);
            }
        });
        AccueilPanel2.add(btnPlay2);
        btnPlay2.setBounds(130, 63, 70, 30);

        videoPlayer.setVisible(true);

        javax.swing.GroupLayout videoPlayerLayout = new javax.swing.GroupLayout(videoPlayer.getContentPane());
        videoPlayer.getContentPane().setLayout(videoPlayerLayout);
        videoPlayerLayout.setHorizontalGroup(
            videoPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        videoPlayerLayout.setVerticalGroup(
            videoPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        AccueilPanel2.add(videoPlayer);
        videoPlayer.setBounds(60, 110, 580, 420);

        btnPause.setText("Pause");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });
        AccueilPanel2.add(btnPause);
        btnPause.setBounds(260, 63, 80, 30);

        ParentPanel.add(AccueilPanel2, "card3");

        ProduitPanel.setPreferredSize(new java.awt.Dimension(790, 399));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(790, 480));
        jTabbedPane1.setSize(790,480);

        AjoutProduitPanel.setLayout(null);

        jLabel1.setText("Nom Produit");
        AjoutProduitPanel.add(jLabel1);
        jLabel1.setBounds(40, 60, 110, 14);

        jLabel2.setText("Catégorie");
        AjoutProduitPanel.add(jLabel2);
        jLabel2.setBounds(40, 110, 110, 14);

        jLabel3.setText("Prix");
        AjoutProduitPanel.add(jLabel3);
        jLabel3.setBounds(40, 150, 110, 14);

        jLabel4.setText("Gouvernorat");
        AjoutProduitPanel.add(jLabel4);
        jLabel4.setBounds(41, 192, 90, 14);

        jLabel5.setText("Réduction");
        AjoutProduitPanel.add(jLabel5);
        jLabel5.setBounds(41, 270, 80, 14);

        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });
        AjoutProduitPanel.add(btnAjouter);
        btnAjouter.setBounds(740, 450, 100, 50);

        tfNomP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomPActionPerformed(evt);
            }
        });
        AjoutProduitPanel.add(tfNomP);
        tfNomP.setBounds(210, 60, 80, 25);
        AjoutProduitPanel.add(tfPrix);
        tfPrix.setBounds(210, 150, 80, 20);

        cbCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategorieActionPerformed(evt);
            }
        });
        AjoutProduitPanel.add(cbCategorie);
        cbCategorie.setBounds(210, 100, 80, 20);

        jLabel6.setText("Quantité");
        AjoutProduitPanel.add(jLabel6);
        jLabel6.setBounds(42, 310, 80, 14);

        LAlerte.setEditable(false);
        LAlerte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LAlerteActionPerformed(evt);
            }
        });
        AjoutProduitPanel.add(LAlerte);
        LAlerte.setBounds(320, 460, 296, 40);
        AjoutProduitPanel.add(tfReduction);
        tfReduction.setBounds(210, 270, 80, 20);
        AjoutProduitPanel.add(tfQuantite);
        tfQuantite.setBounds(210, 310, 80, 20);

        jLabel7.setText("Points Bonus");
        AjoutProduitPanel.add(jLabel7);
        jLabel7.setBounds(41, 350, 80, 14);
        AjoutProduitPanel.add(tfPointBonus);
        tfPointBonus.setBounds(210, 350, 80, 20);

        cbZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbZoneActionPerformed(evt);
            }
        });
        AjoutProduitPanel.add(cbZone);
        cbZone.setBounds(210, 190, 80, 20);

        jLabel8.setText("Description");
        AjoutProduitPanel.add(jLabel8);
        jLabel8.setBounds(413, 60, 90, 14);

        taDescription.setColumns(20);
        taDescription.setRows(5);
        jScrollPane1.setViewportView(taDescription);

        AjoutProduitPanel.add(jScrollPane1);
        jScrollPane1.setBounds(520, 60, 166, 96);

        jLabel9.setText("TVA");
        AjoutProduitPanel.add(jLabel9);
        jLabel9.setBounds(50, 230, 80, 14);
        AjoutProduitPanel.add(tfTVA);
        tfTVA.setBounds(210, 230, 80, 20);

        jLabel20.setText("Photos");
        AjoutProduitPanel.add(jLabel20);
        jLabel20.setBounds(43, 400, 70, 14);
        AjoutProduitPanel.add(tfPhoto);
        tfPhoto.setBounds(170, 400, 140, 20);

        btnParcourir.setText("Parcourir");
        btnParcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParcourirActionPerformed(evt);
            }
        });
        AjoutProduitPanel.add(btnParcourir);
        btnParcourir.setBounds(360, 400, 80, 23);

        jTabbedPane1.addTab("Ajouter Produit", AjoutProduitPanel);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        limage1.setText("jLabel21");

        lcat1.setText("jLabel21");

        lquantite1.setText("jLabel23");

        lprix1.setText("jLabel22");

        lbonus1.setText("jLabel24");

        lnom1.setText("jLabel21");

        javax.swing.GroupLayout p2Layout = new javax.swing.GroupLayout(p2);
        p2.setLayout(p2Layout);
        p2Layout.setHorizontalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p2Layout.createSequentialGroup()
                .addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(p2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lnom1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lprix1))
                    .addGroup(p2Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lquantite1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lcat1)
                    .addComponent(lbonus1))
                .addGap(31, 31, 31))
            .addGroup(p2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(limage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        p2Layout.setVerticalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(limage1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbonus1)
                    .addComponent(lprix1)
                    .addComponent(lnom1))
                .addGap(9, 9, 9)
                .addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lcat1)
                    .addComponent(lquantite1))
                .addContainerGap())
        );

        limage2.setText("jLabel21");

        lcat2.setText("jLabel21");

        lquantite2.setText("jLabel23");

        lprix2.setText("jLabel22");

        lbonus2.setText("jLabel24");

        lnom2.setText("jLabel21");

        javax.swing.GroupLayout p4Layout = new javax.swing.GroupLayout(p4);
        p4.setLayout(p4Layout);
        p4Layout.setHorizontalGroup(
            p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p4Layout.createSequentialGroup()
                .addGroup(p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(p4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lnom2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lprix2))
                    .addGroup(p4Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lquantite2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lcat2)
                    .addComponent(lbonus2))
                .addGap(31, 31, 31))
            .addGroup(p4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(limage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        p4Layout.setVerticalGroup(
            p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(limage2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbonus2)
                    .addComponent(lprix2)
                    .addComponent(lnom2))
                .addGap(9, 9, 9)
                .addGroup(p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lcat2)
                    .addComponent(lquantite2))
                .addContainerGap())
        );

        limage3.setText("jLabel21");

        lcat3.setText("jLabel21");

        lquantite3.setText("jLabel23");

        lprix3.setText("jLabel22");

        lbonus3.setText("jLabel24");

        lnom3.setText("jLabel21");

        javax.swing.GroupLayout p5Layout = new javax.swing.GroupLayout(p5);
        p5.setLayout(p5Layout);
        p5Layout.setHorizontalGroup(
            p5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p5Layout.createSequentialGroup()
                .addGroup(p5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(p5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lnom3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lprix3))
                    .addGroup(p5Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lquantite3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(p5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lcat3)
                    .addComponent(lbonus3))
                .addGap(31, 31, 31))
            .addGroup(p5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(limage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        p5Layout.setVerticalGroup(
            p5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(limage3, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(p5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbonus3)
                    .addComponent(lprix3)
                    .addComponent(lnom3))
                .addGap(9, 9, 9)
                .addGroup(p5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lcat3)
                    .addComponent(lquantite3))
                .addContainerGap())
        );

        lcat4.setText("jLabel21");

        lnom4.setText("jLabel21");

        limage4.setText("jLabel21");

        lbonus4.setText("jLabel24");

        lquantite4.setText("jLabel23");

        lprix4.setText("jLabel22");

        javax.swing.GroupLayout p3Layout = new javax.swing.GroupLayout(p3);
        p3.setLayout(p3Layout);
        p3Layout.setHorizontalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p3Layout.createSequentialGroup()
                .addGroup(p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(p3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lnom4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lprix4))
                    .addGroup(p3Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lquantite4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lcat4)
                    .addComponent(lbonus4))
                .addGap(31, 31, 31))
            .addGroup(p3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(limage4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p3Layout.setVerticalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(limage4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbonus4)
                    .addComponent(lprix4)
                    .addComponent(lnom4))
                .addGap(9, 9, 9)
                .addGroup(p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lcat4)
                    .addComponent(lquantite4))
                .addContainerGap())
        );

        lcat5.setText("jLabel21");

        lnom5.setText("jLabel21");

        limage5.setText("jLabel21");

        lbonus5.setText("jLabel24");

        lquantite5.setText("jLabel23");

        lprix5.setText("jLabel22");

        javax.swing.GroupLayout p6Layout = new javax.swing.GroupLayout(p6);
        p6.setLayout(p6Layout);
        p6Layout.setHorizontalGroup(
            p6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p6Layout.createSequentialGroup()
                .addGroup(p6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(p6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lnom5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lprix5))
                    .addGroup(p6Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lquantite5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(p6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lcat5)
                    .addComponent(lbonus5))
                .addGap(31, 31, 31))
            .addGroup(p6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(limage5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        p6Layout.setVerticalGroup(
            p6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(limage5, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(p6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbonus5)
                    .addComponent(lprix5)
                    .addComponent(lnom5))
                .addGap(9, 9, 9)
                .addGroup(p6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lcat5)
                    .addComponent(lquantite5))
                .addContainerGap())
        );

        p1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p1MouseClicked(evt);
            }
        });

        lnom.setText("jLabel21");

        lprix.setText("jLabel22");

        lquantite.setText("jLabel23");

        lbonus.setText("jLabel24");

        lcat.setText("jLabel21");

        limage.setText("jLabel21");

        javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lnom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lprix))
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(lquantite)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lcat)
                    .addComponent(lbonus))
                .addGap(31, 31, 31))
            .addGroup(p1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(limage, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(limage, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbonus)
                    .addComponent(lprix)
                    .addComponent(lnom))
                .addGap(9, 9, 9)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lcat)
                    .addComponent(lquantite))
                .addContainerGap())
        );

        AjouterProduitPanier.setText("Ajouter Au Panier");

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnext.setText("Next");
        btnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(AjouterProduitPanier))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(btnback)
                        .addGap(26, 26, 26)
                        .addComponent(btnext)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnback)
                            .addComponent(btnext))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AjouterProduitPanier)
                        .addGap(29, 29, 29))))
        );

        javax.swing.GroupLayout GridProduitsPanelLayout = new javax.swing.GroupLayout(GridProduitsPanel);
        GridProduitsPanel.setLayout(GridProduitsPanelLayout);
        GridProduitsPanelLayout.setHorizontalGroup(
            GridProduitsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GridProduitsPanelLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        GridProduitsPanelLayout.setVerticalGroup(
            GridProduitsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GridProduitsPanelLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Grid Produits", GridProduitsPanel);

        lTitreRechercheS1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lTitreRechercheS1.setText("Choisir une catégorie ou un nom de Produit: ");

        tblRechercheS1.setModel(new ServiceByCategorieModel()

        );
        jScrollPane16.setViewportView(tblRechercheS1);

        bntRechercheS1.setText("Rechercher");
        bntRechercheS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRechercheS1ActionPerformed(evt);
            }
        });

        tfRechercheS1.setText("Nom ou Categorie ou Zone");
        tfRechercheS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRechercheS1ActionPerformed(evt);
            }
        });

        rbNom1.setText("Par Nom");
        rbNom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNom1ActionPerformed(evt);
            }
        });

        rbCat1.setText("Par Categorie");
        rbCat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCat1ActionPerformed(evt);
            }
        });

        rbZone1.setText("Par zone");
        rbZone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbZone1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RechercheProduitPanelLayout = new javax.swing.GroupLayout(RechercheProduitPanel);
        RechercheProduitPanel.setLayout(RechercheProduitPanelLayout);
        RechercheProduitPanelLayout.setHorizontalGroup(
            RechercheProduitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RechercheProduitPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(RechercheProduitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RechercheProduitPanelLayout.createSequentialGroup()
                        .addComponent(rbNom1)
                        .addGap(18, 18, 18)
                        .addComponent(rbCat1)
                        .addGap(18, 18, 18)
                        .addComponent(rbZone1))
                    .addGroup(RechercheProduitPanelLayout.createSequentialGroup()
                        .addComponent(bntRechercheS1)
                        .addGap(18, 18, 18)
                        .addComponent(tfRechercheS1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lTitreRechercheS1)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RechercheProduitPanelLayout.setVerticalGroup(
            RechercheProduitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RechercheProduitPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lTitreRechercheS1)
                .addGap(18, 18, 18)
                .addGroup(RechercheProduitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbNom1)
                    .addComponent(rbCat1)
                    .addComponent(rbZone1))
                .addGap(25, 25, 25)
                .addGroup(RechercheProduitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntRechercheS1)
                    .addComponent(tfRechercheS1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Rechercher Un Produit", RechercheProduitPanel);

        MesProduitsConsultationPanel.setLayout(new java.awt.CardLayout());

        MesProduitsPanel1.setLayout(null);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1019, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 657, Short.MAX_VALUE)
        );

        MesProduitsPanel1.add(jPanel6);
        jPanel6.setBounds(1072, 430, 1019, 657);

        tblMesProduits.setModel(new ProduitClientModel());
        tblMesProduits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMesProduitsMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblMesProduits);

        MesProduitsPanel1.add(jScrollPane8);
        jScrollPane8.setBounds(310, 10, 690, 413);

        tfNomP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomP2ActionPerformed(evt);
            }
        });
        MesProduitsPanel1.add(tfNomP2);
        tfNomP2.setBounds(128, 32, 80, 25);

        jLabel51.setText("Catégorie");
        MesProduitsPanel1.add(jLabel51);
        jLabel51.setBounds(10, 78, 47, 14);

        MesProduitsPanel1.add(cbCategorie2);
        cbCategorie2.setBounds(128, 75, 80, 20);

        jLabel52.setText("Prix");
        MesProduitsPanel1.add(jLabel52);
        jLabel52.setBounds(39, 119, 18, 14);
        MesProduitsPanel1.add(tfPrix2);
        tfPrix2.setBounds(128, 116, 80, 20);

        jLabel53.setText("Gouvernorat");
        MesProduitsPanel1.add(jLabel53);
        jLabel53.setBounds(10, 163, 61, 14);

        MesProduitsPanel1.add(cbZone3);
        cbZone3.setBounds(128, 160, 80, 20);

        jLabel54.setText("TVA");
        MesProduitsPanel1.add(jLabel54);
        jLabel54.setBounds(52, 210, 19, 14);
        MesProduitsPanel1.add(tfTVA2);
        tfTVA2.setBounds(128, 207, 80, 20);

        jLabel55.setText("Réduction");
        MesProduitsPanel1.add(jLabel55);
        jLabel55.setBounds(23, 241, 48, 14);
        MesProduitsPanel1.add(tfReduction2);
        tfReduction2.setBounds(128, 238, 80, 20);

        jLabel58.setText("Quantité");
        MesProduitsPanel1.add(jLabel58);
        jLabel58.setBounds(29, 276, 42, 14);
        MesProduitsPanel1.add(tfQuantite2);
        tfQuantite2.setBounds(128, 276, 80, 20);

        jLabel59.setText("Points Bonus");
        MesProduitsPanel1.add(jLabel59);
        jLabel59.setBounds(10, 321, 61, 14);

        tfPointBonus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPointBonus2ActionPerformed(evt);
            }
        });
        MesProduitsPanel1.add(tfPointBonus2);
        tfPointBonus2.setBounds(130, 320, 80, 20);

        jLabel60.setText("Description");
        MesProduitsPanel1.add(jLabel60);
        jLabel60.setBounds(18, 370, 53, 14);

        taDescription2.setColumns(20);
        taDescription2.setRows(5);
        jScrollPane17.setViewportView(taDescription2);

        MesProduitsPanel1.add(jScrollPane17);
        jScrollPane17.setBounds(128, 370, 166, 96);
        MesProduitsPanel1.add(labelId2);
        labelId2.setBounds(130, 10, 70, 20);

        bntConsulter1.setText("Consulter");
        bntConsulter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntConsulter1ActionPerformed(evt);
            }
        });
        MesProduitsPanel1.add(bntConsulter1);
        bntConsulter1.setBounds(550, 450, 90, 23);

        btnSupprimer1.setText("Supprimer");
        btnSupprimer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimer1ActionPerformed(evt);
            }
        });
        MesProduitsPanel1.add(btnSupprimer1);
        btnSupprimer1.setBounds(440, 450, 81, 23);

        jLabel61.setText("jLabel19");
        MesProduitsPanel1.add(jLabel61);
        jLabel61.setBounds(330, 20, 560, 410);

        jLabel62.setText("Nom produit");
        MesProduitsPanel1.add(jLabel62);
        jLabel62.setBounds(10, 40, 80, 14);

        btnModifierP1.setText("Modifier");
        btnModifierP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierP1ActionPerformed(evt);
            }
        });
        MesProduitsPanel1.add(btnModifierP1);
        btnModifierP1.setBounds(340, 450, 71, 23);

        labelId.setText("jLabel10");
        MesProduitsPanel1.add(labelId);
        labelId.setBounds(20, 10, 40, 14);

        MesProduitsConsultationPanel.add(MesProduitsPanel1, "card4");

        lNomProduit.setText("jLabel10");

        lCategorie.setText("jLabel11");

        lQuantite.setText("jLabel12");

        lDescription.setText("jLabel13");

        lPrix.setText("jLabel14");

        lPointBonus.setText("jLabel15");

        lZone.setText("jLabel16");

        lTVA.setText("jLabel17");

        lReduction.setText("jLabel10");

        btnBackP.setText("Back");
        btnBackP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConsultationPanelLayout = new javax.swing.GroupLayout(ConsultationPanel);
        ConsultationPanel.setLayout(ConsultationPanelLayout);
        ConsultationPanelLayout.setHorizontalGroup(
            ConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultationPanelLayout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addGroup(ConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lReduction)
                    .addComponent(lTVA)
                    .addComponent(lZone)
                    .addComponent(lPointBonus)
                    .addComponent(lPrix)
                    .addComponent(lDescription)
                    .addComponent(lQuantite)
                    .addComponent(lCategorie)
                    .addComponent(lNomProduit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConsultationPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBackP)
                .addGap(67, 67, 67))
        );
        ConsultationPanelLayout.setVerticalGroup(
            ConsultationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultationPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lNomProduit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lCategorie)
                .addGap(18, 18, 18)
                .addComponent(lQuantite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lDescription)
                .addGap(18, 18, 18)
                .addComponent(lPrix)
                .addGap(18, 18, 18)
                .addComponent(lPointBonus)
                .addGap(18, 18, 18)
                .addComponent(lZone)
                .addGap(18, 18, 18)
                .addComponent(lTVA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lReduction)
                .addGap(84, 84, 84)
                .addComponent(btnBackP)
                .addContainerGap(627, Short.MAX_VALUE))
        );

        MesProduitsConsultationPanel.add(ConsultationPanel, "card3");

        jTabbedPane1.addTab("Mes Produits", MesProduitsConsultationPanel);

        offresProduitsPan.setLayout(new java.awt.CardLayout());

        jScrollPane3.setSize(500, 600);

        tbProduits.setSize(600, 600);
        tbProduits.setModel(new ProduitModel());
        tbProduits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProduitsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbProduits);

        btnPartager.setText("Partager");
        btnPartager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartagerActionPerformed(evt);
            }
        });

        AjoutPanier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panier.png"))); // NOI18N
        AjoutPanier.setText("Ajouter Au panier");
        AjoutPanier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutPanierActionPerformed(evt);
            }
        });

        btnConsulterProduit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forward.png"))); // NOI18N
        btnConsulterProduit.setText("Consulter");
        btnConsulterProduit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsulterProduitMouseClicked(evt);
            }
        });
        btnConsulterProduit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsulterProduitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OffresProduitsTableauPanelLayout = new javax.swing.GroupLayout(OffresProduitsTableauPanel);
        OffresProduitsTableauPanel.setLayout(OffresProduitsTableauPanelLayout);
        OffresProduitsTableauPanelLayout.setHorizontalGroup(
            OffresProduitsTableauPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OffresProduitsTableauPanelLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OffresProduitsTableauPanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(btnConsulterProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AjoutPanier, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPartager, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(386, 386, 386))
        );
        OffresProduitsTableauPanelLayout.setVerticalGroup(
            OffresProduitsTableauPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OffresProduitsTableauPanelLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(OffresProduitsTableauPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPartager, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AjoutPanier, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsulterProduit))
                .addGap(682, 682, 682))
        );

        offresProduitsPan.add(OffresProduitsTableauPanel, "card2");

        lNomProduit1.setText("jLabel10");

        lCategorie1.setText("jLabel11");

        lQuantite1.setText("jLabel12");

        lDescription1.setText("jLabel13");

        lPrix1.setText("jLabel14");

        lPointBonus1.setText("jLabel15");

        lZone1.setText("jLabel16");

        lTVA1.setText("jLabel17");

        lReduction1.setText("jLabel10");

        btnBackP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnBackP1.setText("Back");
        btnBackP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackP1ActionPerformed(evt);
            }
        });

        tbCommentairesProduits.setModel(new CommentPModel());
        jScrollPane4.setViewportView(tbCommentairesProduits);

        tfCommentP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCommentPActionPerformed(evt);
            }
        });

        btnCommenterP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comment_1.png"))); // NOI18N
        btnCommenterP.setText("Commenter");
        btnCommenterP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommenterPActionPerformed(evt);
            }
        });

        btnSupprimerCommentaire1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rubbish-bin.png"))); // NOI18N
        btnSupprimerCommentaire1.setText("Supprimer Commentaire");
        btnSupprimerCommentaire1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerCommentaire1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConsultationPanel1Layout = new javax.swing.GroupLayout(ConsultationPanel1);
        ConsultationPanel1.setLayout(ConsultationPanel1Layout);
        ConsultationPanel1Layout.setHorizontalGroup(
            ConsultationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConsultationPanel1Layout.createSequentialGroup()
                .addGroup(ConsultationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ConsultationPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCommenterP, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSupprimerCommentaire1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBackP1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ConsultationPanel1Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addGroup(ConsultationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lReduction1)
                            .addComponent(lTVA1)
                            .addComponent(lZone1)
                            .addComponent(lPointBonus1)
                            .addComponent(lPrix1)
                            .addComponent(lDescription1)
                            .addComponent(lQuantite1)
                            .addComponent(lCategorie1)
                            .addComponent(lNomProduit1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                        .addGroup(ConsultationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCommentP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(133, 133, 133))
        );
        ConsultationPanel1Layout.setVerticalGroup(
            ConsultationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultationPanel1Layout.createSequentialGroup()
                .addGroup(ConsultationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConsultationPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lNomProduit1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lCategorie1)
                        .addGap(18, 18, 18)
                        .addComponent(lQuantite1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lDescription1)
                        .addGap(18, 18, 18)
                        .addComponent(lPrix1)
                        .addGap(18, 18, 18)
                        .addComponent(lPointBonus1)
                        .addGap(18, 18, 18)
                        .addComponent(lZone1)
                        .addGap(18, 18, 18)
                        .addComponent(lTVA1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lReduction1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConsultationPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addComponent(tfCommentP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(ConsultationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBackP1)
                    .addComponent(btnSupprimerCommentaire1)
                    .addComponent(btnCommenterP))
                .addContainerGap(570, Short.MAX_VALUE))
        );

        offresProduitsPan.add(ConsultationPanel1, "card3");

        jTabbedPane1.addTab("Offres", offresProduitsPan);

        javax.swing.GroupLayout ProduitPanelLayout = new javax.swing.GroupLayout(ProduitPanel);
        ProduitPanel.setLayout(ProduitPanelLayout);
        ProduitPanelLayout.setHorizontalGroup(
            ProduitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProduitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProduitPanelLayout.setVerticalGroup(
            ProduitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProduitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1057, Short.MAX_VALUE)
                .addContainerGap())
        );

        ParentPanel.add(ProduitPanel, "card2");

        PanelService.setPreferredSize(new java.awt.Dimension(1100, 707));

        tpService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpServiceMouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 51, 102));
        jLabel21.setText("Ajouter Un Service");

        jLabel22.setText("Nom Service :");

        tfNomS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomSActionPerformed(evt);
            }
        });

        jLabel23.setText("Description :");

        tfDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescriptionActionPerformed(evt);
            }
        });

        jLabel24.setText("Catégorie :");

        cbCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCatActionPerformed(evt);
            }
        });

        cbZone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbZone2ActionPerformed(evt);
            }
        });

        jLabel25.setText("Gouvernorat :");

        btnAjoutS.setBackground(new java.awt.Color(255, 204, 204));
        btnAjoutS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Plus.png"))); // NOI18N
        btnAjoutS.setText("Ajouter Service");
        btnAjoutS.setAlignmentX(10.1F);
        btnAjoutS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjoutSActionPerformed(evt);
            }
        });

        tblService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom Service", "Description", "Catégorie", "Date d'ajout", "Etat"
            }
        ));
        tblService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServiceMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblService);

        javax.swing.GroupLayout pAjoutSLayout = new javax.swing.GroupLayout(pAjoutS);
        pAjoutS.setLayout(pAjoutSLayout);
        pAjoutSLayout.setHorizontalGroup(
            pAjoutSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAjoutSLayout.createSequentialGroup()
                .addGroup(pAjoutSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25)
                    .addGroup(pAjoutSLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pAjoutSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAjoutSLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(pAjoutSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfDescription)
                            .addComponent(tfNomS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbZone2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAjoutSLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAjoutS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pAjoutSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pAjoutSLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel21))
                    .addGroup(pAjoutSLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lerror, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pAjoutSLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pAjoutSLayout.setVerticalGroup(
            pAjoutSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAjoutSLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel21)
                .addGap(47, 47, 47)
                .addComponent(jLabel22)
                .addGap(7, 7, 7)
                .addGroup(pAjoutSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pAjoutSLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 541, Short.MAX_VALUE)
                        .addComponent(lerror, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141))
                    .addGroup(pAjoutSLayout.createSequentialGroup()
                        .addComponent(tfNomS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel23)
                        .addGap(4, 4, 4)
                        .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel24)
                        .addGap(2, 2, 2)
                        .addComponent(cbCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel25)
                        .addGap(9, 9, 9)
                        .addComponent(cbZone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnAjoutS, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tpService.addTab("Ajouter Un Service", pAjoutS);

        ParentPanel2.setLayout(new java.awt.CardLayout());

        pAllServices.setLayout(null);

        tblAllServices.setModel((new ListeService()));
        tblAllServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAllServicesMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblAllServices);

        pAllServices.add(jScrollPane7);
        jScrollPane7.setBounds(55, 11, 452, 402);

        btnConsulterS1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forward.png"))); // NOI18N
        btnConsulterS1.setText("Consulter");
        btnConsulterS1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsulterS1MouseClicked(evt);
            }
        });
        btnConsulterS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsulterS1ActionPerformed(evt);
            }
        });
        pAllServices.add(btnConsulterS1);
        btnConsulterS1.setBounds(50, 450, 180, 41);

        ParentPanel2.add(pAllServices, "card3");

        btnBackS2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnBackS2.setText("Back");
        btnBackS2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackS2ActionPerformed(evt);
            }
        });

        tbCommentairesService.setModel( new CommentSModel());
        tbCommentairesService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCommentairesServiceMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbCommentairesService);

        btnSupprimerCommentaire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rubbish-bin.png"))); // NOI18N
        btnSupprimerCommentaire.setText("Supprimer Commentaire");
        btnSupprimerCommentaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerCommentaireActionPerformed(evt);
            }
        });

        bntMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/map-2.png"))); // NOI18N
        bntMap.setText("voir maps");
        bntMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntMapActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Nom Service :");

        lNomSAll.setText("nom");

        lDescriptionSAll.setText("des");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Description :");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Catégorie :");

        lCategorieServiceAll.setText("cat");

        lEtatSAll.setText("etat");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Etat :");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Zone :");

        lZoneSAll.setText("zone");

        javax.swing.GroupLayout pDetailSLayout = new javax.swing.GroupLayout(pDetailS);
        pDetailS.setLayout(pDetailSLayout);
        pDetailSLayout.setHorizontalGroup(
            pDetailSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDetailSLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pDetailSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDetailSLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(lDescriptionSAll))
                    .addGroup(pDetailSLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lNomSAll))
                    .addGroup(pDetailSLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pDetailSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(pDetailSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lZoneSAll)
                            .addComponent(lEtatSAll)
                            .addComponent(lCategorieServiceAll))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pDetailSLayout.setVerticalGroup(
            pDetailSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDetailSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDetailSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lNomSAll))
                .addGap(26, 26, 26)
                .addGroup(pDetailSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lDescriptionSAll))
                .addGap(30, 30, 30)
                .addGroup(pDetailSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(lCategorieServiceAll))
                .addGap(28, 28, 28)
                .addGroup(pDetailSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lEtatSAll))
                .addGap(18, 18, 18)
                .addGroup(pDetailSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(lZoneSAll))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pShowMap.setLayout(new java.awt.BorderLayout());

        btnCommenter1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comment_1.png"))); // NOI18N
        btnCommenter1.setText("Commenter");
        btnCommenter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommenter1ActionPerformed(evt);
            }
        });

        pConsulterS2.add(jScrollPane5);
        jScrollPane5.setBounds(55, 11, 452, 402);

        javax.swing.GroupLayout pConsulterS2Layout = new javax.swing.GroupLayout(pConsulterS2);
        pConsulterS2.setLayout(pConsulterS2Layout);
        pConsulterS2Layout.setHorizontalGroup(
            pConsulterS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pConsulterS2Layout.createSequentialGroup()
                .addGroup(pConsulterS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pConsulterS2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pDetailS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pConsulterS2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntMap)
                        .addGap(60, 60, 60)))
                .addGap(18, 18, 18)
                .addGroup(pConsulterS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pConsulterS2Layout.createSequentialGroup()
                        .addComponent(btnCommenter1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSupprimerCommentaire)
                        .addGap(204, 204, 204))
                    .addGroup(pConsulterS2Layout.createSequentialGroup()
                        .addComponent(pShowMap, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pConsulterS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfComment, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pConsulterS2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBackS2)
                .addGap(251, 251, 251))
        );
        pConsulterS2Layout.setVerticalGroup(
            pConsulterS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pConsulterS2Layout.createSequentialGroup()
                .addGroup(pConsulterS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pConsulterS2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(pDetailS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(bntMap))
                    .addGroup(pConsulterS2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfComment, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pConsulterS2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pShowMap, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(pConsulterS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCommenter1)
                    .addComponent(btnSupprimerCommentaire))
                .addGap(43, 43, 43)
                .addComponent(btnBackS2)
                .addContainerGap(450, Short.MAX_VALUE))
        );

        ParentPanel2.add(pConsulterS2, "card3");

        pShowMap1.setLayout(new java.awt.BorderLayout());
        pShowMap1.add(jLabel56, java.awt.BorderLayout.CENTER);

        ParentPanel2.add(pShowMap1, "card4");

        tpService.addTab("Les offres", ParentPanel2);

        ParentPanel1.setLayout(new java.awt.CardLayout());

        pMesServices.setLayout(null);

        tblMesServices.setModel((new ServiceByUserIdModel()));
        tblMesServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMesServicesMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblMesServices);

        pMesServices.add(jScrollPane9);
        jScrollPane9.setBounds(353, 11, 452, 402);
        pMesServices.add(lMsg);
        lMsg.setBounds(337, 470, 150, 57);

        btnModifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.jpg"))); // NOI18N
        btnModifier.setText("Modifier");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });
        pMesServices.add(btnModifier);
        btnModifier.setBounds(10, 440, 120, 30);

        bntSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rubbish-bin.png"))); // NOI18N
        bntSupprimer.setText("Supprimer");
        bntSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSupprimerActionPerformed(evt);
            }
        });
        pMesServices.add(bntSupprimer);
        bntSupprimer.setBounds(140, 440, 120, 30);

        pMesServices.add(cbZoneX);
        cbZoneX.setBounds(140, 370, 170, 30);

        jLabel31.setText("Zone :");
        pMesServices.add(jLabel31);
        jLabel31.setBounds(16, 373, 31, 14);

        jLabel32.setText("Etat :");
        pMesServices.add(jLabel32);
        jLabel32.setBounds(16, 320, 27, 14);

        cbEtat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EnCours", "n'est Plus valide" }));
        pMesServices.add(cbEtat);
        cbEtat.setBounds(150, 310, 156, 20);

        pMesServices.add(cbCat1);
        cbCat1.setBounds(150, 240, 156, 20);

        jLabel33.setText("Catégorie :");
        pMesServices.add(jLabel33);
        jLabel33.setBounds(16, 253, 54, 14);

        jLabel34.setText("Description :");
        pMesServices.add(jLabel34);
        jLabel34.setBounds(10, 120, 60, 14);
        pMesServices.add(tfDescription1);
        tfDescription1.setBounds(150, 130, 156, 62);

        tfNomService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomServiceActionPerformed(evt);
            }
        });
        pMesServices.add(tfNomService);
        tfNomService.setBounds(150, 60, 156, 20);

        jLabel35.setText("Nom Service :");
        pMesServices.add(jLabel35);
        jLabel35.setBounds(10, 63, 66, 14);

        labelId1.setText("ID");
        pMesServices.add(labelId1);
        labelId1.setBounds(10, 28, 50, 14);

        btnConsulterS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forward.png"))); // NOI18N
        btnConsulterS.setText("Consulter");
        btnConsulterS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsulterSMouseClicked(evt);
            }
        });
        btnConsulterS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsulterSActionPerformed(evt);
            }
        });
        pMesServices.add(btnConsulterS);
        btnConsulterS.setBounds(270, 440, 120, 30);

        ParentPanel1.add(pMesServices, "card2");

        jLabel36.setText("Nom Service :");

        tfNomService1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomService1ActionPerformed(evt);
            }
        });

        jLabel37.setText("Description :");

        jLabel38.setText("Catégorie :");

        cbCat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCat2ActionPerformed(evt);
            }
        });

        cbEtat1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EnCours", "n'est Plus valide" }));

        jLabel39.setText("Etat :");

        jLabel40.setText("Zone :");

        btnBackS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnBackS.setText("Back");
        btnBackS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackSActionPerformed(evt);
            }
        });

        btnMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/map-2.png"))); // NOI18N
        btnMap.setText("Voir Map");
        btnMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMapActionPerformed(evt);
            }
        });

        jTableCommentMesServ.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableCommentMesServ);

        javax.swing.GroupLayout pConsulterSLayout = new javax.swing.GroupLayout(pConsulterS);
        pConsulterS.setLayout(pConsulterSLayout);
        pConsulterSLayout.setHorizontalGroup(
            pConsulterSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pConsulterSLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pConsulterSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pConsulterSLayout.createSequentialGroup()
                        .addGroup(pConsulterSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addGroup(pConsulterSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel37)
                                .addGroup(pConsulterSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel40))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pConsulterSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDescription2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNomService1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCat2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEtat1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbZone5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pConsulterSLayout.createSequentialGroup()
                        .addComponent(btnMap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBackS, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(138, 138, 138)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(381, Short.MAX_VALUE))
        );
        pConsulterSLayout.setVerticalGroup(
            pConsulterSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pConsulterSLayout.createSequentialGroup()
                .addGroup(pConsulterSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pConsulterSLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(pConsulterSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbEtat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pConsulterSLayout.createSequentialGroup()
                                .addGroup(pConsulterSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfNomService1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36))
                                .addGroup(pConsulterSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pConsulterSLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel37))
                                    .addGroup(pConsulterSLayout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(tfDescription2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(55, 55, 55)
                                .addGroup(pConsulterSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel38)
                                    .addComponent(cbCat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addComponent(jLabel39)))
                        .addGap(33, 33, 33)
                        .addGroup(pConsulterSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel40)
                            .addComponent(cbZone5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(pConsulterSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMap)
                            .addComponent(btnBackS)))
                    .addGroup(pConsulterSLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(590, Short.MAX_VALUE))
        );

        ParentPanel1.add(pConsulterS, "card3");

        tpService.addTab("Mes Service", ParentPanel1);

        lTitreRechercheS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lTitreRechercheS.setText("Choisir une catégorie ou un nom de service: ");

        tblRechercheS.setModel(new ServiceByCategorieModel()

        );
        jScrollPane10.setViewportView(tblRechercheS);

        bntRechercheS.setText("Rechercher");
        bntRechercheS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRechercheSActionPerformed(evt);
            }
        });

        tfRechercheS.setText("Nom ou Categorie ou Zone");
        tfRechercheS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRechercheSActionPerformed(evt);
            }
        });

        rbNom.setText("Par Nom");
        rbNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNomActionPerformed(evt);
            }
        });

        rbCat.setText("Par Categorie");
        rbCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCatActionPerformed(evt);
            }
        });

        rbZone.setText("Par zone");
        rbZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbZoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pRechercheSLayout = new javax.swing.GroupLayout(pRechercheS);
        pRechercheS.setLayout(pRechercheSLayout);
        pRechercheSLayout.setHorizontalGroup(
            pRechercheSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRechercheSLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pRechercheSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pRechercheSLayout.createSequentialGroup()
                        .addComponent(rbNom)
                        .addGap(18, 18, 18)
                        .addComponent(rbCat)
                        .addGap(18, 18, 18)
                        .addComponent(rbZone))
                    .addGroup(pRechercheSLayout.createSequentialGroup()
                        .addComponent(bntRechercheS)
                        .addGap(18, 18, 18)
                        .addComponent(tfRechercheS, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lTitreRechercheS)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(502, Short.MAX_VALUE))
        );
        pRechercheSLayout.setVerticalGroup(
            pRechercheSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRechercheSLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lTitreRechercheS)
                .addGap(18, 18, 18)
                .addGroup(pRechercheSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbNom)
                    .addComponent(rbCat)
                    .addComponent(rbZone))
                .addGap(25, 25, 25)
                .addGroup(pRechercheSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntRechercheS)
                    .addComponent(tfRechercheS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(474, Short.MAX_VALUE))
        );

        tpService.addTab("Rechercher Un Service", pRechercheS);

        javax.swing.GroupLayout PanelServiceLayout = new javax.swing.GroupLayout(PanelService);
        PanelService.setLayout(PanelServiceLayout);
        PanelServiceLayout.setHorizontalGroup(
            PanelServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpService)
        );
        PanelServiceLayout.setVerticalGroup(
            PanelServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpService)
        );

        ParentPanel.add(PanelService, "card4");

        javax.swing.GroupLayout PanierReclamationLayout = new javax.swing.GroupLayout(PanierReclamation);
        PanierReclamation.setLayout(PanierReclamationLayout);
        PanierReclamationLayout.setHorizontalGroup(
            PanierReclamationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1243, Short.MAX_VALUE)
        );
        PanierReclamationLayout.setVerticalGroup(
            PanierReclamationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1079, Short.MAX_VALUE)
        );

        ParentPanel.add(PanierReclamation, "card5");

        MessagesPanel.setLayout(new java.awt.CardLayout());

        msgR.setLayout(null);

        btnTestMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Mail_reply.png"))); // NOI18N
        btnTestMsg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTestMsgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTestMsgMouseExited(evt);
            }
        });
        btnTestMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestMsgActionPerformed(evt);
            }
        });
        msgR.add(btnTestMsg);
        btnTestMsg.setBounds(510, 350, 80, 50);

        btnTestMsg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Mail_forward.png"))); // NOI18N
        btnTestMsg2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTestMsg2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTestMsg2MouseExited(evt);
            }
        });
        btnTestMsg2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestMsg2ActionPerformed(evt);
            }
        });
        msgR.add(btnTestMsg2);
        btnTestMsg2.setBounds(620, 350, 80, 50);

        tbMesMsgR.setModel( new MessageReçuModel ());
        jScrollPane12.setViewportView(tbMesMsgR);

        msgR.add(jScrollPane12);
        jScrollPane12.setBounds(170, 110, 540, 180);

        ecrireMsgLabel.setText("Ecrire un message");
        msgR.add(ecrireMsgLabel);
        ecrireMsgLabel.setBounds(510, 330, 100, 20);

        msgEnvoyesLabel.setText("Messages envoyés");
        msgR.add(msgEnvoyesLabel);
        msgEnvoyesLabel.setBounds(620, 330, 110, 20);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("Messages récus");
        msgR.add(jLabel46);
        jLabel46.setBounds(80, 40, 160, 40);

        MessagesPanel.add(msgR, "card2");

        lMsg1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lMsg1.setText("Ecrire un message");

        btnBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        btnEnvMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Mail-add.png"))); // NOI18N
        btnEnvMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnvMsgActionPerformed(evt);
            }
        });

        tfObjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfObjetActionPerformed(evt);
            }
        });

        taMsg.setColumns(20);
        taMsg.setRows(5);
        jScrollPane13.setViewportView(taMsg);

        jLabel41.setText(" À");

        jLabel42.setText("Objet");

        jLabel43.setText("Message");

        javax.swing.GroupLayout msgRedigerLayout = new javax.swing.GroupLayout(msgRediger);
        msgRediger.setLayout(msgRedigerLayout);
        msgRedigerLayout.setHorizontalGroup(
            msgRedigerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(msgRedigerLayout.createSequentialGroup()
                .addGroup(msgRedigerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(msgRedigerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lMsg1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(msgRedigerLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(msgRedigerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(msgRedigerLayout.createSequentialGroup()
                                .addGroup(msgRedigerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43)
                                    .addGroup(msgRedigerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel41)
                                        .addComponent(jLabel42)))
                                .addGap(18, 18, 18)
                                .addGroup(msgRedigerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfObjet, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDest, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, msgRedigerLayout.createSequentialGroup()
                                .addGap(351, 351, 351)
                                .addComponent(btnEnvMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack1)))
                .addContainerGap(655, Short.MAX_VALUE))
        );
        msgRedigerLayout.setVerticalGroup(
            msgRedigerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(msgRedigerLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lMsg1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(msgRedigerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(18, 18, 18)
                .addGroup(msgRedigerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfObjet, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(18, 18, 18)
                .addGroup(msgRedigerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(msgRedigerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEnvMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnBack1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(608, Short.MAX_VALUE))
        );

        MessagesPanel.add(msgRediger, "card3");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText("Les messages envoyés");

        btnBack2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });

        tbMsgEnvs.setModel(new MessagesEnvoyesModel());
        jScrollPane14.setViewportView(tbMsgEnvs);

        javax.swing.GroupLayout msgEnvoyeLayout = new javax.swing.GroupLayout(msgEnvoye);
        msgEnvoye.setLayout(msgEnvoyeLayout);
        msgEnvoyeLayout.setHorizontalGroup(
            msgEnvoyeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(msgEnvoyeLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(msgEnvoyeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack2)
                    .addGroup(msgEnvoyeLayout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(480, 480, 480)))
                .addContainerGap(580, Short.MAX_VALUE))
        );
        msgEnvoyeLayout.setVerticalGroup(
            msgEnvoyeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(msgEnvoyeLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(733, Short.MAX_VALUE))
        );

        MessagesPanel.add(msgEnvoye, "card4");

        ParentPanel.add(MessagesPanel, "card6");

        erreur1.setForeground(new java.awt.Color(255, 0, 0));

        erreur2.setForeground(new java.awt.Color(255, 0, 0));

        taDescriptionRec.setColumns(20);
        taDescriptionRec.setRows(5);
        jScrollPane15.setViewportView(taDescriptionRec);

        jLabel47.setText("Objet");

        jLabel48.setText("Description");

        jLabel49.setText("Envoyer une réclamation");

        btnEnvoyerRec.setText("Envoyer");
        btnEnvoyerRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnvoyerRecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ReclamationPanelLayout = new javax.swing.GroupLayout(ReclamationPanel);
        ReclamationPanel.setLayout(ReclamationPanelLayout);
        ReclamationPanelLayout.setHorizontalGroup(
            ReclamationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReclamationPanelLayout.createSequentialGroup()
                .addGroup(ReclamationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReclamationPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReclamationPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(ReclamationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReclamationPanelLayout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addGap(18, 18, 18)
                                .addComponent(tfSujetRec, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEnvoyerRec, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReclamationPanelLayout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ReclamationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(erreur1)
                    .addComponent(erreur2))
                .addContainerGap(748, Short.MAX_VALUE))
        );
        ReclamationPanelLayout.setVerticalGroup(
            ReclamationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReclamationPanelLayout.createSequentialGroup()
                .addGroup(ReclamationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReclamationPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(ReclamationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSujetRec, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47))
                        .addGap(18, 18, 18)
                        .addGroup(ReclamationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEnvoyerRec))
                    .addGroup(ReclamationPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(erreur1)
                        .addGap(98, 98, 98)
                        .addComponent(erreur2)))
                .addContainerGap(673, Short.MAX_VALUE))
        );

        ParentPanel.add(ReclamationPanel, "card7");

        NotificationPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                NotificationPanelComponentShown(evt);
            }
        });

        tbNotification.setModel(new NotificationModel());
        jScrollPane11.setViewportView(tbNotification);

        labelNotification.setText("Vous avez une notification");

        btnSupNotification.setText("Supprimer tout");
        btnSupNotification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupNotificationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NotificationPanelLayout = new javax.swing.GroupLayout(NotificationPanel);
        NotificationPanel.setLayout(NotificationPanelLayout);
        NotificationPanelLayout.setHorizontalGroup(
            NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NotificationPanelLayout.createSequentialGroup()
                .addGroup(NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NotificationPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(btnSupNotification))
                    .addGroup(NotificationPanelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(labelNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(525, Short.MAX_VALUE))
        );
        NotificationPanelLayout.setVerticalGroup(
            NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NotificationPanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(labelNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NotificationPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(NotificationPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnSupNotification)))
                .addContainerGap(865, Short.MAX_VALUE))
        );

        ParentPanel.add(NotificationPanel, "card8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(ParentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ParentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProduitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduitsActionPerformed

        ParentPanel.removeAll();
        ParentPanel.add(ProduitPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();


    }//GEN-LAST:event_btnProduitsActionPerformed

    private void btnAccueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccueilActionPerformed
        // TODO add your handling code here:
        ParentPanel.removeAll();
        ParentPanel.add(AccueilPanel2);
        ParentPanel.repaint();
        ParentPanel.revalidate();
    }//GEN-LAST:event_btnAccueilActionPerformed

    private void tbProduitsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProduitsMouseClicked

    }//GEN-LAST:event_tbProduitsMouseClicked

    private void btnPartagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartagerActionPerformed
        int ligneSelectionne = tbProduits.getSelectedRow();
        //on récupére la valeur de la première colonne de la ligne sélectionné

        Object l = tbProduits.getValueAt(ligneSelectionne, 0);

        String accessToken = "CAACEdEose0cBAMDBjsGZBTLZB8BIfLGJGbjs0YZA3tCD3PXrq4sPnLsWYMlcAQzVRESOhmiAcmujhVZAtZAVYGylTOrXfBkHTZAnqsESaJo6Bb1AryqRB08XUmjp2gfvE2W4LJfdhvmJPhyEcFvEIRYgloJgUNcO1tMpOBpAThu7GO7VGaZCYCZCYFZAENcOlfCyUjQJc2qwA9gZDZD";
        FacebookClient fbClient = new DefaultFacebookClient(accessToken);
        User me = fbClient.fetchObject("me", User.class);
        Page userPgae = fbClient.fetchObject("10208045352675324", Page.class);

        System.out.println(me.getName());
        System.out.println(me.getBirthday());

        String nom = (String) tbProduits.getValueAt(ligneSelectionne, 1);
        String categorie = (String) tbProduits.getValueAt(ligneSelectionne, 2);
        int quantite = (int) tbProduits.getValueAt(ligneSelectionne, 3);
        String description = (String) tbProduits.getValueAt(ligneSelectionne, 4);
        float prix = (float) tbProduits.getValueAt(ligneSelectionne, 5);
        int pointBonus = (int) tbProduits.getValueAt(ligneSelectionne, 6);
        String zone = (String) tbProduits.getValueAt(ligneSelectionne, 7);
        Date dateAjout = (Date) tbProduits.getValueAt(ligneSelectionne, 8);
        float TVA = (float) tbProduits.getValueAt(ligneSelectionne, 9);
        float reduction = (float) tbProduits.getValueAt(ligneSelectionne, 10);
        int rating = (int) tbProduits.getValueAt(ligneSelectionne, 11);

        fbClient.publish("10208045352675324" + "/feed", FacebookType.class, Parameter.with("message", "nom du produit : " + nom
                + "\nCategorie : " + categorie + "\nQuantite : " + quantite + "\nDescription : " + description + "\nPrix : " + prix + "\nPoint Bonus: " + pointBonus + "\nGouvernorat : " + zone + "\n Date Ajout :" + dateAjout + "TVA : " + TVA + "\nRéduction : " + reduction + "\rating" + rating));

        JOptionPane.showMessageDialog(null, "Shared Succefully on Facebook!");
    }//GEN-LAST:event_btnPartagerActionPerformed

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed

        Produit p = new Produit();
        Date date = new java.sql.Date(System.currentTimeMillis());
        p.setDateAjout(date);
        p.setPrix((float) Double.parseDouble(tfPrix.getText()));
        p.setQuantite(Integer.parseInt(tfQuantite.getText()));
        p.setTva(Integer.parseInt(tfTVA.getText()));
        p.setReduction(Integer.parseInt(tfReduction.getText()));
        p.setNomP(tfNomP.getText());
        p.setUser(LoginForm.getUser_id());

        try {
            rsId = zdao.getZoneByName(cbZone.getSelectedItem().toString());
            while (rsId.next()) {
                p.setZone(rsId.getInt(1));

            }//this.setResizable(false);
        } catch (SQLException ex) {
            Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rsIdC = cdao.getCategorieByName(cbCategorie.getSelectedItem().toString());
            while (rsIdC.next()) {
                p.setCategorie(rsIdC.getInt(1));

            }//this.setResizable(false);
        } catch (SQLException ex) {
            Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.setPtbonus(Integer.parseInt(tfPointBonus.getText()));
        p.setDescription(taDescription.getText());

        PostFile pf = new PostFile();
        String sp = tfPhoto.getText();
        try {
            pf.upload(sp);
            JOptionPane.showMessageDialog(null, "Image telechargé avec succés");
            p.setPhoto("http://localhost/Tec/web/uploads/media/profile/" + im);
        } catch (Exception ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);

        }

        LAlerte.setText(" ");

        if (!tfNomP.getText().trim().equals("")) {
            pdao.add(p);
            tbProduits.setModel(new ProduitModel());
            tblMesProduits.setModel(new ProduitClientModel());
        } else {
            LAlerte.setText("Veuiller introduire le nom de votre produit");
        }
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void tfNomPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomPActionPerformed

    private void cbCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategorieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategorieActionPerformed

    private void LAlerteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAlerteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LAlerteActionPerformed

    private void btnParcourirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParcourirActionPerformed
        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(btnParcourir);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            tfPhoto.setText(chooser.getSelectedFile().getAbsolutePath());
            im = chooser.getSelectedFile().getName();
        }
    }//GEN-LAST:event_btnParcourirActionPerformed

    private void btnServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicesActionPerformed
        // TODO add your handling code here:
        ParentPanel.removeAll();
        ParentPanel.add(PanelService);
        ParentPanel.repaint();
        ParentPanel.revalidate();
    }//GEN-LAST:event_btnServicesActionPerformed

    private void tfNomSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomSActionPerformed

    private void tfDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDescriptionActionPerformed

    private void cbCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCatActionPerformed

    private void cbZone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbZone2ActionPerformed

    }//GEN-LAST:event_cbZone2ActionPerformed

    private void btnAjoutSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjoutSActionPerformed
        // TODO add your handling code here:
        lerror.setText(" ");

        Service s = new Service();
        Date date = new java.sql.Date(System.currentTimeMillis());
        s.setUserId(LoginForm.getUser_id());
        if (!tfNomS.getText().trim().equals("")) {
            s.setNomService(tfNomS.getText());
            try {

                rsId = zoneDAO.getZoneByName(cbZone2.getSelectedItem().toString());
                while (rsId.next()) {
                    s.setZone(rsId.getInt(1));

                }
            } catch (SQLException ex) {
                Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                rsIdCol = coldao.getCollectionByName(cbCat.getSelectedItem().toString());
                while (rsIdCol.next()) {
                    s.setType(rsIdCol.getInt(1));

                }
            } catch (SQLException ex) {
                Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            s.setDescription(tfDescription.getText());
            // s.setType(cbCat.getSelectedItem());
            //s.setZone((int) cbZone.getSelectedItem());
            s.setDateAjout(date);
            s.setEtat("EnCours");
            ServiceDao sdao = new ServiceDao();
            System.out.println(rsIdCol);
            sdao.add(s);

            DefaultTableModel model = (DefaultTableModel) tblService.getModel();
            model.addRow(new Object[]{tfNomS.getText(), tfDescription.getText(), cbCat.getSelectedItem().toString(), s.getDateAjout(), s.getEtat()});

            tfNomS.setText(null);
            tfDescription.setText(null);

            cbCat.setSelectedItem(null);
            cbZone2.setSelectedItem(null);

        } else {
            lerror.setText(" Veuiller enter le nom de votre service SVP !");
            tblAllServices.setModel(new ListeService());
            tblAllServices.getColumnModel().getColumn(0).setMinWidth(0);
            tblAllServices.getColumnModel().getColumn(0).setMaxWidth(0);
            tblAllServices.getColumnModel().getColumn(0).setWidth(0);
           
            tblMesServices.setModel(new ServiceByUserIdModel());
        }
    }//GEN-LAST:event_btnAjoutSActionPerformed

    private void tblServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServiceMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblServiceMouseClicked

    private void tblAllServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAllServicesMouseClicked
        int i = tblAllServices.getSelectedRow();
        Object l = tblAllServices.getValueAt(i, 0);
        service_id = (int) l;
        System.out.println("ID" + service_id);
    }//GEN-LAST:event_tblAllServicesMouseClicked

    private void btnConsulterS1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsulterS1MouseClicked

    }//GEN-LAST:event_btnConsulterS1MouseClicked

    private void btnConsulterS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsulterS1ActionPerformed
        // TODO add your handling code here:
        int i = tblAllServices.getSelectedRow();
        TableModel model = tblAllServices.getModel();
        Object l = tblAllServices.getValueAt(i, 0);
 
        service_id = (int) l;

     
        tbCommentairesService.setModel(new CommentSModel());
        tbCommentairesService.setVisible(true);
        tbCommentairesService.getColumnModel().getColumn(0).setMinWidth(0);
        tbCommentairesService.getColumnModel().getColumn(0).setMaxWidth(0);
        tbCommentairesService.getColumnModel().getColumn(0).setWidth(0);
        lNomSAll.setText(model.getValueAt(i, 1).toString());
        lDescriptionSAll.setText(model.getValueAt(i, 2).toString());
        lCategorieServiceAll.setText(tblAllServices.getValueAt(i, 3).toString());
        lEtatSAll.setText(tblAllServices.getValueAt(i, 4).toString());
        lZoneSAll.setText(model.getValueAt(i, 5).toString());

        Service s = sdao.findById(service_id);

        System.out.println(s.getZone());
        pShowMap.setLayout(new BorderLayout());
        //pShowMap.add(view.getComponent(0), BorderLayout.CENTER);
        java.util.List<Zone> obj = new ArrayList();

        obj = sdao.findByZone(s.getZone());
        double x;
        double y;
        for (Object o : obj) {
            x = ((Zone) o).getLat();
            y = ((Zone) o).getLon();
            System.out.println(x + "dddddddddd" + y);
            //browser.loadURL("https://maps.googleapis.com/maps/api/staticmap?center=" + x + "," + y + "&zoom=12&size=700x500&maptype=roadmap&markers=icone%7Clabel:S%7C" + x + "," + y);
        }

        ParentPanel2.removeAll();
        ParentPanel2.add(pConsulterS2);
        ParentPanel2.repaint();
        ParentPanel2.revalidate();

    }//GEN-LAST:event_btnConsulterS1ActionPerformed

    private void btnBackS2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackS2ActionPerformed
        // TODO add your handling code here:
        ParentPanel2.removeAll();
        ParentPanel2.add(pAllServices);
        ParentPanel2.repaint();
        ParentPanel2.revalidate();
    }//GEN-LAST:event_btnBackS2ActionPerformed

    private void tbCommentairesServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCommentairesServiceMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tbCommentairesServiceMouseClicked

    private void btnSupprimerCommentaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerCommentaireActionPerformed
        Comment c = new Comment();
        CommentDao comm = new CommentDao();
        int ligneSelectionne = tbCommentairesService.getSelectedRow();
        Object l = tbCommentairesService.getValueAt(ligneSelectionne, 0);
        System.out.println(l);
        c = comm.findById((int) l);
        String s = (String) tbCommentairesService.getValueAt(ligneSelectionne, 3);
        System.out.println(s);
        if (LoginForm.getUser_id() == c.getUser_id()) {
            int i = JOptionPane.showConfirmDialog(null, "La suppression est irréversible. Êtes-vous sûr de vouloir continuer?",
                    "Veuillez confirmer votre choix",
                    JOptionPane.YES_NO_OPTION);

            if (i == 0) {
                comm.removeById((int) l);
                tbCommentairesService.setModel(new CommentSModel());
                tbCommentairesService.getColumnModel().getColumn(0).setMinWidth(0);
                tbCommentairesService.getColumnModel().getColumn(0).setMaxWidth(0);
                tbCommentairesService.getColumnModel().getColumn(0).setWidth(0);
            }
        } else {
            JOptionPane.showMessageDialog(ParentPanel, "Ce commentaire est ajouté par " + s + ". Vous ne pouvez pas le supprimer");
        }

    }//GEN-LAST:event_btnSupprimerCommentaireActionPerformed

    private void bntMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntMapActionPerformed


    }//GEN-LAST:event_bntMapActionPerformed

    private void tblMesServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMesServicesMouseClicked
        // TODO add your handling code here:
        int i = tblMesServices.getSelectedRow();
        TableModel model = tblMesServices.getModel();

        //tfId.setText(model.getValueAt(i, 0).toString());
        labelId1.setText(model.getValueAt(i, 0).toString());
        tfNomService.setText(model.getValueAt(i, 1).toString());
        tfDescription1.setText(model.getValueAt(i, 2).toString());

        cbCat1.setSelectedItem(tblMesServices.getValueAt(i, 3));
        cbZoneX.setSelectedItem(tblMesServices.getValueAt(i, 5));
        cbEtat.setSelectedItem(tblMesServices.getValueAt(i, 4));


    }//GEN-LAST:event_tblMesServicesMouseClicked

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        // TODO add your handling code here:
        lMsg.setText(" ");

        Service s = new Service();
        Date date = new java.sql.Date(System.currentTimeMillis());
        if (!tfNomService.getText().trim().equals("")) {
            s.setId(Integer.parseInt(labelId1.getText()));
            s.setNomService(tfNomService.getText());
            s.setDescription(tfDescription1.getText());
            // s.setType(cbCat1.getSelectedItem().toString());

            try {
                rsIdCol = coldao.getCollectionByName(cbCat1.getSelectedItem().toString());
                while (rsIdCol.next()) {
                    s.setType(rsIdCol.getInt(1));

                }
            } catch (SQLException ex) {
                Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

                rsId = zoneDAO.getZoneByName(cbZoneX.getSelectedItem().toString());
                while (rsId.next()) {
                    s.setZone(rsId.getInt(1));

                }
            } catch (SQLException ex) {
                Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            s.setDateAjout(date);
            s.setEtat(cbEtat.getSelectedItem().toString());
            ServiceDao sdao = new ServiceDao();
            sdao.update(s);
            //jScrollPane1.setViewportView(tblService);

        } else {
            lMsg.setText(" Veuiller enter le nom de votre service SVP !");
        }
        tblMesServices.setModel(new ServiceByUserIdModel()); // Act tab apres modif
    }//GEN-LAST:event_btnModifierActionPerformed

    private void bntSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSupprimerActionPerformed
        // TODO add your handling code here:

        // FrameAfficherServiceAdmin f = new FrameAfficherServiceAdmin();
        int i = tblMesServices.getSelectedRow();
        Object l = tblMesServices.getValueAt(i, 0);

        ServiceDao sdao = new ServiceDao();

        int j = JOptionPane.showConfirmDialog(null, "la suppression est irréversible. Etes-vous sur de vouloir continuer?", "Veuillez confirmer votre choix", JOptionPane.YES_NO_OPTION);

        if (j == 0) {
            sdao.removeById((int) l);
            tblMesServices.setModel(new ServiceByUserIdModel());
            jScrollPane9.setViewportView(tblMesServices);
            labelId.setText(null);
            tfNomService.setText(null);
            tfDescription1.setText(null);

            cbCat1.setSelectedItem(null);
            cbZoneX.setSelectedItem(null);
            cbEtat.setSelectedItem(null);

        }

    }//GEN-LAST:event_bntSupprimerActionPerformed

    private void tfNomServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomServiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomServiceActionPerformed

    private void btnConsulterSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsulterSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsulterSMouseClicked

    private void btnConsulterSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsulterSActionPerformed
        // TODO add your handling code here:
        int i = tblMesServices.getSelectedRow();
        Object l = tblMesServices.getValueAt(i, 0);
        service_id = (int) l;
        System.out.println(service_id);
        TableModel model = tblMesServices.getModel();
        //labelId.setText(model.getValueAt(i, 0).toString());
        tfNomService1.setText(model.getValueAt(i, 1).toString());
        tfDescription2.setText(model.getValueAt(i, 2).toString());

        cbCat2.setSelectedItem(tblMesServices.getValueAt(i, 3));
        cbEtat1.setSelectedItem(tblMesServices.getValueAt(i, 4));
        cbZone2.setSelectedItem(model.getValueAt(i, 5).toString());
        ParentPanel.removeAll();
        ParentPanel.add(pConsulterS);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        jTableCommentMesServ.setModel(new CommentSModel());
        jTableCommentMesServ.getColumnModel().getColumn(0).setMinWidth(0);
        jTableCommentMesServ.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableCommentMesServ.getColumnModel().getColumn(0).setWidth(0);

        //        pConsulterS.setVisible(true);
    }//GEN-LAST:event_btnConsulterSActionPerformed

    private void tfNomService1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomService1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomService1ActionPerformed

    private void cbCat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCat2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCat2ActionPerformed

    private void btnBackSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackSActionPerformed
        // TODO add your handling code here:
        ParentPanel.removeAll();
        ParentPanel.add(pMesServices);
        ParentPanel.repaint();
        ParentPanel.revalidate();
    }//GEN-LAST:event_btnBackSActionPerformed

    private void btnMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapActionPerformed
        // TODO add your handling code here:
        int i = tblAllServices.getSelectedRow();
        TableModel model = tblAllServices.getModel();
        Object l = tblAllServices.getValueAt(i, 0);
        service_id = (int) l;

        Service s = sdao.findById(service_id);
        //System.out.println("test zone"+s.getZone());
//        Map map = new Map();
//
//        map.maps(s.getZone());

        double x;
        double y;
        java.util.List<Zone> obj = new ArrayList();
        ServiceDao pdao = new ServiceDao();
        obj = pdao.findByZone(s.getZone());
        for (Object o : obj) {
            x = ((Zone) o).getLat();
            y = ((Zone) o).getLon();
        }
    }//GEN-LAST:event_btnMapActionPerformed

    private void tpServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpServiceMouseClicked
        // TODO add your handling code here:
        tblAllServices.setModel(new ListeService());
        tblAllServices.getColumnModel().getColumn(0).setMinWidth(0);
            tblAllServices.getColumnModel().getColumn(0).setMaxWidth(0);
            tblAllServices.getColumnModel().getColumn(0).setWidth(0);
//            tblAllServices.getColumnModel().getColumn(7).setMinWidth(0);
//            tblAllServices.getColumnModel().getColumn(7).setMaxWidth(0);
//            tblAllServices.getColumnModel().getColumn(7).setWidth(0);

    }//GEN-LAST:event_tpServiceMouseClicked

    private void btnTestMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestMsgActionPerformed
        // TODO add your handling code here:
        MessagesPanel.removeAll();
        MessagesPanel.add(msgRediger);
        MessagesPanel.repaint();
        MessagesPanel.revalidate();
    }//GEN-LAST:event_btnTestMsgActionPerformed

    private void btnTestMsg2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestMsg2ActionPerformed
        // TODO add your handling code here:
        MessagesPanel.removeAll();
        MessagesPanel.add(msgEnvoye);
        MessagesPanel.repaint();
        MessagesPanel.revalidate();
    }//GEN-LAST:event_btnTestMsg2ActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        MessagesPanel.removeAll();
        MessagesPanel.add(msgR);
        MessagesPanel.repaint();
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnEnvMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnvMsgActionPerformed
        UserDao udao = new UserDao();
        MessageDao mdao = new MessageDao();
        Message m = new Message();
        String test = tfDest.getText();
        System.out.println(test);
        entite.User u = udao.findByUserNameI(test);
        if (u.getUsername().equals(test) == true) {
            m.setFrom(LoginForm.getUserName());
            m.setTo(tfDest.getText());
            m.setSujet(tfObjet.getText());
            m.setTexte(taMsg.getText());

            System.out.println(LoginForm.getUserName());
            Date date = new java.sql.Date(System.currentTimeMillis());
            m.setDate_envoi(date);
            mdao.add(m);
            tfDest.setText("");
            tfObjet.setText("");
            taMsg.setText("");
        } else {
            JOptionPane.showMessageDialog(msgRediger, "Cet utilisateur n existe pas");
        }
    }//GEN-LAST:event_btnEnvMsgActionPerformed

    private void tfObjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfObjetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfObjetActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        MessagesPanel.removeAll();
        MessagesPanel.add(msgR);
        MessagesPanel.repaint();
        MessagesPanel.revalidate();
    }//GEN-LAST:event_btnBack2ActionPerformed

    private void btnMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(MessagesPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
    }//GEN-LAST:event_btnMessageActionPerformed

    private void btnAccueilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccueilMouseEntered
        // TODO add your handling code here:
        accueillabel.setVisible(true);
        btnAccueil.setOpaque(true);
        btnAccueil.setContentAreaFilled(true);
        btnAccueil.setBorderPainted(true);
    }//GEN-LAST:event_btnAccueilMouseEntered

    private void btnAccueilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccueilMouseExited

        btnAccueil.setOpaque(false);
        btnAccueil.setContentAreaFilled(false);
        btnAccueil.setBorderPainted(false);
        accueillabel.setVisible(false);    }//GEN-LAST:event_btnAccueilMouseExited

    private void btnProduitsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProduitsMouseEntered
        btnProduits.setOpaque(true);
        btnProduits.setContentAreaFilled(true);
        btnProduits.setBorderPainted(true);
 produitsLabel.setVisible(true);    }//GEN-LAST:event_btnProduitsMouseEntered

    private void btnProduitsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProduitsMouseExited
        btnProduits.setOpaque(false);
        btnProduits.setContentAreaFilled(false);
        btnProduits.setBorderPainted(false);
produitsLabel.setVisible(false);      }//GEN-LAST:event_btnProduitsMouseExited

    private void btnServicesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServicesMouseExited
        servicesLabel.setVisible(false);
        btnServices.setOpaque(false);
        btnServices.setContentAreaFilled(false);
        btnServices.setBorderPainted(false);
    }//GEN-LAST:event_btnServicesMouseExited

    private void btnServicesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServicesMouseEntered
        servicesLabel.setVisible(true);
        btnServices.setOpaque(true);
        btnServices.setContentAreaFilled(true);
        btnServices.setBorderPainted(true);
    }//GEN-LAST:event_btnServicesMouseEntered

    private void btnReclamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReclamMouseEntered
        reclamationLabel.setVisible(true);
        btnReclam.setOpaque(true);
        btnReclam.setContentAreaFilled(true);
        btnReclam.setBorderPainted(true);
    }//GEN-LAST:event_btnReclamMouseEntered

    private void btnReclamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReclamMouseExited
        reclamationLabel.setVisible(false);
        btnReclam.setOpaque(false);
        btnReclam.setContentAreaFilled(false);
        btnReclam.setBorderPainted(false);
    }//GEN-LAST:event_btnReclamMouseExited

    private void btnEnvoyerRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnvoyerRecActionPerformed
        if (!tfSujetRec.getText().equals("") || taDescriptionRec.getText().equals(" ")) {
            Reclamation r = new Reclamation();
            r.setSujet(tfSujetRec.getText());
            r.setDescription(taDescriptionRec.getText());
            Date date = new java.sql.Date(System.currentTimeMillis());
            r.setDate(date);
            ReclamationDao rdao = new ReclamationDao();
            rdao.add(r);
            tfSujetRec.setText("");
            taDescriptionRec.setText("");
        } else {
            JOptionPane.showMessageDialog(ParentPanel, "Veuillez remplir tous les champs");
        }
    }//GEN-LAST:event_btnEnvoyerRecActionPerformed

    private void btnReclamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReclamActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(ReclamationPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
    }//GEN-LAST:event_btnReclamActionPerformed

    private void btnProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfileMouseEntered
        // TODO add your handling code here:
        btnProfile.setOpaque(true);
        btnProfile.setContentAreaFilled(true);
        btnProfile.setBorderPainted(true);
    }//GEN-LAST:event_btnProfileMouseEntered

    private void btnProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfileMouseExited
        // TODO add your handling code here:
        btnProfile.setOpaque(false);
        btnProfile.setContentAreaFilled(false);
        btnProfile.setBorderPainted(false);

    }//GEN-LAST:event_btnProfileMouseExited

    private void NotificationPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_NotificationPanelComponentShown
        tbNotification.setModel(new NotificationModel());
        //          Notification n = new Notification();
        //             NotificationDao ndao = new NotificationDao();
        //             note= ndao.findNotificationService(9);
        //
        //
        //               note.stream().forEach((e) -> {
        //                   JTextField tf = new JTextField ();
        //                    tf.setText("service"+e.getId_service());
        //                    NotificationPanel.add(tf);
        //                    tf.setVisible(true);
        //
        //            System.out.println(e);
        //               });
        //        for (Object o : note) {
        //            tfNotification.setText("vous avez une notification"+o.toString());
        //
        //         }
        //

    }//GEN-LAST:event_NotificationPanelComponentShown

    private void btnNotifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifActionPerformed
        // TODO add your handling code here:
        ParentPanel.removeAll();
        ParentPanel.add(NotificationPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
//        tbNotification.setModel(new NotificationModel());
//        tbNotification.getColumnModel().getColumn(0).setMinWidth(0);
//        tbNotification.getColumnModel().getColumn(0).setMaxWidth(0);
//        tbNotification.getColumnModel().getColumn(0).setWidth(0);
    }//GEN-LAST:event_btnNotifActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnSupNotificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupNotificationActionPerformed
        // TODO add your handling code here:
        NotificationDao ndao = new NotificationDao();
        Notification n = new Notification();
       // n=ndao.removeById((int)LoginForm.getUser_id());
    }//GEN-LAST:event_btnSupNotificationActionPerformed

    private void btnPanierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPanierMouseExited
        // TODO add your handling code here:
        btnPanier.setOpaque(false);
        btnPanier.setContentAreaFilled(false);
        btnPanier.setBorderPainted(false);
    }//GEN-LAST:event_btnPanierMouseExited

    private void btnPanierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPanierMouseEntered
        // TODO add your handling code here:
        btnPanier.setOpaque(true);
        btnPanier.setContentAreaFilled(true);
        btnPanier.setBorderPainted(true);
    }//GEN-LAST:event_btnPanierMouseEntered

    private void btnMessageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMessageMouseExited
        // TODO add your handling code here:
        btnMessage.setOpaque(false);
        btnMessage.setContentAreaFilled(false);
        btnMessage.setBorderPainted(false);
    }//GEN-LAST:event_btnMessageMouseExited

    private void btnMessageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMessageMouseEntered
        // TODO add your handling code here:
        btnMessage.setOpaque(true);
        btnMessage.setContentAreaFilled(true);
        btnMessage.setBorderPainted(true);
    }//GEN-LAST:event_btnMessageMouseEntered

    private void btnNotifMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotifMouseEntered
        // TODO add your handling code here:
        btnNotif.setOpaque(true);
        btnNotif.setContentAreaFilled(true);
        btnNotif.setBorderPainted(true);
    }//GEN-LAST:event_btnNotifMouseEntered

    private void btnNotifMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotifMouseExited
        // TODO add your handling code here:
        btnNotif.setOpaque(false);
        btnNotif.setContentAreaFilled(false);
        btnNotif.setBorderPainted(false);
    }//GEN-LAST:event_btnNotifMouseExited

    private void btnCommenter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommenter1ActionPerformed
        // TODO add your handling code here:
        Comment c = new Comment();
        Notification n = new Notification();
        NotificationDao ndao = new NotificationDao();

        c.setBody(tfComment.getText());
        java.util.Date date = new java.sql.Date(System.currentTimeMillis());
        c.setCreated_at(date);
        System.out.println("testServiceId" + AllForDealFrame.getService_id());
        c.setService_id(AllForDealFrame.getService_id());
        c.setUser_id(LoginForm.getUser_id());
        System.out.println(LoginForm.getUser_id());

        CommentDao pdao = new CommentDao();
        pdao.addS(c);
        n.setId_service(AllForDealFrame.getService_id());
        n.setId_user(LoginForm.getUser_id());
        ndao.add(n);
        tbCommentairesService.setModel(new CommentSModel());
        tbCommentairesService.getColumnModel().getColumn(0).setMinWidth(0);
        tbCommentairesService.getColumnModel().getColumn(0).setMaxWidth(0);
        tbCommentairesService.getColumnModel().getColumn(0).setWidth(0);
        tfComment.setText("");

    }//GEN-LAST:event_btnCommenter1ActionPerformed

    private void btnTestMsgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTestMsgMouseEntered
        // TODO add your handling code here:
        ecrireMsgLabel.setVisible(true);
    }//GEN-LAST:event_btnTestMsgMouseEntered

    private void btnTestMsgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTestMsgMouseExited
        // TODO add your handling code here:
        ecrireMsgLabel.setVisible(false);

    }//GEN-LAST:event_btnTestMsgMouseExited

    private void btnTestMsg2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTestMsg2MouseExited
        // TODO add your handling code here:
        msgEnvoyesLabel.setVisible(false);

    }//GEN-LAST:event_btnTestMsg2MouseExited

    private void btnTestMsg2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTestMsg2MouseEntered
        // TODO add your handling code here:
        msgEnvoyesLabel.setVisible(true);

    }//GEN-LAST:event_btnTestMsg2MouseEntered

    private void btnPlay2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlay2ActionPerformed
        // TODO add your handling code her

        videoPlayer.setTitle("Swing Video Player");
        videoPlayer.setDefaultCloseOperation(EXIT_ON_CLOSE);
        videoPlayer.setLayout(new BorderLayout());
        videoPlayer.setSize(640, 480);
        videoPlayer.add(pv, BorderLayout.CENTER);
        videoPlayer.validate();
        videoPlayer.setVisible(true);
        pv.play("C:\\Users\\SaharS\\Desktop\\JAVA.MP4");
    }//GEN-LAST:event_btnPlay2ActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        // TODO add your handling code here:
        pv.pause("C:\\Users\\SaharS\\Desktop\\JAVA.MP4");
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnSonOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSonOffActionPerformed
        // TODO add your handling code here:
        clip.stop();

    }//GEN-LAST:event_btnSonOffActionPerformed

    private void btnSonOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSonOnActionPerformed
        // TODO add your handling code here:
        Mixer.Info[] mixInfo = AudioSystem.getMixerInfo();
        mixer = AudioSystem.getMixer(mixInfo[0]);
        DataLine.Info dataLine = new DataLine.Info(Clip.class, null);
        try {
            clip = (Clip) mixer.getLine(dataLine);
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        }
        try {
            URL soundURL = this.getClass().getResource("/images/The_Eagles-Hotel_California_acoustic_live_www.wav");
            AudioInputStream audioImput = AudioSystem.getAudioInputStream(soundURL);
            clip.open(audioImput);

        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (UnsupportedAudioFileException exp) {
            exp.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }

        clip.start();
    }//GEN-LAST:event_btnSonOnActionPerformed

    private void cbZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbZoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbZoneActionPerformed
    int i = 0;
    List<Produit> lp = pdao.findAll();
    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed

        System.out.println(lp);

        Produit p1 = lp.get(i);
        lnom.setText(p1.getNomP());
        lprix.setText("" + p1.getPrix());
        lbonus.setText("" + p1.getPtbonus());
        lquantite.setText("" + p1.getQuantite());
        lcat.setText("" + p1.getCategorie());
        /*-------------------------*/
        Produit p2 = lp.get(i - 1);
        lnom1.setText(p2.getNomP());
        lprix1.setText("" + p2.getPrix());
        lbonus1.setText("" + p2.getPtbonus());
        lquantite1.setText("" + p2.getQuantite());
        lcat1.setText("" + p2.getCategorie());
        /*-------------------------*/
        Produit p3 = lp.get(i - 2);
        lnom2.setText(p3.getNomP());
        lprix2.setText("" + p3.getPrix());
        lbonus2.setText("" + p3.getPtbonus());
        lquantite2.setText("" + p3.getQuantite());
        lcat2.setText("" + p3.getCategorie());

        /*-------------------------*/
        Produit p4 = lp.get(i - 3);
        lnom3.setText(p4.getNomP());
        lprix3.setText("" + p4.getPrix());
        lbonus3.setText("" + p4.getPtbonus());
        lquantite3.setText("" + p4.getQuantite());
        lcat3.setText("" + p4.getCategorie());
        /*-------------------------*/
        Produit p5 = lp.get(i - 4);
        lnom4.setText(p5.getNomP());
        lprix4.setText("" + p4.getPrix());
        lbonus4.setText("" + p5.getPtbonus());
        lquantite4.setText("" + p5.getQuantite());
        lcat4.setText("" + p5.getCategorie());
        /*-------------------------*/
        Produit p6 = lp.get(i - 5);
        lnom5.setText("" + p6.getNomP());
        lprix5.setText("" + p6.getPrix());
        lbonus5.setText("" + p6.getPtbonus());
        lquantite5.setText("" + p6.getQuantite());
        lcat5.setText("" + p6.getCategorie());
        /*-------------------------*/
        i -= 6;
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnextActionPerformed

        System.out.println(lp);
        Produit p1 = lp.get(i);
        lnom.setText(p1.getNomP());
        lprix.setText("" + p1.getPrix());
        lbonus.setText("" + p1.getPtbonus());
        lquantite.setText("" + p1.getQuantite());
        lcat.setText("" + p1.getCategorie());
        /*-------------------------*/
        Produit p2 = lp.get(i + 1);
        lnom1.setText(p2.getNomP());
        lprix1.setText("" + p2.getPrix());
        lbonus1.setText("" + p2.getPtbonus());
        lquantite1.setText("" + p2.getQuantite());
        lcat1.setText("" + p2.getCategorie());
        /*-------------------------*/
        Produit p3 = lp.get(i + 2);
        lnom2.setText(p3.getNomP());
        lprix2.setText("" + p3.getPrix());
        lbonus2.setText("" + p3.getPtbonus());
        lquantite2.setText("" + p3.getQuantite());
        lcat2.setText("" + p3.getCategorie());

        /*-------------------------*/
        Produit p4 = lp.get(i + 3);
        lnom3.setText(p4.getNomP());
        lprix3.setText("" + p4.getPrix());
        lbonus3.setText("" + p4.getPtbonus());
        lquantite3.setText("" + p4.getQuantite());
        lcat3.setText("" + p4.getCategorie());
        /*-------------------------*/
        Produit p5 = lp.get(i + 4);
        lnom4.setText(p5.getNomP());
        lprix4.setText("" + p4.getPrix());
        lbonus4.setText("" + p5.getPtbonus());
        lquantite4.setText("" + p5.getQuantite());
        lcat4.setText("" + p5.getCategorie());
        /*-------------------------*/
        Produit p6 = lp.get(i + 5);
        lnom5.setText(p6.getNomP());
        lprix5.setText("" + p6.getPrix());
        lbonus5.setText("" + p6.getPtbonus());
        lquantite5.setText("" + p6.getQuantite());
        lcat5.setText("" + p6.getCategorie());

        /*-------------------------*/
        i += 6;
    }//GEN-LAST:event_btnextActionPerformed

    private void bntRechercheSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRechercheSActionPerformed
        // TODO add your handling code here:
        ServiceDao sdao = new ServiceDao();
        tblRechercheS.setModel(new ServiceByCategorieModel());
        nomS = tfRechercheS.getText();
        if (rbNom.isSelected()) {
            sdao.findByName(nomS);
            tblRechercheS.setModel(new ServiceByNomModel());
        }
        if (rbCat.isSelected()) {
            sdao.findAllByCategorie(nomS);
            tblRechercheS.setModel(new ServiceByCategorieModel());
        }
        if (rbZone.isSelected()) {
            sdao.findByZone2(nomS);
            tblRechercheS.setModel(new ServiceByZoneModel());
        }

    }//GEN-LAST:event_bntRechercheSActionPerformed

    private void tfRechercheSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRechercheSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRechercheSActionPerformed

    private void rbNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNomActionPerformed
        // TODO add your handling code here:
        if (rbNom.isSelected()) {
            rbCat.setSelected(false);
        }
        rbZone.setSelected(false);

    }//GEN-LAST:event_rbNomActionPerformed

    private void rbCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCatActionPerformed
        // TODO add your handling code here:
        if (rbCat.isSelected()) {
            rbNom.setSelected(false);
        }
        rbZone.setSelected(false);
    }//GEN-LAST:event_rbCatActionPerformed

    private void rbZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbZoneActionPerformed
        // TODO add your handling code here:
        if (rbZone.isSelected()) {
            rbCat.setSelected(false);
        }
        rbNom.setSelected(false);
    }//GEN-LAST:event_rbZoneActionPerformed

    private void bntRechercheS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRechercheS1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntRechercheS1ActionPerformed

    private void tfRechercheS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRechercheS1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRechercheS1ActionPerformed

    private void rbNom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNom1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNom1ActionPerformed

    private void rbCat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCat1ActionPerformed

    private void rbZone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbZone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbZone1ActionPerformed

    private void btnConsulterProduitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsulterProduitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsulterProduitMouseClicked

    private void btnConsulterProduitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsulterProduitActionPerformed
        int i = tbProduits.getSelectedRow();
        TableModel model = tbProduits.getModel();
        Object l = tbProduits.getValueAt(i, 0);
        produit_id = (int) l;

        tbCommentairesProduits.setModel(new CommentPModel());
        tbCommentairesProduits.setVisible(true);
        tbCommentairesProduits.getColumnModel().getColumn(0).setMinWidth(0);
        tbCommentairesProduits.getColumnModel().getColumn(0).setMaxWidth(0);
        tbCommentairesProduits.getColumnModel().getColumn(0).setWidth(0);

        lNomProduit1.setText(model.getValueAt(i, 1).toString());
        lCategorie1.setText(model.getValueAt(i, 2).toString());
        lQuantite1.setText(model.getValueAt(i, 3).toString());
        lDescription1.setText(model.getValueAt(i, 4).toString());
        lPrix1.setText(model.getValueAt(i, 5).toString());
        lPointBonus1.setText(model.getValueAt(i, 6).toString());
        lZone1.setText(model.getValueAt(i, 7).toString());
        lTVA1.setText(model.getValueAt(i, 9).toString());
        lReduction1.setText(model.getValueAt(i, 10).toString());

        Produit p = pdao.findById(produit_id);

        offresProduitsPan.removeAll();
        offresProduitsPan.add(ConsultationPanel1);
        offresProduitsPan.repaint();
        offresProduitsPan.revalidate();
    }//GEN-LAST:event_btnConsulterProduitActionPerformed

    private void tblMesProduitsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMesProduitsMouseClicked
        int i = tblMesProduits.getSelectedRow();
        TableModel model = tblMesProduits.getModel();

        //tfId.setText(model.getValueAt(i, 0).toString());
        labelId.setText(model.getValueAt(i, 0).toString());
        tfNomP2.setText(model.getValueAt(i, 1).toString());
        cbCategorie2.setSelectedItem(tblMesProduits.getValueAt(i, 2));
        tfQuantite2.setText(model.getValueAt(i, 3).toString());
        taDescription2.setText(model.getValueAt(i, 4).toString());
        tfPrix2.setText(model.getValueAt(i, 5).toString());
        tfPointBonus2.setText(model.getValueAt(i, 6).toString());
        cbZone3.setSelectedItem(tblMesProduits.getValueAt(i, 7));
        tfTVA2.setText(model.getValueAt(i, 9).toString());
        tfReduction2.setText(model.getValueAt(i, 10).toString());


    }//GEN-LAST:event_tblMesProduitsMouseClicked

    private void tfNomP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomP2ActionPerformed

    private void tfPointBonus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPointBonus2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPointBonus2ActionPerformed

    private void bntConsulter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntConsulter1ActionPerformed
        int i = tblMesProduits.getSelectedRow();
        TableModel model = tblMesProduits.getModel();
        Object l = tblMesProduits.getValueAt(i, 0);
        produit_id = (int) l;
        System.out.println(tblMesProduits);

        lNomProduit.setText(model.getValueAt(i, 1).toString());
        lCategorie.setText(model.getValueAt(i, 2).toString());
        lQuantite.setText(model.getValueAt(i, 3).toString());
        lDescription.setText(model.getValueAt(i, 4).toString());
        lPrix.setText(model.getValueAt(i, 5).toString());
        lPointBonus.setText(model.getValueAt(i, 6).toString());
        lZone.setText(model.getValueAt(i, 7).toString());
        lTVA.setText(model.getValueAt(i, 9).toString());
        lReduction.setText(model.getValueAt(i, 10).toString());
//        

        Produit p = pdao.findById(produit_id);

        MesProduitsConsultationPanel.removeAll();
        MesProduitsConsultationPanel.add(ConsultationPanel);
        MesProduitsConsultationPanel.repaint();
        MesProduitsConsultationPanel.revalidate();
    }//GEN-LAST:event_bntConsulter1ActionPerformed

    private void btnSupprimer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimer1ActionPerformed
        int i = tblMesProduits.getSelectedRow();
        Object l = tblMesProduits.getValueAt(i, 0);

        ProduitDao pdao = new ProduitDao();

        int j = JOptionPane.showConfirmDialog(null, "la suppression est irréversible. Etes-vous sur de vouloir continuer?", "Veuillez confirmer votre choix", JOptionPane.YES_NO_OPTION);

        if (j == 0) {
            pdao.removeById((int) l);
            tblMesProduits.setModel(new ProduitClientModel());
            jScrollPane8.setViewportView(tblMesProduits);
            labelId.setText(null);
            tfNomP2.setText(null);
            tfPrix2.setText(null);
            tfQuantite2.setText(null);
            tfTVA2.setText(null);
            tfReduction2.setText(null);
            tfPointBonus2.setText(null);
            taDescription2.setText(null);

            cbZone3.setSelectedItem(null);
            cbCategorie2.setSelectedItem(null);

        }

    }//GEN-LAST:event_btnSupprimer1ActionPerformed

    private void btnModifierP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierP1ActionPerformed
        Produit p = new Produit();
        p.setId(Integer.parseInt(labelId.getText()));
        p.setPrix((float) Double.parseDouble(tfPrix2.getText()));
        p.setQuantite(Integer.parseInt(tfQuantite2.getText()));
        p.setTva((float) Double.parseDouble(tfTVA2.getText()));
        p.setReduction((float) Double.parseDouble(tfReduction2.getText()));
        p.setNomP(tfNomP2.getText());

        try {
            rsId = zdao.getZoneByName(cbZone3.getSelectedItem().toString());
            while (rsId.next()) {
                p.setZone(rsId.getInt(1));

            }//this.setResizable(false);
        } catch (SQLException ex) {
            Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rsIdC = cdao.getCategorieByName(cbCategorie2.getSelectedItem().toString());
            while (rsIdC.next()) {
                p.setCategorie(rsIdC.getInt(1));

            }//this.setResizable(false);
        } catch (SQLException ex) {
            Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.setPtbonus(Integer.parseInt(tfPointBonus2.getText()));
        p.setDescription(taDescription2.getText());

        LAlerte.setText(" ");

        if (!tfNomP2.getText().trim().equals("")) {
            pdao.update(p);
            tbProduits.setModel(new ProduitModel());
            tblMesProduits.setModel(new ProduitClientModel());
        } else {
            LAlerte.setText("Veuiller introduire le nom de votre produit");
        }
    }//GEN-LAST:event_btnModifierP1ActionPerformed

    private void p1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_p1MouseClicked

    private void btnBackPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackPActionPerformed
        MesProduitsConsultationPanel.removeAll();
        MesProduitsConsultationPanel.add(MesProduitsPanel1);
        MesProduitsConsultationPanel.repaint();
        MesProduitsConsultationPanel.revalidate();
    }//GEN-LAST:event_btnBackPActionPerformed

    private void btnBackP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackP1ActionPerformed
        offresProduitsPan.removeAll();
        offresProduitsPan.add(OffresProduitsTableauPanel);
        offresProduitsPan.repaint();
        offresProduitsPan.revalidate();
    }//GEN-LAST:event_btnBackP1ActionPerformed

    private void AjoutPanierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutPanierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AjoutPanierActionPerformed

    private void tfCommentPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCommentPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCommentPActionPerformed

    private void btnCommenterPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommenterPActionPerformed
        // TODO add your handling code here:
        Comment c = new Comment();
        Notification n = new Notification();
        NotificationDao ndao = new NotificationDao();

        c.setBody(tfCommentP.getText());
        java.util.Date date = new java.sql.Date(System.currentTimeMillis());
        c.setCreated_at(date);
        System.out.println("testServiceId" + AllForDealFrame.getProduit_id());
        c.setProduit_id(AllForDealFrame.getProduit_id());
        c.setUser_id(LoginForm.getUser_id());
        System.out.println(LoginForm.getUser_id());

        CommentDao pdao = new CommentDao();
        pdao.add(c);
        n.setId_produit(AllForDealFrame.getProduit_id());
        //n.setId_user(9);
        ndao.add(n);
        tbCommentairesProduits.setModel(new CommentPModel());
        tbCommentairesProduits.getColumnModel().getColumn(0).setMinWidth(0);
        tbCommentairesProduits.getColumnModel().getColumn(0).setMaxWidth(0);
        tbCommentairesProduits.getColumnModel().getColumn(0).setWidth(0);
        tfCommentP.setText("");
    }//GEN-LAST:event_btnCommenterPActionPerformed

    private void btnSupprimerCommentaire1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerCommentaire1ActionPerformed
        // TODO add your handling code here:
         Comment c = new Comment();
        CommentDao comm = new CommentDao();
        int ligneSelectionne = tbCommentairesProduits.getSelectedRow();
        Object l = tbCommentairesProduits.getValueAt(ligneSelectionne, 0);
        System.out.println(l);
        c = comm.findById((int) l);
        String s = (String) tbCommentairesProduits.getValueAt(ligneSelectionne, 3);
        System.out.println(s);
        if (LoginForm.getUser_id() == c.getUser_id()) {
            int i = JOptionPane.showConfirmDialog(null, "La suppression est irréversible. Êtes-vous sûr de vouloir continuer?",
                    "Veuillez confirmer votre choix",
                    JOptionPane.YES_NO_OPTION);

            if (i == 0) {
                comm.removeById((int) l);
                tbCommentairesProduits.setModel(new CommentPModel());
                tbCommentairesProduits.getColumnModel().getColumn(0).setMinWidth(0);
                tbCommentairesProduits.getColumnModel().getColumn(0).setMaxWidth(0);
                tbCommentairesProduits.getColumnModel().getColumn(0).setWidth(0);
            }
        } else {
            JOptionPane.showMessageDialog(ParentPanel, "Ce commentaire est ajouté par " + s + ". Vous ne pouvez pas le supprimer");
        }
    }//GEN-LAST:event_btnSupprimerCommentaire1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
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
            java.util.logging.Logger.getLogger(AllForDealFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllForDealFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllForDealFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllForDealFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    AllForDealFrame fa = new AllForDealFrame();
                    fa.setVisible(true);
                    //fa.setResizable(false);
                    fa.setSize(1200, 700);
                    //fa.setLocation(screenWidth/2 , screenHeight/2 );
                    tbCommentairesService.getColumnModel().getColumn(0).setMinWidth(0);
                    tbCommentairesService.getColumnModel().getColumn(0).setMaxWidth(0);
                    tbCommentairesService.getColumnModel().getColumn(0).setWidth(0);

                    tbProduits.getColumnModel().getColumn(0).setMinWidth(0);
                    tbProduits.getColumnModel().getColumn(0).setMaxWidth(0);
                    tbProduits.getColumnModel().getColumn(0).setWidth(0);

                    tblMesProduits.getColumnModel().getColumn(0).setMinWidth(0);
                    tblMesProduits.getColumnModel().getColumn(0).setMaxWidth(0);
                    tblMesProduits.getColumnModel().getColumn(0).setWidth(0);

                    tbMesMsgR.getColumnModel().getColumn(0).setMinWidth(0);
                    tbMesMsgR.getColumnModel().getColumn(0).setMaxWidth(0);
                    tbMesMsgR.getColumnModel().getColumn(0).setWidth(0);

                    tbMsgEnvs.getColumnModel().getColumn(0).setMinWidth(0);
                    tbMsgEnvs.getColumnModel().getColumn(0).setMaxWidth(0);
                    tbMsgEnvs.getColumnModel().getColumn(0).setWidth(0);

                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (java.text.ParseException ex) {
                    Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    private void loadAllVille() {
        try {
            ResultSet res = sdao.getAllVille();

            while (res.next()) {

                cbZone.addItem(res.getString(1));
                cbZone3.addItem(res.getString(1));
                cbZone2.addItem(res.getString(1));
                cbZoneX.addItem(res.getString(1));
                //cbZone4.addItem(res.getString(1));

                // System.out.println(res.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAllCategories() {
        try {
            ResultSet res = cdao.getCategories();

            while (res.next()) {

                cbCategorie.addItem(res.getString(1));
                cbCategorie2.addItem(res.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAllCollection() {
        try {
            ResultSet res = coldao.getCollection();

            while (res.next()) {

                cbCat.addItem(res.getString(1));
                cbCat1.addItem(res.getString(1));
                cbCat2.addItem(res.getString(1));
//                cbCat4.addItem(res.getString(1));

                // System.out.println(res.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllForDealFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private void loadMap() {
//
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AccueilPanel2;
    private javax.swing.JButton AjoutPanier;
    private javax.swing.JPanel AjoutProduitPanel;
    private javax.swing.JButton AjouterProduitPanier;
    private javax.swing.JPanel ConsultationPanel;
    private javax.swing.JPanel ConsultationPanel1;
    private javax.swing.JPanel GridProduitsPanel;
    private javax.swing.JTextField LAlerte;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JPanel MesProduitsConsultationPanel;
    private javax.swing.JPanel MesProduitsPanel1;
    private javax.swing.JPanel MessagesPanel;
    private javax.swing.JPanel NotificationPanel;
    private javax.swing.JPanel OffresProduitsTableauPanel;
    private javax.swing.JPanel PanelService;
    private javax.swing.JPanel PanierReclamation;
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JPanel ParentPanel1;
    private javax.swing.JPanel ParentPanel2;
    private javax.swing.JPanel ProduitPanel;
    private javax.swing.JPanel RechercheProduitPanel;
    private javax.swing.JPanel ReclamationPanel;
    private javax.swing.JLabel accueillabel;
    private javax.swing.JButton bntConsulter1;
    private javax.swing.JButton bntMap;
    private javax.swing.JButton bntRechercheS;
    private javax.swing.JButton bntRechercheS1;
    private javax.swing.JButton bntSupprimer;
    private javax.swing.JButton btnAccueil;
    private javax.swing.JButton btnAjoutS;
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnBackP;
    private javax.swing.JButton btnBackP1;
    private javax.swing.JButton btnBackS;
    private javax.swing.JButton btnBackS2;
    private javax.swing.JButton btnCommenter1;
    private javax.swing.JButton btnCommenterP;
    private javax.swing.JButton btnConsulterProduit;
    private javax.swing.JButton btnConsulterS;
    private javax.swing.JButton btnConsulterS1;
    private javax.swing.JButton btnEnvMsg;
    private javax.swing.JButton btnEnvoyerRec;
    private javax.swing.JButton btnMap;
    private javax.swing.JButton btnMessage;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnModifierP1;
    private javax.swing.JButton btnNotif;
    private javax.swing.JButton btnPanier;
    private javax.swing.JButton btnParcourir;
    private javax.swing.JButton btnPartager;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay2;
    private javax.swing.JButton btnProduits;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnReclam;
    private javax.swing.JButton btnServices;
    private javax.swing.JButton btnSonOff;
    private javax.swing.JButton btnSonOn;
    private javax.swing.JButton btnSupNotification;
    private javax.swing.JButton btnSupprimer1;
    private javax.swing.JButton btnSupprimerCommentaire;
    private javax.swing.JButton btnSupprimerCommentaire1;
    private javax.swing.JButton btnTestMsg;
    private javax.swing.JButton btnTestMsg2;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnext;
    private javax.swing.JComboBox cbCat;
    private javax.swing.JComboBox cbCat1;
    private javax.swing.JComboBox cbCat2;
    private javax.swing.JComboBox cbCategorie;
    private javax.swing.JComboBox cbCategorie2;
    private javax.swing.JComboBox cbEtat;
    private javax.swing.JComboBox cbEtat1;
    private javax.swing.JComboBox cbZone;
    private javax.swing.JComboBox cbZone2;
    private javax.swing.JComboBox cbZone3;
    private javax.swing.JComboBox cbZone5;
    private javax.swing.JComboBox cbZoneX;
    private javax.swing.JLabel ecrireMsgLabel;
    private javax.swing.JLabel erreur1;
    private javax.swing.JLabel erreur2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCommentMesServ;
    private javax.swing.JLabel lCategorie;
    private javax.swing.JLabel lCategorie1;
    private javax.swing.JLabel lCategorieServiceAll;
    private javax.swing.JLabel lDescription;
    private javax.swing.JLabel lDescription1;
    private javax.swing.JLabel lDescriptionSAll;
    private javax.swing.JLabel lEtatSAll;
    private javax.swing.JLabel lMsg;
    private javax.swing.JLabel lMsg1;
    private javax.swing.JLabel lNomProduit;
    private javax.swing.JLabel lNomProduit1;
    private javax.swing.JLabel lNomSAll;
    private javax.swing.JLabel lPointBonus;
    private javax.swing.JLabel lPointBonus1;
    private javax.swing.JLabel lPrix;
    private javax.swing.JLabel lPrix1;
    private javax.swing.JLabel lQuantite;
    private javax.swing.JLabel lQuantite1;
    private javax.swing.JLabel lReduction;
    private javax.swing.JLabel lReduction1;
    private javax.swing.JLabel lTVA;
    private javax.swing.JLabel lTVA1;
    private javax.swing.JLabel lTitreRechercheS;
    private javax.swing.JLabel lTitreRechercheS1;
    private javax.swing.JLabel lZone;
    private javax.swing.JLabel lZone1;
    private javax.swing.JLabel lZoneSAll;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelId1;
    private javax.swing.JLabel labelId2;
    private javax.swing.JLabel labelNotification;
    private javax.swing.JLabel lbonus;
    private javax.swing.JLabel lbonus1;
    private javax.swing.JLabel lbonus2;
    private javax.swing.JLabel lbonus3;
    private javax.swing.JLabel lbonus4;
    private javax.swing.JLabel lbonus5;
    private javax.swing.JLabel lcat;
    private javax.swing.JLabel lcat1;
    private javax.swing.JLabel lcat2;
    private javax.swing.JLabel lcat3;
    private javax.swing.JLabel lcat4;
    private javax.swing.JLabel lcat5;
    private javax.swing.JLabel lerror;
    private javax.swing.JLabel limage;
    private javax.swing.JLabel limage1;
    private javax.swing.JLabel limage2;
    private javax.swing.JLabel limage3;
    private javax.swing.JLabel limage4;
    private javax.swing.JLabel limage5;
    private javax.swing.JLabel lnom;
    private javax.swing.JLabel lnom1;
    private javax.swing.JLabel lnom2;
    private javax.swing.JLabel lnom3;
    private javax.swing.JLabel lnom4;
    private javax.swing.JLabel lnom5;
    private javax.swing.JLabel lprix;
    private javax.swing.JLabel lprix1;
    private javax.swing.JLabel lprix2;
    private javax.swing.JLabel lprix3;
    private javax.swing.JLabel lprix4;
    private javax.swing.JLabel lprix5;
    private javax.swing.JLabel lquantite;
    private javax.swing.JLabel lquantite1;
    private javax.swing.JLabel lquantite2;
    private javax.swing.JLabel lquantite3;
    private javax.swing.JLabel lquantite4;
    private javax.swing.JLabel lquantite5;
    private javax.swing.JPanel msgEnvoye;
    private javax.swing.JLabel msgEnvoyesLabel;
    private javax.swing.JPanel msgR;
    private javax.swing.JPanel msgRediger;
    private javax.swing.JPanel offresProduitsPan;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    private javax.swing.JPanel p5;
    private javax.swing.JPanel p6;
    private javax.swing.JPanel pAjoutS;
    private javax.swing.JPanel pAllServices;
    private javax.swing.JPanel pConsulterS;
    private javax.swing.JPanel pConsulterS2;
    private javax.swing.JPanel pDetailS;
    private javax.swing.JPanel pMesServices;
    private javax.swing.JPanel pRechercheS;
    private javax.swing.JPanel pShowMap;
    private javax.swing.JPanel pShowMap1;
    private javax.swing.JLabel produitsLabel;
    private javax.swing.JRadioButton rbCat;
    private javax.swing.JRadioButton rbCat1;
    private javax.swing.JRadioButton rbNom;
    private javax.swing.JRadioButton rbNom1;
    private javax.swing.JRadioButton rbZone;
    private javax.swing.JRadioButton rbZone1;
    private javax.swing.JLabel reclamationLabel;
    private javax.swing.JLabel servicesLabel;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextArea taDescription2;
    private javax.swing.JTextArea taDescriptionRec;
    private javax.swing.JTextArea taMsg;
    private javax.swing.JTable tbCommentairesProduits;
    private static javax.swing.JTable tbCommentairesService;
    private static javax.swing.JTable tbMesMsgR;
    private static javax.swing.JTable tbMsgEnvs;
    private javax.swing.JTable tbNotification;
    private static javax.swing.JTable tbProduits;
    private javax.swing.JTable tblAllServices;
    private static javax.swing.JTable tblMesProduits;
    private javax.swing.JTable tblMesServices;
    private javax.swing.JTable tblRechercheS;
    private javax.swing.JTable tblRechercheS1;
    private javax.swing.JTable tblService;
    private javax.swing.JTextField tfComment;
    private javax.swing.JTextField tfCommentP;
    private javax.swing.JTextField tfDescription;
    private javax.swing.JTextField tfDescription1;
    private javax.swing.JTextField tfDescription2;
    private javax.swing.JTextField tfDest;
    private javax.swing.JTextField tfNomP;
    private javax.swing.JTextField tfNomP2;
    private javax.swing.JTextField tfNomS;
    private javax.swing.JTextField tfNomService;
    private javax.swing.JTextField tfNomService1;
    private javax.swing.JTextField tfObjet;
    private javax.swing.JTextField tfPhoto;
    private javax.swing.JTextField tfPointBonus;
    private javax.swing.JTextField tfPointBonus2;
    private javax.swing.JTextField tfPrix;
    private javax.swing.JTextField tfPrix2;
    private javax.swing.JTextField tfQuantite;
    private javax.swing.JTextField tfQuantite2;
    private javax.swing.JTextField tfRechercheS;
    private javax.swing.JTextField tfRechercheS1;
    private javax.swing.JTextField tfReduction;
    private javax.swing.JTextField tfReduction2;
    private javax.swing.JTextField tfSujetRec;
    private javax.swing.JTextField tfTVA;
    private javax.swing.JTextField tfTVA2;
    private javax.swing.JTabbedPane tpService;
    private javax.swing.JInternalFrame videoPlayer;
    // End of variables declaration//GEN-END:variables
}
