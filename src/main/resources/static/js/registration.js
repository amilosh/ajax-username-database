function myFunction() {
    var x = document.getElementById("username").value;
    document.getElementById("demo").innerHTML = x;

    // PREPARE FORM DATA
    var formData = {
        username : $("#username").val()
    }

    // DO POST
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : window.location + "getResponse",
        data : JSON.stringify(formData),
        dataType : 'json',
        success : function(result) {
            if(result.data == "true") {
                $("#postResultDiv").html("<i class='glyphicon glyphicon-remove' aria-hidden='true' style='color: #FF0000; margin-left: 10px'></i>");
            } else if(result.data == "false") {
                $("#postResultDiv").html("<i class='glyphicon glyphicon-ok' aria-hidden='true' style='color: #00FF7F; margin-left: 10px'></i>");
            }

            console.log(result);
        },
        error : function(e) {
            alert("Error!")
            console.log("ERROR: ", e);
        }
    });

}