# Client Api
A simple JSP page to fill a H2 database with a unique table CLIENT. Also, a REST service to retrieve all saved clients
## Technologies

* H2 database
* Hibernate
* Maven
* Java 1.7
* EJB 3.1
* Glassfish 4.1
* Jersey
* Swagger
* The application has all permissions to access the home `~` so it can create the database files `client-api.mv.db`

## Run the program

* `cd` to the project's root directory.
* run the Maven command `mvn clean compile install`
* if the build is successful it should log the path of the java web archive created

`[INFO] Building war: /home/jorge/workspace/client-api/client-api-web/target/client-api-web-1.0-SNAPSHOT.war`

* Deploy the application on the Glassfish Server.
* If some issue is presented with jboss-logging lib replace it on the server glassfish4/glassfish/modules/ with the version logging-3.3.0.Final.jar which should fix the issue.
* Use the URL http://localhost:8080/client-api-web-1.0-SNAPSHOT/ for the JSP and the http://localhost:8080/client-api-web-1.0-SNAPSHOT/rest/client for the REST service.
