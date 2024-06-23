# Employee Management System

## Description
This project is an Employee Management System built using Spring MVC and Thymeleaf. It provides different features for both employees and administrators to manage attendance, personal details, and leave requests.

## Features

### Employee Features
- **Login**: Employees can log in to their dashboard.
- **Dashboard**: Displays a welcome message with the employee's name.
- **My Profile**: Employees can view their personal details.
- **Mark Attendance**: Employees can mark their attendance using a form.
- **Request Leave**: Employees can submit a leave request using a form.

### Admin Features
- **Login**: Admin can log in to their dashboard.
- **Dashboard**: Shows a list of all employees, attendance records of each employee, and leave requests.
- **Manage Leave Requests**: Admin can approve or reject leave requests submitted by employees. The status of the request should be visible to employees.

## Color Scheme
- Dark Purple: `#20123A`
- Light Purple: `#b8adcc`
- Medium Purple: `#381280`

## Order of Creation
1. Model
2. Repository
3. Service
4. Controller
5. Templates
6. Configuration

## Dependencies
- **Spring Web MVC**: To build web applications including RESTful applications using Spring MVC.
- **Spring Data JPA**: To handle data persistence with ease.
- **MySQL Driver**: MySQL database connectivity.
- **Thymeleaf**: A modern server-side Java template engine for web and standalone environments.
- **Lombok**: A Java library that automatically plugs into your editor and build tools, spicing up your Java.
- **JDBC Driver**: For database connectivity.

## Installation
1. **Clone the repository**:
    ```sh
    git clone https://github.com/your-username/your-repo.git
    cd your-repo
    ```

2. **Configure the database**:
    - Update the `application.properties` file with your MySQL database configuration.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your-database
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Install dependencies**:
   Ensure you have Maven installed. Then, in the project directory, run:
    ```sh
    mvn install
    ```

4. **Deploy the application**:
   Deploy the application to your preferred web server (e.g., Tomcat).
    - Ensure the `pom.xml` includes the necessary configurations for packaging the application as a WAR file.

## Usage
- Access the application at `http://localhost:8080` (or the configured server port).
- Employees and Admin can log in using their credentials to access their respective dashboards.

## Contributing
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a pull request.

## License
This project is licensed under the MIT License.
