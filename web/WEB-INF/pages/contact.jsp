<%@include file="/WEB-INF/templates/bodyHeader.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <form method="post" action="/contact">
            <table border="0" width="80%">
                <tr>
                    <td><spring:message code="contact.subject"/>:</td>
                    <td><input type="text" name="subject" size="65"/></td>
                </tr>
                <tr>
                    <td><spring:message code="contact.message"/>:</td>
                    <td><textarea cols="50" rows="10" name="message"></textarea></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="<spring:message code="contact.send"/>"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="/WEB-INF/templates/footer.jsp" %>
</body>

</html>