
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class GestionMagazin {
    private LinkedList<Magazin> magasins;
    private Connection connection;

    public GestionMagazin() {
        this.magasins = new LinkedList<>();

        // Initialisez la connexion à votre base de données ici
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean ajouterMagazin(Magazin magazin) throws SQLException {
        String query = "INSERT INTO dbo.Magazin (frequenceDePublication, genre, numeroDeMgazin, ISBN, titre, Editeur, anneeEdition, URL, favorie, recommande, Auteur1, Auteur2, Auteur3, Auteur4, Auteur5) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, magazin.getFrequenceDePublication());
            pstmt.setString(2, magazin.getGenre());
            pstmt.setInt(3, magazin.getNumeroDeMgazin());

            pstmt.setString(4, magazin.getISBN());
            pstmt.setString(5, magazin.getTitre());
            pstmt.setString(6, magazin.getEditeur());
            pstmt.setInt(7, magazin.getAnneeEdition());
            pstmt.setString(8, magazin.getURL());
            pstmt.setInt(9, magazin.getFavorie());
            pstmt.setInt(10, magazin.getRecommande());
            pstmt.setString(11, magazin.getAuteur1());
            pstmt.setString(12, magazin.getAuteur2());
            pstmt.setString(13, magazin.getAuteur3());
            pstmt.setString(14, magazin.getAuteur4());
            pstmt.setString(15, magazin.getAuteur5());

            int nbUpdated = pstmt.executeUpdate();
            return nbUpdated > 0;
        }
    }

    public boolean supprimerMagazin(String isbn) throws SQLException {
        String query = "DELETE FROM dbo.Magazin WHERE ISBN = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, isbn);

            int nbUpdated = pstmt.executeUpdate();
            return nbUpdated > 0;
        }
    }

    private LinkedList<Magazin> getMagazinsByParameter(String parameter, String value) throws SQLException {
        LinkedList<Magazin> magazins = new LinkedList<>();
        String query = "SELECT * FROM dbo.Magazin WHERE " + parameter + " LIKE ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, value);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Magazin magazin = createMagazinFromResultSet(rs);
                    magazins.add(magazin);
                }
            }
        }
        return magazins;
    }

    private Magazin createMagazinFromResultSet(ResultSet rs) throws SQLException {
        return new Magazin(
                rs.getString("frequenceDePublication"),
                rs.getString("genre"),
                rs.getInt("numeroDeMgazin"),
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

    public LinkedList<Magazin> getMagazinsByISBN(String isbn) throws SQLException {
        return getMagazinsByParameter("ISBN", isbn);
    }

    public LinkedList<Magazin> getMagazinsByTitre(String titre) throws SQLException {
        return getMagazinsByParameter("titre", titre);
    }

    public LinkedList<Magazin> getMagazinsByEditeur(String editeur) throws SQLException {
        return getMagazinsByParameter("Editeur", editeur);
    }

    public LinkedList<Magazin> getMagazinsByAnneeEdition(int anneeEdition) throws SQLException {
        return getMagazinsByParameter("anneeEdition", String.valueOf(anneeEdition));
    }

    public LinkedList<Magazin> getMagazinsByURL(String url) throws SQLException {
        return getMagazinsByParameter("URL", url);
    }

    public LinkedList<Magazin> getMagazinsByFavorie(int favorie) throws SQLException {
        return getMagazinsByParameter("favorie", String.valueOf(favorie));
    }

    public LinkedList<Magazin> getMagazinsByRecommande(int recommande) throws SQLException {
        return getMagazinsByParameter("recommande", String.valueOf(recommande));
    }
    public LinkedList<Magazin> getArticleByFrequenceDePublication(String frequenceDePublication) throws SQLException {
        return getMagazinsByParameter("frequenceDePublication", frequenceDePublication);
    }
        public LinkedList<Magazin> getArticleByGenre(String genre) throws SQLException {
        return getMagazinsByParameter("genre", genre);
    }
            public LinkedList<Magazin> getArticleByNumeroDeMgazin(int numeroDeMgazin) throws SQLException {
        return getMagazinsByParameter("numeroDeMgazin", String.valueOf(numeroDeMgazin));
    }
    

    public LinkedList<Magazin> afficherTousLesMagazins() throws SQLException {
        String query = "SELECT * FROM dbo.Magazin";
        LinkedList<Magazin> articles = new LinkedList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
               Magazin magazin = createMagazinFromResultSet(rs);
                articles.add(magazin);
            }
        }
        return articles;
    }
}
