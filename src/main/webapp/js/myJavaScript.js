$(document).ready(function () {
    showListDepartments();
});

/*function -> draw department table*/
function drawTableDepartment(dep) {
    $('#test').children().detach();
    var div = $('<div class="container"/>').appendTo($('#test'));

    var table = $('<table class="striped"/>').appendTo(div)
        .append($('<thead/>')
            .append($('<tr/>')
                .append($('<th/>').html('ID:'))
                .append($('<th/>').html('Name:'))
                .append($('<th/>').html('Edit:'))
                .append($('<th/>').html('Delete:'))
                .append($('<th/>').html('List Employee')))
    );

    for (var i = 0; i < dep.length; i++) {
        var department = dep[i];
        $('<tr/>')

            .append($('<td>').text(department.id))
            .append($('<td>').text(department.name))
            .append($('<td>')

            //<a onclick='doalert(this);' href='#post-employee' title='http://localhost:7001/com.backbone.employee/api/emp/empUpdate/"+employee.EMPNO+"' class='btn btn-primary editBtn'>Edit</button>"+


            .append($('<a onclick="addNewDepartments(this.id);" href="#!" >Update</a>')))
            .append($('<td>')
                .append($('<a href="/deleteDepartment" onclick="document.getElementById(id).submit();  return false;">Delete</a>')))
            .append($('<td>')
                .append($('<a id="createNewButton" href="#popup" class="open-popup-link btn btn-primary" role="button">List</a>')))
            .appendTo(table);
    }
    //
    //var div = $('<div/>').appendTo(div)
    //    .append($('<a href="#!" class="btn waves-effect waves-red" onclick="addDepartment">add</a>'));

    $('<button class="btn waves-effect waves-red" onclick="addNewDepartments()"/>').text("+Add dep").appendTo(table);

}

function EditProduct(pid) {
    var ph = $("#DivToAppendPartialVoew");
    ph.load("/Products/edit?productid=" + pid, function () {
        ph.dialog({
            modal: true,
            width: 500,
            height: 438,
            title: "Edit Product",
            resizable: false
        });
    });
}

function DeleteDepartment(id) {
    $.ajax({
        url: '/deleteDepartment',
        type: 'POST',
        dataType: 'json',
        data: {id:id }

        //success: function () {
        //    showListDepartments();
        //}
    })
    //if (confirm("Do you want to delete product: " + dep)) {
    //    var elem = document.getElementById(dep);
    //    domPurge(elem);
    //    return elem.parentNode.removeChild(elem);
    //    var data = {'ProductId': dep}
    //    $.post('/deleteDepartment', data,
    //        function (data) {
    //            if (data == true)
    //                location = location.href;
    //            else
    //                alert("Could not delete");
    //        });
    //}

}

function OpenCreatePopup() {
    var div = $("#DivToAppendPartialVoew");
    div.load("/Products/Create", function () {
        div.dialog({
            modal: true,
            width: 500,
            height: 438,
            title: "Add New Product",
            resizable: false
        });
    });
}
function Delete(pid) {
    $('#deleteConfirmationDialog').dialog({
        autoOpen: false,
        resizable: false,
        height: 140,
        modal: true,
        buttons: {
            "Delete": function () {
                $(this).dialog("close");
            },
            Cancel: function () {
                $(this).dialog("close");
            }
        }
    });
}


//function popitup2() {
//    newwindow2 = window.open('', 'name', 'height=200,width=150');
//    var tmp = newwindow2.document;
//    tmp.write('<html><head><title>popup</title>');
//    //tmp.write('<link rel="stylesheet" href="js.css">');
//    tmp.write('</head><body><p>Delete?</p>');
//    tmp.write('<p><a href="javascript:alert(self.location.href)">view location</a>.</p>');
//    tmp.write('<p><a href="javascript:self.close()">close</a> the popup.</p>');
//    tmp.write('</body></html>');
//    tmp.close();
//}
//function popitup(url) {
//    newwindow = window.open(url, 'name', 'height=200,width=150');
//    if (window.focus) {
//        newwindow.focus()
//    }
//    return false;
//}

function showListDepartments() {
    $.getJSON('/list', function (dep) {
        drawTableDepartment(dep);
    });
}

/*draw form add dep*/
function addNewDepartments(id) {

    $('#test').children().detach();

    var div = $('<div/>').appendTo($('#test'));
    /*Form*/
    var form = $('<form enctype="multipart/form-data" method="post" name="saveDep"/>')
        .append($('<div class="container"/>')
            .append($('<div class="row"/>')
                .append($('<div class="col s4 offset-s4"/>')
                    .append($('<table class="striped"/>')

                        .append($('<input type="hidden" name="id"/>').val(id)).append($('<br/>'))

                        .append($('<label/>').text("Name Department").append($('<br/>')))
                        .append($('<input class="input-control text" type="text" name="name" placeholder="input you name"/>')).append($('<br/>'))

                        .append($('<button class="button primary" onclick="sendDepForController()"/>').text("Add dep"))))))

        .appendTo(div);

}

/*send department data to server*/
function sendDepForController() {
    /*input file to form*/
    var fd = new FormData(document.querySelector("form"));

    $.ajax({
        url: '/list',
        type: 'POST',
        data: fd,
        processData: false,
        contentType: false,
        success: function () {
            showListDepartments();
        }
    });
}

function deleteDep(id) {
    $.ajax({
        contentType: "application/json",
        url: '/delDep',
        type: 'POST',
        dataType: 'json',
        timeout: 100000,
        data: {
            id: id
        },
        success: function () {
            showListDepartments();
        }
    })
}