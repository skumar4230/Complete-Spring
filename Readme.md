# Youtube link
# https://www.youtube.com/watch?v=BLlEgtp2_i8&t=14556s

# properties helper 
https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.actuator

# primary key generation for entity classes

The @GeneratedValue annotation in JPA (Java Persistence API)  combined with the GenerationType enum provides different strategies for automatically generating primary key values for your entities. Here's a breakdown of the different types:

GenerationType.IDENTITY:

This strategy leverages the database's built-in functionality for auto-incrementing columns.
When you use this strategy, the database itself generates a unique identifier for each new entity record.
This is the most common and preferred approach for relational databases as it simplifies your code and ensures unique IDs.
GenerationType.SEQUENCE:

This strategy utilizes a database sequence object to generate primary keys.
A sequence is a database object that maintains a pool of sequential numbers.
JPA interacts with the sequence to retrieve the next available value and assigns it as the primary key for your entity.
This approach is useful when you need more control over the generated IDs or if your database doesn't support auto-incrementing columns natively.
GenerationType.TABLE:

This strategy employs a separate table in the database to manage primary key generation.
The table typically has two columns: one for an identifier (often named something like id) and another for the next available value (e.g., next_val).
JPA interacts with this table to retrieve and update the next available value, assigning it as the primary key for your entity.
This approach is less common but might be necessary for specific scenarios where you need highly customized ID generation logic.
GenerationType.AUTO (default):

This strategy allows the persistence provider (like Hibernate) to choose the most appropriate generation strategy based on the underlying database.
It's the default option and usually works well for most relational databases that support auto-incrementing columns.
However, if you need more control or your database has limitations, you might need to specify a different strategy explicitly.
Choosing the Right Strategy:

In most cases, GenerationType.IDENTITY is the recommended approach for its simplicity and efficiency with relational databases.
If your database doesn't support auto-incrementing columns or you require more control over ID generation, consider GenerationType.SEQUENCE or GenerationType.TABLE.
Use GenerationType.AUTO cautiously, especially in complex scenarios, as it relies on the persistence provider's decision, which might not always align with your specific requirements.

# GenerationType	Description
IDENTITY	Database generates unique identifiers automatically.
SEQUENCE	Database sequence object is used for ID generation.
TABLE	Separate table manages ID generation with next available value.
AUTO (default)	Persistence provider chooses the best strategy based on the database.


# springbot actuator
dashboard to monitor and manage ur applications
# features
built-in endpoint
ability to view real time metrics
customizable
# dependency needed
 <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
after adding this and starting  we will get Exposing 1 endpoint(s) beneath base path '/actuator
i.e http://localhost:4230/actuator

# added in applciation.properties ->management.endpoints.web.exposure.include = *

# Now we will learn Docker
 solve conflicts of environment 
# Containerizing - include the application codes,it's dependencies, and the required environment config in a single unit called container
# What is Docker 
open source platform that allows to automate the deployment,scaling and management of app using containerization and is portable
# Virtual Machine - Vm's act like a separate computer inside your computer
# Docker is lightweight than VMS see diff in images  within resources folder
 url for getting docker images -Docker Hub https://hub.docker.com/
for AWS - ECR(docker)
for GCP - Artifact Registry
for Azure - Azure Container registry
for quay.io 
