# Dealer Listing
Rest API for dealer listing


Apache Maven 3.6.2 
Java version: 1.8.0_181

Steps to setup project

git clone https://github.com/Gyan0522/dealer-listing.git

cd dealer-listing/

- mvn install
- mvn package && java -jar target/dealerlistings-0.1.0.jar
- mvn -N io.takari:maven:wrapper
- ./mvnw clean spring-boot:run

Note : While setting up the project , ensure that maven is installed steps to export the maven path from cmd line:

Maven path setup 
- $ export M2_HOME=/path to maven/apache-maven-3.6.2 
- $ export M2=$M2_HOME/bin 
- $ export MAVEN_OPTS=-Xms256m -Xmx512m 
- $ export PATH=$M2:$PATH

Build Docker image:
-docker build -tag="dealer-listing" .

Run Docker Container:
-docker run -p 8080:8080 -it --rm dealer-listing


API Endpoint :

GET

-http://localhost:8080/v1/vehicle_listings

-http://localhost:8080/v1/searchlisting?make=maruti&model=magna&year=2018&color=red

PUT

-http://localhost:8080/v1/listing

-Body: 
    {  
        "dealerId": "101",
        "code": "a",
        "make": "renault",
        "model": "megane",
        "kw": 212,
        "year": 2018,
        "color": "red",
        "price": 25123
    }
