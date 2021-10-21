
var nombreArticulo;
var precioArticulo;
var unidadesArticulo;
var anadirCarrito;
var formaPago;

var totalArticulos;
var totalPrecio;

var errorArticulo;
var precioNumerico;
var errorPrecio = /^\d+$/;

var imprimir;
var articulos = [];
var preioTotal;
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
	nombreArticulo.focus();
}

function initEventos(){
	anadirCarrito.addEventListener("click", añadir);
	imprimir.addEventListener("click", imprimirCompra);
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
	}else if (errorPrecio.test(precioArticulo)){
		errorPrecio.textContent = "Tipo de dato incorrecto.";
		b = false
		}else {
			b = true;
		} 



	if (a && b) {
		articulos.push(nombreArticulo.value);
		totalArticulos.textContent =  articulos + " ";

		preioTotal += precioArticulo;
		totalPrecio.textContent = precioTotal;

	} else{}


	nombreArticulo.value = ("");
	precioArticulo.value = ("");
	
}




function init(){
	initVariables();
	initEventos();
}