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

function DeleteDepartment(id) {
    $.ajax({
        url: '/deleteDepartment',
        type: 'POST',
        //dataType: 'json',
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

function addNewDepartments(dep) {
    $('#test').children().detach();

    var div = $('<div class="container"/>').appendTo($('#test'));

    var form = $('<form id = "depForm" method="POST" name ="saveDepartment"/>').appendTo(div);

    $('<h1 class="card-panel teal lighten-2" align="center"/>').text("New Department").appendTo(form);
    $('<div class="row"/>')
        .append($('<div class="col s4 offset-s4"/>')
            .append($('<input type="hidden" id="id"/>').val(dep != null ? dep : "")).append($('<br/>'))
            .append($('<h5/>').text("Name Department").append($('<br/>'))
                .append($('<input type="text" id="name" class="validate"/>')))
            //.append($('<span id="valid"></span>')))
            .append($('<input type="submit"  class="btn waves-effect waves-red"/>')))
        .appendTo(form);
    //validateDepartment();
}

function saveDep(dep) {
    var dep = {};
    dep["id"] = $('#id').val();
    dep["name"] = $('#name').val();

    $.ajax({
        url: '/saveDepartment',
        type: 'POST',
        dataType: 'json',
        data: {id: dep["id"], n: dep["name"]},
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
            drawTableEmployee(data, id);
        }
    });
}

function drawTableEmployee(data, id) {
    $('#test').children().detach();

    var div = $('<div class="container"/>').appendTo($('#test'));

    var h1 = $('<h1 class="card-panel teal lighten-2" align="center">List Employee</h1>').appendTo(div);
    var h3 = $('<h3  align="center">Department:  </h3>').text(id).appendTo(div);


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
    for (var i = 0; i < data.length; i++) {
        var employee = data[i];

        $('<tr/>').append($('<td>').text(employee.id))
            .append($('<td>').text(employee.name))
            .append($('<td>').text(employee.email))
            .append($('<td>').text(employee.date))
            .append($('<td>').text(employee.salary))
            .append($('<td>').text(employee.department_id))
            .append($('<td>')
                .append($('<button class="btn-flat disabled" onclick="addNewEmployee(' + employee.id + ', ' + employee.department_id + ')"/>').text("Edit")))
            .append($('<td>')
                .append($('<button class="btn-flat disabled" onclick="DeleteEmployee(' + employee.id + ')"/>').text("Delete")))

            .appendTo(table);
    }
    var idEmp = null;
    $('<button class="btn waves-effect waves-red" onclick="addNewEmployee(' + idEmp + ' ,' + id + ')"/>').text("AddEmployee").appendTo(div);

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

function addNewEmployee(id, depID) {


    $('#test').children().detach();
    var div = $('<div class="container"/>').appendTo($('#test'));

    var form = $('<form id = "employee" method="POST" name ="saveEmployee"/>').appendTo(div);

    $('<h1 class="card-panel teal lighten-2" align="center"/>').text("New Employee").appendTo(form);
    $('<div class="row"/>')
        .append($('<div class="col s4 offset-s4"/>')
            .append($('<input type="hidden" id="id" name="id"/>').val(id)).append($('<br/>'))
            .append($('<h5/>').text("Name Employee").append($('<br/>'))
                .append($('<input type="text" id="name"/>')))
            .append($('<h5/>').text("email").append($('<br/>'))
                .append($('<input type="email" id="email" class="validate">/>'))
                .append($('<label for="email">Email</label>')))
            .append($('<h5 />').text("date").append($('<br/>'))
                .append($('<input type="date" id="date"/>')))
            .append($('<h5/>').text("salary").append($('<br/>'))
                .append($('<input type="text" id="salary"/>')))
            .append($('<input type="hidden" id="department_id" name="department_id"/>').val(depID)).append($('<br/>'))

            .append($('<button class="waves-effect waves-light btn" onclick="saveEmp()"/>').text("Add Employee")))
        .appendTo(form);


}

function saveEmp(data) {
    var data = {};
    data["department_id"] = $('#department_id').val();
    var id = $('#id').val();
    var name = $('#name').val();
    var email = $('#email').val();
    var date = $('#date').val();
    var salary = $('#salary').val();
    var dep = {id: data["department_id"]};
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
            department_id: data["department_id"]
        },
        success: function () {
            showListEmployee(dep);
        }
    });
}

function validateDepartment() {

    $('#depForm').validate({
        rules: {
            name: {
                required: true,
                minlength: 2,
                maxlength: 20
            }
        },
        messages: {
            name: {
                name: "Please enter your name",
                required: "*"
            }
        },
        submitHandler: function () {
            saveDep()
        }
    });


    //$(document).ready(function () {
    //    $('#name').blur(function () {
    //        if ($(this).val() != '') {
    //
    //            if (pattern.test($(this).val())) {
    //                $(this).css({'border': '1px solid #569b44'});
    //                $('#valid').text('Верно');
    //            } else {
    //                $(this).css({'border': '1px solid #ff0000'});
    //                $('#valid').text('Не верно');
    //            }
    //        } else {
    //            // Поле email пустое, выводим предупреждающее сообщение
    //            $(this).css({'border': '1px solid #ff0000'});
    //            $('#valid').text('Поле email не должно быть пустым');
    //        }
    //    });
    //});
}

function emplFormValidate() {
    $('#empForm').validate({
        rules: {
            name: {
                required: true,
                minlength: 2,
                maxlength: 16
            },
            email: {
                required: true,
                email: true,
                remote: {
                    url: "/unicEmplEmail",
                    type: "post",
                    data: {
                        id: function () {
                            return $("#id").val();
                        }
                    }
                }
            },
            salary: {
                //required: true,
                //digits: true,
            },
            date: {
                //required: true,
            }
        },
        submitHandler: function () {
            saveDep()
        }
    });
}