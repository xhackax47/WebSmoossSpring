$(document).ready(function() {
    var myEventTable = [];

    myEventTable[0]                 = [];
    myEventTable[0]["name"]         = "Fiesta loca";
    myEventTable[0]["description"]  = "Une petite fiesta très simple avec pleins de musique de type Salsa !";
    myEventTable[0]["date"]         = "12/06/2018";
    myEventTable[0]["map"]          = "map_modal_event.png";
    
    myEventTable[1]                 = [];
    myEventTable[1]["name"]         = "Anniversaire Jean Bernard";
    myEventTable[1]["description"]  = "Jean Bernard à 50 ans, ça va être dingue !!!";
    myEventTable[1]["date"]         = "18/10/2018";
    myEventTable[1]["map"]          = "map_modal_event.png";
    
    myEventTable[2]                 = [];
    myEventTable[2]["name"]         = "Pot de départ";
    myEventTable[2]["description"]  = "Pot de départ de Jean Bernard, bah oui, on fête ton anniversaire et ton pot de départ !";
    myEventTable[2]["date"]         = "01/05/2018";
    myEventTable[2]["map"]          = "map_modal_event.png";

    myEventTable[3]                 = [];
    myEventTable[3]["name"]         = "Petit test";
    myEventTable[3]["description"]  = "Petit test de rien du tout mais sympatoche :D";
    myEventTable[3]["date"]         = "22/12/2018";
    myEventTable[3]["map"]          = "map_modal_event.png";

    for (var k in myEventTable) {
        createEventList(k, myEventTable[k]["name"], myEventTable[k]["description"], myEventTable[k]["date"], myEventTable[k]["map"]);
    }

    $('tr').on('click', function(){
        var idOfClickedTr       = $(this).attr('id');
        var titleEvent          = $(this).attr('data-title');
        var descriptionEvent    = $(this).attr('data-description');
        var dateEvent           = $(this).attr('data-date');
        var mapEvent            = $(this).attr('data-map');
        
        $('#modalInformationEvent').modal('show');

        $('#modal_title_event').text(titleEvent);
        $('#modal_description_event').text(descriptionEvent);
        $('#modal_date_event').text(dateEvent);
        $('#modal_map_event').html('<img src="img/' + mapEvent + '">');
    })

});


function createEventList(k, title, description, date, map) {

    var newTr, td, td1, td2;

    newTr = $('<tr></tr>').attr({   "class"             : "block_event_list",
                                    "id"                : 'block_event_list_id_'+k,
                                    "data-title"        : title,
                                    "data-description"  : description,
                                    "data-date"         : date,
                                    "data-map"          : map                });
        
    newTd = $('<td></td>').addClass("title_td").text(title);
    newTd1 = $('<td></td>').addClass("description_td").text(description);
    newTd2 = $('<td></td>').addClass("date_td").text(date);

    newTr.append(newTd, newTd1, newTd2).appendTo("#body_event_list");
}