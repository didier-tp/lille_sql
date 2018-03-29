package com.m2i.tp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

	@Override
	public List<Departement> rechercherTousDepartements() {
		try {
			Connection cn = this.etablirConnexion();
			//...
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Departement> departementsSelonRegion(int numRegion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departement departementSelonNumero(String numDep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterDepartement(Departement dep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifierDepartement(Departement dep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerDepartement(String numDep) {
		// TODO Auto-generated method stub

	}

}
