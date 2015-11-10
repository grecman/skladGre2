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
		<c:set scope="request" var="selectedMenu" value="td" />
		<jsp:include page="header.jsp"></jsp:include>
		<div class="mainAreaWide">
			<c:if test="${empty listTd and userRole=='ADMIN'}">
				<H3>Vytvoření táborových dnů</H3>
				<div class="formBar">
					<form:form commandName="formObject" action="${pageContext.servletContext.contextPath}/gre/td/vytvorDny">
						<SPAN>První den:</SPAN>
						<SPAN title="Datum je nutné zadat ve formátu: RRRRMMDD"> <form:input path="prvniDen" class="textovePole" cssStyle="width:80px;"></form:input>
						</SPAN>
						<SPAN>Počet táborových dnů:</SPAN>
						<SPAN title="Datum je nutné zadat ve formátu: RRRRMMDD"> <form:input path="pocetTaborovychDnu" class="textovePole"
								cssStyle="width:30px;"></form:input>
						</SPAN>
						<SPAN><input type="submit" id="formButton" value="OK" class="heroBtn" style="display: inline; margin-left: 25px;"></input></SPAN>
					</form:form>
				</div>
			</c:if>
			<c:if test="${not empty listTd}">
				<table style="table-layout: fixed; overflow: auto;">
					<col width="95px" />
					<col width="10px" />
					<col width="10px" />
					<thead>
						<tr style="background-color: #dfe0e0;">
							<th style="font-size: x-small;">Den</th>
							<c:if test="${fn:contains(userRole, 'ADMIN')}">
								<th colspan="3" align="center"><a onClick="return confirm('Fakt chceš odstřelit všechny dny???')"
									href="${pageContext.servletContext.contextPath}/gre/td/deleteAll"> <img title="Smazat všechny dny!" style="border: 0px;"
										src="${pageContext.servletContext.contextPath}/resources/ico/zrusit.png" />
								</a></th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listTd}" var="i">
							<tr style="background-color: white;">
								<td align="left" title="Norma: ${i.norma}" style="font-weight: bold;"><fmt:formatDate value="${now}" pattern="yyyyMMdd"
										var="denAktualni" /> <c:choose>
										<c:when test="${denAktualni lt denVybrany}">
											<SPAN style="color: green;"> <a href="${pageContext.servletContext.contextPath}/gre/td/vybratDen/${i.id}"> ${i.den}</a></SPAN>
										</c:when>
										<c:otherwise>
											<SPAN style="color: gray;"> <a href="${pageContext.servletContext.contextPath}/gre/td/vybratDen/${i.id}"> ${i.den}</a></SPAN>
										</c:otherwise>
									</c:choose></td>
								<c:if test="${fn:contains(userRole, 'ADMIN')}">
									<form:form commandName="formObject" action="${pageContext.servletContext.contextPath}/gre/td/changeNorma">
										<form:hidden path="id" value="${i.id}" />
										<td align="center"><form:input path="norma" class="textovePole" cssStyle="width:4em;"
												title="Zadej novou normu (pův.: ${i.norma})"></form:input></td>
										<td align="center"><input type="submit" id="formButton" value="OK" onClick="return confirm('Fakt změnit normu?')"></input></td>
									</form:form>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		<BR /> <BR />
		<div class="pageFooter">
			<jsp:include page="footerInfo.jsp" />
		</div>
	</div>
</body>
</html>
