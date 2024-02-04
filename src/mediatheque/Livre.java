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
public class Livre extends Document {
    private int nbPages;
    private String langue;

    public Livre(int nbPages, String langue, String ISBN, String titre, String Editeur, Date anneeEdition, String URL, int favorie, int recommande) {
        super(ISBN, titre, Editeur, anneeEdition, URL, favorie, recommande);
        this.nbPages = nbPages;
        this.langue = langue;
    }
    public String toString() {
        return "Livre{ISBN=" + this.getISBN() + ", titre=" + this.getTitre() + ", tableauAuteurs=" + this.getTableauAuteurs() + ", Editeur=" + this.getEditeur() +", anneeEdition=" + this.getAnneeEdition()+", URL=" + this.getURL()+ ",favorie=" + this.getFavorie()+", recommande=" + this.getRecommande() +", nbPages=" + nbPages+", langue=" + langue+"}";
    }

    
    
}
