$(document).ready(function() {
  $(".stat-page").hide();


     $.getJSON( "data/Reports.json", function( data ) { //json request

     //console.log(data);
     var sales = getObjs("sales",data);
     console.log(sales);
     var avg = getObjs("average",data);
     var topFive = getObjs("topFive",data);
     console.log(topFive);
      var tendency = getObjs("tendency",data);
      console.log(tendency);
     var sug = getObjs("suggestions",data);
     console.log(sug);
     var employee = getObjs("employee",data);
     console.log(employee);

     var salesp = getObjs("salesp",data);
     console.log(salesp);
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
$( "#4" ).one("click",function() {
    $("#percent").tmpl(sales)  //table template
        .appendTo("#percentTable");
      $('#tables').footable();
});
$( "#5" ).one("click",function() {
    $("#pr").tmpl(salesp)  //table template
        .appendTo("#prTable");
      $('#tables').footable();
});
$( "#6" ).one("click",function() {
    $("#sug").tmpl(sug)  //table template
        .appendTo("#sugTable");
      $('#tables').footable();
});
$( "#7" ).one("click",function() {
    $("#ten").tmpl(tendency)  //table template
        .appendTo("#tenTable");
      $('#tables').footable();
});
$( "#8" ).one("click",function() {
    $("#employee").tmpl(employee)  //table template
        .appendTo("#employeeTable");
      $('#tables').footable();
});
$( "#9" ).one("click",function() {
    $("#topFive").tmpl(topFive)  //table template
        .appendTo("#topTable");
      $('#tables').footable();
});
$( "#10" ).one("click",function() {
    $("#avg").tmpl(avg)  //table template
        .appendTo("#avgTable");
      $('tables').footable();
});







      });
});

function extractArray(data, field) {
  var extracted = [data.length];
  for (var i = 0;i < data.length;i++) {
    extracted[i] = data[i][field];
  }
  return extracted;
}
function getObjs(title, data) { //couples reports by type
  var store = [];
  for (var i = 0;i <data.length;i++) {
    if (data[i]["title"] === title) {
      store.push(data[i]);
    }
  }
  return store;
}
