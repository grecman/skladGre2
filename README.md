# skladGre
Aplikace pro správu táborového skladu ... zatím ve fázi vývoje.

Technologie: Spring, Spring Web MVC, JSPs, JSTL, 3 vrstvá architektura, Maven, Hibernate, HSQLDB. jQuery, Ajax.

Projekt obsahuje "embedded HSQL database" která se inicializuje s každým restartem. V případě potřeby použít jinou databazi je nutné přidat JDBC driver do pom.xml a nastavit META-INF/persistence.xml.

Spouštění aplikace: mvn jetty:run (popřípadě: clean package jetty:run) ... na http://localhost:8080/skladGre/
