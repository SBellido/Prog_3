package entregable_3;

public class City {

	private Integer id;
	private String name;
	private Integer servicesStation;
	private boolean thereBalance;
	private boolean thereRadar;
	private Integer repearCar;

	public City(int id, String name) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public boolean isThereBalance() {
		return thereBalance;
	}

	public Integer getServicesStation() {
		return this.servicesStation;
	}

	public Integer getRepearCar() {
		return this.repearCar;
	}

	public Integer getId() {
		return this.id;
	}

	public boolean isThereRadar() {
		return this.thereRadar;
	}

	public void setServicesStation(int servicesStation) {
		this.servicesStation = servicesStation;
	}

	public void setIsThereBalance(boolean thereBalance) {
		this.thereBalance = thereBalance;
	}

	public void setThereRadar(boolean thereRadar) {
		this.thereRadar = thereRadar;
	}

	public void setRepearCar(int repearCar) {
		this.repearCar = repearCar;
	}

	@Override
	public String toString() {
		return "\n-----------------------------"+
				"\nDATOS DE CIUDAD: " +
				"\nid: " + id +
				"\nNombre: '" + name + '\'' +
				"\nEstaciones de servivio: " + servicesStation +
				"\nBalanzas: " + thereBalance +
				"\nRadar: " + thereRadar +
				"\nTalleres Mecánicos: " + repearCar + "\n";
	}
}
