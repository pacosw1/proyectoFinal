$(document).ready(function() {
  $(".stat-page").hide();

  function percentColor(x) {          //changes color of percentage change
    x.each(function() {
      var curr = $(this).text();
      if (curr.includes("-")) {
        $(this).css("color", "red");
      } else {
        $(this).css("color", "green");
      }
  });
}
  $.getJSON("https://api.coinmarketcap.com/v1/ticker/", function(result) { //gets object array

    result1 = result.slice(0, 10); //top 10 list
    var result100 = result.slice(0, 100);
    var coins = "<div class='home-screen'><h2>${rank}</h2><i class='cc ${symbol}'><h2>${symbol}</h2></i><h4>$${price_usd}</h4></div>";
    $.template("coins", coins); //sets top 10 template
    $.tmpl("coins", result1)
      .appendTo(".results"); //adds it to results div

    //initialized table template loop
    $("#charts").tmpl(result100)  //same but for top 100 chart
      .appendTo("#table");
    $('#tables').footable();
    var change = $(".change");
    var change1 = $(".change1");
    var change7 = $(".change7");
    percentColor(change);
    percentColor(change1);
    percentColor(change7);

    });
  });
//under development

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
