
Orden de ejecucion para abrir la caja
Nivel1
Nivel1?password=abc
Nivel2
Nivel2?nums=11
Nivel2?nums=22
Nivel2?nums=33
Nivel3
Nivel3?pwd=12ab
Cualquier otro orden o parametro, eliminara la sesion teniendo que empezar de nuevo por el Nivel1.
La entrada sin parametros a los niveles se podria eliminar pero es mas amigable para saber en que nivel se esta y que debe introducir.
Al no tener ninguna funcion abrir la caja decidi que todo lo pintado para el cliente se vea en vista.jsp.
Sin embargos los errores llevaran a vista-errores.jsp (aunque la podria haber juntado en vista.jsp).
Creo que el codigo y funcionamiento quedaria mas limpio cerrando la session en vista-errores.jsp pero se juntaria la vista con scripties.


