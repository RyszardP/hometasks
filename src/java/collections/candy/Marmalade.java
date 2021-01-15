package collections.candy;

import collections.enums.Flavor;
import collections.enums.Producer;

/**
 * Class  Marmalade parameters <b>marmaladeFlavor</b>
 * @author Rysard Poplavskij
 */
public class Marmalade  extends Candy{
    private Flavor marmaladeFlavor;
    private int countInPack;

    public Marmalade(String name, double sugarContent, double weight, Producer producer, Flavor marmaladeFlavor, int countInPack) {
        super(name, sugarContent, weight, producer);
        this.marmaladeFlavor = marmaladeFlavor;
        this.countInPack = countInPack;
    }

    public Flavor getMarmaladeFlavor() {
        return marmaladeFlavor;
    }

    public void setMarmaladeFlavor(Flavor marmaladeFlavor) {
        this.marmaladeFlavor = marmaladeFlavor;
    }

    public int getCountInPack() {
        return countInPack;
    }

    public void setCountInPack(int countInPack) {
        this.countInPack = countInPack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Marmalade marmalade = (Marmalade) o;

        if (countInPack != marmalade.countInPack) return false;
        return marmaladeFlavor == marmalade.marmaladeFlavor;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (marmaladeFlavor != null ? marmaladeFlavor.hashCode() : 0);
        result = 31 * result + countInPack;
        return result;
    }

    @Override
    public String toString() {
        return "Marmalade{" +
                "marmaladeFlavor=" + marmaladeFlavor +
                ", countInPack=" + countInPack +
                '}';
    }
}
