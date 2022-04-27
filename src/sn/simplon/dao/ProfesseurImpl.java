package sn.simplon.dao;
import sn.simplon.entities.Professeur;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfesseurImpl implements IProfesseur{
    Professeur professeur = new Professeur();
    DB db = new DB();
    private int ok;
    private ResultSet rs;
    @Override
    public int add(Professeur professeur) {
        String sql = "INSERT INTO professeur VALUES (NULL, ?, ?, ?, ?)";
        try {
           db.initPrepar(sql);
           db.getPstm().setString(1, professeur.getNom());
           db.getPstm().setString(2, professeur.getPrenom());
           db.getPstm().setString(3, professeur.getEmail());
           db.getPstm().setString(4, professeur.getTelephone());
         ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        if (ok == 1 ){
            System.out.println("Le professeur "+professeur.getPrenom()+" "+professeur.getNom()+" a été bien inséré dans la base de données");System.out.println("Le professeur "+professeur.getPrenom()+" "+professeur.getNom()+" a été bien inséré dans la base de données");
        }else {
            System.out.println("Insertion échouée");
        }
        return ok;
    }

    @Override
    public List<Professeur> listeProfesseur() {
        List<Professeur> professeurs = new ArrayList<Professeur>();
        String sql = "SELECT * FROM professeur";
        try {
            db.initPrepar(sql);
            rs = db.executeSelect();
            while (rs.next()){
                Professeur professeur = new Professeur();
                professeur.setId(rs.getInt(1));
                professeur.setNom(rs.getString(2));
                professeur.setPrenom(rs.getString(3));
                professeur.setEmail(rs.getString(4));
                professeur.setTelephone(rs.getString(5));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return professeurs;
    }

    @Override
    public int update(Professeur professeur) {
        return 0;
    }

    Scanner sc = new Scanner(System.in);
    @Override
    public Professeur saisieProf() {
        Professeur professeur = new Professeur();
        System.out.println("\n------- SAISIE PROFESSEUR -------\n");
        System.out.println("Saisissez le nom du professeur");
        professeur.setNom(sc.nextLine());
        System.out.println("Saisissiez le prenom");
        professeur.setPrenom(sc.nextLine());
        System.out.println("Saisissez son email ");
        professeur.setEmail(sc.nextLine());
        System.out.println("Saisissez son numero Telephone");
        professeur.setTelephone(sc.nextLine());
        return professeur;
    }
}
