public abstract class Vehicule {
    protected String modele;
    protected int poids;
    protected double vitesseMax;
    protected boolean estDemarre;


    public Vehicule(String modele, int poids, double vitesseMax) {
        this.modele = modele;
        this.poids = poids;
        this.vitesseMax = vitesseMax;
    }

    public boolean demarrer(){
        if (!estDemarre){
            estDemarre =true;
            return true;
        }
        return false;
    }
    public boolean arreter(){
        if (estDemarre){
            estDemarre = false;
            return true;
        }
        return false;
    }
}
