set projectLocation=D:\Work\AT19_MavenProject
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG testng.xml
pause