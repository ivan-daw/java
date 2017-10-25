Ejercicio 2 - Caja de Seguridad - Anotaciones

Orden de ejecucion para abrir la caja
    /Nivel1?password=abc
    /Nivel2?nums=11
    /Nivel2?nums=22
    /Nivel2?nums=33
    /Nivel3?pwd=12ab

Cualquier otro orden o contraseña incorrecta, reseteara el atributo Nivel de la sesion teniendo que empezar de nuevo por el Nivel1 donde se invalidara la sesion.

Se podrian omitir elses con una redireccion por defecto a la pagina de error, pero los he dejado por si en algun momento se decide poner mensajes de error (ej: codigo 3010 para indicar contraseña incorrecta en el nivel 3) que no puse por salirse de lo pedido y hacer hincapie en que contra menos informacion mejor en una pagina de errores.

Se han hecho incluido cosas en el JSTL que podrian ir en otros sitios para trabajar con ello (set/out/if)
