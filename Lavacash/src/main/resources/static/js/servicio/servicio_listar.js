function consultarServicios(callback) {
    $.ajax( {
        url: './api/',
        processData: false,
        contentType: false,
        async: false,
        cache: false,
        type: 'GET',
        success: (datos) => {
            callback(datos);
        },
        error: (error) => {
            console.log(error);
            window.alert("ERROR: no hubo respuesta del servidor.");
        }
    } );
}

function cargarServicios(servicios) {
    servicios.forEach( (servicio) => {
        $("#tableBody > tbody").append("<tr>" + 
                "<td>" + servicio.id + "</td>" + 
                "<td>" + servicio.tipo + "</td>" + 
                "<td>" + servicio.nombre + "</td>" + 
                "<td>" + servicio.descripcion + "</td>" + 
                "<td>" + servicio.precio + "</td>" + 
                "<td>" + servicio.tiempo + "</td>" + 
                "<td>" +
                    "<button type='button' class='btn btn-secondary' "+
                    ">Modificar</button>" + 
                    "<button type='button' class='btn btn-danger' "+
                    "onclick='eliminarServicio("+ servicio.id +
                    ")'>Eliminar</button>" + 
                "</td>" +
            "</tr>");
    });
}

function eliminarServicio(id) {
    console.log(id);
    $.ajax( {
        url: './api/' + id,
        data: null,
        processData: false,
        contentType: false,
        async: false,
        cache: false,
        type: 'DELETE',
        success: (datos) => {
            window.alert("BORRADO EXITOSO");
            location.reload();
        },
        error: (error) => {
            window.alert("ERROR AL COMUNICARSE CON EL SERVIDOR");
        }
    } );
}

consultarServicios(cargarServicios);