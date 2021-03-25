exam-mercadolibre

Código Fuente (Para Nivel 2 y 3: En repositorio github).

En el siguiente link, se encuentra el código fuente desarrollado para el examen:
https://github.com/cmendozat/exam-mercadolibre/tree/master

Instrucciones de cómo ejecutar el programa o la API. (Para Nivel 2 y 3: En README de
github).

API /mutant/

Para ejecutar la api, se debe realizar por medio de una herramienta que permita realizar peticiones http post.

Ejemplo.

Para el ejemplo se utilizo postman. Se realiza una peticion post a la siguiente url, http://exammercadolibre-env.eba-dh9e9a8d.us-east-2.elasticbeanstalk.com/mutant/

Y se envía por el body de la petición, el array del dna.
Ejemplo del json:
{
    "dna":["ATGC","AACT","AGCA","ATAG"]
}

API /stats

Sobre esta api se puede mostrar una pequeña estadística sobre los dna procesados por el servicio /mutant.  Podemos acceder por medio de un navegador web colocando la siguiente url: http://exammercadolibre-env.eba-dh9e9a8d.us-east-2.elasticbeanstalk.com/stats

