
var nombreArticulo;
var precioArticulo;
var unidadesArticulo;
var anadirCarrito;
var formaPago;

var totalArticulos;
var totalPrecio;

var errorArticulo;
var errorPrecio;
var precioNumerico = /^\d+$/;

var condiciones;
var imprimir;
var articulos = [];
var precioTotal = 0;
var a;
var b;

window.onload = function (){
	init();


	

	
}

function initVariables(){
	nombreArticulo = document.getElementById('nombre');
	precioArticulo = document.getElementById('precio');
	unidadesArticulo = document.getElementById('unidades');
	anadirCarrito = document.getElementById('anadir');
	formaPago = document.getElementById('pago');
	errorArticulo = document.getElementById('falta_articulo');
	errorPrecio = document.getElementById('falta_precio');
	imprimir = document.getElementById('imprimir');
	totalArticulos = document.getElementById('totalArticulos');
	totalPrecio = document.getElementById('totalPrecio');	
	imprimir = document.getElementById('imprimir');	
	condiciones = document.getElementById('condiciones');	
	nombreArticulo.focus();
}

function initEventos(){
	anadirCarrito.addEventListener("click", añadir);
	imprimir.addEventListener("click", imprimirCompra);
	condiciones.addEventListener("input", aceptarCondiciones);
}


function añadir (){


	if (nombreArticulo.value == ""){
		errorArticulo.textContent = "Falta añadir artículo.";
		a = false;
	} else{
		a = true;

	}

	if (precioArticulo.value == ""){
		errorPrecio.textContent = "Falta añadir precio.";
		b = false;
		}else if (false /* FALTA COMPROBAR QUE EL DATO SEA UN NÚMERO!typeof precioArticulo.value === 'number'*/ ){
		errorPrecio.textContent = "Tipo de dato incorrecto.";
		b = false
			}else {
				b = true;
			} 


	if (a && b) {
		articulos.push(nombreArticulo.value);
		totalArticulos.textContent =  articulos + " ";

		//NO ME SUMA LOS PRECIOS...
		precioTotal = (precioTotal + precioArticulo.value);
		totalPrecio.textContent = precioTotal;
	}


	nombreArticulo.value = ("");
	precioArticulo.value = ("");
	
}

//NO FUNCIONAA
function aceptarCondiciones(){
	if (condiciones.value == Y){
		imprimir.disabled = false;
	}else{
		imprimir.disabled = true;
		}
}

function imprimirCompra(){

}




function init(){
	initVariables();
	initEventos();
}