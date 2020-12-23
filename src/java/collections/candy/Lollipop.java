package collections.main_task.candy;

import collections.main_task.enums.Flavor;
import collections.main_task.enums.Producer;

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
}
