import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class GestionEmprunts {
    private Connection connection;

    public GestionEmprunts() {
        // Initialisez la connexion à votre base de données ici
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
        } catch (SQLException e) {
            // Gérez l'exception de manière plus appropriée en fonction des besoins de votre application
            e.printStackTrace();
        }
    }

    public boolean ajouterEmprunt(Emprunt emprunt) throws SQLException {
        String query = "INSERT INTO dbo.Emprunt (matriculeClient, idKindles, dateEmprunt) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, emprunt.getMatriculeClient());
            pstmt.setString(2, emprunt.getIdKindles());
            pstmt.setString(3, emprunt.getDateEmprunt()); // Conversion de java.util.Date à java.sql.Date

            int nbUpdated = pstmt.executeUpdate();
            return nbUpdated > 0;
        }
    }

    public boolean supprimerEmprunt(String matriculeClient, String idKindles) throws SQLException {
        String query = "DELETE FROM dbo.Emprunt WHERE matriculeClient = ? AND idKindles = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, matriculeClient);
            pstmt.setString(2, idKindles);

            int nbUpdated = pstmt.executeUpdate();
            return nbUpdated > 0;
        }
    }

    private LinkedList<Emprunt> getEmpruntsByParameter(String parameter, String value) throws SQLException {
        LinkedList<Emprunt> emprunts = new LinkedList<>();
        String query = "SELECT * FROM dbo.Emprunt WHERE " + parameter + " LIKE ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, value);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Emprunt emprunt = createEmpruntFromResultSet(rs);
                    emprunts.add(emprunt);
                }
            }
        }
        return emprunts;
    }

    private Emprunt createEmpruntFromResultSet(ResultSet rs) throws SQLException {
        String matriculeClient = rs.getString("matriculeClient");
        String idKindles = rs.getString("idKindles");
        String dateEmprunt = rs.getString("dateEmprunt");

        return new Emprunt(matriculeClient, idKindles, dateEmprunt);
    }

    // Méthodes de recherche par attributs spécifiques
    public LinkedList<Emprunt> getEmpruntsByMatriculeClient(String matriculeClient) throws SQLException {
        return getEmpruntsByParameter("matriculeClient", matriculeClient);
    }

    public LinkedList<Emprunt> getEmpruntsByIdKindles(String idKindles) throws SQLException {
        return getEmpruntsByParameter("idKindles", idKindles);
    }

    public LinkedList<Emprunt> afficherTousLesEmprunts() throws SQLException {
        String query = "SELECT * FROM dbo.Emprunt";
        LinkedList<Emprunt> emprunts = new LinkedList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Emprunt emprunt = createEmpruntFromResultSet(rs);
                emprunts.add(emprunt);
            }
        }
        return emprunts;
    }

}
