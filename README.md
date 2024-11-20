# Task Management API

## Project Overview
A robust Spring Boot application for managing tasks with comprehensive features and best practices.

## Features
- CRUD operations for tasks
- Task status management
- Error handling
- Authentication support

## Technology Stack
- Java 11+
- Spring Boot
- Spring Data JPA
- H2 Database
- JUnit 5
- Maven

## Prerequisites
- JDK 11 or higher
- Maven 3.6+

## Configuration

### Database
- H2 in-memory database
- Persistent file-based storage
- Configurable in `application.properties`

### Environment Variables


## Installation

1. Clone the repository
```bash
git clone https://github.com/mohitkmeena/wellnesstask.git
cd wellnesstask
```

2. Build the project
```bash
mvn clean install
```

3. Run the application
```bash
mvn spring-boot:run
```

4. Use PostMan to use it easily  with basic authentication username : root and password :root 

### Task Management
- `GET /tasks`: Retrieve all tasks
- `GET /tasks/{id}`: Get specific task
- `POST /tasks`: Create new task
- `PUT /tasks/{id}`: Update existing task
- `DELETE /tasks/{id}`: Delete task
- `PATCH /tasks/{id}`: Mark task complete

### Authentication
- `POST /login`: User authentication

## Security
- Basic authentication
- Error handling





## Contributing
1. Fork the repository
2. Create feature branch
3. Commit changes
4. Push to branch
5. Create pull request

## License
MIT License

## Contact
Mohit Kumar Meena
mohitmeenag2005@gmail.com

