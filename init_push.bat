git init
cd /d "%~dp0"
git add *
git commit -a -m "nouvelle version"
git remote add gitHubOriginLilleSql https://didier-tp:pwd007!@github.com/didier-tp/lille_sql.git
git push -u gitHubOriginLilleSql master
pause
