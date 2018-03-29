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
# via des quotes inversees , un nom de tables ou de colonne pourrait comporter
# des espaces ex `chef lieu`


CREATE TABLE Departement( 
    numero VARCHAR(6) PRIMARY KEY,
	nom VARCHAR(48) ,
	population INTEGER,
	superficie INTEGER,
	prefecture VARCHAR(48),
	refRegion INTEGER
)ENGINE=InnoDB;

ALTER TABLE Departement
 ADD CONSTRAINT FK_RegionValidePourDepartement
  FOREIGN KEY (refRegion) REFERENCES Region(num) ;

# show tables est une instruction MySql qui affiche la liste des tables
show tables;

INSERT INTO Region(num, nom , chef_lieu ) 
VALUES (1, "Ile de France" , "Paris"),
  (2, "Hauts de France" , "Lille" ),
  (3, 'Normandie',"Rouen");
												
INSERT INTO Departement(numero, nom , prefecture , population , superficie,  refRegion ) 
      VALUES ("59", "Nord" , "Lille" ,2577000, 5743 , 2),
             ("62", "Pas de calais" , "Arras", 1456000,6671 , 2),
			 ("75", "Paris" , "Paris" ,2166200 ,105, 2),
			 ("60", "Oise" , "Beauvais" ,780000,5860 , 2),
			 ("80", "Somme" , "Amiens" ,555551 ,6170, 2),
			 ("02", "Aisne" , "Laon" ,535489 ,7369, 2),
			 ("92", "Hauts de Seine" , null,1517000, 176 , 1);
			 
			 
# cette insertion devrait être refusée (region 99 existe pas):			 
#INSERT INTO Departement(numero, nom , prefecture , refRegion ) 
#      VALUES ("AA", "ABC" , "XYZ" , 99);			 
												
# affichage de la structure pour verifier:
#describe Region;
#describe Departement;

# affichage des donnees pour verifier:
SELECT * FROM Region;	
SELECT * FROM Departement;											



