# InterAIview

**InterAIview** is a full-stack AI-powered web application that helps users **analyze resumes**, **prepare for interviews**, and **track their interview journey** - all in one place.

---

## What This Web App Does

* **Resume Analyzer:**

* Upload resume (PDF)

* Paste Job Description

* Get:

  * Match score
  * Matched & missing skills
  * AI-generated resume feedback

* **AI Interview Assistant:**

  * Section-based interview questions:

    * Introduction, Technical, Behavioral, HR, Group Discussion
  * Voice + text answers
  * AI evaluates answers with score & feedback

* **Authentication:**

  * Signup & Login
  * Session-based authentication (Spring Boot)
  * Persistent login support (can be extended)

* **User History:**

  * Resume analysis history
  * Interview Q&A + AI feedback history
  * User-specific data stored securely

---

## Tech Stack

### Frontend

* HTML, CSS
* Spring Boot MVC

### Backend

* Spring Boot (Java)
* REST Controllers

### Database

* MongoDB Atlas

### AI Integration

* Google Gemini API
* Model: `gemini-2.5-flash`
* Used for:

  * Resume feedback
  * Resume–JD match analysis
  * Interview question generation
  * Answer evaluation

---

## Running Locally

### Backend

```bash
git clone https://github.com//sonig-07/interaiview.git
cd interaiview
./mvnw spring-boot:run
```

Application runs at:

```bash
http://localhost:8080
```

---

## Screenshots

<img width="1251" height="669" alt="1" src="https://github.com/user-attachments/assets/0fe9ec7e-540c-4af2-b020-66e8b457a638" />

<img width="1845" height="911" alt="2" src="https://github.com/user-attachments/assets/086bcdfe-a7e0-4d09-aec2-0e3b4427c6ac" />

<img width="1920" height="924" alt="3" src="https://github.com/user-attachments/assets/7434761f-a6cc-4bd3-bb82-8e306c6ba4e2" />


---

## Author

SoniG07

---




