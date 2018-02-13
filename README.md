# Joanne Saunders Individual Project

This repository will contain the Secret Recipe application for Enterprise Java Class. 

### Problem Statement

I have been collecting recipes for many years and as my collection grows, the organization becomes more and more difficult.
Security has also become a concern; I have nearly started the file folder on fire... twice. 
I would also like to free up that drawer in the kitchen and get all those cookbooks moved to a less central location.

To that end, I am building an application that allows a user to build and maintain recipes in electronic cookbook format.
You can keep your information secure and organized, share your recipes on the internet or keep them private for your own use.
Optional feature will be to allow user groups that can share recipes just within their group.

### Project Technologies/Techniques 

* Security/Authentication
  * TODO: is this something we already should know, or is this coming in weeks ahead? Tomcat's JDBC Realm Authentication
  * Admin role: create/read/update/delete (crud) of all data, manage user accounts
  * User role: sign up, sign in, create recipe book, create/edit/delete own recipes and categories only

* Database
  * MySQL
  * Store users and roles
  * Store all data for the users
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * TODO: Needs to be decided. Things to look into:
    * Print to PDF
    * send recipe file formats to other users? or via email?
    * english to metric conversion on measures
    * any other cookbookie stuff out there i might want to add.
* CSS 
  * Bootstrap 
* Data Validation
  * TODO: Not sure- 2 recommended options are Bootstrap Validator for front end and Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Independent Research Topic/s
  * TODO: Still needs to be determined. Suggestions on independent research  
  * Hibernate Validation
  * Hibernate Search
  * Project Lombok to eliminate boilerplate code like getters/setters/equals
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA


### Design

* [Screen Design](DesignDocuments/Screens.md)
* [Application Flow](DesignDocuments/applicationFlow.md)
* [Database Design](DesignDocuments/databaseDiagram.png)

### [Project Plan](ProjectPlan.md)

### [Development Journal](timeLog.md)
