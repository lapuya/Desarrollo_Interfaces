//Inicialización de las variables

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

var pago;
var titularTarjeta;
var numeroTarjeta;
var cvv;
var importeEfectivo;

                                                                                                                                                                                                                                                                                                                                                                                                                                                         
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
	
	pago = document.getElementById('pago');
	titularTarjeta = document.getElementById('titularTarjeta');
	numeroTarjeta = document.getElementById('numeroTarjeta');
	cvv = document.getElementById('cvv');
	importeEfectivo = document.getElementById('importeEfectivo');
	capaTarjeta.style.display = "none";
	capaEfectivo.style.display = "none";

}
 
function initEventos(){
	anadirCarrito.addEventListener("click", añadir);
	imprimir.addEventListener("click", imprimirCompra);
	condiciones.addEventListener("input", aceptarCondiciones);
	pago.addEventListener("change", cargarPago);
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
		totalArticulos.textContent = articulos + "";
 
		
		precioTotal += (parseFloat(precioArticulo.value) * parseFloat(unidadesArticulo.value));
		totalPrecio.textContent = precioTotal;
	}
 
 
	nombreArticulo.value = ("");
	precioArticulo.value = ("");
 
}
//Función para proceder al pago
function cargarPago(){
	if(pago.value == "seleccione"){
		capaTarjeta.style.display="none";
		capaEfectivo.style.display="none";
	}else if(pago.value == "tarjeta") {
		capaTarjeta.style.display="block";
		capaEfectivo.style.display="none";
	}else{
		capaTarjeta.style.display="none";
		capaEfectivo.style.display="block";
	}	
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