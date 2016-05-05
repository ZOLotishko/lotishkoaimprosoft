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
                .append($('<a href="/saveDepartment" onclick="addNewDepartments(' + department.id + ').submit();  return false;">Update</a>')))
            .append($('<td>')
                .append($('<a href="/deleteDepartment" onclick="DeleteDepartment(' + department.id + ').submit();  return false;">Delete</a>')))
            .append($('<td>')
                .append($('<button class="btn waves-effect waves-red" onclick="showListEmployee(' + department.id + ')"/>').text("List")).appendTo(table))
                //.append($('<a href="/listEmployees" onclick="showListEmployee(' + department.id + ').submit();  return false;">List</a>')))
            .appendTo(table);
    }

    $('<button class="btn waves-effect waves-red" onclick="addNewDepartments()"/>').text("AddDepartment").appendTo(table);

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

function showListDepartments() {
    $.getJSON('/list', function (dep) {
        drawTableDepartment(dep);
    });
}

function addNewDepartments() {
    $('#test').children().detach();

    var div = $('<div class="container"/>').appendTo($('#test'));

    var form = $('<form id = "department" method="POST" name ="saveDepartment"/>').appendTo(div);

    $('<h1 class="card-panel teal lighten-2" align="center"/>').text("New Department").appendTo(form);
    $('<div class="row"/>')
        .append($('<div class="col s4 offset-s4"/>')
            .append($('<input type="hidden" id="id"/>')).append($('<br/>'))
            .append($('<h5/>').text("Name Department").append($('<br/>'))
                .append($('<input type="text" id="name"/>')))
            .append($('<button class="waves-effect waves-light btn" onclick="saveDep()"/>').text("Add dep")))
        .appendTo(form);
}

function saveDep(department) {
    var department = {};
    department["id"] = $('#id').val();
    department["name"] = $('#name').val();


    $.ajax({
        url: '/saveDepartment',
        type: 'POST',
        dataType: 'json',
        data: {id: department["id"], n: department["name"]},
        success: function () {
            showListDepartments();
        }
    });
}
function showListEmployee(id) {
    $.getJSON('/listEmployees', function (emp) {
        drawTableEmployee(emp)
    });
}

function drawTableEmployee(emp) {
    $('#test').children().detach();
    var div = $('<div class="container"/>').appendTo($('#test'));

    var h1 = $('<h1 class="card-panel teal lighten-2" align="center">List Employee</h1>').appendTo(div);
    var table = $('<table class="striped"/>').appendTo(div)
        .append($('<thead/>')
            .append($('<tr/>')
                .append($('<th/>').html('ID:'))
                .append($('<th/>').html('Name:'))
                .append($('<th/>').html('Email:'))
                .append($('<th/>').html('Date:'))
                .append($('<th/>').html('Salary:'))
                .append($('<th/>').html('Department_id'))
                .append($('<th/>').html('Edit:'))
                .append($('<th/>').html('Delete:')))
        );

    for (var i = 0; i < emp.length; i++) {
        var employee = emp[i];
        $('<tr/>')
            .append($('<td>').text(employee.id))
            .append($('<td>').text(employee.name))
            .append($('<td>').text(employee.email))
            .append($('<td>').text(employee.date))
            .append($('<td>').text(employee.salary))
            .append($('<td>').text(employee.department_id))
            .append($('<td>').appendTo(table));

            //<a onclick='doalert(this);' href='#post-employee' title='http://localhost:7001/com.backbone.employee/api/emp/empUpdate/"+employee.EMPNO+"' class='btn btn-primary editBtn'>Edit</button>"+


            //    .append($('<a href="/saveDepartment" onclick="addNewDepartments(' + department + ').submit();  return false;">Update</a>')))
            //.append($('<td>')
            //    .append($('<a href="/deleteDepartment" onclick="DeleteDepartment(' + department.id + ').submit();  return false;">Delete</a>')))
            //.append($('<td>');
    }

    var div = $('<div/>').appendTo(div)
        .append($('<a href="#!" class="btn waves-effect waves-red" onclick="addEmployee">add</a>'));

    $('<button class="btn waves-effect waves-red" onclick="addNewDepartments()"/>').text("AddEmployee").appendTo(table);

}