import java.util.Date;
import java.util.LinkedList;

public class Magazin extends Document {
    private String frequenceDePublication;
    private String genre;
    private int numeroDeMgazin;

    public Magazin(String frequenceDePublication, String genre, int numeroDeMgazin, String ISBN, String titre, String Editeur, int anneeEdition, String URL, int favorie, int recommande,String Auteur1,String Auteur2,String Auteur3,String Auteur4,String Auteur5) {
        super(ISBN, titre, Editeur, anneeEdition, URL, favorie, recommande,Auteur1, Auteur2, Auteur3, Auteur4, Auteur5);
        this.frequenceDePublication = frequenceDePublication;
        this.genre = genre;
        this.numeroDeMgazin = numeroDeMgazin;
    }

    public String getFrequenceDePublication() {
        return frequenceDePublication;
    }

    public String getGenre() {
        return genre;
    }

    public int getNumeroDeMgazin() {
        return numeroDeMgazin;
    }

    public void setFrequenceDePublication(String frequenceDePublication) {
        this.frequenceDePublication = frequenceDePublication;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setNumeroDeMgazin(int numeroDeMgazin) {
        this.numeroDeMgazin = numeroDeMgazin;
    }
    public String toString() {
        return "Magazin{ISBN=" + this.getISBN() + ", titre=" + this.getTitre()  + ", Editeur=" + this.getEditeur() +", anneeEdition=" + this.getAnneeEdition()+", URL=" + this.getURL()+ ",favorie=" + this.getFavorie()+", recommande=" + this.getRecommande() +", frequenceDePublication=" + frequenceDePublication+", genre=" + genre+", numeroDeMgazin=" + numeroDeMgazin+
                ", Auteur1=" + getAuteur1() +
                ", Auteur2=" + getAuteur2() +
                ", Auteur3=" + getAuteur3() +
                ", Auteur4=" + getAuteur4() +
                ", Auteur5=" + getAuteur5() +"}";
    }
    
}