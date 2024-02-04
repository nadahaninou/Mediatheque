public class Admin {
    private final String matriculeAdmin;
    private String nom;
    private String prenom;

    public Admin(String matriculeAdmin, String nom, String prenom) {
        this.matriculeAdmin = matriculeAdmin;
        this.nom = nom;
        this.prenom = prenom;
    }


    public String getMatriculeAdmin() {
        return matriculeAdmin;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    @Override
    public String toString() {
        return "Admin{" +
                "matriculeAdmin='" + matriculeAdmin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
