public class Main {
    public static void main(String[] args) {
        System.out.println("HelloWorld");
        
        System.out.println("========== 1. TEST DU CIRCUIT ==========");
        Circuit monaco = new Circuit("Circuit de Monaco", "Monte Carlo", 3.337);
        System.out.println(monaco); 

        System.out.println("\n========== 2. TEST DES PERSONNES (Héritage) ==========");
        Pilote leclerc = new Pilote("Leclerc", "Charles", 26, 16, 0.2);
        Pilote sainz = new Pilote("Sainz", "Carlos", 29, 55, 0.22);
        Pilote bearman = new Pilote("Bearman", "Oliver", 18, 38, 0.25);
        Pilote giovinazzi = new Pilote("Giovinazzi", "Antonio", 30, 99, 0.24);
        Pilote piloteEnTrop = new Pilote("Intrus", "Trop", 20, 0, 0.3); // Pour tester le blocage

        // On teste les méthodes de Personne et de Pilote
        leclerc.afficherInfos(); 
        leclerc.piloter();

        System.out.println("\n========== 3. TEST DES VÉHICULES ==========");
        Formule f1Leclerc = new Formule("Ferrari SF-24", 798, 350.0, "Tendre", leclerc);
        Formule f1Sainz = new Formule("Ferrari SF-24", 798, 350.0, "Medium", sainz);
        Formule f1EnTrop = new Formule("Ferrari SF-24", 798, 350.0, "Dur", bearman);

        // On teste les méthodes de la classe mère Vehicule
        f1Leclerc.demarrer();
        System.out.println(f1Leclerc); 
    
        System.out.println("\n========== 4. TEST DE L'ÉCURIE & DES LIMITES ==========");
        Ecurie ferrari = new Ecurie("Scuderia Ferrari", "HP");
        
        // Ajout des pilotes (on en met 5 pour forcer l'erreur des 4 max)
        ferrari.ajouterPilote(leclerc);
        ferrari.ajouterPilote(sainz);
        ferrari.ajouterPilote(bearman);
        ferrari.ajouterPilote(giovinazzi);
        ferrari.ajouterPilote(piloteEnTrop); // Ceci doit déclencher votre "Erreur : L'ecurie est deja complete"

        // Ajout des voitures (on en met 3 pour forcer l'erreur des 2 max)
        ferrari.ajouterVoiture(f1Leclerc);
        ferrari.ajouterVoiture(f1Sainz);
        ferrari.ajouterVoiture(f1EnTrop); // Ceci doit déclencher votre erreur 

        System.out.println(ferrari);

        System.out.println("\n========== 5. TEST DE L'ASSISTANCE ==========");
        Technicien mecano = new Technicien("Bono", "Peter", 45, "Chef Mécanicien");
        VehiculeAssistance safetyCar = new VehiculeAssistance("Aston Martin Vantage", 1600, 310.0, "Safety Car", false, mecano);
        
        mecano.intervenir();
        safetyCar.changerStatut(); // On passe en intervention
        System.out.println(safetyCar);
        
        System.out.println("\n========== 6. TEST DU GRAND PRIX ==========");
        GrandPrix gpMonaco = new GrandPrix("Grand Prix de Monaco", "24 Mai 2026", monaco);
        System.out.println(gpMonaco);
        System.out.println("Le Grand Prix a bien été créé !");
    }
}