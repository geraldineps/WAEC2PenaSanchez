var fechaActual = new Date().toISOString().split('T')[0];

$(document).on("click", "#btnagregar", function(){
    $("#txtnombrecurso").val("");
    $("#txtresumencurso").val("");
    $("#hddidcurso").val("0");
    listarCboDocentes(0);
    $("#fecharegistro").val(fechaActual);
    $("#modalcurso").modal("show");
});

$(document).on("click", ".btnactualizar", function()
{
    $("#txtnombrecurso").val($(this).attr("data-cursoname"));
    $("#txtresumencurso").val($(this).attr("data-cursoresumem"));
    $("#hddidcurso").val($(this).attr("data-cursocod"));
    $("#cbodocente").empty();
    listarCboDocentes($(this).attr("data-cursodoc"));
    $("#fecharegistro").val($(this).attr("data-cursoreg"));
    $("#modalcurso").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/curso/register",
        contentType: "application/json",
        data: JSON.stringify({
            idcurso: $("#hddidcurso").val(),
            nomcurso: $("#txtnombrecurso").val(),
            resumen: $("#txtresumencurso").val(),
            iddocente: $("#cbodocente").val(),
            fecharegistro: $("#fecharegistro").val(),
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarCursos()
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalcurso").modal("hide");
});

function listarCursos(){
    $.ajax({
        type: "GET",
        url: "/curso/list",
        dataType: "json",
        success: function(resultado){
            $("#tblcurso > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblcurso > tbody").append(`<tr>`+
                `<td>${value.idcurso}</td>`+
                `<td>${value.nomcurso}</td>`+
                `<td>${value.resumen}</td>`+
                `<td>${value.fecharegistro}</td>`+
                `<td>${value.docente.nomdocente}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-cursocod="${value.idcurso}" `+
                    `data-cursoname="${value.nomcurso}" `+
                    `data-cursoresumem="${value.resumen}" `+
                    `data-cursoreg="${value.fecharegistro}" `+
                    `data-cursodoc="${value.docente.iddocente}">Actualizar`+
                `</button></td>`+
                `</tr>`);
            });
        }
    });
}

function listarCboDocentes(iddocente){
    $.ajax({
        type: "GET",
        url: "/docente/get",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbodocente").append(
                    `<option value="${value.iddocente}">${value.nomdocente}</option>`
                )
            });
            if(iddocente > 0){
                $("#cbodocente").val(iddocente);
            }
        }
    })
}