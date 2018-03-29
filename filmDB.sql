# script SQL pour mySql
#DROP DATABASE IF EXISTS filmDB;
#CREATE DATABASE filmDB;

CREATE DATABASE IF NOT EXISTS filmDB ;

USE filmDB;

# DROP TABLE Dans ordre inverse des CREATE TABLE et/ou INSERT INTO si FOREIGN KEY CONSTRAINTS
DROP TABLE IF EXISTS Acteur_Film;
DROP TABLE IF EXISTS Acteur;
DROP TABLE IF EXISTS Film;

CREATE TABLE Film( 
    id INTEGER auto_increment PRIMARY KEY,
	titre VARCHAR(64) ,
	dateSortie Date
) ENGINE=InnoDB;
# via des quotes inversées , un nom de tables ou de colonne pourrait comporter
# des espaces ex `chef lieu`

CREATE TABLE Acteur( 
    id INTEGER  auto_increment PRIMARY KEY,
	nom VARCHAR(48) ,
	prenom VARCHAR(48),
	dateNaissance DATE
)ENGINE=InnoDB;

CREATE TABLE Acteur_Film( 
    idActeur INTEGER ,
	idFilm INTEGER ,
	role VARCHAR(48) ,
	CONSTRAINT Pk_acteur_film PRIMARY KEY(idActeur , idFilm),
	CONSTRAINT Fk_acteurValide FOREIGN KEY(idActeur) REFERENCES Acteur(id) ,
	CONSTRAINT Fk_filmValide FOREIGN KEY(idFilm) REFERENCES Film(id) 
)ENGINE=InnoDB;

INSERT INTO Film(id, titre , dateSortie ) 
      VALUES (1, "Film1" , "1990-02-25" ),
             (2, "Camping 1" , "2006-04-26" ),
			 (3, "Tous Debout" , "2018-03-15"  );
#ajout sans preciser id / auto_increment :			 
INSERT INTO Film(titre , dateSortie ) 
          VALUES ("Nouveau Film" , "2018-03-28");

INSERT INTO Acteur(id, nom , prenom , dateNaissance ) 
       VALUES (1, "Belmondo" , "Paul" , "1950-12-01"),
              (99, "Duboscq" , "Franck" , "1970-06-30" );									
			 			 
INSERT INTO Acteur_Film(idActeur, idFilm , role ) 
      VALUES (99,2,"campeur"),
	         (99,3,"faux handicape"),
			 (1, 1, "gendarme");			 
												
# affichage des donnees pour verifier:
SELECT * FROM Film;	
SELECT * FROM Acteur;
SELECT * FROM Acteur_Film;	

#Exemple de requete :
SELECT titre as titre_film_2018 FROM Film WHERE dateSortie BETWEEN "2018-01-01" AND "2018-12-31";

#Exemple de jointure :
SELECT Acteur.nom , role , Film.titre FROM Acteur_Film 
       JOIN Acteur ON Acteur_Film.idActeur = Acteur.id
       JOIN Film ON Acteur_Film.idFilm = Film.id;	   



