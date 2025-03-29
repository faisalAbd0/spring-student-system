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
<h1>Welcome Student Dashboard</h1>
<h2>Student Name: ${username}</h2>


<table>
    <thead>
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
        <th>Grade</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach var="grade" items="${grades}">

        <tr>
            <td>${grade.course.courseId}</td>
            <td>${grade.course.courseName}</td>
            <td>${grade.grade}</td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
        <a href="${pageContext.request.contextPath}/student/profile">Profile</a>
    </tfoot>

</table>

</body>
</html>