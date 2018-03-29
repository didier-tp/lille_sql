set MYSQL_HOME=C:\wamp64\bin\mysql\mysql5.7.14
REM set MYSQL_HOME=C:\Program Files\MySQL\MySQL Server 5.7
"%MYSQL_HOME%\bin\mysql" -u root -p < filmDB.sql
pause
REM -u username , -p pour demander un mot de passes