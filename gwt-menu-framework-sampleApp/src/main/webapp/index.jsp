<%@ page session="false" contentType="text/html;charset=utf-8" %>
<%-- see http://turbomanage.wordpress.com/2009/12/11/how-to-inject-guice-objects-in-a-jsp/ --%>
<%@ page import="com.google.inject.Guice" %>
<%@ page import="com.google.inject.Injector" %>
<%@ page import="com.google.inject.Key" %>
<%@ page import="com.google.inject.name.Names" %>
<%@ page import="com.teamtter.tests.ServerUser" %>
<%
    Injector injector = (Injector) pageContext.getServletContext().getAttribute(Injector.class.getName());
    ServerUser user = injector.getInstance(ServerUser.class);
    String logoutUrl = injector.getInstance(Key.get(String.class, Names.named("app.logoutUrl")));
%>
<%!
    private String htmlEscape(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;");
    }
%>
<!doctype html>
<html>
  <head>
    <meta charset=UTF-8>

    <%--                                                               --%>
    <%-- Consider inlining CSS to reduce the number of requested files --%>
    <%--                                                               --%>
    <link type="text/css" rel="stylesheet" href="static/gwtmenuframework.css">

    <%--                                           --%>
    <%-- Any title is fine                         --%>
    <%--                                           --%>
    <title>Web Application Starter Project</title>

    <%-- Tell GWT where to find its permutations, as we inline the *.nocache.js --%>
    <meta name="app::gwt:property" content='baseUrl=app/'>
  </head>

  <body>
    <noscript>
      <div style="width: 22em; position: absolute; left: 50%; margin-left: -11em; color: red; background-color: white; border: 1px solid red; padding: 4px; font-family: sans-serif">
        Your web browser must have JavaScript enabled in order for this application to display correctly.
      </div>
    </noscript>

    <div id="user">
      Signed in as <%= htmlEscape(user.getUserName()) %>
<%
    if (user.isAdmin()) {
%>
      (you're an administrator)
<%
    }

    if (logoutUrl != null) {
      logoutUrl = logoutUrl.trim();
      if (!logoutUrl.isEmpty()) {
%>
      | <a href="<%= htmlEscape(logoutUrl) %>">Sign out</a>
<%
      }
    }
%>
    </div>

    <%-- OPTIONAL: include this if you want history support in IE6 and IE7 --%>
    <iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1' style="position:absolute;width:0;height:0;border:0"></iframe>

    <script>
      <%-- see http://blog.alexmaccaw.com/a-javascript-security-flaw for the replace() rationale --%>
      var user = <%= user.toJson().replace("</", "<\\/") %>;

<%--       <%@ include file="app/app.nocache.js" %> --%>
    </script>
  </body>
</html>
