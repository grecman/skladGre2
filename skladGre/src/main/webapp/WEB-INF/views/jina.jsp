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

<script type="text/javascript">
	$(document).ready(function() {

		$("#formPotravina").submit(function() {});

		$("#inputNazevPotraviny").autocomplete({
			source : function(request, response) {
				var input = request.term;
				$.ajax({
					url : "./autocompleteNazevPotraviny.json?string=" + input
				}).done(function(data) {
					response(data);
				});
			}
		});
	});
</script>

</head>
<body>
	<BR />
	<a href="${pageContext.servletContext.contextPath}/" class="btn">Index</a>
	<div class="pageFooter">
		<jsp:include page="footerInfo.jsp" />
	</div>
	<BR />
	<BR />

	<form:form commandName="potravina" id="formPotravina" action="${pageContext.servletContext.contextPath}/">
		<input path="jmeno" id="inputNazevPotraviny"></input>
		<input type="submit" id="butPotvrditZmenyVyrobniProstredky"
			value="Potvrdit změny" class="btn" onclick=""></input>
	</form:form>

</body>
	</html>
</jsp:root>

