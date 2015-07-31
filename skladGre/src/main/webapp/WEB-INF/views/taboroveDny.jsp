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
		<div class="mainAreaWide">neco</div>
		<div class="pageFooter">
			<jsp:include page="footerInfo.jsp" />
		</div>
	</div>
</body>
	</html>
</jsp:root>