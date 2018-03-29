Un mode operatoire "git" pour travail en equipe
===============================================

NB: l'odre des operations est très important !!!

Un des membres de l'équipe effectue EN PREMIER les étapes 1,2,3,4
et continuera ultérieurement avec les étapes 6 , 7 , 8 , ...

Les autres membres de l'équipe pourront effectuer l' étape 5
SEULEMENT APRES la fin des étapes 1,2,3,4 !!!!

1 . création et test (sans GIT) d'un embryon de projet 
  a) créer par exemple un nouveau projet maven "prjXy" (avec pom.xml)
    sous eclipse ou bien un nouveau dossier "prjXy" avec contenu html+css+js
    sous notepad++
  b) tester un minimum (test unitaire ou "run as ... / run on server ou ...)
  
2 . prise en charge par git en mode local
  a) git init (en ligne de commande ou via tortoise git)
  b) copier/coller adapté de .gitignore
  c) git add * et git commit -a -m version_initiale
     (en ligne de commande ou via tortoise git)
     
3. préparation d'un réferentiel GIT distant (souvent avec github)
   a) se connecter avec son compte github (ex: didier-tp , pwd007! )
   b) créer un nouveau référentiel vide (sans readme , sans .gitignore) 
      sous git hub ==> nouvelle url de type
   https://github.com/didier-tp/web3b.git
   
4. push initial vers le référentiel distant (géré par gitHub):
   a) se placer dans le répertoire du projet (où il y a .git)
   b) lancer les commandes suivantes (directement dans "cmd" ou via ".bat"):
   REM git remote add Web3bGitHubOrigin https://username:password@urlRepoDistantGit
   git remote add Web3bGitHubOrigin https://didier-tp:pwd007!@github.com/didier-tp/web3b.git
   git push -u Web3bGitHubOrigin master   
   
5. clonage du référentiel distant/partagé GIT
   a) se placer quelquepart (cmd , cd )
   b) lancer la commande git clone https://github.com/didier-tp/web3b.git
   ou éventuellement git clone https://didier-tp:pwd007!@github.com/didier-tp/web3b.git
   c) éventuelle importation dans un IDE (exemple: 
      import ... / existing maven project sous eclipse)  
    
6. amélioration du code , test et commit local
   a) améiorer un ou plusieurs fichiers
   b) tests (unitaires ou via navigateur ou ...)
   c) commit (en ligne de commande ou avec tortoise git ou avec un IDE)
   
7. pull/push (avec merge automatique ou conflit)
   a) tenter un push direct (cmd / git push , tortoise git , IDE )
   b) si nécessaire lancer d'abord un pull
      c)  si besoin gérer les conflits (*)
          et ré-efectuer un test et un nouveau commit
   d) relancer si besoin un push , retenter le cycle a,b,c,d si besoin  
   
8) pull à lancer régulièrement/souvent pour charger les modifications
   effectués par les autres membres de l'équipe:
   * git pull (ligne de cmd, tortoise git ou via IDE )
   
   
========================
(*) résolution des conflits:
juste après un pull qui déclenche en interne "fetch + merge",
certains conflits peuvent être à gérer manuellement .
Les fichiers en conflit sont précisés par le message de la commande pull.
"git status" ou bien les couleurs de "tortoise git" peuvent également
servir à identifier les fichiers en conflit.
Via un éditeur tel que "notepad++" on peut ouvrir 1 à 1 les
fichiers en conflit et effectuer une fusion adaptée au cas par cas
de la version locale avec cetaines lignes de la version distante.
Si les modifications sont importantes, quelques tests (unitaire, web, ...)
peuvent être ensuite appropriés.
il faut ensuite effectuer un commit pour enregistrer les fichiers
où les conflits ont été résolus avant de ré-effectuer un push.

      