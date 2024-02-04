import java.util.Date;
import java.util.LinkedList;

public class Article extends Document {
    private String rubrique;

    public Article(String rubrique, String ISBN, String titre, String Editeur, int anneeEdition, String URL, int favorie, int recommande,String Auteur1,String Auteur2,String Auteur3,String Auteur4,String Auteur5) {
        super(ISBN, titre, Editeur, anneeEdition, URL, favorie, recommande, Auteur1, Auteur2, Auteur3, Auteur4, Auteur5);
        this.rubrique = rubrique;
    }

    public String getRubrique() {
        return rubrique;
    }

    @Override
    public String toString() {
        return "Article{" +
                "rubrique=" + rubrique + 
                ", ISBN=" + getISBN() + 
                ", titre=" + getTitre() + 
                ", Editeur=" + getEditeur() + 
                ", anneeEdition=" + getAnneeEdition() +
                ", URL=" + getURL() + 
                ", favorie=" + getFavorie() +
                ", recommande=" + getRecommande() +
                ", Auteur1=" + getAuteur1() +
                ", Auteur2=" + getAuteur2() +
                ", Auteur3=" + getAuteur3() +
                ", Auteur4=" + getAuteur4() +
                ", Auteur5=" + getAuteur5() +
                '}';
    }


    
    
    }