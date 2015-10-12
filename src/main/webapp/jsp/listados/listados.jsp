<%@ page contentType="text/html; charset=UTF-8"%>

<script type="text/javascript" src="js/angularctrls/listados.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	setMenuActive(3);
	setTabActive(1);
});
</script>


<div ng-controller="ListadosCtrl">

	<ul class="nav nav-tabs">
		<li role="presentation"><a href="#">Listados</a></li>
	</ul>

	<div id="contenido">
		<div id="capa1" class="capaContenido">
			Filtrar contactos por:
			<form role="form">
				<div class="row">
					<div class="col-xs-1">
						<label for="nombre">Medio:</label>
					</div>
					<div class="col-xs-2">
						<select ng-model="filtro.medio"
							ng-options="medio.nombre for medio in medios"
							class="form-control col-xs-12">
							<option value="">--Seleccione--</option>
						</select>
					</div>
					<div class="col-xs-1">
						<label for="nombre">Tipo 1:</label>
					</div>
					<div class="col-xs-2">
						<select ng-model="filtro.categoria1"
							ng-options="tipo.nombrecategoria for tipo in tipos1"
							class="form-control col-xs-12">
							<option value="">-- Seleccione --</option>
						</select>
					</div>
					<div class="col-xs-1">
						<label for="nombre">Tipo 2:</label>
					</div>
					<div class="col-xs-2">
						<select ng-model="filtro.categoria2"
							ng-options="tipo.nombrecategoria for tipo in tipos2"
							class="form-control col-xs-12">
							<option value="">-- Seleccione --</option>
						</select>
					</div>
					<div class="col-xs-1">
						<label for="nombre">Ambito:</label>
					</div>
					<div class="col-xs-2">
						<select ng-model="filtro.ambito"
							ng-options="ambito.nombre group by ambito.agrupacion for ambito in ambitos"
							class="form-control col-xs-12">
							<option value="">-- Seleccione --</option>
						</select>
					</div>
				</div>
				<div class="" style="text-align: right; padding-top: 10px;">
					<button type="button" ng-click="limpiarFiltro();"
						class="btn btn-default">Limpiar campos</button>
					<button type="button" ng-click="filtraContactos();"
						class="btn btn-default">Buscar</button>
				</div>
			</form>
			<!-- <div class="alert alert-info" ng-show="contactos.length === 0">No
				hay resultados</div> -->
			<div id="numElementos" style="display: block; margin-left: auto; margin-right: auto; width: 84%">&nbsp;</div>
			<textarea id="listadoTextarea" rows="10" cols="100"
				style="display: block; margin-left: auto; margin-right: auto;"></textarea>
		</div>
	</div>

</div>
