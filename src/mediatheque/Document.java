/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediatheque;

import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author nada haninou
 */
public abstract class Document {
    java.util.Scanner s=new java.util.Scanner(System.in);
    private String ISBN;
    private String titre;
    private String[] tableauAuteurs = new String[5];
    private String Editeur;
    private Date anneeEdition;
    private String URL;
    private int favorie;
    private int recommande;

    public Document(String ISBN, String titre, String Editeur, Date anneeEdition, String URL, int favorie, int recommande) {
        System.out.println("donnez le nombre d'auteurs de ce livre ,attention il ne doit pas depasser 5");
        int n=s.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("donnez le nom de l'auteur"+i);
            tableauAuteurs[i]=s.next();
        }
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

    public String[] getTableauAuteurs() {
        return tableauAuteurs;
    }

    public String getEditeur() {
        return Editeur;
    }

    public Date getAnneeEdition() {
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
    public String getelemttableau(int i){
        return tableauAuteurs[i];
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

    public void setTableauAuteurs(String[] tableauAuteurs) {
        this.tableauAuteurs = tableauAuteurs;
    }

    public void setEditeur(String Editeur) {
        this.Editeur = Editeur;
    }

    public void setAnneeEdition(Date anneeEdition) {
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
    public void setelemttableau(int i,String auteur){
        tableauAuteurs[i]=auteur;
    }
    @Override
     public String toString() {
        return "Document{ISBN=" + ISBN + ", titre=" + titre + ", tableauAuteurs=" + tableauAuteurs + ", Editeur=" + Editeur +", anneeEdition=" + anneeEdition+", URL=" + URL+ ",favorie=" + favorie+", recommande=" + recommande +"}";
    }
    
    
    
    
    
   
    
    
}
