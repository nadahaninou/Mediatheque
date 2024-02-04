import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

public class Maintest {
    private static final GestionLivre gestionLivre = new GestionLivre();
    private static final GestionClient gestionClient = new GestionClient();
    private static final GestionArticle gestionArticle = new GestionArticle();
    private static final GestionMagazin gestionMagazin = new GestionMagazin();
    private static final GestionRoman gestionRoman = new GestionRoman();
    private static final GestionKindeles gestionKindeles = new GestionKindeles();
    private static final GestionEmprunts gestionEmprunts = new GestionEmprunts();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        int choice;
        do {
            System.out.println("Bienvenue dans le programme de gestion de documents!");
            System.out.println("\nMenu principal:");
            System.out.println("1. Gestion des livres");
            System.out.println("2. Gestion des articles");
            System.out.println("3. Gestion des magazins");
            System.out.println("4. Gestion des romans");
            System.out.println("5. Gestion des clients");
            System.out.println("6. Gestion des kindeles");
            System.out.println("7. Gestion des Emprunts");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option (0=5) : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    GestionLivres();
                    break;
                case 2:
                    GestionArticles();
                    
                    break;
                case 3:
                    GestionMagazin();
                    break;
                case 4:
                    GestionRoman();
                    break;
                case 5:
                    GestionClient();
                    break;
                case 6:
                    GestionKindeles();
                    break;
                case 7:
                    GestionEmprunts();
                    break;
            }

        } while (choice != 0);

        // Fermez le scanner à la fin
        scanner.close();
    }
    //================================gestionlivres================================================================

    private static void GestionLivres() throws SQLException {
        int choice;
        do {
            System.out.println("Bienvenue dans le programme de gestion de livres!");
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Supprimer un livre");
            System.out.println("3. Rechercher un livre");
            System.out.println("4. Afficher tout livre");
            System.out.println("0. Revenir au menu principal");
            System.out.print("Choisissez une option (0-4) : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ajouterLivre();
                    break;
                case 2:
                    supprimerLivre();
                    break;
                case 3:
                    rechercheLivres();
                    break;
                case 4:
                    afficherTousLesLivres();
                    break;
            }
        } while (choice != 0);
            
        
    }

    private static void ajouterLivre() throws SQLException {
        System.out.print("Nombre de pages : ");
                        int nbPages = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("Langue : ");
                        String langue = scanner.next();

                        System.out.print("ISBN : ");
                        String isbn = scanner.next();

                        System.out.print("Titre : ");
                        String titre = scanner.next();

                        System.out.print("Editeur : ");
                        String editeur = scanner.next();

                        System.out.print("Année d'édition : ");
                        int anneeEdition = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("URL : ");
                        String url = scanner.next();

                        System.out.print("Favori : ");
                        int favori = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("Recommandé : ");
                        int recommande = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character*
                        System.out.println("donnez le nombre d'auteurs de ce livre ,attention il ne doit pas depasser 5");
                        int n=scanner.nextInt();
                        String Auteur1=null;
                        String Auteur2=null;
                        String Auteur3=null;
                        String Auteur4=null;
                        String Auteur5=null;
                        switch(n){
                            case 1:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                break;
                            case 2:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                break;
                            case 3:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur3=scanner.next();
                                break;
                            case 4:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur3=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur4=scanner.next();
                                break;
                            case 5:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur3=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur4=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur5=scanner.next();
                                break;
                                       
                        
        }
                        // Create a Livre object with user input
                        Livre nouveauLivre = new Livre(nbPages, langue, isbn, titre, editeur, anneeEdition, url, favori, recommande,Auteur1,Auteur2,Auteur3,Auteur4,Auteur5);

                        // Add the book to the database
                        boolean ajoutReussi = gestionLivre.ajouterLivre(nouveauLivre);

                        if (ajoutReussi) {
                            System.out.println("Livre ajouté avec succès à la base de données.");
                        } else {
                            System.out.println("Échec de l'ajout du livre à la base de données.");
                        }
    }

    private static void supprimerLivre() throws SQLException {
        System.out.print("ISBN : ");
                   String Isbn = scanner.next();
                   boolean SuppReussi = gestionLivre.supprimerLivre(Isbn);
                   if (SuppReussi) {
                            System.out.println("Livre supprime avec succès à la base de données.");
                        } else {
                            System.out.println("Échec de la suppression du livre à la base de données.");
                        }
    }

    private static void rechercheLivres() throws SQLException {
        int choiceR;
        do {
            System.out.println("\nRecherche de livres :");
            System.out.println("1. Recherche par nombre de pages");
            System.out.println("2. Recherche par langue");
            System.out.println("3. Recherche par ISBN");
            System.out.println("4. Recherche par titre");
            System.out.println("5. Recherche par éditeur");
            System.out.println("6. Recherche par année d'édition");
            System.out.println("7. Recherche par URL");
            System.out.println("8. Recherche par favori");
            System.out.println("9. Recherche par recommandé");
            System.out.println("0. Revenir au menu précédent");
            System.out.print("Choisissez une option (0-9) : ");
            choiceR = scanner.nextInt();

            switch (choiceR) {
                case 1:
                    System.out.print("Entrez le nombre de pages : ");
                    int searchNbPages = scanner.nextInt();
                    LinkedList<Livre> livresByNbPages = gestionLivre.getLivresByNbPages(searchNbPages);
                    afficherLivresResultat(livresByNbPages);
                    break;
                case 2:
                    
                    System.out.print("Entrez la langue : ");
                    String searchLangue = scanner.next();

                    LinkedList<Livre> livresByLangue = gestionLivre.getLivresByLangue(searchLangue);
                    System.out.println(livresByLangue);
                    break;
                   
                case 3:
                    
                    System.out.print("Entrez le ISBN : ");
                    String searchISBN = scanner.next();

                    LinkedList<Livre> livresByIsbn = gestionLivre.getLivresByISBN(searchISBN);
                    System.out.println(livresByIsbn);
                    break;
                case 4:
                    System.out.print("Entrez le titre : ");
                    String searchtitre = scanner.next();

                    LinkedList<Livre> livresBytitre = gestionLivre.getLivresByTitre(searchtitre);
                    System.out.println(livresBytitre);
                    break;
                case 5:
                    System.out.print("Entrez léditeur : ");
                    String searchéditeur = scanner.next();

                    LinkedList<Livre> livresByéditeur = gestionLivre.getLivresByEditeur(searchéditeur);
                    System.out.println(livresByéditeur);
                    break;
                case 6:
                    System.out.print("Entrez année d'édition : ");
                    int searchannéeédition = scanner.nextInt();

                    LinkedList<Livre> livresByannéeédition = gestionLivre.getLivresByAnneeEdition(searchannéeédition);
                    System.out.println(livresByannéeédition);
                    break;
                case 7:
                    System.out.print("Entrez URL : ");
                    String searchURL = scanner.next();
                    LinkedList<Livre> livresByURL = gestionLivre.getLivresByURL(searchURL);
                    System.out.println(livresByURL);
                    break;
                case 8:
                    System.out.print("Entrez favori : ");
                    int searchfavori = scanner.nextInt();

                    LinkedList<Livre> livresByfavori = gestionLivre.getLivresByFavorie(searchfavori);
                    System.out.println(livresByfavori);
                    break;
                case 9:
                    System.out.print("Entrez recommandé : ");
                    int searchrecommandé = scanner.nextInt();
                    LinkedList<Livre> livresByrecommandé = gestionLivre.getLivresByRecommande(searchrecommandé);
                    System.out.println(livresByrecommandé);
                    break;
            }
        } while (choiceR != 0);
    }

    private static void afficherTousLesLivres() throws SQLException {
        LinkedList<Livre> livres = gestionLivre.afficherTousLesLivres();
        System.out.println(livres);
    }
        private static void afficherLivresResultat(LinkedList<Livre> livres) {
        // TODO: Ajoutez le code pour afficher les livres résultat
        System.out.println(livres);
    }
     //=========================================gestion articles=============================
         private static void GestionArticles() throws SQLException {
        int choice;
        do {
            System.out.println("Bienvenue dans le programme de gestion des articles!");
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un article");
            System.out.println("2. Supprimer un article");
            System.out.println("3. Rechercher un article");
            System.out.println("4. Afficher tout article");
            System.out.println("0. Revenir au menu principal");
            System.out.print("Choisissez une option (0-4) : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ajouterArticle();
                    break;
                case 2:
                    supprimerArticle();
                    break;
                case 3:
                    rechercheArticle();
                    break;
                case 4:
                    afficherTousLesArticle();
                    break;
            }
        } while (choice != 0);
    }
         private static void ajouterArticle() throws SQLException {
     System.out.print("Rubrique : ");
                        String rubrique = scanner.next();

                        System.out.print("ISBN : ");
                        String isbn = scanner.next();

                        System.out.print("Titre : ");
                        String titre = scanner.next();

                        System.out.print("Editeur : ");
                        String editeur = scanner.next();

                        System.out.print("Année d'édition : ");
                        int anneeEdition = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("URL : ");
                        String url = scanner.next();

                        System.out.print("Favori : ");
                        int favori = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("Recommandé : ");
                        int recommande = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character*
                        System.out.println("donnez le nombre d'auteurs de ce article ,attention il ne doit pas depasser 5");
                        int n=scanner.nextInt();
                        String Auteur1=null;
                        String Auteur2=null;
                        String Auteur3=null;
                        String Auteur4=null;
                        String Auteur5=null;
                        switch(n){
                            case 1:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                break;
                            case 2:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                break;
                            case 3:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur3=scanner.next();
                                break;
                            case 4:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur3=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur4=scanner.next();
                                break;
                            case 5:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur3=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur4=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur5=scanner.next();
                                break;
                                       
                        
        }
                        // Create a Livre object with user input
                        Article nouveauArticle = new Article( rubrique, isbn, titre, editeur, anneeEdition, url, favori, recommande,Auteur1,Auteur2,Auteur3,Auteur4,Auteur5);

                        // Add the book to the database
                        boolean ajoutReussi = gestionArticle.ajouterArticle(nouveauArticle);

                        if (ajoutReussi) {
                            System.out.println("Livre ajouté avec succès à la base de données.");
                        } else {
                            System.out.println("Échec de l'ajout de l'article à la base de données.");
                        }
                           
    }

    private static void supprimerArticle() throws SQLException {
        System.out.print("ISBN : ");
                   String Isbn = scanner.next();
                   boolean SuppReussi = gestionArticle.supprimerArticle(Isbn);
                   if (SuppReussi) {
                            System.out.println("Articlee supprime avec succès à la base de données.");
                        } else {
                            System.out.println("Échec de la suppression du article à la base de données.");
                        }
    }
    private static void rechercheArticle() throws SQLException {
        int choiceR;
        do {
             System.out.println("1. Recherche par rubrique");
             System.out.println("2. Recherche par ISBN");
             System.out.println("3. Recherche par titre");
             System.out.println("4. Recherche par éditeur");
             System.out.println("5. Recherche par année d'édition");
             System.out.println("6. Recherche par URL");
             System.out.println("7. Recherche par favori");
             System.out.println("8. Recherche par recommandé");
             System.out.println("0. Revenir au menu précédent");
             System.out.print("Choisissez une option (0-9) : ");
            choiceR = scanner.nextInt();

            switch (choiceR) {
                case 1:
                    System.out.print("Entrez la rubrique : ");
                    String searchrubrique = scanner.next();

                    LinkedList<Article> ArticlesByrubrique = gestionArticle.getArticleByRubrique(searchrubrique);
                    System.out.println(ArticlesByrubrique );
                    break;
                case 2:
                    
                    System.out.print("Entrez la isbn : ");
                    String searchisbn = scanner.next();

                    LinkedList<Article> ArticlesByisbn = gestionArticle.getArticlesByISBN(searchisbn);
                    System.out.println(ArticlesByisbn);
                    break;
                   
                case 3:
                    
                    System.out.print("Entrez le titre : ");
                    String searchtitre = scanner.next();

                    LinkedList<Article> ArticlesBytitre = gestionArticle.getArticleByTitre(searchtitre);
                    System.out.println(ArticlesBytitre);
                    break;
                case 4:
                    System.out.print("Entrez le editeur : ");
                    String searchediteur = scanner.next();

                    LinkedList<Article> ArticlesByediteur = gestionArticle.getArticleByEditeur(searchediteur);
                    System.out.println(ArticlesByediteur);
                    break;
                case 5:
                    System.out.print("Entrez l'annee edition : ");
                    int searcheanneeedtion = scanner.nextInt();

                    LinkedList<Article> ArticlesByanneeedtion = gestionArticle.getArticleByAnneeEdition(searcheanneeedtion);
                    System.out.println(ArticlesByanneeedtion);
                    break;
                case 6:
                    System.out.print("Entrez URL ");
                    String searcheurl = scanner.next();

                    LinkedList<Article> ArticlesByurl = gestionArticle.getArticlesByURL(searcheurl);
                    System.out.println(ArticlesByurl);
                    break;
                case 7:
                    System.out.print("Entrez favorie ");
                    int searchefavorie = scanner.nextInt();

                    LinkedList<Article> ArticlesByfavorie = gestionArticle.getArticleByFavorie(searchefavorie);
                    System.out.println(ArticlesByfavorie);
                    break;
                case 8:
                    System.out.print("Entrez recommandé : ");
                    int searchrecommandé = scanner.nextInt();

                    LinkedList<Article> livresByrecommandé = gestionArticle.getArticlesByRecommande(searchrecommandé);
                    System.out.println(livresByrecommandé);
                    break;
                
            }
        } while (choiceR != 0);
    }
    private static void afficherTousLesArticle() throws SQLException {
        LinkedList<Article> articles = gestionArticle.afficherTousLesArticles();
        System.out.println(articles);
    }
 //==================================================GESTION DES MAGAZINS=========================================================================
    private static void GestionMagazin() throws SQLException {
        int choice;
        do {
            System.out.println("Bienvenue dans le programme de gestion des magazins!");
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un magazin");
            System.out.println("2. Supprimer un magazin");
            System.out.println("3. Rechercher un magazin");
            System.out.println("4. Afficher tout magazin");
            System.out.println("0. Revenir au menu magazin");
            System.out.print("Choisissez une option (0-4) : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ajoutermagazin();
                    break;
                case 2:
                    supprimermagazin();
                    break;
                case 3:
                    recherchemagazin();
                    break;
                case 4:
                    afficherTousLesmagazin();
                    break;
            }
        } while (choice != 0);
    }
         private static void ajoutermagazin() throws SQLException {
     System.out.print("Frequence De Publication : ");
                        String frequenceDePublication = scanner.next();
                        
                        System.out.print("Genre : ");
                        String genre = scanner.next();
                        
                        System.out.print("Numero De Mgazin : ");
                        int numeroDeMgazin = scanner.nextInt();
                        
                        System.out.print("ISBN : ");
                        String isbn = scanner.next();

                        System.out.print("Titre : ");
                        String titre = scanner.next();

                        System.out.print("Editeur : ");
                        String editeur = scanner.next();

                        System.out.print("Année d'édition : ");
                        int anneeEdition = scanner.nextInt();
                         // Consume the newline character

                        System.out.print("URL : ");
                        String url = scanner.next();

                        System.out.print("Favori : ");
                        int favori = scanner.nextInt();
                        

                        System.out.print("Recommandé : ");
                        int recommande = scanner.nextInt();
                        
                        System.out.println("donnez le nombre d'auteurs de ce livre ,attention il ne doit pas depasser 5");
                        int n=scanner.nextInt();
                        String Auteur1=null;
                        String Auteur2=null;
                        String Auteur3=null;
                        String Auteur4=null;
                        String Auteur5=null;
                        switch(n){
                            case 1:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                break;
                            case 2:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                break;
                            case 3:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur3=scanner.next();
                                break;
                            case 4:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur3=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur4=scanner.next();
                                break;
                            case 5:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur3=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur4=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur5=scanner.next();
                                break;
                                       
                        
        }
                        // Create a Livre object with user input
                        Magazin nouveauMagazin = new Magazin(frequenceDePublication, genre, numeroDeMgazin, isbn, titre, editeur, anneeEdition, url, favori, recommande,Auteur1,Auteur2,Auteur3,Auteur4,Auteur5);

                        // Add the book to the database
                        boolean ajoutReussi = gestionMagazin.ajouterMagazin(nouveauMagazin);

                        if (ajoutReussi) {
                            System.out.println("Magazin ajouté avec succès à la base de données.");
                        } else {
                            System.out.println("Échec de l'ajout du magazin à la base de données.");
                        }
                           
    }

    private static void supprimermagazin() throws SQLException {
        System.out.print("ISBN : ");
                   String Isbn = scanner.next();
                   boolean SuppReussi = gestionMagazin.supprimerMagazin(Isbn);
                   if (SuppReussi) {
                            System.out.println("Magazin supprime avec succès à la base de données.");
                        } else {
                            System.out.println("Échec de la suppression du magazin à la base de données.");
                        }
    }
    private static void recherchemagazin() throws SQLException {
        int choiceR;
        do {
             System.out.println("\nRecherche de magazines :");
                    System.out.println("1. Recherche par frequence de publication");
                    System.out.println("2. Recherche par ISBN");
                    System.out.println("3. Recherche par titre");
                    System.out.println("4. Recherche par éditeur");
                    System.out.println("5. Recherche par année d'édition");
                    System.out.println("6. Recherche par URL");
                    System.out.println("7. Recherche par favori");
                    System.out.println("8. Recherche par recommandé");
                    System.out.println("9. Recherche par genre");
                    System.out.println("10. Recherche par numero du magazin");
             System.out.print("Choisissez une option (0-9) : ");
            choiceR = scanner.nextInt();

            switch (choiceR) {
                case 1:
                    System.out.print("Entrez la frequence de publication : ");
                    String searchfreq = scanner.next();

                    LinkedList<Magazin> MagazinesByfreq = gestionMagazin.getArticleByFrequenceDePublication(searchfreq);
                    System.out.println(MagazinesByfreq );
                    break;
                case 2:
                    
                    System.out.print("Entrez la isbn : ");
                    String searchisbn = scanner.next();

                    LinkedList<Magazin> MagazinesByisbn = gestionMagazin.getMagazinsByISBN( searchisbn);
                    System.out.println(MagazinesByisbn);
                    break;
                   
                case 3:
                    
                    System.out.print("Entrez le titre : ");
                    String searchtitre = scanner.next();

                    LinkedList<Magazin> MagazinesBytitre = gestionMagazin.getMagazinsByTitre(searchtitre);
                    System.out.println(MagazinesBytitre);
                    break;
                case 4:
                    System.out.print("Entrez le editeur : ");
                    String searchediteur = scanner.next();

                    LinkedList<Magazin> MagazinesByediteur = gestionMagazin.getMagazinsByEditeur(searchediteur);
                    System.out.println(MagazinesByediteur);
                    break;
                case 5:
                    System.out.print("Entrez l'annee edition : ");
                    int searcheanneeedtion = scanner.nextInt();

                    LinkedList<Magazin> MagazinesByanneeedtion = gestionMagazin.getMagazinsByAnneeEdition(searcheanneeedtion);
                    System.out.println(MagazinesByanneeedtion);
                    break;
                case 6:
                    System.out.print("Entrez URL ");
                    String searcheurl = scanner.next();

                    LinkedList<Magazin> MagazinesByurl = gestionMagazin.getMagazinsByURL(searcheurl);
                    System.out.println(MagazinesByurl);
                    break;
                case 7:
                    System.out.print("Entrez favorie ");
                    int searchefavorie = scanner.nextInt();

                    LinkedList<Magazin> MagazinesByfavorie = gestionMagazin.getMagazinsByFavorie(searchefavorie);
                    System.out.println(MagazinesByfavorie);
                    break;
                case 8:
                    System.out.print("Entrez recommandé : ");
                    int searchrecommandé = scanner.nextInt();

                    LinkedList<Magazin> MagazinesByrecommandé = gestionMagazin.getMagazinsByRecommande(searchrecommandé);
                    System.out.println(MagazinesByrecommandé);
                    break;
                case 9:
                    
                    System.out.print("Entrez le genre : ");
                    
                    String searchregenre = scanner.next();

                    LinkedList<Magazin> MagazinesBygenre = gestionMagazin.getArticleByGenre(searchregenre);
                    System.out.println(MagazinesBygenre);
                    break; 
                    
                case 10:
                    
                    System.out.print("Entrez numero De Mgazin : ");
                    int searchrenumeroDeMgazin = scanner.nextInt();

                    LinkedList<Magazin> MagazinesBysearchrenumeroDeMgazin = gestionMagazin.getArticleByNumeroDeMgazin(searchrenumeroDeMgazin);
                    System.out.println(MagazinesBysearchrenumeroDeMgazin);
                    break;
                
            }
        } while (choiceR != 0);
    }
    private static void afficherTousLesmagazin() throws SQLException {
        LinkedList<Magazin> magazines = gestionMagazin.afficherTousLesMagazins();
        System.out.println(magazines);
    }
 //===============================================Gestion Roman==================================================================
    private static void GestionRoman() throws SQLException {
        int choice;
        do {
            System.out.println("Bienvenue dans le programme de gestion des Roman!");
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un Roman");
            System.out.println("2. Supprimer un Roman");
            System.out.println("3. Rechercher un Roman");
            System.out.println("4. Afficher tout Roman");
            System.out.println("0. Revenir au menu Roman");
            System.out.print("Choisissez une option (0-4) : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ajouterRoman();
                    break;
                case 2:
                    supprimerRoman();
                    break;
                case 3:
                    rechercheRoman();
                    break;
                case 4:
                    afficherTousLesRoman();
                    break;
            }
        } while (choice != 0);
    }
         private static void ajouterRoman() throws SQLException {
     System.out.print("genre : ");
                        String genre = scanner.next();
                        

                        System.out.print("Nombre Chapitres : ");
                        int NbChapitres = scanner.nextInt();

                        System.out.print("ISBN : ");
                        String isbn = scanner.next();

                        System.out.print("Titre : ");
                        String titre = scanner.next();

                        System.out.print("Editeur : ");
                        String editeur = scanner.next();

                        System.out.print("Année d'édition : ");
                        int anneeEdition = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("URL : ");
                        String url = scanner.next();

                        System.out.print("Favori : ");
                        int favori = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("Recommandé : ");
                        int recommande = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character*
                        System.out.println("donnez le nombre d'auteurs de ce Roman ,attention il ne doit pas depasser 5");
                        int n=scanner.nextInt();
                        String Auteur1=null;
                        String Auteur2=null;
                        String Auteur3=null;
                        String Auteur4=null;
                        String Auteur5=null;
                        switch(n){
                            case 1:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                break;
                            case 2:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                break;
                            case 3:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur3=scanner.next();
                                break;
                            case 4:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur3=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur4=scanner.next();
                                break;
                            case 5:
                                System.out.println("entrez le nom de l'auteur");
                                Auteur1=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur2=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur3=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur4=scanner.next();
                                System.out.println("entrez le nom de l'auteur");
                                Auteur5=scanner.next();
                                break;
                                       
                        
        }
                        // Create a Livre object with user input
                        Roman nouveauRoman = new Roman(genre,NbChapitres, isbn, titre, editeur, anneeEdition, url, favori, recommande,Auteur1,Auteur2,Auteur3,Auteur4,Auteur5);

                        // Add the book to the database
                        boolean ajoutReussi = gestionRoman.ajouterRoman(nouveauRoman);

                        if (ajoutReussi) {
                            System.out.println("Roman ajouté avec succès à la base de données.");
                        } else {
                            System.out.println("Échec de l'ajout du Roman à la base de données.");
                        }
                           
    }

    private static void supprimerRoman() throws SQLException {
        System.out.print("ISBN : ");
                   String Isbn = scanner.next();
                   boolean SuppReussi = gestionRoman.supprimerRoman(Isbn);
                   if (SuppReussi) {
                            System.out.println("Roman supprime avec succès à la base de données.");
                        } else {
                            System.out.println("Échec de la suppression du Roman à la base de données.");
                        }
    }
    private static void rechercheRoman() throws SQLException {
        int choiceR;
        do {
                    System.out.println("\nRecherche de romans :");
                    System.out.println("\nRecherche de Roman :");
                    System.out.println("1. Recherche par genre");
                    System.out.println("2. Recherche par nombre de chapitres");
                    System.out.println("3. Recherche par ISBN");
                    System.out.println("4. Recherche par titre");
                    System.out.println("5. Recherche par éditeur");
                    System.out.println("6. Recherche par année d'édition");
                    System.out.println("7. Recherche par URL");
                    System.out.println("8. Recherche par favori");
                    System.out.println("9. Recherche par recommandé");
             System.out.print("Choisissez une option (0-9) : ");
            choiceR = scanner.nextInt();

            switch (choiceR) {
                case 1:
                    System.out.print("Entrez le genre : ");
                    String genree = scanner.next();
                     

                    LinkedList<Roman> RomanByNbPages = gestionRoman.getRomanByGenre(genree);
                    System.out.println(RomanByNbPages);
                    break;
                case 2:
                    
                    System.out.print("Entrez le nombre de chapitres : ");
                    int nbChapitres= scanner.nextInt();

                    LinkedList<Roman> RomanBynbchapitres = gestionRoman.getRomansByNBChapitres(nbChapitres);
                    System.out.println(RomanBynbchapitres);
                    break;
                   
                case 3:
                    
                    System.out.print("Entrez le ISBN : ");
                    String searchISBN = scanner.next();

                    LinkedList<Roman> RomansByIsbn = gestionRoman.getRomansByISBN(searchISBN);
                    System.out.println(RomansByIsbn);
                    break;
                case 4:
                    System.out.print("Entrez le titre : ");
                    String searchtitre = scanner.next();

                    LinkedList<Roman> RomansBytitre = gestionRoman.getRomansByTitre(searchtitre);
                    System.out.println(RomansBytitre);
                    break;
                case 5:
                    System.out.print("Entrez léditeur : ");
                    String searchéditeur = scanner.next();

                    LinkedList<Roman> RomansByéditeur = gestionRoman.getRomansByEditeur(searchéditeur);
                    System.out.println(RomansByéditeur);
                    break;
                case 6:
                    System.out.print("Entrez année d'édition : ");
                    int searchannéeédition = scanner.nextInt();

                    LinkedList<Roman> RomanByannéeédition = gestionRoman.getRomansByAnneeEdition(searchannéeédition);
                    System.out.println(RomanByannéeédition);
                    break;
                case 7:
                    System.out.print("Entrez URL : ");
                    String searchURL = scanner.next();

                    LinkedList<Roman> RomansByURL = gestionRoman.getRomansByURL(searchURL);
                    System.out.println(RomansByURL);
                    break;
                case 8:
                    System.out.print("Entrez favori : ");
                    int searchfavori = scanner.nextInt();

                    LinkedList<Roman> RomansByfavori = gestionRoman.getRomansByFavorie(searchfavori);
                    System.out.println(RomansByfavori);
                    break;
                case 9:
                    
                    System.out.print("Entrez recommandé : ");
                    int searchrecommandé = scanner.nextInt();
                    LinkedList<Roman> RomansByrecommandé = gestionRoman.getRomansByRecommande(searchrecommandé);
                    System.out.println(RomansByrecommandé);
                    break; 
                    
                
                
            }
        } while (choiceR != 0);
    }
    private static void afficherTousLesRoman() throws SQLException {
        LinkedList<Roman> Romans = gestionRoman.afficherTousLesRomans();
        System.out.println(Romans);
    }
    
    
    
    
    //==================================================GESTION CLIENT+++++++++++++++++++++++++++++++++++++++++++++++++++
    
    private static void GestionClient() throws SQLException {
        int choice;
        do {
            System.out.println("Bienvenue dans le programme de gestion de clients!");
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un Client");
            System.out.println("2. Supprimer un Client");
            System.out.println("3. Rechercher un Client");
            System.out.println("4. Afficher tout Client");
            System.out.println("0. Revenir au menu principal");
            System.out.print("Choisissez une option (0-4) : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ajouterClient();
                    break;
                case 2:
                    supprimerClient();
                    break;
                case 3:
                    rechercheClient();
                    break;
                case 4:
                    afficherTousLesClient();
                    break;
            }
        } while (choice != 0);
            
        
    }

    private static void ajouterClient() throws SQLException {

                        System.out.print("matricule Client : ");
                        String matriculeClient = scanner.next();

                        System.out.print("nom : ");
                        String nom = scanner.next();

                        System.out.print("prenom : ");
                        String prenom = scanner.next();

                        System.out.print("typeAbonnement : ");
                        String typeAbonnement = scanner.next();

                        

                        System.out.print("motDePasse : ");
                        String motDePasse = scanner.next();

                        Client nouveauClient = new Client( matriculeClient,  nom,  prenom,  typeAbonnement,  motDePasse) ;

                        // Add the book to the database
                        boolean ajoutReussi =gestionClient.ajouterClient(nouveauClient);

                        if (ajoutReussi) {
                            System.out.println("Client ajouté avec succès à la base de données.");
                        } else {
                            System.out.println("Échec de l'ajout du Client à la base de données.");
                        }
    }

    private static void supprimerClient() throws SQLException {
        System.out.print("Matricule : ");
                   String Matricule = scanner.next();
                   boolean SuppReussi = gestionClient.supprimerClient(Matricule);
                   if (SuppReussi) {
                            System.out.println("Client supprime avec succès à la base de données.");
                        } else {
                            System.out.println("Échec de la suppression du Client à la base de données.");
                        }
    }

    private static void rechercheClient() throws SQLException {
        int choiceR;
        do {
            System.out.println("\nRecherche de clients :");
            System.out.println("1. Recherche par matricule");
            System.out.println("2. Recherche par Nom");
            System.out.println("3. Recherche par prenom");
            System.out.println("4. Recherche par abonnement");
            System.out.println("0. Revenir au menu précédent");
            System.out.print("Choisissez une option (0-9) : ");
            choiceR = scanner.nextInt();

            switch (choiceR) {
                case 1:
                    System.out.print("Entrez la matricule : ");
                    String matricule = scanner.next();
                    LinkedList<Client> matrciules = gestionClient.getclientByMatriculeClient(matricule);
                    System.out.println(matrciules);
                    break;
                case 2:
                    
                    System.out.print("Entrez le nom : ");
                    String nom = scanner.next();

                    LinkedList<Client> clients = gestionClient.getclientByNom(nom);
                    System.out.println(clients);
                    break;
                   
                case 3:
                    
                    System.out.print("Entrez le prenom : ");
                    String prenom = scanner.next();

                    LinkedList<Client> cliente = gestionClient.getclientByPrenom(prenom);
                    System.out.println(cliente);
                    break;
                case 4:
                    System.out.print("Entrez l abonnnement: ");
                    String abonnement = scanner.next();

                    LinkedList<Client> abonnements = gestionClient.getclientByTypeAbonnement(abonnement);
                    System.out.println(abonnements);
                    break;
                
        }} while (choiceR != 0);}
    

    private static void afficherTousLesClient() throws SQLException {
        LinkedList<Client> clients= gestionClient.getTousLesClients();
        System.out.println(clients);
    }
        private static void afficherClientResultat(LinkedList<Client> clients) {
        // TODO: Ajoutez le code pour afficher les livres résultat
        System.out.println(clients);
    }
 //============================================gestion kindeles=======================================================================
private static void GestionKindeles() throws SQLException {
        int choice;
        do {
            System.out.println("Bienvenue dans le programme de gestion de kindeles!");
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un Kindeles");
            System.out.println("2. Supprimer un Kindeles");
            System.out.println("3. Rechercher un Kindeles");
            System.out.println("4. Afficher tout Kindeles");
            System.out.println("0. Revenir au menu principal");
            System.out.print("Choisissez une option (0-4) : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ajouterKindeles();
                    break;
                case 2:
                    supprimerKindeles();
                    break;
                case 3:
                    rechercheKindeles();
                    break;
                case 4:
                    afficherTousLesKindeles();
                    break;
            }
        } while (choice != 0);
            
        
    }

    private static void ajouterKindeles() throws SQLException {

                        System.out.print("id kindeles : ");
                        String idekindeles = scanner.next();

                        System.out.print("taille ecran : ");
                        String tailleEcran = scanner.next();

                        System.out.print("taille stockage : ");
                        String tailleStockage = scanner.next();

                        System.out.print("modele : ");
                        String modele = scanner.next();

                       Kindles nouveauaKindeles = new  Kindles( idekindeles,  tailleEcran, tailleStockage,  modele) ;

                        // Add the book to the database
                        boolean ajoutReussi =gestionKindeles.ajouterKindle(nouveauaKindeles);

                        if (ajoutReussi) {
                            System.out.println("Kindeles ajouté avec succès à la base de données.");
                        } else {
                            System.out.println("Échec de l'ajout du Kindeles à la base de données.");
                        }
    }

    private static void supprimerKindeles() throws SQLException {
        System.out.print("id kindeles : ");
                   String ideKindeles = scanner.next();
                   boolean SuppReussi = gestionKindeles.supprimerKindle(ideKindeles);
                   if (SuppReussi) {
                            System.out.println("Kindeles supprime avec succès à la base de données.");
                        } else {
                            System.out.println("Échec de la suppression du Kindeles à la base de données.");
                        }
    }

    private static void rechercheKindeles() throws SQLException {
        int choiceR;
        do {
            System.out.println("\nRecherche de Kindeles :");
            System.out.println("1. Recherche par idKindeles");
            System.out.println("2. Recherche par TailleEcran");
            System.out.println("3. Recherche par TailleStockage");
            System.out.println("4. Recherche par modele");
            System.out.println("0. Revenir au menu précédent");
            System.out.print("Choisissez une option (0-9) : ");
            choiceR = scanner.nextInt();

            switch (choiceR) {
                case 1:
                    System.out.print("Entrez le idKindeles : ");
                    String idkindeles = scanner.next();
                    LinkedList<Kindles> indeless = gestionKindeles.getKindlesById(idkindeles);
                    System.out.println(indeless );
                    break;
                case 2:
                    
                    System.out.print("Entrez la taille ecran : ");
                    String tailleecran = scanner.next();

                    LinkedList<Kindles> tailles = gestionKindeles.getKindlesByTailleEcran(tailleecran);
                    System.out.println(tailles);
                    break;
                   
                case 3:
                    
                    System.out.print("Entrez la taile de stockage : ");
                    String tailleStockge = scanner.next();

                    LinkedList<Kindles> Stockges = gestionKindeles.getKindlesByTailleStockage(tailleStockge);
                    System.out.println(Stockges);
                    break;
                case 4:
                    System.out.print("Entrez le modele: ");
                    String modele = scanner.next();

                    LinkedList<Kindles> modeles = gestionKindeles.getKindlesByModele(modele);
                    System.out.println(modeles);
                    break;
                
        }} while (choiceR != 0);}
    

    private static void  afficherTousLesKindeles() throws SQLException {
        LinkedList<Kindles> kindles= gestionKindeles.afficherTousLesKindles();
        System.out.println(kindles);
    }
        //=========================================================GEstion Kindles+++++++++++++++++++++++++++++++++++++
        private static void GestionEmprunts() throws SQLException {
        int choice;
        do {
            System.out.println("Bienvenue dans le programme de gestion des Emprunts!");
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un Emprunt");
            System.out.println("2. Supprimer un Emprunt");
            System.out.println("3. Rechercher un Emprunt");
            System.out.println("4. Afficher tout Emprunt");
            System.out.println("0. Revenir au menu Emprunt");
            System.out.print("Choisissez une option (0-4) : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ajouterEmprunt();
                    break;
                case 2:
                    supprimerEmprunt();
                    break;
                case 3:
                    rechercheEmprunt();
                    break;
                case 4:
                    afficherTousLesEmprunts();
                    break;
            }
        } while (choice != 0);
            
        
    }

    private static void ajouterEmprunt() throws SQLException {

                        System.out.print("matricule Client : ");
                        String matriculeClient = scanner.next();

                        System.out.print("id Kindles : ");
                        String idKindles = scanner.next();

                        System.out.print(" dateEmprunt : ");
                        String dateEmprunt = scanner.next();

                       
                       Emprunt nouveauEmprunts = new  Emprunt( matriculeClient,  idKindles, dateEmprunt) ;

                        // Add the book to the database
                        boolean ajoutReussi =gestionEmprunts.ajouterEmprunt(nouveauEmprunts);

                        if (ajoutReussi) {
                            System.out.println("Emprunt ajouté avec succès à la base de données.");
                        } else {
                            System.out.println("Échec de l'ajout du Emprunt à la base de données.");
                        }
    }

    private static void supprimerEmprunt() throws SQLException {
        System.out.print("id Emprunt : ");
                   String idEmprunt = scanner.next();
                   System.out.print("matriculeClient : ");
                   String matriculeClient = scanner.next();
                   boolean SuppReussi = gestionEmprunts.supprimerEmprunt(matriculeClient, idEmprunt);
                   if (SuppReussi) {
                            System.out.println("Emprunt supprime avec succès à la base de données.");
                        } else {
                            System.out.println("Échec de la suppression du Emprunt à la base de données.");
                        }
    }

    private static void rechercheEmprunt() throws SQLException {
        int choiceR;
        do {
            System.out.println("\nRecherche de Emprunt :");
            System.out.println("1. Recherche par MatriculeClient");
            System.out.println("2. Recherche par IdKindles");
            
            System.out.print("Choisissez une option (0-2) : ");
            choiceR = scanner.nextInt();

            switch (choiceR) {
                case 1:
                    System.out.print("Entrez le MatriculeClient : ");
                    String MatriculeClient = scanner.next();
                    LinkedList<Emprunt> Emprunt = gestionEmprunts.getEmpruntsByMatriculeClient(MatriculeClient);
                    System.out.println(Emprunt );
                    break;
                case 2:
                    
                    System.out.print("Entrez l IdKindles : ");
                    String IdKindles1 = scanner.next();

                    LinkedList<Emprunt> IdKindles = gestionEmprunts.getEmpruntsByIdKindles(IdKindles1);
                    System.out.println(IdKindles);
                    break;
                   
               
                
                
        }} while (choiceR != 0);}
    

    private static void  afficherTousLesEmprunts() throws SQLException {
        LinkedList<Emprunt> Emprunts= gestionEmprunts.afficherTousLesEmprunts();
        System.out.println(Emprunts);
    }
        
}
