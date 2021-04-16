package entregable_1;

import java.util.Iterator;

public class Resolution {
    private SimpleLinkedList list;
    private Integer sum;

    public Resolution() {
        this.list = new SimpleLinkedList();
        this.sum = 0;
    }

    public SimpleLinkedList getSolution(SimpleLinkedList entryList, Integer threshold) {

        SimpleLinkedList resultList = new SimpleLinkedList();
        MyIterator it = (MyIterator) entryList.iterator();
        Integer result = 0;

        while (it.hasNext()) {
            Integer value =  it.getValue();

            if ((this.sum + value <= threshold)) {
              result = this.sumSecuence(value);
              it.move();

                if (!it.hasNext() ||
                        result == threshold ||
                        (result + it.getValue() > threshold)) {
                    resultList.insertFront(result);
                    System.out.println(result);
                    this.sum -= this.sum;
                }
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
