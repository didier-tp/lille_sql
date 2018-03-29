package com.m2i.tp.main;

import com.m2i.tp.dao.DepartementDaoJdbc;

public class App {

	public static void main(String[] args) {
		System.out.println("demarrage appli tpJdbc ...");
        DepartementDaoJdbc dao = new DepartementDaoJdbc();
        dao.rechercherTousDepartements();
        //...
	}

}
