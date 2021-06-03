package entregable_3;

import java.awt.*;
import java.util.*;
import java.util.List;

public class FindRoad {

	private final int MAXBALANCES = 2;
	private Graph<Integer> graph;
	private HashMap<Integer, City> cities;
    private HashMap<Integer, String> colors;
    private Road partialRoad;
    private Road bestRoad;
    private int countBalances;
	public FindRoad() {}

	public FindRoad(Graph<Integer> graph, HashMap<Integer, City> cities) {
        this.graph = graph;
        this.cities = cities;
        this.colors = new HashMap<>();
		this.partialRoad = new Road();
		this.bestRoad = new Road();
		this.countBalances = 0;
	}


	private void updateCountBalance(City origin) {
		if (isWeighsInOrigin(origin))
			this.countBalances++;
	}

	private void downgradeCountBalance(City origin) {
		if (isWeighsInOrigin(origin))
				this.countBalances--;
	}

	private boolean isParcialRoadSmaller() {
		return this.partialRoad.getKmsPartial() < this.bestRoad.getKms();
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

	private void getRoad_visit(City origin, Integer destinationId, int kmActual, List<City> auxCities) {
        Integer originId = origin.getId(); // OBTIENE ID DE CIUDAD ORIGEN
        auxCities.add(origin); // AGREGA ORIGEN ACTUAL A LISTA AUXILIAR DE CIUDADES
		this.partialRoad.setKms(kmActual); // SETEA CANTIDAD DE KM RECORRIDOS AL CAMINO PARCIAL
		this.colors.put(originId, "yellow"); // ACTUALIZA REGISTRO DE VISITA

		if (originId.equals(destinationId)) { // EVALÚA SI LLEGÓ A DESTINO FINAL
			if (this.isParcialRoadSmaller() || this.bestRoad.getKms() == 0) { // EVALÚA SI EL CAMINO PARCIAL ES MÁS CORTO QUE EL MEJOR ACTUAL
				this.bestRoad.addAllCities(auxCities); // AGREGA TODAS LAS CIUDADES VISITADAS AL MEJOR CAMINO ACTUAL
				this.bestRoad.setKms(this.partialRoad.getKmsPartial()); // SETTEA LOS KM DEL MEJOR CAMINO CON EL VALOR DEL CAMINO PARCIAL
			}
		} else {

			Iterator<Integer> itIdDestination = this.graph.getAdyacent(originId); // OBTIENE IDs ADYACENTES AL ORIGEN
			while (itIdDestination.hasNext())  { // ITERA MIENTRAS HAYA UN PRÓXIMO
				Integer nextId = itIdDestination.next(); // OBTIENE ID DE UNO DE LOS DESTINOS POSIBLES
				City nextCity = this.cities.get(nextId); // CREA UNA CIUDAD TEMPORAL A PARTIR DEL ID OBTENIDO
                String actualDestination = this.colors.get(nextId);  // OBTIENE EL REGISTRO DE COLOR DE ESA CIUDAD

                if (actualDestination.equals("white") && this.isBalanceOk()) { // EVALÚA SI AÚN NO REGISTRA VISITA Y LAS BALANZAS ESTÁN OK
                    Arc<Integer> arc = this.graph.getArc(originId, nextId);// OBTIENE EL ARCO ENTRE ORIGEN ACTUAL Y DESTINO ACTUAL
                    this.updateCountBalance(nextCity); // ACTUALIZA CONTEO DE BALANZAS
                    kmActual += arc.getHashtag(); // ACTUALIZA KM RECORRIDOS
                    this.partialRoad.setKmsPartial(kmActual); // SETEA KM ACTUAL CON EL VALOR ACTUALIZADO
                    this.getRoad_visit(nextCity, destinationId, kmActual, auxCities); // LLAMA RECURSIVAMENTE CON PARÁMETROS ACTUALIZADOS

					kmActual -= arc.getHashtag(); // RESTA LOS KM
					this.partialRoad.setKmsPartial(kmActual); // SETTEA KM CON EL VALOR ACTUALIZADO
					this.downgradeCountBalance(nextCity); // RESTA UNA BALANZA LA LA ÚLTIMA CIUDAD TENÍA BASLANZA
				}
            }
		}
		auxCities.remove(origin);// ELIMINA CIUDAD DEL CAMINO PARCIAL
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

}
