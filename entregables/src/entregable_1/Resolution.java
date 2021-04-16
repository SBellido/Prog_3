package entregable_1;

import java.util.Iterator;

public class Resolution {
    private Integer sum;

    public Resolution() {
        this.sum = 0;
    }

    // La complejidad computacional de este método es O(n)
    // donde n es la cantidad de elementos que contiene la lista.
    public SimpleLinkedList getSolution(SimpleLinkedList entryList, Integer threshold) {
         SimpleLinkedList resultList = new SimpleLinkedList();

        MyIterator it = entryList.iterator();
        Integer result = 0;

        while (it.hasNext()) {
            Integer value =  it.getValue();

            if ((this.sum + value <= threshold)) {
                result = this.sumSecuence(value);
                it.move();
                entryList.extractFront();

                if (!it.hasNext() ||
                        result == threshold ||
                        (result + it.getValue() > threshold)) {
                    resultList.insertLast(result);
                    this.sum -= this.sum;
                }
            } else {
                it.move();
                entryList.extractFront();
                this.sum -= this.sum;
            }
        }

        return resultList;
    }

    public Integer sumSecuence(Integer value) {
        return this.sum += value;
    }

    public Integer sumSecuence() {
        Integer sum = 0;
        return sum;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }


}
