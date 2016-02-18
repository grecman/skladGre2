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
<script type="text/javascript">
	$(document).ready(
			function() {

				$('#tableId').dataTable(
						{
							"paging" : true,
							"ordering" : true,
							"order" : [ 0, "asc" ],
							"info" : true,
							"bFilter" : true,
							"iDisplayLength" : 10,
							"language" : {
								// datatables.net/reference/option/language
								"lengthMenu" : "&#160;Zobrazit _MENU_ řádků na stránce.", "info" : "&#160;Stránka: _PAGE_/_PAGES_, načteno _TOTAL_ záznamů.",
								"infoEmpty" : "Nenalezeny žádné záznamy.", "infoFiltered" : "&#160;(filtr: _TOTAL_ / _MAX_)", "loadingRecords" : "Nahrávám...",
								"processing" : "Pracuji...", "search" : "Vyhledat:", "zeroRecords" : "Nebyly nalezeny žádné záznamy.", "paginate" : {
									"first" : "První", "last" : "Poslední", "next" : "Další", "previous" : "Předcházející"
								}
							}
						});

				$("#inputNazevPotraviny").autocomplete({
					source : function(request, response) {
						var input = request.term;
						$.ajax({
							url : "./autocompleteNazevPotraviny.json?string=" + input, dataType : 'json', type : 'POST', contentType : "application/json"
						}).done(function(data) {
							response(data);
						});
					}
				});
			});
</script>
</head>
<body>
	<div class="page">
		<c:set scope="request" var="selectedMenu" value="td" />
		<jsp:include page="header.jsp"></jsp:include>
		<div class="mainAreaWide">
			<div class="formBar">
				<c:choose>
					<c:when test="${empty tdList}">
						<form:form commandName="formObject" action="${pageContext.servletContext.contextPath}/gre/td/vytvorDny">
							<SPAN>První den:</SPAN>
							<SPAN title="Datum je nutné zadat ve formátu: RRRRMMDD"> <form:input path="prvniDen" class="textovePole"
									cssStyle="width:80px;"></form:input>
							</SPAN>
							<SPAN>Počet táborových dnů:</SPAN>
							<SPAN title="Datum je nutné zadat ve formátu: RRRRMMDD"> <form:input path="pocetTaborovychDnu" class="textovePole"
									cssStyle="width:30px;"></form:input>
							</SPAN>
							<SPAN>Norma:</SPAN>
							<SPAN title="Norma (celé číslo). Pozn: vypočítává se konstanta*počet lidi na táboře (časem to zautomatizujeme)"> <form:input
									path="norma" class="textovePole" cssStyle="width:40px;"></form:input>
							</SPAN>
							<SPAN><input type="submit" id="formButton" value="OK" class="heroBtn" style="display: inline; margin-left: 25px;"></input></SPAN>
						</form:form>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${empty vybranyDen}">
								<SPAN>Vyber táborový den ...</SPAN>
							</c:when>
							<c:otherwise>
								<SPAN>Vybraný táborový den</SPAN>
								<fmt:formatDate value="${vybranyDen.den}" pattern="yyyyMMdd" var="vybranyDenFormated" />
								<SPAN title="Zrušit vybraný táborový den" style="margin-top: 0px;"> <a
									href="${pageContext.servletContext.contextPath}/gre/td/zrusitVybranyDen"><SPAN style="color: green; font-weight: bold;">${vybranyDen.den}</SPAN>
								</a>
								</SPAN>
								<SPAN>Denní norma: ${vybranyDen.norma}</SPAN>
								<form:form commandName="formObject" action="${pageContext.servletContext.contextPath}/gre/td/changeNorma">
									<SPAN><form:hidden path="id" value="${vybranyDen.id}" /> <form:input path="norma" class="textovePole" cssStyle="width:4em;"
											title="Zadej novou normu (pův.: ${vybranyDen.norma})"></form:input> <input type="submit" id="formButton" value="OK"
										class="heroBtn" style="width: auto;" onClick="return confirm('Fakt změnit normu?')"></input></SPAN>
								</form:form>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
				<c:if test="${not empty tdList and userRole=='ADMIN'}">
					<a onClick="return confirm('Fakt???')" href="${pageContext.servletContext.contextPath}/gre/td/deleteAll"><SPAN
						style="padding-left: 300px;"><input type="submit" id="formButton" value="Smazat všechny dny" class="heroBtn"
							style="display: inline; width: auto;"></input></SPAN> </a>
				</c:if>
			</div>
			<c:if test="${not empty tdList and empty vybranyDen}">
				<table style="table-layout: fixed; overflow: auto;">
					<thead>
						<TR>
							<c:set var="poradi" value="${1}" />
							<c:forEach items="${tdList}" var="i">
								<TH>${poradi}</TH>
								<c:set var="poradi" value="${poradi+1}" />
							</c:forEach>
						</TR>
					</thead>
					<tbody>
						<tr style="background-color: white; height: 35px;">
							<c:forEach items="${tdList}" var="i">
								<td align="center" title="Norma: ${i.norma}" width="45px;"
									style="border-top: thin; border-top-color: gray; border-top-style: solid; border-right: thin; border-right-color: gray; border-right-style: solid;">
									<fmt:formatDate value="${today}" pattern="yyyyMMdd" var="denAktualni" /> <fmt:formatDate value="${i.den}" pattern="yyyyMMdd"
										var="denGre" /> <fmt:formatDate value="${i.den}" pattern="E dd.MMM" var="denNaformatovany" /> <c:choose>
										<c:when test="${denAktualni le denGre}">
											<SPAN style="color: green;"> <a href="${pageContext.servletContext.contextPath}/gre/td/vybratDen/${i.id}">
													${denNaformatovany}</a></SPAN>
										</c:when>
										<c:otherwise>
											<SPAN style="color: gray;"> <a href="${pageContext.servletContext.contextPath}/gre/td/vybratDen/${i.id}">
													${denNaformatovany}</a></SPAN>
										</c:otherwise>
									</c:choose>
								</td>
							</c:forEach>
						</tr>
					</tbody>
				</table>
			</c:if>
			<BR />
			<c:if test="${not empty vybranyDen}">
				<table style="border: none;">
					<tr>
						<td style="font-size: x-small;">Potravina</td>
						<td style="font-size: x-small;">Cena</td>
						<td style="font-size: x-small;">Množství</td>
						<td style="font-size: x-small;">Mějná jednotka</td>
						<td style="font-size: x-small;">Č.účtenky</td>
						<td></td>
					</tr>
					<tr>
						<form:form commandName="formObject" action="${pageContext.servletContext.contextPath}/gre/td/priradPotravinuDoDne/${vybranyDen.id}">
							<td><form:input path="jmeno" id="inputNazevPotraviny" style="width: 300px;"></form:input></td>
							<td><form:input path="cena" style="width: 60px;"></form:input></td>
							<td><form:input path="mnozstvi" style="width: 60px;"></form:input></td>
							<td><form:select path="mernaJednotka" style="width: 100px;">
									<c:forEach items="${mjList}" var="i">
										<form:option value="${i.mernaJednotka}">${i.mernaJednotka}</form:option>
									</c:forEach>
								</form:select></td>
							<td><form:input path="uctenka" style="width: 60px;"></form:input></td>
							<td><input type="submit" class="heroBtn" style="display: inline;" value="Ok"></input></td>
						</form:form>
					</tr>
				</table>
				<!-- 
				<DIV>
					<SPAN style="display: inline-block; width: 300px; font-size: x-small;">Potravina</SPAN>&#160;&#160; <SPAN
						style="display: inline-block; width: 60px; font-size: x-small;">Cena</SPAN>&#160;&#160;&#160;&#160;<SPAN
						style="display: inline-block; width: 60px; font-size: x-small;">Množství</SPAN> &#160;&#160;&#160; <SPAN
						style="display: inline-block; width: 100px; font-size: x-small;">Mějná jednotka</SPAN> <SPAN
						style="display: inline-block; width: 60px; font-size: x-small;">Č.účtenky</SPAN>
				</DIV>
				<form:form commandName="formObject" action="${pageContext.servletContext.contextPath}/gre/td/priradPotravinuDoDne/${vybranyDen.id}">
					<SPAN><form:input path="jmeno" id="inputNazevPotraviny" style="width: 300px;"></form:input></SPAN>&#160;
					<SPAN><form:input path="cena" style="width: 60px;"></form:input> </SPAN>&#160;
					<SPAN><form:input path="mnozstvi" style="width: 60px;"></form:input> </SPAN>&#160;
					<SPAN><form:select path="mernaJednotka" style="width: 100px;">
							<c:forEach items="${mjList}" var="i">
								<form:option value="${i.mernaJednotka}">${i.mernaJednotka}</form:option>
							</c:forEach>
						</form:select></SPAN>&#160;
					<SPAN><form:input path="uctenka" style="width: 60px;"></form:input> </SPAN>&#160;
					<SPAN> <input type="submit" class="heroBtn" style="display: inline;" value="Ok"></input></SPAN>
				</form:form> -->
				<br>
				<table style="table-layout: fixed;">
					<col width="200px" />
					<col width="70px" />
					<col width="70px" />
					<col width="70px" />
					<col width="70px" />
					<col width="70px" />
					<thead>
						<tr style="background-color: #dfe0e0;">
							<th style="font-size: x-small;">Jmeno</th>
							<th style="font-size: x-small;">Cena</th>
							<th style="font-size: x-small;">Množství</th>
							<th style="font-size: x-small;" title="Měrná jednotka">MJ</th>
							<th style="font-size: x-small;" title="Číslo účtenky">Č.účt.</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${skladDenList}" var="i">
							<tr style="background-color: white;">
								<td align="left">${i.jmenoPotraviny}</td>
								<td align="right">${i.cena}</td>
								<td align="right">${i.mnozstvi}</td>
								<td align="center">${i.mj.mernaJednotka}</td>
								<td align="center">${i.uctenka}</td>
								<td align="center"><a onClick="return confirm('Opravdu smazat potravinu ${i.potravina.jmeno} z uvedeného dne ???')"
									href="${pageContext.servletContext.contextPath}/gre/td/smazatPotravinu/${i.id}"> <img title="Smazat potravinu!"
										style="border: 0px;" src="${pageContext.servletContext.contextPath}/resources/ico/zrusit.png" />
								</a></td>
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
