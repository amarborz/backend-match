# match

Doorloop de volgende stappen om een bijbehorende database op te zetten:

In git bash: <docker container run -dit --name matchsql -e MYSQL_ROOT_PASSWORD=match -p 3306:3306 mysql>
Ga naar Docker Desktop, klik op je container (matchsql).
Ga naar Terminal of Exec en typ: <mysql -u root -p>. Voer vervolgens je password in (match)
Typ . Typ vervolgens
Pas je application.properties file aan zodat deze naar de juiste database verwijst:
spring.datasource.url=jdbc:mysql://localhost:3306/matchsql
spring.datasource.username=root
spring.datasource.password=match
Run de code in Eclipse. Hierna kan je met Insomnia GET en POST requests uitvoeren.
