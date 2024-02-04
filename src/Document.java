import java.util.Scanner;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author nada haninou
 */
public abstract class Document {
    java.util.Scanner s=new java.util.Scanner(System.in);
    private String ISBN;
    private String titre;
    private String Auteur1;
    private String Auteur2;
    private String Auteur3;
    private String Auteur4;
    private String Auteur5;
    private String Editeur;
    private int anneeEdition;
    private String URL;
    private int favorie;
    private int recommande;

    public Document(String ISBN, String titre, String Editeur, int anneeEdition, String URL, int favorie, int recommande,String Auteur1,String Auteur2,String Auteur3,String Auteur4,String Auteur5) {
        this.Auteur1=Auteur1;
        this.Auteur2=Auteur2;
        this.Auteur3=Auteur3;
        this.Auteur4=Auteur4;
        this.Auteur5=Auteur5;
        this.ISBN = ISBN;
        this.titre = titre;
        this.Editeur = Editeur;
        this.anneeEdition = anneeEdition;
        this.URL = URL;
        this.favorie = favorie;
        this.recommande = recommande;
    }

    public Scanner getS() {
        return s;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur1() {
        return Auteur1;
    }

    public String getAuteur2() {
        return Auteur2;
    }

    public String getAuteur3() {
        return Auteur3;
    }

    public String getAuteur4() {
        return Auteur4;
    }

    public String getAuteur5() {
        return Auteur5;
    }

    public void setAuteur1(String Auteur1) {
        this.Auteur1 = Auteur1;
    }

    public void setAuteur2(String Auteur2) {
        this.Auteur2 = Auteur2;
    }

    public void setAuteur3(String Auteur3) {
        this.Auteur3 = Auteur3;
    }

    public void setAuteur4(String Auteur4) {
        this.Auteur4 = Auteur4;
    }

    public void setAuteur5(String Auteur5) {
        this.Auteur5 = Auteur5;
    }



    public String getEditeur() {
        return Editeur;
    }

    public int getAnneeEdition() {
        return anneeEdition;
    }

    public String getURL() {
        return URL;
    }

    public int getFavorie() {
        return favorie;
    }

    public int getRecommande() {
        return recommande;
    }

    public void setS(Scanner s) {
        this.s = s;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }



    public void setEditeur(String Editeur) {
        this.Editeur = Editeur;
    }

    public void setAnneeEdition(int anneeEdition) {
        this.anneeEdition = anneeEdition;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setFavorie(int favorie) {
        this.favorie = favorie;
    }

    public void setRecommande(int recommande) {
        this.recommande = recommande;
    }

    @Override
     public String toString() {
        return "Document{ISBN=" + ISBN +", titre=" + titre + ",Auteur1="+ Auteur1+ ",Auteur2="+ Auteur2+",Auteur3="+ Auteur3+",Auteur4="+ Auteur4+",Auteur5="+ Auteur5+", Editeur=" + Editeur +", anneeEdition=" + anneeEdition+", URL=" + URL+ ",favorie=" + favorie+", recommande=" + recommande +"}";
    }
    
    
    
    
    
   
    
    
}