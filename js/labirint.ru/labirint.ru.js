/*
Скрипт для определения закупочной цены на сайте labirint.ru в личном кабинете.
*/
// цена на странице class = buying-priceold-val.
//
const upPriceRatio = 1.2;

$("[id_books]").each( function(i){
	const book_a = $(this);
	const book_href = book_a.attr("href");
	
	$.get("https://www.labirint.ru"+book_href, function( my_var ) {
		const price_element = $(my_var).find('.buying-priceold-val');
		//console.log($(my_var).find('.buying-priceold-val'));
		book_a.closest('td').after( price_element.wrap( "<td ></td>" ));
		
	});

	//console.log($(this).attr("href"));

}) 


///////////////////////////////////////////////////////////////////////

$("body").prepend($("<div id='mainDiv' style='font-size:20px;position:fixed;right:0px;top:0px; width:1000px;height:100%; background-color:white;z-index:2147483647;padding:10px;'></div>"));
$('#mainDiv').append("<input id='search_input' style='margin:10px;' value='978-5-462-01195-5'/> ");
$('#mainDiv').append("<table border=1 style='width:100%'>"+
   "<thead><tr><td>#</td><td>имя</td><td>сейчас</td><td>при заказе</td><td>закупка(*" + upPriceRatio + ")</td></tr></thead>"+
   "<tbody id='result'>  </tbody></table>");

$('#search_input').on('keyup', function (e) {
  if (e.keyCode !== 13) return;
  const query = $('#search_input').val();
  $('#search_input').select();
  console.log(query);
  $('#result').empty();
  $.get("https://www.labirint.ru/cabinet/?bookslist=1&txt="+query, function( my_var ) {
    $(my_var).find('#blo table tbody tr:has(a[id_books])').each( booksFunc );
  });
});

const booksFunc = function (i) {
  const that = $(this);
  const idBook = that.find("a[id_books]").first().attr('id_books');
  const orderUrl = that.find("a[href^='/cabinet/order/']").first().attr('href');
  $.get("https://www.labirint.ru"+orderUrl, function( my_var ) {
	$(my_var).find('tbody tr:has(a[id_books="'+idBook+'"])').each( function(){updatePrice($(this)); $(this).removeClass(); $('#result').append( $(this) ); bookPrice( $( this ) )});
  });
};

const updatePrice = function(that) {
  const td = that.find('td:nth-child(4)');
  const price = td.text();
  const price_by_procent = Math.floor(price * upPriceRatio);
  td.empty();
  td.append( $("<span>" + price + "</span> <span style='font-size:30px;color:#c33e1e;'>(" + price_by_procent + ")</span>") );
  
  that.find('td:nth-child(3)').before("<td></td>");
};

const bookPrice = function (thatTr){
  const book_href = thatTr.find("a[href^='/books/']").attr('href');
  console.log(book_href);
  $.get("https://www.labirint.ru"+book_href, function( my_var ) {
	const price = $(my_var).find('.buying-priceold-val').text().match(/\d+/);
	const img = $(my_var).find('#product-image img');
	thatTr.find('td:nth-child(3)').text( price);
	img.attr('height','120px');
	thatTr.find('td:nth-child(3)').append(img);
  });
};

$(document).keyup(function(e) {
     if (e.keyCode == 27) { // escape key maps to keycode `27`
        $('#search_input').focus();
		$('#search_input').val('');
    }
});
