<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Exodia Dashboard</title>

    <!-- Bootstrap styles -->
    <!--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
    <link href="/libs/bootstrap.css" rel="stylesheet"/>
    <link href="/libs/style.css" rel="stylesheet"/>
    <link href="/libs/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link rel="shortcut icon" href="/img/logos/favicon.ico">


</head>
<body>





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
