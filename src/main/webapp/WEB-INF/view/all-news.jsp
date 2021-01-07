<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<body>

<h2>The list of the news</h2>
<table>
    <tr>
        <th>Date</th>
        <th>Title</th>
        <th>Brief</th>
        <th>Content</th>
        <th>User</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="news" items="${allNews}">
        <c:url var="editButton" value="/editInfo">
            <c:param name="newsId" value="${news.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteNews">
            <c:param name="newsId" value="${news.id}"/>
        </c:url>

        <tr>
            <td>${news.news_date}</td>
            <td>${news.title}</td>
            <td>${news.brief}</td>
            <td>${news.content}</td>
            <td>
                <security:authorize access="hasRole('ADMIN')">
                <input type="button" value="edit"
                onclick="window.location.href ='${editButton}'"/>

                <input type="button" value="delete"
                       onclick="window.location.href ='${deleteButton}'"/>
                </security:authorize>
            </td>
        </tr>
    </c:forEach>
</table>

<br>
<br>

<security:authorize access="hasRole('ADMIN')">
<input type="button" value="Add"
onclick="window.location.href = 'addNewNews'">
</security:authorize>

</body>
</html>