# weather-service
Use 'Open Weather Stack APIs' to get weather information

### Tech Stack
* Java 21
* Spring Boot 3.2.3
* Github Action
* Mapstruct mapper
* TDD approach
* Open Api Documentation
* Adapter Design Pattern
* Spring Profiling
* Used WeatherStack APIs
* Used H2 database to develop and test
* Used MariaDB in Production Mode


### How to run the application
* Clone the repository
* Run the docker-compose file to start the Keycloak server
  * Define your realm
  * Define your client
  * Define your user
  * Define your roles (USER, ADMIN)
  * Define your client roles (APP_USER, APP_ADMIN)

* Run the application
* Use the below command to run the application
  * `mvn clean install`
  * `mvn spring-boot:run`

* Use Weather-Api.http in http-request-util in the root directory to key keycloak token and use it in the header to access the weather api


### GOOD LUCK
