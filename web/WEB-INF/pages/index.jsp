<%@include file="/WEB-INF/templates/bodyHeader.jsp" %>
<div class="container marketing">
    <div class="row">
        <c:forEach items="${news}" var="item">
            <jsp:useBean id="item" class="com.testtask.model.News" scope="page"/>
            <div class="col-lg-4">
                <img class="img-responsive "
                     src="${item.imageLink}"
                     alt="Generic placeholder image" width="140" height="140">

                <div id="date">${f:dateTimeResolver(item.dateTime, "dd/MM/yyyy")}</div>
                <h2>${item.title}</h2>
                <p>${item.content}</p>
                <p>${item.location}</p>
                <p><a class="btn btn-default" href="${item.link}" role="button"><spring:message
                        code="main.details"/> &raquo;</a></p>
            </div>
        </c:forEach>
    </div>
</div>
<%@include file="/WEB-INF/templates/footer.jsp" %>
</body>

</html>
