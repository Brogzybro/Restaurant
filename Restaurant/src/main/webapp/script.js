/**
 * Created by BrageHalse on 26.09.2017.
 */
$document.ready(function(){
    $("#regBord").click(function () {
        $ajax({
            url: "rest/resBord",
            type: 'POST',
            data: $("#regBordInp").val(),
            contentType: 'text/plain'
        });
    });
   function update () {
       $.get("rest/resBord", function (data) {
            $("#toString").html(data);
       });
   }
   window.setInterval(update, 1000);
});

