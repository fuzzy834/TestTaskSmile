<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://testtask.com/functions" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">

    <script type="text/javascript">
        var localeCode = "${pageContext.response.locale}";
        function show(lang) {
            window.location.href = window.location.href.split('?')[0] + '?lang=' + lang;
        }
    </script>

</head>
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/"><spring:message code="title"/></a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/"><spring:message code="home"/></a></li>
                        <li><a href="/contact"><spring:message code="contacts"/></a></li>

                    </ul>
                    <ul class="nav navbar-nav navbar-right" style="margin-right: 15px;">
                        <li class="dropdown" id="lang-dropdown">
                            <a class="navbar-link" role="button" data-toggle="dropdown"
                               aria-haspopup="true" id="lang-button">${pageContext.response.locale}<span
                                    class="caret"></span></a>
                            <ul class="dropdown-menu dropdown-menu-right">
                                <li><a onclick="show('en')">English</a></li>
                                <li><a onclick="show('fr')">Français</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>