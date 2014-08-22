$(document).ready(function() {
    $("#photo").change(function() {
        var input = $(this)[0];
        if (input.files && input.files[0]) {
            if (input.files[0].type.match('image.*')) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    $('#image_preview').attr('src', e.target.result);
                };
                reader.readAsDataURL(input.files[0]);
            } else {
                console.log('is not image mime type');
            }
        } else {
            console.log('not isset files data or files API not supported');
        }
    });

    $("ul").on("click", "li", function(event) {
        event.stopPropagation();
    });

    $(".save").click(function() {
        $(this).dropdown("toggle");
        var parentUl = $(this).parent().parent();
        var childrenDiv = parentUl.children("div");
        var tags = childrenDiv.find("li").find("input[type=checkbox]:checked");
        for (var i = 0;i < tags.length;i++) {
            var tagName = tags.get(i).nextSibling.innerHTML;
            parentUl.parent().parent().find(".tags").append("<a class='tag'><span>"+tagName+"</span></a>");
            tags.get(i).parentNode.parentNode.removeChild(tags.get(i).parentNode);
        }
    });

    $(".delete").click(function() {
        if ($(this).hasClass('active')) {
            $(this).removeClass('active');
        } else {
            $(this).addClass('active');
        }
    });

    $(".tags").on("click", "a", function() {
        if ($(".delete").hasClass('active')) {
            var mainDiv = $(this).parent().parent().find(".list-tags");
            //var mainDiv = $(this).parents().find(".col-lg-8").find(".list-tags");
            mainDiv.append("<li><input type='checkbox'><a class='tag'>"+$(this).get(0).innerHTML+"</a></li>");
            $(this).hide("slow");
        }
    });

    $(".clear").click(function() {
        //tinyMCE.triggerSave(false, true);
        var tinyMCEId = "post-text";
        tinyMCE.get(tinyMCEId).setContent('');
    });

    $(".save-post").click(function() {
        $("#myModal").modal("toggle");
    });

    $(".edit").click(function() {
        $(this).parent().parent().hide("slow");
        var mainBlock = $(this).parent().parent().parent();
        mainBlock.find(".post-edit").show();
    });

    $(".save-edit").click(function() {
        $(this).parent().parent().hide("slow");
        $(this).parent().parent().parent().find(".post-block").show("slow");
    });

    $(".cancel-edit").click(function() {
        $(this).parent().parent().hide("slow");
        $(this).parent().parent().parent().find(".post-block").show("slow");
    });

    $(".remove").click(function() {
        $(this).parent().parent().parent().hide("slow");
    })

    /*$(".tag").click(function() {
     if ($(".delete").hasClass('active')) {
     alert("A");
     }
     });*/

    /*$(".edit").click(function() {
     $(this).parent().parent().hide("slow");
     var mainBlock = $(this).parents().find('.well');
     mainBlock.find(".post-edit").show();
     });

     $('li').click(function(event){
     event.stopPropagation();
     });

     $(".save").click(function() {
     $(".dropdown-menu").dropdown("toggle");

     });

     $("#delete").click(function() {
     if ($(this).hasClass('active')) {
     $(this).removeClass('active');
     } else {
     $(this).addClass('active');
     }
     });

     $(".tags").click(function() {
     if ($("#delete").hasClass('active')) {
     $(this).hide("slow");
     }
     });*/
});