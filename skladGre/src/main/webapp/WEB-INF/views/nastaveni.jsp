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
		<c:set scope="request" var="selectedMenu" value="nastaveni" />
		<jsp:include page="header.jsp" />
		<div class="mainAreaWide">
			<SPAN>
				<H5>Zadat celkovy pocet lidi na tabore (nebo ho spocitat v pripade, ze bude zadano komplet taborove osazenstvo), dale financni
					normu na jednoho jedince na den (tusim, ze ted to bylo 110,-) a z toho pocitat normu na den (viz paramert u taborovych dnu, ktery nyni
					zadavam jako konstantu).</H5>
			</SPAN>
			<H3>Číselník měrných jednotek</H3>
			<table style="table-layout: fixed;">
				<col width="70px" />
				<col width="150px" />
				<thead>
					<tr style="background-color: #dfe0e0;">
						<th style="font-size: x-small;">MJ</th>
						<th style="font-size: x-small;">Popis</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${mjList}" var="i">
						<tr style="background-color: white;">
							<td align="left">&#160;${i.mernaJednotka}</td>
							<td align="left">${i.popis}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="pageFooter">
			<jsp:include page="footerInfo.jsp" />
		</div>
	</div>
</body>
</html>
