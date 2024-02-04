import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class GestionRoman {
    private LinkedList<Roman> romans;
    private Connection connection;

    public GestionRoman() {
        this.romans = new LinkedList<>();

        // Initialisez la connexion à votre base de données ici
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean ajouterRoman(Roman roman) throws SQLException {
        String query = "INSERT INTO dbo.Roman (genre, nbChapitres, ISBN, titre, Editeur, anneeEdition, URL, favorie, recommande, Auteur1, Auteur2, Auteur3, Auteur4, Auteur5) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, roman.getGenre());
            pstmt.setInt(2, roman.getNbChapitres());
            pstmt.setString(3, roman.getISBN());
            pstmt.setString(4, roman.getTitre());
            pstmt.setString(5, roman.getEditeur());
            pstmt.setInt(6, roman.getAnneeEdition());
            pstmt.setString(7, roman.getURL());
            pstmt.setInt(8, roman.getFavorie());
            pstmt.setInt(9, roman.getRecommande());
            pstmt.setString(10, roman.getAuteur1());
            pstmt.setString(11, roman.getAuteur2());
            pstmt.setString(12, roman.getAuteur3());
            pstmt.setString(13, roman.getAuteur4());
            pstmt.setString(14, roman.getAuteur5());

            int nbUpdated = pstmt.executeUpdate();
            return nbUpdated > 0;
        }
    }

    public boolean supprimerRoman(String isbn) throws SQLException {
        String query = "DELETE FROM dbo.Roman WHERE ISBN = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, isbn);

            int nbUpdated = pstmt.executeUpdate();
            return nbUpdated > 0;
        }
    }

    // Ajoutez d'autres méthodes pour la recherche, l'affichage, etc., en fonction de vos besoins

    private LinkedList<Roman> getRomansByParameter(String parameter, String value) throws SQLException {
        LinkedList<Roman> romans = new LinkedList<>();
        String query = "SELECT * FROM dbo.Roman WHERE " + parameter + " LIKE ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, value);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Roman roman = createRomanFromResultSet(rs);
                    romans.add(roman);
                }
            }
        }
        return romans;
    }

    private Roman createRomanFromResultSet(ResultSet rs) throws SQLException {
        return new Roman(
                rs.getString("genre"),
                rs.getInt("nbChapitres"),
                rs.getString("ISBN"),
                rs.getString("titre"),
                rs.getString("Editeur"),
                rs.getInt("anneeEdition"),
                rs.getString("URL"),
                rs.getInt("favorie"),
                rs.getInt("recommande"),
                rs.getString("Auteur1"),
                rs.getString("Auteur2"),
                rs.getString("Auteur3"),
                rs.getString("Auteur4"),
                rs.getString("Auteur5")
        );
    }
    public LinkedList<Roman> getRomanByGenre(String genre) throws SQLException {
        return getRomansByParameter("genre", genre);
    }

    public LinkedList<Roman> getRomansByNBChapitres(int nbChapitres) throws SQLException {
        return getRomansByParameter("nbChapitres", String.valueOf(nbChapitres));
    }

    public LinkedList<Roman> getRomansByISBN(String isbn) throws SQLException {
        return getRomansByParameter("ISBN", isbn);
    }

    public LinkedList<Roman> getRomansByTitre(String titre) throws SQLException {
        return getRomansByParameter("titre", titre);
    }

    public LinkedList<Roman> getRomansByEditeur(String editeur) throws SQLException {
        return getRomansByParameter("Editeur", editeur);
    }

    public LinkedList<Roman> getRomansByAnneeEdition(int anneeEdition) throws SQLException {
        return getRomansByParameter("anneeEdition", String.valueOf(anneeEdition));
    }

    public LinkedList<Roman> getRomansByURL(String url) throws SQLException {
        return getRomansByParameter("URL", url);
    }

    public LinkedList<Roman> getRomansByFavorie(int favorie) throws SQLException {
        return getRomansByParameter("favorie", String.valueOf(favorie));
    }

    public LinkedList<Roman> getRomansByRecommande(int recommande) throws SQLException {
        return getRomansByParameter("recommande", String.valueOf(recommande));
    }
    public LinkedList<Roman> afficherTousLesRomans() throws SQLException {
    String query = "SELECT * FROM dbo.Roman";
    LinkedList<Roman> Romans = new LinkedList<>();
    try (PreparedStatement pstmt = connection.prepareStatement(query);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            Roman Romane = createRomanFromResultSet(rs);
            Romans.add(Romane);
        }
    }
    return Romans;
}


    
}
