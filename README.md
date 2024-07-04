
# Doctor-Patient Management Platform

## Overview

This project aims to create a Doctor-Patient Management Platform where doctors can register patients via a mobile or web portal. The platform incorporates backend APIs to manage tasks like adding doctors and their specialties, inputting patient details including symptoms, and recommending suitable doctors based on patient symptoms and location.

## Technologies Used
* Java
* Spring Boot - for building the REST APIs
* Hibernate - for database operations
* MySQL - as the database
* Swagger - for API documentation

## Doctor’s entity
In our database we will have the doctor's name, city, email, phone number, and speciality.
* City can have 3 values only i.e. Delhi, Noida, Faridabad
* Speciality can have 4 values i.e. Orthopaedic, Gynecology, Dermatology, ENT specialist.
A doctor can be added or removed from the platform.
## Patient’s entity
In our database we will have the patient's name, city, email, phone number, and symptom.
* City can have any value
* Symptom can have the following values only
1. Arthritis, Back Pain, Tissue injuries (comes under Orthopaedic speciality)
2. Dysmenorrhea (comes under Gynecology speciality)
3. Skin infection, skin burn (comes under Dermatology speciality)
4.  Ear pain (comes under ENT speciality)

A patient can be added or removed from the platform.

https://github.com/Ishi2001/Doctor_Patients-API/assets/71957301/89a5cfe2-0ebc-46aa-808d-38a0d530722b


![Screenshot 2024-07-04 123246](https://github.com/Ishi2001/Doctor_Patients-API/assets/71957301/f79d0b58-9c5e-408c-9d11-acb2385b4212)
![Screenshot 2024-07-04 123346](https://github.com/Ishi2001/Doctor_Patients-API/assets/71957301/549e6492-55e3-4029-a822-26451a66df79)
![Screenshot 2024-07-04 123403](https://github.com/Ishi2001/Doctor_Patients-API/assets/71957301/bb5ee04a-16e8-4a33-af86-33bb4cefd4c9)

Implemented the following endpoints:

**Doctor-controller**

1. GET/doctors/{id}
2. PUT/doctors/{id}
3. DELETE/doctors/{id}
4. GET/doctors
5. POST/doctors
   
**Patient-controller**

1. GET/patients/{id}
2. PUT/patients/{id}
3. DELETE/patients/{id}
4. GET/patients
5. POST/patients

**Suggestion-controller**

GET/suggestions/{patientId}

Open your browser and go to http://localhost:8080/swagger-ui.html to view and test the APIs.
