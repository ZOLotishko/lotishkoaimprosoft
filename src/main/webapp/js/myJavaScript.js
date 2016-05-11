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

    var form = $('<form id = "departmentForm" method="POST" name ="saveDepartment"/>').appendTo(div);

    $('<h1 class="card-panel teal lighten-2" align="center"/>').text("New Department").appendTo(form);
    $('<div class="row"/>')
        .append($('<div class="col s4 offset-s4"/>')
            .append($('<input type="hidden" id="id"/>').val(dep != null ? dep : "")).append($('<br/>'))
            .append($('<h5/>').text("Name Department").append($('<br/>'))
                .append($('<input type="text" id="name" name="name" class="validate"  />')))

            .append($('<button  class="btn waves-effect waves-red"/>').on('click', saveDep).text("add department")))
        .appendTo(form);
}

function saveDep(dep) {

    $('#departmentForm').validate({
        rules: {
            name: {
                required: true,
                minlength: 5,
                maxlength: 10,
                remote: {
                    url: "/uniqueName",
                    type: "post",
                    data: {
                        id: function () {
                            return $("#id").val();
                        }
                    }
                }
            }
        },
        messages: {
            name: {
                name: "Please enter your name",
                required: "error",
                remote: "This username is already taken! Try another."
            }
        },
        submitHandler: function () {
            var dep = {};
            dep["id"] = $('#id').val();
            dep["name"] = $('#name').val();
            $.ajax({
                url: '/saveDepartment',
                type: 'POST',
                //dataType: 'json',
                data: {id: dep["id"], n: dep["name"]},
                success: function () {
                    showListDepartments(dep);
                }
            });
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
                .append($('<button class="btn-flat disabled" onclick="DeleteEmployee(' + employee.id + ', ' + id + ')"/>').text("Delete")))

            .appendTo(table);
    }
    var idEmp = null;
    $('<button class="btn waves-effect waves-red" onclick="addNewEmployee(' + idEmp + ' ,' + id + ')"/>').text("AddEmployee").appendTo(div);

}

function DeleteEmployee(id, depId) {
    $.ajax({
        url: '/deleteEmployee',
        type: 'POST',
        //dataType: 'json',
        data: {id: id},
        success: function () {
            showListEmployee(depId);
        }
    })
}

function addNewEmployee(id, depID) {


    $('#test').children().detach();
    var div = $('<div class="container"/>').appendTo($('#test'));

    var form = $('<form id = "employeeForm" method="POST" name ="saveEmployee"/>').appendTo(div);

    $('<h1 class="card-panel teal lighten-2" align="center"/>').text("New Employee").appendTo(form);
    $('<div class="row"/>')
        .append($('<div class="col s4 offset-s4"/>')
            .append($('<input type="hidden" id="id" name="id"/>').val(id)).append($('<br/>'))
            .append($('<h5/>').text("Name Employee").append($('<br/>'))
                .append($('<input type="text" id="name" name="name" class="validate"/>')))
            .append($('<h5/>').text("email").append($('<br/>'))
                .append($('<input type="text" id="email" name="email" class="validate" />')))
            //.append($('<label for="email">Email</label>')))
            .append($('<h5 />').text("date").append($('<br/>'))
                .append($('<input type="date" id="date" name="date" class="validate"/>')))
            .append($('<h5/>').text("salary").append($('<br/>'))
                .append($('<input type="text" id="salary" name="salary" class="validate"/>')))
            .append($('<input type="hidden" id="department_id" name="department_id"/>').val(depID)).append($('<br/>'))

            .append($('<button class="waves-effect waves-light btn"/>').on('click', saveEmp).text("Add Employee")))
        .appendTo(form);


}

function saveEmp(data) {

    $('#employeeForm').validate({
        rules: {
            name: {
                required: true,
                minlength: 5,
                maxlength: 20
            },
            email: {
                required: true,
                email: {
                  email: function(){
                      check($("#email"));
                  }
                },
                remote: {
                    url: "/uniqueEmail",
                    type: "post",
                    data: {
                        id: function () {
                            return $("#id").val();
                        }
                    }
                }
            },

            date: {
                required: true
            },
            salary: {
                required: true
            },
        },
        messages: {
            name: {
                name: "Please enter your name",
                required: "error"
            },
            email: {
                email: "Please enter your name",
                required: "error",
                remote: "This email is already taken! Try another.",
                email: "Your email address must be in the format of name@domain.com"
            },
            date: {
                required: "error"
            },
            salary: {
                required: "error"
            }

        },
        submitHandler: function () {
            var data = {};
            data["department_id"] = $('#department_id').val();
            var id = $('#id').val();
            var name = $('#name').val();
            var email = $('#email').val();
            var date = $('#date').val();
            var salary = $('#salary').val();
            //var dep = {id: data["department_id"]};
            $.ajax({
                url: '/saveEmployee',
                type: 'POST',
                //dataType: 'json',
                data: {
                    id: id,
                    name: name,
                    email: email,
                    date: date,
                    salary: salary,
                    department_id: data["department_id"]
                },
                success: function () {
                    showListEmployee(data["department_id"]);
                }
            });
        }
    });
}
function check(email){
    return ("^(\S+)@([a-z0-9-]+)(\.)([a-z]{2,4})(\.?)([a-z]{0,4})+$").test(email);
}