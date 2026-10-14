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
        return "Pilote : \n   Nom : "+super.nom+"\n   Prenom : "+ super.prenom+"\n   Age : "+super.age+"\n   Numero Course : "+this.numeroCourse+"\n   Temps de reaction : "+this.tempsReaction;
    }
}