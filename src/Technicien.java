public class Technicien extends Personne {
    private String role ;

    public Technicien(String nom, String prenom, int age, String role) {
        super(nom, prenom, age); // Appel au constructeur de la classe parente (Personne)
        this.role = role;
    }

    public void intervenir() {
        System.out.println(getNom() + " intervient sur le véhicule. Rôle : " + this.role);
        // Logique spécifique à l'intervention du technicien
    }

    public String toString() {
    return getNom() + " - " + this.role;
    } 
    
}