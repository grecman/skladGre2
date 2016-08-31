<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<c:if test="${empty listTabor or loggedUser.admin}">
				<div class="formBar">
					<span style="font-weight: bolder; color: purple;">Nový tábor</span>
					<form:form commandName="formObject"
						action="${pageContext.servletContext.contextPath}/gre/login/newTabor">
						<SPAN>Rok:</SPAN>
						<SPAN> <form:input path="rok" class="textovePole"
								cssStyle="width:100px;"></form:input>
						</SPAN>
						<SPAN>Místo:</SPAN>
						<SPAN> <form:input path="misto" class="textovePole"
								cssStyle="width:100px;"></form:input>
						</SPAN>
						<SPAN>Běh:</SPAN>
						<SPAN> <form:input path="beh" class="textovePole"
								cssStyle="width:100px;"></form:input>
						</SPAN>
						<SPAN><input type="submit" id="formButton" value="OK"
							class="heroBtn" style="display: inline; margin-left: 25px;"></input></SPAN>
					</form:form>
				</div>
				<br>
			</c:if>
			<c:if test="${empty listUser or loggedUser.admin}">
				<div class="formBar">
					<span style="font-weight: bolder; color: purple;">Nový
						uživatel</span>
					<form:form commandName="formObject"
						action="${pageContext.servletContext.contextPath}/gre/login/newUser">
						<SPAN>Nick:</SPAN>
						<SPAN> <form:input path="nick" id="nick"
								class="textovePole" cssStyle="width:100px;"></form:input>
						</SPAN>
						<SPAN>Password:</SPAN>
						<SPAN> <form:input path="password" id="password"
								type="password" class="textovePole" cssStyle="width:100px;"></form:input>
						</SPAN>
						<SPAN>Admin:</SPAN>
						<SPAN> <form:checkbox path="admin"
								cssStyle="margin-top: 3px;" />
						</SPAN>
						<SPAN><input type="submit" id="formButton" value="OK"
							class="heroBtn" style="display: inline; margin-left: 25px;"></input></SPAN>
					</form:form>
					<c:if test="${empty listUser}">
						<span style="color: gray; font-size: xx-small;">Zadáváte
							prvního uživateledo aplikace, jeho role bude nastavena
							automaticky jako ADMIN!</span>
					</c:if>
				</div>
				<br>
			</c:if>
			<c:if
				test="${not empty listUser and not empty listTabor and loggedUser.admin}">
				<div class="formBar">
					<span style="font-weight: bolder; color: purple;">Přiřazení
						rolí</span>
					<form:form commandName="formObject"
						action="${pageContext.servletContext.contextPath}/gre/login/setRole">
						<SPAN>Jméno uživatele:&#160;&#160; <form:select path="nick">
								<c:forEach var="i" items="${listUser}">
									<form:option value="${i.nick}">${i.nick}</form:option>
								</c:forEach>
							</form:select>
						</SPAN>
						<SPAN>Role:</SPAN>
						<SPAN> <form:select path="role">
								<c:forEach items="${listRoleList}" var="i">
									<form:option value="${i.role}" title="${i.popis}">${i.role}</form:option>
								</c:forEach>
							</form:select>
						</SPAN>
						<SPAN>Tabor:</SPAN>
						<SPAN> <form:select path="id">
								<c:forEach items="${listTabor}" var="i">
									<form:option value="${i.id}">${i.rok}-${i.misto}-${i.beh}</form:option>
								</c:forEach>
							</form:select>
						</SPAN>
						<SPAN><input type="submit" id="formButton" value="OK"
							class="heroBtn" style="display: inline; margin-left: 25px;"></input></SPAN>
					</form:form>
					<c:if test="${empty listUser}">
						<span style="color: gray; font-size: xx-small;">Zadáváte
							prvního uživateledo aplikace, jeho role bude nastavena
							automaticky jako ADMIN!</span>
					</c:if>
				</div>

			</c:if>
			<c:if test="${not empty listUser and empty loggedUser}">
				<H4>Přihlášení uživatele</H4>
				<div class="formBar">
					<form:form commandName="formObject"
						action="${pageContext.servletContext.contextPath}/gre/login/enterLogin">
						<SPAN>Jméno uživatele:&#160;&#160; <form:select path="nick">
								<form:option value=""> . . .  </form:option>
								<c:forEach var="i" items="${listUser}">
									<form:option value="${i.nick}">${i.nick}</form:option>
								</c:forEach>
							</form:select>
						</SPAN>
						<SPAN> <form:input path="password" id="password"
								type="password" class="textovePole" cssStyle="width:160px;"></form:input>
							<input type="submit" id="formButton" value="OK" class="heroBtn"
							style="display: inline; margin-left: 25px;"></input>
						</SPAN>
					</form:form>
				</div>
			</c:if>
			<c:if test="${not empty listTabor and loggedUser.admin}">
				<H4>Přehled rolí</H4>
				<table style="border: none;">
					<tr>
						<td valign="top"><table style="table-layout: fixed;">
								<col width="65px" />
								<col width="150px" />
								<col width="35px" />
								<thead>
									<tr style="background-color: #dfe0e0;">
										<th style="font-size: x-small;">Nick</th>
										<th style="font-size: x-small;">Tábor</th>
										<th style="font-size: x-small;">Role</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listRole}" var="i">
										<tr style="background-color: white; height: 23px;">
											<td align="left">${i.user.nick}</td>
											<td align="left">${i.tabor.rok}-${i.tabor.misto}-${i.tabor.beh}</td>
											<td align="left">${i.roleList.role}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table></td>
						<td valign="top"><c:if test="${loggedUser.admin}">
								<table style="table-layout: fixed;">
									<col width="260px" />
									<thead>
										<tr style="background-color: #dfe0e0;">
											<th style="font-size: x-small;">Admin settings</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listRole}" var="i">
											<tr style="background-color: white;">
												<form:form commandName="formObject"
													action="${pageContext.servletContext.contextPath}/gre/login/changeParamRole">
													<form:hidden path="id" value="${i.id}" />
													<td align="left"><form:input path="rok"
															class="textovePole" title="Zadej novy rok."
															cssStyle="width:40px; border-style: solid; border-width: thin; border-color: yellow;"></form:input>
														<form:input path="misto" class="textovePole"
															cssStyle="width:100px;border-style: solid; border-width: thin; border-color: yellow;"
															title="Zadej nove misto"></form:input> <form:input
															path="beh" class="textovePole"
															cssStyle="width:30px;border-style: solid; border-width: thin; border-color: yellow;"
															title="Zadej novy beh"></form:input> <input type="submit"
														value="OK" onClick="return confirm('Fakt???')"></input> <a
														onClick="return confirm('Fakt chceš odstřelit tento tabor???')"
														href="${pageContext.servletContext.contextPath}/gre/login/deleteRole/${i.id}">
															<img title="Smazat uživatele!" style="border: 0px;"
															src="${pageContext.servletContext.contextPath}/resources/ico/zrusit.png" />
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
			<c:if test="${not empty listUser}">
				<H4>Seznam registrovaných uživatelů</H4>
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
											<td align="left"
												title="${i.pocetPrihlaseni}...${i.posledniPrihlaseni}">${i.nick}</td>
											<td><c:choose>
													<c:when test="${i.admin}">
														<img style="border: 0px;"
															src="${pageContext.servletContext.contextPath}/resources/ico/ok.png" />
													</c:when>
													<c:otherwise></c:otherwise>
												</c:choose></td>
										</tr>
									</c:forEach>
								</tbody>
							</table></td>
						<td valign="top"><c:if test="${loggedUser.admin}">
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
												<form:form commandName="formObject"
													action="${pageContext.servletContext.contextPath}/gre/login/changeParamUser">
													<form:hidden path="id" value="${i.id}" />
													<td align="left"><form:input path="nick"
															class="textovePole" title="Zadej novy NICK."
															cssStyle="width:100px; border-style: solid; border-width: thin; border-color: yellow;"></form:input>
														<form:input path="password" type="password" id="password"
															class="textovePole"
															cssStyle="width:100px;border-style: solid; border-width: thin; border-color: yellow;"
															title="Zadej nove heslo (pův.: ${i.password})"></form:input>
														<c:choose>
															<c:when test="${i.admin}">
																<form:checkbox path="admin" value="${i.admin}"
																	checked="yes" />
															</c:when>
															<c:otherwise>
																<form:checkbox path="admin" value="${i.admin}" />
															</c:otherwise>
														</c:choose> <input type="submit" value="OK"
														onClick="return confirm('Fakt???')"></input> <a
														onClick="return confirm('Fakt chceš odstřelit uživatele ${i.nick} ???')"
														href="${pageContext.servletContext.contextPath}/gre/login/deleteUser/${i.nick}">
															<img title="Smazat uživatele!" style="border: 0px;"
															src="${pageContext.servletContext.contextPath}/resources/ico/zrusit.png" />
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
			<c:if test="${not empty listTabor and loggedUser.admin}">
				<H4>Seznam taborů</H4>
				<table style="border: none;">
					<tr>
						<td valign="top"><table style="table-layout: fixed;">
								<col width="50px" />
								<col width="150px" />
								<col width="35px" />
								<thead>
									<tr style="background-color: #dfe0e0;">
										<th style="font-size: x-small;">Rok</th>
										<th style="font-size: x-small;">Místo</th>
										<th style="font-size: x-small;">Běh</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listTabor}" var="i">
										<tr style="background-color: white; height: 23px;">
											<td align="center">${i.rok}</td>
											<td align="left">${i.misto}</td>
											<td align="center">${i.beh}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table></td>
						<td valign="top"><c:if test="${loggedUser.admin}">
								<table style="table-layout: fixed;">
									<col width="260px" />
									<thead>
										<tr style="background-color: #dfe0e0;">
											<th style="font-size: x-small;">Admin settings</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listTabor}" var="i">
											<tr style="background-color: white;">
												<form:form commandName="formObject"
													action="${pageContext.servletContext.contextPath}/gre/login/changeParamTabor">
													<form:hidden path="id" value="${i.id}" />
													<td align="left"><form:input path="rok"
															class="textovePole" title="Zadej novy rok."
															cssStyle="width:40px; border-style: solid; border-width: thin; border-color: yellow;"></form:input>
														<form:input path="misto" class="textovePole"
															cssStyle="width:100px;border-style: solid; border-width: thin; border-color: yellow;"
															title="Zadej nove misto"></form:input> <form:input
															path="beh" class="textovePole"
															cssStyle="width:30px;border-style: solid; border-width: thin; border-color: yellow;"
															title="Zadej novy beh"></form:input> <input type="submit"
														value="OK" onClick="return confirm('Fakt???')"></input> <a
														onClick="return confirm('Fakt chceš odstřelit tento tabor???')"
														href="${pageContext.servletContext.contextPath}/gre/login/deleteTabor/${i.id}">
															<img title="Smazat uživatele!" style="border: 0px;"
															src="${pageContext.servletContext.contextPath}/resources/ico/zrusit.png" />
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
		<div style="background: transparent; height: 20px;"></div>
		<div class="pageFooter">
			<jsp:include page="footerInfo.jsp" />
		</div>
	</div>
</body>
</html>
