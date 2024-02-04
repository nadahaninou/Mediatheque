import java.util.Date;
import java.util.LinkedList;


public class Roman extends Document {
    private String genre;
    private int nbChapitres;

    public Roman(String genre, int nbChapitres, String ISBN, String titre, String Editeur, int anneeEdition, String URL, int favorie, int recommande,String Auteur1,String Auteur2,String Auteur3,String Auteur4,String Auteur5) {
        super(ISBN, titre, Editeur, anneeEdition, URL, favorie, recommande, Auteur1, Auteur2, Auteur3, Auteur4, Auteur5);
        this.genre = genre;
        this.nbChapitres = nbChapitres;
    }
    public String toString() {
        return "Roman{ISBN=" + this.getISBN() + ", titre=" + this.getTitre()  + ", Editeur=" + this.getEditeur() +", anneeEdition=" + this.getAnneeEdition()+", URL=" + this.getURL()+ ",favorie=" + this.getFavorie()+", recommande=" + this.getRecommande() +", genre=" + genre+", nbChapitres=" + nbChapitres+
                ", Auteur1=" + getAuteur1() +
                ", Auteur2=" + getAuteur2() +
                ", Auteur3=" + getAuteur3() +
                ", Auteur4=" + getAuteur4() +
                ", Auteur5=" + getAuteur5() +"}";
    }

    public String getGenre() {
        return genre;
    }

    public int getNbChapitres() {
        return nbChapitres;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setNbChapitres(int nbChapitres) {
        this.nbChapitres = nbChapitres;
    }
    
    
    
}