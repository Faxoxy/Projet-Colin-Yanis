public class Personne {
    protected String nom;
    protected String prenom; 
    protected int age ;

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getNom() {
        return this.prenom + " " + this.nom;
    }
    

    public void afficherInfos() {
        System.out.println("Nom complet : " + getNom() + ", Age : " + this.age + " ans");
    }   
}
