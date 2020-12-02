function buscarProds(){

	var empr = document.getElementsByName("IDEmpre")[0].value;
    var cat = document.getElementsByName("cat")[0].value;
    var palb = document.getElementsByName("busc")[0].value;
    
    
    
	console.log(empr +"|"+ cat +"|"+ palb );
	
	
	if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari 
        xmlhttp = new XMLHttpRequest();
    } else { // code for IE6, IE5 
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue"); 
            document.getElementById("PantallaAdm").innerHTML = this.responseText;
        }
    };

    xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/BuscarProds?idEmp="+empr+"&cat="+cat+"&palb="+palb, true);
    xmlhttp.send();


    return false;
	
}



function editarprods(select) {



    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari 
        xmlhttp = new XMLHttpRequest();
    } else { // code for IE6, IE5 
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue"); 
            document.getElementById("PantallaAdm").innerHTML = this.responseText;
        }
    };

    xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/EditarProds?idEmp="+select, true);
    xmlhttp.send();


    return false;
}



function editarprod(id) {


	var nom = document.getElementsByName("nombre"+id)[0].value;
    var pre = document.getElementsByName("precio"+id)[0].value;
    var des = document.getElementsByName("descrip"+id)[0].value;
    var img = "Nohay";
	var sel = document.getElementsByName("sel"+id)[0].value;
	var empr = document.getElementsByName("IDEmpre")[0].value;
	
	console.log(nom +"|"+ pre +"|"+ des +"|"+img+"|"+sel)



	if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari 
        xmlhttp = new XMLHttpRequest();
    } else { // code for IE6, IE5 
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue"); 
            document.getElementById("PantallaAdm").innerHTML = this.responseText;
        }
    };

    xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/GuardarEditarProds?id="+id+"&nom="+nom+"&pre="+pre+"&des="+des+"&img="+img+"&sel="+sel+"&empre="+empr, true);
    xmlhttp.send();


    return false;
}

function eliminarprod (id) {


	var empr = document.getElementsByName("IDEmpre")[0].value;
	
	if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari 
        xmlhttp = new XMLHttpRequest();
    } else { // code for IE6, IE5 
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue"); 
            document.getElementById("PantallaAdm").innerHTML = this.responseText;
        }
    };

    xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/EliminarEditarProds?id="+id+"&empre="+empr, true);
    xmlhttp.send();


    return false;
}







function crearprods(select) {



    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari 
        xmlhttp = new XMLHttpRequest();
    } else { // code for IE6, IE5 
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue"); 
            document.getElementById("PantallaAdm").innerHTML = this.responseText;
        }
    };

    xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/CrearProdsVin?idEmp="+select, true);
    xmlhttp.send();


    return false;
}


function guardarDatos(){

	
	console.log(document.getElementsByName("nombre")[0].value);
    console.log(document.getElementsByName("precio")[0].value);
    console.log(document.getElementsByName("desc")[0].value);
    console.log(document.getElementsByName("img")[0].value);
    console.log(document.getElementsByName("empl")[0].value);
    console.log(document.getElementsByName("sel")[0].value);

    var nom = document.getElementsByName("nombre")[0].value;
    var pre = document.getElementsByName("precio")[0].value;
    var des = document.getElementsByName("desc")[0].value;
    var img = document.getElementsByName("img")[0].value;
    var empl = document.getElementsByName("empl")[0].value;
    var sel = document.getElementsByName("sel")[0].value;
    
    console.log(empl);



    if (nom == "" || pre == "" || des == "" || empl == "" || sel == "") {
        console.log("Esta vacio");

    } else {
		
		if (window.XMLHttpRequest) {
	        // code for IE7+, Firefox, Chrome, Opera, Safari 
	        xmlhttp = new XMLHttpRequest();
	    } else { // code for IE6, IE5 
	        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	    }
	
	    xmlhttp.onreadystatechange = function() {
	        if (this.readyState == 4 && this.status == 200) {
	            //alert("llegue"); 
	            document.getElementById("PantallaAdm").innerHTML = this.responseText;
	        }
	    };
	
	    xmlhttp.open("GET","/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/GuardarProdsVin?nom="+nom+"&empl="+empl+"&des="+des+"&img="+img+"&pre="+pre+"&sel="+sel, true);
	    xmlhttp.send();
	
	
	    return false;
    }
    
}


function manejoPeds(empID){
    
    	if (window.XMLHttpRequest) {
	        // code for IE7+, Firefox, Chrome, Opera, Safari 
	        xmlhttp = new XMLHttpRequest();
	    } else { // code for IE6, IE5 
	        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	    }
	
	    xmlhttp.onreadystatechange = function() {
	        if (this.readyState == 4 && this.status == 200) {
	            //alert("llegue"); 
	            document.getElementById("PantallaAdm").innerHTML = this.responseText;
	        }
	    };
	
	    xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/MostrarUsers?idEmp="+empID, true);
	    xmlhttp.send();
	
	
	    return false;
	    
    
}


function mostrarPeds(usuID){
	
	if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari 
        xmlhttp = new XMLHttpRequest();
    } else { // code for IE6, IE5 
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue"); 
            document.getElementById("aquiPedidos").innerHTML = this.responseText;
        }
    };

    xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/MostrarUsersPeds?usuID="+usuID, true);
    xmlhttp.send();


    return false;
	

}


function MostrarDetalles(cabsID){

	if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari 
        xmlhttp = new XMLHttpRequest();
    } else { // code for IE6, IE5 
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue"); 
            document.getElementById("aquiDetallesO").innerHTML = this.responseText;
        }
    };

    xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/MostrarUsersPedsDetall?cabsID="+cabsID, true);
    xmlhttp.send();


    return false;

}

function CambiarEstad(id, est ,pedi){



	if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari 
        xmlhttp = new XMLHttpRequest();
    } else { // code for IE6, IE5 
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            //alert("llegue"); 
            document.getElementById("aquiPedidos").innerHTML = this.responseText;
        }
    };

    xmlhttp.open("GET", "/Practica_de_laboratorio_01_Servlets_JSP_y_JDBC/MostrarUsersPedsCambio?usuID="+id+"&est="+est+"&pedi="+pedi, true);
    xmlhttp.send();


    return false;
	

}
