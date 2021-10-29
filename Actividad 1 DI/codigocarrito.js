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
var articulos = "";
var precioTotal = 0;

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
	condiciones.addEventListener("click", aceptarCondiciones);
	pago.addEventListener("change", cargarPago);
	imprimir.addEventListener("click", imprimirCompra);
}

//funcion para comprobar si se ha añadido un articulos
function checkNombre()
{
  if (nombreArticulo.value == ""){
  		errorArticulo.textContent = "Falta añadir artículo.";
      return false;
    } else {
      return true;
    }
}

//funcion para comprobar si se ha añadido un precio o si es un numero
function checkPrecio()
{
  if (precioArticulo.value == ""){
		errorPrecio.textContent = "Falta añadir precio.";
		return false;
  } else if (isNaN(precioArticulo.value)){
		errorPrecio.textContent = "Tipo de dato incorrecto.";
		return false
	} else
    return true;
}

//funcion para comprobar el numero de unidades introducidas
function checkUnidades()
{
  if (unidades.value <= 0) {
    errorUnidades.textContent = "Las unidades no pueden ser 0 o menor.";
    return false;
  } else
    return true;
}

//funcion para limpair los campos de
function limpiarErrores()
{
	errorPrecio.textContent = "";
	errorArticulo.textContent = "";
}

//limpia los campos despues de añadir articulos
function limpiarCampos()
{
	nombreArticulo.value = ("");
	precioArticulo.value = ("");
}

//añadir aticulos en el carrito
function añadir (){
  if (checkNombre() && checkPrecio() && checkUnidades())
  {
		//poner comas justo depues del primer articulo
		if (articulos.length > 0)
			articulos += ", ";
    articulos += nombreArticulo.value;
    totalArticulos.value = articulos + "";

    precioTotal += (parseFloat(precioArticulo.value) * parseFloat(unidadesArticulo.value));
    totalPrecio.value = precioTotal;

    //si tuvieramos algun error, limpiarlo en el proximo intento
		limpiarErrores();
  }
	limpiarCampos();
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

//funcion auxiliar que comprueba si un string esta vacio o nulo
function isEmpty(str)
{
	return (!str || str.length == 0 );
}

//función que servira para imprimir todo despues del pago
function imprimirTodo()
{
	return ("Los articulos son: " + totalArticulos.value +
	"\nEl precio total es: " + totalPrecio.value +
	"\nForma de pago es: " + pago.value);
}

//funcion que se activa al pagar con tarjeta
function pagoConTarjeta()
{
	var codigoCvv=/^\d{3}$/;

	//comprobamos si algun campo esta vacio
	if(!isEmpty(titularTarjeta.value) && !isEmpty(numeroTarjeta.value) && !isEmpty(cvv.value)){
		if(!isNaN(numeroTarjeta.value) && codigoCvv.test(cvv.value)) //que sean numeros y 3 numeros de cvv
			alert(imprimirTodo());
		else
			alert("datos incorrectos...");
	}else
		alert("faltan datos");
}

//funcion que se activa al pagar con efectivo
function pagoConEfectivo()
{
	if(importe.value!="" &&  !isNaN(importe.value))
		alert(imprimirTodo());
	else
		alert("datos de importe efectivo incorrectos");
}
//Función para imprimir compra
function imprimirCompra(){
	if(pago.value=="tarjeta"){
		pagoConTarjeta();
	}else if(pago.value=="efectivo"){
		pagoConEfectivo
	}else alert("seleccione un método de pago");
}

function init(){
	initVariables();
	initEventos();
}