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
public class Roman extends Document {
    private String genre;
    private int nbChapitres;

    public Roman(String genre, int nbChapitres, String ISBN, String titre, String Editeur, Date anneeEdition, String URL, int favorie, int recommande) {
        super(ISBN, titre, Editeur, anneeEdition, URL, favorie, recommande);
        this.genre = genre;
        this.nbChapitres = nbChapitres;
    }
    public String toString() {
        return "Roman{ISBN=" + this.getISBN() + ", titre=" + this.getTitre() + ", tableauAuteurs=" + this.getTableauAuteurs() + ", Editeur=" + this.getEditeur() +", anneeEdition=" + this.getAnneeEdition()+", URL=" + this.getURL()+ ",favorie=" + this.getFavorie()+", recommande=" + this.getRecommande() +", genre=" + genre+", nbChapitres=" + nbChapitres+"}";
    }
    
    
    
}
