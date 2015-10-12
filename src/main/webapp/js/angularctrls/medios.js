/**
 * 
 */

contactosApp.controller('MediosCtrl', function($scope, $http, ngDialog){

	$http.get("/prensa/medios/getTipos1Select")
	.success(function(response){
		$scope.tipos1 = response;
	});

	$http.get("/prensa/medios/getTipos2Select")
	.success(function(response){
		$scope.tipos2 = response;
	});
	
	$http.get("/prensa/medios/getAmbitos")
	.success(function(response){
		$scope.ambitos = response;
	});
	
	$scope.medio = {};
	$scope.medios = null;
	$scope.buscaMedios = function (){
		$http.post("/prensa/medios/buscaMedios", $scope.medio)
		.success(function(response){
			$scope.medios = response;
		})
		.error(function(){
			muestraMensajeError('Se ha producido un error en la consulta de Medios');
		});
	};
	
	$scope.resetAddMedioForm = function(){
		$scope.medio.nombre = null;
		$scope.medio.categoria1 = null;
		$scope.medio.categoria2 = null;
		$scope.medio.ambito = null;
	};
	
	$scope.limpiarCamposBusqueda = function(){
		$scope.resetAddMedioForm();
	};
	
	$scope.formGuardaMedio = function(medio){
		if (medio != null){
			$("#altaModificaMedio").html('Actualizar');
			$scope.medioEdicion = angular.copy(medio);
		} else {
			$("#altaModificaMedio").html('Alta');
			$scope.medioEdicion = {};
		}

		$("#formInline").removeClass("oculto");
		
	};
	
	$scope.guardaMedio = function(){

		if ($scope.formAltaMedio.$valid) {
            $http.post("/prensa/medios/"+ (($scope.medioEdicion.idmedio > 0)?"update":"add") +"Medio", $scope.medioEdicion)
            .success(function(){
            	var mensaje = "actualizado";
            	if ($scope.medioEdicion.idmedio == null){
            		mensaje = "dado de alta";
            	}            	
            	
        		$scope.buscaMedios();
				muestraMensajeExito('Se ha '+ mensaje + ' el medio correctamente');
				$scope.cancelarGuardar();
			})
			.error(function(){
				muestraMensajeError('Se ha producido un error al guardar la edición del medio');
			});
		}
	};
	
	$scope.cancelarGuardar = function(){
		$("#formInline").addClass("oculto");
	};
	
	$scope.borraMedio = function(medio){
		if (confirm("¿Estás seguro de borrar el medio?")){
			$http.post("/prensa/medios/borraMedio", medio)
			.success(function(){
				$scope.buscaMedios();
				muestraMensajeExito('Se ha borrado el medio correctamente');				
			})
			.error(function(){
				muestraMensajeError('Se ha producido un error al borrar el medio');
			});
		}
	};
	
});