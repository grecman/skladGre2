<?xml version="1.0" encoding="UTF-8" ?>

<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:form="http://www.springframework.org/tags/form" xmlns:Spring="http://www.springframework.org/tags"
	xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:f="http://java.sun.com/jsp/jstl/fmt" version="2.0">
	<div class="logo"><SCRIPT type="text/javascript">/* gre */</SCRIPT>
		<!-- pri prazdnem tagu v DIVu prohlizece neumeji tento div uzavrit a ignoruji nasledujici /DIV, proto tento vyse vlozeny script -->
	</div>
	<div class="header">
		<div class="title"><a href="${pageContext.servletContext.contextPath}/index.html">Táborový sklad</a> | ${pageTitle}</div>
		<div class="info">
			<div class="user">
				<span id="uzivatel" title="${userRole}">Uživatel:&#160;${userLogin}&#160;</span>
			</div>
		</div>
		 
		<div class="menu">
			<a class="${selectedMenu eq 'login' ? 'selected' : 'passive'}" href="${pageContext.servletContext.contextPath}/gre/login/logged">Login</a>
			<a class="${selectedMenu eq 'td' ? 'selected' : 'passive'}" href="${pageContext.servletContext.contextPath}/gre/td/seznam">Táborové dny</a>
			<a class="${selectedMenu eq 'potraviny' ? 'selected' : 'passive'}" href="${pageContext.servletContext.contextPath}/gre/potravina/potraviny">Potraviny</a>
		</div>
	</div>
</jsp:root>