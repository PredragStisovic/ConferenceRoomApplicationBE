# Project Description                                                                                                                                                                   
   
This is an application made in Java for scheduling university classroom as a part of subject: Advanced Software Technologies.

It is conceptualized as an application that allows professors to schedule classrooms and check which ones are already taken up. It allows seamless communication and reduces confusion at the university, increasing productivity and organisation.

# Technologies

### Backend

Java, Spring Boot
Spring Security with JWT authentication
Hibernate
Liquibase (database migrations)
REST API with Swagger/OpenAPI documentation
MySQL database

### Frontend

Next.js application

# Features

### Authentication & Authorization

Registration — email must be unique, password minimum 8 characters
Login — returns a JWT token used for all subsequent requests
Password change — requires old password, new password must be different than old one
Passwords are stored encrypted using BCrypt

### User Roles

  ZAPOSLENI — default role
    Browse and filter available rooms (by name, minimum capacity, with pagination)
    Submit reservation requests for a room
    Report room unavailability periods

  ADMIN
    Create new user accounts
    Approve or reject reservation requests
    Delete reservations
    Cannot approve their own requests (self-approval is forbidden)

### Room Management

  Create and delete rooms (name + capacity)
  Filter rooms by name and minimum capacity with paginated results
  Each room tracks its own unavailability periods

### Reservation Workflow

  A professor submits a reservation request with a room, time slot, and appointment type
  The system enforces that start time is before end time and in the future
  Reservations are created as unapproved — an admin must approve them
  On approval, the system records who approved and when
  Admins can delete pending reservations
  Three appointment types are supported: ISPIT (exam), KOLOKVIJUM (midterm), PREDAVANJE (lecture)

# Architecture

### Backend Structure

  Entities: KorisnikEntity (user), SalaEntity (room), TerminEntity (reservation), TipTerminaEntity (appointment type), NedostupnostSaleEntity (room unavailability)
  Converter pattern: Generic Converter<T, E> interface with toDto()/toEntity() methods, one implementation per entity
  Global exception handling: Centralized @RestControllerAdvice that returns consistent JSON error responses
  Security: Stateless JWT filter chain — token is validated on every request, user and role are loaded from the database, enabling @PreAuthorize role checks on individual endpoints

### REST Endpoints

  /auth — registration, login, password change (public)
  /korisnik — user lookup, admin user creation
  /sala — room CRUD, filtering with pagination
  /termin — create reservations, list by room, list unapproved, approve, delete
  /nedostupnost-sale — report room unavailability

### Database

  Managed entirely through Liquibase — Hibernate ddl-auto is set to none
  Schema and initial data (admin account, appointment types) are created automatically on startup

# Running the Project

  Backend

  1. Start a MySQL instance with a database named mydb on port 3306
  2. Run the Spring Boot application
  3. Liquibase will automatically create all tables and seed initial data
  4. Swagger UI is available at http://localhost:8081/swagger-ui/index.html

  Frontend

  1. Start the React application
  2. Access through the browser
