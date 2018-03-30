package com.m2i.tp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.m2i.tp.entity.Film;

public class FilmDaoJdbc implements FilmDAO {
	
	private Connection etablirConnexion(){
		Connection cn =null;
		//chargement des valeurs de paramDB.properties :
		ResourceBundle ressources = ResourceBundle.getBundle("paramDB"); 
		String driver = ressources.getString("driver");
		String url = ressources.getString("url2");
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
	
	//cette methode doit etre appelee juste apres pst.executeUpdate();
	static Integer recupererClefPrimaireAutoIncrementee(PreparedStatement pst){
		Integer pk=null;
		try {
			ResultSet rsKeys = pst.getGeneratedKeys();
			if(rsKeys.next()){
				pk=rsKeys.getInt(1);//pour ici une clef primaire sur une seule colonne de type Integer
			} rsKeys.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk;
	}

	@Override
	public Film ajouterFilm(Film f) {
		Connection cn = null;
		try {
			cn = this.etablirConnexion();
			//chaque ? correspond à un paramètre variable .
			String reqSql = "INSERT INTO Film(titre, dateSortie) VALUES(?,?)";
			PreparedStatement pst = cn.prepareStatement(reqSql);  
		    pst.setString(1, f.getTitre());//le 1 correspond au numéro d'ordre du ? qui sera remplacé
		    pst.setDate(2, new java.sql.Date(f.getDateSortie().getTime()));
		    int nbLignes = pst.executeUpdate();
		    f.setId(recupererClefPrimaireAutoIncrementee(pst));
		    System.out.println("nb ligne(s) ajoutee(s) en base:" + nbLignes);
		    pst.close(); //fermetures dans l'ordre inverse des ouvertures/créations
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeCn(cn);//ferme la connexion ou bien la rend dans un pool de connexions recyclables
		}
		return f;
	}

}
