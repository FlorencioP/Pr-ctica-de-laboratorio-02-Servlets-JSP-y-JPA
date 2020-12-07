1.	Desarrollar una aplicación con tecnología JEE para gestionar requerimientos de compra en la web.

Se pide desarrollar una aplicación JEE que permita gestionar requerimientos de compras de varias empresas. En donde, un usuario pertenece a una sola empresa. Y una empresa cuenta con muchos productos, los cuales están organizados en diferentes categorías. Sin embargo, un producto puede pertenecer a una sola categoría. La finalidad de la aplicación es que el usuario pueda ingresar a través de un inicio de sesión y pueda registrar un requerimiento para la compra de varios productos. Además, que pueda ver el estado de la compra. 

Los requerimientos funcionales del sistema son:
•	La aplicación deberá manejar dos roles “Usuario” y “Administrador”
•	Un “usuario” y “administrador” puede iniciar sesión usando su correo y contraseña.
•	Una vez iniciado sesión el “usuario” podrá:
o	Registrar, modificar, eliminar, buscar y listar sus requerimientos de compra
•	Una vez iniciado sesión el “administrador” podrá:
o	Registrar, modificar, eliminar, buscar y listar los productos de la empresa a la que pertenece
o	Listar todos los requerimientos de compra de los “usuarios” de la empresa a la que pertenece
o	Aprobar o Rechazar los requerimientos de compra de los “usuarios” de la empresa a la que pertenece.

Nota: Filtrar los productos por la empresa a la cual el usuario pertenece.
De igual manera, se pide manejar sesiones y filtros para que existe seguridad en el sistema. Por lo qué, debe existir una parte pública y una privada. La parte privada ha sido descrita en los requisitos antes planteados. Y la parte pública será una página index.html a través de la cual podrán acceder al sistema. Además, en la parte pública se debe mostrar un catálogo de los productos filtrados por cada empresa. Se debe generar una página con la experiencia e interfaz de usuario apropiada, como la que se muestra a continuación.
Desarrollo:
En nuestra aplicación empezamos mostrando las empresas involucradas y un pequeño recuadro donde el usuario podrá iniciar sesión. Se utilizan un total de 3 empresas y 6 usuarios, 3 de estos son usuarios normales y otros 3 administradores, uno de cada uno para cada empresa.
Para llevar a cabo los requerimientos primero se empezó por el diseño de la Base de datos, se definió que la raíz de todo el proyecto seria la empresa, es por eso por lo que se crea una tabla en la Base de datos donde se contiene la información con respecto a estas:
 ![1](/READMEIMG/1.png?raw=true "Title")
Una vez creada la tabla donde se guardarán las empresas seguimos con el requerimiento que estipula que cada usuario podrá pertenecer a solo una empresa en específico, lo que se hace entonces es añadir una llave foránea que referencie al id de las empresas.
 ![2](/READMEIMG/2.png?raw=true "Title")
Además del Id de la empresa, también se guarda el correo del usuario, su contraseña y el tipo de usuario que es, estos datos serán útiles mas adelante cuando sea necesario pedir datos para el inicio de sesión.
Para los productos es necesario que pertenezcan a una empresa en específico y también a una sola categoría. Para esto se pensó en añadir a la información de los productos 2 llaves foráneas, una para referencias a la empresa y otra para referencias a su categoría. 
    ![3](/READMEIMG/3.png?raw=true "Title")
	![34](/READMEIMG/34.png?raw=true "Title")

Para el ultimo requerimiento del programa se crearon 2 tablas más, estas contendrán la información de los pedidos que hagan los usuarios y el estado actual de estos pedidos. Se crea la tabla donde se almacenarán las cabeceras de los pedidos, estas contendrán su id único, el id del usuario propietario de la orden y el estado actual de la orden. Además de esta tabla también existirá otra donde se almacenara el id del producto, el id de su cabecera correspondiente y la cantidad pedida por parte del usuario.
   ![4](/READMEIMG/4.png?raw=true "Title")
   ![5](/READMEIMG/5.png?raw=true "Title")

Una vez terminada de definir la base de datos entramos a programar las funcionalidades del sistema.
Para el manejo de roles se utilizó un Servet llamado Login, donde se reciben los datos del usuario, estos datos son su mail y contraseña, cuando los recibe, el Servlet realiza una consulta SQL donde se obtiene el rol de dicho usuario y la empresa a la que este pertenece, al recibir estos datos se un jsp para cargar los datos correspondientes, en caso de que no exista el usuario el servlet simplemente redirecciona la vista a una pagina donde se advierte esto. 
  ![6](/READMEIMG/6.png?raw=true "Title")
  ![7](/READMEIMG/7.png?raw=true "Title")
Dependiendo del resultado de la consulta, Si es usurario se cargará el JSP de usuarios, y este recibirá la información del usuario mediante una clase Usuario.
Dentro del JSP se utilizará el ID de usuario para cargar sus pedidos y también para crear pedidos a su nombre, también se recibe el ID de la empresa mediante la llave foránea, esta sirve para identificar la empresa a la que esta registrado el usuario y así cargar la información correspondiente.
  
 ![8](/READMEIMG/8.png?raw=true "Title")
 ![9](/READMEIMG/9.png?raw=true "Title")
 ![10](/READMEIMG/10.png?raw=true "Title")
Para las funcionalidades del usuario es necesario cargar la información pasada a través del JSP en funciones, estas funciones vienen de un javascript y lo que hace este es utilizar AJAX refiriéndose al servlet correspondiente, en cada uno de estos se realiza la consulta correspondiente se envían los datos a un JSP y este luego carga en la parte designada por el AJAX.
Función en le JavaScript donde se llama al Servlet y se usa AJAX:
 ![11](/READMEIMG/11.png?raw=true "Title")
Servlet donde se solicita la información y luego se carga en el JSP:
 ![12](/READMEIMG/12.png?raw=true "Title")
Consulta SQL realizada en el DAO:
Esta es la parte que mas cambian dentro del proceso, aquí se utilizan entidades para la búsqueda, y a diferencia de la anterior práctica, este query devuelve una entidad entera con la que se puede trabajar.
 ![13](/READMEIMG/13.png?raw=true "Title")
JSP donde se muestra la información correspondiente:
 ![14](/READMEIMG/14.png?raw=true "Title")
El ciclo FOR presente sirve para imprimir en la pagina los productos.
Esa es la lógica principal utilizada de aquí en adelante para cada una de las funcionalidades pedidas, tanto para el usuario y para el Administrador.
Si el usuario que inicia sesión es un administrador el servlet Login se encarga de enviar la información del usuario y el ID de la empresa para cargar el JSP de Administrador, donde este podrá Listar los pedidos hechos por los usuarios, aprobar o rechazar estos y también crear o modificar los productos. 
  ![15](/READMEIMG/15.png?raw=true "Title")
  ![16](/READMEIMG/16.png?raw=true "Title")
Para prevenir el acceso a paginas sin que se allá iniciado sesión se utiliza un filtro, y para que este funcione se hace uso de 3 filters, uno llamado Filtro que es el que se encarga aplicar el filtro a las paginas que lo necesiten, otro llamado Salir que es el que se encarga de registrar el cierre de sesión por parte del usuario y el de Login, este ya fue mostrado anteriormente y lo que hace es registrar el inicio de sesión y redireccionar al usuario a la página correspondiente.
   ![17](/READMEIMG/17.png?raw=true "Title")
   ![18](/READMEIMG/18.png?raw=true "Title")
Por último, veremos cómo quedo el índex del programa, aquí es donde se muestra la casilla de inicio de sesión y también a las empresas existentes, si se hace entra a una de estas se iniciara sesión automáticamente como invitado y lo único que se podrá hacer es ver los productos disponibles y clasificarlos por categorías.
 
 ![19](/READMEIMG/19.png?raw=true "Title")
 ![20](/READMEIMG/20.png?raw=true "Title")
Estas 2 paginas de la tienda forman parte de la parte publica del programa. 
Ahora cuando el usuario inicia sesión con una correo y contraseña se carga la pagina correspondiente dependiendo de su rol:
Usuario: 
 ![21](/READMEIMG/21.png?raw=true "Title")
Al hacer click en “ver” cargan los datos del pedido.
 ![22](/READMEIMG/22.png?raw=true "Title")
Esta es la interfaz donde el usuario puede crear pedidos:
 ![23](/READMEIMG/23.png?raw=true "Title")
Admin: 
Este puede registrar un nuevo producto:
 ![24](/READMEIMG/24.png?raw=true "Title")
Puede modificar los productos ya creados:
 ![25](/READMEIMG/25.png?raw=true "Title")
Y por último llevar un manejo de los pedidos realizados a la empresa:
 ![26](/READMEIMG/26.png?raw=true "Title")
 ![27](/READMEIMG/27.png?raw=true "Title")

La pagina cambia de estilo y datos dependiendo de la empresa a la que el usuario pertenezca:
 ![28](/READMEIMG/28.png?raw=true "Title")
