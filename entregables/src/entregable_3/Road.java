package entregable_3;

import java.util.List;

public class Road {
    private List cities;
    private Integer kms;

    public Road(List cities, Integer kms) {
        this.cities = cities;
        this.kms = kms;
    }


    public void setKms(Integer kms) {
        this.kms = kms;
    }

    public Integer getKms() {
        return kms;
    }
}
