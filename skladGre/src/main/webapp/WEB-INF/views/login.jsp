<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="lib.jsp" />
<title>Tabor</title>
</head>
<body>
	<div class="page">
		<c:set scope="request" var="selectedMenu" value="login" />
		<jsp:include page="header.jsp" />
		<div class="mainAreaWide">
			<c:if test="${empty listUser or loggedUser.superAdmin}">
				<H3>Registrace nového uživatele</H3>
				<div class="formBar">
					<form:form commandName="formObject" action="${pageContext.servletContext.contextPath}/gre/login/newUser">
						<SPAN>Nick:</SPAN>
						<SPAN> <form:input path="nick" id="nick" class="textovePole" cssStyle="width:160px;"></form:input>
						</SPAN>
						<SPAN>Password:</SPAN>
						<SPAN> <form:input path="password" id="password" type="password" class="textovePole" cssStyle="width:160px;"></form:input>
						</SPAN>
						<SPAN>Admin:</SPAN>
						<SPAN><form:checkbox path="superAdmin" cssStyle="width:20px; height: 20px;" /></SPAN>
						<!-- <SPAN>Role:</SPAN>
						<SPAN>Role:</SPAN> <form:select path="role">
								<form:option value="USER">USER</form:option>
								<form:option value="READER">READER</form:option>
								<form:option value="ADMIN">ADMIN</form:option>
							</form:select>
						</SPAN> -->
						<SPAN><input type="submit" id="formButton" value="OK" class="heroBtn" style="display: inline; margin-left: 25px;"></input></SPAN>
					</form:form>
				</div>
			</c:if>
			<c:if test="${not empty listUser and empty loggedUser}">
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
						<SPAN> <form:input path="password" id="password" type="password" class="textovePole" cssStyle="width:160px;"></form:input> <input
							type="submit" id="formButton" value="OK" class="heroBtn" style="display: inline; margin-left: 25px;"></input>
						</SPAN>
					</form:form>
				</div>
			</c:if>
			<c:if test="${not empty listUser}">
				<H3>Seznam registrovaných uživatelů</H3>
				<table style="border: none;">
					<tr>
						<td valign="top"><table style="table-layout: fixed;">
								<col width="150px" />
								<col width="35px" />
								<thead>
									<tr style="background-color: #dfe0e0;">
										<th style="font-size: x-small;">Uživatel</th>
										<th style="font-size: x-small;" title="Správce aplikace">Adm.</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listUser}" var="i">
										<tr style="background-color: white; height: 23px;">
											<td align="left" title="${i.pocetPrihlaseni}...${i.posledniPrihlaseni}">${i.nick}</td>
											<td><c:choose>
													<c:when test="${i.superAdmin}">
														<img style="border: 0px;" src="${pageContext.servletContext.contextPath}/resources/ico/ok.png" />
													</c:when>
													<c:otherwise></c:otherwise>
												</c:choose></td>
										</tr>
									</c:forEach>
								</tbody>
							</table></td>
						<td valign="top"><c:if test="${loggedUser.superAdmin}">
								<table style="table-layout: fixed;">
									<col width="300px" />
									<thead>
										<tr style="background-color: #dfe0e0;">
											<th style="font-size: x-small;">Admin settings</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listUser}" var="i">
											<tr style="background-color: white;">
												<form:form commandName="formObject" action="${pageContext.servletContext.contextPath}/gre/login/changeParamUser">
													<form:hidden path="id" value="${i.id}" />
													<td align="left"><form:input path="nick" class="textovePole" title="Zadej novy NICK."
															cssStyle="width:100px; border-style: solid; border-width: thin; border-color: yellow;"></form:input> <form:input
															path="password" type="password" id="password" class="textovePole"
															cssStyle="width:100px;border-style: solid; border-width: thin; border-color: yellow;"
															title="Zadej nove heslo (pův.: ${i.password})"></form:input> <c:choose>
															<c:when test="${i.superAdmin}">
																<form:checkbox path="superAdmin" value="${i.superAdmin}" checked="yes" />
															</c:when>
															<c:otherwise>
																<form:checkbox path="superAdmin" value="${i.superAdmin}" />
															</c:otherwise>
														</c:choose> <input type="submit" value="OK" onClick="return confirm('Fakt???')"></input> <a
														onClick="return confirm('Fakt chceš odstřelit uživatele ${i.nick} ???')"
														href="${pageContext.servletContext.contextPath}/gre/login/deleteUser/${i.nick}"> <img title="Smazat uživatele!"
															style="border: 0px;" src="${pageContext.servletContext.contextPath}/resources/ico/zrusit.png" />
													</a></td>
												</form:form>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:if></td>
					</tr>
				</table>
			</c:if>
		</div>
		<H2 style="color: red; padding-left: 20px;">${errorMessage}</H2>
		<!-- 
		<BR /> <a href="${pageContext.servletContext.contextPath}/potraviny"
			class="btn" title="Seznam všech zadaných potravin">Potraviny</a> <BR /><BR /><BR /><BR />
		<a href="${pageContext.servletContext.contextPath}/potravina/nova"
			class="btn" title="Nová potravina">Nová potravina</a>
			
<%-- 			<form:select path="role"> --%> <%-- 												<form:option value="${i.role}">${i.role}</form:option> --%>
			<%-- 		<form:option value="READER">READER</form:option> --%> <%-- 												<form:option value="USER">USER</form:option> --%>
			<%-- 	form:option value="ADMIN">ADMIN</form:option> --%> <%-- 											</form:select>  --%></td>
			
			
 -->
		<div class="pageFooter">
			<jsp:include page="footerInfo.jsp" />
		</div>
	</div>
</body>
</html>
