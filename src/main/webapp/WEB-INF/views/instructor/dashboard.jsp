<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>instructor Dashboard</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css">--%>

</head>
<body>
${errorMessage}
<h1>Welcome instructor Dashboard</h1>
<h2>instructor Name: ${username}</h2>
<h2>instructor ID: ${userId}</h2>


<table>
    <thead>
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
        <th>Student Limit</th>
        <th>Actions</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.courseId}</td>
            <td>${course.courseName}</td>
            <td>${course.studentLimit}</td>
            <td>
                <a href="${pageContext.request.contextPath}/instructor/students?courseId=${course.courseId}">
                    View Students
                </a>
            </td>

        </tr>
    </c:forEach>

    </tbody>


</table>

</body>
</html>