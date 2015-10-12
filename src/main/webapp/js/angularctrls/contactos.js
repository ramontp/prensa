/**
 * 
 */

contactosApp.controller('ContactosCtrl', function($scope, $http, ngDialog){
	
	$http.get("/prensa/medios/getMediosSelect")
	.success(function(response){
		$scope.medios = response;
	});
	
	$scope.contacto = {};
	$scope.contactos = null;
	$scope.buscaContactos = function (){
		$http.post("/prensa/buscaContactos", $scope.contacto)
		.success(function(response){
			$scope.contactos = response;
		})
		.error(function(){
			muestraMensajeError('Se ha producido un error en la consulta de Contactos');
		});
	};
	
	$scope.resetAddContactForm = function(){
		$scope.contacto.nombre = null;
		$scope.contacto.telefono = null;
		$scope.contacto.email = null;
		$scope.contacto.medio = null;
		$scope.buscaContactosForm.$setPristine();
	};
		
	$scope.limpiarCamposBusqueda = function(){
		$scope.resetAddContactForm();
	};

	$scope.formGuardaContacto = function(contacto){
		if (contacto != null){
			$("#altaModificaContacto").html('Actualizar');
			$scope.contactoEdicion = angular.copy(contacto);
		} else {
			$("#altaModificaContacto").html('Alta');
			$scope.contactoEdicion = {};
		}

		$("#formInline").removeClass("oculto");
		
	};

	$scope.cancelarGuardar = function(){
		$("#formInline").addClass("oculto");
	};
	
	$scope.guardaContacto = function(){

		if ($scope.formAltaContacto.$valid) {
            $http.post("/prensa/contactos/"+ (($scope.contactoEdicion.idcontacto > 0)?"update":"add") +"Contacto", $scope.contactoEdicion)
            .success(function(){
            	var mensaje = "actualizado";
            	if ($scope.contactoEdicion.idcontacto == null){
            		mensaje = "dado de alta";
            	}            	
            	
        		$scope.buscaContactos();
				muestraMensajeExito('Se ha '+ mensaje + ' el contacto correctamente');
				$scope.cancelarGuardar();
			})
			.error(function(){
				muestraMensajeError('Se ha producido un error al guardar la edición del contacto');
			});
		}
	};
	

	$scope.checkDisableFormAlta = function(){
		if (!angular.isUndefined($scope.formAltaContacto) || $scope.formAltaContacto === null){
			if ($scope.formAltaContacto.$invalid || noFieldFilled()){
				return true;	
			}
		}
		return false;
	};
	
	function noFieldFilled(){
		return $("form[name='formAltaContacto']").find("#nombre").val().length === 0 &&
		$("form[name='formAltaContacto']").find("#telefono").val().length === 0 &&
		$("form[name='formAltaContacto']").find("#email").val().length === 0 ;
	};
	
	$scope.borraContacto = function(contacto){
		if (confirm('Vas a eliminar un contacto. ¿Estás seguro?')){
			$http.post("/prensa/contactos/borraContacto", contacto)
			.success(function(){
				$scope.buscaContactos();
				muestraMensajeExito('Se ha eliminado el contacto correctamente');
			})
			.error(function(){
				muestraMensajeError('Se ha producido un error al borrar contacto');
			});
		}
	};
	
});

