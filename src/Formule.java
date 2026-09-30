public class Formule extends Vehicule{
    private String typedeGomme;
    private Pilote pilote;

    public Formule(String modele,int poids,double vitesseMax,String typedeGomme,Pilote pilote){ 
        super(modele,poids,vitesseMax);
        this.typedeGomme=typedeGomme;
        this.pilote=pilote;
    }
    public void changerGomme(String typedeGomme){
        this.typedeGomme=typedeGomme;
    }

    public void assignerPilote(Pilote pilote){
        this.pilote=pilote;
    }

    public String toString() {
        return "Formule :\n\t modele: "+super.modele+"\n poids: "+poids+"\n vitesseMax: "+vitesseMax+"\n typedeGomme: "+typedeGomme+"\n pilote:"+pilote;
    }
}
