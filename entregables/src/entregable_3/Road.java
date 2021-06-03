package entregable_3;

import java.util.ArrayList;
import java.util.List;

public class Road {
    private List<City> cities = new ArrayList<City>();
    private Integer kms;
    private Integer kmsPartial;


    public Road(List<City> cities, Integer kms, Integer kmsPartial) {
        this.cities = cities;
        this.kms = kms;
        this.kmsPartial = kmsPartial;
    }

    public Road() {
        this.kms = 0;
        this.kmsPartial = 0;
    }

    public void addCity(City city) {
        this.cities.add(city);
    }

    public void setKms(Integer kms) {
        this.kms = kms;
    }

    public List<City> getListCities() {
        return new ArrayList<>(this.cities);
    }

    public void deleteCity(City cityToDelete) {
        for (City city : this.cities)
            if (city.getId().equals(cityToDelete.getId()))
                this.cities.remove(cityToDelete);
    }

    public void addAllCities(List<City> cities) {
        this.cities.clear();
        this.cities.addAll(cities);
    }

    public City getCityFromId(Integer cityId) {
        for (City city : this.cities)
            if (city.getId().equals(cityId))
                return city;
        return null;
    }

    @Override
    public String toString() {
        return "\nEL CAMINO POSIBLE MÁS CORTO: " +
                "\nCiudades: " + this.cities +
                "\nkms Totales: " + this.getKms() +
                "\n-------------------------------- fin";
    }


    // GETERS & SETTERS
    public Integer getKms() {
        return this.kms;
    }

    public void setKmsTotal(Integer kms) {
        this.kms = kms;
    }

    public void setKmsPartial(Integer kmsPartial) {
        this.kmsPartial = kmsPartial;
    }

    public Integer getKmsTotal() {
        return this.kms;
    }

    public Integer getKmsPartial() {
        return kmsPartial;
    }


}
