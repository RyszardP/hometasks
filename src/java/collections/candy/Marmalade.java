package collections.main_task.candy;

import collections.main_task.enums.Flavor;
import collections.main_task.enums.Producer;

public class Marmalade  extends Candy{
    private Flavor marmaladeFlavor;

    public Marmalade(String name, double sugarContent, double weight, Producer producer, Flavor marmaladeFlavor) {
        super(name, sugarContent, weight, producer);
        this.marmaladeFlavor = marmaladeFlavor;
    }

    public Flavor getMarmaladeFlavor() {
        return marmaladeFlavor;
    }

    public void setMarmaladeFlavor(Flavor marmaladeFlavor) {
        this.marmaladeFlavor = marmaladeFlavor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Marmalade marmalade = (Marmalade) o;

        return marmaladeFlavor == marmalade.marmaladeFlavor;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (marmaladeFlavor != null ? marmaladeFlavor.hashCode() : 0);
        return result;
    }
}
