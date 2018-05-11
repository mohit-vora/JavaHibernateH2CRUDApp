
cd C:/Users/mohit_vora/Desktop/Tomcat-7.0.62/webapps

for /d %%x in (CRUD*) do rd /s /q "%%x"

robocopy "C:/Program Files/Go Agent/pipelines/test2/warTestDeploy/deployWar" "C:\Program Files\apache-tomcat-7.0.86\webapps" "*.war" /E

netstat -na | find "LISTENING" | find /C /I ":8765" > NUL
IF %errorlevel%==0 (
echo shutting down tomcat1
net stop tomcat7
	timeout 3
	echo starting tomcat
net start tomcat7
)ELSE (
echo starting tomcat
net start tomcat7

)

netstat -na | find "LISTENING" | find /C /I ":8765" > NUL
IF %errorlevel%==0 (
	echo error starting tomcat service, please check your environment.
	exit /b 2
)ELSE (
	echo tomcat is up and running
)