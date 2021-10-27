
var nombreArticulo;
var precioArticulo;
var unidadesArticulo;
var anadirCarrito;
var formaPago;

var totalArticulos;
var totalPrecio;

var errorFaltaArticulo;
var errorFaltaPrecio;
var errorTipoIncorrecto;
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
//Inicialización de las variables
function initVariables(){
	nombreArticulo = document.getElementById('nombre');
	precioArticulo = document.getElementById('precio');
	unidadesArticulo = document.getElementById('unidades');
	anadirCarrito = document.getElementById('anadir');
	formaPago = document.getElementById('pago');
	errorFaltaArticulo = document.getElementById('falta_articulo');
	errorFaltaPrecio = document.getElementById('falta_precio');
	imprimir = document.getElementById('imprimir');
	totalArticulos = document.getElementById('totalArticulos');
	totalPrecio = document.getElementById('totalPrecio');	
	imprimir = document.getElementById('imprimir');	
	condiciones = document.getElementById('condiciones');	
	nombreArticulo.focus();
}
//Inicialización de los eventos
function initEventos(){
	anadirCarrito.addEventListener("click", anadir);
	imprimir.addEventListener("click", imprimirCompra);
	condiciones.addEventListener("input", aceptarCondiciones);
}

//Función para añadir al carrito
function anadir (){


	if (nombreArticulo.value == ""){
		errorFaltaArticulo.textContent = "Falta añadir artículo.";
		a = false;
	} else{
		a = true;

	}

	if (precioArticulo.value == ""){
		errorFaltaPrecio.textContent = "Falta añadir precio.";
		b = false;
		}else if (isNaN(precioArticulo)== false){
		errorTipoIncorrecto.textContent = "Tipo de dato incorrecto.";
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