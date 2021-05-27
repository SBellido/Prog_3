package entregable_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Road implements Comparator {
    private List<City> cities = new ArrayList<City>();
    private Integer kms;

    public Road(List<City> cities, Integer kms) {
        this.cities = cities;
        this.kms = kms;
    }

    public Road() {
        this.kms = 0;
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
    public City getCityFromId(Integer id) {
        for (City city : this.cities)
            if (city.getId().equals(id))
                return city;
        return null;
    }

    public Integer getKms() {
        return kms;
    }


    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public String toString() {
        return "\nCamino: " +
                "\nCiudades: " + cities +
                "\nkms Totales: " + kms;
    }
}
