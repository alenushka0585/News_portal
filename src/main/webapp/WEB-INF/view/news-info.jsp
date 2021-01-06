<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<body>

<h2>News Info</h2>
<br>

<form:form action="saveNews" modelAttribute="news">
    <form:hidden path="id"/>

    Title <form:input path="title"/>
    <br>
    Brief <form:input path="brief"/>
    <br>
    Content <form:input path="content"/>
    <br>
    <input type="submit" value="save">

</form:form>

</body>