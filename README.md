# Avasyu - Smart Contact Manager

Avasyu is a full-stack web application built on Spring Boot, designed to manage contacts efficiently with various features including social login, cloud-based image storage, email integration, and more

## Features

1. **User Authentication**
   - User signup with email and password
   - Email verification for account activation
   - Social login with Google and GitHub

2. **Contact Management**
   - Add contacts with profile pictures
   - Cloud storage integration for contact pictures (AWS/Cloudinary)
   - View all contacts with pagination
   - Search contacts by name or details
   - Update and delete contacts

3. **Email Integration**
   - Compose and send emails directly from the application
   - Attach files with emails (text + attachment)

4. **Export and Reporting**
   - Export contact data to Excel for reporting and analysis

5. **User Profile Management**
   - View and edit own profile details
   - Dark and Light theme options for user interface customization

6. **Other Features**
   - Mark contacts as favorites for quick access
   - Provide feedback or suggestions directly from the application

## Technologies Used

- **Backend**
  - Spring Boot
  - Spring Framework
  - Spring MVC
  - Spring Data JPA (ORM)
  - Spring Security

- **Frontend**
  - Thymeleaf (Template Engine)
  - JavaScript
  - Tailwind CSS (for responsive and utility-first CSS framework)
  - Flowbite components (UI components library)

- **Database**
  - MySQL or PostgreSQL (project database independent)

- **External Services**
  - OAuth for social login (Google, GitHub)
  - AWS/Cloudinary SDK for file storage
  - Java email services for sending/receiving emails
  - PDF/Excel tools for generating reports

## Installation and Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd avasyu/

2. **Configure application properties**

- Set up database configuration in application.properties
- Configure Cloudinary credentials for file storage
- Add OAuth client IDs and secrets for Google and GitHub login
- Build and run the application

3. **Build and Run the Application**
   Fire up in the terminal
   ```bash
    ./mvnw spring-boot:run

4 **Access Avasyu**

Open your browser and visit http://localhost:8000
Sign up with your email or use social login options


Contributions are welcome! Fork the repository and submit a pull request with your improvements.
