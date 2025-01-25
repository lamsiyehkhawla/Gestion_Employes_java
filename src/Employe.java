public class Employe {
    private int id;
    private String nom;
    private String poste;
    private double salaire;

    public Employe(int id, String nom, String poste, double salaire) {
        this.id = id;
        this.nom = nom;
        this.poste = poste;
        this.salaire = salaire;
    }
    // Getters et Setters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPoste() {
        return poste;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    // toString() pour afficher les détails
    @Override
    public String toString() {
        return "Employe{id=" + id + ", nom='" + nom + "', poste='" + poste + "', salaire=" + salaire + "}";
    }
}
