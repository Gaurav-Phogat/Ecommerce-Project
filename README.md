Version 1.0 Up now, will be adding details about the project with a video on how to get it up and running on your own local machine later.



Log---

Front-end :
Used:  React, Bootstrap, jwt.

Written In : 80% Javascript, 15% HTML , 5% CSS.


React-> Made full use of useEffect and useState to achieve as much as possible of react-DOM to avoid re-rendering everytime.
     -> Used conditional rendering depending on useState for role based rendering.
     -> To make Application more secure Will be adding another verification layer in next version update.

Bootstrap-> Used basic styling classes and icons.

JWT-> Used JWT encoded with role to get role and verify role for rendering different components and parts of components depending of role type.

Back-end: 

used: Spring Boot, Maven,  Spring WEB, Spring data JPA, Lombok, Spring Security, JWT tokens.

Written in: Java 95%, xml 5%.

Spring Boot-> Default parent dependency for everything spring.

Maven-> Used maven to get and install dependencies to make it easier for use.
     -> Using maven also makes it easier to dockerize which is my current goal as of uploading version 1.0.

Spring Web-> built the REST API with help of web
	  -> Spring MVC used for handling HTTP requests from front-end or API calls.
	  -> Easy to get Application up and running with embedded tomcat server which made developing easier.

Spring Data JPA-> Used for simple ORM mapping significantly decreasing code length and saving time aswell as making code more readable.
	       -> Made SQL interactions query free with use of Repo and Entity Classes such as Product and user.

Lombok->Made boiler plate with just few annotations making code simpler and readable.

Spring Security-> Helped me with hashing and storing password in databse.
	       -> Also made it simpler to create secure endpoints.

JWT-> Generated JWT tokens for verification of user sessions and make it simpler to make UI changes with role encoded into the token.
   -> Used for Authenticating user before they make any serious changes.
   -> Need to improve it so that if the Admin changes the role info of a user it reflects on the token automatically and stops recognizing old token as valid.

Database:

used: PostgreSQL.

Written in : Only had to write one query for search function aside for that it was taken care of by Spring JPA with help of repo.

PostgreSQL-> Used Entities to directly generate or update databse without having to write queries.
	  -> Used PgAdmin to streamline development since it makes it simpler to see the database schema's clearly.
	  -> Overall postgreSQL is a good choice for ecommerce since we can control the number of variables being used in a ecommerce setting.



Summary-> Need to work on more robust security for now just using simple role based rendering to secure it but the API is still not 100% secure.
       -> Also making cart such that we also store cart data. One Idea I have is storing every ProductId in one string and using a algorithim to quickly add and remove from it to make it seem like we are using another table. since the problem with using another table is that when we want to update the cart the speed of updating may actually be worse unless we implement a high level scalable design which is beyond my level as fresher for now.
       -> Another improvement worth making is Using a actuall image hosting service and just storing the links of images instead of storing images as base64 encoded directly into the PostgreSQL databse like currently. Although I have limited the size to 512kb it is still very large compared to how big it should be which is at max 10kb imo. So I was thinking of implementing Cloudinary if I have time later.

