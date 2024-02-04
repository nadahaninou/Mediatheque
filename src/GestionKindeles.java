import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
public class GestionKindeles {
    private Connection connection;

    public GestionKindeles() {
        // Initialisez la connexion à votre base de données ici
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
        } catch (SQLException e) {
            // Gérez l'exception de manière plus appropriée en fonction des besoins de votre application
            e.printStackTrace();
        }
    }

    public boolean ajouterKindle(Kindles kindle) throws SQLException {
        String query = "INSERT INTO dbo.Kindles (idKindles, tailleEcran, tailleStockage, modele) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, kindle.getIdKindles());
            pstmt.setString(2, kindle.getTailleEcran());
            pstmt.setString(3, kindle.getTailleStockage());
            pstmt.setString(4, kindle.getModele());

            int nbUpdated = pstmt.executeUpdate();
            return nbUpdated > 0;
        }
    }

    public boolean supprimerKindle(String idKindles) throws SQLException {
        String query = "DELETE FROM dbo.Kindles WHERE idKindles = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, idKindles);

            int nbUpdated = pstmt.executeUpdate();
            return nbUpdated > 0;
        }
    }

    private LinkedList<Kindles> getKindlesByParameter(String parameter, String value) throws SQLException {
        LinkedList<Kindles> kindles = new LinkedList<>();
        String query = "SELECT * FROM dbo.Kindles WHERE " + parameter + " LIKE ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, value);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Kindles kindle = createKindleFromResultSet(rs);
                    kindles.add(kindle);
                }
            }
        }
        return kindles;
    }

    private Kindles createKindleFromResultSet(ResultSet rs) throws SQLException {
        return new Kindles(
                rs.getString("idKindles"),
                rs.getString("tailleEcran"),
                rs.getString("tailleStockage"),
                rs.getString("modele")
        );
    }

    // Méthodes de recherche par attributs spécifiques
    public LinkedList<Kindles> getKindlesById(String idKindles) throws SQLException {
        return getKindlesByParameter("idKindles", idKindles);
    }

    public LinkedList<Kindles> getKindlesByTailleEcran(String tailleEcran) throws SQLException {
        return getKindlesByParameter("tailleEcran", tailleEcran);
    }

    public LinkedList<Kindles> getKindlesByTailleStockage(String tailleStockage) throws SQLException {
        return getKindlesByParameter("tailleStockage", tailleStockage);
    }

    public LinkedList<Kindles> getKindlesByModele(String modele) throws SQLException {
        return getKindlesByParameter("modele", modele);
    }

    public LinkedList<Kindles> afficherTousLesKindles() throws SQLException {
        String query = "SELECT * FROM dbo.Kindles";
        LinkedList<Kindles> kindles = new LinkedList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Kindles kindle = createKindleFromResultSet(rs);
                kindles.add(kindle);
            }
        }
        return kindles;
    }
}
