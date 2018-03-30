package com.m2i.tp.dao;

import com.m2i.tp.entity.Film;

public interface FilmDAO {
    //parametre en  entree : film dont l'id est encore inconnu (à null)
	//valeur de retour : copie ou une référence sur le film
	//comportant en plus l'id auto incrémenté par MySQL ou ...
   public Film ajouterFilm(Film f); 
   
   //autres methodes CRUD que l'on a pas le temps de coder
}
