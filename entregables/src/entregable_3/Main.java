/*
Entregable TP3
Utilizando su propia implementación de Grafo desarrollado en este práctico, resuelva el siguiente problema:

Una empresa de transporte desea encontrar el camino más corto por la cual los camiones tienen que
viajar de una ciudad a otra. Para esto, la empresa cuenta con un mapa con información de las ciudades
y las rutas/caminos que conectan las distintas ciudades.

Para cada ciudad la empresa tiene registrada:
La cantidad de estaciones de servicio que hay en la ciudad
Si la ciudad posee balanza para realizar pesaje de camiones
Si existen radares de velocidad en las cercanías de la ciudad
La cantidad de talleres mecánicos en la ciudad
Por cada ruta la empresa tiene registrado:
El par de ciudades que conecta
La cantidad de kilómetros de la ruta
Se debe utilizar el grafo implementado para representar la red de conexiones entre
las distintas ciudades del mapa. A continuación se muestra un ejemplo:

A partir de esta información, la empresa desea que le brindemos el camino más corto
entre un par de ciudades dado. La distancia de un camino se calcula según la cantidad d
e kilómetros recorridos. Por ejemplo, para ir desde Azul a Ayacucho, la ruta más corta es:
[Azul, Bolivar, Olavarría, Tandil, Ayacucho] con un total de 440 km de distancia a recorrer.

Sin embargo, la empresa nos hace saber que los controles de pesaje conllevan mucho tiempo,
e introducen mucha demora en los viajes, por lo que se desea que el viaje planificado atraviese,
como máximo, por una única ciudad con balanza para pesaje. En este punto,
dado que Olavarría y Tandil cuentan ambas con balanza de pesaje,
nos indican que el camino [Azul, Bolivar, Olavarría, Tandil, Ayacucho] no es aceptable.

Se debe proveer un servicio que, a partir de dos ciudades de origen y destino,
 calcule el camino más corto que atraviese como máximo una única ciudad con balanza de pesaje.
 La salida del servicio debe incluir la lista de ciudades en el orden que se las debe recorrer,
 junto con la cantidad total de kilómetros por recorrer.

La entrega de este trabajo debe contener:

Todo el codigo necesario para ejecutar, es decir, no solo el código de la funcion solicitada,
sino también el código correspondiente al grafo (mínimamente con los métodos propuestos
en el esqueleto) y cualquier estructura auxiliar necesaria.
El código debe contener comentarios que indiquen la complejidad de la función desarrollada
y de los distintos métodos de la lista (recuerden siempre indicar que es N)
Se debe proveer un main en el que se instancien las rutas y las ciudades indicadas en este ejemplo,
y que solicite e imprima el resultado de ejecutar el servicio solicitado con las siguientes ciudades,
considerando las operaciones entre los distintos llamados:
origen: Azul - destino: Ayacucho
origen: Rauch - destino: Mar del plata
origen: Mar del plata - destino: Pehuajo
eliminar la ciudad Ayacucho.
eliminar la ruta Tandil - Rauch
origen: Mar del plata - destino Pehuajo
 */

package entregable_3;

public class Main {

	public static void main(String[] args) {
		

		City ayacucho = new City(1,"Ayacucho");
		City tandil = new City(2,"Tandil");
		City bolivar = new City(3,"Bolivar");
		
		Map mapa = new Map();
		
		mapa.addCity(ayacucho); // Agrego ayacucho
		mapa.addCity(tandil); // Agrego tandil
		mapa.addCity(bolivar); // Agrego bolivar
		
		mapa.addRoute(ayacucho, tandil, 70); // Agrego la ruta entre ayacucho-tandil de 70km
		
		
//		mapa.encontrarCamino(ayacucho, bolivar); // Busco el mejor camino entre ayacucho y bolivar
		
		mapa.deleteCity(ayacucho); // Borro la ciudad ayacucho
//		mapa.borrarRuta(ayacucho, tandil); // Borro la ruta entre ayacucho-tandil


		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		DirecterGraph<Float> grafito = new DirecterGraph<>();

		// Agrego los vertices 1 y 2
//		grafito.agregarVertice(1);
//		grafito.agregarVertice(2);

		// Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
//		grafito.agregarArco(1, 2, 3F);

		// Obtengo el arco entre 1 y 2, y le pido la etiqueta
//		Float etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();

//		System.out.println(etiqueta); // Deber�a imprimir 3

	}

}
