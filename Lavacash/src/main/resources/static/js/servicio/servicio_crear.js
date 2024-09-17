let serviciosDisponibles;
let serviciosAgregados = [];

/**
 * Se encarga de consultar servicios de la api y levantar el modal
 */
function escogerServicios() {
    consultarServicios(cargarServiciosDisponibles);
    $('#modalEscogerServicios').modal('show');
}

function cargarServiciosDisponibles(servicios) {
    servicios.forEach( (servicio) => {
        $("#tableModal > tbody").append("<tr>" + 
                "<td>" + servicio.id + "</td>" + 
                "<td>" + servicio.nombre + "</td>" + 
                "<td>" + servicio.descripcion + "</td>" + 
                "<td><input type='checkbox' class='' value='' /></td>" +
            "</tr>");
    });
}

function consultarServicios(action) {
    $.ajax( {
        url: 'http://localhost:8080/api/servicio/',
        data: null,
        processData: false,
        contentType: 'application/json',
        async: false,
        cache: false,
        type: 'GET',
        success: (datos) => {
            action(datos);
            serviciosAgregados = datos;
            actualizarTabla();
        },
        error: (error) => {
            console.log(error);
            window.alert("ERROR: no hubo respuesta del servidor.");
        }
    } );
}

function limpiarTabla(nombre) {
    $("#" + nombre + " > tbody").empty();
}

function actualizarTabla() {
    serviciosAgregados.forEach( (servicio) => {
        $("#tableBody > tbody").append("<tr id='" + servicio.id + "'>" + 
                "<td>" + servicio.id + "</td>" + 
                "<td>" + servicio.nombre + "</td>" + 
                "<td>" + servicio.descripcion + "</td>" + 
                "<td><button type='button' class='btn btn-secondary' value='Eliminar' >Eliminar</button></td>" +
            "</tr>");
    });
}

limpiarTabla("tableBody");
