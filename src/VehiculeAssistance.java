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
        return  "VehiculeAssistance : \n   Modele : " + modele + "\n   Poids : " + poids + "\n   Vitesse max : " + vitesseMax + "\n   Type assistance : "+typeAssistance+"\n   En intervention : "+enIntervention+"\n   Technicien : "+technicien;
    }
}