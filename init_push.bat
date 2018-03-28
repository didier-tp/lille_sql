git init
cd /d "%~dp0"
git add *
git commit -a -m "nouvelle version"
REM password doit être remplacé par la valeur du password !
git remote add gitHubOriginLilleSql https://didier-tp:password@github.com/didier-tp/lille_sql.git
git push -u gitHubOriginLilleSql master
pause
