
import java.text.SimpleDateFormat;
import java.util.Date;


public class Emprunt {
    private  final String matriculeClient;
    private String idKindles;
    private String dateEmprunt;

    public Emprunt(String matriculeClient, String idKindles, String dateEmprunt) {
        this.matriculeClient = matriculeClient;
        this.idKindles = idKindles;
        this.dateEmprunt = dateEmprunt;
    }

    public String getMatriculeClient() {
        return matriculeClient;
    }

    public String getIdKindles() {
        return idKindles;
    }



    public void setIdKindles(String idKindles) {
        this.idKindles = idKindles;
    }

    public void setDateEmprunt(String dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public String getDateEmprunt() {
        return dateEmprunt;
    }

    @Override
    public String toString() {
        return "Emprunt{" + "matriculeClient=" + matriculeClient + ", idKindles=" + idKindles + ", dateEmprunt=" + dateEmprunt + '}';
    }


}
