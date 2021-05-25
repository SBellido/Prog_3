package entregable_3;

import java.util.ArrayList;
import java.util.List;

public class Road {
    private List<City> cities;
    private Integer kms;

    public Road(List<City> cities, Integer kms) {
        this.cities = cities;
        this.kms = kms;
    }

    public Road() {
    }

    public void addCity(City city) {
        this.cities.add(city);
    }

    public void setKms(Integer kms) {
        this.kms = kms;
    }


    public Integer getKms() {
        return kms;
    }


}
