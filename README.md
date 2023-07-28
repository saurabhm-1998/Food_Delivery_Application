# Food Delivery Application

The Food Delivery Application is a user-friendly and efficient platform designed to facilitate the process of ordering food from restaurants and getting it delivered to customers' doorsteps. The application leverages the power of technology and the convenience of online platforms to enhance the overall food ordering experience for users.

## Framework and Language Used

Framework and Language Used

Spring Boot

Java

MySQL

Spring Web

## Data Flow

The data flow in the Food Delivery Application follows the Model-View-Controller (MVC) architectural pattern. Here's how data flows through the different components:

### Controller
The application has the following controllers:

* AdminController: Handles administrative tasks, such as adding new food items to the menu.
* UserController: Manages user actions, such as placing orders, viewing order history, and handling authentication.
* OrderController: Deals with requests related to displaying details about the orders placed.
### Service
The application includes the following service classes:

* AdminService: Contains business logic related to administrative actions.

* UserService: Contains business logic for user-related actions, including orders and authentication.

* OrderService: Handles business logic related to orders.

### Repository
The application uses the Spring Data JPA framework to implement repositories. It includes:

* FoodMenuRepository: Provides methods to interact with the FoodMenu entity for data access.

### Authentication
The application implements user authentication using authentication tokens. Here's how the authentication process works:

When a user signs up, a unique authentication token is generated and associated with the user account.
The user can sign in using their credentials (username and password).
Upon successful authentication, the server returns an authentication token to the user.
The user must include this authentication token in the request headers for subsequent requests to access protected endpoints.
The application uses the authentication token to verify the user's identity and grant access to protected resources.

## Database Design
The MySQL database is used to store the application's data. The database design includes tables for:

* FoodMenu: Stores information about food items, including foodItemId, foodName, and foodPrice.

* User: Contains user information, including details for authentication.

* Order: Stores details about user orders.

* Food Order: Stores the information of food ordered by user.

## Data Structure Used in the Project
The project uses a MySQL database to manage and store data. The data structure primarily consists of tables representing various entities and their relationships.

## Project Summary
The Food Delivery Application is developed using Spring Boot, Java, and MySQL. It follows the MVC architectural pattern, where the Controller handles incoming HTTP requests, the Service layer contains the business logic, and the Repository layer interacts with the database for data access. The application allows users to view the menu, place orders, and view their order history. Administrators can add new food items to the menu. The project aims to provide a user-friendly and efficient food ordering experience to customers. The implementation of user authentication ensures secure access to the application's features and protects sensitive user information.