<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Profile</title>
<%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/profile.css">--%>
<%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css">--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
${errorMessage}
<div class="profile-container">
    <div class="profile-header">
        <h2>Student Profile</h2>
    </div>

    <div class="info-row">
        <span class="info-label">Name:</span>
        <span>${student.username}</span>
    </div>

    <div class="info-row">
        <span class="info-label">Student ID:</span>
        <span>${student.id}</span>
    </div>

    <div class="info-row">
        <span class="info-label">Age:</span>
        <span>${student.age}</span>
    </div>

    <div class="info-row">
        <span class="info-label">GPA:</span>
        <span>${student.gpa}</span>
    </div>

    <div class="nav-links">
        <a href="${pageContext.request.contextPath}/student/dashboard">Dashboard</a>
    </div>
</div>
</body>
</html>