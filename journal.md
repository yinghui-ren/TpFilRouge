1.11. When clicking the green run button, the IDE compiles the code, builds the project using Maven, starts the JVM, 
runs the main class, initializes the Spring Boot context, and starts the embedded Tomcat server on port 8080.

1.12. This message means that the embedded Tomcat server has successfully started. It listens for HTTP requests on port 
8080, and the application is deployed at the root context path "/".

1.14. This annotation marks the main class of the Spring Boot application. It enables auto-configuration and component 
scanning.


1.15. It is necessary to restart the server because the application runs compiled classes in memory. After modifying the
source code, the application must be restarted so that the new compiled classes are loaded and the changes become effective.

2.1 No, it is not safe to keep this code in the entry point. The main method should only start the application. Putting 
business logic there makes the program harder to maintain and does not follow the proper Spring Boot architecture.

2.2.3. We use annotations such as @RestController and @GetMapping. The @GetMapping("/hello") annotation maps the URL 
"/hello" to the method displayHello().

Spring Boot scans the controller class, creates a bean, and registers the URL mapping. When a GET request is sent to 
"/hello", Spring calls the method and automatically converts the returned object into JSON.

3.1.3.
When this dependency is activated, Spring Boot adds JPA and Hibernate support to the project.
It allows the application to interact with the database using repositories and entity classes, without writing SQL manually.

3.2.1.3
The generated Entity class is different from the previous Programmer.java class because it contains JPA annotations such
as @Entity, @Table, @Id, and @Column.
These annotations allow the class to be mapped to a database table and used in the persistence layer.

4.1.1. findAll()

4.1.2. 
No. The controller should not access the repository directly.
The request should go through the Service layer, which then calls the repository.

4.1.4. 
The @Service annotation tells Spring that this class is a service component.
It allows Spring to automatically detect and manage it as a bean in the application context.

4.1.7.
We are working in the Controller layer, which handles HTTP requests and communicates with the Service layer.

4.1.8. 
Using @Autowired directly on a field is not the best practice.
A better approach is constructor injection, because it makes dependencies explicit.

4.5.
PUT replaces the whole resource, while PATCH modifies only some fields of the resource.

5.8.2
HTML form normally sends a GET or POST request, while the controller deletion method is often defined with @DeleteMapping,
so clicking the Delete button does not call the @DeleteMapping method correctly.



