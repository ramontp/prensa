/**
 * 
 */

contactosApp.controller('ListadosCtrl', function($scope, $http) {

	$http.get("/prensa/medios/getMediosSelect")
	.success(function(response){
		$scope.medios = response;
	});

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
	
	$scope.filtro = {};
	
	$scope.limpiarFiltro = function(){
		$scope.filtro.medio = null;
		$scope.filtro.categoria1 = null;
		$scope.filtro.categoria2 = null;
		$scope.filtro.ambito = null;
		$("#listadoTextarea").html('');
		$("#numElementos").html('');
	};
	
	$scope.filtraContactos = function(){
		$("#listadoTextarea").html('');
		$http.post("/prensa/listados/filtraContactos", $scope.filtro)
		.success(function(response){
			$scope.contactos = response;
			var listado="";
			var contador = 0;
			angular.forEach($scope.contactos, function(value, key){
				//console.log(value.email+'_'+key);
				if (value.email != ""){
					listado += value.email.toLowerCase() + ', ';
					contador++;
				}
				if (value.email2 != ""){
					listado += value.email2.toLowerCase() + ', ';
					contador++;
				}
			});
			if (contador == 1){
				$("#numElementos").html("Se ha encontrado un email");				
			} else {
				$("#numElementos").html("Se han encontrado "+contador+" emails");
			}
			$("#listadoTextarea").html(listado.substr(0, listado.length-2));
		})
		.error(function(){
			muestraMensajeError('Se ha producido un error al filtrar los contactos');
		});
	};
	
});