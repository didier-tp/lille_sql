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
 *
 */
public interface DepartementDAO {
	public List<Departement> rechercherTousDepartements();
	

}
