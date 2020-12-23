package collections.candy;

import collections.enums.Producer;

public abstract class Candy {
    /**
     * Class Candy with parameters <b>name</b>, <b>sugarContent</b>, <b>weight</b>, <b>producer</b>
     * @author Rysard Poplavskij
     */
    String name;
    double sugarContent;
    double weight;
    Producer producer;

    public Candy() {
    }

    public Candy(String name, double sugarContent, double weight, Producer producer) {
        this.name = name;
        this.sugarContent = sugarContent;
        this.weight = weight;
        this.producer = producer;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    public void setSugarContent(double sugarContent) {
        this.sugarContent = (sugarContent > 0) ? sugarContent : 0;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = (weight > 0) ? weight : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candy candy = (Candy) o;

        if (Double.compare(candy.sugarContent, sugarContent) != 0) return false;
        if (Double.compare(candy.weight, weight) != 0) return false;
        if (name != null ? !name.equals(candy.name) : candy.name != null) return false;
        return producer != null ? producer.equals(candy.producer) : candy.producer == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(sugarContent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", sugarContent=" + sugarContent +
                ", weight=" + weight +
                ", producer='" + producer + '\'' +
                '}';
    }
}
