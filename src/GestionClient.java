/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
public class GestionClient {
    
     private Connection connection;

    public GestionClient() {
        // Initialiser la connexion à votre base de données ici
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
        } catch (SQLException e) {
            // Gérer l'exception en fonction des besoins de votre application
            e.printStackTrace();
        }
    }

    public boolean ajouterClient(Client client) throws SQLException {
        String query = "INSERT INTO dbo.Client (matriculeClient, nom, prenom, typeAbonnement, motDePasse) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, client.getMatriculeClient());
            pstmt.setString(2, client.getNom());
            pstmt.setString(3, client.getPrenom());
            pstmt.setString(4, client.getTypeAbonnement());
            pstmt.setString(5, client.getMotDePasse());

            int nbAjouts = pstmt.executeUpdate();
            return nbAjouts > 0;
        }
    }

    public boolean supprimerClient(String matriculeClient) throws SQLException {
        String query = "DELETE FROM dbo.Client WHERE matriculeClient = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, matriculeClient);

            int nbSuppressions = pstmt.executeUpdate();
            return nbSuppressions > 0;
        }
    }

    public LinkedList<Client> getTousLesClients() throws SQLException {
        LinkedList<Client> clients = new LinkedList<>();
        String query = "SELECT * FROM dbo.Client";
        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Client client = createClientFromResultSet(rs);
                clients.add(client);
            }
        }
        return clients;
    }
        public LinkedList<Client> getClientsByParameter(String parameter, String value) throws SQLException {
        LinkedList<Client> clients = new LinkedList<>();
        String query = "SELECT * FROM dbo.Client WHERE " + parameter + " LIKE ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, value);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Client client = createClientFromResultSet(rs);
                    clients.add(client);
                }
            }
        }
        return clients;
    }
 public LinkedList<Client> getclientByMatriculeClient(String MatriculeClient) throws SQLException {
        return getClientsByParameter("MatriculeClient", String.valueOf(MatriculeClient));
        
    }
  public LinkedList<Client> getclientByNom(String Nom) throws SQLException {
        return getClientsByParameter("Nom", String.valueOf(Nom));
        
    }
    public LinkedList<Client> getclientByPrenom(String Prenom) throws SQLException {
        return getClientsByParameter("Prenom", String.valueOf(Prenom)); 
    }
        public LinkedList<Client> getclientByTypeAbonnement(String TypeAbonnement) throws SQLException {
        return getClientsByParameter("TypeAbonnement", String.valueOf(TypeAbonnement)); 
    }
         public LinkedList<Client> getRomansByMotDePasse(String MotDePasse) throws SQLException {
        return getClientsByParameter("MotDePasse", String.valueOf(MotDePasse)); 
    }   
        
        
    private Client createClientFromResultSet(ResultSet rs) throws SQLException {
        return new Client(
                rs.getString("matriculeClient"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getString("typeAbonnement"),
                rs.getString("motDePasse")
        );
    }

    
}
