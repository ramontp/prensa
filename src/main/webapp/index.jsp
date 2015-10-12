<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link href="css/theme.css" rel="stylesheet">
<link href="css/bootstrap-select.css" rel="stylesheet" type="text/css" >
<link href="css/custom.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<div class="col-md-2"></div>
	<div class="col-md-8 background">
		<header id="heading">
			<div class="logo_header">
				<a href="http://www.noletia.es/" title="Ir a Noletia"> <img
					alt="Noletia" src="img/logo-noletia.png">
				</a>
				
			</div>

		</header>
		<br style="margin-top:10px">
		<!-- <nav id="navigation">
			<ul>
				<li><a href="listadoPrensa.action"><span>Medios de
							Prensa</span></a></li>
				<li><a href="inicioListados.action"><span>Listados
							de Emails</span></a></li>
				<li><a href="listadoCategorias.action"><span>Categorias</span></a></li>
				<li><a href="copiaSeguridad.action"><span>Copia de Seguridad</span></a></li>
			</ul>
		</nav> -->
		<div style="clear: both"></div>

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<!-- <div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Brand</a>
				</div> -->

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="#">Medios de Prensa<span class="sr-only">(current)</span></a>
						</li>
						<li><a href="#">Listados de emails</a></li>
						<li><a href="#">Categorias</a></li>
						<!-- <li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">Dropdown
								<span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
								<li class="divider"></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li> -->
					</ul>
					<form class="navbar-form navbar-right" role="search">
						<select class="selectpicker" data-width="100px" title="Buscar">
							<option>Empresa</option>
							<option>Provincia</option>
							<option>Email</option>
						</select>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Buscar</button>
					</form>
					<!-- <ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">Buscar por
								<span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Empresa</a></li>
								<li><a href="#">Provincia</a></li>
								<li><a href="#">Email</a></li>
								<li><a href="#">Categoria</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul></li>
					</ul> -->
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>


		<!-- <div>
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#">Buscador</a></li>
				<li role="presentation"><a href="#">Alta / Edición</a></li>
			</ul>
		</div>
		<div id="separador"></div> -->

		<div>

			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">Listado de Medios de Prensa</div>

				<!-- Table -->
				<table class="table">
					<thead>
						<tr>
							<th>Empresa</th>
							<th>Provincia</th>
						</tr>
					</thead>
					<tr class="even">
						<td>20 minutos</td><td>Sevilla</td>
					</tr>
					<tr class="odd">
						<td>ABC de Sevilla</td><td>Sevilla</td>
					</tr>
				</table>
			</div>

		</div>
		<footer>
			<hr>
			<div style="text-align: center">Prensa v - Achtung Baby
				Productions &copy;</div>

		</footer>
	</div>
	<div class="col-md-2"></div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-select.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".selectpicker").selectpicker({
				style: 'btn-info',
			    size: 4,
			    width
			});
		});
	</script>
</body>
</html>