import java.awt.*;

import javax.swing.*;


public class IHM extends JFrame {
    public IHM(GrandPrix gp) {
        this.setTitle("Affichage du Grand Prix");
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container conteneur = this.getContentPane();
        conteneur.setLayout(new BorderLayout());

        JPanel panneauNord = new JPanel(new GridLayout(2, 1));
        
        JLabel labelGP = new JLabel(gp.nom + " (" + gp.date + ")");
        JLabel labelCircuit = new JLabel(gp.getCircuit().toString());
        
        panneauNord.add(labelGP);
        panneauNord.add(labelCircuit);
        conteneur.add(BorderLayout.NORTH, panneauNord);


        JPanel panneauCentre = new JPanel(new GridLayout(1, 3));

        //col1
        JTextArea textePilotes = new JTextArea();
        textePilotes.setEditable(false);
        String contenuPilotes = "=== ÉCURIES & PILOTES ===\n\n";
        for (Ecurie e : gp.getLesEcuries()) {
            contenuPilotes += e.toString() + "\n";
            for (Pilote p : e.getListePilotes()) {
                contenuPilotes += "  -> " + p.getNom() + "\n" + p.toString() + "\n\n";
            }
            contenuPilotes += "-------------------------\n";
        }
        textePilotes.setText(contenuPilotes);
        panneauCentre.add(new JScrollPane(textePilotes));

        //col2 formule
        JTextArea texteFormules = new JTextArea();
        texteFormules.setEditable(false);
        String contenuFormules = "=== FORMULES INSCRITES ===\n\n";
        for (Ecurie e : gp.getLesEcuries()) {
            contenuFormules += "[" + e.toString() + "]\n";
            for (Formule f : e.getListeFormules()) {
                contenuFormules += f.toString() + "\n\n";
            }
            contenuFormules += "-------------------------\n";
        }
        texteFormules.setText(contenuFormules);
        panneauCentre.add(new JScrollPane(texteFormules));

        //col3 assistance
        JTextArea texteAssistance = new JTextArea();
        texteAssistance.setEditable(false);
        String contenuAssistance = "=== ASSISTANCE & SÉCURITÉ ===\n\n";
        for (VehiculeAssistance va : gp.getListeAssistance()) {
            contenuAssistance += va.toString() + "\n\n-------------------------\n";
        }
        texteAssistance.setText(contenuAssistance);
        panneauCentre.add(new JScrollPane(texteAssistance));

        conteneur.add(BorderLayout.CENTER, panneauCentre);


        JPanel panneauSud = new JPanel(new FlowLayout());
        
        JLabel resumeEcuries = new JLabel("Écuries inscrites : " + gp.getLesEcuries().size());
        JLabel separateur = new JLabel(" | ");
        JLabel resumeAssistance = new JLabel("Véhicules d'assistance : " + gp.getListeAssistance().size());
        
        panneauSud.add(resumeEcuries);
        panneauSud.add(separateur);
        panneauSud.add(resumeAssistance);
        
        conteneur.add(BorderLayout.SOUTH, panneauSud);

        this.setVisible(true);
    }
}