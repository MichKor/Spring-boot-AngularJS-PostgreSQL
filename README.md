# Spring-boot-AngularJS-PostgreSQL

### Starting the application

You'll need to provide connection credentials for the database. To do this is to set the PostgreSQL username and password in `src/main/resources/application.properties`

```
spring.datasource.url=jdbc:postgresql://localhost:5432/<Your database name here>
spring.datasource.userName=<Your username here>
spring.datasource.password=<Your password here>
```

And that's it! Head to <http://localhost:8080> to see your application running.

### Spring Security 

You must manually add user permissions to the database.

Table `privilage --> 1 - ROLE_ADMIN, 2 - ROLE_USER` 

Then assign user permissions to the table `user_privilages` 