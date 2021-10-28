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
var errorUnidades;
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
  errorUnidades = document.getElementById('falta_unidades');
	imprimir = document.getElementById('imprimir');
	totalArticulos = document.getElementById('totalArticulos');
	totalPrecio = document.getElementById('totalPrecio');
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
	condiciones.addEventListener("click", aceptarCondiciones);
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
  } else if (isNaN(precioArticulo.value)){
		errorPrecio.textContent = "Tipo de dato incorrecto.";
		b = false
	} else
				b = true;
  //comprobar que las unidades del articulo es mayor que 0
  if (unidades.value <= 0) {
    errorUnidades.textContent = "Las unidades no pueden ser 0 o menor.";
    a = false; //ponemos 'a' falso para que no se añada al carrito
  }

  //Si el articulo, el precio y las unidades están bien añadimos
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

//Función que permite imprimir al aceptar condiciones
function aceptarCondiciones(){
	if (condiciones.checked == true){
		imprimir.disabled = false;
	}else{
		imprimir.disabled = true;
		}
}
//Función para imprimir compra, falta retocar cosas
function imprimirCompra(){
	var num=/^\d{9}$/;
	var codigoCvv=/^\d{3}$/;

	if(pago.value=="tarjeta"){
		if(titularTarjeta.value!="" && numeroTarjeta.value!="" && cvv.value!=""){
			if(!isNan(numeroTarjeta.value) && codigoCvv.test(cvv.value)){
				alert("procesando datos");
			}else{
				alert("datos incorrectos...");
			}
		}else if(pago.value=="efectivo"){
			if(importe.value!="" &&  !isNaN(importe.value)){
				alert("procesando datos");
			}else{
				alert("datos de importe efectivo incorrectos");
			}
		}else alert("seleccione un método de pago");
	}
}




function init(){
	initVariables();
	initEventos();
}
