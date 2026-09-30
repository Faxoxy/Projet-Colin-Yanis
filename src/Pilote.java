public class Pilote extends Personne{

    private int numeroCourse ;
    private double tempsReaction ;

    public Pilote (String nom, String prenom, int age, int numeroCourse, double tempsReaction) {
        super(nom, prenom, age) ;
        this.numeroCourse = numeroCourse ;
        this.tempsReaction = tempsReaction ;
    }

    public void piloter() {
        System.out.println(getNom() + " (N°" + this.numeroCourse + ") est en train de piloter.");
    }

    public String toString() {
        return "Pilote: \n\tnom: "+super.nom+"\n prenom: "+ super.prenom+"\n age: "+super.age+"\n numeroCourse: "+this.numeroCourse+"\n tempsReaction: "+this.tempsReaction ;
    }
}