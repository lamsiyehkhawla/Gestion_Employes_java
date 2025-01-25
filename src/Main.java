import java.util.Scanner;
public class Main {
    // Méthode principale pour exécuter le programme
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choix = -1; // Initialisation de la variable pour le choix de l'utilisateur

        while (choix != 0) { // Boucle principale
            GestionEmployes.printMenu(); // Affiche le menu
            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt(); // Récupère l'option choisie
            scanner.nextLine(); // Consomme la ligne restante

            if (choix == 1) { // Ajouter un employé
                System.out.print("ID : ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consomme la ligne restante
                System.out.print("Nom : ");
                String nom = scanner.nextLine();
                System.out.print("Poste : ");
                String poste = scanner.nextLine();
                System.out.print("Salaire : ");
                double salaire = scanner.nextDouble();
                GestionEmployes.ajouterEmploye(new Employe(id, nom, poste, salaire));
            } else if (choix == 2) { // Modifier un employé
                System.out.print("ID de l'employé à modifier : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nouveau nom : ");
                String nom = scanner.nextLine();
                System.out.print("Nouveau poste : ");
                String poste = scanner.nextLine();
                System.out.print("Nouveau salaire : ");
                double salaire = scanner.nextDouble();
                GestionEmployes.modifierEmploye(id, nom, poste, salaire);
            } else if (choix == 3) { // Supprimer un employé
                System.out.print("ID de l'employé à supprimer : ");
                int id = scanner.nextInt();
                GestionEmployes.supprimerEmploye(id);
            } else if (choix == 4) { // Afficher tous les employés
                GestionEmployes.afficherEmployes();
            } else if (choix == 5) { // Rechercher un employé
                System.out.print("Rechercher par nom ou poste : ");
                String critere = scanner.nextLine();
                GestionEmployes.rechercherEmploye(critere);
            } else if (choix == 6) { // Calculer la masse salariale
                GestionEmployes.calculerMasseSalariale();
            } else if (choix == 7) { // Trier les employés par salaire
                System.out.print("Trier par salaire croissant (true/false) : ");
                boolean ordreCroissant = scanner.nextBoolean();
                GestionEmployes.trierEmployesParSalaire(ordreCroissant);
            } else if (choix == 0) { // Quitter
                System.out.println("Au revoir !");
            } else {
                System.out.println("Option invalide. Veuillez réessayer.");
            }
        }

        scanner.close(); // Ferme le scanner
    }
}