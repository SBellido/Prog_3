package entregable_3;

public class City {

	private int id;
	private String name;
	private int servicesStation;
	private boolean thereBalance;
	private boolean thereRadar;
	private int repearCar;

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

	public void setIsThereBalance(boolean thereBalance) {
		this.thereBalance = thereBalance;
	}

	public int getServicesStation() {
		return this.servicesStation;
	}

	public void setServicesStation(int servicesStation) {
		this.servicesStation = servicesStation;
	}

	public boolean isThereRadar() {
		return this.thereRadar;
	}

	public void setThereRadar(boolean thereRadar) {
		this.thereRadar = thereRadar;
	}

	public int getRepearCar() {
		return this.repearCar;
	}

	public void setRepearCar(int repearCar) {
		this.repearCar = repearCar;
	}

	public int getId() {
		return this.id;
	}

}
