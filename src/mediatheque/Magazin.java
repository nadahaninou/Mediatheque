/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediatheque;
import java.util.Date;
/**
 *
 * @author nada haninou
 */
public class Magazin extends Document {
    private String frequenceDePublication;
    private String genre;
    private int numeroDeMgazin;

    public Magazin(String frequenceDePublication, String genre, int numeroDeMgazin, String ISBN, String titre, String Editeur, Date anneeEdition, String URL, int favorie, int recommande) {
        super(ISBN, titre, Editeur, anneeEdition, URL, favorie, recommande);
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
        return "Magazin{ISBN=" + this.getISBN() + ", titre=" + this.getTitre() + ", tableauAuteurs=" + this.getTableauAuteurs() + ", Editeur=" + this.getEditeur() +", anneeEdition=" + this.getAnneeEdition()+", URL=" + this.getURL()+ ",favorie=" + this.getFavorie()+", recommande=" + this.getRecommande() +", frequenceDePublication=" + frequenceDePublication+", genre=" + genre+", numeroDeMgazin=" + numeroDeMgazin+"}";
    }
    
}
