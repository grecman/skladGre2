<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:Spring="http://www.springframework.org/tags"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:f="http://java.sun.com/jsp/jstl/fmt" version="2.0">
	<jsp:output omit-xml-declaration="false" doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" />
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="lib.jsp" />
<title>Tabor</title>

</head>
<body>
	<div class="page">

		<div class="obal" style="text-align: left; margin: 0px auto;">
			<div class="tableArea" style="width: 250px;">
				<table>
					<thead>
						<tr>
							<th>Denní norma</th>
							<th>Táborový den</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${listTd}" var="i" varStatus="iterator">
							<tr class="${ (iterator.index mod 2) == 0 ? 'nic': 'alt' }">
								<td>${i.norma}</td>
								<td style="color: green; font-weight: bold;"><f:formatDate
										value="${i.den}" pattern="yyyy-MM-dd" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="tableArea" style="width: 350px; overflow: auto;">
				<table>
					<COL width="150px" />
					<COL width="150px" />
					<thead>
						<tr>
							<th>Potravina</th>
							<th>neco</th>
						</tr>
					</thead>
				</table>
				<div class="tableScroll" style="max-height: 350px;">
					<table>
						<COL width="150px" />
						<COL width="150px" />
						<tbody>
							<c:forEach items="${listPot}" var="i" varStatus="iterator">
								<tr class="${ (iterator.index mod 2) == 0 ? 'nic': 'alt' }">
									<td style="color: green; font-weight: bold;">${i.jmeno}</td>
									<td>gre</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<BR /> <a href="${pageContext.servletContext.contextPath}/potraviny"
			class="btn" title="Seznam všech zadaných potravin">Potraviny</a>


		<div class="pageFooter">
			<jsp:include page="footerInfo.jsp" />
		</div>
	</div>
</body>
	</html>
</jsp:root>