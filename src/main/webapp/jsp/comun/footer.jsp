<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<footer>
	<hr>
	<div style="text-align: center">Prensa v<spring:eval expression="@propertyConfigurer.getProperty('aplicacion.version')" /> - Achtung Baby
		Productions &copy;</div>

</footer>