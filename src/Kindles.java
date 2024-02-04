/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class Kindles {
    private final String idKindles;
    private String tailleEcran;
    private String tailleStockage;
    private String modele;

    public Kindles(String idKindles, String tailleEcran, String tailleStockage, String modele) {
        this.idKindles = idKindles;
        this.tailleEcran = tailleEcran;
        this.tailleStockage = tailleStockage;
        this.modele = modele;
    }

    public String getIdKindles() {
        return idKindles;
    }

    public String getTailleEcran() {
        return tailleEcran;
    }

    public String getTailleStockage() {
        return tailleStockage;
    }

    public String getModele() {
        return modele;
    }

    public void setTailleEcran(String tailleEcran) {
        this.tailleEcran = tailleEcran;
    }

    public void setTailleStockage(String tailleStockage) {
        this.tailleStockage = tailleStockage;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }
    public String toString() {
    return "Kindles{" +
            "idKindles='" + idKindles + '\'' +
            ", tailleEcran='" + tailleEcran + '\'' +
            ", tailleStockage='" + tailleStockage + '\'' +
            ", modele='" + modele + '\'' +
            '}';
    }
    
}
