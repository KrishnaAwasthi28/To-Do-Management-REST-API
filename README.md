<h1 align="center">📝 To-Do Management REST API</h1>

<p align="center">
  A secure, scalable backend REST API for managing personal tasks, built using 
  <b>Spring Boot</b>, <b>Spring Security</b>, and <b>JPA/Hibernate</b>.
</p>

<hr/>

<h2>🚀 Features</h2>
<ul>
  <li>User registration with encrypted passwords (BCrypt)</li>
  <li>Secure authentication using Spring Security</li>
  <li>Create, Read, Update, Delete (CRUD) operations for tasks</li>
  <li>User-specific task management (ownership based access)</li>
  <li>Task status management (PENDING, IN_PROGRESS, COMPLETED)</li>
  <li>Task priority support (LOW, MEDIUM, HIGH)</li>
  <li>Automatic timestamps using JPA lifecycle callbacks</li>
</ul>

<hr/>

<h2>🛠️ Tech Stack</h2>
<ul>
  <li><b>Java</b></li>
  <li><b>Spring Boot</b></li>
  <li><b>Spring Security</b></li>
  <li><b>Spring Data JPA (Hibernate)</b></li>
  <li><b>MySQL</b></li>
  <li><b>BCrypt Password Encoder</b></li>
  <li><b>Maven</b></li>
</ul>

<hr/>

<h2>📂 Project Structure</h2>

<pre>
com.github.todoapi
│
├── config          → Security configuration
├── controller      → REST controllers
├── dto             → Request & response DTOs
├── entity          → JPA entities
├── enums           → Task status & priority enums
├── repository      → JPA repositories
├── service         → Business logic
└── TodoApiApplication.java
</pre>

<hr/>

<h2>🔐 Authentication</h2>
<p>
  This project uses <b>Spring Security with HTTP Basic Authentication</b>.
  All task-related APIs are protected and require valid user credentials.
</p>

<p><b>Username:</b> User Email<br/>
<b>Password:</b> Plain password (verified using BCrypt internally)</p>

<hr/>

<h2>📌 API Endpoints</h2>

<h3>🔑 Authentication APIs</h3>
<table border="1" cellpadding="8">
  <tr>
    <th>Method</th>
    <th>Endpoint</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>POST</td>
    <td>/api/auth/register</td>
    <td>Register a new user</td>
  </tr>
</table>

<hr/>

<h3>📝 Task APIs (Protected)</h3>
<table border="1" cellpadding="8">
  <tr>
    <th>Method</th>
    <th>Endpoint</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>POST</td>
    <td>/api/tasks</td>
    <td>Create a new task</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/api/tasks</td>
    <td>Get all tasks for logged-in user</td>
  </tr>
  <tr>
    <td>PUT</td>
    <td>/api/tasks/{id}</td>
    <td>Update an existing task</td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>/api/tasks/{id}</td>
    <td>Delete a task</td>
  </tr>
  <tr>
    <td>PATCH</td>
    <td>/api/tasks/{id}/status</td>
    <td>Update task status</td>
  </tr>
  <tr>
    <td>PATCH</td>
    <td>/api/tasks/{id}/complete</td>
    <td>Mark task as completed</td>
  </tr>
</table>

<hr/>

<h2>📤 Sample Request – Create Task</h2>

<pre>
POST /api/tasks
Authorization: Basic base64(email:password)
Content-Type: application/json

{
  "title": "Learn Spring Security",
  "description": "Understand authentication flow",
  "priority": "HIGH",
  "dueDate": "2026-01-30"
}
</pre>

<hr/>

<h2>📥 Sample Response</h2>

<pre>
{
  "id": 1,
  "title": "Learn Spring Security",
  "status": "PENDING"
}
</pre>

<hr/>

<h2>🧠 Key Concepts Implemented</h2>
<ul>
  <li>DTO-based request/response handling</li>
  <li>Entity relationships using JPA (@ManyToOne)</li>
  <li>Secure user context via SecurityContextHolder</li>
  <li>Ownership-based authorization</li>
  <li>Validation to prevent invalid DB inserts</li>
</ul>

<hr/>

<h2>🧪 How to Run the Project</h2>
<ol>
  <li>Clone the repository</li>
  <li>Configure MySQL credentials in <code>application.properties</code></li>
  <li>Run the application using your IDE or <code>mvn spring-boot:run</code></li>
  <li>Test APIs using Postman</li>
</ol>

<hr/>

<h2>🚧 Future Enhancements</h2>
<ul>
  <li>JWT based authentication</li>
  <li>Pagination & filtering</li>
  <li>Global exception handling</li>
  <li>Swagger/OpenAPI documentation</li>
</ul>

<hr/>

<h2>👨‍💻 Author</h2>
<p>
  <b>Krishna Awasthi</b><br/>
  SDE | Backend Developer | Java & Spring Boot
</p>

<p align="center">
  ⭐ If you found this project useful, consider starring the repository!
</p>
