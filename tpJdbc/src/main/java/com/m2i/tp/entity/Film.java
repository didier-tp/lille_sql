package com.m2i.tp.entity;

import java.util.Date;

public class Film {
   private Integer id; //avec auto_increment en base
           //Integer à null par défaut , int à 0 par défaut
   private String titre;
   private Date dateSortie;
   //+get/set , +constructeur(s) , +toString()
   public Film() {
		super();
	}
   
   public Film(Integer id, String titre, Date dateSortie) {
		super();
		this.id = id;
		this.titre = titre;
		this.dateSortie = dateSortie;
	}   
   
@Override
public String toString() {
	return "Film [id=" + id + ", titre=" + titre + ", dateSortie=" + dateSortie + "]";
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public Date getDateSortie() {
	return dateSortie;
}
public void setDateSortie(Date dateSortie) {
	this.dateSortie = dateSortie;
}
   
   
   
}
