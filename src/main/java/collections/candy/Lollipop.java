package collections.candy;

import collections.enums.Flavor;
import collections.enums.Producer;

/**
 * Class Lollipop parameters <b>lollipopFlavor</b>
 * @author Rysard Poplavskij
 */
public class Lollipop extends Candy {
    private Flavor lollipopFlavor;

    public Lollipop(String name, double sugarContent, double weight, Producer producer, Flavor lollipopFlavor) {
        super(name, sugarContent, weight, producer);
        this.lollipopFlavor = lollipopFlavor;
    }

    public Flavor getLollipopFlavor() {
        return lollipopFlavor;
    }

    public void setLollipopFlavor(Flavor lollipopFlavor) {
        this.lollipopFlavor = lollipopFlavor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Lollipop lollipop = (Lollipop) o;

        return lollipopFlavor == lollipop.lollipopFlavor;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (lollipopFlavor != null ? lollipopFlavor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lollipop{" +
                "lollipopFlavor=" + lollipopFlavor +
                '}';
    }
}
