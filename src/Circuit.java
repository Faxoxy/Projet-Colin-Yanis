public class Circuit {
    private String nom;
    private String lieu;
    private double longueurPiste;

    public Circuit (String nom, String lieu, double longueurPiste){
        this.nom = nom;
        this.lieu = lieu;
        this.longueurPiste = longueurPiste;
    }

    public double getLongueur(){
        return this.longueurPiste;
    }

    public String toString(){
        return "Nom du circuit : " + nom + " | Nom du lieu : " + lieu + " | Longueur de la piste : " + longueurPiste; 
    }
    
}
