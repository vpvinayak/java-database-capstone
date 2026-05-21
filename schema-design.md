# Schema Design – Smart Clinic Management System

## MySQL Database Schema

The Smart Clinic system uses MySQL as the relational database for structured data such as doctors, patients, appointments, and admin users.

---

# 1. Doctors Table

| Field Name | Data Type | Constraints |
|-------------|-----------|-------------|
| doctor_id | BIGINT | PRIMARY KEY, AUTO_INCREMENT |
| name | VARCHAR(100) | NOT NULL |
| specialty | VARCHAR(100) | NOT NULL |
| email | VARCHAR(100) | UNIQUE, NOT NULL |
| phone | VARCHAR(15) | NOT NULL |

Purpose:
Stores doctor profile and specialty information.

---

# 2. Patients Table

| Field Name | Data Type | Constraints |
|-------------|-----------|-------------|
| patient_id | BIGINT | PRIMARY KEY, AUTO_INCREMENT |
| name | VARCHAR(100) | NOT NULL |
| gender | VARCHAR(10) | NOT NULL |
| age | INT | NOT NULL |
| email | VARCHAR(100) | UNIQUE |
| phone | VARCHAR(15) | UNIQUE |

Purpose:
Stores patient personal and contact information.

---

# 3. Appointments Table

| Field Name | Data Type | Constraints |
|-------------|-----------|-------------|
| appointment_id | BIGINT | PRIMARY KEY, AUTO_INCREMENT |
| doctor_id | BIGINT | FOREIGN KEY |
| patient_id | BIGINT | FOREIGN KEY |
| appointment_time | DATETIME | NOT NULL |
| status | VARCHAR(20) | DEFAULT 'Booked' |

Foreign Keys:
- doctor_id → Doctors(doctor_id)
- patient_id → Patients(patient_id)

Purpose:
Stores appointment bookings between doctors and patients.

---

# 4. Admin Users Table

| Field Name | Data Type | Constraints |
|-------------|-----------|-------------|
| admin_id | BIGINT | PRIMARY KEY, AUTO_INCREMENT |
| username | VARCHAR(50) | UNIQUE |
| password | VARCHAR(255) | NOT NULL |
| role | VARCHAR(20) | DEFAULT 'ADMIN' |

Purpose:
Stores administrator login credentials.

---

## Entity Relationships

1. One Doctor → Many Appointments  
2. One Patient → Many Appointments  
3. Admin Users manage Doctors and Appointments

---

## MongoDB Schema

MongoDB stores flexible document-based medical records and prescriptions.

### Prescription Collection

```json
{
  "_id": "ObjectId",
  "patientId": 1,
  "doctorId": 2,
  "medications": [
    {
      "name": "Paracetamol",
      "dosage": "500mg"
    }
  ],
  "notes": "Take after meals"
}
