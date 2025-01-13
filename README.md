# Analytics API Microservice

## Overview

The Analytics API is designed to provide comprehensive analytics and insights on user engagement and comic performance. This microservice allows users to retrieve, create, update, and delete analytics records related to comic interactions. The API is structured to handle various operations on analytics data, ensuring efficient data management and retrieval.

### Features
- **Retrieve all analytics records**: Fetch a complete list of analytics data.
- **Create new analytics records**: Add new data entries for analytics.
- **Retrieve a specific analytics record**: Access detailed information of a single analytics entry by its ID.
- **Update existing analytics records**: Modify data of an existing analytics entry.
- **Delete analytics records**: Remove analytics data by ID.

### Technical Details
- **API Version**: 1.0.0
- **Base Path**: `/analytics`
- **Data Format**: JSON

## Build Instructions

### Spring Boot Application
To build and run the application, follow these steps:
1. Ensure you have Java and Maven installed on your system.
2. Clone the repository and navigate to the project directory.
3. Run `mvn clean install` to build the application and generate the `.jar` file.

### Flyway DB Integration
To set up the database, follow these prerequisites:
- Ensure Docker is installed and running on your system.
- Use the following script to create the database:
  ```sql
  CREATE DATABASE IF NOT EXISTS `analytics_db`;
  ```
- To avoid errors with reserved keywords, execute:
  ```sql
  SET sql_mode = 'ANSI_QUOTES';
  ```

## Running Locally

To run the application locally using Docker, follow these steps:
1. Use the provided `docker-compose.yml` file to set up the environment.
2. The `docker-compose` file will:
   - Create a MySQL container.
   - Run `mvn clean install` to build the application and generate a `.jar` file.
   - Build the service image using the Dockerfile.
3. Execute `docker-compose up` to start the application.

### Note
- No pre-existing MySQL instance is required as the `docker-compose` setup will handle the database creation and management.