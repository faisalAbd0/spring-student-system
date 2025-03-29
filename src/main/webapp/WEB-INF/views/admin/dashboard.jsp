<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css">--%>
    <script type="text/javascript">
        function showTable(tableId) {
            document.getElementById("studentsTable").style.display = "none";
            document.getElementById("instructorsTable").style.display = "none";
            document.getElementById("coursesTable").style.display = "none";

            document.getElementById(tableId).style.display = "table";
        }
    </script>
</head>
<body>
<h1>Admin Dashboard</h1>

<!-- Buttons to toggle between tables -->
<div>
    <button onclick="showTable('coursesTable')">Show Courses</button>
    <button onclick="showTable('instructorsTable')">Show Instructors</button>
    <button onclick="showTable('studentsTable')">Show Students</button>
</div>


<!-- Tables to show data -->
<h2>Courses</h2>
<table id="coursesTable" style="display:none;">
    <thead>
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
        <th>Student Limit</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.courseId}</td>
            <td>${course.courseName}</td>
            <td>${course.studentLimit}</td>
            <td>
                <form action="${pageContext.request.contextPath}/admin/deleteCourse" method="POST">
                    <input type="hidden" name="courseId" value="${course.courseId}">
                    <input type="submit" value="Delete Course">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Instructors</h2>
<table id="instructorsTable" style="display:none;">
    <thead>
    <tr>
        <th>Instructor ID</th>
        <th>Username</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="instructor" items="${instructors}">
        <tr>
            <td>${instructor.id}</td>
            <td>${instructor.username}</td>
            <td>

                <form action="${pageContext.request.contextPath}/admin/deleteInstructor" method="POST">
                    <input type="hidden" name="instructorId" value="${instructor.id}">
                    <input type="submit" value="Delete Instructor">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Students</h2>
<table id="studentsTable" style="display:none;">
    <thead>
    <tr>
        <th>Student ID</th>
        <th>Username</th>
        <th>GPA</th>
        <th>Age</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.username}</td>
            <td>${student.gpa}</td>
            <td>${student.age}</td>
            <td>
                <form action="${pageContext.request.contextPath}/admin/deleteStudent" method="POST">
                    <input type="hidden" name="studentId" value="${student.id}">
                    <input type="submit" value="Delete Student">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<!-- Forms for Adding Entities -->
<h2>Add New Course</h2>
<%--<form action="/addCourse" method="POST">--%>
<form action="${pageContext.request.contextPath}/admin/addCourse" method="POST">
    <label for="courseName">Course Name:</label>
    <input type="text" id="courseName" name="courseName" required><br>
    <label for="studentLimit">Student Limit:</label>
    <input type="number" id="studentLimit" name="studentLimit" required><br>
    <input type="submit" value="Add Course">
</form>

<h2>Add New Instructor</h2>
<form action="${pageContext.request.contextPath}/admin/addInstructor" method="POST">
    <label for="instructorUsername">Instructor Username:</label>
    <input type="text" id="instructorUsername" name="instructorUsername" required><br>
    <label for="instructorPassword">Instructor Password:</label>
    <input type="password" id="instructorPassword" name="instructorPassword" required><br>
    <input type="submit" value="Add Instructor">
</form>

<h2>Add New Student</h2>
<form action="${pageContext.request.contextPath}/admin/addStudent" method="POST">
    <label for="studentUsername">Student Username:</label>
    <input type="text" id="studentUsername" name="studentUsername" required><br>
    <label for="studentPassword">Student Password:</label>
    <input type="password" id="studentPassword" name="studentPassword" required><br>
    <label for="studentGpa">GPA:</label>
    <input type="number" step="0.1" id="studentGpa" name="studentGpa" required><br>
    <label for="studentAge">Age:</label>
    <input type="number" id="studentAge" name="studentAge" required><br>
    <input type="submit" value="Add Student">
</form>
</body>
</html>
