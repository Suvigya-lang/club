1. Create a Booking
Endpoint:
POST /api/bookings

Description:
Create a new booking with details such as member name, class, participation date, and start time.

Request Body:

json

{
  "memberName": "John Doe",
  "classId": 1,
  "participationDate": "2025-02-15",
  "classStartTime": "09:00:00"
}
Response:
Returns the created booking entity.

2. Search Bookings
Endpoint:
POST /api/bookings/search

Description:
Search bookings based on optional filters like member name and date range.

Request Body:

json

{
  "memberName": "John Doe",
  "startDate": "2025-02-15",
  "endDate": "2025-02-20"
}
Response:
Returns a list of bookings that match the search criteria.

3. Get All Bookings
Endpoint:
GET /api/bookings

Description:
Fetch all available bookings.

Response:

json
[
  {
    "id": 1,
    "memberName": "John Doe",
    "classId": 1,
    "participationDate": "2025-02-15",
    "classStartTime": "09:00:00"
  }
]
4. Update a Booking
Endpoint:
PUT /api/bookings/{id}

Description:
Update a booking by its ID.

Request Body:

json

{
  "memberName": "Jane Doe",
  "classId": 2,
  "participationDate": "2025-03-10",
  "classStartTime": "11:00:00"
}
Response:
Returns the updated booking entity.

5. Delete a Booking
Endpoint:
DELETE /api/bookings/{id}

Description:
Delete a booking by its ID.

Response:
Returns a success message or an error if the booking doesn't exist.

Instructions for Running the API Locally
Clone the repository:

bash

git clone <repository-url>
cd booking-management-api
Configure the database in application.properties:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Build and run the application:

bash

./mvnw spring-boot:run
Access the API at http://localhost:8080
