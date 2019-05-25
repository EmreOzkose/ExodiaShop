
<%
    Cookie cookie = null;
    Cookie[] cookies = null;

    String loggedUsername = "";
    String lang = "";

    // Get an array of Cookies associated with the this domain
    cookies = request.getCookies();

    if( cookies != null ) {
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            System.out.println(cookie.getName());

            if (cookie.getName().equals("lang"))
                lang = cookie.getValue( );
            else if (cookie.getName().equals("loggedUsername"))
                loggedUsername = cookie.getValue( );

        }
    }
    pageContext.setAttribute("lang", lang);
    pageContext.setAttribute("loggedUsername", loggedUsername);
%>