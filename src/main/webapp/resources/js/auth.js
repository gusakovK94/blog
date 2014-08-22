$(document).ready(function() {
    $(".login").submit(function(e) {
        e.preventDefault();

        var method = $(this).attr("method");
        var action = $(this).attr("action");
        var data = $(this).serialize();

        $.ajax({
            type: method,
            url: action,
            data: data,
            success: function(result) {
                if (result === true) {
                    window.location.href = "/admin";
                } else {
                    $(".alert").show("slow");
                }
            }
        })
    })
});