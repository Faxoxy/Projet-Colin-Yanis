public class VehiculeAssistance extends Vehicule {
    private String typeAssistance ;
    private boolean enIntervention ;
    private Technicien technicien ;
    


    public VehiculeAssistance(String modele,int poids,double vitesseMax,String typeAssistance){
        super(modele,poids,vitesseMax);
        this.typeAssistance = typeAssistance;
    }
    public VehiculeAssistance(String modele,int poids,double vitesseMax,String typeAssistance,boolean enIntervention,Technicien technicien){
        this(modele,poids,vitesseMax,typeAssistance);
        this.enIntervention = enIntervention;
        this.technicien = technicien;
    }
    
    public boolean changerStatut(){
        if (enIntervention == true){
            enIntervention = false;
            return false;
        } else {
            enIntervention = true;
            return true;
        }
    }
    
    public String toString() {
        return  "VehiculeAssistance : \n\t modele : " + modele + "\n poids: " + poids + "\n vitesseMax: " + vitesseMax + "\n typeAssistance: "+typeAssistance+"\n enIntervention: "+enIntervention+"\n technicien: "+technicien;
    }
}