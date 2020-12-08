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
Lo primero que empezamos a realizar es nuestro diagrama de Entidad-Relacion, para asi definir nuestra base de datos y tambien las entidades dentro del programa.      
  
![1](/READMEIMG/1.png?raw=true "Title")

Primero empezamos creando las entidades que no requieren de claves foraneas, En nuestro caso serian las de: Categoria y Empresa.
Entidad Empresa:
 ![2](/READMEIMG/2.png?raw=true "Title")


Entidad Categoria: 
 ![3](/READMEIMG/3.png?raw=true "Title")


Se decidió empezar con la creación de estas 2 entidades ya que no dependen de la existencia de otras entidades para que puedan funcionar.
Una vez creadas estas 2 procedimos a crear las entidades de Usuario y Producto, ya que estas están relacionadas con la empresa y también con la Categoría (Solo Producto)
Entidad Producto:
 ![4](/READMEIMG/4.png?raw=true "Title")


Continuamos con la creación de los usuarios, estos son necesarios para poder luego crear la entidad FacturaCabecera y FacturaDetalle, ya que la Cabecera necesita que exista la entidad usuario para referenciarse al usuario al que pertenece por medio de una clave foránea y así mismo con la factura detalle que necesita de la existencia de una factura cabecera para referenciarse a esta y también de un producto.


Entidad Usuario:
 ![5](/READMEIMG/5.png?raw=true "Title")


Entidad FacturaCabecera:
 ![6](/READMEIMG/6.png?raw=true "Title")

Entidad FacturaDetalle:
 ![7](/READMEIMG/7.png?raw=true "Title")


Todas estas entidades cuentan con sus Setters and Getters respectivos y toStrings.

En nuestra aplicación empezamos mostrando las empresas involucradas y un pequeño recuadro donde el usuario podrá iniciar sesión. Se utilizan un total de 3 empresas y 6 usuarios, 3 de estos son usuarios normales y otros 3 administradores, uno de cada uno para cada empresa.

Para llevar a cabo los requerimientos primero se empezó por el diseño de la Base de datos, se definió que la raíz de todo el proyecto sería la empresa, es por eso por lo que se crea una tabla en la Base de datos donde se contiene la información con respecto a estas:
 ![8](/READMEIMG/8.png?raw=true "Title")


Una vez creada la tabla donde se guardarán las empresas seguimos con el requerimiento que estipula que cada usuario podrá pertenecer a solo una empresa en específico, lo que se hace entonces es añadir una llave foránea que referencie al id de las empresas.
  ![9](/READMEIMG/9.png?raw=true "Title")


Además del Id de la empresa, también se guarda el correo del usuario, su contraseña y el tipo de usuario que es, estos datos serán útiles mas adelante cuando sea necesario pedir datos para el inicio de sesión.
Para los productos es necesario que pertenezcan a una empresa en específico y también a una sola categoría. Para esto se pensó en añadir a la información de los productos 2 llaves foráneas, una para referencias a la empresa y otra para referencias a su categoría. 
![10](/READMEIMG/10.png?raw=true "Title")
 ![11](/READMEIMG/11.png?raw=true "Title")

Para el ultimo requerimiento del programa se crearon 2 tablas más, estas contendrán la información de los pedidos que hagan los usuarios y el estado actual de estos pedidos. Se crea la tabla donde se almacenarán las cabeceras de los pedidos, estas contendrán su id único, el id del usuario propietario de la orden y el estado actual de la orden. Además de esta tabla también existirá otra donde se almacenará el id del producto, el id de su cabecera correspondiente y la cantidad pedida por parte del usuario.
![12](/READMEIMG/12.png?raw=true "Title")
 ![13](/READMEIMG/13.png?raw=true "Title")


Una vez que hemos terminado de definir la base de datos entramos a programar las funcionalidades del sistema.
Para el manejo de roles se utilizó un Servet llamado Login, donde se reciben los datos del usuario, estos datos son su mail y contraseña, cuando los recibe, el Servlet realiza una consulta SQL donde se obtiene el rol de dicho usuario y la empresa a la que este pertenece, al recibir estos datos se redirige a un jsp para cargar los datos correspondientes, en caso de que no exista el usuario el servlet simplemente  se redirecciona la vista a una pagina donde se advierte esto. 
   ![14](/READMEIMG/14.png?raw=true "Title")
 ![15](/READMEIMG/15.png?raw=true "Title")

Dependiendo del resultado de la consulta, Si es usurario es encontrado se carga un atributo de tipo Usuario y se redirige al JSP de la vista del usuario.
Dentro del JSP se utilizará el ID del usuario para cargar sus pedidos dependiendo de la empresa a la que pertenezca el mismo, esta se identificara utilizando a la llave foránea como referencia, y también para crear pedidos a su nombre.
  
  ![16](/READMEIMG/16.png?raw=true "Title")
 ![17](/READMEIMG/17.png?raw=true "Title")
 ![18](/READMEIMG/18.png?raw=true "Title")


Para las funcionalidades del usuario es necesario cargar la información pasada a través del JSP en funciones, estas funciones vienen de un javascript el cual utiliza AJAX para dirigirse al servlet correspondiente, en cada uno de estos se realiza la consulta correspondiente y se envían los datos a un JSP para que este los cargue en la parte designada por el AJAX.


Usuario
1.	Crear pedidos.
1.1.	Función de JavaScript que permite ver la lista de productos que ofrece la empresa a la que pertenece el usuario:
              ![19](/READMEIMG/19.png?raw=true "Title")


Una vez que en el jsp se dio Clic en el botón de crear pedidos nos dirigirá a la función crearPedU pasando como parámetro el id de la empresa que se encuentra como clave foránea en el usuario, una vez que estemos dentro de la función está nos dirigirá a través de Ajax al servlet “VizualiProdCrearPed” Pasando al nivel de la empresa como parámetro mediante el método GET.


1.2.	 Servlet que permite obtener los productos de la empresa
       ![20](/READMEIMG/20.png?raw=true "Title")


Dentro de este servlet sub tiene como parámetro al ID de la empresa y de éste se hace una consulta para que nos regrese una lista de productos de acuerdo con el ID de la misma, esta lista se pasará hacia el JSP “usrVincreate” para poder listar los productos mediante etiquetas HTML y presentarla a través de Ajax en el JSP principal.
1.3.	Consulta SQL en el JPAProductoDAO para obtener la lista de productos según la empresa.
    ![21](/READMEIMG/21.png?raw=true "Title")


En esta consulta SQL se tiene como parámetro a él ID de la empresa obtenido en el servlet anterior, él mismo se usa para buscar la empresa en la base de datos, obteniendo la entidad correspondiente para usarla en la consulta que vamos a realizar, la cual nos dé como resultado una lista de productos pertenecientes a la empresa con el mismo ID y que el ingresado como parámetro.

1.4.	JSP “usrVincreate” que permite listar los productos de la empresa
     ![22](/READMEIMG/22.png?raw=true "Title")


Dentro de este JSP se recoge como parámetro la lista de productos de la empresa almacenándolo en una lista desde Java, Seguido de esto se crea una tabla en la cual sus filas pues se Irán iterando según el número de productos de la empresa.

1.5.	Función de JavaScript que permite la recolección de datos de la tabla para crear pedidos:
    ![23](/READMEIMG/23.png?raw=true "Title")


Como se puede apreciar en el código trabaja mediante nodos los cuales se recolectan al presionar el botón de agregar, de esta manera recolectamos el nombre, precio, descripción y cantidad Qué queremos agregar a nuestro pedido. Una vez recolectados los datos se agregan a un String el cual estará separado por punto y coma por cada pedido agregado y con una coma por cada dato que contenga el pedido.
Después de que el usuario haya agregado todos sus productos al pedido se dará clic al botón de confirmar pedido para que este pueda enviarlos datos al servlet correspondiente Mediante una función Ajax.


1.6.	Función para el envío del pedido hacia el servlet:
      ![24](/READMEIMG/24.png?raw=true "Title")


En esta función se recibe como parámetros el id del usuario y la llave foránea de la empresa, dentro del Ajax se enviarán los siguientes datos: id del usuario, la llave foranea de la empresa y la lista de pedidos hacia el servlet de “CAmbiarNombresPorIDs”.
1.7.	Servlet “CAmbiarNombresPorIDs” para crear los pedidos.
    ![25](/READMEIMG/25.png?raw=true "Title")


Dentro de este servlet se puede apreciar que se reciben: los datos de la lista de pedidos, el id del usuario, y la llave foránea de la empresa mediante el método getParameter, con estos datos se procede a crear un pedido cabecera, mientras que con la lista de pedidos se hace una separación de los pedidos mediante la función split la cual nos ayudará a separarlos dentro de un vector, Una vez separados los pedidos procederemos a crearlos uno por uno y agregarlos al PedidoCabecera, Si los datos ingresaron correctamente a la base de datos se procederá a mostrar un mensaje de éxito el cual está en un JSP aparte por lo cual se re direcciona al mismo y se mostrará mediante el Ajax en el JSP  de la ventana principal del usuario.
1.8.	Consulta SQL realizada en el JPAPedidoCabeceraDAO para UltimoID
    ![26](/READMEIMG/26.png?raw=true "Title")


Lo que se realiza aquí es consultar cual es el Id más alto que exista para los Pedidos Cabecera, realizado con el persistentClass.
1.9.	Consulta SQL realizada en el JPAPedidoDetalleDAO para obtener UltimoID
    ![27](/READMEIMG/27.png?raw=true "Title")


Lo que se realiza aquí es consultar cual es el Id más alto que exista para los Pedidos Detalle.


1.10.	Consulta SQL realizada en el JPAPedidoCabeceraDAO para crear el pedido Cabecera
    ![28](/READMEIMG/28.png?raw=true "Title")


En este caso, estamos haciendo uso de un metodo generico, donde simplemente se recive una entidad, y dependiendo de dicha entidad se registrara en la base de datos, en este caso pasamos como parámetro a un objeto PedidoCabecera, el cual hemos obtenido desde el servlet anteriormente mencionado, una vez que hemos obtenido el objeto se puede añadir un nuevo PedidoCabecera. 
1.11.	Consulta SQL realizada en el JPAPedidoDetalleDAO para crear el pedido detalle
    ![29](/READMEIMG/29.png?raw=true "Title")


De la misma manera que el anterior, se hace uso de un metodo generico, donde simplemente se recive una entidad, y dependiendo de dicha entidad se registrara en la base de datos, en este caso pasamos como parámetro a un objeto PedidoDetalle, el cual hemos obtenido desde el servlet anteriormente mencionado, una vez que hemos obtenido el objeto procederemos a desglosar sus atributos para insertarlos en la consulta SQL que nos permite añadir un nuevo PedidoDetalle. 

1.12.	JSP “MensajeExito” donde muestra el mensaje de éxito.
    ![30](/READMEIMG/30.png?raw=true "Title")


En esta parte se mostrará un mensaje inticando que el pedido fue completado con éxito con un botón de aceptar para que se quite el mismo mensaje.
2.	Ver pedidos
2.1.	Función de JavaScript para listar los pedidos del usuario
    ![31](/READMEIMG/31.png?raw=true "Title")



En esta función como parámetro tenemos al ID del usuario el cual se enviará mediante el Ajax hacia el servlet VerPedidos para que este pueda hacer la respectiva consulta y se logre obtener la lista de pedidos y su estado del cliente.


2.2.	Servlet para Obtener el listado de pedidos del usuario
    ![32](/READMEIMG/32.png?raw=true "Title")


Este ser le recibe como parámetro líder del usuario que se envió desde la función anterior del JavaScript seguido de esto se realiza una consulta para poder obtener un listado de los pedidos que ha hecho el cliente a partir de su ID, Después de obtener este listado este se envía al JSP “MostrarPedidos” para mostrar este listado desde el mismo.
2.3.	Consulta SQL desde el JPAPedidoCabeceraDAO desde la cual se obtendrá el listado de pedidos del usuario desde la base de datos.
    ![33](/READMEIMG/33.png?raw=true "Title")


En esta consulta recibimos como parámetro el id del usuario con el cual primero obtenemos la entidad usuario al que el id pertenezca y luego realizaremos la consulta para obtener el listado de pedidos que ha realizado el mismo por cada fila que salga del resultado de la consulta ésta se añadirá a una lista para después retornar el resultado hacia el servlet.


2.4.	JSP “MostrarPedidos” donde se mostrará la lista de pedidos del usuario
     ![34](/READMEIMG/34.png?raw=true "Title")


En este JSP lo que se hace es recibir el listado de los pedidos que ha hecho el usuario y guardarlos en un listado de tipo list seguido de esto se crea una tabla desde la cual sus filas se irán iterando según el número de pedidos que ha hecho el usuario mediante la función out.println. En esta parte también se transforma la inicial del estado en su palabra completa para poder añadirlo a la tabla y con esto el usuario pueda ver de una mejor manera el estado en el que se encuentra su pedido. Esta tabla se mostrará en el JSP principal donde se encuentra la ventana del usuario gracias al Ajax ejecutado anteriormente.

2.5.	Función JavaScript para poder ver el detalle del pedido
      ![35](/READMEIMG/35.png?raw=true "Title")


Esta función recibirá como un parámetro el nodo desde el cual fue enviado en la matriz después de recoger los datos como lo son el ID de la de la cabecera se mandará al servlet “VerPedidosDetalle” Para poder tomar los pedidos y productos que pidió el usuario.
2.6.	Servlet para obtener los detalles del pedido
    ![36](/READMEIMG/36.png?raw=true "Title")


Dentro de este servlet se obtiene el id de la cabecera, con este se manda a buscar la lista de pedidos según su cabecera seguido de esto por cada detalle se obtendrá un producto almacenándolo en una lista con su respectiva cantidad y enviándolo al JSP “MostrarDetalles”.
2.7.	Consulta SQL desde JPAPedidoDetalleDAO para obtener la lista de pedidos a partir del ID de la cabecera.
    ![37](/READMEIMG/37.png?raw=true "Title")



Este método lo que se hace es recibir el IDE de la cabecera, leer el id para retirar la entidad correspondiente y realizar una consulta que nos devuelve el listado de pedidos detalle a partir de él y de la cabecera por cada fila que devuelva la consulta se irá guardando en una lista la cual se enviará hacia el servlet.
2.8.	JSP “MostrarDetalles” donde se mostrará en una tabla los detalles del respectivo pedido
	![38](/READMEIMG/38.png?raw=true "Title")


En este JSP lo que se recibe son dos listas una para las listas de los detalles y otra para la lista de los productos seguido de esto sí creará una tabla mediante las etiquetas HTML por cada fila de esta tabla sé ir a iterando según el número de detalles e ir almacenando en la tabla los datos del producto y la cantidad que pertenece al detalle, así como el precio total de cada detalle.
2.9.	JavaScript para modificar el detalle

    ![39](/READMEIMG/39.png?raw=true "Title")


Si se desea modificar el pedido se tendrá que cliquear en el botón de modificar puesto en la tabla este de aquí nos dirigirá a la función de modificarPed la cual recibirá como parámetros al nodo al id de la cabecera, del detalle, y del pedido cómo estamos trabajando con nodos en la tabla Podremos recoger los datos de la fila seleccionada una vez recogidos estos datos se modificará esta fila para que podamos modificar la cantidad solicitada en el detalle una vez hayamos modificado la cantidad pulsaremos aceptar en el caso de que queramos confirmar el cambio O cancelar si queremos cancelarlo.


En el caso de confirmar el cambio llamaremos a otra función donde podremos guardar nuestro cambio del pedido:

     ![40](/READMEIMG/40.png?raw=true "Title")


En esta función lo que será es recoger los datos de la fila modificada y mandarlos al servlet “ModificarDetalle”.
    ![41](/READMEIMG/41.png?raw=true "Title")


En este Server lo que se recogerá es el ID de la cabecera, ID del detalle, ID producto y la cantidad Para poder instanciar un nuevo pedido detalle el cual se enviará como un parámetro a la sentencia SQL que permitirá modificar el pedido.
    ![42](/READMEIMG/42.png?raw=true "Title")


Para actualizar los datos del pedido detalle se usa el metodo generico “Update” este de aquí nos sirve para cualquier entidad, en este caso la entidad que estamos actualizando es el detalle de un pedido.
Después de esto en el servlet se redirige al actualizar pedido detalle.

En el caso de cancelar la modificación se ejecutará la siguiente función:
    ![43](/READMEIMG/43.png?raw=true "Title")


Dentro de este código lo que se hace es cargar los datos de fila guardada antes de su modificación Cancelando así cualquier modificación echa si es que se aplasta el botón de cancelar.
2.10.	JavaScript para eliminar un detalle
    ![44](/READMEIMG/44.png?raw=true "Title")


Dentro de esta función se tiene como parámetros al líder del pedido y el líder de la cabecera y estos serán enviados mediante el Ajax al servlet “EliminarDet” Donde a partir del líder del pedido detalle se eliminará el mismo.
2.11.	Servlet “EliminarDet” donde se cambia el estado del detalle para eliminarlo
    ![45](/READMEIMG/45.png?raw=true "Title")

Dentro de este servlet se recibe el líder de la cabecera y el líder del detalle seguido de esto se utiliza el método delete para eliminar el pedido detalle para después mandar el ID de la cabecera al “ActualizarPedidosDetalle” Para que se recargue la tabla en la que estamos trabajando.


2.12.	Sentencia SQL donde se cambia el estado del pedidoDetalle en la base de datos
 ![46](/READMEIMG/46.png?raw=true "Title")


Se usa la función genérica de “delete” para eliminar esta entidad.
Administrador
    ![47](/READMEIMG/47.png?raw=true "Title")


En el caso de que el Servlet Login detecte que ha iniciado sesión un administrador este redireccionara la página a la vista de administrador y se enviara toda la información del usuario.

    ![48](/READMEIMG/48.png?raw=true "Title")


Una vez en el JSP principal del administrador se recibe la información anteriormente enviada del usuario para identificar la empresa a la que pertenece usando la llave foránea de empresa que el usuario tiene sirve exactamente para esto (Distinguir a la empresa a la que pertenece) 

     ![49](/READMEIMG/49.png?raw=true "Title")



Independientemente de la empresa de la que el usuario pertenezca, se cargan 3 opciones que están a disposición del administrador, estas son “Registrar Producto”, "Modificar Productos" y "Manejar Pedidos".
Todas las opciones se ejecutan por medio de JavaScript y reciben como parámetro la llave foránea de la empresa.
Dentro de esto también se encuentra un <div>, este espacio de aquí está destinado a ser utilizado con AJAX para así mostrar los datos sin la necesidad de cambiar de página.
Ahora explicaremos lo que hace cada función:
La primera llamada ”crearprods” sirve para que el administrador añada más productos a su empresa, al seleccionar esta se llama una función JavaScript donde se utiliza AJAX en el espacio anteriormente mencionado.
1.	Crear productos
1.1.	Función de JavaScript para crear productos
    ![50](/READMEIMG/50.png?raw=true "Title")

En sí, lo que hace nuestra función es entregar información a un servlet y luego este como respuesta cargara una página con los datos en base a la información enviada, gracias al AJAX la información se visualizara dentro del <div> designado.
1.2.	Servlet para enviar el id de la empresa al JSP
     ![51](/READMEIMG/51.png?raw=true "Title")


Lo que hace nuestro Servlet en el caso de crear productos es simplemente enviar el id de la empresa a la cual se va a registrar el producto a un JSP llamado “TablonCrear”.
1.3.	JSP donde se ingresan los datos para crear un nuevo producto
 ![52](/READMEIMG/52.png?raw=true "Title")


En este JSP es donde El administrador ingresara toda la información acerca del producto que desea registrar, cuando allá terminado el administrador guardara los datos pulsando el botón guardar, este llama a una función JavaScript donde esta se encargara de retirar todos los datos.
1.4.	Función JavaScript para registrar el nuevo producto
 ![53](/READMEIMG/53.png?raw=true "Title")


Esta función se encargará de retirar todos los datos y de llamar a un Servlet que se encargará de registrar estos datos en la Base de datos, Esta función también aplica AJAX y se encarga de volver a cargar el formulario una vez completado el proceso, esto para que el Administrador ingrese otro producto más si así lo requiere.
1.5.	Servlet para guardar el nuevo producto
    ![54](/READMEIMG/54.png?raw=true "Title")


Al enviar esos datos al Servlet este lo que hace es transformar la información recibida a su debido formato para crear un producto, este sirve para crear la entidad en la base de datos, luego que se cree esta entidad se enviara el id de la empresa de nuevo al JSP “TablonCrear” haciendo que se vuelva a cargar el Formulario para crear productos.
1.6.	Consulta SQL desde JPAProductoDAO para guardar el producto.
 ![55](/READMEIMG/55.png?raw=true "Title")


Se utiliza uno de los métodos generales para crear el nuevo producto.



2.	Editar productos.
2.1.	Función JavaScript para la edición de productos
![56](/READMEIMG/56.png?raw=true "Title")

Tal y como la anterior, esta función llama a un Servlet desde una función en JavaScript, esta de aquí utiliza AJAX y cargara la información en el espacio designado.
2.2.	Servlet para modificar el producto
     ![57](/READMEIMG/57.png?raw=true "Title")


El Servlet llamado en este caso se llama “EditarProds” este recibe el Id de la empresa y con este busca todos los productos que estén relacionados con la empresa con “findE”.


2.3.	Consulta SQL desde JPAProductoDAO para obtener los productos que desee modificar
    ![58](/READMEIMG/58.png?raw=true "Title")


Esta consulta nos devuelve una lista, la cual luego nos sirve como parámetro para cargar los datos en el JSP.
2.4.	JSP “TablaEditarProductos” 
    ![59](/READMEIMG/59.png?raw=true "Title")


Tanto como la lista obtenida y el id de la empresa se envían a un JSP llamado “TablaEditarProductos” Aquí Se cargan los productos en una tabla que permite la edición de los campos, también cuenta con un sistema de búsqueda en caso de que el administrador este buscando un producto en específico para su edición.
Dentro de esta tabla se encuentran dos opciones, la primera es guardar la edición realizada y la otra es eliminar el producto de la lista, Cada producto dentro de la empresa tiene estas 2 opciones.

Primero explicaremos el funcionamiento de las opciones de búsqueda, Se puede buscar por categoría y por Texto.
Cuando el Administrador desee buscar un producto ingresara la información necesaria y pulsara el botón Buscar, Esto llamara al método “buscarProds”.
3.	Buscar productos
3.1.	Función JavaScript para buscar productos
    ![60](/READMEIMG/60.png?raw=true "Title")


Este método lo que hace es retirar la información del <select> este será el id de la categoría y también retira la información de del <input> que es donde el administrador ingresara un texto para hacer referencia a lo que se esté buscando.
Existen 2 casos probables cuando se pulsa el botón buscar, la consulta realizada dependerá si la variable “tex” este vacía o no.


3.2.	Servlet buscarProds este servlet nos ayudara a buscar los productos según su categoría.
    ![61](/READMEIMG/61.png?raw=true "Title")


En el caso de que esta esté vacía lo único que se hace es una consulta utilizando el id de la empresa y el id de la categoría para filtrar los productos.
3.3.	Consulta SQL desde el JPAProductoDAO para obtener la lista de productos que coincidan con la búsqueda.
    ![62](/READMEIMG/62.png?raw=true "Title")


En el caso de que no lo este, se hace otra consulta donde se utilizara el texto ingresado para la búsqueda en la base de datos.




3.4.	Consulta SQL desde el JPAProductoDAO para obtener la lista de productos que coincidan con la búsqueda.
    ![63](/READMEIMG/63.png?raw=true "Title")


Ambas consultas devuelven una lista, con esta lista lo único que falta hacer es volver a cargar el JSP que muestra los productos enlistados, pero esta vez con una lista de productos ya filtrada. Eso es lo que hace el Servlet llamado al final.
Como se dijo anteriormente, cada producto listado cuenta con 2 botones, uno que guarda los cambios realizados y otro que elimina el producto de la lista.
4.	Editar productos
4.1.	JSP TablaEditarProds 
    ![64](/READMEIMG/64.png?raw=true "Title")


Cuando el administrador allá terminado los cambios dentro de un producto y lo desea guardar, es necesario que pulse el botón “Guardar” Activando una función en el JavaScript llamada “editarprod” esta recibe el id del producto que se desea cambiar.
Lo único que hace esta función es recibir el id del producto y los datos que se desean remplazar en él, esta función también trabaja con AJAX permitiendo que la lista se actualice en el mismo lugar cuando el administrador haga click en guardar.
Una vez enviados los datos correspondientes al Servlet este los recibe y los transforma al tipo de dato adecuado para crear un producto con la información enviada y el mismo id del producto que se busca editar, hecho esto se envía un Update para guardar los cambios en la base de datos, hecho esto, se vuelve a consultar la lista de productos de la empresa con el Id de la empresa y se vuelven a enviar los datos actualizados sobre la página del administrador.

    ![65](/READMEIMG/65.png?raw=true "Title")


Aquí presentamos el metodo update utilizado.
4.2.	Consulta SQL desde JPAProductoDAO se actualiza el producto desde el parametro que recibe.
    ![66](/READMEIMG/66.png?raw=true "Title")


En el caso de que el administrador haga click en el botón “Eliminar” se activara la función “eliminarprod” esta función es similar a la de “editarprod”, de la misma manera, se envía el id del producto, el Servlet recibe el dato, procesa una consulta, actualiza la lista y manda de nuevo a cargar los contenidos de la tabla, solo en este caso, la consulta realizada es distinta, esta se llama “delete” y lo que hace es cambiar el estado del producto de Activo “A” a Eliminado “E”.
5.	Eliminar un producto
5.1.	Consulta SQL desde JPAProductoDAO donde elimina el producto a partir de su parametro.
   ![67](/READMEIMG/67.png?raw=true "Title")


Cuando se actualice la lista, este producto ya no se mostrará.
La tercer y última opción que tiene el administrador a su disposición es la del manejo de pedidos aquí es donde un administrador observará los pedidos de los usuarios dentro de su empresa, podrá ver los detalles de estos y decidir se aprueba el pedido o lo rechaza.
Cuando el administrador haga click en “Manejar Pedidos” se activará la función “manejoPeds”, al igual que las otras 2 funciones esta recibe el Id de la empresa y funciona con AJAX.
Lo primero que se hace con esto es mostrar a los usuarios involucrados con la empresa, dentro de esto también se carga una pequeña área donde cargara el siguiente contenido, asi mismo se hace uso de AJAX.


6.	Manejo de pedidos
    ![68](/READMEIMG/68.png?raw=true "Title")


Este Servlet ejecuta una consulta que devolverá una lista de usuarios que estén dentro de la empresa a la que pertenezca el Administrador
    ![69](/READMEIMG/69.png?raw=true "Title")


Una vez retirada la lista, lo que se hace es enviar esta al JSP “usersEmpresa”.
    ![70](/READMEIMG/70.png?raw=true "Title")


En este cargaran todos los usuarios, y además se le añadirá un botón que cargara los pedidos realizados por parte de ese usuario en otro <div> que se crea al cargar ese JSP, esta función utiliza el id del usuario para llevarse a cabo.  Al hacer click sobre este se carga el Servlet “MostrarUsersPeds”.
    ![71](/READMEIMG/71.png?raw=true "Title")


Lo que pasa al cargar este Servlet es que con el Id del usuario se hace una consulta y esta devuelve una lista de todos los pedidos en total que ha tenido este usuario.
    ![72](/READMEIMG/72.png?raw=true "Title")


La consulta utilizada es la siguiente:
    ![73](/READMEIMG/73.png?raw=true "Title")


Una vez conseguida la lista lo que se hace es enviarla como parámetro al JSP que cargara con la Ayuda del AJAX en el <div> designado. Ese JSP lo que hace es mostrar la lista de pedidos por parte de ese usuario y añadir 3 opciones, La primera es la de mostrar los detalles del pedido, la segunda es la de Aprobar el Pedido y la tercera es de Rechazar el pedido, entre lo que es Aprobar y Rechazar el método se comparte.
En este JSP también se crea un <div> que es donde los detalles del pedido se mostraran.
       ![74](/READMEIMG/74.png?raw=true "Title")


Al seleccionar “Ver:” se carga la función “mostrarDetalles” como parámetro necesita que se le envié el id de la cabecera y esta utilizara AJAX para cargar los datos ahí.
    ![75](/READMEIMG/75.png?raw=true "Title")


Similar a los anteriores Servlets, lo que se hace es usar el Id de la cabecera para conseguir la lista de detalles del pedido al que corresponden, se carga el resultado al JSP llamado “usersPedidosDetall” y como todo esto se esta ejecutando en una función que utiliza AJAX pues el resultado se mostrara en el área designada.
    ![76](/READMEIMG/76.png?raw=true "Title")


Dentro del JSP lo único que se hace es listar la información de los productos.
     ![77](/READMEIMG/77.png?raw=true "Title")


Por otro lado, para cambiar el estado de un pedido se utiliza la función “cambiarEstad” esta recibe como parámetros el Id de la cabecera y el estado a la que se quiere cambiar esta, estos estados son A de Aprobado y R de Rechazado, este cambiara dependiendo el botón que se pulse.
    ![78](/READMEIMG/78.png?raw=true "Title")


El Servet solicitado se encarga de modificar el pedido cabecera correspondiente con el estado deseado y luego se encarga de volver a cargar las cabeceras de los pedidos del usuario, actualizando la lista visualizada con el nuevo estado del pedido.
    ![79](/READMEIMG/79.png?raw=true "Title")


Para esto se utiliza esta consulta:
    ![80](/READMEIMG/80.png?raw=true "Title")


Cierre de sesión 
 ![81](/READMEIMG/81.png?raw=true "Title")


Dentro de este servlet se cierra la sesión y este es el primer paso para poder aplicar los filtros ya que los mismos apartaran la parte publica de la privada que seria cuando se esta iniciado sesión. 
Filtro
 ![82](/READMEIMG/82.png?raw=true "Title")

  ![83](/READMEIMG/83.png?raw=true "Title")


Con este filtro lo que hacemos es apartar todas la direcciones que se usan en la parte privada que es cuando uno se encuentra inicado sesion por lo tanto si se quiere acceder a una de esas direcciones se preguntara si el usuario esta logueado, si lo esta el filtro lo dejara acceder a esa direccion pero si no lo esta el filtro no lo dejara acceder a esa direccion y redirigira a la pagina al index.
Usuarios Invitados
Si un usuario que no tiene cuenta quiere ingresar a ver que es lo que las Empresas le ofrecen , este puede hacer click en el boton entrar. Dependiendo del boton que pulse, se cargaran los productos de dicha empresa en una tabla, esto es mediante un <form> que contiene la info de la empresa, y al hacer click, carga el Servlet llamado “VisualizacionProductosInvitado” que, dependiendo del valor de ID que se le pase, cargara la lista de productos solicitada.
 ![84](/READMEIMG/84.png?raw=true "Title")


Cuando se carga el Servlet este lo unico que hace es conseguir la lista de los productos de la empresa y enviarselo como parametro al JSP llamado “invVin”
 ![85](/READMEIMG/85.png?raw=true "Title")


El JSP lo que hace es cargar los datos correpondientes a la empresa solicitada y, por medio de una tabla, Listar todos los productos disponibles por parte de esa empresa 
  ![86](/READMEIMG/86.png?raw=true "Title")
  ![87](/READMEIMG/87.png?raw=true "Title")


Interfaces. 
Por último, veremos cómo quedo el índex del programa, aquí es donde se muestra la casilla de inicio de sesión y también a las empresas existentes, si se hace entra a una de estas se iniciará sesión automáticamente como invitado y lo único que se podrá hacer es ver los productos disponibles y clasificarlos por categorías.
  ![88](/READMEIMG/88.png?raw=true "Title")

  ![89](/READMEIMG/89.png?raw=true "Title")


Estas 2 paginas de la tienda forman parte de la parte publica del programa. 
Ahora cuando el usuario inicia sesión con una correo y contraseña se carga la pagina correspondiente dependiendo de su rol:
Interfaz del Usuario: 
Al hacer click en “ver” cargan los datos del pedido.
    ![90](/READMEIMG/90.png?raw=true "Title")


Al hacer click en “ver” cargan los datos del pedido.
  ![91](/READMEIMG/91.png?raw=true "Title")


Esta es la interfaz donde el usuario puede crear pedidos:
 ![92](/READMEIMG/92.png?raw=true "Title")


Admin: 
Este puede registrar un nuevo producto:
![93](/READMEIMG/93.png?raw=true "Title")


Puede modificar los productos ya creados:
 ![94](/READMEIMG/94.png?raw=true "Title")

Y por último llevar un manejo de los pedidos realizados a la empresa:
  ![95](/READMEIMG/95.png?raw=true "Title")

  ![96](/READMEIMG/96.png?raw=true "Title")



La pagina cambia de estilo y datos dependiendo de la empresa a la que el usuario pertenezca:
![97](/READMEIMG/97.png?raw=true "Title")

Usuario de GitHub: FlorencioP
Repositorio de la Practica 2: FlorencioP/Pr-ctica-de-laboratorio-02-Servlets-JSP-y-JPA (github.com)



