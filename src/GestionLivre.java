import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

public class GestionLivre {
    private LinkedList<Livre> livres;
    private Scanner scanner;
    private Connection connection;

    public GestionLivre() {
        this.livres = new LinkedList<>();
        this.scanner = new Scanner(System.in);

        // Initialize the connection to your database here
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
        } catch (SQLException e) {
            // Handle the exception more gracefully based on your application needs
            e.printStackTrace();
        }
    }

    public boolean ajouterLivre(Livre livre) throws SQLException {
    String query = "INSERT INTO  dbo.Livre (nbPages, langue, ISBN, titre, Editeur, anneeEdition, URL, favorie, recommande,Auteur1,Auteur2,Auteur3,Auteur4,Auteur5) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";
    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        pstmt.setInt(1, livre.getNbPages());
        pstmt.setString(2, livre.getLangue());
        pstmt.setString(3, livre.getISBN());
        pstmt.setString(4, livre.getTitre());
        pstmt.setString(5, livre.getEditeur());
        pstmt.setInt(6, livre.getAnneeEdition());
        pstmt.setString(7, livre.getURL());
        pstmt.setInt(8, livre.getFavorie());
        pstmt.setInt(9, livre.getRecommande());
        pstmt.setString(10, livre.getAuteur1());
        pstmt.setString(11, livre.getAuteur2());
        pstmt.setString(12, livre.getAuteur3());
        pstmt.setString(13, livre.getAuteur4());
        pstmt.setString(14, livre.getAuteur5());
                

        int nbUpdated = pstmt.executeUpdate();
        return nbUpdated > 0;
    }
}
    public boolean supprimerLivre(String isbn) throws SQLException {
    String query = "DELETE FROM dbo.Livre WHERE ISBN = ?";
    
    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        pstmt.setString(1, isbn);
        
        int nbUpdated = pstmt.executeUpdate();
        return nbUpdated > 0;
    }
}

       private LinkedList<Livre> getLivresByParameter(String parameter, String value) throws SQLException {
        LinkedList<Livre> livres = new LinkedList<>();
        String query = "SELECT * FROM dbo.Livre WHERE " + parameter + " LIKE ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, value);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Livre livre = createLivreFromResultSet(rs);
                    livres.add(livre);
                }
            }
        }
        return livres;
    }
       private Livre createLivreFromResultSet(ResultSet rs) throws SQLException {
    return new Livre(rs.getInt("nbPages"),rs.getString("langue"),rs.getString("ISBN"),rs.getString("titre"), rs.getString("Editeur"),rs.getInt("anneeEdition"),rs.getString("URL"),rs.getInt("favorie"),rs.getInt("recommande"),rs.getString("Auteur1"),rs.getString("Auteur2"),rs.getString("Auteur3"),rs.getString("Auteur4"),rs.getString("Auteur5"));
}

    // Utility method to create Livre object from ResultSet
   /* private Livre createLivreFromResultSet(ResultSet rs) throws SQLException {
        return new Livre(
                rs.getInt("nbPages"),
                rs.getString("langue"),
                rs.getString("ISBN"),
                rs.getString("titre"),
                rs.getString("Editeur"),
                rs.getInt("anneeEdition"),
                rs.getString("URL"),
                rs.getInt("favorie"),
                rs.getInt("recommande")
        );
    }*/
    //REcherche par Parametres
public LinkedList<Livre> getLivresByNbPages(int nbPages) throws SQLException {
        return getLivresByParameter("nbPages", String.valueOf(nbPages));
    }

    public LinkedList<Livre> getLivresByLangue(String langue) throws SQLException {
        return getLivresByParameter("langue", langue);
    }

    public LinkedList<Livre> getLivresByISBN(String isbn) throws SQLException {
        return getLivresByParameter("ISBN", isbn);
    }

    public LinkedList<Livre> getLivresByTitre(String titre) throws SQLException {
        return getLivresByParameter("titre", titre);
    }

    public LinkedList<Livre> getLivresByEditeur(String editeur) throws SQLException {
        return getLivresByParameter("Editeur", editeur);
    }

    public LinkedList<Livre> getLivresByAnneeEdition(int anneeEdition) throws SQLException {
        return getLivresByParameter("anneeEdition", String.valueOf(anneeEdition));
    }

    public LinkedList<Livre> getLivresByURL(String url) throws SQLException {
        return getLivresByParameter("URL", url);
    }

    public LinkedList<Livre> getLivresByFavorie(int favorie) throws SQLException {
        return getLivresByParameter("favorie", String.valueOf(favorie));
    }

    public LinkedList<Livre> getLivresByRecommande(int recommande) throws SQLException {
        return getLivresByParameter("recommande", String.valueOf(recommande));
    }
    public LinkedList<Livre> afficherTousLesLivres() throws SQLException {
    String query = "SELECT * FROM dbo.Livre";
    LinkedList<Livre> Livres = new LinkedList<>();
    try (PreparedStatement pstmt = connection.prepareStatement(query);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            Livre livre = createLivreFromResultSet(rs);
            Livres.add(livre);
        }
    }
    return Livres;
}

    // ... (existing code)
}

