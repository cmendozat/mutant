Código Fuente (Para Nivel 2 y 3: En repositorio github).

Instrucciones de cómo ejecutar el programa o la API. (Para Nivel 2 y 3: En README de
github).

API /mutant/

Para ejecutar la api, se debe realizar por medio de una herramienta que permita realizar peticiones http post.

Ejemplo.

Para el ejemplo se utilizo postman y se envía por el body de la petición, el array del dna.
Ejemplo del json:
{
    "dna":["ATGC","AACT","AGCA","ATAG"]
}

API /stats

Sobre esta api se puede mostrar una pequeña estadística sobre los dna procesados por el servicio /mutant.
