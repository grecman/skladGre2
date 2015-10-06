<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:fn="http://java.sun.com/jsp/jstl/functions" xmlns:form="http://www.springframework.org/tags/form"
	xmlns:Spring="http://www.springframework.org/tags" xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:f="http://java.sun.com/jsp/jstl/fmt" version="2.0">
	<jsp:output omit-xml-declaration="false" doctype-root-element="html" doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" />
	<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="lib.jsp" />
<title>Tabor</title>

<script type="text/javascript">
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
		/*
		 $("#formPotravina").submit(function() {
		 $("#formPotravina").submit();
		 });

		 $("#inputNazevPotraviny").autocomplete({
		 source : function(request, response) {
		 var input = request.term;
		 $.ajax({
		 url : "./autocompleteNazevPotraviny.json?string=" + input,
		 dataType : 'json',
		 type : 'POST',
		 contentType : "application/json"
		 }).done(function(data) {
		 response(data);
		 });
		 }
		 });*/
	});
</script>

</head>
<body>
	<div class="page">
		<c:set scope="request" var="selectedMenu" value="potraviny" />
		<jsp:include page="header.jsp"></jsp:include>
		<div class="mainAreaWide">

			<c:if test="${userRole=='ADMIN' or userRole=='USER'}">
				<div class="formBar">
					<form:form commandName="formObject" action="${pageContext.servletContext.contextPath}/gre/potravina/nova">
						<SPAN>Jméno nové potraviny</SPAN>
						<SPAN> <form:input path="jmeno" class="textovePole" cssStyle="width:160px;"></form:input>
						</SPAN>
						<SPAN><input type="submit" id="formButton" value="OK" class="heroBtn" style="display: inline; margin-left: 25px;"></input></SPAN>
					</form:form>
					<c:if test="${empty listPotravina and userRole=='ADMIN'}">
						<a href="${pageContext.servletContext.contextPath}/gre/potravinyPlneni"><SPAN><input type="submit" id="formButton" value="Nahrát potraviny"
								class="heroBtn" style="display: inline; margin-left: 95px;"></input></SPAN> </a>
					</c:if>
					<c:if test="${not empty listPotravina and userRole=='ADMIN'}">
						<a onClick="return confirm('Fakt???')" href="${pageContext.servletContext.contextPath}/gre/potravina/deleteAll"><SPAN><input type="submit"
								id="formButton" value="Smazat všechny potraviny" class="heroBtn" style="display: inline; margin-left: 95px; width: auto;"></input></SPAN> </a>
					</c:if>
				</div>
			</c:if>

			<!--<form:form commandName="formObject" id="formPotravina" action="${pageContext.servletContext.contextPath}/potraviny">
				<form:input path="jmeno" id="inputNazevPotraviny" style="width: 400px;"></form:input>
				<input type="submit" class="btn"></input>
			</form:form>-->
			<c:if test="${not empty listPotravina}">
				<H3>Seznam evidovaných potravin</H3>
				<table id="tableId" style="table-layout: fixed;">
					<!-- 					<col width="95px" /> -->
					<!-- 					<col width="95px" /> -->
					<thead>
						<tr style="background-color: #dfe0e0;">
							<th style="font-size: x-small;">Potravina</th>
							<c:if test="${fn:contains(userRole, 'USER') or fn:contains(userRole, 'ADMIN')}">
								<th>Nové / opravené jméno potraviny</th>
								<th></th>
							</c:if>
							<c:if test="${fn:contains(userRole, 'ADMIN')}">
								<th></th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listPotravina}" var="i">
							<tr style="background-color: white;">
								<td align="left">${i.jmeno}</td>
								<c:if test="${fn:contains(userRole, 'USER') or fn:contains(userRole, 'ADMIN')}">
									<form:form commandName="formObject" action="${pageContext.servletContext.contextPath}/gre/potravina/edit">
										<form:hidden path="id" value="${i.id}" />
										<td align="left"><form:input path="jmeno" class="textovePole" cssStyle="width:200px;"></form:input></td>
										<td align="center"><input type="submit" id="formButton" value="OK" onClick="return confirm('Fakt???')"></input></td>
									</form:form>
								</c:if>
								<c:if test="${fn:contains(userRole, 'ADMIN')}">
									<td align="center"><a onClick="return confirm('Fakt chceš odstřelit ${i.jmeno} ???')"
										href="${pageContext.servletContext.contextPath}/gre/potravina/delete/${i.id}"> <img title="Smazat tuto potravinu!" style="border: 0px;"
											src="${pageContext.servletContext.contextPath}/resources/ico/zrusit.png" />
									</a></td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
		<BR />
		<div class="pageFooter">
			<jsp:include page="footerInfo.jsp" />
		</div>
	</div>



</body>
	</html>
</jsp:root>

