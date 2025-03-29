<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Dashboard</title>
<%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/table.css">--%>
<%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css">--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
${errorMessage}
<h1>Welcome to the Student Dashboard</h1>
<h2>Student Name: ${username}</h2>

<!-- Table to display list of students and their grades -->
<table>
    <thead>
    <tr>
        <th>Student ID</th>
        <th>Username</th>
        <th>Age</th>
        <th>GPA</th>
        <th>Grade</th>
    </tr>
    </thead>
    <tbody>
    <!-- Iterate over the map entries -->
    <c:forEach var="entry" items="${students.entrySet()}">
        <tr>
            <td>${entry.key.id}</td>
            <td>${entry.key.username}</td>
            <td>${entry.key.age}</td>
            <td>${entry.key.gpa}</td>
            <td>${entry.value}</td> <!-- Grade is the value in the map -->
        </tr>
    </c:forEach>
    </tbody>


</table>


<h2>Average: ${status[0]}</h2>
<h2>Min: ${status[1]}</h2>
<h2>Max: ${status[2]}</h2>

<h1>Change Grade:</h1>

<form action="${pageContext.request.contextPath}/instructor/students?courseId=${courseId}" method="POST">

    <label>Student Id:</label><br>
    <input type="text"  name="studentId" value=""><br>

    <label>New Grade:</label><br>
    <input type="text"  name="newGrade" value=""><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
