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

//		System.setProperty("spring.devtools.restart.enabled", "false");
		Map map = new Map();


		City ayacucho = new City(1, "Ayacucho");
		ayacucho.setServicesStation(1);
		ayacucho.setIsThereBalance(false);
		ayacucho.setThereRadar(false);
		ayacucho.setRepearCar(2);

		City azul = new City(2, "Azul");
		azul.setServicesStation(4);
		azul.setIsThereBalance(false);
		azul.setThereRadar(true);
		azul.setRepearCar(4);

		City bolivar = new City(3, "Bolívar");
		bolivar.setServicesStation(7);
		bolivar.setIsThereBalance(false);
		bolivar.setThereRadar(false);
		bolivar.setRepearCar(4);

		City marDelPlata = new City(4, "Mar del Plata");
		marDelPlata.setServicesStation(15);
		marDelPlata.setIsThereBalance(true);
		marDelPlata.setThereRadar(false);
		marDelPlata.setRepearCar(12);

		City olavarria = new City(5, "Olavarría");
		olavarria.setServicesStation(9);
		olavarria.setIsThereBalance(true);
		olavarria.setThereRadar(false);
		olavarria.setRepearCar(17);

		City pehuajo = new City(6, "Pehuajó");
		pehuajo.setServicesStation(3);
		pehuajo.setIsThereBalance(true);
		pehuajo.setThereRadar(true);
		pehuajo.setRepearCar(5);

		City rauch = new City(7, "Rauch");
		rauch.setServicesStation(1);
		rauch.setIsThereBalance(false);
		rauch.setThereRadar(true);
		rauch.setRepearCar(5);

		City tandil = new City(8, "Tandil");
		tandil.setServicesStation(6);
		tandil.setIsThereBalance(true);
		tandil.setThereRadar(true);
		tandil.setRepearCar(5);

		map.addCity(ayacucho);
		map.addCity(azul);
		map.addCity(bolivar);
		map.addCity(marDelPlata);
		map.addCity(olavarria);
		map.addCity(pehuajo);
		map.addCity(rauch);
		map.addCity(tandil);

		map.addRoad(ayacucho,pehuajo, 540);
		map.addRoad(ayacucho,tandil, 70);
		map.addRoad(ayacucho,rauch, 50);
		map.addRoad(azul, bolivar,100);
		map.addRoad(bolivar, olavarria,140);
		map.addRoad(bolivar, pehuajo,70);
		map.addRoad(marDelPlata, tandil,200);
		map.addRoad(olavarria, rauch,210);
		map.addRoad(olavarria, tandil,130);
		map.addRoad(rauch, tandil,60);



		System.out.println(map.getBestRoad(marDelPlata, ayacucho));

	}

}
