<%@ page contentType="text/html; charset=UTF-8"%>

<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/angularctrls/listados.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	setMenuActive(3);
	//setTabActive(1);
});
</script>

<script type="text/ng-template" id="customPopupTemplate.html">
  <div class="custom-popup-wrapper"
     ng-style="{top: position().top+'px', left: position().left+'px'}"
     style="display: block;"
     ng-show="isOpen() && !moveInProgress"
     aria-hidden="{{!isOpen()}}">

    <ul class="dropdown-menu" role="listbox">
        <li ng-repeat="match in matches track by $index" ng-class="{active: isActive($index) }"
            ng-mouseenter="selectActive($index)" ng-click="selectMatch($index)" role="option" id="{{::match.id}}">
            <div uib-typeahead-match index="$index" match="match" query="query" template-url="templateUrl"></div>
        </li>
    </ul>
  </div>
</script>

<div class="container-fluid typeahead-demo" ng-controller="ListadosCtrl">

	<!-- <ul class="nav nav-tabs">
		<li role="presentation"><a href="#">Listados</a></li>
	</ul> -->

	<div id="contenido">
		<div id="capa1" class="capaContenido">
			Filtrar contactos por:
			<form role="form">
				<div class="row">
					<div class="col-xs-1">
						<label for="nombre">Medio:</label>
					</div>
					<div class="col-xs-3">
						<!-- <select ng-model="filtro.medio"
							ng-options="medio.nombre for medio in medios"
							class="form-control col-xs-12">
							<option value="">--Seleccione--</option>
						</select> -->
						<input type="text" ng-model="filtro.medio" 
							placeholder="Medio" 
							uib-typeahead="medio.nombre for medio in medios | filter:$viewValue | limitTo: 8" 
							typeahead-popup-template-url="customPopupTemplate.html"
							typeahead-on-select="setMedioFiltro($item)" 
							class="form-control">
					</div>
					<div class="col-xs-1">
						<label for="nombre">Tipo 1:</label>
					</div>
					<div class="col-xs-3">
						<select ng-model="filtro.categoria1"
							ng-options="tipo.nombrecategoria for tipo in tipos1"
							class="form-control col-xs-12">
							<option value="">-- Seleccione --</option>
						</select>
					</div>
					<div class="col-xs-1">
						<div id="ico_fav" ng-class="filtro.destacado ? 'destacado' : ((filtro.destacado == undefined)?'desactivado':'normal')" ng-click="setFiltroDestacado()" title="Filtrar contactos destacados"></div>
					</div>
				</div>	
				<div class="row">
					<div class="col-xs-1">
						<label for="nombre">Tipo 2:</label>
					</div>
					<div class="col-xs-3">
						<select ng-model="filtro.categoria2"
							ng-options="tipo.nombrecategoria for tipo in tipos2"
							class="form-control col-xs-12">
							<option value="">-- Seleccione --</option>
						</select>
					</div>
					<div class="col-xs-1">
						<label for="nombre">Ambito:</label>
					</div>
					<div class="col-xs-3">
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
				
			<button class="btn btn-link" ng-click="exportToExcel('#table1')">
        		<span class="fa fa-file-excel-o"></span> Exportar a Excel
    		</button>				
		</div>
	</div>

</div>

<table id="table1" class="oculto">
	<tr id="fila"><td><strong>Listados de emails</strong></td></tr>
</table>
