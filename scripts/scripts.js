$(document).ready(function() {
  $(".stat-page").hide();


     $.getJSON( "data/Reports.json", function( data ) { //json request

     //console.log(data);
     var reorder = getObjs("inventory",data);
     console.log(reorder);
     var time = getObjs("time",data);
     console.log(time);
     var trans = getObjs("transactions",data);
     console.log(trans);
     $( "#1" ).one("click",function() {
       $("#trans").tmpl(trans)
           .appendTo("#table");
         $('#tables').footable();
});
$( "#2" ).one("click",function() {
  $("#times").tmpl(time)  //table template
      .appendTo("#table1");
    $('#tables').footable();
});
$( "#3" ).one("click",function() {
  $("#inventory").tmpl(reorder)  //table template
      .appendTo("#table2");
    $('#tables').footable();
});







      });
});


function getObjs(title, data) { //couples reports by type
  var store = [];
  for (var i = 0;i <data.length;i++) {
    if (data[i]["title"] === title) {
      store.push(data[i]);
    }
  }
  return store;
}
