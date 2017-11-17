$(document).ready(function() {
  $(".stat-page").hide();


  $.getJSON( "data/data.json", function( data ) {
    var totalCost = 0;
    var totalPrice = 0;
    for (var i = 0;i< data.length;i++) {
        var curr = data[i]
      console.log(curr);
      for (var j = 0; j < curr['Products'].length;j++) {
        var current = curr["Products"][j];
        var name = current["name"];
        var price = current["price"];
        var quantity = current["quantity"];
        totalCost += current["cost"];
      }
    }
  console.log(totalPrice - totalCost);

    $("#charts").tmpl(data)  //same but for top 100 chart
        .appendTo("#table");
      $('#tables').footable();
   });



});
/*  function getObj(result, search) { // manual search. currenly not being used
    for (x in result) {
      var obj;
      if (result[x]["name"] == search) {
        obj = result[x];
        //alert(result[x]["price_usd"]);
      }
    }
    return obj;
  }

  */

/*
 $(".stat-page").empty();
 $(".stat-page").hide(1000);
 var search = $("#input").val();
 var found = getObj(result, search);
   creates block for top 10 coins
  var stats = "<div class='stat-page'><h3>${rank}</h3><i class='cc ${symbol}'><h2>${name}</h2></i><h4>$${price_usd}</h4><br><h5>24h Change</h5><p class='change'> ${percent_change_24h}</p></div>";
  $.template("searched", stats);
  $.tmpl("searched", found)
    .appendTo(".stat-page");
*/

  /*
  var options = {  // used to autocomplete search feature. not currently being used
    url: "https://api.coinmarketcap.com/v1/ticker/",
    getValue: "name",

    list: {
      match: {
        enabled: true
      }
    }
  };
  $("#input").easyAutocomplete(options);
  */
