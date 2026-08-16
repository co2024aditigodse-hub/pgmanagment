# PGF (Paying Guest Facility) Management System - API Documentation

## Overview
This is a complete REST API for managing Paying Guest Facilities. The system handles user authentication, room bookings, payments, complaints, and notices.

---

## 1. **Authentication APIs** (`/api/auth`)
Base URL: `/api/auth`

### 1.1 Register User
- **Endpoint:** `POST /api/auth/register`
- **Description:** Register a new user account
- **Request Body:**
  ```json
  {
    "username": "string",
    "email": "string",
    "password": "string",
    "name": "string"
  }
  ```
- **Response:** String (success message)
- **What happens:** Creates a new user account in the system

### 1.2 Login User
- **Endpoint:** `POST /api/auth/login`
- **Description:** Authenticate user and get JWT token
- **Request Body:**
  ```json
  {
    "username": "string",
    "password": "string"
  }
  ```
- **Response:**
  ```json
  {
    "token": "JWT token string",
    "user": { user details }
  }
  ```
- **What happens:** Verifies credentials and returns authentication token for subsequent API calls

---

## 2. **User Management APIs** (`/api/users`)
Base URL: `/api/users`

### 2.1 Create User
- **Endpoint:** `POST /api/users`
- **Description:** Register a new user
- **Request Body:** RegisterDto object
- **Response:** UserDto object
- **What happens:** Creates new user and stores in database

### 2.2 Get All Users
- **Endpoint:** `GET /api/users`
- **Description:** Fetch all users from system
- **Response:** List of UserDto objects
- **What happens:** Returns list of all registered users

### 2.3 Get User by ID
- **Endpoint:** `GET /api/users/{id}`
- **Description:** Fetch specific user details
- **Path Parameter:** `id` (Long) - User ID
- **Response:** UserDto object
- **What happens:** Retrieves detailed information for a specific user

### 2.4 Update User
- **Endpoint:** `PUT /api/users/{id}`
- **Description:** Update user information
- **Path Parameter:** `id` (Long) - User ID
- **Request Body:** UserDto object (updated data)
- **Response:** UserDto object (updated)
- **What happens:** Modifies user profile information

### 2.5 Delete User
- **Endpoint:** `DELETE /api/users/{id}`
- **Description:** Remove user from system
- **Path Parameter:** `id` (Long) - User ID
- **Response:** "User Deleted Successfully"
- **What happens:** Permanently deletes user account and associated data

---

## 3. **PG (Paying Guest) Management APIs** (`/api/pg`)
Base URL: `/api/pg`

### 3.1 Create PG
- **Endpoint:** `POST /api/pg`
- **Description:** Add new PG facility
- **Request Body:** PgDto object
- **Response:** PgDto object
- **What happens:** Registers new paying guest accommodation facility in system

### 3.2 Get All PGs
- **Endpoint:** `GET /api/pg`
- **Description:** Fetch all PG facilities
- **Response:** List of PgDto objects
- **What happens:** Returns list of all available PG facilities

### 3.3 Get PG by ID
- **Endpoint:** `GET /api/pg/{id}`
- **Description:** Fetch specific PG facility details
- **Path Parameter:** `id` (Long) - PG ID
- **Response:** PgDto object
- **What happens:** Retrieves detailed information about a specific PG facility

### 3.4 Update PG
- **Endpoint:** `PUT /api/pg/{id}`
- **Description:** Update PG facility information
- **Path Parameter:** `id` (Long) - PG ID
- **Request Body:** PgDto object (updated data)
- **Response:** PgDto object (updated)
- **What happens:** Modifies PG facility details like amenities, price, capacity

### 3.5 Delete PG
- **Endpoint:** `DELETE /api/pg/{id}`
- **Description:** Remove PG facility
- **Path Parameter:** `id` (Long) - PG ID
- **Response:** "PG Deleted Successfully"
- **What happens:** Permanently removes PG facility and all associated rooms

---

## 4. **Room Management APIs** (`/api/rooms`)
Base URL: `/api/rooms`

### 4.1 Create Room
- **Endpoint:** `POST /api/rooms`
- **Description:** Add new room to a PG
- **Request Body:** RoomDto object
- **Response:** RoomDto object
- **What happens:** Creates new room with details like room number, type, capacity, price

### 4.2 Get All Rooms
- **Endpoint:** `GET /api/rooms`
- **Description:** Fetch all available rooms
- **Response:** List of RoomDto objects
- **What happens:** Returns list of all rooms across all PGs

### 4.3 Get Room by ID
- **Endpoint:** `GET /api/rooms/{id}`
- **Description:** Fetch specific room details
- **Path Parameter:** `id` (Long) - Room ID
- **Response:** RoomDto object
- **What happens:** Retrieves detailed information about a specific room

### 4.4 Update Room
- **Endpoint:** `PUT /api/rooms/{id}`
- **Description:** Update room information
- **Path Parameter:** `id` (Long) - Room ID
- **Request Body:** RoomDto object (updated data)
- **Response:** RoomDto object (updated)
- **What happens:** Modifies room details like availability, price, furnishing status

### 4.5 Delete Room
- **Endpoint:** `DELETE /api/rooms/{id}`
- **Description:** Remove room
- **Path Parameter:** `id` (Long) - Room ID
- **Response:** "Room Deleted Successfully"
- **What happens:** Permanently deletes room from system

---

## 5. **Booking Management APIs** (`/api/bookings`)
Base URL: `/api/bookings`

### 5.1 Create Booking
- **Endpoint:** `POST /api/bookings`
- **Description:** Create new room booking
- **Request Body:** BookingDto object
- **Response:** BookingDto object
- **What happens:** Books a room for a user with check-in and check-out dates

### 5.2 Get All Bookings
- **Endpoint:** `GET /api/bookings`
- **Description:** Fetch all bookings
- **Response:** List of BookingDto objects
- **What happens:** Returns list of all bookings in the system

### 5.3 Get Booking by ID
- **Endpoint:** `GET /api/bookings/{id}`
- **Description:** Fetch specific booking details
- **Path Parameter:** `id` (Long) - Booking ID
- **Response:** BookingDto object
- **What happens:** Retrieves detailed information about a specific booking

### 5.4 Update Booking
- **Endpoint:** `PUT /api/bookings/{id}`
- **Description:** Update booking information
- **Path Parameter:** `id` (Long) - Booking ID
- **Request Body:** BookingDto object (updated data)
- **Response:** BookingDto object (updated)
- **What happens:** Modifies booking dates, room, or status

### 5.5 Cancel/Delete Booking
- **Endpoint:** `DELETE /api/bookings/{id}`
- **Description:** Cancel or remove booking
- **Path Parameter:** `id` (Long) - Booking ID
- **Response:** "Booking Deleted Successfully"
- **What happens:** Cancels the booking and frees up the room

---

## 6. **Payment Management APIs** (`/api/payments`)
Base URL: `/api/payments`

### 6.1 Create Payment
- **Endpoint:** `POST /api/payments`
- **Description:** Record new payment transaction
- **Request Body:** PaymentDto object
- **Response:** PaymentDto object
- **What happens:** Records payment for booking (rent, deposits, fees)

### 6.2 Get All Payments
- **Endpoint:** `GET /api/payments`
- **Description:** Fetch all payment records
- **Response:** List of PaymentDto objects
- **What happens:** Returns list of all payment transactions

### 6.3 Get Payment by ID
- **Endpoint:** `GET /api/payments/{id}`
- **Description:** Fetch specific payment details
- **Path Parameter:** `id` (Long) - Payment ID
- **Response:** PaymentDto object
- **What happens:** Retrieves detailed information about a specific payment

### 6.4 Update Payment
- **Endpoint:** `PUT /api/payments/{id}`
- **Description:** Update payment information
- **Path Parameter:** `id` (Long) - Payment ID
- **Request Body:** PaymentDto object (updated data)
- **Response:** PaymentDto object (updated)
- **What happens:** Modifies payment status or amount

### 6.5 Delete Payment
- **Endpoint:** `DELETE /api/payments/{id}`
- **Description:** Remove payment record
- **Path Parameter:** `id` (Long) - Payment ID
- **Response:** "Payment Deleted Successfully"
- **What happens:** Deletes payment transaction from records

---

## 7. **Complaint Management APIs** (`/api/complaints`)
Base URL: `/api/complaints`

### 7.1 Create Complaint
- **Endpoint:** `POST /api/complaints`
- **Description:** Register new complaint
- **Request Body:** ComplaintDto object
- **Response:** ComplaintDto object
- **What happens:** Creates complaint ticket for maintenance, noise, or other issues

### 7.2 Get All Complaints
- **Endpoint:** `GET /api/complaints`
- **Description:** Fetch all complaints
- **Response:** List of ComplaintDto objects
- **What happens:** Returns list of all complaints in the system

### 7.3 Get Complaint by ID
- **Endpoint:** `GET /api/complaints/{id}`
- **Description:** Fetch specific complaint details
- **Path Parameter:** `id` (Long) - Complaint ID
- **Response:** ComplaintDto object
- **What happens:** Retrieves detailed information about a specific complaint

### 7.4 Update Complaint
- **Endpoint:** `PUT /api/complaints/{id}`
- **Description:** Update complaint information
- **Path Parameter:** `id` (Long) - Complaint ID
- **Request Body:** ComplaintDto object (updated data)
- **Response:** ComplaintDto object (updated)
- **What happens:** Modifies complaint status, priority, or description

### 7.5 Delete Complaint
- **Endpoint:** `DELETE /api/complaints/{id}`
- **Description:** Remove complaint
- **Path Parameter:** `id` (Long) - Complaint ID
- **Response:** "Complaint Deleted Successfully"
- **What happens:** Deletes complaint from system

---

## 8. **Notice Management APIs** (`/api/notices`)
Base URL: `/api/notices`

### 8.1 Create Notice
- **Endpoint:** `POST /api/notices`
- **Description:** Post new notice
- **Request Body:** NoticeDto object
- **Response:** NoticeDto object
- **What happens:** Creates notice for all residents (maintenance, events, rules)

### 8.2 Get All Notices
- **Endpoint:** `GET /api/notices`
- **Description:** Fetch all notices
- **Response:** List of NoticeDto objects
- **What happens:** Returns list of all posted notices

### 8.3 Get Notice by ID
- **Endpoint:** `GET /api/notices/{id}`
- **Description:** Fetch specific notice details
- **Path Parameter:** `id` (Long) - Notice ID
- **Response:** NoticeDto object
- **What happens:** Retrieves detailed information about a specific notice

### 8.4 Update Notice
- **Endpoint:** `PUT /api/notices/{id}`
- **Description:** Update notice information
- **Path Parameter:** `id` (Long) - Notice ID
- **Request Body:** NoticeDto object (updated data)
- **Response:** NoticeDto object (updated)
- **What happens:** Modifies notice content or expiration date

### 8.5 Delete Notice
- **Endpoint:** `DELETE /api/notices/{id}`
- **Description:** Remove notice
- **Path Parameter:** `id` (Long) - Notice ID
- **Response:** "Notice Deleted Successfully"
- **What happens:** Archives or permanently removes notice

---

## 9. **Role Management APIs** (`/api/roles`)
Base URL: `/api/roles`

### 9.1 Create Role
- **Endpoint:** `POST /api/roles`
- **Description:** Create new role
- **Request Body:** Role object
- **Response:** Role object
- **What happens:** Defines new user role (Admin, Manager, Tenant, etc.)

### 9.2 Get All Roles
- **Endpoint:** `GET /api/roles`
- **Description:** Fetch all available roles
- **Response:** List of Role objects
- **What happens:** Returns list of all system roles

### 9.3 Get Role by ID
- **Endpoint:** `GET /api/roles/{id}`
- **Description:** Fetch specific role details
- **Path Parameter:** `id` (Long) - Role ID
- **Response:** Role object
- **What happens:** Retrieves detailed information about a specific role

### 9.4 Delete Role
- **Endpoint:** `DELETE /api/roles/{id}`
- **Description:** Remove role
- **Path Parameter:** `id` (Long) - Role ID
- **Response:** "Role Deleted Successfully"
- **What happens:** Deletes role from system (cannot delete if assigned to users)

---

## Summary Statistics

| Category | Count |
|----------|-------|
| Total Endpoints | 45 |
| Controllers | 9 |
| Authentication Endpoints | 2 |
| CRUD Operations | 43 |

### HTTP Methods Used:
- **POST** - Create/Register (9)
- **GET** - Retrieve (18)
- **PUT** - Update (9)
- **DELETE** - Delete (9)

---

## Security Features
- JWT Authentication for protected endpoints
- Role-based access control
- Password encryption
- User session management

---

## Error Handling
- Global exception handler implemented
- ResourceNotFoundException for missing resources
- Proper HTTP status codes returned

---

## Data Models
Each entity has an associated DTO for API communication:
- **User** ↔ UserDto
- **PG** ↔ PgDto
- **Room** ↔ RoomDto
- **Booking** ↔ BookingDto
- **Payment** ↔ PaymentDto
- **Complaint** ↔ ComplaintDto
- **Notice** ↔ NoticeDto
- **Role** (used directly)
