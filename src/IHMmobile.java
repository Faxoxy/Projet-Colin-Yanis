import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IHMmobile extends JFrame implements ActionListener {

    private GrandPrix gp;
    private ArrayList<Pilote> tousLesPilotes = new ArrayList<>();

    //menu principal
    private JTabbedPane onglets;
    private JMenuItem menuPilotes, menuEcuries, menuAssistance, menuInfosCircuit;

    //onglet pilotes
    private JComboBox<String> comboPilotes;
    private JLabel lblNom, lblAge, lblNumero, lblReaction, lblEcuriePilote;
    private JButton btnPopupPilote;

    //onglet ecuries
    private JList<String> listeGraphiqueEcuries;
    private JTextArea zoneDetailsEcurie;

    public IHMmobile(GrandPrix gp) {
        this.gp = gp;

        this.setTitle("F1 Pocket - " + gp.nom);
        this.setSize(380, 680);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //ferme uniquement la fenêtre mobile

        Container conteneur = this.getContentPane();
        conteneur.setLayout(new BorderLayout());

      
        //barre menue en haut
        JMenuBar barreMenu = new JMenuBar();
        JMenu menuNav = new JMenu("= Menu Navigation");

        menuPilotes = new JMenuItem("1. Fiches Pilotes");
        menuEcuries = new JMenuItem("2. Écuries & Monoplaces");
        menuAssistance = new JMenuItem("3. Sécurité & Assistance");
        menuInfosCircuit = new JMenuItem("i. Infos du Circuit");

        menuPilotes.addActionListener(this);
        menuEcuries.addActionListener(this);
        menuAssistance.addActionListener(this);
        menuInfosCircuit.addActionListener(this);

        menuNav.add(menuPilotes);
        menuNav.add(menuEcuries);
        menuNav.add(menuAssistance);
        menuNav.addSeparator(); //barre
        menuNav.add(menuInfosCircuit);
        barreMenu.add(menuNav);
        this.setJMenuBar(barreMenu);


        //en tete
        JPanel bandeauHaut = new JPanel(new GridLayout(2, 1));
        bandeauHaut.setBackground(new Color(220, 38, 38)); //rouge F1
        
        JLabel titreMobile = new JLabel(gp.nom, SwingConstants.CENTER);
        titreMobile.setForeground(Color.WHITE);
        titreMobile.setFont(new Font("Arial", Font.PLAIN, 16));
        
        JLabel dateMobile = new JLabel(gp.date, SwingConstants.CENTER);
        dateMobile.setForeground(Color.WHITE);
        
        bandeauHaut.add(titreMobile);
        bandeauHaut.add(dateMobile);
        conteneur.add(BorderLayout.NORTH, bandeauHaut);

        //ligne onglzts
        onglets = new JTabbedPane();
        onglets.addTab("Pilotes", creerOngletPilotes());
        onglets.addTab("Écuries", creerOngletEcuries());
        onglets.addTab("Assistance", creerOngletAssistance());

        conteneur.add(BorderLayout.CENTER, onglets);

        this.setVisible(true);
    }


    //onglet 1 def
    private JPanel creerOngletPilotes() {
        JPanel panneau = new JPanel(new BorderLayout(10, 10));

        //menu deroul
        JPanel hautSelection = new JPanel(new GridLayout(2, 1));
        hautSelection.add(new JLabel(" Sélectionner un pilote :", SwingConstants.LEFT));

        comboPilotes = new JComboBox<>();
        for (Ecurie e : gp.getLesEcuries()) {
            for (Pilote p : e.getListePilotes()) {
                tousLesPilotes.add(p);
                comboPilotes.addItem(p.getNom());
            }
        }
        comboPilotes.addActionListener(this);
        hautSelection.add(comboPilotes);
        panneau.add(BorderLayout.NORTH, hautSelection);

        JPanel cartePilote = new JPanel(new GridLayout(5, 1));
        cartePilote.setBorder(BorderFactory.createTitledBorder("Statistiques du Pilote"));

        lblNom = new JLabel();
        lblEcuriePilote = new JLabel();
        lblAge = new JLabel();
        lblNumero = new JLabel();
        lblReaction = new JLabel();

        Font policeStats = new Font("Arial", Font.PLAIN, 14); //pas gras ni italique car bug ecurie import
        lblNom.setFont(policeStats);
        lblAge.setFont(policeStats);
        lblNumero.setFont(policeStats);
        lblReaction.setFont(policeStats);

        cartePilote.add(lblNom);
        cartePilote.add(lblEcuriePilote);
        cartePilote.add(lblAge);
        cartePilote.add(lblNumero);
        cartePilote.add(lblReaction);
        panneau.add(BorderLayout.CENTER, cartePilote);


        //bouton bas boite de dialogue
        btnPopupPilote = new JButton("Voir Fiche Complète + Voiture");
        btnPopupPilote.addActionListener(this);
        panneau.add(BorderLayout.SOUTH, btnPopupPilote);

        //init affichafge 1er pilote
        if (!tousLesPilotes.isEmpty()) {
            mettreAJourFichePilote(0);
        }
        return panneau;
    }


    //onglet 2 navi ecurie
    private JPanel creerOngletEcuries() {
        JPanel panneau = new JPanel(new BorderLayout(5, 5));

        DefaultListModel<String> modeleEcuries = new DefaultListModel<>();
        for (Ecurie e : gp.getLesEcuries()) {
            modeleEcuries.addElement(e.toString());
        }

        listeGraphiqueEcuries = new JList<>(modeleEcuries);
        JScrollPane scrollListe = new JScrollPane(listeGraphiqueEcuries);
        scrollListe.setPreferredSize(new Dimension(350, 100));
        scrollListe.setBorder(BorderFactory.createTitledBorder("Touchez une écurie :"));

        zoneDetailsEcurie = new JTextArea("Sélectionnez une écurie ci-dessus pour voir ses monoplaces et ses pilotes.");

        listeGraphiqueEcuries.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = listeGraphiqueEcuries.getSelectedIndex();
                if (index >= 0) {
                    Ecurie ec = gp.getLesEcuries().get(index);
                    String texte = "=== " + ec.toString() + " ===\n\n";
                    texte += "--- PILOTES (" + ec.getListePilotes().size() + "/4) ---\n";
                    for (Pilote p : ec.getListePilotes()) {
                        texte += "• " + p.getNom() + " (" + p.age + " ans)\n";
                    }
                    texte += "\n--- MONOPLACES (" + ec.getListeFormules().size() + "/2) ---\n";
                    for (Formule f : ec.getListeFormules()) {
                        texte += f.toString() + "\n\n";
                    }
                    zoneDetailsEcurie.setText(texte);
                }
            }
        });

        panneau.add(BorderLayout.NORTH, scrollListe);
        panneau.add(BorderLayout.CENTER, new JScrollPane(zoneDetailsEcurie));
        return panneau;
    }

    //onglet 3 navi assistance 
    private JPanel creerOngletAssistance() {
        JPanel panneau = new JPanel(new BorderLayout());
        JTextArea texteAssistance = new JTextArea();
        texteAssistance.setEditable(false);

        String contenu = "=== VÉHICULES D'INTERVENTION ===\n\n";
        for (VehiculeAssistance va : gp.getListeAssistance()) {
            contenu += va.toString() + "\n\n----------------------------\n\n";
        }
        texteAssistance.setText(contenu);

        panneau.add(BorderLayout.CENTER, new JScrollPane(texteAssistance));
        return panneau;
    }


    private void mettreAJourFichePilote(int index) {
        Pilote p = tousLesPilotes.get(index);

        //to string pour info pilote
        String[] lignes = p.toString().split("\n");
        String numCourse = (lignes.length > 4) ? lignes[4].replace("Numero Course :", "").trim() : "?";
        String tpsReaction = (lignes.length > 5) ? lignes[5].replace("Temps de reaction :", "").trim() : "?";

        String nomEcurie = "Indépendant";
        for (Ecurie e : gp.getLesEcuries()) {
            if (e.getListePilotes().contains(p)) {
                nomEcurie = e.toString();
            }
        }

        lblNom.setText("Nom complet : " + p.getNom());
        lblEcuriePilote.setText(nomEcurie);
        lblAge.setText("Âge : " + p.age + " ans");
        lblNumero.setText("Numéro de course : N°" + numCourse);
        lblReaction.setText("Temps de réaction : " + tpsReaction + " s");
    }

    //GESTIOON NAV
    @Override
    public void actionPerformed(ActionEvent e) {
        //chgt pilote menu deroul
        if (e.getSource() == comboPilotes) {
            int index = comboPilotes.getSelectedIndex();
            if (index >= 0) {
                mettreAJourFichePilote(index);
            }
        }
        //plus d'info pilote JOptionPanne boite de dialogue
        else if (e.getSource() == btnPopupPilote) {
            int index = comboPilotes.getSelectedIndex();
            if (index >= 0) {
                Pilote p = tousLesPilotes.get(index);
                JOptionPane.showMessageDialog(this, p.toString(), "Fiche Officielle : " + p.getNom(), JOptionPane.PLAIN_MESSAGE);
            }
        }
        //navigation barre de menu en haut JMenuItem
        else if (e.getSource() == menuPilotes) {
            onglets.setSelectedIndex(0);
        } else if (e.getSource() == menuEcuries) {
            onglets.setSelectedIndex(1);
        } else if (e.getSource() == menuAssistance) {
            onglets.setSelectedIndex(2);
        } else if (e.getSource() == menuInfosCircuit) {
            JOptionPane.showMessageDialog(this, gp.getCircuit().toString(), "Détails du Circuit", JOptionPane.PLAIN_MESSAGE);
        }
    }
}