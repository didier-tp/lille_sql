# script SQL pour mySql
#DROP DATABASE IF EXISTS geoDB;
#CREATE DATABASE geoDB;

CREATE DATABASE IF NOT EXISTS geoDB ;

USE geoDB;

# DROP TABLE Dans ordre inverse des CREATE TABLE et/ou INSERT INTO si FOREIGN KEY CONSTRAINTS
DROP TABLE IF EXISTS Departement;
DROP TABLE IF EXISTS Region;


CREATE TABLE Region( 
    num INTEGER PRIMARY KEY,
	nom VARCHAR(64) ,
	chef_lieu VARCHAR(32)
) ENGINE=InnoDB;
# via des quotes inversées , un nom de tables ou de colonne pourrait comporter
# des espaces ex `chef lieu`


CREATE TABLE Departement( 
    numero VARCHAR(6) PRIMARY KEY,
	nom VARCHAR(48) ,
	prefecture VARCHAR(48),
	refRegion INTEGER
)ENGINE=InnoDB;

ALTER TABLE Departement
 ADD CONSTRAINT FK_RegionValidePourDepartement
  FOREIGN KEY (refRegion) REFERENCES Region(num) ;

# show tables est une instruction MySql qui affiche la liste des tables
show tables;

INSERT INTO Region(num, nom , chef_lieu ) VALUES (1, "Ile de France" , "Paris"),
                                                (2, "Hauts de France" , "Lille" );
												
INSERT INTO Departement(numero, nom , prefecture , refRegion ) 
      VALUES ("59", "Nord" , "Lille" , 2),
             ("62", "Pas de calais" , "Arras"  , 2),
			 ("75", "Paris" , "Paris"  , 2);
			 
# cette insertion devrait être refusée (region 99 existe pas):			 
#INSERT INTO Departement(numero, nom , prefecture , refRegion ) 
#      VALUES ("AA", "ABC" , "XYZ" , 99);			 
												
# affichage de la structure pour verifier:
#describe Region;
#describe Departement;

# affichage des donnees pour verifier:
SELECT * FROM Region;	
SELECT * FROM Departement;											



