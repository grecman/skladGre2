<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:form="http://www.springframework.org/tags/form" xmlns:Spring="http://www.springframework.org/tags"
	xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:fn="http://java.sun.com/jsp/jstl/functions" xmlns:f="http://java.sun.com/jsp/jstl/fmt" version="2.0">
	<jsp:output omit-xml-declaration="false" doctype-root-element="html" doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" />
	<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="lib.jsp" />
<title>Tabor</title>

<script>
	$(document).ready(function() {

		$('#tableId').dataTable({
			"paging" : true,
			"ordering" : true,
			//"order" : [ [ 2, "asc" ], [ 0, "asc" ] ],
			"info" : true,
			"bFilter" : true,
			"iDisplayLength" : 10,
			"language" : {
				// datatables.net/reference/option/language
				"lengthMenu" : "&#160;Zobrazit _MENU_ řádků na stránce.",
				"info" : "&#160;Stránka: _PAGE_/_PAGES_, načteno _TOTAL_ záznamů.",
				"infoEmpty" : "Nenalezeny žádné záznamy.",
				"infoFiltered" : "&#160;(filtr: _TOTAL_ / _MAX_)",
				"loadingRecords" : "Nahrávám...",
				"processing" : "Pracuji...",
				"search" : "Vyhledat:",
				"zeroRecords" : "Nebyly nalezeny žádné záznamy.",
				"paginate" : {
					"first" : "První",
					"last" : "Poslední",
					"next" : "Další",
					"previous" : "Předcházející"
				}
			}
		});
	});
</script>
</head>
<body>
	<div class="page">
		<jsp:include page="header.jsp" />

		<div class="mainAreaWide">
			<c:if test="${empty listUser or userRole=='ADMIN'}">
				<H3>Registrace nového uživatele</H3>
				<div class="formBar">
					<form:form commandName="formObject" action="${pageContext.servletContext.contextPath}/gre/login/newUser">
						<SPAN>Nick:</SPAN>
						<SPAN> <form:input path="nick" id="nick" class="textovePole" cssStyle="width:160px;"></form:input>
						</SPAN>
						<SPAN>Password:</SPAN>
						<SPAN> <form:input path="password" id="password" type="password" class="textovePole" cssStyle="width:160px;"></form:input>
						</SPAN>
						<SPAN>Role:</SPAN>
						<SPAN> <form:select path="role">
								<form:option value="READER">READER</form:option>
								<form:option value="USER">USER</form:option>
								<form:option value="ADMIN">ADMIN</form:option>
							</form:select>
						</SPAN>
						<SPAN><input type="submit" id="formButton" value="OK" class="heroBtn" style="display: inline; margin-left: 25px;"></input></SPAN>
					</form:form>
				</div>
			</c:if>
			<c:if test="${not empty listUser and empty userLogin}">
				<H3>Přihlášení uživatele</H3>
				<div class="formBar">
					<form:form commandName="formObject" action="${pageContext.servletContext.contextPath}/gre/login/enterLogin">
						<SPAN>Jméno uživatele:&#160;&#160; <form:select path="nick">
								<form:option value=""> . . .  </form:option>
								<c:forEach var="i" items="${listUser}">
									<form:option value="${i.nick}">${i.nick}</form:option>
								</c:forEach>
							</form:select>
						</SPAN>
						<SPAN> <form:input path="password" id="password" type="password" class="textovePole" cssStyle="width:160px;"></form:input> <input type="submit"
							id="formButton" value="OK" class="heroBtn" style="display: inline; margin-left: 25px;"></input>
						</SPAN>
					</form:form>
				</div>
			</c:if>

			<c:if test="${not empty listUser}">
				<H3>Seznam registrovaných uživatelů</H3>
				<table id="XXXtableId" style="table-layout: fixed;">
					<col width="95px" />
					<col width="80px" />
					<col width="10px" />
					<col width="10px" />
					<col width="10px" />
					<col width="10px" />
					<thead>
						<tr style="background-color: #dfe0e0;">
							<th style="font-size: x-small;">Uživatel</th>
							<th style="font-size: x-small;">Role</th>
							<c:if test="${fn:contains(userRole, 'ADMIN')}">
								<th colspan="4">Admin setting</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listUser}" var="i">
							<tr style="background-color: white;">
								<td align="left" title="${i.pocetPrihlaseni}...${i.posledniPrihlaseni}">${i.nick}</td>
								<td align="left">${i.role}</td>
								<c:if test="${fn:contains(userRole, 'ADMIN')}">
									<td align="center"><a onClick="return confirm('Fakt chceš odstřelit ${i.nick} ???')"
										href="${pageContext.servletContext.contextPath}/gre/login/deleteUser/${i.nick}"> <img title="Smazat uživatele!" style="border: 0px;"
											src="${pageContext.servletContext.contextPath}/resources/ico/zrusit.png" />
									</a></td>
									<form:form commandName="formObject" action="${pageContext.servletContext.contextPath}/gre/login/changeParamUser">
										<form:hidden path="nick" value="${i.nick}" />
										<td align="center"><form:input path="password" type="password" id="password" class="textovePole" cssStyle="width:140px;"
												title="Zadej nove heslo (pův.: ${i.password})"></form:input></td>
										<td align="center"><form:select path="role">
												<form:option value="${i.role}">${i.role}</form:option>
												<form:option value="READER">READER</form:option>
												<form:option value="USER">USER</form:option>
												<form:option value="ADMIN">ADMIN</form:option>
											</form:select></td>
										<td align="center"><input type="submit" id="formButton" value="OK" onClick="return confirm('Fakt???')"></input></td>
									</form:form>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>

		</div>

		<H2 style="color: red; padding-left: 20px;">${errorMessage}</H2>

		<!-- 
		<BR /> <a href="${pageContext.servletContext.contextPath}/potraviny"
			class="btn" title="Seznam všech zadaných potravin">Potraviny</a> <BR /><BR /><BR /><BR />
		<a href="${pageContext.servletContext.contextPath}/potravina/nova"
			class="btn" title="Nová potravina">Nová potravina</a>
 -->

		<div class="pageFooter">
			<jsp:include page="footerInfo.jsp" />
		</div>
	</div>
</body>
	</html>
</jsp:root>