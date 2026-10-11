import java.util.ArrayList;

public class GrandPrix {
    protected String nom;
    protected String date;
    protected Circuit circuit;
    
    private ArrayList<Ecurie> lesEcuries = new ArrayList<Ecurie>();
    private ArrayList<VehiculeAssistance> listeAssistance = new ArrayList<VehiculeAssistance>();

    public GrandPrix(String nom, String date, Circuit circuit){
        this.nom = nom;
        this.date = date;
        this.circuit = circuit;
    }


    //ajout getter pour le json
    public Circuit getCircuit() {
        return this.circuit;
    }
    public ArrayList<Ecurie> getLesEcuries() {
        return this.lesEcuries;
    }
    public ArrayList<VehiculeAssistance> getListeAssistance() {
        return this.listeAssistance;
    }

    public String toString() {
        return "Grand Prix : " + this.nom + " | Date : " + this.date + 
               "\n\t -> " + this.circuit + 
               "\n\t -> Écuries inscrites : " + this.lesEcuries.size() + 
               " | Véhicules d'assistance : " + this.listeAssistance.size();
    }

}
