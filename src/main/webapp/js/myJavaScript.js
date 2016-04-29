$(document).ready(function () {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/list",
        dataType: "json",
        timeout: 10000,
        data: "dep",
        success: function (dep) {
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
                        .append($('<a href="#!" onclick="popitup2()">Update</a> ')))
                    .append($('<td>')
                        .append($('<a href="/deleteDepartment?department_id=${dep.id}">Delete</button>')))
                    .append($('<td>')
                        .append($('<a href="/listEmployees?department_id=${dep.id}">List Employee</button>')))
                    .appendTo(table);
            }

            var div = $('<div/>').appendTo(div)
                .append($('<a href="#!" class="btn waves-effect waves-red" onclick="addDepartment">add</a>'));


        }

    })
});

function addDepartment() {
    var name = window.prompt("new Depertment", "name");
    if (name) {


    }
}

function deleteDepartment(){

}
function popitup2() {
    newwindow2 = window.open('', 'name', 'height=200,width=150');
    var tmp = newwindow2.document;
    tmp.write('<html><head><title>popup</title>');
    //tmp.write('<link rel="stylesheet" href="js.css">');
    tmp.write('</head><body><p>Delete?</p>');
    tmp.write('<p><a href="javascript:alert(self.location.href)">view location</a>.</p>');
    tmp.write('<p><a href="javascript:self.close()">close</a> the popup.</p>');
    tmp.write('</body></html>');
    tmp.close();
}
function popitup(url) {
    newwindow = window.open(url, 'name', 'height=200,width=150');
    if (window.focus) {
        newwindow.focus()
    }
    return false;
}