cd /d "%~dp0"
git add *
git commit -a -m "nouvelle version"
git push -u gitHubOriginLilleSql master
pause