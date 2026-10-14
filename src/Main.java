//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        ///*
        System.out.println("========== CHARGEMENT DU GRAND PRIX DEPUIS JSON =========="); // Mais qui est JSON ??
        
        Gson gson = new Gson();
        
        try (Reader lecteur = new FileReader("data/grand_prix.json")) {
            GrandPrix gpMonaco = gson.fromJson(lecteur, GrandPrix.class);
            
            IHM fenetre1 = new IHM(gpMonaco);
            fenetre1.setVisible(true);

            IHMmobile fenetre2 = new IHMmobile(gpMonaco);
            fenetre2.setVisible(true);

            System.out.println(gpMonaco);
            
            System.out.println("\n========== 1. DÉTAIL DU CIRCUIT ==========");
            System.out.println(gpMonaco.getCircuit());
            
            System.out.println("\n========== 2. DÉTAIL DES ÉCURIES (Pilotes et Véhicules) ==========");
            for (Ecurie ecurie : gpMonaco.getLesEcuries()) {
                System.out.println(ecurie);
                
                for (Pilote p : ecurie.getListePilotes()) { //equivalent : for (int i = 0; i < ecurie.getListeFormules().size(); i++)
                    p.afficherInfos(); 
                }
                
                for (Formule f : ecurie.getListeFormules()) {
                    System.out.println(f);
                }
            }
            
            System.out.println("\n========== 3. VÉHICULES D'ASSISTANCE ==========");
            for (VehiculeAssistance va : gpMonaco.getListeAssistance()) {
                System.out.println(va);
            }
            
        } catch (Exception e) {
            System.out.println("Erreur : Impossible de charger le fichier JSON.");
            e.printStackTrace();
        }
        //*/

        /*
        System.out.println("========== 1. TEST DU CIRCUIT ==========");
        Circuit monaco = new Circuit("Circuit de Monaco", "Monte Carlo", 3.337);
        System.out.println(monaco); 

        System.out.println("\n========== 2. TEST DES PERSONNES (Héritage) ==========");
        Pilote leclerc = new Pilote("Leclerc", "Charles", 26, 16, 0.2);
        Pilote sainz = new Pilote("Sainz", "Carlos", 29, 55, 0.22);
        Pilote bearman = new Pilote("Bearman", "Oliver", 18, 38, 0.25);
        Pilote giovinazzi = new Pilote("Giovinazzi", "Antonio", 30, 99, 0.24);
        Pilote piloteEnTrop = new Pilote("Intrus", "Trop", 20, 0, 0.3); // Pour tester le blocage

        leclerc.afficherInfos(); 
        leclerc.piloter();

        System.out.println("\n========== 3. TEST DES VÉHICULES ==========");
        Formule f1Leclerc = new Formule("Ferrari SF-24", 798, 350.0, "Tendre", leclerc);
        Formule f1Sainz = new Formule("Ferrari SF-24", 798, 350.0, "Medium", sainz);
        Formule f1EnTrop = new Formule("Ferrari SF-24", 798, 350.0, "Dur", bearman);

        f1Leclerc.demarrer();
        System.out.println(f1Leclerc); 
    
        System.out.println("\n========== 4. TEST DE L'ÉCURIE & DES LIMITES ==========");
        Ecurie ferrari = new Ecurie("Scuderia Ferrari", "HP");
        
        ferrari.ajouterPilote(leclerc);
        ferrari.ajouterPilote(sainz);
        ferrari.ajouterPilote(bearman);
        ferrari.ajouterPilote(giovinazzi);
        ferrari.ajouterPilote(piloteEnTrop);

        ferrari.ajouterVoiture(f1Leclerc);
        ferrari.ajouterVoiture(f1Sainz);
        ferrari.ajouterVoiture(f1EnTrop);

        System.out.println(ferrari);

        System.out.println("\n========== 5. TEST DE L'ASSISTANCE ==========");
        Technicien mecano = new Technicien("Bono", "Peter", 45, "Chef Mécanicien");
        VehiculeAssistance safetyCar = new VehiculeAssistance("Aston Martin Vantage", 1600, 310.0, "Safety Car", false, mecano);
        
        mecano.intervenir();
        safetyCar.changerStatut();
        System.out.println(safetyCar);
        
        System.out.println("\n========== 6. TEST DU GRAND PRIX ==========");
        GrandPrix gpMonaco = new GrandPrix("Grand Prix de Monaco", "24 Mai 2026", monaco);
        System.out.println(gpMonaco);
        System.out.println("Le Grand Prix a bien été créé !");

        */
        /*

        System.out.println("\n========== 7. TEST DU CHARGEMENT CSV ==========");

        ArrayList<Pilote> pilotesDuFichier = new ArrayList<>(); //list stock pilotes

        String cheminFichier = "data/pilotes.csv"; 
        String ligne;

        try {
            BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichier));
            
            while ((ligne = lecteur.readLine()) != null) { //ligne par ligne jusqu'a vide
                
                String[] donnees = ligne.split(";"); //SUREMENT ;
                
                String nom = donnees[0]; //on recup les data dans l'ordre du contrucrteur pilote
                String prenom = donnees[1];
                int age = Integer.parseInt(donnees[2]); //convertion textee du csv en entier java
                int numero = Integer.parseInt(donnees[3]);
                double tempsReaction = Double.parseDouble(donnees[4]); //pareil en double
                
                Pilote nouveauPilote = new Pilote(nom, prenom, age, numero, tempsReaction);
                pilotesDuFichier.add(nouveauPilote);
            }
            lecteur.close();
            System.out.println("Fichier charge avec succes ! " + pilotesDuFichier.size() + " pilotes trouves");
            
            for (Pilote p : pilotesDuFichier) { //on affiche les pilotes cree automatiquement
                System.out.println(p);
            }
            
        } catch (IOException e) {
            System.out.println("Erreur : Impossible de lire le fichier. Verifie le chemin !");
            e.printStackTrace();
        }

        */

    }
}