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
                .append($('<button class="btn-flat disabled" onclick="addNewDepartments(' + department.id + ')"/>').text("Edit")))
            .append($('<td>')
                .append($('<button class="btn-flat disabled" onclick="DeleteDepartment(' + department.id + ')"/>').text("Delete")))
            .append($('<td>')
                .append($('<button class="btn-flat disabled" onclick="showListEmployee(' + department.id + ')"/>').text("List"))).appendTo(table);
        //.append($('<a href="/listEmployees" onclick="showListEmployee('+department.id+').submit();  return false;">List</a>')))
        //.appendTo(table);    <a class="btn-flat disabled">Button</a>
    }

    $('<button class="btn waves-effect waves-red" onclick="addNewDepartments()"/>').text("AddDepartment").appendTo(div);

}

function DeleteDepartment() {
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

    $.ajax({
        url: '/listEmployees',
        type: 'GET',
        dataType: 'json',
        data: {id: id},
        success: function (data) {
            drawTableEmployee(data);
        }
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
        var department = emp[i];
        $('<tr/>').append($('<td>').text(department.id))
            .append($('<td>').text(department.name))
            .append($('<td>').text(department.email))
            .append($('<td>').text(department.date))
            .append($('<td>').text(department.salary))
            .append($('<td>').text(department.department_id))
            .append($('<td>')
                .append($('<button class="btn-flat disabled" onclick="addNewEmployee('+department.id+')"/>').text("Edit")))
            .append($('<td>')
                .append($('<button class="btn-flat disabled" onclick="DeleteEmployee(' + department.id + ')"/>').text("Delete")))

            .appendTo(table);
    }

    $('<button class="btn waves-effect waves-red" onclick="addNewEmployee(' + department.department_id + ')"/>').text("AddEmployee").appendTo(div);

}

function DeleteEmployee(id) {
    $.ajax({
        url: '/deleteEmployee',
        type: 'POST',
        dataType: 'json',
        data: {id: id},
        success: function () {
            showListEmployee();
        }
    })
}

function addNewEmployee(employee) {


    $('#test').children().detach();

    var div = $('<div class="container"/>').appendTo($('#test'));

    var form = $('<form id = "employee" method="POST" name ="saveEmployee"/>').appendTo(div);

    $('<h1 class="card-panel teal lighten-2" align="center"/>').text("New Employee").appendTo(form);
    $('<div class="row"/>')
        .append($('<div class="col s4 offset-s4"/>')
            .append($('<input type="hidden" id="id"/>').val(employee.id)).append($('<br/>'))
            .append($('<h5/>').text("Name Employee").append($('<br/>'))
                .append($('<input type="text" id="name"/>').val(employee.name)))
            .append($('<h5/>').text("email").append($('<br/>'))
                .append($('<input type="text" id="email"/>').val(employee.email)))
            .append($('<h5/>').text("date").append($('<br/>'))
                .append($('<input type="date" id="date"/>').val(employee.date)))
            .append($('<h5/>').text("salary").append($('<br/>'))
                .append($('<input type="text" id="salary"/>').val(employee.salary)))
            .append($('<input type="hidden" id="department_id"/>').val(employee.department_id)).append($('<br/>'))

            .append($('<button class="waves-effect waves-light btn" onclick="saveEmp()"/>').text("Add Employee")))
        .appendTo(form);
}

function saveEmp() {
    var id = $('#id').val();
    var name = $('#name').val();
    var email = $('#email').val();
    var date = $('#date').val();
    var salary = $('#salary').val();
    var department_id = $('#department_id').val();
    var dep = {id: department_id};
    $.ajax({
        url: '/saveEmployee',
        type: 'POST',
        dataType: 'json',
        data: {
            id: id,
            name: name,
            email: email,
            date: date,
            salary: salary,
            department_id: department_id
        },
        success: function () {
            showListEmployee(dep);
        }
    });
}