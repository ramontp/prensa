/**
 * 
 */

contactosApp.controller('ContactosCtrl', function ($scope, $http) {

    $scope.setMedioBuscar = function (medio) {
        $scope.contacto.medio = medio;
    };

    $scope.addObservaciones = function (contacto) {
        if ($("#obs_" + contacto.idcontacto).length) {
            $("#obs_" + contacto.idcontacto).remove();
        } else {
            var newRow = $("<tr id='obs_" + contacto.idcontacto + "'><td colspan='5' class='observaciones'>" + contacto.observaciones + "</td></tr>");
            newRow.insertAfter($("#contacto_" + contacto.idcontacto).closest("tr")).hide().show("slow");
        }
    };

    $http.get("/prensa/medios/getMediosSelect")
            .success(function (response) {
                $scope.medios = response;
            });

    $scope.contacto = {};
    $scope.contactos = null;
    $scope.buscaContactos = function () {
        $http.post("/prensa/buscaContactos", $scope.contacto)
                .success(function (response) {
                    $scope.contactos = response;
                    var numContactos = $scope.contactos.length;
                    var contactosEncontrados = 'contacto encontrado';
                    if (numContactos > 1) {
                        contactosEncontrados = 'contactos encontrados';
                    }
                    $("#numContacts").html('(' + $scope.contactos.length + ' ' + contactosEncontrados + ')');
                })
                .error(function () {
                    muestraMensajeError('Se ha producido un error en la consulta de Contactos');
                });
    };

    $scope.resetAddContactForm = function () {
        $scope.contacto.nombre = null;
        $scope.contacto.telefono = null;
        $scope.contacto.email = null;
        $scope.contacto.medio = null;
        $scope.contacto.destacado = null;
        $scope.contacto.fotografo = null;
        $scope.buscaContactosForm.$setPristine();
    };

    $scope.limpiarCamposBusqueda = function () {
        $scope.resetAddContactForm();
    };

    $scope.formGuardaContacto = function (contacto) {
        if (contacto !== null) {
            $("#altaModificaContacto").html('Actualizar');
            $scope.contactoEdicion = angular.copy(contacto);
        } else {
            $("#altaModificaContacto").html('Alta');
            $scope.contactoEdicion = {};
        }

        $("#formInline").removeClass("oculto");

    };

    $scope.cancelarGuardar = function () {
        $("#formInline").addClass("oculto");
    };

    $scope.guardaContacto = function () {

        if ($scope.formAltaContacto.$valid) {
            $http.post("/prensa/contactos/" + (($scope.contactoEdicion.idcontacto > 0) ? "update" : "add") + "Contacto", $scope.contactoEdicion)
                    .success(function () {
                        var mensaje = "actualizado";
                        if ($scope.contactoEdicion.idcontacto == null) {
                            mensaje = "dado de alta";
                        }

                        $scope.buscaContactos();
                        muestraMensajeExito('Se ha ' + mensaje + ' el contacto correctamente');
                        $scope.cancelarGuardar();
                    })
                    .error(function () {
                        muestraMensajeError('Se ha producido un error al guardar la edición del contacto');
                    });
        }
    };

    $scope.borraContacto = function (contacto) {
        if (confirm('Vas a eliminar un contacto. ¿Estás seguro?')) {
            $http.post("/prensa/contactos/borraContacto", contacto)
                    .success(function () {
                        $scope.buscaContactos();
                        muestraMensajeExito('Se ha eliminado el contacto correctamente');
                    })
                    .error(function () {
                        muestraMensajeError('Se ha producido un error al borrar contacto');
                    });
        }
    };

    $scope.setDestacado = function (contacto) {
        contacto.destacado = (contacto.destacado === 0) ? 1 : 0;
        $http.post("/prensa/contactos/setDestacado", contacto)
                .success(function () {
                    $scope.buscaContactos();
                })
                .error(function () {
                    muestraMensajeError('Se ha producido un error al destacar el contacto');
                });
    };

    $scope.setFotografo = function (contacto) {
        contacto.fotografo = (contacto.fotografo === 0) ? 1 : 0;
        $http.post("/prensa/contactos/setFotografo", contacto)
                .success(function () {
                    $scope.buscaContactos();
                })
                .error(function () {
                    muestraMensajeError('Se ha producido un error al actualizar el contacto');
                });
    };

    $scope.setFiltroDestacado = function () {
        switch ($scope.contacto.destacado) {
            case 0:
                $scope.contacto.destacado = 1;
                break;
            case 1:
                $scope.contacto.destacado = null;
                break;
            default:
                $scope.contacto.destacado = 0;
        }
    };

    $scope.setFiltroFotografo = function () {
        switch ($scope.contacto.fotografo) {
            case 0:
                $scope.contacto.fotografo = 1;
                break;
            case 1:
                $scope.contacto.fotografo = null;
                break;
            default:
                $scope.contacto.fotografo = 0;
        }
    };

});

