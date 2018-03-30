package com.m2i.tp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.m2i.tp.entity.Departement;

public class DepartementDaoJdbc implements DepartementDAO {
	
	private Connection etablirConnexion(){
		Connection cn =null;
		//chargement des valeurs de paramDB.properties :
		ResourceBundle ressources = ResourceBundle.getBundle("paramDB"); 
		String driver = ressources.getString("driver");
		String url = ressources.getString("url");
		String username = ressources.getString("username");
		String password = ressources.getString("password");
		try {
			Class.forName(driver); //charger en mémoire la classe principale du .jar (driver JDBC)
			cn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.err.println("erreur le driver JDBC est introuvable . driver JDBC .jar manquant ou invalide");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("erreur de connexion à la base de donnée");
			e.printStackTrace();
		}
		return cn; 
	}
	
	static void closeCn(Connection cn){
		try { cn.close(); } catch (SQLException e) {e.printStackTrace();}
	}
	
	private void extractDepartementValuesFromResultSetRow(ResultSet rs,Departement dep){
		try {
			dep.setNumero(rs.getString("numero")); dep.setNom(rs.getString("nom"));
			dep.setPrefecture(rs.getString("prefecture"));
			dep.setPopulation(rs.getInt("population"));	dep.setSuperficie(rs.getInt("superficie"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Departement> rechercherTousDepartements() {
		List<Departement> listeDep = new ArrayList<Departement>();
		Connection cn = null;
		try {
			cn = this.etablirConnexion();
			Statement st = cn.createStatement();  String reqSql = "SELECT * FROM Departement";
			ResultSet rs = st.executeQuery(reqSql);
			while(rs.next()){
				Departement dep = new Departement();
				extractDepartementValuesFromResultSetRow(rs,dep);
				listeDep.add(dep);
			}
			rs.close(); st.close(); //fermetures dans l'ordre inverse des ouvertures/créations
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeCn(cn);//ferme la connexion ou bien la rend dans un pool de connexions recyclables
		}
		return listeDep;
	}

	@Override
	public List<Departement> departementsSelonRegion(String numRegion) {
		List<Departement> listeDep = new ArrayList<Departement>();
		Connection cn = null;
		try {
			cn = this.etablirConnexion();
			//chaque ? correspond à un paramètre variable .
			String reqSql = "SELECT * FROM Departement WHERE refRegion=?";
			PreparedStatement pst = cn.prepareStatement(reqSql);  
		    pst.setString(1, numRegion);//le 1 correspond au numéro d'ordre du ? qui sera remplacé
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Departement dep = new Departement();
				extractDepartementValuesFromResultSetRow(rs,dep);
				listeDep.add(dep);
			}
			rs.close(); pst.close(); //fermetures dans l'ordre inverse des ouvertures/créations
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeCn(cn);//ferme la connexion ou bien la rend dans un pool de connexions recyclables
		}
		return listeDep;
	}

	@Override
	public Departement departementSelonNumero(String numDep) {
		Departement dep = null;
		Connection cn = null;
		try {
			cn = this.etablirConnexion();
			//chaque ? correspond à un paramètre variable .
			String reqSql = "SELECT * FROM Departement WHERE numero=?";
			PreparedStatement pst = cn.prepareStatement(reqSql);  
		    pst.setString(1, numDep);//le 1 correspond au numéro d'ordre du ? qui sera remplacé
			ResultSet rs = pst.executeQuery();
			/*while*/ 
			if(rs.next()){
				dep = new Departement();
				extractDepartementValuesFromResultSetRow(rs,dep);
			}
			rs.close(); pst.close(); //fermetures dans l'ordre inverse des ouvertures/créations
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeCn(cn);//ferme la connexion ou bien la rend dans un pool de connexions recyclables
		}
		return dep;
	}

	@Override
	public void ajouterDepartement(Departement dep) {
		Connection cn = null;
		try {
			cn = this.etablirConnexion();
			//chaque ? correspond à un paramètre variable .
			String reqSql = "INSERT INTO Departement(numero,nom,prefecture,population,superficie,refRegion) "
					    + " VALUES(?,?,?,?,?,?)";
			PreparedStatement pst = cn.prepareStatement(reqSql);  
		    pst.setString(1, dep.getNumero());//le 1 correspond au numéro d'ordre du ? qui sera remplacé
		    pst.setString(2, dep.getNom());
		    pst.setString(3, dep.getPrefecture());
		    pst.setInt(4, dep.getPopulation());
		    pst.setInt(5, dep.getSuperficie());
		    pst.setString(6, null);
		    int nbLignes = pst.executeUpdate();
		    System.out.println("nb ligne(s) ajoutee(s) en base:" + nbLignes);
		    pst.close(); //fermetures dans l'ordre inverse des ouvertures/créations
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeCn(cn);//ferme la connexion ou bien la rend dans un pool de connexions recyclables
		}
	}

	@Override
	public void modifierDepartement(Departement dep) {
		Connection cn = null;
		try {
			cn = this.etablirConnexion();
			//chaque ? correspond à un paramètre variable .
			String reqSql = "UPDATE Departement SET nom=?,prefecture=?,population=?,superficie=?,refRegion=? "
					    + " WHERE numero=?";
			PreparedStatement pst = cn.prepareStatement(reqSql);  
		    pst.setString(1, dep.getNom());//le 1 correspond au numéro d'ordre du ? qui sera remplacé
		    pst.setString(2, dep.getPrefecture());
		    pst.setInt(3, dep.getPopulation());
		    pst.setInt(4, dep.getSuperficie());
		    pst.setString(5, null);
		    pst.setString(6, dep.getNumero());
		    int nbLignes = pst.executeUpdate();
		    System.out.println("nb ligne(s) modifiee(s) en base:" + nbLignes);
		    pst.close(); //fermetures dans l'ordre inverse des ouvertures/créations
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeCn(cn);//ferme la connexion ou bien la rend dans un pool de connexions recyclables
		}
	}

	@Override
	public void supprimerDepartement(String numDep) {
		Connection cn = null;
		try {
			cn = this.etablirConnexion();
			//chaque ? correspond à un paramètre variable .
			String reqSql = "DELETE FROM Departement WHERE numero=?";
			PreparedStatement pst = cn.prepareStatement(reqSql);  
		    pst.setString(1, numDep);//le 1 correspond au numéro d'ordre du ? qui sera remplacé
		    int nbLignes = pst.executeUpdate();
		    System.out.println("nb ligne supprimee en base:" + nbLignes);
		    pst.close(); //fermetures dans l'ordre inverse des ouvertures/créations
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeCn(cn);//ferme la connexion ou bien la rend dans un pool de connexions recyclables
		}
	}

}
