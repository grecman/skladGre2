<div class="logo">
	<SCRIPT type="text/javascript">
		/* gre */
	</SCRIPT>
	<!-- pri prazdnem tagu v DIVu prohlizece neumeji tento div uzavrit a ignoruji nasledujici /DIV, proto tento vyse vlozeny script -->
</div>
<div class="header">
	<div class="title">T�borov� sklad | ${pageTitle}</div>
	<div class="info">
		<div class="user">
			<span id="uzivatel" style="color: blue; font-weight: bold;" title="${userRole}&#160;Odhl�sit"><a
				href="${pageContext.servletContext.contextPath}/index.html">&#160;${userLogin}&#160;</a></span>
		</div>
	</div>
	<div class="menu">
		<a class="${selectedMenu eq 'login' ? 'selected' : 'passive'}" href="${pageContext.servletContext.contextPath}/gre/login/logged">Login</a>
		<a class="${selectedMenu eq 'td' ? 'selected' : 'passive'}" href="${pageContext.servletContext.contextPath}/gre/td/seznam">T�borov�
			dny</a> <a class="${selectedMenu eq 'potraviny' ? 'selected' : 'passive'}"
			href="${pageContext.servletContext.contextPath}/gre/potravina/seznam">Potraviny</a> <a
			class="${selectedMenu eq 'osazenstvo' ? 'selected' : 'passive'}" href="${pageContext.servletContext.contextPath}/gre/osazenstvo/vyberTyp">T�borov�
			osazenstvo</a> <a class="${selectedMenu eq 'nastaveni' ? 'selected' : 'passive'}"
			href="${pageContext.servletContext.contextPath}/gre/nastaveni">Nastaven�</a>
	</div>
</div>
