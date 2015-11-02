/**
 * 
 */

contactosApp.controller('ListadosCtrl', function($scope, $http, Excel, $timeout) {

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
		$scope.filtro.destacado = null;
		$scope.filtro.fotografo = null;
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
				if (value.email){
					listado += value.email.toLowerCase() + ', ';
					contador++;
					addToTable(value.email);
				}
				if (value.email2){
					listado += value.email2.toLowerCase() + ', ';
					contador++;
					addToTable(value.email2);
				}
			});
			if (contador === 1){
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
	
	addToTable = function(email){
		$("#table1").append("<tr><td>"+email+"</td></tr>");
	};

	$scope.setFiltroDestacado = function(){
		switch($scope.filtro.destacado){
		case 0:
			$scope.filtro.destacado=1;
			break;
		case 1:
			$scope.filtro.destacado=null;
			break;
		default:
			$scope.filtro.destacado=0;
		}
	};

	$scope.setFiltroFotografo = function(){
		switch($scope.filtro.fotografo){
		case 0:
			$scope.filtro.fotografo=1;
			break;
		case 1:
			$scope.filtro.fotografo=null;
			break;
		default:
			$scope.filtro.fotografo=0;
		}
	};
	
	$scope.setMedioFiltro = function(medio){
		$scope.filtro.medio = medio;
	};

	$scope.exportToExcel=function(tableId){ // ex: '#my-table'
	  var exportHref=Excel.tableToExcel(tableId,'Emails');
	  $timeout(function(){location.href=exportHref;},100); // trigger download
	};
	
});


contactosApp.factory('Excel',function($window){
    var uri='data:application/vnd.ms-excel;base64,',
        template='<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
        base64=function(s){return $window.btoa(unescape(encodeURIComponent(s)));},
        format=function(s,c){return s.replace(/{(\w+)}/g,function(m,p){return c[p];});};
    return {
        tableToExcel:function(tableId,worksheetName){
            var table=$(tableId),
                ctx={worksheet:worksheetName,table:table.html()},
                href=uri+base64(format(template,ctx));
            return href;
        }
    };
});