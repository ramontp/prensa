<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/angularctrls/contactos.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		setMenuActive(1);		
		setTabActive(1);
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

<div class="loading-spiner-holder modal" loading ><div class="loading-spiner"></div></div>

<div class="container-fluid typeahead-demo" ng-controller="ContactosCtrl">

	<!-- <ul class="nav nav-tabs">
		<li role="presentation"><a href="#">Búsqueda contactos</a></li>
	</ul> -->

	<div id="contenido">
		<div id="capa1" class="capaContenido">
			<form role="form" name="buscaContactosForm">
				<div class="row">
					<div class="col-xs-1">
						<label for="nombre">Nombre:</label>
					</div>
					<div class="col-xs-2">
						<input type="text" id="nombre" ng-model="contacto.nombre"
							placeholder="Nombre" class="form-control col-xs-12">
					</div>
					<!-- <div class="col-xs-1">
						<label for="telefono">Teléfono:</label>
					</div>
					<div class="col-xs-2">
						<input type="text" id="telefono" ng-model="contacto.telefono"
							placeholder="Teléfono" class="form-control col-xs-12">
					</div> -->
					<div class="col-xs-1">
						<label for="email">Email:</label>
					</div>
					<div class="col-xs-3">
						<input type="text" id="email" ng-model="contacto.email"
							placeholder="Email" class="form-control col-xs-12">
					</div>
					<div class="col-xs-1">
						<label for="medio">Medio:</label>
					</div>
					<div class="col-xs-3">						
						<input type="text" ng-model="contacto.medio" 
							placeholder="Medio" 
							uib-typeahead="medio.nombre for medio in medios | filter:$viewValue | limitTo: 8" 
							typeahead-popup-template-url="customPopupTemplate.html"
							typeahead-on-select="setMedioBuscar($item)" 
							class="form-control">
					</div>
					<div class="col-xs-1">
						<div id="ico_fav" ng-class="contacto.destacado ? 'destacado' : ((contacto.destacado == undefined)?'desactivado':'normal')" ng-click="setFiltroDestacado()" title="Filtrar contactos destacados"></div>
					</div>
				</div>
				<div class="" style="text-align: right; padding-top: 10px;">
					<button type="button" ng-click="limpiarCamposBusqueda();"
						class="btn btn-default">Limpiar campos</button>
					<button type="button" ng-click="buscaContactos();"
						class="btn btn-default">Buscar</button>
				</div>
			</form>
			<div class="alert alert-info" ng-show="contactos.length === 0">No
				hay resultados</div>
			<div class="panel panel-default" ng-show="contactos.length !== 0">
				<!-- Default panel contents -->
				<div class="panel-heading">Listado de Contactos <span id="numContacts"></span></div>

				<!-- Table -->
				<table class="table">
					<thead>
						<tr>
							<th></th>
							<th>Nombre</th>
							<th>Teléfono</th>
							<th>Email</th>
							<th>Medio</th>
							<th width="50px;"><a
							class="fa fa-plus fa-fw enlace"
							ng-click="formGuardaContacto(null)"></a></th>
						</tr>
					</thead>
					<tbody>
						<tr id="formInline" class="oculto">
							<td colspan="5">
								<form role="form" name="formAltaContacto" novalidate="novalidate">
									<div class="row">
										<div class="col-xs-4">
											<label for="nombre">Nombre:</label>
										</div>
										<div class="col-xs-8">
											<input type="text" name="nombre" ng-model="contactoEdicion.nombre">
										</div>
									</div>
									<div class="row">
										<div class="col-xs-4">
											<label for="observaciones">Observaciones:</label>
										</div>
										<div class="col-xs-8">
											<textarea rows="5" cols="50" ng-model="contactoEdicion.observaciones"></textarea>
										</div>
									</div>
									<div class="row" ng-class="{ errorFormulario: formAltaContacto.telefono.$invalid }">
										<div class="col-xs-4">
											<label for="telefono">Telefono:</label>
										</div>
										<div class="col-xs-8">
											<input type="text" name="telefono" ng-model="contactoEdicion.telefono">
										</div>
									</div>
									<div class="row" ng-class="{ errorFormulario: formAltaContacto.email.$invalid }">
										<div class="col-xs-4">
											<label for="email">Email:</label>
										</div>
										<div class="col-xs-8">
											<input type="text" name="email" ng-model="contactoEdicion.email">
										</div>
									</div>
									<div class="row" ng-class="{ errorFormulario: formAltaContacto.email2.$invalid }">
										<div class="col-xs-4">
											<label for="email">Email 2:</label>
										</div>
										<div class="col-xs-8">
											<input type="text" name="email2" ng-model="contactoEdicion.email2">
										</div>
									</div>
									<div class="row">
										<div class="col-xs-4">
											<label for="telefono">Medio:</label>
										</div>
										<div class="col-xs-8">
											<select ng-model="contactoEdicion.medio"
												ng-options="medio.nombre for medio in medios track by medio.idmedio"
												class="form-control"></select>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-4">
											<label for="telefono">Destacado:</label>
										</div>
										<div class="col-xs-8">
											<input type="checkbox" ng-model="contactoEdicion.destacado"
											ng-true-value="1"
											ng-false-value="0">
										</div>
									</div>
									<div class="">
										<button type="button" ng-click="cancelarGuardar();"
											class="btn btn-default">Cancelar</button>
										<button type="button" ng-click="guardaContacto();" id="altaModificaContacto"
											class="btn btn-default" value="Alta"></button>
									</div>
								</form>
							</td>
						</tr>
						<tr ng-repeat="contact in contactos">
							<td><div id="ico_fav" ng-class="contact.destacado ? 'destacado' : 'normal'" ng-click="setDestacado(contact)"></div></td>
							<td>{{contact.nombre}}</td>
							<td>{{contact.telefono}}</td>
							<td>{{contact.email}} <span ng-show="contact.email2.length > 0"> / {{contact.email2}}</span></td>
							<td>{{contact.medio.nombre}}</td>
							<td id="contacto_{{contact.idcontacto}}" style="width: 80px;"><a
								class="fa fa-pencil fa-fw enlace"
								ng-click="formGuardaContacto(contact)"></a> <a
								class="fa fa-trash-o fa-fw enlace"
								ng-click="borraContacto(contact)"></a> <a
								class="fa fa-file-text-o fa-fw enlace"
								ng-click="addObservaciones(contact)" ng-show="contact.observaciones"></a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

