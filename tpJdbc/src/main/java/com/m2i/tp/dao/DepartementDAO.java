package com.m2i.tp.dao;

import java.util.List;

import com.m2i.tp.entity.Departement;

/**
 * 
 * @author Formation
 *
 * DAO = Data Access Object = composant java spécialisé dans l'accès aux données
 * avec méthodes CRUD 
 * implémentations possibles : DepartementDaoJdbc
 *                             DepartementDaoJpaHibernate
 *                             ....
 * avec throws RuntimeException implicites
 */
public interface DepartementDAO {
	public List<Departement> rechercherTousDepartements();
	public List<Departement> departementsSelonRegion(int numRegion);
	public Departement departementSelonNumero(String numDep);
	
	public void ajouterDepartement(Departement dep);
	public void modifierDepartement(Departement dep);
	public void supprimerDepartement(String numDep);
	
    //...
}
