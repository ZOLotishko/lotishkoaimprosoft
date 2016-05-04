$(document).ready(function () {
    showListDepartments();
});


function drawTableDepartment(dep) {
    $('#test').children().detach();
    var div = $('<div class="container"/>').appendTo($('#test'));

    var h1 = $('<h1 class="card-panel teal lighten-2" align="center">List Department</h1>').appendTo(div);
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
        $('<tr/>').append($('<td>').text(department.id))
            .append($('<td>').text(department.name))
            .append($('<td>')
                .append($('<a href="/saveDepartment" onclick="addNewDepartments(' + department + ').submit();  return false;">Update</a>')))
            .append($('<td>')
                .append($('<a href="/deleteDepartment" onclick="DeleteDepartment(' + department.id + ').submit();  return false;">Delete</a>')))
            .append($('<td>')
                .append($('<a href="/deleteDepartment" onclick="DeleteDepartment(' + department.id + ').submit();  return false;">List</a>')))
            .appendTo(table);
    }
    //
    //var div = $('<div/>').appendTo(div)
    //    .append($('<a href="#!" class="btn waves-effect waves-red" onclick="addDepartment">add</a>'));

    $('<button class="btn waves-effect waves-red" onclick="addNewDepartments()"/>').text("+Add dep").appendTo(table);

}

function EditProduct(department) {
    $.ajax({
        url: '/saveDep',
        type: 'POST',
        dataType: 'json',
        data: {id: id},
        success: function () {
            addNewDepartments(department);
        }


    })
    //var ph = $("#DivToAppendPartialVoew");
    //ph.load("/Products/edit?productid=" + pid, function () {
    //    ph.dialog({
    //        modal: true,
    //        width: 500,
    //        height: 438,
    //        title: "Edit Product",
    //        resizable: false
    //    });
    //});
}

function DeleteDepartment(id) {
    $.ajax({
        url: '/deleteDepartment',
        type: 'POST',
        dataType: 'json',
        data: {id: id},
        success: function () {
            showListDepartments();
        }


    })

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

function showListDepartments() {
    $.getJSON('/list', function (dep) {
        drawTableDepartment(dep);
    });
}
//
//function showAddDepartment() {
//    $.getJSON('/saveDepartment', function (department) {
//        addNewDepartments(department);
//    });
//}
function addNewDepartments() {
    $('#test').children().detach();

    var div = $('<div class="container"/>').appendTo($('#test'));

    var form = $('<form method="POST" name ="saveDepartment"/>').appendTo(div);


    $('<h1 class="card-panel teal lighten-2" align="center"/>').text("New Department").appendTo(form);
    $('<div class="row"/>')
        .append($('<div class="col s4 offset-s4"/>')
            .append($('<input type="hidden" name="id"/>')).append($('<br/>'))
            .append($('<h5/>').text("Name Department").append($('<br/>'))
                .append($('<input type="text" name="name"/>')))
            .append($('<button class="waves-effect waves-light btn" onclick="saveDep()"/>').text("Add dep")))

        .appendTo(form);


}
function saveDep(department) {

    $.ajax({
        url: '/saveDepartment',
        type: 'POST',
        data: {department: department},
        success: function () {
            showListDepartments();
        }
    });
}
//function showListEmployee(id) {
//    $.getJSON('/listEmployee', function (emp) {
//        drawTableEmployee(emp)
//    });
//}
//
//function drawTableEmployee(emp) {
//    $('#test').children().detach();
//    var div = $('<div class="container"/>').appendTo($('#test'));
//
//    var h1 = $('<h1 class="card-panel teal lighten-2" align="center">List Employee</h1>').appendTo(div);
//    var table = $('<table class="striped"/>').appendTo(div)
//        .append($('<thead/>')
//            .append($('<tr/>')
//                .append($('<th/>').html('ID:'))
//                .append($('<th/>').html('Name:'))
//                .append($('<th/>').html('Email:'))
//                .append($('<th/>').html('Date:'))
//                .append($('<th/>').html('Salary:'))
//                .append($('<th/>').html('Department_id'))
//                .append($('<th/>').html('Edit:'))
//                .append($('<th/>').html('Delete:')))
//        );
//
//    for (var i = 0; i < emp.length; i++) {
//        var employee = emp[i];
//        $('<tr/>')
//            //
//            //.append($('<td>').text(employee.id))
//            //.append($('<td>').text(employee.name))
//            //.append($('<td>').text(employee.email))
//            //.append($('<td>').text(employee.date))
//            //.append($('<td>').text(employee.salary))
//            //.append($('<td>').text(employee.department_id))
//            //.append($('<td>')
//
//            //<a onclick='doalert(this);' href='#post-employee' title='http://localhost:7001/com.backbone.employee/api/emp/empUpdate/"+employee.EMPNO+"' class='btn btn-primary editBtn'>Edit</button>"+
//
//
//            //    .append($('<a href="/saveDepartment" onclick="addNewDepartments(' + department + ').submit();  return false;">Update</a>')))
//            //.append($('<td>')
//            //    .append($('<a href="/deleteDepartment" onclick="DeleteDepartment(' + department.id + ').submit();  return false;">Delete</a>')))
//            //.append($('<td>')
//            //    .append($('<a id="createNewButton" href="#popup" class="open-popup-link btn btn-primary" role="button">List</a>')))
//            //.appendTo(table);
//    }
//    //
//    //var div = $('<div/>').appendTo(div)
//    //    .append($('<a href="#!" class="btn waves-effect waves-red" onclick="addDepartment">add</a>'));
//
//    //$('<button class="btn waves-effect waves-red" onclick="addNewDepartments()"/>').text("+Add dep").appendTo(table);
//
//}