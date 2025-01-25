import java.util.Arrays;

public class GestionEmployes {
    // Tableau statique pour stocker les employés (limité à 50)
    private static Employe[] employes = new Employe[50];
    private static int nbEmployes = 0; // Compteur d'employés actuels

    // Méthode pour afficher le menu principal
    public static void printMenu(){
        System.out.println("\nMenu Principal :");
        System.out.println("1. Ajouter un employé");
        System.out.println("2. Modifier un employé");
        System.out.println("3. Supprimer un employé");
        System.out.println("4. Afficher tous les employés");
        System.out.println("5. Rechercher un employé");
        System.out.println("6. Calculer la masse salariale");
        System.out.println("7. Trier les employés par salaire");
        System.out.println("0. Quitter");

    }
    // Méthode pour ajouter un employé au tableau
    public static void ajouterEmploye(Employe emp){
        if (nbEmployes < employes.length){
            employes[nbEmployes++] = emp;
            System.out.println("Employe ajouté avec succes!");
        }
        else{
            System.out.println("Sorry !! : Tableau plein");
        }
    }
    // Méthode pour modifier les informations d'un employé existant
    public static void modifierEmploye(int id, String nvNom,String nvPoste, double nvSalaire) {
        for (int i = 0; i < nbEmployes; i++) {
            if (employes[i].getId() == id) {
                employes[i].setNom(nvNom);
                employes[i].setPoste(nvPoste);
                employes[i].setSalaire(nvSalaire);
                System.out.println("Employé modifié avec succès !");
                return;
            }
        }
        System.out.println("Employé non trouvé.");

    }
    // Méthode pour supprimer un employé par son ID
    public static void supprimerEmploye(int id) {
        for (int i = 0; i < nbEmployes; i++) {
            if (employes[i].getId() == id) {
                employes[i] = employes[--nbEmployes];
                employes[nbEmployes] = null;
                System.out.println("Employé supprimé avec succès !");
                return;
            }
        }
        System.out.println("Employé non trouvé.");
    }

    public static void afficherEmployes() {
        System.out.println("\nListe des employés :");
        for (int i = 0; i < nbEmployes; i++) {
            System.out.println(employes[i]);
        }
    }

    public static void rechercherEmploye(String critere) {
        boolean found = false;
        for (int i = 0; i < nbEmployes; i++) {
            if (employes[i].getNom().equalsIgnoreCase(critere) || employes[i].getPoste().equalsIgnoreCase(critere)) {
                System.out.println(employes[i]);
                found = true;
            }
        }
        if (!found) System.out.println("Aucun employé trouvé avec ce critère.");
    }

    public static void calculerMasseSalariale() {
        double totalSalaire = 0;
        for (int i = 0; i < nbEmployes; i++) {
            totalSalaire += employes[i].getSalaire();
        }
        System.out.println("Masse salariale totale : " + totalSalaire);
    }

    public static void trierEmployesParSalaire(boolean ordreCroissant) {
        Arrays.sort(employes, 0, nbEmployes, (e1, e2) -> {
            int compare = Employe.compareParSalaire(e1, e2);
            return ordreCroissant ? compare : -compare;
        });
        System.out.println("Employés triés par salaire :");
        afficherEmployes();
    }

}
