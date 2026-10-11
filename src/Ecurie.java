import java.util.ArrayList;

public class Ecurie {
    private String nom ;
    private String sponsor ;
    
    private ArrayList<Pilote> listePilotes = new ArrayList<Pilote>();
    private ArrayList<Formule> listeFormules = new ArrayList<Formule>();

    public Ecurie(String nom , String sponsor){
        this.nom = nom;
        this.sponsor = sponsor;
    }

    //ajout getter pour le json
    public ArrayList<Pilote> getListePilotes() {
        return this.listePilotes;
    }
    public ArrayList<Formule> getListeFormules() {
        return this.listeFormules;
    }

    

    public void ajouterPilote(Pilote p) {
        if (this.listePilotes.size() < 4) {
            this.listePilotes.add(p);
            System.out.println(p.getNom() + " a rejoint l'ecurie !");
        } else {
            System.out.println("Erreur : L'ecurie est deja complete (4 pilotes max)");
        }
    }

    public void ajouterVoiture(Formule f){
        if (this.listeFormules.size()<2){
            this.listeFormules.add(f);
            System.out.println("Le vehicule est ajoute !");
        } else {
            System.out.println("Erreur : L'ecurie est deja complete (2 vehicule max)");
        }
    }

    public String toString(){
        return "Ecurie : " + nom + " de Sponsor : " + sponsor;
    }
}