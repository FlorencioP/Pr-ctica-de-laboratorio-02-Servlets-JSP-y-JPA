function eliminarDET (idPed,idCab) {
	
	 if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari 
            xmlhttp = new XMLHttpRequest();
        } else { // code for IE6, IE5 
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue");
                document.getElementById('btnCrear').style.display = 'none'; 
                document.getElementById("pantalla").innerHTML = this.responseText;
            }
        };

        xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/EliminarDet?idDet="+idPed+"&idCab="+idCab, true);
        xmlhttp.send();
	

    return false;

}



var lisPedido="";

function recogerDat(nodo){

        var nodoTd = nodo.parentNode; //Nodo TD

        var nodoTr = nodoTd.parentNode; //Nodo TR

        var nodosEnTr = nodoTr.getElementsByTagName('td');

        var nombre = nodosEnTr[0].textContent; 

        var precio = nodosEnTr[1].textContent; 

        var descripcion  = nodosEnTr[2].textContent; 
        
        var cantidad = nodosEnTr[3].getElementsByTagName('input').item(0).value;
        
        lisPedido=lisPedido+";"+nombre+","+cantidad;
        
        console.log(lisPedido);

}


function confirmar(usuID,fkEmp) {
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari 
            xmlhttp = new XMLHttpRequest();
        } else { // code for IE6, IE5 
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue");
                document.getElementById('btnCrear').style.display = 'none'; 
                document.getElementById("pantalla").innerHTML = this.responseText;
            }
        };

        xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/CAmbiarNombresPorIDs?lisPedido="+lisPedido+"&usuID="+usuID+"&fkEmp="+fkEmp, true);
        xmlhttp.send();
	
	lisPedido="";
    return false;
    
}


function buscarCat(idEmp) {
	var combo = document.getElementById("cat");
	var selected = combo.options[combo.selectedIndex].text;
	if(selected=="Todas"){
		selected=0;
	}
	else if(selected=="Pan"){
		selected=1;
	}
	else if(selected=="Vino"){
		selected=2;
	}
	else if(selected=="Queso"){
		selected=3;
	}
	else if(selected=="Cereal"){
		selected=4;
	}
	else if(selected=="Camisetas"){
		selected=5;
	}
	else if(selected=="Pantalones"){
		selected=6;
	}
	else if(selected=="Casacas"){
		selected=7;
	}
	else {
		selected=8;
	}
	
	buscar(selected , idEmp);
}



function buscar(select , idEmp) {

        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari 
            xmlhttp = new XMLHttpRequest();
        } else { // code for IE6, IE5 
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue"); 
                document.getElementById("informacion").innerHTML = this.responseText;
            }
        };

		console.log(select+" y "+ idEmp);
		
        xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/FiltrarProdPorCatInv?idCat="+select +"&idEmpre="+idEmp , true);
        xmlhttp.send();


    return false;
}

function aceptar(){
	document.getElementById('textoExito').style.display = 'none';
	document.getElementById('btnAceptar').style.display = 'none';
}	


function crearPedU(idEmp) {		
	lisPedido="";
		document.getElementById('btnCrear').style.display = 'block';
		console.log(idEmp);
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari 
            xmlhttp = new XMLHttpRequest();
        } else { // code for IE6, IE5 
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue"); 
                document.getElementById("pantalla").innerHTML = this.responseText;
            }
        };

        xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/VizualiProdCrearPed?idEmp="+idEmp, true);
        xmlhttp.send();


    return false;
}

function verPedidos(usuID){
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari 
            xmlhttp = new XMLHttpRequest();
        } else { // code for IE6, IE5 
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue"); 
                document.getElementById('btnCrear').style.display = 'none';
                document.getElementById("pantalla").innerHTML = this.responseText;
            }
        };

        xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/VerPedidos?usuID="+usuID, true);
        xmlhttp.send();

    return false;
}

function verPedidosUsu(nodo){
	var nodoTd = nodo.parentNode; //Nodo TD

    var nodoTr = nodoTd.parentNode; //Nodo TR

    var nodosEnTr = nodoTr.getElementsByTagName('td');

    var cabeceraID = nodosEnTr[0].textContent; 
    
    console.log(cabeceraID);

	if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari 
            xmlhttp = new XMLHttpRequest();
        } else { // code for IE6, IE5 
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue"); 
                document.getElementById("pantalla").innerHTML = this.responseText;
            }
        };

        xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/VerPedidosDetalle?cabeceraID="+cabeceraID, true);
        xmlhttp.send();

    return false;
}

function modificarPed(nodo, idCab, idDet, prodID){
	
		var nodoTd = nodo.parentNode; //Nodo TD
		
		var nodoTr = nodoTd.parentNode; //Nodo TR
		
		var nodoContenedorForm = document.getElementById('contenedorForm'); //Nodo DIV
		
		var nodosEnTr = nodoTr.getElementsByTagName('td');
		
		var nombre = nodosEnTr[0].textContent; 
		
		var descripcion = nodosEnTr[1].textContent;
		
		var cantidad = nodosEnTr[2].textContent; 
		
		var precioUnitario = nodosEnTr[3].textContent;
		
		var total = nodosEnTr[4].textContent; 
		
		tempCodigo =nodoTr.innerHTML;
		
		var nuevoCodigoHtml = "<tr><td class='tg-y698'>"+nombre+"</td><td class='tg-y698'>"+descripcion+
							"</td><td"+" class='tg-y698'><input type='text' value="+cantidad+" size='5'></td><td class='tg-y698'>"
							+precioUnitario+"</td><td class='tg-y698'>"+total+"</td><td class='tg-y698'>"+
							"<input type='button' value='Aceptar' onclick='guardarProdMod(this,"+ idCab +","+idDet+","+prodID+")'></td>"+
	    					"<td class='tg-y698'><input type='button' value='Cancelar' onclick='cancelar(this,"+ idCab+","+ idDet+"," +prodID+")'></td>";
		nodoTr.innerHTML = nuevoCodigoHtml;
}

var tempCodigo = "";

function  cancelar(nodo, idCab, idDet, prodID) {

	var nodoTd = nodo.parentNode; //Nodo TD
		
		var nodoTr = nodoTd.parentNode; //Nodo TR
		
		var nodoContenedorForm = document.getElementById('contenedorForm'); //Nodo DIV
		
		var nodosEnTr = nodoTr.getElementsByTagName('td');
		
		var nombre = nodosEnTr[0].textContent; 
		
		var descripcion = nodosEnTr[1].textContent;
		
		var cantidad = nodosEnTr[2].textContent; 
		
		var precioUnitario = nodosEnTr[3].textContent;
		
		var total = nodosEnTr[4].textContent; 
		
		var nuevoCodigoHtml = tempCodigo;
	    					
		nodoTr.innerHTML = nuevoCodigoHtml;
		
		tempCodigo = "";
}

function guardarProdMod(nodo,idCab,idDet,prodID){
	var nodoTd = nodo.parentNode; //Nodo TD

    var nodoTr = nodoTd.parentNode; //Nodo TR

    var nodosEnTr = nodoTr.getElementsByTagName('td');

    var cantidad = nodosEnTr[2].getElementsByTagName('input').item(0).value;
    
    console.log(cantidad);

	if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari 
            xmlhttp = new XMLHttpRequest();
        } else { // code for IE6, IE5 
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                //alert("llegue"); 
                document.getElementById("pantalla").innerHTML = this.responseText;
            }
        };

        xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/ModificarDetalle?cantidad="+
        cantidad+"&idCab="+idCab+"&idDet="+idDet+"&prodID="+prodID, true);
        xmlhttp.send();

    return false;
}
