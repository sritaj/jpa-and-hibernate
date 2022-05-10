<img src="https://blog.netgloo.com/wp-content/uploads/2014/10/Spring-Data-jpa-Hibernate_c80.jpg" alt="SpringBoot JPA Hibernate" style="height: 300px; width:700px;"/>

# Spring Boot - JPA - Hibernate

***Spring Boot Project*** demonstrating ***JPA and Hibernate*** capabilities. Examples covering ***Entities, SpringJDBC,
JPA, Hibernate, SpringDataJPA, SQL Queries Using JPQL, Native Queries, basics of SpringREST*** using ***H2 database***
, ***MySQL*** and ***MongoDB*** along with ***TestNG Unit Tests*** examples for Repositories, utilising Lombok and Faker
libraries

## Tech Stack

1. Java
2. SpringBoot
3. JPA
4. Hibernate
5. JDBC
6. H2 Database, MySQL Database, MongoDB
7. TestNG

## Examples/Features Included

| Examples                                                             | Packages/Files/Location      |
| -------------------------------------------------------------------- | ---------------------------- |
| CRUD operations using SpringJDBC                                     | ***jdbcRepository*** - Repository implementing Methods for SQL CRUD queries, JDBCApplication - Runner Class to Run the JDBC specific operations          |
| CRUD operations using JPA and Hibernate using Entity Manager         | ***entitymanager***  - package containing the entities, repository and test (segregated at entity, repository and test layer)           |
| Custom Methods for CRUD operations                                   | ***CourseSpringDataRepositoryImpl*** - Repository Interface implementing Custom Methods |
| SpringDataJPA queries (Finder methods)                               | ***springjpadata*** - package containing the entities, repository and test (segregated at entity, repository and test layer) |
| Inheritance Mapping                                                  | ***inheritancemapping*** - package containing the entities, repository and test (segregated at entity, repository and test layer)                                         |
| Component Mapping/Embedded Table in Entity                           | ***componentmapping*** - package containing the entities, repository and test (segregated at entity, repository and test layer)|
| CRUD operations/pagination/sorting using JPQL, Native SQL Query      | ***springdatajpa*** - package containing the entities, repository and test (segregated at entity, repository and test layer)                                 |
| Relationships                                                        | ***relationships*** - package containing the entities, repository and test (segregated at entity, repository and test layer) |
| AutoGenerated ID using custom Table, Composite Key IDs, Embedded IDs | ***customids*** - package containing the entities, repository and test (segregated at entity, repository and test layer)
| File Saving and Retrieving                                           | ***fileshandling*** - package containing the entities, repository and test (segregated at entity, repository and test layer)
| Softdelete                                                           | ***softdelete*** - package containing the entities, repository and test (segregated at entity, repository and test layer)
| Stored procedures                                                    | ***storedprocedures*** - package containing the entities, repository and test (segregated at entity, repository and test layer)                                             |
| Transaction Management                                               | ***transactionmanagement*** - package containing the entities, repository, service and test (segregated at entity, repository, service and test layer)                                            |
| REST APIs for CRUD operations                                        | ***restfulapis*** - package containing the entities, repository, controller and test (segregated at entity, repository, controller and test layer)
| MongoDB CRUD operations                                              | ***mongodb*** - package containing the entities, repository and test (segregated at entity, repository and test layer)
| H2 Database and MySQL Database                                       | ***application.properties*** - Configurations for H2 and MySQL Databases |
| ENUM to set Data in the Column                                       | ***enums*** - package containing ENUM that is used with Rating entity(entitymanager package) and relevant Test methods
| TestNG Unit Tests                                                    | ***test/../repository*** - package containing TestNG tests for relevant Repositories

## Instructions

### Running SpringBoot Application and Tests in Local System

1. There are two Spring Boot Application file (annotated by SpringBootApplication), **JDBCApplication** and **
   JpaAndHibernateApplication**; by default JpaAndHibernateApplication is configured for the Run, JDBCApplication
   annotation is commented out.
2. To run the JDBCApplication to check SpringJDBC specific Runs, uncomment the SpringBootApplication annotation in the
   file and comment the SpringBootApplication annotation in the JpaAndHibernateApplication file
3. The properties file have configuration for H2 database and MySQL, by default H2 database is setup

### Running SpringBoot Application and Tests in Local System in H2 database

1. To run the tests in H2 database, uncomment the configuration for H2 in application.properties and comment out the
   MySQL database, MongoDB properties
2. On running the Tests file or the JPAandHibernateApplication file the H2 database will be utitlized and the data can
   be cross-checked in the H2 database
3. The data.sql will be loaded to the H2 database for Test data when the H2 database is configured

### Running SpringBoot Application and Tests in Local System in MySQL Database

1. To run the tests in MySQL database, uncomment the configuration for MySQL in application.properties and comment out
   the H2 database, MongoDB properties
2. Configure the MySQL database in the local environment
3. From the src/main/resources take the **db_schema.sql** first and then the **table.sql** and run the script in MySQL
   to create the DB, Users and Relevant Tables required
4. On running the Tests file or the JPAandHibernateApplication file the MySQL database will be utitlized and the data
   can be cross-checked in the MySQL database

### Running SpringBoot Application and Tests in Local System in MongoDB

1. To run the tests in MongoDB, uncomment the configuration for MongoDB in application.properties and comment out the H2
   and MySQL database properties
2. On running the Tests file ***ItemSpringDataMongoRepositoryTest*** located under test/*/repository/mongodb/ the
   MongoDB will be utilized and the data can be cross-checked in the MongoDB

## Setup/TroubleShooting

1. Check the specified Port Number in application.properties is free or not, or else change it to an available port like
   9891, 9020
2. Setup the MySQL and MongoDB in local environment

## Special Thanks

Special Thanks to many Instructors who have done a splendid job on explaining the course concepts

- [in28minutes](https://courses.in28minutes.com/p/master-hibernate-and-jpa-with-spring-boot-in-100-steps)
- [Bharath Thippireddy](https://www.udemy.com/course/spring-data-jpa-using-hibernate/)
- And many more sources from which I learnt trouble-shooting points via YouTube, StackOverFlow, SpringJPA Docs and
  Articles 
