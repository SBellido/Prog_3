package entregable_3;

import java.awt.*;
import java.util.*;
import java.util.List;

public class FindRoad implements Comparator<Road> {

	private final int MAXBALANCES = 2;
	private Graph<Integer> graph;
	private HashMap<Integer, City> cities;
    private HashMap<Integer, String> colors;
    private Road partialRoad;
    private Road bestRoad;
    private int countBalances;
    private Integer kmLast;
	public FindRoad() {}

	public FindRoad(Graph<Integer> graph, HashMap<Integer, City> cities) {
        this.graph = graph;
        this.cities = cities;
        this.colors = new HashMap<>();
		this.partialRoad = new Road();
		this.bestRoad = new Road();
		this.countBalances = 0;
		this.kmLast = 0;
	}


	@Override
	public int compare(Road road1, Road road2) {
		return Math.max(road1.getKms(), road2.getKms());
	}


	private void updateCountBalance(City origin) {
		if (isWeighsInOrigin(origin))
			this.countBalances++;
	}

	private void downgradeCountBalance() {
		if (this.countBalances > 0)
            this.countBalances--;
	}


	private boolean isWeighsInOrigin(City origin) {
		return origin.isThereBalance();
	}


	public void findRoad(City origin, Integer destinationId, Integer kmActual) {
		List<City> auxCities = new ArrayList<>();
		Iterator<Integer> itVertex = this.graph.getVertex();

		while (itVertex.hasNext()) {
			Integer vertexIdActual = itVertex.next();
			colors.put(vertexIdActual, "white");
		}
		this.getRoad_visit(origin, destinationId, kmActual, auxCities);

	}


	/*private void getRoad_visit(City origin, Integer destinationId, int kmActual, List<City> auxCities) {
		auxCities.add(origin); // AGREGA ORIGEN ACTUAL A LISTA AUXILIAR DE CIUDADES
		Integer originId = origin.getId(); // OBTIENE SU ID
		System.out.println("Km actualizado: "+kmActual);
		this.partialRoad.setKms(kmActual); // SETEA CANTIDAD DE KM RECORRIDOS AL CAMINO PARCIAL
		int bestKm = this.compare(this.bestRoad, this.partialRoad); // COMPARA EL LARGO DEL CAMINO PARCIAL, CON EL MEJOR ACTUAL Y GUARDA EL MEJOR
		this.colors.put(originId, "yellow"); // ACTUALIZA REGISTRO DE VISITA

		if (originId.equals(destinationId)) { // EVALÚA SI LLEGÓ A DESTINO FINAL
			System.out.println("Km actual: " + bestKm);
			this.bestRoad.setKms(bestKm); // SETEA KMs DEL MEJOR CAMINO ACTUAL
			this.bestRoad.addAllCities(auxCities); // AGREGA TODAS LAS CIUDADES VISITADAS AL MEJOR CAMINO ACTUAL
		} else {

			Iterator<Integer> itIdDestination = this.graph.getAdyacent(originId); // OBTIENE IDs ADYACENTES AL ORIGEN
            while (itIdDestination.hasNext())  { // ITERA MIENTRAS HAYA UN PRÓXIMO
                Integer nextId = itIdDestination.next(); // OBTIENE ID DE UNO DE LOS DESTINOS POSIBLES
				Arc<Integer> arc = this.graph.getArc(originId, nextId); // OBTIENE EL ARCO ENTRE ORIGEN ACTUAL Y DESTINO ACTUAL
				City nextCity = this.cities.get(nextId); // CREA UNA CIUDAD TEMPORAL A PARTIR DEL ID OBTENIDO
				String actualDestination = this.colors.get(nextId);  // OBTIENE EL REGISTRO DE COLOR DE ESA CIUDAD
				System.out.println("Ciudad actual: "+nextCity);

				if (actualDestination.equals("white") && this.isBalanceOk()) { // EVALÚA SI AÚN NO REGISTRA VISITA Y LAS BALANZAS ESTÁN OK
					System.out.println("balanzas: "+this.countBalances);
					this.updateCountBalance(nextCity); // ACTUALIZA CONTEO DE BALANZAS
					System.out.println("Km : "+kmActual);
					kmActual += arc.getHashtag(); // ACTUALIZA KM RECORRIDOS

					this.getRoad_visit(nextCity, destinationId, kmActual, auxCities); // LLAMA RECURSIVAMENTE CON PARÁMETROS ACTUALIZADOS
					kmActual -= arc.getHashtag(); // restar kms

				}


			}
		}
		this.downgradeCountBalance(); // RESTA UNA BALANZA
		System.out.println("balanzas actualizadas: "+this.countBalances);
		auxCities.remove(origin); // ELIMINA CIUDADES
		this.colors.put(originId, "white"); // HABILITA PARA VOLVER A VISITAR ESA CIUDAD

	}*/

	private void getRoad_visit(City origin, Integer destinationId, int kmActual, List<City> auxCities) {
		System.out.println("Ciudad origen: "+origin);
		System.out.println("Km actualizado: "+kmActual);

		auxCities.add(origin); // AGREGA ORIGEN ACTUAL A LISTA AUXILIAR DE CIUDADES
		Integer originId = origin.getId(); // OBTIENE SU ID
		this.partialRoad.setKms(kmActual); // SETEA CANTIDAD DE KM RECORRIDOS AL CAMINO PARCIAL
		int bestKm = this.compare(this.bestRoad, this.partialRoad); // COMPARA EL LARGO DEL CAMINO PARCIAL, CON EL MEJOR ACTUAL Y GUARDA EL MEJOR
		this.colors.put(originId, "yellow"); // ACTUALIZA REGISTRO DE VISITA

		if (originId.equals(destinationId)) { // EVALÚA SI LLEGÓ A DESTINO FINAL
			System.out.println("Km en destino final: " + bestKm);
			this.bestRoad.setKms(bestKm); // SETEA KMs DEL MEJOR CAMINO ACTUAL
			this.bestRoad.addAllCities(auxCities); // AGREGA TODAS LAS CIUDADES VISITADAS AL MEJOR CAMINO ACTUAL
		} else {

			Iterator<Integer> itIdDestination = this.graph.getAdyacent(originId); // OBTIENE IDs ADYACENTES AL ORIGEN
			while (itIdDestination.hasNext())  { // ITERA MIENTRAS HAYA UN PRÓXIMO
				Integer nextId = itIdDestination.next(); // OBTIENE ID DE UNO DE LOS DESTINOS POSIBLES
				City nextCity = this.cities.get(nextId); // CREA UNA CIUDAD TEMPORAL A PARTIR DEL ID OBTENIDO
                String actualDestination = this.colors.get(nextId);  // OBTIENE EL REGISTRO DE COLOR DE ESA CIUDAD

                if (actualDestination.equals("white") && this.isBalanceOk()) { // EVALÚA SI AÚN NO REGISTRA VISITA Y LAS BALANZAS ESTÁN OK
                    Arc<Integer> arc = this.graph.getArc(originId, nextId);// OBTIENE EL ARCO ENTRE ORIGEN ACTUAL Y DESTINO ACTUAL
                    this.setKmLast(arc.getHashtag());
                    this.updateCountBalance(nextCity); // ACTUALIZA CONTEO DE BALANZAS
                    kmActual += arc.getHashtag(); // ACTUALIZA KM RECORRIDOS
                    this.partialRoad.setKmsPartial(kmActual);
                    System.out.println("Ciudad próxima: "+nextCity);
                    System.out.println("balanzas contadas: "+this.countBalances);
                    System.out.println("Km contados: "+kmActual);
                    this.getRoad_visit(nextCity, destinationId, kmActual, auxCities); // LLAMA RECURSIVAMENTE CON PARÁMETROS ACTUALIZADOS
				}
                //auxCities.remove(nextCity);
				//auxCities.clear();
				kmActual = this.partialRoad.getKms();
                System.out.println("ya visitó, acá se corta. \nkm actual: " + kmActual + " " +this.partialRoad.getKms());
            }
            this.partialRoad.setKms(this.partialRoad.getKmsPartial() - this.getKmLast());
            //kmActual = this.partialRoad.getKms();
            System.out.println("Actualiza km " + "\nkm parcial: "+ this.partialRoad.getKms()  +"\nÚltimo km: " +this.getKmLast());

            this.downgradeCountBalance(); // RESTA UNA BALANZA
            System.out.println("balanzas actualizadas: "+this.countBalances);
            auxCities.remove(origin);// ELIMINA CIUDAD
            System.out.println("Ciudad eliminada: "+origin);
        }


        this.colors.put(originId, "white"); // HABILITA PARA VOLVER A VISITAR ESA CIUDAD

	}


	private boolean isBalanceOk() {
		return this.countBalances < MAXBALANCES;
	}

	public Road getBestRoad() {
		return this.bestRoad;
	}

	public void setBestRoad(Road bestRoad) {
		this.bestRoad = bestRoad;
	}

	public int getCountBalances() {
		return countBalances;
	}

	public void setCountBalances(Integer countBalances) {
		this.countBalances = countBalances;
	}

    public Integer getKmLast() {
        return kmLast;
    }

    public void setKmLast(Integer kmLast) {
        this.kmLast = kmLast;
    }
}


//List<City> citiesVisit = new ArrayList<>();
//Iterator<City> itCity = citiesVisit.iterator();
//IteratorCity<Integer> itIdCity = new IteratorCity<>(itCity);
//grafo dame todos los arcos

