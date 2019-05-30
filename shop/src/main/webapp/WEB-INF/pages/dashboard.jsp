<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    // Create cookies for first and last names.
    Cookie loggedUsernameCookie = new Cookie("loggedUsernameCookie", request.getParameter("loggedUsername"));

    String lang_s = request.getParameter("lang");
    Cookie lang = new Cookie("lang", lang_s);

    loggedUsernameCookie.setMaxAge(60*60*24);
    lang.setMaxAge(60*60*24);

    response.addCookie( loggedUsernameCookie );
    response.addCookie( lang );
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- Add language option-->
    <c:if test="${lang.equals('tr')}">
        <jsp:include page="/languages/tr.jsp" />
    </c:if>
    <c:if test="${lang.equals('en')}">
        <jsp:include page="/languages/en.jsp" />
    </c:if>


    <title>${dashboard_text}</title>

    <!-- Bootstrap styles -->
    <!--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
    <link href="/libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>
    <link href="/libs/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link rel="shortcut icon" href="/img/logos/favicon.ico">

    <script type='text/javascript'>
        (function(){
            if( window.localStorage ){
                if( !localStorage.getItem('firstLoad') ){
                    localStorage['firstLoad'] = true;
                    window.location.reload();
                }
                else
                    localStorage.removeItem('firstLoad');
            }
        })();

    </script>
</head>
<body>

${lang}
<div class="container">
    <jsp:include page="/components/header.jsp" />
    <jsp:include page="/components/navbar.jsp" />

    <div class="row">

        <div class="col-md-3">
            <jsp:include page="/components/sidebar.jsp" />
        </div>

        <div class="col-md-9">
            <jsp:include page="/components/cartPage.jsp" />
        </div>

    </div>

</body>
</html>
