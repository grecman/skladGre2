# skladGre
Aplikace pro správu táborového skladu ... zatím ve fázi vývoje.

Technologie: Spring, Spring Web MVC, JSPs, JSTL, HTML5, CSS3, 3 vrstvá architektura, Maven, Hibernate, PostGreSQL, jQuery, AJAX.

Nyni je projekt běží na lokalní databázi PostGreSQL. 
 
Spouštění aplikace: mvn jetty:run (popřípadě: clean package jetty:run) ... na http://localhost:8080/skladGre/
Pro databazi je nutne dát do parametrů webového serveru (v tomto případě embedované JETTY) instanci pro	jdbc driver (v "Run Configurations).
PARAMERT_NAME=-Djdbc.drivers VALUE=org.postgresql.Driver
