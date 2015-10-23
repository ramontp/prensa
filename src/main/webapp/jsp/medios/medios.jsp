<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/angularctrls/medios.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		setMenuActive(2);
		setTabActive(1);
	});
</script>

<div ng-controller="MediosCtrl">

	<!-- <ul class="nav nav-tabs">
		<li role="presentation"><a href="#">Medios disponibles</a></li>
	</ul> -->

	<div id="contenido">
		<div id="capa1" class="capaContenido">
			<form role="form">
				<div class="row">
					<div class="col-xs-1">
						<label for="nombre">Nombre:</label>
					</div>
					<div class="col-xs-2">
						<input type="text" id="nombre" ng-model="medio.nombre"
							placeholder="Nombre" class="form-control col-xs-12">
					</div>
					<div class="col-xs-1">
						<label for="telefono">Tipo 1:</label>
					</div>
					<div class="col-xs-2">
						<select ng-model="medio.categoria1"
							ng-options="tipo.nombrecategoria for tipo in tipos1"
							class="form-control col-xs-12">
							<option value="">-- Seleccione --</option>
						</select>
					</div>
					<div class="col-xs-1">
						<label for="email">Tipo 2:</label>
					</div>
					<div class="col-xs-2">
						<select ng-model="medio.categoria2"
							ng-options="tipo.nombrecategoria for tipo in tipos2"
							class="form-control col-xs-12">
							<option value="">-- Seleccione --</option>
						</select>
					</div>
					<div class="col-xs-1">
						<label for="medio">Ámbito:</label>
					</div>
					<div class="col-xs-2">
						<select ng-model="medio.ambito"
							ng-options="ambito.nombre group by ambito.agrupacion for ambito in ambitos"
							class="form-control col-xs-12">
							<option value="">-- Seleccione --</option>
						</select>
					</div>
				</div>
				<div class="" style="text-align: right; padding-top: 10px;">
					<button type="button" ng-click="limpiarCamposBusqueda();"
						class="btn btn-default">Limpiar campos</button>
					<button type="button" ng-click="buscaMedios();"
						class="btn btn-default">Buscar</button>
				</div>
			</form>

			<div class="alert alert-info" ng-show="medios.length === 0">No hay resultados</div>
			<div class="panel panel-default" ng-show="medios.length !== 0">
				<!-- Default panel contents -->
				<div class="panel-heading">Listado de Medios</div>

				<!-- Table -->
				<table class="table">
					<thead>
						<tr>
							<th>Medio</th>
							<th>Tipo 1</th>
							<th>Tipo 2</th>
							<th>Ámbito</th>
							<th width="50px;"><a
							class="fa fa-plus fa-fw enlace"
							ng-click="formGuardaMedio(null)"></a></th>
						</tr>
					</thead>
					<tbody>
				    <tr id="formInline" class="oculto">
					    <td colspan="5">
							<form role="form" name="formAltaMedio" novalidate="novalidate">
								<div class="row">
									<div class="col-xs-4">
										<label for="nombre">Nombre:</label>
									</div>
									<div class="col-xs-8" ng-class="{errorFormulario: formAltaMedio.$invalid && formAltaMedio.nombre.$dirty}">
										<input type="text" name="nombre" ng-model="medioEdicion.nombre" required>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-4">
										<label for="telefono">Tipo 1:</label>
									</div>
									<div class="col-xs-8">
										<select ng-model="medioEdicion.categoria1"
											ng-options="tipo.nombrecategoria for tipo in tipos1 track by tipo.idcategoria"
											class="form-control col-xs-12">
											<option value="">-- Seleccione --</option>
										</select>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-4">
										<label for="email">Tipo 2:</label>
									</div>
									<div class="col-xs-8">
										<select ng-model="medioEdicion.categoria2"
											ng-options="tipo.nombrecategoria for tipo in tipos2 track by tipo.idcategoria"
											class="form-control col-xs-12">
											<option value="">-- Seleccione --</option>
										</select>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-4">
										<label for="telefono">Ámbito:</label>
									</div>
									<div class="col-xs-8">
										<select ng-model="medioEdicion.ambito"
											ng-options="ambito.nombre group by ambito.agrupacion for ambito in ambitos track by ambito.idambito"
											class="form-control"></select>
									</div>
								</div>
								<div class="">
									<button type="button" ng-click="cancelarGuardar();"
										class="btn btn-default">Cancelar</button>
									<button type="button" ng-click="guardaMedio();" id="altaModificaMedio"
										class="btn btn-default" value="Alta"></button>
								</div>
							</form>
					    </td>
					</tr>
					<tr ng-repeat="medio in medios">
						<td>{{medio.nombre}}</td>
						<td>{{medio.categoria1.nombrecategoria}}</td>
						<td>{{medio.categoria2.nombrecategoria}}</td>
						<td>{{medio.ambito.nombre}}</td>
						<td style="width: 60px;"><a
							class="fa fa-pencil fa-fw enlace"
							ng-click="formGuardaMedio(medio)"></a> <a
							class="fa fa-trash-o fa-fw enlace"
							ng-click="borraMedio(medio)"></a></td>
					</tr>
					</tbody>

				</table>
			</div>
		</div>
		
	</div>

</div>