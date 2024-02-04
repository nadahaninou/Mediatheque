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
public class Article extends Document {
    private String rubrique;

    public Article(String rubrique, String ISBN, String titre, String Editeur, Date anneeEdition, String URL, int favorie, int recommande) {
        super(ISBN, titre, Editeur, anneeEdition, URL, favorie, recommande);
        this.rubrique = rubrique;
    }

    public String getRubrique() {
        return rubrique;
    }

    public void setRubrique(String rubrique) {
        this.rubrique = rubrique;
    }
    @Override
    public String toString() {
        return "Article{ISBN=" + this.getISBN() + ", titre=" + this.getTitre() + ", tableauAuteurs=" + this.getTableauAuteurs() + ", Editeur=" + this.getEditeur() +", anneeEdition=" + this.getAnneeEdition()+", URL=" + this.getURL()+ ",favorie=" + this.getFavorie()+", recommande=" + this.getRecommande() +", rubrique=" + rubrique+"}";
    }
    
    
    }
    

