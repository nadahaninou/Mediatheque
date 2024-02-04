import java.util.Date;
import java.util.LinkedList;

public class Livre extends Document {
    private int nbPages;
    private String langue;

    public Livre(int nbPages, String langue, String ISBN, String titre, String Editeur, int anneeEdition, String URL, int favorie, int recommande,String Auteur1,String Auteur2,String Auteur3,String Auteur4,String Auteur5) {
        super(ISBN, titre, Editeur, anneeEdition, URL, favorie, recommande,Auteur1,Auteur2,Auteur3,Auteur4, Auteur5);
        this.nbPages = nbPages;
        this.langue = langue;
    }
    public String toString() {
        return "Livre{ISBN=" + this.getISBN() + ", titre=" + this.getTitre() + ", Auteur1=" + this.getAuteur1()+ ", Auteur2=" + this.getAuteur2()+", Auteur3=" + this.getAuteur3()+", Auteur4=" + this.getAuteur4()+", Auteur5=" + this.getAuteur5()+ ", Editeur=" + this.getEditeur() +", anneeEdition=" + this.getAnneeEdition()+", URL=" + this.getURL()+ ",favorie=" + this.getFavorie()+", recommande=" + this.getRecommande()+", langue=" + langue+", nbpages="+nbPages+"}";
    }

    public int getNbPages() {
        return nbPages;
    }

    public String getLangue() {
        return langue;
    }

    
    
}