
public class Client {
    private final String matriculeClient;
    private String nom;
    private String prenom;
    private String typeAbonnement;
    private String motDePasse;

    public Client(String matriculeClient, String nom, String prenom, String typeAbonnement, String motDePasse) {
        this.matriculeClient = matriculeClient;
        this.nom = nom;
        this.prenom = prenom;
        this.typeAbonnement = typeAbonnement;
        this.motDePasse = motDePasse;
    }

    public String getMatriculeClient() {
        return matriculeClient;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTypeAbonnement() {
        return typeAbonnement;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTypeAbonnement(String typeAbonnement) {
        this.typeAbonnement = typeAbonnement;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    @Override
    public String toString() {
        return "Client{" +
                "idClient='" + matriculeClient + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", typeAbonnement='" + typeAbonnement + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
}
