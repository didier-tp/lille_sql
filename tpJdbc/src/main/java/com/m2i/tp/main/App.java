package com.m2i.tp.main;

import java.util.List;

import com.m2i.tp.dao.DepartementDaoJdbc;
import com.m2i.tp.entity.Departement;

public class App {

	public static void main(String[] args) {
		System.out.println("demarrage appli tpJdbc ...");
        DepartementDaoJdbc dao = new DepartementDaoJdbc();
        
        List<Departement> listeDep = dao.rechercherTousDepartements();
        System.out.println("liste de tous les departements:");
        for(Departement dep : listeDep){
        	System.out.println("\t" + dep.toString());
        }
        
        List<Departement> listeDep2 = dao.departementsSelonRegion("FR-HDF");
        System.out.println("departements de la region Hauts-De-France:");
        for(Departement dep : listeDep2){
        	System.out.println("\t" + dep.toString());
        }
        
        //Sequence de test:
        String pk="13bis";
        // 1. ajouter et verifier ajout
        Departement nouveauDep = new Departement(pk,"Bouches-du-Rhone","Marseille",1,1 /*,"FR-PAC" */);
        dao.ajouterDepartement(nouveauDep);
        Departement depReluEnBase = dao.departementSelonNumero(pk);
        System.out.println("departement ajoute: " + depReluEnBase.toString());
        // 2. modifier et verfier maj
        Departement depAModifier = depReluEnBase;
        depAModifier.setPopulation(2);
        depAModifier.setSuperficie(2);
        dao.modifierDepartement(depAModifier);
        depReluEnBase = dao.departementSelonNumero(pk);
        System.out.println("departement modifie: " + depReluEnBase.toString());
        // 3. supprimer et vérifier suppression
        dao.supprimerDepartement(pk);
        depReluEnBase = dao.departementSelonNumero(pk);
        if(depReluEnBase ==null){
        	System.out.println("departement bien supprimé");
        }
        
	}

}
