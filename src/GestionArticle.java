import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class GestionArticle {
    private LinkedList<Article> articles;
    private Connection connection;

    public GestionArticle() {
        this.articles = new LinkedList<>();

        // Initialize the connection to your database here
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean ajouterArticle(Article article) throws SQLException {
        String query = "INSERT INTO dbo.Article (rubrique, ISBN, titre, Editeur, anneeEdition, URL, favorie, recommande, Auteur1, Auteur2, Auteur3, Auteur4, Auteur5) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, article.getRubrique());
            pstmt.setString(2, article.getISBN());
            pstmt.setString(3, article.getTitre());
            pstmt.setString(4, article.getEditeur());
            pstmt.setInt(5, article.getAnneeEdition());
            pstmt.setString(6, article.getURL());
            pstmt.setInt(7, article.getFavorie());
            pstmt.setInt(8, article.getRecommande());
            pstmt.setString(9, article.getAuteur1());
            pstmt.setString(10, article.getAuteur2());
            pstmt.setString(11, article.getAuteur3());
            pstmt.setString(12, article.getAuteur4());
            pstmt.setString(13, article.getAuteur5());

            int nbUpdated = pstmt.executeUpdate();
            return nbUpdated > 0;
        }
    }

    public boolean supprimerArticle(String isbn) throws SQLException {
        String query = "DELETE FROM dbo.Article WHERE ISBN = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, isbn);

            int nbUpdated = pstmt.executeUpdate();
            return nbUpdated > 0;
        }
    }

    private LinkedList<Article> getArticlesByParameter(String parameter, String value) throws SQLException {
        LinkedList<Article> articles = new LinkedList<>();
        String query = "SELECT * FROM dbo.Article WHERE " + parameter + " LIKE ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, value);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Article article = createArticleFromResultSet(rs);
                    articles.add(article);
                }
            }
        }
        return articles;
    }

    private Article createArticleFromResultSet(ResultSet rs) throws SQLException {
        return new Article(
                rs.getString("rubrique"),
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

    public LinkedList<Article> getArticlesByISBN(String isbn) throws SQLException {
        return getArticlesByParameter("ISBN", isbn);
    }

    public LinkedList<Article> getArticleByTitre(String titre) throws SQLException {
        return getArticlesByParameter("titre", titre);
    }

    public LinkedList<Article> getArticleByEditeur(String editeur) throws SQLException {
        return getArticlesByParameter("Editeur", editeur);
    }

    public LinkedList<Article> getArticleByAnneeEdition(int anneeEdition) throws SQLException {
        return getArticlesByParameter("anneeEdition", String.valueOf(anneeEdition));
    }

    public LinkedList<Article> getArticlesByURL(String url) throws SQLException {
        return getArticlesByParameter("URL", url);
    }

    public LinkedList<Article> getArticleByFavorie(int favorie) throws SQLException {
        return getArticlesByParameter("favorie", String.valueOf(favorie));
    }

    public LinkedList<Article> getArticlesByRecommande(int recommande) throws SQLException {
        return getArticlesByParameter("recommande", String.valueOf(recommande));
    }
    public LinkedList<Article> getArticleByRubrique(String rubrique) throws SQLException {
        return getArticlesByParameter("rubrique", rubrique);
    }

    public LinkedList<Article> afficherTousLesArticles() throws SQLException {
        String query = "SELECT * FROM dbo.Article";
        LinkedList<Article> articles = new LinkedList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Article article = createArticleFromResultSet(rs);
                articles.add(article);
            }
        }
        return articles;
    }
}
