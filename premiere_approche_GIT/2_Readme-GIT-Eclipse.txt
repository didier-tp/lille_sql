Un mode opératoire "maven+git" sous eclipse
===========================================

Remarque préliminaire: la prise en charge de GIT sous eclipse
s'effectue avec le plugin "EGIT" faisant partie de la version Eclipse JEE.
Ce plugin (devant cohabiter avec d'autres plugins eclipse) est un peu moins intuitif
que tortoise git mais offre l'avantage d'une bonne intégration dans l'IDE.

Bien qu'il y ait plein de variantes dans les séquences possibles, certaines
opérations sont plus simples que d'autres:

* Eclipse reconnait bien un projet existant "maven+git" (pom.xml et .git)
  ==> il est donc facile et intuitif de:
      a) cloner un référentiel distant via une ligne de commande
         ou via tortoise git
      b) importer le projet sous eclipse via le menu 
         "import ... / import maven project" (en sélectionnant le répertoire 
         comportant pom.xml)
         
  Autre séquence possible:
      a) activer la perspective "GIT" dans eclipse
      b) paramétrer un "remote GIT repository" (URL à spécifier)
      c) se laisser guider par les menus pour effectuer un 
         "clone+import en tant que projet eclipse" . 
         
* Si eclipse ne reconnait pas bien l'aspect "GIT" d'un projet existant
  (après des opérations effectuées en ligne de commande 
  ou via tortoise GIT)  on peut déclencher "refresh"
  ou bien "close project" suivi de "open project"
  ou bien "delete project" suivi de "import .../import maven project" 
  
* Une fois qu'un projet "maven+GIT" est bien reconnu par eclipse,
  le déclenchement des commit, pull , push , .... s'effectue via
  le menu "Team / ..." du "project explorer" (en perspective jee)
  et l'exploration des versions s'effectue via la perspective GIT 
  (show in / history)
  
* Si lors d'un push, un username et un mot de passe sont nécessaires , on   
  pourra les saisir dans une boîte de dialogue appropriée d'eclipse
  
* Le principal point fort de GIT sous eclipse est l'aide à la résolution
  des conflits (après un pull précédant un push):
  pour chaque fichier en confit:
       a) menu Team/Merge tool
       b) modifier la zone de gauche (locale) en tenant compte de certaines "bonnes choses"
          de la zone de droite (distante et non modifiable directement)
       c) menu Team/add to index (si nécessaire) 
  Une fois les fusions effectuées localement/temporairement, on peut alors:
       1) effectuer RAPIDEMENT quelques tests (JUnit, web , ...)
       2) Team / commit
       3) Team / push to upstream .      