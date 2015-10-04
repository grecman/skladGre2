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
			"order" : [ [ 0, "asc" ], [ 2, "asc" ] ],
			"info" : true,
			"bFilter" : true,
			"iDisplayLength" : 25,
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
						<SPAN title="Datum je nutné zadat ve formátu: RRRRMMDD"> <form:input path="pocetTaborovychDnu" class="textovePole" cssStyle="width:30px;"></form:input>
						</SPAN>
						<SPAN><input type="submit" id="formButton" value="OK" class="heroBtn" style="display: inline; margin-left: 25px;"></input></SPAN>
					</form:form>
				</div>
			</c:if>
			<c:if test="${not empty listTd}">
				<table id="XXXtableId" style="table-layout: fixed;">
					<col width="95px" />
					<col width="10px" />
					<col width="10px" />
					<thead>
						<tr style="background-color: #dfe0e0;">
							<th style="font-size: x-small;">Den</th>
							<c:if test="${fn:contains(userRole, 'ADMIN')}">
								<th colspan="3">Admin setting&#160;&#160;<a onClick="return confirm('Fakt chceš odstřelit tento den???')"
									href="${pageContext.servletContext.contextPath}/gre/td/deleteTdAll"> <img title="Smazat všechny dny!" style="border: 0px;"
										src="${pageContext.servletContext.contextPath}/resources/ico/zrusit.png" />
								</a></th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listTd}" var="i">
							<tr style="background-color: white;">
								<td align="left" title="Norma: ${i.norma}">${i.den}</td>
								<c:if test="${fn:contains(userRole, 'ADMIN')}">
									<form:form commandName="formObject" action="${pageContext.servletContext.contextPath}/gre/td/changeNorma">
										<form:hidden path="id" value="${i.id}" />
										<td align="center"><form:input path="norma" class="textovePole" cssStyle="width:80px;" title="Zadej novou normu (pův.: ${i.norma})"></form:input></td>
										<td align="center"><input type="submit" id="formButton" value="OK" onClick="return confirm('Fakt???')"></input></td>
									</form:form>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		<div class="pageFooter">
			<jsp:include page="footerInfo.jsp" />
		</div>
	</div>
</body>
	</html>
</jsp:root>