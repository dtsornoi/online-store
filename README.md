# Online Store (Final Project as Part of Software Development Academy courses)  

## Description  

As part of our project, we created an application that allows you to add products to the store via the administration panel. The system is to enable user registration and logging, as well as placing an order.  

**Main system functions**  
- Login Panel
- Admin:
  - Adding products
  - List of products + editing
  - List of Customers + editing
- User:
  - List of products + sorting
  - Profile page + editing
- All:
  - Cart
  - View Order
  - Logout
  - Registration
  
## Team  
  
Team members: Mark, Vladimir, Dmitri.  
  
Team Leader: Dmitri.

## Back-End  

Backend of the project is build using Java and Spring Framework.  
Project uses REST controllers to combine Frontend with Backend.  
Backend is separated in different layers Controller, Service, Repository, Security and Configuration.  
Backend technologies used:
- Spring Boot REST
- Spring Boot JPA (Hibernate)
- MySQL
- Lombok  
- Spring Security + JWT  
- AOP (for logging and debugging)  

````
Backend main port is: 8080
````
## Front-End  
   
The frontend part of project is located in src/main/frontend and **Angular** was used to build it,  
so do not forget to run in the angular root folder:  
```
npm install
```  
Front-end technologies used:  
- Angular Bootsrap 
- Custom css
- Angular Material  
  
By default right now you are registered as Admin, if you want to see view of User, then in  
**register.component.ts** change ROLE_ADMIN constant to ROLE_USER on line **38**.
````
Frontend main port is: 4200
````