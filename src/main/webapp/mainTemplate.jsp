<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html ng-app="contactosApp">
<head>

<title>
	<tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
<!-- Bootstrap -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link href="css/theme.css" rel="stylesheet">
<link href="css/bootstrap-select.css" rel="stylesheet" type="text/css" >
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href="css/custom.css" rel="stylesheet">
<link rel='shortcut icon' href='favicon.ico'>

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<!-- <script type="text/javascript" src="js/bootstrap-select.js"></script>
	<script type="text/javascript" src="js/angular.min.js"></script> -->
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-animate.js"></script>
    <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.14.1.js"></script>
    
	<script type="text/javascript">
		
		
		function setMenuActive(index){
			$(".navbar-nav").find("li").each(function(i, element){
				$(element).removeClass("active");
			});
			$(".navbar-nav").find("li:nth-child("+index+")").addClass("active");
		};
		
		function setTabActive(index){
			$(".nav-tabs").find("li").each(function(i, element){
				$(element).removeClass("active");
			});
			$(".nav-tabs").find("li:nth-child("+index+")").addClass("active");
			
			$("#contenido").find(".capaContenido").each(function(i, element){
				$(element).addClass("oculto");
			});
			$("#capa"+index).removeClass("oculto");
		};

		function muestraMensajeError(mensaje){
			$(".alert-danger").html(mensaje).slideDown();
			time = setTimeout(function(){$(".alert-danger").slideUp();},5000);
		}
		
		function muestraMensajeExito(mensaje){
			$(".alert-success").html(mensaje).slideDown();
			time = setTimeout(function(){$(".alert-success").slideUp();},5000);
		}
</script>

</head>
<body>

	<div class="col-md-1"></div>
	<div class="col-md-10 background">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
		<div class="alert alert-success oculto avisos" role="alert">...</div>
		<div class="alert alert-info oculto avisos" role="alert">...</div>
		<div class="alert alert-warning oculto avisos" role="alert">...</div>
		<div class="alert alert-danger oculto avisos" role="alert">...</div>
		<tiles:insertAttribute name="body"></tiles:insertAttribute>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
	<div class="col-md-1"></div>
	
	
</body>
</html>