<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="logo">
	<SCRIPT type="text/javascript">
		/* gre */
	</SCRIPT>
	<!-- pri prazdnem tagu v DIVu prohlizece neumeji tento div uzavrit a ignoruji nasledujici /DIV, proto tento vyse vlozeny script -->
</div>
<div class="header">
	<div class="title">Táborový sklad | ${pageTitle}</div>
	<div class="info">
		<div class="user">
			<span id="uzivatel" style="color: blue; font-weight: bold;" title="${userRole}&#160;Odhlásit"><a
				href="${pageContext.servletContext.contextPath}/index.html">&#160;${userLogin}&#160;</a></span>
		</div>
	</div>
	<div class="menu">
		<a class="${selectedMenu eq 'login' ? 'selected' : 'passive'}" href="${pageContext.servletContext.contextPath}/gre/login/logged">Login</a>
		<c:if test="${not empty userLogin}">
			<a class="${selectedMenu eq 'td' ? 'selected' : 'passive'}" href="${pageContext.servletContext.contextPath}/gre/td/seznam">Táborové
				dny</a>
			<a class="${selectedMenu eq 'potraviny' ? 'selected' : 'passive'}" href="${pageContext.servletContext.contextPath}/gre/potravina/seznam">Potraviny</a>
			<a class="${selectedMenu eq 'osazenstvo' ? 'selected' : 'passive'}"
				href="${pageContext.servletContext.contextPath}/gre/osazenstvo/vyberTyp">Táborové osazenstvo</a>
			<a class="${selectedMenu eq 'nastaveni' ? 'selected' : 'passive'}" href="${pageContext.servletContext.contextPath}/gre/nastaveni">Nastavení</a>
		</c:if>
	</div>
</div>
